package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMap.java */
/* loaded from: classes3.dex */
public final class x<T, R> extends h.c.b0<R> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> f16585b;

    /* compiled from: SingleFlatMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> f16586b;

        /* compiled from: SingleFlatMap.java */
        /* renamed from: h.c.n0.e.g.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0396a<R> implements h.c.e0<R> {
            final AtomicReference<h.c.k0.b> a;

            /* renamed from: b  reason: collision with root package name */
            final h.c.e0<? super R> f16587b;

            C0396a(AtomicReference<h.c.k0.b> atomicReference, h.c.e0<? super R> e0Var) {
                this.a = atomicReference;
                this.f16587b = e0Var;
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                this.f16587b.onError(th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this.a, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(R r) {
                this.f16587b.onSuccess(r);
            }
        }

        a(h.c.e0<? super R> e0Var, h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> nVar) {
            this.a = e0Var;
            this.f16586b = nVar;
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
        public void onSuccess(T t) {
            try {
                h.c.h0 h0Var = (h.c.h0) h.c.n0.b.b.e(this.f16586b.apply(t), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                h0Var.subscribe(new C0396a(this, this.a));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public x(h.c.h0<? extends T> h0Var, h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> nVar) {
        this.f16585b = nVar;
        this.a = h0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16585b));
    }
}