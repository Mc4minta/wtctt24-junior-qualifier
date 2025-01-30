package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCreate.java */
/* loaded from: classes3.dex */
public final class d<T> extends h.c.b0<T> {
    final h.c.f0<T> a;

    /* compiled from: SingleCreate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.d0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.d0
        public boolean a(Throwable th) {
            h.c.k0.b andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar == cVar || (andSet = getAndSet(cVar)) == cVar) {
                return false;
            }
            try {
                this.a.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.d0, h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.d0
        public void onError(Throwable th) {
            if (a(th)) {
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.d0
        public void onSuccess(T t) {
            h.c.k0.b andSet;
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar == cVar || (andSet = getAndSet(cVar)) == cVar) {
                return;
            }
            try {
                if (t == null) {
                    this.a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.a.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public d(h.c.f0<T> f0Var) {
        this.a = f0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        a aVar = new a(e0Var);
        e0Var.onSubscribe(aVar);
        try {
            this.a.subscribe(aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            aVar.onError(th);
        }
    }
}