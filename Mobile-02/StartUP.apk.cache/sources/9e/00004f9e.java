package h.c.n0.e.g;

/* compiled from: SingleHide.java */
/* loaded from: classes3.dex */
public final class g0<T> extends h.c.b0<T> {
    final h.c.h0<? extends T> a;

    /* compiled from: SingleHide.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16508b;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16508b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16508b.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16508b, bVar)) {
                this.f16508b = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public g0(h.c.h0<? extends T> h0Var) {
        this.a = h0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}