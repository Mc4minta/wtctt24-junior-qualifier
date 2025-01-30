package h.c.n0.e.e;

/* compiled from: ObservableMaterialize.java */
/* loaded from: classes3.dex */
public final class x1<T> extends h.c.n0.e.e.a<T, h.c.r<T>> {

    /* compiled from: ObservableMaterialize.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super h.c.r<T>> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16375b;

        a(h.c.z<? super h.c.r<T>> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16375b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16375b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onNext(h.c.r.a());
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onNext(h.c.r.b(th));
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(h.c.r.c(t));
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16375b, bVar)) {
                this.f16375b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public x1(h.c.x<T> xVar) {
        super(xVar);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.r<T>> zVar) {
        this.a.subscribe(new a(zVar));
    }
}