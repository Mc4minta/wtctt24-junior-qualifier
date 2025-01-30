package h.c.n0.e.g;

/* compiled from: SingleToFlowable.java */
/* loaded from: classes3.dex */
public final class u0<T> extends h.c.h<T> {
    final h.c.h0<? extends T> a;

    /* compiled from: SingleToFlowable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<T> implements h.c.e0<T> {

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16575c;

        a(k.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f16575c.dispose();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16575c, bVar)) {
                this.f16575c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            c(t);
        }
    }

    public u0(h.c.h0<? extends T> h0Var) {
        this.a = h0Var;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe(new a(cVar));
    }
}