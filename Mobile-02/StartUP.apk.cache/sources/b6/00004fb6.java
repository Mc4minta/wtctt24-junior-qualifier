package h.c.n0.e.g;

/* compiled from: SingleDoAfterTerminate.java */
/* loaded from: classes3.dex */
public final class n<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.a f16531b;

    /* compiled from: SingleDoAfterTerminate.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.a f16532b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16533c;

        a(h.c.e0<? super T> e0Var, h.c.m0.a aVar) {
            this.a = e0Var;
            this.f16532b = aVar;
        }

        private void a() {
            try {
                this.f16532b.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16533c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16533c.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
            a();
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16533c, bVar)) {
                this.f16533c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
            a();
        }
    }

    public n(h.c.h0<T> h0Var, h.c.m0.a aVar) {
        this.a = h0Var;
        this.f16531b = aVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16531b));
    }
}