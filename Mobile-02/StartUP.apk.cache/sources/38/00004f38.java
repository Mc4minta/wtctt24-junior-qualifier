package h.c.n0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSampleTimed.java */
/* loaded from: classes3.dex */
public final class u2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16261b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16262c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f16263d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f16264e;

    /* compiled from: ObservableSampleTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f16265g;

        a(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            super(zVar, j2, timeUnit, a0Var);
            this.f16265g = new AtomicInteger(1);
        }

        @Override // h.c.n0.e.e.u2.c
        void b() {
            c();
            if (this.f16265g.decrementAndGet() == 0) {
                this.a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16265g.incrementAndGet() == 2) {
                c();
                if (this.f16265g.decrementAndGet() == 0) {
                    this.a.onComplete();
                }
            }
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {
        b(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            super(zVar, j2, timeUnit, a0Var);
        }

        @Override // h.c.n0.e.e.u2.c
        void b() {
            this.a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends AtomicReference<T> implements h.c.z<T>, h.c.k0.b, Runnable {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16266b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f16267c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.a0 f16268d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16269e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f16270f;

        c(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = zVar;
            this.f16266b = j2;
            this.f16267c = timeUnit;
            this.f16268d = a0Var;
        }

        void a() {
            h.c.n0.a.c.h(this.f16269e);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.a.onNext(andSet);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            a();
            this.f16270f.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16270f.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            a();
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            a();
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16270f, bVar)) {
                this.f16270f = bVar;
                this.a.onSubscribe(this);
                h.c.a0 a0Var = this.f16268d;
                long j2 = this.f16266b;
                h.c.n0.a.c.q(this.f16269e, a0Var.e(this, j2, j2, this.f16267c));
            }
        }
    }

    public u2(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        super(xVar);
        this.f16261b = j2;
        this.f16262c = timeUnit;
        this.f16263d = a0Var;
        this.f16264e = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.p0.f fVar = new h.c.p0.f(zVar);
        if (this.f16264e) {
            this.a.subscribe(new a(fVar, this.f16261b, this.f16262c, this.f16263d));
        } else {
            this.a.subscribe(new b(fVar, this.f16261b, this.f16262c, this.f16263d));
        }
    }
}