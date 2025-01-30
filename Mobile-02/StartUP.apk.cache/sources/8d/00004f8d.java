package h.c.n0.e.g;

/* compiled from: SingleContains.java */
/* loaded from: classes3.dex */
public final class c<T> extends h.c.b0<Boolean> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Object f16487b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<Object, Object> f16488c;

    /* compiled from: SingleContains.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.e0<T> {
        private final h.c.e0<? super Boolean> a;

        a(h.c.e0<? super Boolean> e0Var) {
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
                c cVar = c.this;
                this.a.onSuccess(Boolean.valueOf(cVar.f16488c.a(t, cVar.f16487b)));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public c(h.c.h0<T> h0Var, Object obj, h.c.m0.d<Object, Object> dVar) {
        this.a = h0Var;
        this.f16487b = obj;
        this.f16488c = dVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}