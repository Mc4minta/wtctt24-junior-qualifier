package h.c.n0.e.e;

/* compiled from: ObservableDematerialize.java */
/* loaded from: classes3.dex */
public final class h0<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.r<R>> f15732b;

    /* compiled from: ObservableDematerialize.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.r<R>> f15733b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15734c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f15735d;

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.r<R>> nVar) {
            this.a = zVar;
            this.f15733b = nVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15735d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15735d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15734c) {
                return;
            }
            this.f15734c = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15734c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15734c = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15734c) {
                if (t instanceof h.c.r) {
                    h.c.r rVar = (h.c.r) t;
                    if (rVar.g()) {
                        h.c.r0.a.u(rVar.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                h.c.r rVar2 = (h.c.r) h.c.n0.b.b.e(this.f15733b.apply(t), "The selector returned a null Notification");
                if (rVar2.g()) {
                    this.f15735d.dispose();
                    onError(rVar2.d());
                } else if (rVar2.f()) {
                    this.f15735d.dispose();
                    onComplete();
                } else {
                    this.a.onNext((Object) rVar2.e());
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15735d.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15735d, bVar)) {
                this.f15735d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public h0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.r<R>> nVar) {
        super(xVar);
        this.f15732b = nVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        this.a.subscribe(new a(zVar, this.f15732b));
    }
}