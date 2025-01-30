package h.c.n0.e.b;

/* compiled from: FlowableReduce.java */
/* loaded from: classes3.dex */
public final class u2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<T, T, T> f15093b;

    /* compiled from: FlowableReduce.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<T> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.c<T, T, T> f15094c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15095d;

        a(k.a.c<? super T> cVar, h.c.m0.c<T, T, T> cVar2) {
            super(cVar);
            this.f15094c = cVar2;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f15095d.cancel();
            this.f15095d = h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            k.a.d dVar = this.f15095d;
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar == gVar) {
                return;
            }
            this.f15095d = gVar;
            T t = this.f16754b;
            if (t != null) {
                c(t);
            } else {
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            k.a.d dVar = this.f15095d;
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar == gVar) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15095d = gVar;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15095d == h.c.n0.i.g.CANCELLED) {
                return;
            }
            T t2 = this.f16754b;
            if (t2 == null) {
                this.f16754b = t;
                return;
            }
            try {
                this.f16754b = (T) h.c.n0.b.b.e(this.f15094c.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15095d.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15095d, dVar)) {
                this.f15095d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public u2(h.c.h<T> hVar, h.c.m0.c<T, T, T> cVar) {
        super(hVar);
        this.f15093b = cVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15093b));
    }
}