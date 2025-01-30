package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleDoFinally.java */
/* loaded from: classes3.dex */
public final class o<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.a f16538b;

    /* compiled from: SingleDoFinally.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.a f16539b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16540c;

        a(h.c.e0<? super T> e0Var, h.c.m0.a aVar) {
            this.a = e0Var;
            this.f16539b = aVar;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f16539b.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16540c.dispose();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16540c.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
            a();
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16540c, bVar)) {
                this.f16540c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
            a();
        }
    }

    public o(h.c.h0<T> h0Var, h.c.m0.a aVar) {
        this.a = h0Var;
        this.f16538b = aVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16538b));
    }
}