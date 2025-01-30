package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableInterval.java */
/* loaded from: classes3.dex */
public final class o1 extends h.c.s<Long> {
    final h.c.a0 a;

    /* renamed from: b  reason: collision with root package name */
    final long f16022b;

    /* renamed from: c  reason: collision with root package name */
    final long f16023c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f16024d;

    /* compiled from: ObservableInterval.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.k0.b, Runnable {
        final h.c.z<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        long f16025b;

        a(h.c.z<? super Long> zVar) {
            this.a = zVar;
        }

        public void a(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != h.c.n0.a.c.DISPOSED) {
                h.c.z<? super Long> zVar = this.a;
                long j2 = this.f16025b;
                this.f16025b = 1 + j2;
                zVar.onNext(Long.valueOf(j2));
            }
        }
    }

    public o1(long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.f16022b = j2;
        this.f16023c = j3;
        this.f16024d = timeUnit;
        this.a = a0Var;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super Long> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        h.c.a0 a0Var = this.a;
        if (a0Var instanceof h.c.n0.g.q) {
            a0.c a2 = a0Var.a();
            aVar.a(a2);
            a2.d(aVar, this.f16022b, this.f16023c, this.f16024d);
            return;
        }
        aVar.a(a0Var.e(aVar, this.f16022b, this.f16023c, this.f16024d));
    }
}