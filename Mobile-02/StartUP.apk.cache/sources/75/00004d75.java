package h.c.n0.e.b;

/* compiled from: FlowableElementAtMaybe.java */
/* loaded from: classes3.dex */
public final class t0<T> extends h.c.o<T> implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f15023b;

    /* compiled from: FlowableElementAtMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15024b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f15025c;

        /* renamed from: d  reason: collision with root package name */
        long f15026d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15027e;

        a(h.c.p<? super T> pVar, long j2) {
            this.a = pVar;
            this.f15024b = j2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15025c.cancel();
            this.f15025c = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15025c == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15025c = h.c.n0.i.g.CANCELLED;
            if (this.f15027e) {
                return;
            }
            this.f15027e = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15027e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15027e = true;
            this.f15025c = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15027e) {
                return;
            }
            long j2 = this.f15026d;
            if (j2 == this.f15024b) {
                this.f15027e = true;
                this.f15025c.cancel();
                this.f15025c = h.c.n0.i.g.CANCELLED;
                this.a.onSuccess(t);
                return;
            }
            this.f15026d = j2 + 1;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15025c, dVar)) {
                this.f15025c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public t0(h.c.h<T> hVar, long j2) {
        this.a = hVar;
        this.f15023b = j2;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe((h.c.m) new a(pVar, this.f15023b));
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new s0(this.a, this.f15023b, null, false));
    }
}