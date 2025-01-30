package h.c.n0.e.e;

/* compiled from: ObservableReduceMaybe.java */
/* loaded from: classes3.dex */
public final class j2<T> extends h.c.o<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<T, T, T> f15847b;

    /* compiled from: ObservableReduceMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<T, T, T> f15848b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15849c;

        /* renamed from: d  reason: collision with root package name */
        T f15850d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f15851e;

        a(h.c.p<? super T> pVar, h.c.m0.c<T, T, T> cVar) {
            this.a = pVar;
            this.f15848b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15851e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15851e.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15849c) {
                return;
            }
            this.f15849c = true;
            T t = this.f15850d;
            this.f15850d = null;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15849c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15849c = true;
            this.f15850d = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15849c) {
                return;
            }
            T t2 = this.f15850d;
            if (t2 == null) {
                this.f15850d = t;
                return;
            }
            try {
                this.f15850d = (T) h.c.n0.b.b.e(this.f15848b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15851e.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15851e, bVar)) {
                this.f15851e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public j2(h.c.x<T> xVar, h.c.m0.c<T, T, T> cVar) {
        this.a = xVar;
        this.f15847b = cVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe(new a(pVar, this.f15847b));
    }
}