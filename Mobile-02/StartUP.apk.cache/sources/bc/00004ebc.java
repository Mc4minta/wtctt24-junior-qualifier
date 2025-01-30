package h.c.n0.e.e;

/* compiled from: ObservableDoFinally.java */
/* loaded from: classes3.dex */
public final class m0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.a f15951b;

    /* compiled from: ObservableDoFinally.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.b<T> implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.a f15952b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15953c;

        /* renamed from: d  reason: collision with root package name */
        h.c.n0.c.e<T> f15954d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15955e;

        a(h.c.z<? super T> zVar, h.c.m0.a aVar) {
            this.a = zVar;
            this.f15952b = aVar;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f15952b.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15954d.clear();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15953c.dispose();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15953c.isDisposed();
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f15954d.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            h.c.n0.c.e<T> eVar = this.f15954d;
            if (eVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int n = eVar.n(i2);
            if (n != 0) {
                this.f15955e = n == 1;
            }
            return n;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
            a();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15953c, bVar)) {
                this.f15953c = bVar;
                if (bVar instanceof h.c.n0.c.e) {
                    this.f15954d = (h.c.n0.c.e) bVar;
                }
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f15954d.poll();
            if (poll == null && this.f15955e) {
                a();
            }
            return poll;
        }
    }

    public m0(h.c.x<T> xVar, h.c.m0.a aVar) {
        super(xVar);
        this.f15951b = aVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15951b));
    }
}