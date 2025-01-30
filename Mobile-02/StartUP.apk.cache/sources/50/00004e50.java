package h.c.n0.e.e;

/* compiled from: ObservableFromPublisher.java */
/* loaded from: classes3.dex */
public final class f1<T> extends h.c.s<T> {
    final k.a.b<? extends T> a;

    /* compiled from: ObservableFromPublisher.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f15663b;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15663b.cancel();
            this.f15663b = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15663b == h.c.n0.i.g.CANCELLED;
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
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15663b, dVar)) {
                this.f15663b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public f1(k.a.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar));
    }
}