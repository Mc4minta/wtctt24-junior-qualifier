package h.c.n0.e.e;

/* compiled from: ObservableCountSingle.java */
/* loaded from: classes3.dex */
public final class a0<T> extends h.c.b0<Long> implements h.c.n0.c.d<Long> {
    final h.c.x<T> a;

    /* compiled from: ObservableCountSingle.java */
    /* loaded from: classes3.dex */
    static final class a implements h.c.z<Object>, h.c.k0.b {
        final h.c.e0<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15486b;

        /* renamed from: c  reason: collision with root package name */
        long f15487c;

        a(h.c.e0<? super Long> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15486b.dispose();
            this.f15486b = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15486b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15486b = h.c.n0.a.c.DISPOSED;
            this.a.onSuccess(Long.valueOf(this.f15487c));
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15486b = h.c.n0.a.c.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            this.f15487c++;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15486b, bVar)) {
                this.f15486b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public a0(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // h.c.n0.c.d
    public h.c.s<Long> a() {
        return h.c.r0.a.n(new z(this.a));
    }

    @Override // h.c.b0
    public void subscribeActual(h.c.e0<? super Long> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}