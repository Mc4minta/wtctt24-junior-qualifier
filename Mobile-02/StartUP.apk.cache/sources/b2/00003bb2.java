package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import com.coinbase.ApiConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.f;
import com.google.firebase.remoteconfig.internal.j;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class ConfigFetchHttpClient {
    private static final Pattern a = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* renamed from: b  reason: collision with root package name */
    private final Context f9412b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9413c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9414d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9415e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9416f;

    /* renamed from: g  reason: collision with root package name */
    private final long f9417g;

    /* renamed from: h  reason: collision with root package name */
    private final long f9418h;

    public ConfigFetchHttpClient(Context context, String str, String str2, String str3, long j2, long j3) {
        this.f9412b = context;
        this.f9413c = str;
        this.f9414d = str2;
        this.f9415e = e(str);
        this.f9416f = str3;
        this.f9417g = j2;
        this.f9418h = j3;
    }

    private boolean a(JSONObject jSONObject) {
        try {
            return !jSONObject.get(ApiConstants.STATE).equals("NO_CHANGE");
        } catch (JSONException unused) {
            return true;
        }
    }

    private JSONObject b(String str, String str2, Map<String, String> map) throws FirebaseRemoteConfigClientException {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("appInstanceId", str);
            hashMap.put("appInstanceIdToken", str2);
            hashMap.put("appId", this.f9413c);
            Locale locale = this.f9412b.getResources().getConfiguration().locale;
            hashMap.put("countryCode", locale.getCountry());
            hashMap.put("languageCode", locale.toString());
            hashMap.put("platformVersion", Integer.toString(Build.VERSION.SDK_INT));
            hashMap.put("timeZone", TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = this.f9412b.getPackageManager().getPackageInfo(this.f9412b.getPackageName(), 0);
                if (packageInfo != null) {
                    hashMap.put("appVersion", packageInfo.versionName);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            hashMap.put("packageName", this.f9412b.getPackageName());
            hashMap.put("sdkVersion", "19.0.4");
            hashMap.put("analyticsUserProperties", new JSONObject(map));
            return new JSONObject(hashMap);
        }
        throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase instance id is null.");
    }

    private static f d(JSONObject jSONObject, Date date) throws FirebaseRemoteConfigClientException {
        JSONObject jSONObject2;
        try {
            f.b e2 = f.f().e(date);
            JSONArray jSONArray = null;
            try {
                jSONObject2 = jSONObject.getJSONObject("entries");
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                e2.c(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray("experimentDescriptions");
            } catch (JSONException unused2) {
            }
            if (jSONArray != null) {
                e2.d(jSONArray);
            }
            return e2.a();
        } catch (JSONException e3) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: fetch response could not be parsed.", e3);
        }
    }

    private static String e(String str) {
        Matcher matcher = a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private JSONObject f(URLConnection uRLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read != -1) {
                sb.append((char) read);
            } else {
                return new JSONObject(sb.toString());
            }
        }
    }

    private String g(String str, String str2) {
        return String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", str, str2);
    }

    private String h() {
        try {
            Context context = this.f9412b;
            byte[] a2 = com.google.android.gms.common.util.a.a(context, context.getPackageName());
            if (a2 == null) {
                Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f9412b.getPackageName());
                return null;
            }
            return com.google.android.gms.common.util.j.b(a2, false);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("FirebaseRemoteConfig", "No such package: " + this.f9412b.getPackageName(), e2);
            return null;
        }
    }

    private void i(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f9414d);
        httpURLConnection.setRequestProperty("X-Android-Package", this.f9412b.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", h());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
    }

    private void j(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private void k(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private void l(HttpURLConnection httpURLConnection, String str, Map<String, String> map) {
        httpURLConnection.setDoOutput(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(this.f9417g));
        httpURLConnection.setReadTimeout((int) timeUnit.toMillis(this.f9418h));
        httpURLConnection.setRequestProperty(HttpHeaders.IF_NONE_MATCH, str);
        i(httpURLConnection);
        j(httpURLConnection, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpURLConnection c() throws FirebaseRemoteConfigException {
        try {
            return (HttpURLConnection) new URL(g(this.f9415e, this.f9416f)).openConnection();
        } catch (IOException e2) {
            throw new FirebaseRemoteConfigException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Keep
    public j.a fetch(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2, Date date) throws FirebaseRemoteConfigException {
        l(httpURLConnection, str3, map2);
        try {
            try {
                k(httpURLConnection, b(str, str2, map).toString().getBytes("utf-8"));
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.ETAG);
                    JSONObject f2 = f(httpURLConnection);
                    try {
                        httpURLConnection.getInputStream().close();
                    } catch (IOException unused) {
                    }
                    if (!a(f2)) {
                        return j.a.a(date);
                    }
                    return j.a.b(d(f2, date), headerField);
                }
                throw new FirebaseRemoteConfigServerException(responseCode, httpURLConnection.getResponseMessage());
            } catch (IOException | JSONException e2) {
                throw new FirebaseRemoteConfigClientException("The client had an error while calling the backend!", e2);
            }
        } finally {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
            } catch (IOException unused2) {
            }
        }
    }
}