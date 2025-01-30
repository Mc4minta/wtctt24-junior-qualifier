package h.c.n0.e.b;

/* compiled from: FlowableLastMaybe.java */
/* loaded from: classes3.dex */
public final class w1<T> extends h.c.o<T> {
    final k.a.b<T> a;

    /* compiled from: FlowableLastMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f15178b;

        /* renamed from: c  reason: collision with root package name */
        T f15179c;

        a(h.c.p<? super T> pVar) {
            this.a = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15178b.cancel();
            this.f15178b = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15178b == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15178b = h.c.n0.i.g.CANCELLED;
            T t = this.f15179c;
            if (t != null) {
                this.f15179c = null;
                this.a.onSuccess(t);
                return;
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f15178b = h.c.n0.i.g.CANCELLED;
            this.f15179c = null;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f15179c = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15178b, dVar)) {
                this.f15178b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public w1(k.a.b<T> bVar) {
        this.a = bVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe(new a(pVar));
    }
}