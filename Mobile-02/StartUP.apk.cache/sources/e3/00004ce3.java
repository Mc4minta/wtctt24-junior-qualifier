package h.c.n0.e.b;

/* compiled from: FlowableDetach.java */
/* loaded from: classes3.dex */
public final class l0<T> extends h.c.n0.e.b.a<T, T> {

    /* compiled from: FlowableDetach.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14627b;

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            k.a.d dVar = this.f14627b;
            this.f14627b = h.c.n0.j.g.INSTANCE;
            this.a = h.c.n0.j.g.q();
            dVar.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            k.a.c<? super T> cVar = this.a;
            this.f14627b = h.c.n0.j.g.INSTANCE;
            this.a = h.c.n0.j.g.q();
            cVar.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            k.a.c<? super T> cVar = this.a;
            this.f14627b = h.c.n0.j.g.INSTANCE;
            this.a = h.c.n0.j.g.q();
            cVar.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14627b, dVar)) {
                this.f14627b = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14627b.request(j2);
        }
    }

    public l0(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}