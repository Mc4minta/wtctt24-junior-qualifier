package h.c.n0.e.e;

/* compiled from: ObservableSkipWhile.java */
/* loaded from: classes3.dex */
public final class i3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15812b;

    /* compiled from: ObservableSkipWhile.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f15813b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15814c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15815d;

        a(h.c.z<? super T> zVar, h.c.m0.p<? super T> pVar) {
            this.a = zVar;
            this.f15813b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15814c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15814c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15815d) {
                this.a.onNext(t);
                return;
            }
            try {
                if (this.f15813b.test(t)) {
                    return;
                }
                this.f15815d = true;
                this.a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15814c.dispose();
                this.a.onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15814c, bVar)) {
                this.f15814c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i3(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        super(xVar);
        this.f15812b = pVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15812b));
    }
}