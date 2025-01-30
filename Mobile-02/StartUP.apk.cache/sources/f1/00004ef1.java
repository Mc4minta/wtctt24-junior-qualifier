package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableIntervalRange.java */
/* loaded from: classes3.dex */
public final class p1 extends h.c.s<Long> {
    final h.c.a0 a;

    /* renamed from: b  reason: collision with root package name */
    final long f16065b;

    /* renamed from: c  reason: collision with root package name */
    final long f16066c;

    /* renamed from: d  reason: collision with root package name */
    final long f16067d;

    /* renamed from: e  reason: collision with root package name */
    final long f16068e;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f16069f;

    /* compiled from: ObservableIntervalRange.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.k0.b, Runnable {
        final h.c.z<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16070b;

        /* renamed from: c  reason: collision with root package name */
        long f16071c;

        a(h.c.z<? super Long> zVar, long j2, long j3) {
            this.a = zVar;
            this.f16071c = j2;
            this.f16070b = j3;
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
            if (isDisposed()) {
                return;
            }
            long j2 = this.f16071c;
            this.a.onNext(Long.valueOf(j2));
            if (j2 == this.f16070b) {
                h.c.n0.a.c.h(this);
                this.a.onComplete();
                return;
            }
            this.f16071c = j2 + 1;
        }
    }

    public p1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.f16067d = j4;
        this.f16068e = j5;
        this.f16069f = timeUnit;
        this.a = a0Var;
        this.f16065b = j2;
        this.f16066c = j3;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super Long> zVar) {
        a aVar = new a(zVar, this.f16065b, this.f16066c);
        zVar.onSubscribe(aVar);
        h.c.a0 a0Var = this.a;
        if (a0Var instanceof h.c.n0.g.q) {
            a0.c a2 = a0Var.a();
            aVar.a(a2);
            a2.d(aVar, this.f16067d, this.f16068e, this.f16069f);
            return;
        }
        aVar.a(a0Var.e(aVar, this.f16067d, this.f16068e, this.f16069f));
    }
}