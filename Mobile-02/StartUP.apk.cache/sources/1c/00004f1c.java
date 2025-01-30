package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableCollectSingle.java */
/* loaded from: classes3.dex */
public final class s<T, U> extends h.c.b0<U> implements h.c.n0.c.d<U> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends U> f16180b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.b<? super U, ? super T> f16181c;

    /* compiled from: ObservableCollectSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.b<? super U, ? super T> f16182b;

        /* renamed from: c  reason: collision with root package name */
        final U f16183c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16184d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16185e;

        a(h.c.e0<? super U> e0Var, U u, h.c.m0.b<? super U, ? super T> bVar) {
            this.a = e0Var;
            this.f16182b = bVar;
            this.f16183c = u;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16184d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16184d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16185e) {
                return;
            }
            this.f16185e = true;
            this.a.onSuccess((U) this.f16183c);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16185e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16185e = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16185e) {
                return;
            }
            try {
                this.f16182b.a((U) this.f16183c, t);
            } catch (Throwable th) {
                this.f16184d.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16184d, bVar)) {
                this.f16184d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public s(h.c.x<T> xVar, Callable<? extends U> callable, h.c.m0.b<? super U, ? super T> bVar) {
        this.a = xVar;
        this.f16180b = callable;
        this.f16181c = bVar;
    }

    @Override // h.c.n0.c.d
    public h.c.s<U> a() {
        return h.c.r0.a.n(new r(this.a, this.f16180b, this.f16181c));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super U> e0Var) {
        try {
            this.a.subscribe(new a(e0Var, h.c.n0.b.b.e(this.f16180b.call(), "The initialSupplier returned a null value"), this.f16181c));
        } catch (Throwable th) {
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}