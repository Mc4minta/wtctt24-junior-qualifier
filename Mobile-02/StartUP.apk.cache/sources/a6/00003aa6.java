package com.google.firebase.crashlytics.c.p.j;

import com.google.firebase.crashlytics.c.g.b0;
import com.google.firebase.crashlytics.c.g.h;
import java.io.IOException;
import org.apache.http.client.methods.HttpPost;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
abstract class a extends com.google.firebase.crashlytics.c.g.a {

    /* renamed from: f  reason: collision with root package name */
    private final String f9070f;

    public a(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar, com.google.firebase.crashlytics.c.k.a aVar, String str3) {
        super(str, str2, cVar, aVar);
        this.f9070f = str3;
    }

    private com.google.firebase.crashlytics.c.k.b g(com.google.firebase.crashlytics.c.k.b bVar, com.google.firebase.crashlytics.c.p.i.a aVar) {
        return bVar.d("X-CRASHLYTICS-ORG-ID", aVar.a).d("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f9039b).d("X-CRASHLYTICS-API-CLIENT-TYPE", "android").d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9070f);
    }

    private com.google.firebase.crashlytics.c.k.b h(com.google.firebase.crashlytics.c.k.b bVar, com.google.firebase.crashlytics.c.p.i.a aVar) {
        com.google.firebase.crashlytics.c.k.b g2 = bVar.g("org_id", aVar.a).g("app[identifier]", aVar.f9040c).g("app[name]", aVar.f9044g).g("app[display_version]", aVar.f9041d).g("app[build_version]", aVar.f9042e).g("app[source]", Integer.toString(aVar.f9045h)).g("app[minimum_sdk_version]", aVar.f9046i).g("app[built_sdk_version]", aVar.f9047j);
        if (!h.D(aVar.f9043f)) {
            g2.g("app[instance_identifier]", aVar.f9043f);
        }
        return g2;
    }

    public boolean i(com.google.firebase.crashlytics.c.p.i.a aVar, boolean z) {
        if (z) {
            com.google.firebase.crashlytics.c.k.b h2 = h(g(c(), aVar), aVar);
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("Sending app info to " + e());
            try {
                com.google.firebase.crashlytics.c.k.d b2 = h2.b();
                int b3 = b2.b();
                String str = HttpPost.METHOD_NAME.equalsIgnoreCase(h2.f()) ? "Create" : "Update";
                com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
                f3.b(str + " app request ID: " + b2.d("X-REQUEST-ID"));
                com.google.firebase.crashlytics.c.b f4 = com.google.firebase.crashlytics.c.b.f();
                f4.b("Result was " + b3);
                return b0.a(b3) == 0;
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b.f().e("HTTP request failed.", e2);
                throw new RuntimeException(e2);
            }
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }
}