package h.c.n0.e.b;

/* compiled from: FlowableDoAfterNext.java */
/* loaded from: classes3.dex */
public final class o0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f14779b;

    /* compiled from: FlowableDoAfterNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.f<? super T> f14780f;

        a(h.c.n0.c.a<? super T> aVar, h.c.m0.f<? super T> fVar) {
            super(aVar);
            this.f14780f = fVar;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            boolean h2 = this.a.h(t);
            try {
                this.f14780f.accept(t);
            } catch (Throwable th) {
                c(th);
            }
            return h2;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
            if (this.f16710e == 0) {
                try {
                    this.f14780f.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f16708c.poll();
            if (poll != null) {
                this.f14780f.accept(poll);
            }
            return poll;
        }
    }

    /* compiled from: FlowableDoAfterNext.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.h.b<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.f<? super T> f14781f;

        b(k.a.c<? super T> cVar, h.c.m0.f<? super T> fVar) {
            super(cVar);
            this.f14781f = fVar;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f16713d) {
                return;
            }
            this.a.onNext(t);
            if (this.f16714e == 0) {
                try {
                    this.f14781f.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f16712c.poll();
            if (poll != null) {
                this.f14781f.accept(poll);
            }
            return poll;
        }
    }

    public o0(h.c.h<T> hVar, h.c.m0.f<? super T> fVar) {
        super(hVar);
        this.f14779b = fVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new a((h.c.n0.c.a) cVar, this.f14779b));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14779b));
        }
    }
}