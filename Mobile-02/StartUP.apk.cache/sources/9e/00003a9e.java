package com.google.firebase.crashlytics.c.p;

import com.google.firebase.crashlytics.c.g.p;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class h implements g {
    private static com.google.firebase.crashlytics.c.p.i.b b(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        String string = jSONObject2.getString("status");
        boolean equals = "new".equals(string);
        String string2 = jSONObject.getString("bundle_id");
        String string3 = jSONObject.getString("org_id");
        String format = equals ? "https://update.crashlytics.com/spi/v1/platforms/android/apps" : String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", string2);
        Locale locale = Locale.US;
        return new com.google.firebase.crashlytics.c.p.i.b(string, format, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject2.optBoolean("update_required", false), jSONObject2.optInt("report_upload_variant", 0), jSONObject2.optInt("native_report_upload_variant", 0));
    }

    private static com.google.firebase.crashlytics.c.p.i.c c(JSONObject jSONObject) {
        return new com.google.firebase.crashlytics.c.p.i.c(jSONObject.optBoolean("collect_reports", true));
    }

    private static com.google.firebase.crashlytics.c.p.i.d d() {
        return new com.google.firebase.crashlytics.c.p.i.d(8, 4);
    }

    private static long e(p pVar, long j2, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return pVar.a() + (j2 * 1000);
    }

    @Override // com.google.firebase.crashlytics.c.p.g
    public com.google.firebase.crashlytics.c.p.i.f a(p pVar, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new com.google.firebase.crashlytics.c.p.i.f(e(pVar, optInt2, jSONObject), b(jSONObject.getJSONObject("fabric"), jSONObject.getJSONObject("app")), d(), c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}