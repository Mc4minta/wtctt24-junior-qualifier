package h.c.n0.e.b;

/* compiled from: FlowableAnySingle.java */
/* loaded from: classes3.dex */
public final class j<T> extends h.c.b0<Boolean> implements h.c.n0.c.b<Boolean> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f14529b;

    /* compiled from: FlowableAnySingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f14530b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14531c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14532d;

        a(h.c.e0<? super Boolean> e0Var, h.c.m0.p<? super T> pVar) {
            this.a = e0Var;
            this.f14530b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14531c.cancel();
            this.f14531c = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14531c == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14532d) {
                return;
            }
            this.f14532d = true;
            this.f14531c = h.c.n0.i.g.CANCELLED;
            this.a.onSuccess(Boolean.FALSE);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14532d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14532d = true;
            this.f14531c = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14532d) {
                return;
            }
            try {
                if (this.f14530b.test(t)) {
                    this.f14532d = true;
                    this.f14531c.cancel();
                    this.f14531c = h.c.n0.i.g.CANCELLED;
                    this.a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14531c.cancel();
                this.f14531c = h.c.n0.i.g.CANCELLED;
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14531c, dVar)) {
                this.f14531c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public j(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        this.a = hVar;
        this.f14529b = pVar;
    }

    @Override // h.c.n0.c.b
    public h.c.h<Boolean> e() {
        return h.c.r0.a.l(new i(this.a, this.f14529b));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        this.a.subscribe((h.c.m) new a(e0Var, this.f14529b));
    }
}