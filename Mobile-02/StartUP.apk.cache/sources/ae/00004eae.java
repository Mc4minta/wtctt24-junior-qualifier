package h.c.n0.e.e;

/* compiled from: ObservableDoAfterNext.java */
/* loaded from: classes3.dex */
public final class l0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f15909b;

    /* compiled from: ObservableDoAfterNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.f<? super T> f15910f;

        a(h.c.z<? super T> zVar, h.c.m0.f<? super T> fVar) {
            super(zVar);
            this.f15910f = fVar;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
            if (this.f14115e == 0) {
                try {
                    this.f15910f.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f14113c.poll();
            if (poll != null) {
                this.f15910f.accept(poll);
            }
            return poll;
        }
    }

    public l0(h.c.x<T> xVar, h.c.m0.f<? super T> fVar) {
        super(xVar);
        this.f15909b = fVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15909b));
    }
}