package h.c.n0.e.b;

/* compiled from: FlowableFilter.java */
/* loaded from: classes3.dex */
public final class x0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f15204b;

    /* compiled from: FlowableFilter.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.p<? super T> f15205f;

        a(h.c.n0.c.a<? super T> aVar, h.c.m0.p<? super T> pVar) {
            super(aVar);
            this.f15205f = pVar;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f16709d) {
                return false;
            }
            if (this.f16710e != 0) {
                return this.a.h(null);
            }
            try {
                return this.f15205f.test(t) && this.a.h(t);
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
            h.c.n0.c.g<T> gVar = this.f16708c;
            h.c.m0.p<? super T> pVar = this.f15205f;
            while (true) {
                T poll = gVar.poll();
                if (poll == null) {
                    return null;
                }
                if (pVar.test(poll)) {
                    return poll;
                }
                if (this.f16710e == 2) {
                    gVar.request(1L);
                }
            }
        }
    }

    /* compiled from: FlowableFilter.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.h.b<T, T> implements h.c.n0.c.a<T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.p<? super T> f15206f;

        b(k.a.c<? super T> cVar, h.c.m0.p<? super T> pVar) {
            super(cVar);
            this.f15206f = pVar;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f16713d) {
                return false;
            }
            if (this.f16714e != 0) {
                this.a.onNext(null);
                return true;
            }
            try {
                boolean test = this.f15206f.test(t);
                if (test) {
                    this.a.onNext(t);
                }
                return test;
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
            h.c.n0.c.g<T> gVar = this.f16712c;
            h.c.m0.p<? super T> pVar = this.f15206f;
            while (true) {
                T poll = gVar.poll();
                if (poll == null) {
                    return null;
                }
                if (pVar.test(poll)) {
                    return poll;
                }
                if (this.f16714e == 2) {
                    gVar.request(1L);
                }
            }
        }
    }

    public x0(h.c.h<T> hVar, h.c.m0.p<? super T> pVar) {
        super(hVar);
        this.f15204b = pVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new a((h.c.n0.c.a) cVar, this.f15204b));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f15204b));
        }
    }
}