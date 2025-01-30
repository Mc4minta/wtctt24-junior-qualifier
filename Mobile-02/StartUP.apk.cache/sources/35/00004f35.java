package h.c.n0.e.e;

/* compiled from: ObservableFilter.java */
/* loaded from: classes3.dex */
public final class u0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f16258b;

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.p<? super T> f16259f;

        a(h.c.z<? super T> zVar, h.c.m0.p<? super T> pVar) {
            super(zVar);
            this.f16259f = pVar;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f14115e == 0) {
                try {
                    if (this.f16259f.test(t)) {
                        this.a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.a.onNext(null);
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f14113c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f16259f.test(poll));
            return poll;
        }
    }

    public u0(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        super(xVar);
        this.f16258b = pVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16258b));
    }
}