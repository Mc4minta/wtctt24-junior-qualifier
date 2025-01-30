package h.c.n0.e.e;

/* compiled from: ObservableScan.java */
/* loaded from: classes3.dex */
public final class x2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<T, T, T> f16376b;

    /* compiled from: ObservableScan.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<T, T, T> f16377b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16378c;

        /* renamed from: d  reason: collision with root package name */
        T f16379d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16380e;

        a(h.c.z<? super T> zVar, h.c.m0.c<T, T, T> cVar) {
            this.a = zVar;
            this.f16377b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16378c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16378c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16380e) {
                return;
            }
            this.f16380e = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16380e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16380e = true;
            this.a.onError(th);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16380e) {
                return;
            }
            h.c.z<? super T> zVar = this.a;
            T t2 = this.f16379d;
            if (t2 == null) {
                this.f16379d = t;
                zVar.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) h.c.n0.b.b.e(this.f16377b.apply(t2, t), "The value returned by the accumulator is null");
                this.f16379d = r4;
                zVar.onNext(r4);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16378c.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16378c, bVar)) {
                this.f16378c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public x2(h.c.x<T> xVar, h.c.m0.c<T, T, T> cVar) {
        super(xVar);
        this.f16376b = cVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16376b));
    }
}