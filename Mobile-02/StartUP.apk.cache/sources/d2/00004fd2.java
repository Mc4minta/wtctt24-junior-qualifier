package h.c.n0.e.g;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTimer.java */
/* loaded from: classes3.dex */
public final class t0 extends h.c.b0<Long> {
    final long a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f16571b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.a0 f16572c;

    /* compiled from: SingleTimer.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.k0.b, Runnable {
        final h.c.e0<? super Long> a;

        a(h.c.e0<? super Long> e0Var) {
            this.a = e0Var;
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
            this.a.onSuccess(0L);
        }
    }

    public t0(long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.a = j2;
        this.f16571b = timeUnit;
        this.f16572c = a0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Long> e0Var) {
        a aVar = new a(e0Var);
        e0Var.onSubscribe(aVar);
        aVar.a(this.f16572c.d(aVar, this.a, this.f16571b));
    }
}