package h.c.n0.e.g;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTimeout.java */
/* loaded from: classes3.dex */
public final class s0<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f16560b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16561c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f16562d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.h0<? extends T> f16563e;

    /* compiled from: SingleTimeout.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, Runnable, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16564b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final C0395a<T> f16565c;

        /* renamed from: d  reason: collision with root package name */
        h.c.h0<? extends T> f16566d;

        /* renamed from: e  reason: collision with root package name */
        final long f16567e;

        /* renamed from: f  reason: collision with root package name */
        final TimeUnit f16568f;

        /* compiled from: SingleTimeout.java */
        /* renamed from: h.c.n0.e.g.s0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0395a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T> {
            final h.c.e0<? super T> a;

            C0395a(h.c.e0<? super T> e0Var) {
                this.a = e0Var;
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
        }

        a(h.c.e0<? super T> e0Var, h.c.h0<? extends T> h0Var, long j2, TimeUnit timeUnit) {
            this.a = e0Var;
            this.f16566d = h0Var;
            this.f16567e = j2;
            this.f16568f = timeUnit;
            if (h0Var != null) {
                this.f16565c = new C0395a<>(e0Var);
            } else {
                this.f16565c = null;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
            h.c.n0.a.c.h(this.f16564b);
            C0395a<T> c0395a = this.f16565c;
            if (c0395a != null) {
                h.c.n0.a.c.h(c0395a);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar && compareAndSet(bVar, cVar)) {
                h.c.n0.a.c.h(this.f16564b);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar == cVar || !compareAndSet(bVar, cVar)) {
                return;
            }
            h.c.n0.a.c.h(this.f16564b);
            this.a.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar == cVar || !compareAndSet(bVar, cVar)) {
                return;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            h.c.h0<? extends T> h0Var = this.f16566d;
            if (h0Var == null) {
                this.a.onError(new TimeoutException(h.c.n0.j.j.d(this.f16567e, this.f16568f)));
                return;
            }
            this.f16566d = null;
            h0Var.subscribe(this.f16565c);
        }
    }

    public s0(h.c.h0<T> h0Var, long j2, TimeUnit timeUnit, h.c.a0 a0Var, h.c.h0<? extends T> h0Var2) {
        this.a = h0Var;
        this.f16560b = j2;
        this.f16561c = timeUnit;
        this.f16562d = a0Var;
        this.f16563e = h0Var2;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        a aVar = new a(e0Var, this.f16563e, this.f16560b, this.f16561c);
        e0Var.onSubscribe(aVar);
        h.c.n0.a.c.q(aVar.f16564b, this.f16562d.d(aVar, this.f16560b, this.f16561c));
        this.a.subscribe(aVar);
    }
}