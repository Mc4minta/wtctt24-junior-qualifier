package h.c.n0.e.b;

/* compiled from: FlowableTakeUntilPredicate.java */
/* loaded from: classes3.dex */
public final class f4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f14408b;

    /* compiled from: FlowableTakeUntilPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f14409b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14410c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14411d;

        a(k.a.c<? super T> cVar, h.c.m0.p<? super T> pVar) {
            this.a = cVar;
            this.f14409b = pVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14410c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14411d) {
                return;
            }
            this.f14411d = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (!this.f14411d) {
                this.f14411d = true;
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14411d) {
                return;
            }
            this.a.onNext(t);
            try {
                if (this.f14409b.test(t)) {
                    this.f14411d = true;
                    this.f14410c.cancel();
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14410c.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14410c, dVar)) {
                this.f14410c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14410c.request(j2);
        }
    }

    public f4(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        super(hVar);
        this.f14408b = pVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14408b));
    }
}