package h.c.n0.e.b;

/* compiled from: FlowableCountSingle.java */
/* loaded from: classes3.dex */
public final class d0<T> extends h.c.b0<Long> implements h.c.n0.c.b<Long> {
    final h.c.h<T> a;

    /* compiled from: FlowableCountSingle.java */
    /* loaded from: classes3.dex */
    static final class a implements h.c.m<Object>, h.c.k0.b {
        final h.c.e0<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14306b;

        /* renamed from: c  reason: collision with root package name */
        long f14307c;

        a(h.c.e0<? super Long> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14306b.cancel();
            this.f14306b = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14306b == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14306b = h.c.n0.i.g.CANCELLED;
            this.a.onSuccess(Long.valueOf(this.f14307c));
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14306b = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            this.f14307c++;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14306b, dVar)) {
                this.f14306b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public d0(h.c.h<T> hVar) {
        this.a = hVar;
    }

    @Override // h.c.n0.c.b
    public h.c.h<Long> e() {
        return h.c.r0.a.l(new c0(this.a));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Long> e0Var) {
        this.a.subscribe((h.c.m) new a(e0Var));
    }
}