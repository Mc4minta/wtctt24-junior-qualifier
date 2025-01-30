package h.c.n0.e.b;

/* compiled from: FlowableCount.java */
/* loaded from: classes3.dex */
public final class c0<T> extends h.c.n0.e.b.a<T, Long> {

    /* compiled from: FlowableCount.java */
    /* loaded from: classes3.dex */
    static final class a extends h.c.n0.i.c<Long> implements h.c.m<Object> {

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14248c;

        /* renamed from: d  reason: collision with root package name */
        long f14249d;

        a(k.a.c<? super Long> cVar) {
            super(cVar);
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14248c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            c(Long.valueOf(this.f14249d));
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            this.f14249d++;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14248c, dVar)) {
                this.f14248c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public c0(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super Long> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}