package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableScanSeed.java */
/* loaded from: classes3.dex */
public final class y2<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<R, ? super T, R> f16418b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<R> f16419c;

    /* compiled from: ObservableScanSeed.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<R, ? super T, R> f16420b;

        /* renamed from: c  reason: collision with root package name */
        R f16421c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16422d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16423e;

        a(h.c.z<? super R> zVar, h.c.m0.c<R, ? super T, R> cVar, R r) {
            this.a = zVar;
            this.f16420b = cVar;
            this.f16421c = r;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16422d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16422d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16423e) {
                return;
            }
            this.f16423e = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16423e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16423e = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16423e) {
                return;
            }
            try {
                R r = (R) h.c.n0.b.b.e(this.f16420b.apply(this.f16421c, t), "The accumulator returned a null value");
                this.f16421c = r;
                this.a.onNext(r);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16422d.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16422d, bVar)) {
                this.f16422d = bVar;
                this.a.onSubscribe(this);
                this.a.onNext((R) this.f16421c);
            }
        }
    }

    public y2(h.c.x<T> xVar, Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        super(xVar);
        this.f16418b = cVar;
        this.f16419c = callable;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        try {
            this.a.subscribe(new a(zVar, this.f16418b, h.c.n0.b.b.e(this.f16419c.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }
}