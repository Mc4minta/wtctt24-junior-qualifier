package h.c.n0.e.g;

/* compiled from: SingleDoOnSuccess.java */
/* loaded from: classes3.dex */
public final class t<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f16569b;

    /* compiled from: SingleDoOnSuccess.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.e0<T> {
        final h.c.e0<? super T> a;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
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
                t.this.f16569b.accept(t);
                this.a.onSuccess(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public t(h.c.h0<T> h0Var, h.c.m0.f<? super T> fVar) {
        this.a = h0Var;
        this.f16569b = fVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}