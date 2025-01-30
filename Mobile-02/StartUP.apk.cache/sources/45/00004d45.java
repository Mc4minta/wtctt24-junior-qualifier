package h.c.n0.e.b;

/* compiled from: FlowableDoOnLifecycle.java */
/* loaded from: classes3.dex */
public final class r0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private final h.c.m0.f<? super k.a.d> f14897b;

    /* renamed from: c  reason: collision with root package name */
    private final h.c.m0.o f14898c;

    /* renamed from: d  reason: collision with root package name */
    private final h.c.m0.a f14899d;

    /* compiled from: FlowableDoOnLifecycle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.f<? super k.a.d> f14900b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.o f14901c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.a f14902d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14903e;

        a(k.a.c<? super T> cVar, h.c.m0.f<? super k.a.d> fVar, h.c.m0.o oVar, h.c.m0.a aVar) {
            this.a = cVar;
            this.f14900b = fVar;
            this.f14902d = aVar;
            this.f14901c = oVar;
        }

        @Override // k.a.d
        public void cancel() {
            k.a.d dVar = this.f14903e;
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar != gVar) {
                this.f14903e = gVar;
                try {
                    this.f14902d.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
                dVar.cancel();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14903e != h.c.n0.i.g.CANCELLED) {
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14903e != h.c.n0.i.g.CANCELLED) {
                this.a.onError(th);
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            try {
                this.f14900b.accept(dVar);
                if (h.c.n0.i.g.C(this.f14903e, dVar)) {
                    this.f14903e = dVar;
                    this.a.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dVar.cancel();
                this.f14903e = h.c.n0.i.g.CANCELLED;
                h.c.n0.i.d.q(th, this.a);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            try {
                this.f14901c.a(j2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
            this.f14903e.request(j2);
        }
    }

    public r0(h.c.h<T> hVar, h.c.m0.f<? super k.a.d> fVar, h.c.m0.o oVar, h.c.m0.a aVar) {
        super(hVar);
        this.f14897b = fVar;
        this.f14898c = oVar;
        this.f14899d = aVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14897b, this.f14898c, this.f14899d));
    }
}