package h.c.n0.e.b;

import h.c.n0.e.b.b3;

/* compiled from: FlowableRetryWhen.java */
/* loaded from: classes3.dex */
public final class f3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super h.c.h<Throwable>, ? extends k.a.b<?>> f14407b;

    /* compiled from: FlowableRetryWhen.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends b3.c<T, Throwable> {
        a(k.a.c<? super T> cVar, h.c.s0.a<Throwable> aVar, k.a.d dVar) {
            super(cVar, aVar, dVar);
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14243l.cancel();
            this.f14241j.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            j(th);
        }
    }

    public f3(h.c.h<T> hVar, h.c.m0.n<? super h.c.h<Throwable>, ? extends k.a.b<?>> nVar) {
        super(hVar);
        this.f14407b = nVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.w0.d dVar = new h.c.w0.d(cVar);
        h.c.s0.a<T> b2 = h.c.s0.c.e(8).b();
        try {
            k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14407b.apply(b2), "handler returned a null Publisher");
            b3.b bVar2 = new b3.b(this.a);
            a aVar = new a(dVar, b2, bVar2);
            bVar2.f14240d = aVar;
            cVar.onSubscribe(aVar);
            bVar.subscribe(bVar2);
            bVar2.onNext(0);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}