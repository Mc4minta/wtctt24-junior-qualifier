package com.google.firebase.crashlytics.c.p.j;

import com.appsflyer.internal.referrer.Payload;
import com.google.firebase.crashlytics.c.g.h;
import com.google.firebase.crashlytics.c.g.k;
import com.google.firebase.crashlytics.c.p.i.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class c extends com.google.firebase.crashlytics.c.g.a implements d {

    /* renamed from: f  reason: collision with root package name */
    private com.google.firebase.crashlytics.c.b f9071f;

    public c(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar) {
        this(str, str2, cVar, com.google.firebase.crashlytics.c.k.a.GET, com.google.firebase.crashlytics.c.b.f());
    }

    private com.google.firebase.crashlytics.c.k.b g(com.google.firebase.crashlytics.c.k.b bVar, g gVar) {
        h(bVar, "X-CRASHLYTICS-GOOGLE-APP-ID", gVar.a);
        h(bVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        h(bVar, "X-CRASHLYTICS-API-CLIENT-VERSION", k.i());
        h(bVar, HttpHeaders.ACCEPT, "application/json");
        h(bVar, "X-CRASHLYTICS-DEVICE-MODEL", gVar.f9062b);
        h(bVar, "X-CRASHLYTICS-OS-BUILD-VERSION", gVar.f9063c);
        h(bVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", gVar.f9064d);
        h(bVar, "X-CRASHLYTICS-INSTALLATION-ID", gVar.f9065e.a());
        return bVar;
    }

    private void h(com.google.firebase.crashlytics.c.k.b bVar, String str, String str2) {
        if (str2 != null) {
            bVar.d(str, str2);
        }
    }

    private JSONObject i(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            com.google.firebase.crashlytics.c.b bVar = this.f9071f;
            bVar.c("Failed to parse settings JSON from " + e(), e2);
            com.google.firebase.crashlytics.c.b bVar2 = this.f9071f;
            bVar2.b("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> j(g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", gVar.f9068h);
        hashMap.put("display_version", gVar.f9067g);
        hashMap.put(Payload.SOURCE, Integer.toString(gVar.f9069i));
        String str = gVar.f9066f;
        if (!h.D(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    @Override // com.google.firebase.crashlytics.c.p.j.d
    public JSONObject a(g gVar, boolean z) {
        if (z) {
            try {
                Map<String, String> j2 = j(gVar);
                com.google.firebase.crashlytics.c.k.b g2 = g(d(j2), gVar);
                com.google.firebase.crashlytics.c.b bVar = this.f9071f;
                bVar.b("Requesting settings from " + e());
                com.google.firebase.crashlytics.c.b bVar2 = this.f9071f;
                bVar2.b("Settings query params were: " + j2);
                com.google.firebase.crashlytics.c.k.d b2 = g2.b();
                com.google.firebase.crashlytics.c.b bVar3 = this.f9071f;
                bVar3.b("Settings request ID: " + b2.d("X-REQUEST-ID"));
                return k(b2);
            } catch (IOException e2) {
                this.f9071f.e("Settings request failed.", e2);
                return null;
            }
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }

    JSONObject k(com.google.firebase.crashlytics.c.k.d dVar) {
        int b2 = dVar.b();
        com.google.firebase.crashlytics.c.b bVar = this.f9071f;
        bVar.b("Settings result was: " + b2);
        if (l(b2)) {
            return i(dVar.a());
        }
        com.google.firebase.crashlytics.c.b bVar2 = this.f9071f;
        bVar2.d("Failed to retrieve settings from " + e());
        return null;
    }

    boolean l(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 202 || i2 == 203;
    }

    c(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar, com.google.firebase.crashlytics.c.k.a aVar, com.google.firebase.crashlytics.c.b bVar) {
        super(str, str2, cVar, aVar);
        this.f9071f = bVar;
    }
}