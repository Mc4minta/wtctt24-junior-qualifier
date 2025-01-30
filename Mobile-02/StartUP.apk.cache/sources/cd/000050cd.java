package io.branch.referral;

import android.content.Context;
import android.net.TrafficStats;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UniversalResourceAnalyser.java */
/* loaded from: classes2.dex */
public class i0 {
    private static JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    private static i0 f16982b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<String> f16983c;

    /* renamed from: d  reason: collision with root package name */
    private final JSONObject f16984d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UniversalResourceAnalyser.java */
    /* loaded from: classes2.dex */
    public static class b extends c<Void, Void, JSONObject> {
        private final q a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16985b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public JSONObject doInBackground(Void... voidArr) {
            HttpsURLConnection httpsURLConnection;
            TrafficStats.setThreadStatsTag(0);
            JSONObject jSONObject = new JSONObject();
            HttpsURLConnection httpsURLConnection2 = null;
            try {
                httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://cdn.branch.io/sdk/uriskiplist_v#.json".replace("#", Integer.toString(i0.a.optInt(ClientCookie.VERSION_ATTR) + 1))).openConnection()));
            } catch (Throwable unused) {
            }
            try {
                httpsURLConnection.setConnectTimeout(1500);
                httpsURLConnection.setReadTimeout(1500);
                if (httpsURLConnection.getResponseCode() == 200 && httpsURLConnection.getInputStream() != null) {
                    jSONObject = new JSONObject(new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())).readLine());
                }
                httpsURLConnection.disconnect();
            } catch (Throwable unused2) {
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                return jSONObject;
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject.optInt(ClientCookie.VERSION_ATTR) > i0.a.optInt(ClientCookie.VERSION_ATTR)) {
                JSONObject unused = i0.a = jSONObject;
                this.a.A0("skip_url_format_key", i0.a.toString());
            }
        }

        private b(Context context) {
            this.f16985b = 1500;
            this.a = q.B(context);
        }
    }

    private i0(Context context) {
        JSONObject jSONObject = new JSONObject();
        this.f16984d = jSONObject;
        try {
            jSONObject.putOpt(ClientCookie.VERSION_ATTR, 0);
            JSONArray jSONArray = new JSONArray();
            jSONObject.putOpt("uri_skip_list", jSONArray);
            jSONArray.put("^fb\\d+:");
            jSONArray.put("^li\\d+:");
            jSONArray.put("^pdk\\d+:");
            jSONArray.put("^twitterkit-.*:");
            jSONArray.put("^com\\.googleusercontent\\.apps\\.\\d+-.*:\\/oauth");
            jSONArray.put("^(?i)(?!(http|https):).*(:|:.*\\b)(password|o?auth|o?auth.?token|access|access.?token)\\b");
            jSONArray.put("^(?i)((http|https):\\/\\/).*[\\/|?|#].*\\b(password|o?auth|o?auth.?token|access|access.?token)\\b");
        } catch (JSONException unused) {
        }
        a = f(context);
        this.f16983c = new ArrayList<>();
    }

    public static i0 d(Context context) {
        if (f16982b == null) {
            f16982b = new i0(context);
        }
        return f16982b;
    }

    private JSONObject f(Context context) {
        q B = q.B(context);
        JSONObject jSONObject = new JSONObject();
        String Q = B.Q("skip_url_format_key");
        if (!TextUtils.isEmpty(Q) && !"bnc_no_value".equals(Q)) {
            try {
                return new JSONObject(Q);
            } catch (JSONException unused) {
                return jSONObject;
            }
        }
        return this.f16984d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context) {
        try {
            new b(context).a(new Void[0]);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e(String str) {
        String str2;
        try {
            JSONArray optJSONArray = a.optJSONArray("uri_skip_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        str2 = optJSONArray.getString(i2);
                    } catch (JSONException unused) {
                    }
                    if (Pattern.compile(str2).matcher(str).find()) {
                        break;
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
                if (this.f16983c.size() <= 0) {
                    return str;
                }
                Iterator<String> it = this.f16983c.iterator();
                while (it.hasNext()) {
                    if (str.matches(it.next())) {
                        return str;
                    }
                }
            }
            return str2;
        } catch (Exception unused2) {
            return str;
        }
    }
}