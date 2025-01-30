package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatWithMaybe.java */
/* loaded from: classes3.dex */
public final class a0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.q<? extends T> f14178b;

    /* compiled from: FlowableConcatWithMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.s<T, T> implements h.c.p<T> {

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f14179e;

        /* renamed from: f  reason: collision with root package name */
        h.c.q<? extends T> f14180f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14181g;

        a(k.a.c<? super T> cVar, h.c.q<? extends T> qVar) {
            super(cVar);
            this.f14180f = qVar;
            this.f14179e = new AtomicReference<>();
        }

        @Override // h.c.n0.h.s, k.a.d
        public void cancel() {
            super.cancel();
            h.c.n0.a.c.h(this.f14179e);
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14181g) {
                this.a.onComplete();
                return;
            }
            this.f14181g = true;
            this.f16745b = h.c.n0.i.g.CANCELLED;
            h.c.q<? extends T> qVar = this.f14180f;
            this.f14180f = null;
            qVar.b(this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f16747d++;
            this.a.onNext(t);
        }

        @Override // h.c.p
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f14179e, bVar);
        }

        @Override // h.c.p
        public void onSuccess(T t) {
            a(t);
        }
    }

    public a0(h.c.h<T> hVar, h.c.q<? extends T> qVar) {
        super(hVar);
        this.f14178b = qVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14178b));
    }
}