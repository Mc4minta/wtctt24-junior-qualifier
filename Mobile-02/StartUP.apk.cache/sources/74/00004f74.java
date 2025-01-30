package h.c.n0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimer.java */
/* loaded from: classes3.dex */
public final class y3 extends h.c.s<Long> {
    final h.c.a0 a;

    /* renamed from: b  reason: collision with root package name */
    final long f16424b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16425c;

    /* compiled from: ObservableTimer.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.k0.b, Runnable {
        final h.c.z<? super Long> a;

        a(h.c.z<? super Long> zVar) {
            this.a = zVar;
        }

        public void a(h.c.k0.b bVar) {
            h.c.n0.a.c.A(this, bVar);
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
            this.a.onNext(0L);
            lazySet(h.c.n0.a.d.INSTANCE);
            this.a.onComplete();
        }
    }

    public y3(long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.f16424b = j2;
        this.f16425c = timeUnit;
        this.a = a0Var;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super Long> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        aVar.a(this.a.d(aVar, this.f16424b, this.f16425c));
    }
}