package h.c.n0.e.e;

/* compiled from: ObservableAll.java */
/* loaded from: classes3.dex */
public final class f<T> extends h.c.n0.e.e.a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15648b;

    /* compiled from: ObservableAll.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f15649b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15650c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15651d;

        a(h.c.z<? super Boolean> zVar, h.c.m0.p<? super T> pVar) {
            this.a = zVar;
            this.f15649b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15650c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15650c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15651d) {
                return;
            }
            this.f15651d = true;
            this.a.onNext(Boolean.TRUE);
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15651d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15651d = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15651d) {
                return;
            }
            try {
                if (this.f15649b.test(t)) {
                    return;
                }
                this.f15651d = true;
                this.f15650c.dispose();
                this.a.onNext(Boolean.FALSE);
                this.a.onComplete();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15650c.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15650c, bVar)) {
                this.f15650c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public f(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        super(xVar);
        this.f15648b = pVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super Boolean> zVar) {
        this.a.subscribe(new a(zVar, this.f15648b));
    }
}