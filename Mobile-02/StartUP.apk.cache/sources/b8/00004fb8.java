package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleObserveOn.java */
/* loaded from: classes3.dex */
public final class n0<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f16534b;

    /* compiled from: SingleObserveOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b, Runnable {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.a0 f16535b;

        /* renamed from: c  reason: collision with root package name */
        T f16536c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f16537d;

        a(h.c.e0<? super T> e0Var, h.c.a0 a0Var) {
            this.a = e0Var;
            this.f16535b = a0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f16537d = th;
            h.c.n0.a.c.q(this, this.f16535b.c(this));
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.f16536c = t;
            h.c.n0.a.c.q(this, this.f16535b.c(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f16537d;
            if (th != null) {
                this.a.onError(th);
            } else {
                this.a.onSuccess((T) this.f16536c);
            }
        }
    }

    public n0(h.c.h0<T> h0Var, h.c.a0 a0Var) {
        this.a = h0Var;
        this.f16534b = a0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16534b));
    }
}