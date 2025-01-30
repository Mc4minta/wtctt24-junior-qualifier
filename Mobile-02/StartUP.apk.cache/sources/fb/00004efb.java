package h.c.n0.e.e;

/* compiled from: ObservableElementAtMaybe.java */
/* loaded from: classes3.dex */
public final class q0<T> extends h.c.o<T> implements h.c.n0.c.d<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f16111b;

    /* compiled from: ObservableElementAtMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16112b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16113c;

        /* renamed from: d  reason: collision with root package name */
        long f16114d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16115e;

        a(h.c.p<? super T> pVar, long j2) {
            this.a = pVar;
            this.f16112b = j2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16113c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16113c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16115e) {
                return;
            }
            this.f16115e = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16115e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16115e = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16115e) {
                return;
            }
            long j2 = this.f16114d;
            if (j2 == this.f16112b) {
                this.f16115e = true;
                this.f16113c.dispose();
                this.a.onSuccess(t);
                return;
            }
            this.f16114d = j2 + 1;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16113c, bVar)) {
                this.f16113c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public q0(h.c.x<T> xVar, long j2) {
        this.a = xVar;
        this.f16111b = j2;
    }

    @Override // h.c.n0.c.d
    public h.c.s<T> a() {
        return h.c.r0.a.n(new p0(this.a, this.f16111b, null, false));
    }

    @Override // h.c.o
    public void d(h.c.p<? super T> pVar) {
        this.a.subscribe(new a(pVar, this.f16111b));
    }
}