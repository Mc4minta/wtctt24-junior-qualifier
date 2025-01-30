package h.c.n0.e.e;

/* compiled from: ObservableFlattenIterable.java */
/* loaded from: classes3.dex */
public final class a1<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f15488b;

    /* compiled from: ObservableFlattenIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f15489b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15490c;

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar) {
            this.a = zVar;
            this.f15489b = nVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15490c.dispose();
            this.f15490c = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15490c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.k0.b bVar = this.f15490c;
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar == cVar) {
                return;
            }
            this.f15490c = cVar;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.k0.b bVar = this.f15490c;
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar == cVar) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15490c = cVar;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15490c == h.c.n0.a.c.DISPOSED) {
                return;
            }
            try {
                h.c.z<? super R> zVar = this.a;
                for (R r : this.f15489b.apply(t)) {
                    try {
                        try {
                            zVar.onNext((Object) h.c.n0.b.b.e(r, "The iterator returned a null value"));
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            this.f15490c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.f15490c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f15490c.dispose();
                onError(th3);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15490c, bVar)) {
                this.f15490c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public a1(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar) {
        super(xVar);
        this.f15488b = nVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        this.a.subscribe(new a(zVar, this.f15488b));
    }
}