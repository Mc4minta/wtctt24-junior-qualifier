package h.c.n0.e.g;

/* compiled from: SingleDetach.java */
/* loaded from: classes3.dex */
public final class l<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* compiled from: SingleDetach.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.e0<T>, h.c.k0.b {
        h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16527b;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.a = null;
            this.f16527b.dispose();
            this.f16527b = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16527b.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f16527b = h.c.n0.a.c.DISPOSED;
            h.c.e0<? super T> e0Var = this.a;
            if (e0Var != null) {
                this.a = null;
                e0Var.onError(th);
            }
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16527b, bVar)) {
                this.f16527b = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.f16527b = h.c.n0.a.c.DISPOSED;
            h.c.e0<? super T> e0Var = this.a;
            if (e0Var != null) {
                this.a = null;
                e0Var.onSuccess(t);
            }
        }
    }

    public l(h.c.h0<T> h0Var) {
        this.a = h0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}