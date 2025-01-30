package h.c.n0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableCollectSingle.java */
/* loaded from: classes3.dex */
public final class s<T, U> extends h.c.b0<U> implements h.c.n0.c.b<U> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends U> f14963b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.b<? super U, ? super T> f14964c;

    /* compiled from: FlowableCollectSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.b<? super U, ? super T> f14965b;

        /* renamed from: c  reason: collision with root package name */
        final U f14966c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f14967d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14968e;

        a(h.c.e0<? super U> e0Var, U u, h.c.m0.b<? super U, ? super T> bVar) {
            this.a = e0Var;
            this.f14965b = bVar;
            this.f14966c = u;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14967d.cancel();
            this.f14967d = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14967d == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14968e) {
                return;
            }
            this.f14968e = true;
            this.f14967d = h.c.n0.i.g.CANCELLED;
            this.a.onSuccess((U) this.f14966c);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14968e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14968e = true;
            this.f14967d = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14968e) {
                return;
            }
            try {
                this.f14965b.a((U) this.f14966c, t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14967d.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14967d, dVar)) {
                this.f14967d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public s(h.c.h<T> hVar, Callable<? extends U> callable, h.c.m0.b<? super U, ? super T> bVar) {
        this.a = hVar;
        this.f14963b = callable;
        this.f14964c = bVar;
    }

    @Override // h.c.n0.c.b
    public h.c.h<U> e() {
        return h.c.r0.a.l(new r(this.a, this.f14963b, this.f14964c));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super U> e0Var) {
        try {
            this.a.subscribe((h.c.m) new a(e0Var, h.c.n0.b.b.e(this.f14963b.call(), "The initialSupplier returned a null value"), this.f14964c));
        } catch (Throwable th) {
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}