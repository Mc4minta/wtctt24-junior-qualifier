package h.c.n0.e.e;

/* compiled from: ObservableLastMaybe.java */
/* loaded from: classes3.dex */
public final class s1<T> extends h.c.o<T> {
    final h.c.x<T> a;

    /* compiled from: ObservableLastMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16186b;

        /* renamed from: c  reason: collision with root package name */
        T f16187c;

        a(h.c.p<? super T> pVar) {
            this.a = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16186b.dispose();
            this.f16186b = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16186b == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16186b = h.c.n0.a.c.DISPOSED;
            T t = this.f16187c;
            if (t != null) {
                this.f16187c = null;
                this.a.onSuccess(t);
                return;
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16186b = h.c.n0.a.c.DISPOSED;
            this.f16187c = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f16187c = t;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16186b, bVar)) {
                this.f16186b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public s1(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe(new a(pVar));
    }
}