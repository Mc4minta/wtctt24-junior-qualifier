package h.c.n0.e.g;

/* compiled from: SingleDematerialize.java */
/* loaded from: classes3.dex */
public final class k<T, R> extends h.c.o<R> {
    final h.c.b0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, h.c.r<R>> f16522b;

    /* compiled from: SingleDematerialize.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.e0<T>, h.c.k0.b {
        final h.c.p<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, h.c.r<R>> f16523b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16524c;

        a(h.c.p<? super R> pVar, h.c.m0.n<? super T, h.c.r<R>> nVar) {
            this.a = pVar;
            this.f16523b = nVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16524c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16524c.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16524c, bVar)) {
                this.f16524c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            try {
                h.c.r rVar = (h.c.r) h.c.n0.b.b.e(this.f16523b.apply(t), "The selector returned a null Notification");
                if (rVar.h()) {
                    this.a.onSuccess((Object) rVar.e());
                } else if (rVar.f()) {
                    this.a.onComplete();
                } else {
                    this.a.onError(rVar.d());
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public k(h.c.b0<T> b0Var, h.c.m0.n<? super T, h.c.r<R>> nVar) {
        this.a = b0Var;
        this.f16522b = nVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super R> pVar) {
        this.a.subscribe(new a(pVar, this.f16522b));
    }
}