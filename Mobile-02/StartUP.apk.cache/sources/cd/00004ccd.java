package h.c.n0.e.b;

/* compiled from: FlowableScan.java */
/* loaded from: classes3.dex */
public final class j3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<T, T, T> f14551b;

    /* compiled from: FlowableScan.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<T, T, T> f14552b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14553c;

        /* renamed from: d  reason: collision with root package name */
        T f14554d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14555e;

        a(k.a.c<? super T> cVar, h.c.m0.c<T, T, T> cVar2) {
            this.a = cVar;
            this.f14552b = cVar2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14553c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14555e) {
                return;
            }
            this.f14555e = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14555e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14555e = true;
            this.a.onError(th);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14555e) {
                return;
            }
            k.a.c<? super T> cVar = this.a;
            T t2 = this.f14554d;
            if (t2 == null) {
                this.f14554d = t;
                cVar.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) h.c.n0.b.b.e(this.f14552b.apply(t2, t), "The value returned by the accumulator is null");
                this.f14554d = r4;
                cVar.onNext(r4);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14553c.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14553c, dVar)) {
                this.f14553c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14553c.request(j2);
        }
    }

    public j3(h.c.h<T> hVar, h.c.m0.c<T, T, T> cVar) {
        super(hVar);
        this.f14551b = cVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14551b));
    }
}