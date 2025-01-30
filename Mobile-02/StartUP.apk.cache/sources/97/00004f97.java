package h.c.n0.e.g;

import java.util.concurrent.TimeUnit;

/* compiled from: SingleDelay.java */
/* loaded from: classes3.dex */
public final class f<T> extends h.c.b0<T> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f16498b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16499c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f16500d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f16501e;

    /* compiled from: SingleDelay.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.e0<T> {
        private final h.c.n0.a.g a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.e0<? super T> f16502b;

        /* compiled from: SingleDelay.java */
        /* renamed from: h.c.n0.e.g.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0394a implements Runnable {
            private final Throwable a;

            RunnableC0394a(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16502b.onError(this.a);
            }
        }

        /* compiled from: SingleDelay.java */
        /* loaded from: classes3.dex */
        final class b implements Runnable {
            private final T a;

            b(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16502b.onSuccess((T) this.a);
            }
        }

        a(h.c.n0.a.g gVar, h.c.e0<? super T> e0Var) {
            this.a = gVar;
            this.f16502b = e0Var;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            h.c.n0.a.g gVar = this.a;
            h.c.a0 a0Var = f.this.f16500d;
            RunnableC0394a runnableC0394a = new RunnableC0394a(th);
            f fVar = f.this;
            gVar.a(a0Var.d(runnableC0394a, fVar.f16501e ? fVar.f16498b : 0L, fVar.f16499c));
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.a(bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            h.c.n0.a.g gVar = this.a;
            h.c.a0 a0Var = f.this.f16500d;
            b bVar = new b(t);
            f fVar = f.this;
            gVar.a(a0Var.d(bVar, fVar.f16498b, fVar.f16499c));
        }
    }

    public f(h.c.h0<? extends T> h0Var, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        this.a = h0Var;
        this.f16498b = j2;
        this.f16499c = timeUnit;
        this.f16500d = a0Var;
        this.f16501e = z;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        h.c.n0.a.g gVar = new h.c.n0.a.g();
        e0Var.onSubscribe(gVar);
        this.a.subscribe(new a(gVar, e0Var));
    }
}