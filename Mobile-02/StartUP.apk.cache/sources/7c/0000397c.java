package com.google.firebase.crashlytics.c.f;

import android.os.Bundle;
import com.coinbase.ApiConstants;
import com.google.firebase.analytics.a.a;
import com.google.firebase.crashlytics.c.f.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class a implements a.b, b {
    private final com.google.firebase.analytics.a.a a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0164a f8660b;

    /* renamed from: c  reason: collision with root package name */
    private b.a f8661c;

    /* renamed from: d  reason: collision with root package name */
    private a.InterfaceC0162a f8662d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0164a {
        void a(String str);
    }

    public a(com.google.firebase.analytics.a.a aVar, InterfaceC0164a interfaceC0164a) {
        this.a = aVar;
        this.f8660b = interfaceC0164a;
    }

    private void d(String str, Bundle bundle) {
        try {
            this.f8660b.a("$A$:" + f(str, bundle));
        } catch (JSONException unused) {
            com.google.firebase.crashlytics.c.b.f().i("Unable to serialize Firebase Analytics event.");
        }
    }

    private void e(int i2, Bundle bundle) {
        b.a aVar = this.f8661c;
        if (aVar != null) {
            aVar.a(i2, bundle);
        }
    }

    private static String f(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(ApiConstants.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.c.f.b
    public void a(b.a aVar) {
        this.f8661c = aVar;
    }

    @Override // com.google.firebase.crashlytics.c.f.b
    public boolean b() {
        com.google.firebase.analytics.a.a aVar = this.a;
        if (aVar == null) {
            com.google.firebase.crashlytics.c.b.f().b("Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        a.InterfaceC0162a g2 = aVar.g("clx", this);
        this.f8662d = g2;
        if (g2 == null) {
            com.google.firebase.crashlytics.c.b.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            a.InterfaceC0162a g3 = this.a.g("crash", this);
            this.f8662d = g3;
            if (g3 != null) {
                com.google.firebase.crashlytics.c.b.f().i("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return this.f8662d != null;
    }

    @Override // com.google.firebase.analytics.a.a.b
    public void c(int i2, Bundle bundle) {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("AnalyticsConnectorReceiver received message: " + i2 + " " + bundle);
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if ("clx".equals(bundle2.getString("_o"))) {
            e(i2, bundle);
            return;
        }
        String string = bundle.getString(ApiConstants.NAME);
        if (string != null) {
            d(string, bundle2);
        }
    }
}