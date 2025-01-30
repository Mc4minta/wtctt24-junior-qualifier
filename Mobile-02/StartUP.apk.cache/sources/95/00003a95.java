package com.google.firebase.crashlytics.c.o;

import android.content.Context;
import com.google.firebase.crashlytics.c.g.n;
import com.google.firebase.crashlytics.c.i.v;
import com.google.firebase.crashlytics.c.i.x.h;
import e.g.a.c.e;
import e.g.a.c.f;
import e.g.a.c.g;
import e.g.a.c.i.q;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class c {
    private static final h a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final String f9023b = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: c  reason: collision with root package name */
    private static final String f9024c = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: d  reason: collision with root package name */
    private static final e<v, byte[]> f9025d = b.a();

    /* renamed from: e  reason: collision with root package name */
    private final f<v> f9026e;

    /* renamed from: f  reason: collision with root package name */
    private final e<v, byte[]> f9027f;

    c(f<v> fVar, e<v, byte[]> eVar) {
        this.f9026e = fVar;
        this.f9027f = eVar;
    }

    public static c a(Context context) {
        q.f(context);
        g g2 = q.c().g(new com.google.android.datatransport.cct.a(f9023b, f9024c));
        e.g.a.c.b b2 = e.g.a.c.b.b("json");
        e<v, byte[]> eVar = f9025d;
        return new c(g2.a("FIREBASE_CRASHLYTICS_REPORT", v.class, b2, eVar), eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(com.google.android.gms.tasks.h hVar, n nVar, Exception exc) {
        if (exc != null) {
            hVar.d(exc);
        } else {
            hVar.e(nVar);
        }
    }

    private static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                sb.append(str.charAt(i2));
                if (str2.length() > i2) {
                    sb.append(str2.charAt(i2));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    public com.google.android.gms.tasks.g<n> e(n nVar) {
        v b2 = nVar.b();
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        this.f9026e.b(e.g.a.c.c.e(b2), a.b(hVar, nVar));
        return hVar.a();
    }
}