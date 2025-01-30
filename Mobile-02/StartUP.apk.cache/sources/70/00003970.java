package com.google.firebase.crashlytics;

import android.content.Context;
import com.google.android.gms.tasks.j;
import com.google.firebase.c;
import com.google.firebase.crashlytics.c.e;
import com.google.firebase.crashlytics.c.g.k;
import com.google.firebase.crashlytics.c.g.q;
import com.google.firebase.crashlytics.c.g.t;
import com.google.firebase.crashlytics.c.g.v;
import com.google.firebase.crashlytics.c.p.d;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class b {
    private final k a;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements Callable<Void> {
        final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExecutorService f8639b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f8640c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f8641d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f8642e;

        a(e eVar, ExecutorService executorService, d dVar, boolean z, k kVar) {
            this.a = eVar;
            this.f8639b = executorService;
            this.f8640c = dVar;
            this.f8641d = z;
            this.f8642e = kVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            this.a.c(this.f8639b, this.f8640c);
            if (this.f8641d) {
                this.f8642e.g(this.f8640c);
                return null;
            }
            return null;
        }
    }

    private b(k kVar) {
        this.a = kVar;
    }

    public static b a() {
        b bVar = (b) c.h().f(b.class);
        Objects.requireNonNull(bVar, "FirebaseCrashlytics component is not present.");
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b(c cVar, com.google.firebase.iid.b.a aVar, com.google.firebase.crashlytics.c.a aVar2, com.google.firebase.analytics.a.a aVar3) {
        Context g2 = cVar.g();
        v vVar = new v(g2, g2.getPackageName(), aVar);
        q qVar = new q(cVar);
        com.google.firebase.crashlytics.c.c cVar2 = aVar2 == null ? new com.google.firebase.crashlytics.c.c() : aVar2;
        e eVar = new e(cVar, g2, vVar, qVar);
        k kVar = new k(cVar, vVar, cVar2, qVar, aVar3);
        if (!eVar.h()) {
            com.google.firebase.crashlytics.c.b.f().d("Unable to start Crashlytics.");
            return null;
        }
        ExecutorService c2 = t.c("com.google.firebase.crashlytics.startup");
        d l2 = eVar.l(g2, cVar, c2);
        j.c(c2, new a(eVar, c2, l2, kVar.o(l2), kVar));
        return new b(kVar);
    }

    public void c(String str) {
        this.a.k(str);
    }

    public void d(Throwable th) {
        if (th == null) {
            com.google.firebase.crashlytics.c.b.f().i("Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.a.l(th);
        }
    }

    public void e(String str, int i2) {
        this.a.p(str, Integer.toString(i2));
    }

    public void f(String str, String str2) {
        this.a.p(str, str2);
    }

    public void g(String str) {
        this.a.q(str);
    }
}