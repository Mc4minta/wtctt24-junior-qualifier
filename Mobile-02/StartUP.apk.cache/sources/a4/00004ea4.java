package h.c.n0.e.e;

/* compiled from: ObservableReduceSeedSingle.java */
/* loaded from: classes3.dex */
public final class k2<T, R> extends h.c.b0<R> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final R f15873b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.c<R, ? super T, R> f15874c;

    /* compiled from: ObservableReduceSeedSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<R, ? super T, R> f15875b;

        /* renamed from: c  reason: collision with root package name */
        R f15876c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f15877d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h.c.e0<? super R> e0Var, h.c.m0.c<R, ? super T, R> cVar, R r) {
            this.a = e0Var;
            this.f15876c = r;
            this.f15875b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15877d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15877d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            R r = this.f15876c;
            if (r != null) {
                this.f15876c = null;
                this.a.onSuccess(r);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15876c != null) {
                this.f15876c = null;
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            R r = this.f15876c;
            if (r != null) {
                try {
                    this.f15876c = (R) h.c.n0.b.b.e(this.f15875b.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f15877d.dispose();
                    onError(th);
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15877d, bVar)) {
                this.f15877d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public k2(h.c.x<T> xVar, R r, h.c.m0.c<R, ? super T, R> cVar) {
        this.a = xVar;
        this.f15873b = r;
        this.f15874c = cVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        this.a.subscribe(new a(e0Var, this.f15874c, this.f15873b));
    }
}