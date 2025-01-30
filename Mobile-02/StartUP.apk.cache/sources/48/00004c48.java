package h.c.n0.e.b;

/* compiled from: FlowableTakeLastOne.java */
/* loaded from: classes3.dex */
public final class b4<T> extends h.c.n0.e.b.a<T, T> {

    /* compiled from: FlowableTakeLastOne.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<T> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14244c;

        a(k.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14244c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            T t = this.f16754b;
            if (t != null) {
                c(t);
            } else {
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f16754b = null;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f16754b = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14244c, dVar)) {
                this.f14244c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public b4(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}