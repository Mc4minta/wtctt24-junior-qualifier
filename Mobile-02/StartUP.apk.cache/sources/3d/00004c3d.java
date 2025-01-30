package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatWithSingle.java */
/* loaded from: classes3.dex */
public final class b0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.h0<? extends T> f14215b;

    /* compiled from: FlowableConcatWithSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.s<T, T> implements h.c.e0<T> {

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f14216e;

        /* renamed from: f  reason: collision with root package name */
        h.c.h0<? extends T> f14217f;

        a(k.a.c<? super T> cVar, h.c.h0<? extends T> h0Var) {
            super(cVar);
            this.f14217f = h0Var;
            this.f14216e = new AtomicReference<>();
        }

        @Override // h.c.n0.h.s, k.a.d
        public void cancel() {
            super.cancel();
            h.c.n0.a.c.h(this.f14216e);
        }

        @Override // k.a.c
        public void onComplete() {
            this.f16745b = h.c.n0.i.g.CANCELLED;
            h.c.h0<? extends T> h0Var = this.f14217f;
            this.f14217f = null;
            h0Var.subscribe(this);
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

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f14216e, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            a(t);
        }
    }

    public b0(h.c.h<T> hVar, h.c.h0<? extends T> h0Var) {
        super(hVar);
        this.f14215b = h0Var;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14215b));
    }
}