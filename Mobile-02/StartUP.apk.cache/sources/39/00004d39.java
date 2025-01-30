package h.c.n0.e.b;

/* compiled from: FlowableIgnoreElementsCompletable.java */
/* loaded from: classes3.dex */
public final class q1<T> extends h.c.c implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* compiled from: FlowableIgnoreElementsCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14863b;

        a(h.c.e eVar) {
            this.a = eVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14863b.cancel();
            this.f14863b = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14863b == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14863b = h.c.n0.i.g.CANCELLED;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14863b = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14863b, dVar)) {
                this.f14863b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public q1(h.c.h<T> hVar) {
        this.a = hVar;
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new p1(this.a));
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.subscribe((h.c.m) new a(eVar));
    }
}