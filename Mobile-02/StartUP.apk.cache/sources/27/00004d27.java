package h.c.n0.e.b;

/* compiled from: FlowableDoFinally.java */
/* loaded from: classes3.dex */
public final class p0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.a f14817b;

    /* compiled from: FlowableDoFinally.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.a<T> implements h.c.n0.c.a<T> {
        final h.c.n0.c.a<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.a f14818b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14819c;

        /* renamed from: d  reason: collision with root package name */
        h.c.n0.c.g<T> f14820d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14821e;

        a(h.c.n0.c.a<? super T> aVar, h.c.m0.a aVar2) {
            this.a = aVar;
            this.f14818b = aVar2;
        }

        void c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f14818b.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f14819c.cancel();
            c();
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f14820d.clear();
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            return this.a.h(t);
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f14820d.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            h.c.n0.c.g<T> gVar = this.f14820d;
            if (gVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int n = gVar.n(i2);
            if (n != 0) {
                this.f14821e = n == 1;
            }
            return n;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
            c();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
            c();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14819c, dVar)) {
                this.f14819c = dVar;
                if (dVar instanceof h.c.n0.c.g) {
                    this.f14820d = (h.c.n0.c.g) dVar;
                }
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f14820d.poll();
            if (poll == null && this.f14821e) {
                c();
            }
            return poll;
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14819c.request(j2);
        }
    }

    /* compiled from: FlowableDoFinally.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.i.a<T> implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.a f14822b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14823c;

        /* renamed from: d  reason: collision with root package name */
        h.c.n0.c.g<T> f14824d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14825e;

        b(k.a.c<? super T> cVar, h.c.m0.a aVar) {
            this.a = cVar;
            this.f14822b = aVar;
        }

        void c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f14822b.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f14823c.cancel();
            c();
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f14824d.clear();
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f14824d.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            h.c.n0.c.g<T> gVar = this.f14824d;
            if (gVar == null || (i2 & 4) != 0) {
                return 0;
            }
            int n = gVar.n(i2);
            if (n != 0) {
                this.f14825e = n == 1;
            }
            return n;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
            c();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
            c();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14823c, dVar)) {
                this.f14823c = dVar;
                if (dVar instanceof h.c.n0.c.g) {
                    this.f14824d = (h.c.n0.c.g) dVar;
                }
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f14824d.poll();
            if (poll == null && this.f14825e) {
                c();
            }
            return poll;
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14823c.request(j2);
        }
    }

    public p0(h.c.h<T> hVar, h.c.m0.a aVar) {
        super(hVar);
        this.f14817b = aVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new a((h.c.n0.c.a) cVar, this.f14817b));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14817b));
        }
    }
}