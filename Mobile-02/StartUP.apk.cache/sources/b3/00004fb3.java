package h.c.n0.e.g;

/* compiled from: SingleDoAfterSuccess.java */
/* loaded from: classes3.dex */
public final class m<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f16528b;

    /* compiled from: SingleDoAfterSuccess.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.f<? super T> f16529b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16530c;

        a(h.c.e0<? super T> e0Var, h.c.m0.f<? super T> fVar) {
            this.a = e0Var;
            this.f16529b = fVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16530c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16530c.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16530c, bVar)) {
                this.f16530c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
            try {
                this.f16529b.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
        }
    }

    public m(h.c.h0<T> h0Var, h.c.m0.f<? super T> fVar) {
        this.a = h0Var;
        this.f16528b = fVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16528b));
    }
}