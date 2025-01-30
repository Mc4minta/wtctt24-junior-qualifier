package h.c.n0.e.b;

/* compiled from: FlowableReduceSeedSingle.java */
/* loaded from: classes3.dex */
public final class w2<T, R> extends h.c.b0<R> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final R f15180b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.c<R, ? super T, R> f15181c;

    /* compiled from: FlowableReduceSeedSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<R, ? super T, R> f15182b;

        /* renamed from: c  reason: collision with root package name */
        R f15183c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15184d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h.c.e0<? super R> e0Var, h.c.m0.c<R, ? super T, R> cVar, R r) {
            this.a = e0Var;
            this.f15183c = r;
            this.f15182b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15184d.cancel();
            this.f15184d = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15184d == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            R r = this.f15183c;
            if (r != null) {
                this.f15183c = null;
                this.f15184d = h.c.n0.i.g.CANCELLED;
                this.a.onSuccess(r);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15183c != null) {
                this.f15183c = null;
                this.f15184d = h.c.n0.i.g.CANCELLED;
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            R r = this.f15183c;
            if (r != null) {
                try {
                    this.f15183c = (R) h.c.n0.b.b.e(this.f15182b.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f15184d.cancel();
                    onError(th);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15184d, dVar)) {
                this.f15184d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public w2(k.a.b<T> bVar, R r, h.c.m0.c<R, ? super T, R> cVar) {
        this.a = bVar;
        this.f15180b = r;
        this.f15181c = cVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        this.a.subscribe(new a(e0Var, this.f15181c, this.f15180b));
    }
}