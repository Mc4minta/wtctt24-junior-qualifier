package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublishSelector.java */
/* loaded from: classes3.dex */
public final class g2<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super h.c.s<T>, ? extends h.c.x<R>> f15695b;

    /* compiled from: ObservablePublishSelector.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.z<T> {
        final h.c.v0.b<T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15696b;

        a(h.c.v0.b<T> bVar, AtomicReference<h.c.k0.b> atomicReference) {
            this.a = bVar;
            this.f15696b = atomicReference;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15696b, bVar);
        }
    }

    /* compiled from: ObservablePublishSelector.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicReference<h.c.k0.b> implements h.c.z<R>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15697b;

        b(h.c.z<? super R> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15697b.dispose();
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15697b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.n0.a.c.h(this);
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this);
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15697b, bVar)) {
                this.f15697b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g2(h.c.x<T> xVar, h.c.m0.n<? super h.c.s<T>, ? extends h.c.x<R>> nVar) {
        super(xVar);
        this.f15695b = nVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        h.c.v0.b d2 = h.c.v0.b.d();
        try {
            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15695b.apply(d2), "The selector returned a null ObservableSource");
            b bVar = new b(zVar);
            xVar.subscribe(bVar);
            this.a.subscribe(new a(d2, bVar));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }
}