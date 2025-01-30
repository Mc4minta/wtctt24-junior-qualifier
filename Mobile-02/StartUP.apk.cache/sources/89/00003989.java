package com.google.firebase.crashlytics.c.g;

import android.content.Context;
import com.google.firebase.crashlytics.c.i.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class e0 {
    private final m a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.l.g f8674b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.o.c f8675c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.h.b f8676d;

    /* renamed from: e  reason: collision with root package name */
    private final g0 f8677e;

    /* renamed from: f  reason: collision with root package name */
    private String f8678f;

    e0(m mVar, com.google.firebase.crashlytics.c.l.g gVar, com.google.firebase.crashlytics.c.o.c cVar, com.google.firebase.crashlytics.c.h.b bVar, g0 g0Var) {
        this.a = mVar;
        this.f8674b = gVar;
        this.f8675c = cVar;
        this.f8676d = bVar;
        this.f8677e = g0Var;
    }

    public static e0 b(Context context, v vVar, com.google.firebase.crashlytics.c.l.h hVar, b bVar, com.google.firebase.crashlytics.c.h.b bVar2, g0 g0Var, com.google.firebase.crashlytics.c.q.d dVar, com.google.firebase.crashlytics.c.p.e eVar) {
        return new e0(new m(context, vVar, bVar, dVar), new com.google.firebase.crashlytics.c.l.g(new File(hVar.a()), eVar), com.google.firebase.crashlytics.c.o.c.a(context), bVar2, g0Var);
    }

    private static List<v.b> e(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(v.b.a().b(entry.getKey()).c(entry.getValue()).a());
        }
        Collections.sort(arrayList, d0.a());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(com.google.android.gms.tasks.g<n> gVar) {
        if (gVar.q()) {
            n m = gVar.m();
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("Crashlytics report successfully enqueued to DataTransport: " + m.c());
            this.f8674b.i(m.c());
            return true;
        }
        com.google.firebase.crashlytics.c.b.f().c("Crashlytics report could not be enqueued to DataTransport", gVar.l());
        return false;
    }

    private void j(Throwable th, Thread thread, String str, long j2, boolean z) {
        String str2 = this.f8678f;
        if (str2 == null) {
            com.google.firebase.crashlytics.c.b.f().b("Cannot persist event, no currently open session");
            return;
        }
        boolean equals = str.equals("crash");
        v.d.AbstractC0173d b2 = this.a.b(th, thread, str, j2, 4, 8, z);
        v.d.AbstractC0173d.b g2 = b2.g();
        String d2 = this.f8676d.d();
        if (d2 != null) {
            g2.d(v.d.AbstractC0173d.AbstractC0184d.a().b(d2).a());
        } else {
            com.google.firebase.crashlytics.c.b.f().b("No log data to include with this event.");
        }
        List<v.b> e2 = e(this.f8677e.a());
        if (!e2.isEmpty()) {
            g2.b(b2.b().f().c(com.google.firebase.crashlytics.c.i.w.h(e2)).a());
        }
        this.f8674b.B(g2.a(), str2, equals);
    }

    public void c(String str, List<z> list) {
        ArrayList arrayList = new ArrayList();
        for (z zVar : list) {
            v.c.b c2 = zVar.c();
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        this.f8674b.k(str, v.c.a().b(com.google.firebase.crashlytics.c.i.w.h(arrayList)).a());
    }

    public void d(long j2) {
        this.f8674b.j(this.f8678f, j2);
    }

    public void g(String str, long j2) {
        this.f8678f = str;
        this.f8674b.C(this.a.c(str, j2));
    }

    public void h() {
        this.f8678f = null;
    }

    public void k(Throwable th, Thread thread, long j2) {
        j(th, thread, "crash", j2, true);
    }

    public void l(Throwable th, Thread thread, long j2) {
        j(th, thread, "error", j2, false);
    }

    public void m() {
        String str = this.f8678f;
        if (str == null) {
            com.google.firebase.crashlytics.c.b.f().b("Could not persist user ID; no current session");
            return;
        }
        String b2 = this.f8677e.b();
        if (b2 == null) {
            com.google.firebase.crashlytics.c.b.f().b("Could not persist user ID; no user ID available");
        } else {
            this.f8674b.D(b2, str);
        }
    }

    public void n() {
        this.f8674b.h();
    }

    public void o(Executor executor, r rVar) {
        if (rVar == r.NONE) {
            com.google.firebase.crashlytics.c.b.f().b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f8674b.h();
            return;
        }
        for (n nVar : this.f8674b.y()) {
            if (nVar.b().k() == v.e.NATIVE && rVar != r.ALL) {
                com.google.firebase.crashlytics.c.b.f().b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f8674b.i(nVar.c());
            } else {
                this.f8675c.e(nVar).i(executor, c0.b(this));
            }
        }
    }
}