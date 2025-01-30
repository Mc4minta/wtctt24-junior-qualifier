package h.c.n0.e.b;

/* compiled from: FlowableSingleMaybe.java */
/* loaded from: classes3.dex */
public final class p3<T> extends h.c.o<T> implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* compiled from: FlowableSingleMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14829b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14830c;

        /* renamed from: d  reason: collision with root package name */
        T f14831d;

        a(h.c.p<? super T> pVar) {
            this.a = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14829b.cancel();
            this.f14829b = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14829b == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14830c) {
                return;
            }
            this.f14830c = true;
            this.f14829b = h.c.n0.i.g.CANCELLED;
            T t = this.f14831d;
            this.f14831d = null;
            if (t == null) {
                this.a.onComplete();
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14830c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14830c = true;
            this.f14829b = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14830c) {
                return;
            }
            if (this.f14831d != null) {
                this.f14830c = true;
                this.f14829b.cancel();
                this.f14829b = h.c.n0.i.g.CANCELLED;
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f14831d = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14829b, dVar)) {
                this.f14829b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public p3(h.c.h<T> hVar) {
        this.a = hVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe((h.c.m) new a(pVar));
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new o3(this.a, null, false));
    }
}