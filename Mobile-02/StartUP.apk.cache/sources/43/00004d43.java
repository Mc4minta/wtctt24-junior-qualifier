package h.c.n0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableCollect.java */
/* loaded from: classes3.dex */
public final class r<T, U> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends U> f14891b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.b<? super U, ? super T> f14892c;

    /* compiled from: FlowableCollect.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends h.c.n0.i.c<U> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.b<? super U, ? super T> f14893c;

        /* renamed from: d  reason: collision with root package name */
        final U f14894d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14895e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14896f;

        a(k.a.c<? super U> cVar, U u, h.c.m0.b<? super U, ? super T> bVar) {
            super(cVar);
            this.f14893c = bVar;
            this.f14894d = u;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14895e.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14896f) {
                return;
            }
            this.f14896f = true;
            c(this.f14894d);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14896f) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14896f = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14896f) {
                return;
            }
            try {
                this.f14893c.a((U) this.f14894d, t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14895e.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14895e, dVar)) {
                this.f14895e = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public r(h.c.h<T> hVar, Callable<? extends U> callable, h.c.m0.b<? super U, ? super T> bVar) {
        super(hVar);
        this.f14891b = callable;
        this.f14892c = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        try {
            this.a.subscribe((h.c.m) new a(cVar, h.c.n0.b.b.e(this.f14891b.call(), "The initial value supplied is null"), this.f14892c));
        } catch (Throwable th) {
            h.c.n0.i.d.q(th, cVar);
        }
    }
}