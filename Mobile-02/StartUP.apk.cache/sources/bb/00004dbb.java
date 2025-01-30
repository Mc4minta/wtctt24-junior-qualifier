package h.c.n0.e.b;

/* compiled from: FlowableSwitchIfEmpty.java */
/* loaded from: classes3.dex */
public final class x3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<? extends T> f15213b;

    /* compiled from: FlowableSwitchIfEmpty.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final k.a.b<? extends T> f15214b;

        /* renamed from: d  reason: collision with root package name */
        boolean f15216d = true;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.i.f f15215c = new h.c.n0.i.f(false);

        a(k.a.c<? super T> cVar, k.a.b<? extends T> bVar) {
            this.a = cVar;
            this.f15214b = bVar;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15216d) {
                this.f15216d = false;
                this.f15214b.subscribe(this);
                return;
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15216d) {
                this.f15216d = false;
            }
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.f15215c.i(dVar);
        }
    }

    public x3(h.c.h<T> hVar, k.a.b<? extends T> bVar) {
        super(hVar);
        this.f15213b = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar, this.f15213b);
        cVar.onSubscribe(aVar.f15215c);
        this.a.subscribe((h.c.m) aVar);
    }
}