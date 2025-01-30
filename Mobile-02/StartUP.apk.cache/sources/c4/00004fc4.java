package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubscribeOn.java */
/* loaded from: classes3.dex */
public final class q0<T> extends h.c.b0<T> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f16550b;

    /* compiled from: SingleSubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b, Runnable {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f16551b = new h.c.n0.a.g();

        /* renamed from: c  reason: collision with root package name */
        final h.c.h0<? extends T> f16552c;

        a(h.c.e0<? super T> e0Var, h.c.h0<? extends T> h0Var) {
            this.a = e0Var;
            this.f16552c = h0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
            this.f16551b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16552c.subscribe(this);
        }
    }

    public q0(h.c.h0<? extends T> h0Var, h.c.a0 a0Var) {
        this.a = h0Var;
        this.f16550b = a0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        a aVar = new a(e0Var, this.a);
        e0Var.onSubscribe(aVar);
        aVar.f16551b.a(this.f16550b.c(aVar));
    }
}