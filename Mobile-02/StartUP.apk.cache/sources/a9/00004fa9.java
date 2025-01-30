package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithSingle.java */
/* loaded from: classes3.dex */
public final class j<T, U> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.h0<U> f16519b;

    /* compiled from: SingleDelayWithSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends AtomicReference<h.c.k0.b> implements h.c.e0<U>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.h0<T> f16520b;

        a(h.c.e0<? super T> e0Var, h.c.h0<T> h0Var) {
            this.a = e0Var;
            this.f16520b = h0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(U u) {
            this.f16520b.subscribe(new h.c.n0.d.y(this, this.a));
        }
    }

    public j(h.c.h0<T> h0Var, h.c.h0<U> h0Var2) {
        this.a = h0Var;
        this.f16519b = h0Var2;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.f16519b.subscribe(new a(e0Var, this.a));
    }
}