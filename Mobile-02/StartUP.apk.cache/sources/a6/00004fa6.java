package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithPublisher.java */
/* loaded from: classes3.dex */
public final class i<T, U> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<U> f16515b;

    /* compiled from: SingleDelayWithPublisher.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends AtomicReference<h.c.k0.b> implements h.c.m<U>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.h0<T> f16516b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16517c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f16518d;

        a(h.c.e0<? super T> e0Var, h.c.h0<T> h0Var) {
            this.a = e0Var;
            this.f16516b = h0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16518d.cancel();
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f16517c) {
                return;
            }
            this.f16517c = true;
            this.f16516b.subscribe(new h.c.n0.d.y(this, this.a));
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f16517c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16517c = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(U u) {
            this.f16518d.cancel();
            onComplete();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f16518d, dVar)) {
                this.f16518d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public i(h.c.h0<T> h0Var, k.a.b<U> bVar) {
        this.a = h0Var;
        this.f16515b = bVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.f16515b.subscribe(new a(e0Var, this.a));
    }
}