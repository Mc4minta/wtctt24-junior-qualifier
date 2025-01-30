package h.c.n0.e.e;

/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes3.dex */
public final class c3<T> extends h.c.o<T> {
    final h.c.x<T> a;

    /* compiled from: ObservableSingleMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15557b;

        /* renamed from: c  reason: collision with root package name */
        T f15558c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15559d;

        a(h.c.p<? super T> pVar) {
            this.a = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15557b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15557b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15559d) {
                return;
            }
            this.f15559d = true;
            T t = this.f15558c;
            this.f15558c = null;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15559d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15559d = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15559d) {
                return;
            }
            if (this.f15558c != null) {
                this.f15559d = true;
                this.f15557b.dispose();
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f15558c = t;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15557b, bVar)) {
                this.f15557b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public c3(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // h.c.o
    public void d(h.c.p<? super T> pVar) {
        this.a.subscribe(new a(pVar));
    }
}