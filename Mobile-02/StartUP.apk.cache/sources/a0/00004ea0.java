package h.c.n0.e.e;

/* compiled from: ObservableDistinctUntilChanged.java */
/* loaded from: classes3.dex */
public final class k0<T, K> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, K> f15866b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<? super K, ? super K> f15867c;

    /* compiled from: ObservableDistinctUntilChanged.java */
    /* loaded from: classes3.dex */
    static final class a<T, K> extends h.c.n0.d.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, K> f15868f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.d<? super K, ? super K> f15869g;

        /* renamed from: h  reason: collision with root package name */
        K f15870h;

        /* renamed from: j  reason: collision with root package name */
        boolean f15871j;

        a(h.c.z<? super T> zVar, h.c.m0.n<? super T, K> nVar, h.c.m0.d<? super K, ? super K> dVar) {
            super(zVar);
            this.f15868f = nVar;
            this.f15869g = dVar;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f14114d) {
                return;
            }
            if (this.f14115e != 0) {
                this.a.onNext(t);
                return;
            }
            try {
                K apply = this.f15868f.apply(t);
                if (this.f15871j) {
                    boolean a = this.f15869g.a((K) this.f15870h, apply);
                    this.f15870h = apply;
                    if (a) {
                        return;
                    }
                } else {
                    this.f15871j = true;
                    this.f15870h = apply;
                }
                this.a.onNext(t);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            while (true) {
                T poll = this.f14113c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f15868f.apply(poll);
                if (!this.f15871j) {
                    this.f15871j = true;
                    this.f15870h = apply;
                    return poll;
                } else if (!this.f15869g.a((K) this.f15870h, apply)) {
                    this.f15870h = apply;
                    return poll;
                } else {
                    this.f15870h = apply;
                }
            }
        }
    }

    public k0(h.c.x<T> xVar, h.c.m0.n<? super T, K> nVar, h.c.m0.d<? super K, ? super K> dVar) {
        super(xVar);
        this.f15866b = nVar;
        this.f15867c = dVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15866b, this.f15867c));
    }
}