package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithCompletable.java */
/* loaded from: classes3.dex */
public final class g<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.f f16506b;

    /* compiled from: SingleDelayWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.h0<T> f16507b;

        a(h.c.e0<? super T> e0Var, h.c.h0<T> h0Var) {
            this.a = e0Var;
            this.f16507b = h0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e
        public void onComplete() {
            this.f16507b.subscribe(new h.c.n0.d.y(this, this.a));
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }
    }

    public g(h.c.h0<T> h0Var, h.c.f fVar) {
        this.a = h0Var;
        this.f16506b = fVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.f16506b.c(new a(e0Var, this.a));
    }
}