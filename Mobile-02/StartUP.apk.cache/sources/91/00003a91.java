package com.google.firebase.crashlytics.c.n.d;

import com.google.firebase.crashlytics.c.g.b0;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class c extends com.google.firebase.crashlytics.c.g.a implements b {

    /* renamed from: f  reason: collision with root package name */
    private final String f9020f;

    public c(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar, String str3) {
        this(str, str2, cVar, com.google.firebase.crashlytics.c.k.a.POST, str3);
    }

    private com.google.firebase.crashlytics.c.k.b g(com.google.firebase.crashlytics.c.k.b bVar, com.google.firebase.crashlytics.c.n.c.a aVar) {
        com.google.firebase.crashlytics.c.k.b d2 = bVar.d("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f9013b).d("X-CRASHLYTICS-API-CLIENT-TYPE", "android").d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9020f);
        for (Map.Entry<String, String> entry : aVar.f9014c.b().entrySet()) {
            d2 = d2.e(entry);
        }
        return d2;
    }

    private com.google.firebase.crashlytics.c.k.b h(com.google.firebase.crashlytics.c.k.b bVar, com.google.firebase.crashlytics.c.n.c.c cVar) {
        File[] d2;
        com.google.firebase.crashlytics.c.k.b g2 = bVar.g("report[identifier]", cVar.a());
        if (cVar.d().length == 1) {
            com.google.firebase.crashlytics.c.b.f().b("Adding single file " + cVar.e() + " to report " + cVar.a());
            return g2.h("report[file]", cVar.e(), "application/octet-stream", cVar.c());
        }
        int i2 = 0;
        for (File file : cVar.d()) {
            com.google.firebase.crashlytics.c.b.f().b("Adding file " + file.getName() + " to report " + cVar.a());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i2);
            sb.append("]");
            g2 = g2.h(sb.toString(), file.getName(), "application/octet-stream", file);
            i2++;
        }
        return g2;
    }

    @Override // com.google.firebase.crashlytics.c.n.d.b
    public boolean b(com.google.firebase.crashlytics.c.n.c.a aVar, boolean z) {
        if (z) {
            com.google.firebase.crashlytics.c.k.b h2 = h(g(c(), aVar), aVar.f9014c);
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("Sending report to: " + e());
            try {
                com.google.firebase.crashlytics.c.k.d b2 = h2.b();
                int b3 = b2.b();
                com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
                f3.b("Create report request ID: " + b2.d("X-REQUEST-ID"));
                com.google.firebase.crashlytics.c.b f4 = com.google.firebase.crashlytics.c.b.f();
                f4.b("Result was: " + b3);
                return b0.a(b3) == 0;
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b.f().e("Create report HTTP request failed.", e2);
                throw new RuntimeException(e2);
            }
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }

    c(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar, com.google.firebase.crashlytics.c.k.a aVar, String str3) {
        super(str, str2, cVar, aVar);
        this.f9020f = str3;
    }
}