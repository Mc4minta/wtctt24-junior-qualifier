package h.c.n0.e.b;

/* compiled from: FlowableDistinctUntilChanged.java */
/* loaded from: classes3.dex */
public final class n0<T, K> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, K> f14737b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<? super K, ? super K> f14738c;

    /* compiled from: FlowableDistinctUntilChanged.java */
    /* loaded from: classes3.dex */
    static final class a<T, K> extends h.c.n0.h.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, K> f14739f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.d<? super K, ? super K> f14740g;

        /* renamed from: h  reason: collision with root package name */
        K f14741h;

        /* renamed from: j  reason: collision with root package name */
        boolean f14742j;

        a(h.c.n0.c.a<? super T> aVar, h.c.m0.n<? super T, K> nVar, h.c.m0.d<? super K, ? super K> dVar) {
            super(aVar);
            this.f14739f = nVar;
            this.f14740g = dVar;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f16709d) {
                return false;
            }
            if (this.f16710e != 0) {
                return this.a.h(t);
            }
            try {
                K apply = this.f14739f.apply(t);
                if (this.f14742j) {
                    boolean a = this.f14740g.a((K) this.f14741h, apply);
                    this.f14741h = apply;
                    if (a) {
                        return false;
                    }
                } else {
                    this.f14742j = true;
                    this.f14741h = apply;
                }
                this.a.onNext(t);
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (h(t)) {
                return;
            }
            this.f16707b.request(1L);
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            while (true) {
                T poll = this.f16708c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f14739f.apply(poll);
                if (!this.f14742j) {
                    this.f14742j = true;
                    this.f14741h = apply;
                    return poll;
                } else if (!this.f14740g.a((K) this.f14741h, apply)) {
                    this.f14741h = apply;
                    return poll;
                } else {
                    this.f14741h = apply;
                    if (this.f16710e != 1) {
                        this.f16707b.request(1L);
                    }
                }
            }
        }
    }

    /* compiled from: FlowableDistinctUntilChanged.java */
    /* loaded from: classes3.dex */
    static final class b<T, K> extends h.c.n0.h.b<T, T> implements h.c.n0.c.a<T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, K> f14743f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.d<? super K, ? super K> f14744g;

        /* renamed from: h  reason: collision with root package name */
        K f14745h;

        /* renamed from: j  reason: collision with root package name */
        boolean f14746j;

        b(k.a.c<? super T> cVar, h.c.m0.n<? super T, K> nVar, h.c.m0.d<? super K, ? super K> dVar) {
            super(cVar);
            this.f14743f = nVar;
            this.f14744g = dVar;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f16713d) {
                return false;
            }
            if (this.f16714e != 0) {
                this.a.onNext(t);
                return true;
            }
            try {
                K apply = this.f14743f.apply(t);
                if (this.f14746j) {
                    boolean a = this.f14744g.a((K) this.f14745h, apply);
                    this.f14745h = apply;
                    if (a) {
                        return false;
                    }
                } else {
                    this.f14746j = true;
                    this.f14745h = apply;
                }
                this.a.onNext(t);
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (h(t)) {
                return;
            }
            this.f16711b.request(1L);
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            while (true) {
                T poll = this.f16712c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f14743f.apply(poll);
                if (!this.f14746j) {
                    this.f14746j = true;
                    this.f14745h = apply;
                    return poll;
                } else if (!this.f14744g.a((K) this.f14745h, apply)) {
                    this.f14745h = apply;
                    return poll;
                } else {
                    this.f14745h = apply;
                    if (this.f16714e != 1) {
                        this.f16711b.request(1L);
                    }
                }
            }
        }
    }

    public n0(h.c.h<T> hVar, h.c.m0.n<? super T, K> nVar, h.c.m0.d<? super K, ? super K> dVar) {
        super(hVar);
        this.f14737b = nVar;
        this.f14738c = dVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new a((h.c.n0.c.a) cVar, this.f14737b, this.f14738c));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14737b, this.f14738c));
        }
    }
}