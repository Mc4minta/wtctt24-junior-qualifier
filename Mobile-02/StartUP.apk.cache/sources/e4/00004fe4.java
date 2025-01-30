package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class y<T> extends h.c.c {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f16594b;

    /* compiled from: SingleFlatMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.e, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f16595b;

        a(h.c.e eVar, h.c.m0.n<? super T, ? extends h.c.f> nVar) {
            this.a = eVar;
            this.f16595b = nVar;
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
            this.a.onComplete();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f16595b.apply(t), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                fVar.c(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(th);
            }
        }
    }

    public y(h.c.h0<T> h0Var, h.c.m0.n<? super T, ? extends h.c.f> nVar) {
        this.a = h0Var;
        this.f16594b = nVar;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        a aVar = new a(eVar, this.f16594b);
        eVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}