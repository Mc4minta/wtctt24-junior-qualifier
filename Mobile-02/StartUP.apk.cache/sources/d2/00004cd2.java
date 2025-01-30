package h.c.n0.e.b;

/* compiled from: FlowableDematerialize.java */
/* loaded from: classes3.dex */
public final class k0<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.r<R>> f14562b;

    /* compiled from: FlowableDematerialize.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.m<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.r<R>> f14563b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14564c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f14565d;

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends h.c.r<R>> nVar) {
            this.a = cVar;
            this.f14563b = nVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14565d.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14564c) {
                return;
            }
            this.f14564c = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14564c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14564c = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14564c) {
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
                h.c.r rVar2 = (h.c.r) h.c.n0.b.b.e(this.f14563b.apply(t), "The selector returned a null Notification");
                if (rVar2.g()) {
                    this.f14565d.cancel();
                    onError(rVar2.d());
                } else if (rVar2.f()) {
                    this.f14565d.cancel();
                    onComplete();
                } else {
                    this.a.onNext((Object) rVar2.e());
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14565d.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14565d, dVar)) {
                this.f14565d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14565d.request(j2);
        }
    }

    public k0(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h.c.r<R>> nVar) {
        super(hVar);
        this.f14562b = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14562b));
    }
}