package h.c.n0.e.g;

import java.util.Iterator;

/* compiled from: SingleFlatMapIterableObservable.java */
/* loaded from: classes3.dex */
public final class a0<T, R> extends h.c.s<R> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f16471b;

    /* compiled from: SingleFlatMapIterableObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends h.c.n0.d.b<R> implements h.c.e0<T> {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f16472b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16473c;

        /* renamed from: d  reason: collision with root package name */
        volatile Iterator<? extends R> f16474d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f16475e;

        /* renamed from: f  reason: collision with root package name */
        boolean f16476f;

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar) {
            this.a = zVar;
            this.f16472b = nVar;
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f16474d = null;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16475e = true;
            this.f16473c.dispose();
            this.f16473c = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16475e;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f16474d == null;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                this.f16476f = true;
                return 2;
            }
            return 0;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f16473c = h.c.n0.a.c.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16473c, bVar)) {
                this.f16473c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            h.c.z<? super R> zVar = this.a;
            try {
                Iterator<? extends R> it = this.f16472b.apply(t).iterator();
                if (!it.hasNext()) {
                    zVar.onComplete();
                } else if (this.f16476f) {
                    this.f16474d = it;
                    zVar.onNext(null);
                    zVar.onComplete();
                } else {
                    while (!this.f16475e) {
                        try {
                            zVar.onNext((R) it.next());
                            if (this.f16475e) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    zVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                zVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            zVar.onError(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.a.onError(th3);
            }
        }

        @Override // h.c.n0.c.j
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f16474d;
            if (it != null) {
                R r = (R) h.c.n0.b.b.e(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.f16474d = null;
                }
                return r;
            }
            return null;
        }
    }

    public a0(h.c.h0<T> h0Var, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar) {
        this.a = h0Var;
        this.f16471b = nVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        this.a.subscribe(new a(zVar, this.f16471b));
    }
}