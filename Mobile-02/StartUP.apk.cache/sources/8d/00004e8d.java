package h.c.n0.e.e;

/* compiled from: ObservableAnySingle.java */
/* loaded from: classes3.dex */
public final class j<T> extends h.c.b0<Boolean> implements h.c.n0.c.d<Boolean> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15822b;

    /* compiled from: ObservableAnySingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f15823b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15824c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15825d;

        a(h.c.e0<? super Boolean> e0Var, h.c.m0.p<? super T> pVar) {
            this.a = e0Var;
            this.f15823b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15824c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15824c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15825d) {
                return;
            }
            this.f15825d = true;
            this.a.onSuccess(Boolean.FALSE);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15825d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15825d = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15825d) {
                return;
            }
            try {
                if (this.f15823b.test(t)) {
                    this.f15825d = true;
                    this.f15824c.dispose();
                    this.a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15824c.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15824c, bVar)) {
                this.f15824c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public j(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        this.a = xVar;
        this.f15822b = pVar;
    }

    @Override // h.c.n0.c.d
    public h.c.s<Boolean> a() {
        return h.c.r0.a.n(new i(this.a, this.f15822b));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        this.a.subscribe(new a(e0Var, this.f15822b));
    }
}