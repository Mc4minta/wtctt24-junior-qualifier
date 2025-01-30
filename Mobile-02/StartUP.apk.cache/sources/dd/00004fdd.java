package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleUnsubscribeOn.java */
/* loaded from: classes3.dex */
public final class w0<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f16582b;

    /* compiled from: SingleUnsubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b, Runnable {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.a0 f16583b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16584c;

        a(h.c.e0<? super T> e0Var, h.c.a0 a0Var) {
            this.a = e0Var;
            this.f16583b = a0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            h.c.k0.b andSet = getAndSet(cVar);
            if (andSet != cVar) {
                this.f16584c = andSet;
                this.f16583b.c(this);
            }
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
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16584c.dispose();
        }
    }

    public w0(h.c.h0<T> h0Var, h.c.a0 a0Var) {
        this.a = h0Var;
        this.f16582b = a0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16582b));
    }
}