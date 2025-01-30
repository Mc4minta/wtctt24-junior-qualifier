package com.google.firebase.crashlytics.c.p;

import com.google.firebase.crashlytics.c.g.p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class b implements g {
    private static com.google.firebase.crashlytics.c.p.i.b b(JSONObject jSONObject) throws JSONException {
        return new com.google.firebase.crashlytics.c.p.i.b(jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false));
    }

    private static com.google.firebase.crashlytics.c.p.i.c c(JSONObject jSONObject) {
        return new com.google.firebase.crashlytics.c.p.i.c(jSONObject.optBoolean("collect_reports", true));
    }

    private static com.google.firebase.crashlytics.c.p.i.d d(JSONObject jSONObject) {
        return new com.google.firebase.crashlytics.c.p.i.d(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.firebase.crashlytics.c.p.i.e e(p pVar) {
        JSONObject jSONObject = new JSONObject();
        return new com.google.firebase.crashlytics.c.p.i.f(f(pVar, 3600L, jSONObject), null, d(jSONObject), c(jSONObject), 0, 3600);
    }

    private static long f(p pVar, long j2, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return pVar.a() + (j2 * 1000);
    }

    @Override // com.google.firebase.crashlytics.c.p.g
    public com.google.firebase.crashlytics.c.p.i.f a(p pVar, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new com.google.firebase.crashlytics.c.p.i.f(f(pVar, optInt2, jSONObject), b(jSONObject.getJSONObject("app")), d(jSONObject.getJSONObject("session")), c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}