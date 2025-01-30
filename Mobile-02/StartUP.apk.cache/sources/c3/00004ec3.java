package h.c.n0.e.e;

/* compiled from: ObservableTake.java */
/* loaded from: classes3.dex */
public final class m3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15969b;

    /* compiled from: ObservableTake.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15970b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15971c;

        /* renamed from: d  reason: collision with root package name */
        long f15972d;

        a(h.c.z<? super T> zVar, long j2) {
            this.a = zVar;
            this.f15972d = j2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15971c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15971c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15970b) {
                return;
            }
            this.f15970b = true;
            this.f15971c.dispose();
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15970b) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15970b = true;
            this.f15971c.dispose();
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15970b) {
                return;
            }
            long j2 = this.f15972d;
            long j3 = j2 - 1;
            this.f15972d = j3;
            if (j2 > 0) {
                boolean z = j3 == 0;
                this.a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15971c, bVar)) {
                this.f15971c = bVar;
                if (this.f15972d == 0) {
                    this.f15970b = true;
                    bVar.dispose();
                    h.c.n0.a.d.q(this.a);
                    return;
                }
                this.a.onSubscribe(this);
            }
        }
    }

    public m3(h.c.x<T> xVar, long j2) {
        super(xVar);
        this.f15969b = j2;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15969b));
    }
}