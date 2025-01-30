package h.c.n0.e.a;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableTimer.java */
/* loaded from: classes.dex */
public final class j extends h.c.c {
    final long a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f14173b;

    /* renamed from: c  reason: collision with root package name */
    final a0 f14174c;

    /* compiled from: CompletableTimer.java */
    /* loaded from: classes.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.k0.b, Runnable {
        final h.c.e a;

        a(h.c.e eVar) {
            this.a = eVar;
        }

        void a(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this, bVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onComplete();
        }
    }

    public j(long j2, TimeUnit timeUnit, a0 a0Var) {
        this.a = j2;
        this.f14173b = timeUnit;
        this.f14174c = a0Var;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        a aVar = new a(eVar);
        eVar.onSubscribe(aVar);
        aVar.a(this.f14174c.d(aVar, this.a, this.f14173b));
    }
}