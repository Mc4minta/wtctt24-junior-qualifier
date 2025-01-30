package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDoOnDispose.java */
/* loaded from: classes3.dex */
public final class p<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.a f16544b;

    /* compiled from: SingleDoOnDispose.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.m0.a> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16545b;

        a(h.c.e0<? super T> e0Var, h.c.m0.a aVar) {
            this.a = e0Var;
            lazySet(aVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.m0.a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
                this.f16545b.dispose();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16545b.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16545b, bVar)) {
                this.f16545b = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public p(h.c.h0<T> h0Var, h.c.m0.a aVar) {
        this.a = h0Var;
        this.f16544b = aVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16544b));
    }
}