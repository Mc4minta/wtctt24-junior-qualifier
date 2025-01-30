package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import com.coinbase.ApiConstants;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
final class a0 {
    private static final long a = TimeUnit.DAYS.toMillis(7);

    /* renamed from: b  reason: collision with root package name */
    final String f9128b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9129c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9130d;

    private a0(String str, String str2, long j2) {
        this.f9128b = str;
        this.f9129c = str2;
        this.f9130d = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a0(jSONObject.getString(ApiConstants.TOKEN), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                sb.append("Failed to parse token: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }
        return new a0(str, null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        return a0Var.f9128b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str, String str2, long j2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ApiConstants.TOKEN, str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(String str) {
        return System.currentTimeMillis() > this.f9130d + a || !str.equals(this.f9129c);
    }
}