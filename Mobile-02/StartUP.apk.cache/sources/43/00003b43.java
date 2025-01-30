package com.google.firebase.installations.r;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.j;
import com.google.firebase.FirebaseException;
import com.google.firebase.f.c;
import com.google.firebase.i.h;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.r.d;
import com.google.firebase.installations.r.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
public class c {
    private static final Pattern a = Pattern.compile("[0-9]+s");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f9256b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private final Context f9257c;

    /* renamed from: d  reason: collision with root package name */
    private final h f9258d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.f.c f9259e;

    public c(Context context, h hVar, com.google.firebase.f.c cVar) {
        this.f9257c = context;
        this.f9258d = hVar;
        this.f9259e = cVar;
    }

    private static JSONObject a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:16.2.2");
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:16.2.2");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private String f() {
        try {
            Context context = this.f9257c;
            byte[] a2 = com.google.android.gms.common.util.a.a(context, context.getPackageName());
            if (a2 == null) {
                Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f9257c.getPackageName());
                return null;
            }
            return j.b(a2, false);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("ContentValues", "No such package: " + this.f9257c.getPackageName(), e2);
            return null;
        }
    }

    private static byte[] g(JSONObject jSONObject) throws IOException {
        return jSONObject.toString().getBytes("UTF-8");
    }

    private static void h() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void i(HttpURLConnection httpURLConnection) {
        String m = m(httpURLConnection);
        if (TextUtils.isEmpty(m)) {
            return;
        }
        Log.w("Firebase-Installations", m);
    }

    private HttpURLConnection j(URL url, String str) throws IOException {
        c.a a2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        httpURLConnection.addRequestProperty(HttpHeaders.ACCEPT, "application/json");
        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.addRequestProperty("X-Android-Package", this.f9257c.getPackageName());
        com.google.firebase.f.c cVar = this.f9259e;
        if (cVar != null && this.f9258d != null && (a2 = cVar.a("fire-installations-id")) != c.a.NONE) {
            httpURLConnection.addRequestProperty("x-firebase-client", this.f9258d.a());
            httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(a2.h()));
        }
        httpURLConnection.addRequestProperty("X-Android-Cert", f());
        httpURLConnection.addRequestProperty("x-goog-api-key", str);
        return httpURLConnection;
    }

    static long k(String str) {
        t.b(a.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private d l(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f9256b));
        e.a a2 = e.a();
        d.a a3 = d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(ApiConstants.NAME)) {
                a3.f(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                a3.c(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                a3.d(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals(ApiConstants.TOKEN)) {
                        a2.c(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        a2.d(k(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                a3.b(a2.a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a3.e(d.b.OK).a();
    }

    private static String m(HttpURLConnection httpURLConnection) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f9256b));
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                String format = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return format;
            } catch (IOException unused2) {
                bufferedReader.close();
                return null;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        } catch (IOException unused4) {
            return null;
        }
    }

    private e n(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f9256b));
        e.a a2 = e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(ApiConstants.TOKEN)) {
                a2.c(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                a2.d(k(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return a2.b(e.b.OK).a();
    }

    private void o(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        q(httpURLConnection, g(a(str, str2)));
    }

    private void p(HttpURLConnection httpURLConnection) throws IOException {
        q(httpURLConnection, g(b()));
    }

    private static void q(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
                try {
                    return;
                } catch (IOException unused) {
                    return;
                }
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
    }

    public d c(String str, String str2, String str3, String str4, String str5) throws IOException {
        int i2 = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations", str3)));
        while (i2 <= 1) {
            HttpURLConnection j2 = j(url, str);
            try {
                j2.setRequestMethod(HttpPost.METHOD_NAME);
                j2.setDoOutput(true);
                if (str5 != null) {
                    j2.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                }
                o(j2, str2, str4);
                int responseCode = j2.getResponseCode();
                if (responseCode == 200) {
                    return l(j2);
                }
                i(j2);
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    h();
                    return d.a().e(d.b.BAD_CONFIG).a();
                }
                i2++;
            } finally {
                j2.disconnect();
            }
        }
        throw new IOException();
    }

    public void d(String str, String str2, String str3, String str4) throws FirebaseException, IOException {
        int i2 = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations/%s", str3, str2)));
        while (i2 <= 1) {
            HttpURLConnection j2 = j(url, str);
            try {
                j2.setRequestMethod(HttpDelete.METHOD_NAME);
                j2.addRequestProperty("Authorization", "FIS_v2 " + str4);
                int responseCode = j2.getResponseCode();
                if (responseCode != 200 && responseCode != 401 && responseCode != 404) {
                    i(j2);
                    if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                        h();
                        throw new FirebaseInstallationsException("Bad config while trying to delete FID", FirebaseInstallationsException.a.BAD_CONFIG);
                    }
                    i2++;
                }
                return;
            } finally {
                j2.disconnect();
            }
        }
        throw new IOException();
    }

    public e e(String str, String str2, String str3, String str4) throws IOException {
        int i2 = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations/%s/authTokens:generate", str3, str2)));
        while (i2 <= 1) {
            HttpURLConnection j2 = j(url, str);
            try {
                j2.setRequestMethod(HttpPost.METHOD_NAME);
                j2.addRequestProperty("Authorization", "FIS_v2 " + str4);
                p(j2);
                int responseCode = j2.getResponseCode();
                if (responseCode == 200) {
                    return n(j2);
                }
                i(j2);
                if (responseCode != 401 && responseCode != 404) {
                    if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                        h();
                        return e.a().b(e.b.BAD_CONFIG).a();
                    }
                    i2++;
                }
                return e.a().b(e.b.AUTH_ERROR).a();
            } finally {
                j2.disconnect();
            }
        }
        throw new IOException();
    }
}