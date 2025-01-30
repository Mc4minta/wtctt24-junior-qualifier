package h.c.n0.e.e;

/* compiled from: ObservableSkip.java */
/* loaded from: classes3.dex */
public final class e3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15631b;

    /* compiled from: ObservableSkip.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        long f15632b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15633c;

        a(h.c.z<? super T> zVar, long j2) {
            this.a = zVar;
            this.f15632b = j2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15633c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15633c.isDisposed();
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
            long j2 = this.f15632b;
            if (j2 != 0) {
                this.f15632b = j2 - 1;
            } else {
                this.a.onNext(t);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15633c, bVar)) {
                this.f15633c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public e3(h.c.x<T> xVar, long j2) {
        super(xVar);
        this.f15631b = j2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15631b));
    }
}