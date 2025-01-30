package h.c.n0.e.e;

/* compiled from: ObservableMap.java */
/* loaded from: classes3.dex */
public final class v1<T, U> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends U> f16317b;

    /* compiled from: ObservableMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends h.c.n0.d.a<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends U> f16318f;

        a(h.c.z<? super U> zVar, h.c.m0.n<? super T, ? extends U> nVar) {
            super(zVar);
            this.f16318f = nVar;
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
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(h.c.n0.b.b.e(this.f16318f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // h.c.n0.c.j
        public U poll() throws Exception {
            T poll = this.f14113c.poll();
            if (poll != null) {
                return (U) h.c.n0.b.b.e(this.f16318f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public v1(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends U> nVar) {
        super(xVar);
        this.f16317b = nVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super U> zVar) {
        this.a.subscribe(new a(zVar, this.f16317b));
    }
}