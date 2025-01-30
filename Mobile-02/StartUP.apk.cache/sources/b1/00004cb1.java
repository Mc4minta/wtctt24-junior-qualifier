package h.c.n0.e.b;

/* compiled from: FlowableAny.java */
/* loaded from: classes3.dex */
public final class i<T> extends h.c.n0.e.b.a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f14482b;

    /* compiled from: FlowableAny.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<Boolean> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.p<? super T> f14483c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f14484d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14485e;

        a(k.a.c<? super Boolean> cVar, h.c.m0.p<? super T> pVar) {
            super(cVar);
            this.f14483c = pVar;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14484d.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14485e) {
                return;
            }
            this.f14485e = true;
            c(Boolean.FALSE);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14485e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14485e = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14485e) {
                return;
            }
            try {
                if (this.f14483c.test(t)) {
                    this.f14485e = true;
                    this.f14484d.cancel();
                    c(Boolean.TRUE);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14484d.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14484d, dVar)) {
                this.f14484d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public i(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        super(hVar);
        this.f14482b = pVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super Boolean> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14482b));
    }
}