package h.c.n0.e.e;

/* compiled from: ObservableTakeLastOne.java */
/* loaded from: classes3.dex */
public final class o3<T> extends h.c.n0.e.e.a<T, T> {

    /* compiled from: ObservableTakeLastOne.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16030b;

        /* renamed from: c  reason: collision with root package name */
        T f16031c;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        void a() {
            T t = this.f16031c;
            if (t != null) {
                this.f16031c = null;
                this.a.onNext(t);
            }
            this.a.onComplete();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16031c = null;
            this.f16030b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16030b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16031c = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f16031c = t;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16030b, bVar)) {
                this.f16030b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public o3(h.c.x<T> xVar) {
        super(xVar);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar));
    }
}