package h.c.n0.e.b;

/* compiled from: FlowableAll.java */
/* loaded from: classes3.dex */
public final class f<T> extends h.c.n0.e.b.a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f14377b;

    /* compiled from: FlowableAll.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<Boolean> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.p<? super T> f14378c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f14379d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14380e;

        a(k.a.c<? super Boolean> cVar, h.c.m0.p<? super T> pVar) {
            super(cVar);
            this.f14378c = pVar;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14379d.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14380e) {
                return;
            }
            this.f14380e = true;
            c(Boolean.TRUE);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14380e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14380e = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14380e) {
                return;
            }
            try {
                if (this.f14378c.test(t)) {
                    return;
                }
                this.f14380e = true;
                this.f14379d.cancel();
                c(Boolean.FALSE);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14379d.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14379d, dVar)) {
                this.f14379d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public f(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        super(hVar);
        this.f14377b = pVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super Boolean> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14377b));
    }
}