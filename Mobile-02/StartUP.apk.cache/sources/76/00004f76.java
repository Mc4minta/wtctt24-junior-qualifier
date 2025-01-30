package h.c.n0.e.e;

/* compiled from: ObservableCount.java */
/* loaded from: classes3.dex */
public final class z<T> extends h.c.n0.e.e.a<T, Long> {

    /* compiled from: ObservableCount.java */
    /* loaded from: classes3.dex */
    static final class a implements h.c.z<Object>, h.c.k0.b {
        final h.c.z<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16426b;

        /* renamed from: c  reason: collision with root package name */
        long f16427c;

        a(h.c.z<? super Long> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16426b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16426b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onNext(Long.valueOf(this.f16427c));
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            this.f16427c++;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16426b, bVar)) {
                this.f16426b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public z(h.c.x<T> xVar) {
        super(xVar);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super Long> zVar) {
        this.a.subscribe(new a(zVar));
    }
}