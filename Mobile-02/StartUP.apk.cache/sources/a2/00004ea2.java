package h.c.n0.e.e;

/* compiled from: ObservableHide.java */
/* loaded from: classes3.dex */
public final class k1<T> extends h.c.n0.e.e.a<T, T> {

    /* compiled from: ObservableHide.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15872b;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15872b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15872b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15872b, bVar)) {
                this.f15872b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public k1(h.c.x<T> xVar) {
        super(xVar);
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar));
    }
}