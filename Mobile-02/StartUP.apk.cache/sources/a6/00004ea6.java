package h.c.n0.e.e;

/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes3.dex */
public final class k3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<? extends T> f15878b;

    /* compiled from: ObservableSwitchIfEmpty.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.x<? extends T> f15879b;

        /* renamed from: d  reason: collision with root package name */
        boolean f15881d = true;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.a.g f15880c = new h.c.n0.a.g();

        a(h.c.z<? super T> zVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f15879b = xVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15881d) {
                this.f15881d = false;
                this.f15879b.subscribe(this);
                return;
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15881d) {
                this.f15881d = false;
            }
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f15880c.b(bVar);
        }
    }

    public k3(h.c.x<T> xVar, h.c.x<? extends T> xVar2) {
        super(xVar);
        this.f15878b = xVar2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar, this.f15878b);
        zVar.onSubscribe(aVar.f15880c);
        this.a.subscribe(aVar);
    }
}