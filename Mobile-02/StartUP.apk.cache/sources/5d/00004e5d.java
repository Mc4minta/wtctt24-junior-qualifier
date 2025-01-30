package h.c.n0.e.e;

/* compiled from: ObservableAllSingle.java */
/* loaded from: classes3.dex */
public final class g<T> extends h.c.b0<Boolean> implements h.c.n0.c.d<Boolean> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15687b;

    /* compiled from: ObservableAllSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f15688b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15689c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15690d;

        a(h.c.e0<? super Boolean> e0Var, h.c.m0.p<? super T> pVar) {
            this.a = e0Var;
            this.f15688b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15689c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15689c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15690d) {
                return;
            }
            this.f15690d = true;
            this.a.onSuccess(Boolean.TRUE);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15690d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15690d = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15690d) {
                return;
            }
            try {
                if (this.f15688b.test(t)) {
                    return;
                }
                this.f15690d = true;
                this.f15689c.dispose();
                this.a.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15689c.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15689c, bVar)) {
                this.f15689c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        this.a = xVar;
        this.f15687b = pVar;
    }

    @Override // h.c.n0.c.d
    public h.c.s<Boolean> a() {
        return h.c.r0.a.n(new f(this.a, this.f15687b));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        this.a.subscribe(new a(e0Var, this.f15687b));
    }
}