package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableCollect.java */
/* loaded from: classes3.dex */
public final class r<T, U> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends U> f16158b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.b<? super U, ? super T> f16159c;

    /* compiled from: ObservableCollect.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.b<? super U, ? super T> f16160b;

        /* renamed from: c  reason: collision with root package name */
        final U f16161c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16162d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16163e;

        a(h.c.z<? super U> zVar, U u, h.c.m0.b<? super U, ? super T> bVar) {
            this.a = zVar;
            this.f16160b = bVar;
            this.f16161c = u;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16162d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16162d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16163e) {
                return;
            }
            this.f16163e = true;
            this.a.onNext((U) this.f16161c);
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16163e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16163e = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16163e) {
                return;
            }
            try {
                this.f16160b.a((U) this.f16161c, t);
            } catch (Throwable th) {
                this.f16162d.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16162d, bVar)) {
                this.f16162d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public r(h.c.x<T> xVar, Callable<? extends U> callable, h.c.m0.b<? super U, ? super T> bVar) {
        super(xVar);
        this.f16158b = callable;
        this.f16159c = bVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super U> zVar) {
        try {
            this.a.subscribe(new a(zVar, h.c.n0.b.b.e(this.f16158b.call(), "The initialSupplier returned a null value"), this.f16159c));
        } catch (Throwable th) {
            h.c.n0.a.d.y(th, zVar);
        }
    }
}