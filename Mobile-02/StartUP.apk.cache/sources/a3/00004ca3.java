package h.c.n0.e.b;

/* compiled from: FlowableTakeWhile.java */
/* loaded from: classes3.dex */
public final class g4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f14448b;

    /* compiled from: FlowableTakeWhile.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f14449b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14450c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14451d;

        a(k.a.c<? super T> cVar, h.c.m0.p<? super T> pVar) {
            this.a = cVar;
            this.f14449b = pVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14450c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14451d) {
                return;
            }
            this.f14451d = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14451d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14451d = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14451d) {
                return;
            }
            try {
                if (!this.f14449b.test(t)) {
                    this.f14451d = true;
                    this.f14450c.cancel();
                    this.a.onComplete();
                    return;
                }
                this.a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14450c.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14450c, dVar)) {
                this.f14450c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14450c.request(j2);
        }
    }

    public g4(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        super(hVar);
        this.f14448b = pVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14448b));
    }
}