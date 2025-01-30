package h.c.n0.e.e;

/* compiled from: ObservableAny.java */
/* loaded from: classes3.dex */
public final class i<T> extends h.c.n0.e.e.a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15782b;

    /* compiled from: ObservableAny.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f15783b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15784c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15785d;

        a(h.c.z<? super Boolean> zVar, h.c.m0.p<? super T> pVar) {
            this.a = zVar;
            this.f15783b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15784c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15784c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15785d) {
                return;
            }
            this.f15785d = true;
            this.a.onNext(Boolean.FALSE);
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15785d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15785d = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15785d) {
                return;
            }
            try {
                if (this.f15783b.test(t)) {
                    this.f15785d = true;
                    this.f15784c.dispose();
                    this.a.onNext(Boolean.TRUE);
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15784c.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15784c, bVar)) {
                this.f15784c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        super(xVar);
        this.f15782b = pVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super Boolean> zVar) {
        this.a.subscribe(new a(zVar, this.f15782b));
    }
}