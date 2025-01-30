package h.c.n0.e.e;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes3.dex */
public final class g0<T, U> extends h.c.s<T> {
    final h.c.x<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<U> f15691b;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.z<U> {
        final h.c.n0.a.g a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.z<? super T> f15692b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15693c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: h.c.n0.e.e.g0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0380a implements h.c.z<T> {
            C0380a() {
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                a.this.f15692b.onComplete();
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                a.this.f15692b.onError(th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(T t) {
                a.this.f15692b.onNext(t);
            }

            @Override // h.c.z
            public void onSubscribe(h.c.k0.b bVar) {
                a.this.a.b(bVar);
            }
        }

        a(h.c.n0.a.g gVar, h.c.z<? super T> zVar) {
            this.a = gVar;
            this.f15692b = zVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15693c) {
                return;
            }
            this.f15693c = true;
            g0.this.a.subscribe(new C0380a());
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15693c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15693c = true;
            this.f15692b.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(U u) {
            onComplete();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.b(bVar);
        }
    }

    public g0(h.c.x<? extends T> xVar, h.c.x<U> xVar2) {
        this.a = xVar;
        this.f15691b = xVar2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.a.g gVar = new h.c.n0.a.g();
        zVar.onSubscribe(gVar);
        this.f15691b.subscribe(new a(gVar, zVar));
    }
}