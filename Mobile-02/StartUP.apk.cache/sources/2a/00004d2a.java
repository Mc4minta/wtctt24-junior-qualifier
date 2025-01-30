package h.c.n0.e.b;

/* compiled from: FlowableIgnoreElements.java */
/* loaded from: classes3.dex */
public final class p1<T> extends h.c.n0.e.b.a<T, T> {

    /* compiled from: FlowableIgnoreElements.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.n0.c.g<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14826b;

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14826b.cancel();
        }

        @Override // h.c.n0.c.j
        public void clear() {
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return true;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return i2 & 2;
        }

        @Override // h.c.n0.c.j
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14826b, dVar)) {
                this.f14826b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() {
            return null;
        }

        @Override // k.a.d
        public void request(long j2) {
        }
    }

    public p1(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}