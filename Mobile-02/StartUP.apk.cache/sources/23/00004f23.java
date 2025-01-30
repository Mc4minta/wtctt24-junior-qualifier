package h.c.n0.e.e;

/* compiled from: ObservableTakeWhile.java */
/* loaded from: classes3.dex */
public final class s3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super T> f16194b;

    /* compiled from: ObservableTakeWhile.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.p<? super T> f16195b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16196c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16197d;

        a(h.c.z<? super T> zVar, h.c.m0.p<? super T> pVar) {
            this.a = zVar;
            this.f16195b = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16196c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16196c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16197d) {
                return;
            }
            this.f16197d = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16197d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16197d = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16197d) {
                return;
            }
            try {
                if (!this.f16195b.test(t)) {
                    this.f16197d = true;
                    this.f16196c.dispose();
                    this.a.onComplete();
                    return;
                }
                this.a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16196c.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16196c, bVar)) {
                this.f16196c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public s3(h.c.x<T> xVar, h.c.m0.p<? super T> pVar) {
        super(xVar);
        this.f16194b = pVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16194b));
    }
}