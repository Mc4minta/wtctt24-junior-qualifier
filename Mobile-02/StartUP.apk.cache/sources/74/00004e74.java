package h.c.n0.e.e;

/* compiled from: ObservableSkipUntil.java */
/* loaded from: classes3.dex */
public final class h3<T, U> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<U> f15748b;

    /* compiled from: ObservableSkipUntil.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.z<U> {
        final h.c.n0.a.a a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f15749b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.p0.f<T> f15750c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f15751d;

        a(h.c.n0.a.a aVar, b<T> bVar, h.c.p0.f<T> fVar) {
            this.a = aVar;
            this.f15749b = bVar;
            this.f15750c = fVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15749b.f15755d = true;
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.dispose();
            this.f15750c.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(U u) {
            this.f15751d.dispose();
            this.f15749b.f15755d = true;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15751d, bVar)) {
                this.f15751d = bVar;
                this.a.a(1, bVar);
            }
        }
    }

    /* compiled from: ObservableSkipUntil.java */
    /* loaded from: classes3.dex */
    static final class b<T> implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.a f15753b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15754c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f15755d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15756e;

        b(h.c.z<? super T> zVar, h.c.n0.a.a aVar) {
            this.a = zVar;
            this.f15753b = aVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15753b.dispose();
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15753b.dispose();
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15756e) {
                this.a.onNext(t);
            } else if (this.f15755d) {
                this.f15756e = true;
                this.a.onNext(t);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15754c, bVar)) {
                this.f15754c = bVar;
                this.f15753b.a(0, bVar);
            }
        }
    }

    public h3(h.c.x<T> xVar, h.c.x<U> xVar2) {
        super(xVar);
        this.f15748b = xVar2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.p0.f fVar = new h.c.p0.f(zVar);
        h.c.n0.a.a aVar = new h.c.n0.a.a(2);
        fVar.onSubscribe(aVar);
        b bVar = new b(fVar, aVar);
        this.f15748b.subscribe(new a(aVar, bVar, fVar));
        this.a.subscribe(bVar);
    }
}