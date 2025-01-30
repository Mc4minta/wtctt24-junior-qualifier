package h.c.n0.e.g;

/* compiled from: SingleToObservable.java */
/* loaded from: classes3.dex */
public final class v0<T> extends h.c.s<T> {
    final h.c.h0<? extends T> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleToObservable.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends h.c.n0.d.l<T> implements h.c.e0<T> {

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16581c;

        a(h.c.z<? super T> zVar) {
            super(zVar);
        }

        @Override // h.c.n0.d.l, h.c.k0.b
        public void dispose() {
            super.dispose();
            this.f16581c.dispose();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            c(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16581c, bVar)) {
                this.f16581c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            b(t);
        }
    }

    public v0(h.c.h0<? extends T> h0Var) {
        this.a = h0Var;
    }

    public static <T> h.c.e0<T> b(h.c.z<? super T> zVar) {
        return new a(zVar);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(b(zVar));
    }
}