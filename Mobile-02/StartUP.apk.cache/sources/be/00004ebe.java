package h.c.n0.e.e;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes3.dex */
public final class m1<T> extends h.c.c implements h.c.n0.c.d<T> {
    final h.c.x<T> a;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15956b;

        a(h.c.e eVar) {
            this.a = eVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15956b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15956b.isDisposed();
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
            this.f15956b = bVar;
            this.a.onSubscribe(this);
        }
    }

    public m1(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // h.c.n0.c.d
    public h.c.s<T> a() {
        return h.c.r0.a.n(new l1(this.a));
    }

    @Override // h.c.c
    public void t(h.c.e eVar) {
        this.a.subscribe(new a(eVar));
    }
}