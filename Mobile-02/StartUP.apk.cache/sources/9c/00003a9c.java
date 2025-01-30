package com.google.firebase.crashlytics.c.p;

import com.google.firebase.crashlytics.c.g.p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class f {
    private final p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(p pVar) {
        this.a = pVar;
    }

    private static g a(int i2) {
        if (i2 != 3) {
            return new b();
        }
        return new h();
    }

    public com.google.firebase.crashlytics.c.p.i.f b(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.a, jSONObject);
    }
}