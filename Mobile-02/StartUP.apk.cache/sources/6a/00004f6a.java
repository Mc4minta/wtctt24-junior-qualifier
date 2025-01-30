package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatWithSingle.java */
/* loaded from: classes3.dex */
public final class y<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.h0<? extends T> f16399b;

    /* compiled from: ObservableConcatWithSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.e0<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.h0<? extends T> f16400b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16401c;

        a(h.c.z<? super T> zVar, h.c.h0<? extends T> h0Var) {
            this.a = zVar;
            this.f16400b = h0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16401c = true;
            h.c.n0.a.c.q(this, null);
            h.c.h0<? extends T> h0Var = this.f16400b;
            this.f16400b = null;
            h0Var.subscribe(this);
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
            if (!h.c.n0.a.c.z(this, bVar) || this.f16401c) {
                return;
            }
            this.a.onSubscribe(this);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onNext(t);
            this.a.onComplete();
        }
    }

    public y(h.c.s<T> sVar, h.c.h0<? extends T> h0Var) {
        super(sVar);
        this.f16399b = h0Var;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16399b));
    }
}