package h.c.n0.e.b;

/* compiled from: FlowableSkipWhile.java */
/* loaded from: classes3.dex */
public final class v3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15138b;

    /* compiled from: FlowableSkipWhile.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f15139b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f15140c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15141d;

        a(k.a.c<? super T> cVar, h.c.m0.p<? super T> pVar) {
            this.a = cVar;
            this.f15139b = pVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f15140c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15141d) {
                this.a.onNext(t);
                return;
            }
            try {
                if (this.f15139b.test(t)) {
                    this.f15140c.request(1L);
                    return;
                }
                this.f15141d = true;
                this.a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15140c.cancel();
                this.a.onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15140c, dVar)) {
                this.f15140c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f15140c.request(j2);
        }
    }

    public v3(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        super(hVar);
        this.f15138b = pVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15138b));
    }
}