package h.c.n0.e.e;

/* compiled from: ObservableDetach.java */
/* loaded from: classes3.dex */
public final class i0<T> extends h.c.n0.e.e.a<T, T> {

    /* compiled from: ObservableDetach.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15786b;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.k0.b bVar = this.f15786b;
            this.f15786b = h.c.n0.j.g.INSTANCE;
            this.a = h.c.n0.j.g.n();
            bVar.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15786b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.z<? super T> zVar = this.a;
            this.f15786b = h.c.n0.j.g.INSTANCE;
            this.a = h.c.n0.j.g.n();
            zVar.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.z<? super T> zVar = this.a;
            this.f15786b = h.c.n0.j.g.INSTANCE;
            this.a = h.c.n0.j.g.n();
            zVar.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15786b, bVar)) {
                this.f15786b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i0(h.c.x<T> xVar) {
        super(xVar);
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar));
    }
}