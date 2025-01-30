package h.c.n0.e.b;

/* compiled from: FlowableFromObservable.java */
/* loaded from: classes3.dex */
public final class j1<T> extends h.c.h<T> {
    private final h.c.s<T> a;

    /* compiled from: FlowableFromObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f14537b;

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14537b.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f14537b = bVar;
            this.a.onSubscribe(this);
        }

        @Override // k.a.d
        public void request(long j2) {
        }
    }

    public j1(h.c.s<T> sVar) {
        this.a = sVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe(new a(cVar));
    }
}