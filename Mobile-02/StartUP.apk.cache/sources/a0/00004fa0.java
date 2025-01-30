package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithObservable.java */
/* loaded from: classes3.dex */
public final class h<T, U> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<U> f16509b;

    /* compiled from: SingleDelayWithObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends AtomicReference<h.c.k0.b> implements h.c.z<U>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.h0<T> f16510b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16511c;

        a(h.c.e0<? super T> e0Var, h.c.h0<T> h0Var) {
            this.a = e0Var;
            this.f16510b = h0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16511c) {
                return;
            }
            this.f16511c = true;
            this.f16510b.subscribe(new h.c.n0.d.y(this, this.a));
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16511c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16511c = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(U u) {
            get().dispose();
            onComplete();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.y(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }
    }

    public h(h.c.h0<T> h0Var, h.c.x<U> xVar) {
        this.a = h0Var;
        this.f16509b = xVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.f16509b.subscribe(new a(e0Var, this.a));
    }
}