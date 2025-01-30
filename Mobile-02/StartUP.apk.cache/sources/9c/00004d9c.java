package h.c.n0.e.b;

/* compiled from: FlowableReduceMaybe.java */
/* loaded from: classes3.dex */
public final class v2<T> extends h.c.o<T> implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<T, T, T> f15133b;

    /* compiled from: FlowableReduceMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<T, T, T> f15134b;

        /* renamed from: c  reason: collision with root package name */
        T f15135c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15136d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15137e;

        a(h.c.p<? super T> pVar, h.c.m0.c<T, T, T> cVar) {
            this.a = pVar;
            this.f15134b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15136d.cancel();
            this.f15137e = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15137e;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15137e) {
                return;
            }
            this.f15137e = true;
            T t = this.f15135c;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15137e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15137e = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15137e) {
                return;
            }
            T t2 = this.f15135c;
            if (t2 == null) {
                this.f15135c = t;
                return;
            }
            try {
                this.f15135c = (T) h.c.n0.b.b.e(this.f15134b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15136d.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15136d, dVar)) {
                this.f15136d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public v2(h.c.h<T> hVar, h.c.m0.c<T, T, T> cVar) {
        this.a = hVar;
        this.f15133b = cVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe((h.c.m) new a(pVar, this.f15133b));
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new u2(this.a, this.f15133b));
    }
}