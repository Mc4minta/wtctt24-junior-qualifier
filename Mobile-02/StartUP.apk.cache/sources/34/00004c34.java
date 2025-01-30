package h.c.n0.e.b;

/* compiled from: FlowableMap.java */
/* loaded from: classes3.dex */
public final class a2<T, U> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends U> f14192b;

    /* compiled from: FlowableMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends h.c.n0.h.a<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends U> f14193f;

        a(h.c.n0.c.a<? super U> aVar, h.c.m0.n<? super T, ? extends U> nVar) {
            super(aVar);
            this.f14193f = nVar;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f16709d) {
                return false;
            }
            try {
                return this.a.h(h.c.n0.b.b.e(this.f14193f.apply(t), "The mapper function returned a null value."));
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
            if (this.f16709d) {
                return;
            }
            if (this.f16710e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(h.c.n0.b.b.e(this.f14193f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // h.c.n0.c.j
        public U poll() throws Exception {
            T poll = this.f16708c.poll();
            if (poll != null) {
                return (U) h.c.n0.b.b.e(this.f14193f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* compiled from: FlowableMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends h.c.n0.h.b<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends U> f14194f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(k.a.c<? super U> cVar, h.c.m0.n<? super T, ? extends U> nVar) {
            super(cVar);
            this.f14194f = nVar;
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
            if (this.f16714e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(h.c.n0.b.b.e(this.f14194f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // h.c.n0.c.j
        public U poll() throws Exception {
            T poll = this.f16712c.poll();
            if (poll != null) {
                return (U) h.c.n0.b.b.e(this.f14194f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public a2(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends U> nVar) {
        super(hVar);
        this.f14192b = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.c.h
    public void subscribeActual(k.a.c<? super U> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new a((h.c.n0.c.a) cVar, this.f14192b));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14192b));
        }
    }
}