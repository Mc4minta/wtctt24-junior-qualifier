package h.c.n0.e.g;

/* compiled from: SingleMap.java */
/* loaded from: classes3.dex */
public final class k0<T, R> extends h.c.b0<R> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends R> f16525b;

    /* compiled from: SingleMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.e0<T> {
        final h.c.e0<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends R> f16526b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h.c.e0<? super R> e0Var, h.c.m0.n<? super T, ? extends R> nVar) {
            this.a = e0Var;
            this.f16526b = nVar;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.onSubscribe(bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            try {
                this.a.onSuccess(h.c.n0.b.b.e(this.f16526b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(th);
            }
        }
    }

    public k0(h.c.h0<? extends T> h0Var, h.c.m0.n<? super T, ? extends R> nVar) {
        this.a = h0Var;
        this.f16525b = nVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16525b));
    }
}