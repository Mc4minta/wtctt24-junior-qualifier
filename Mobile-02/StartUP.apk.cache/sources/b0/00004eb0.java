package h.c.n0.e.e;

/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes3.dex */
public final class l1<T> extends h.c.n0.e.e.a<T, T> {

    /* compiled from: ObservableIgnoreElements.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15911b;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15911b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15911b.isDisposed();
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
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f15911b = bVar;
            this.a.onSubscribe(this);
        }
    }

    public l1(h.c.x<T> xVar) {
        super(xVar);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar));
    }
}