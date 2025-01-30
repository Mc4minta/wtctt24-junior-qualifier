package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapMaybe.java */
/* loaded from: classes3.dex */
public final class b0<T, R> extends h.c.o<R> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.q<? extends R>> f16484b;

    /* compiled from: SingleFlatMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<R> implements h.c.p<R> {
        final AtomicReference<h.c.k0.b> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.p<? super R> f16485b;

        a(AtomicReference<h.c.k0.b> atomicReference, h.c.p<? super R> pVar) {
            this.a = atomicReference;
            this.f16485b = pVar;
        }

        @Override // h.c.p
        public void onComplete() {
            this.f16485b.onComplete();
        }

        @Override // h.c.p
        public void onError(Throwable th) {
            this.f16485b.onError(th);
        }

        @Override // h.c.p
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this.a, bVar);
        }

        @Override // h.c.p
        public void onSuccess(R r) {
            this.f16485b.onSuccess(r);
        }
    }

    /* compiled from: SingleFlatMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b {
        final h.c.p<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.q<? extends R>> f16486b;

        b(h.c.p<? super R> pVar, h.c.m0.n<? super T, ? extends h.c.q<? extends R>> nVar) {
            this.a = pVar;
            this.f16486b = nVar;
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
                h.c.q qVar = (h.c.q) h.c.n0.b.b.e(this.f16486b.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                qVar.b(new a(this, this.a));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(th);
            }
        }
    }

    public b0(h.c.h0<? extends T> h0Var, h.c.m0.n<? super T, ? extends h.c.q<? extends R>> nVar) {
        this.f16484b = nVar;
        this.a = h0Var;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super R> pVar) {
        this.a.subscribe(new b(pVar, this.f16484b));
    }
}