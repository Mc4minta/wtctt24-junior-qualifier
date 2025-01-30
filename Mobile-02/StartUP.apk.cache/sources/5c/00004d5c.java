package h.c.n0.e.b;

/* compiled from: FlowableSkip.java */
/* loaded from: classes3.dex */
public final class r3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14933b;

    /* compiled from: FlowableSkip.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        long f14934b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14935c;

        a(k.a.c<? super T> cVar, long j2) {
            this.a = cVar;
            this.f14934b = j2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14935c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = this.f14934b;
            if (j2 != 0) {
                this.f14934b = j2 - 1;
            } else {
                this.a.onNext(t);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14935c, dVar)) {
                long j2 = this.f14934b;
                this.f14935c = dVar;
                this.a.onSubscribe(this);
                dVar.request(j2);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14935c.request(j2);
        }
    }

    public r3(h.c.h<T> hVar, long j2) {
        super(hVar);
        this.f14933b = j2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14933b));
    }
}