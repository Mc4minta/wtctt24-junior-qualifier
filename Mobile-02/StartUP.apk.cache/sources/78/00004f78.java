package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapSingle.java */
/* loaded from: classes3.dex */
public final class z0<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> f16428b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16429c;

    /* compiled from: ObservableFlatMapSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f16430b;

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> f16434f;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f16436h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f16437j;

        /* renamed from: c  reason: collision with root package name */
        final h.c.k0.a f16431c = new h.c.k0.a();

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f16433e = new h.c.n0.j.c();

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f16432d = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<h.c.n0.f.c<R>> f16435g = new AtomicReference<>();

        /* compiled from: ObservableFlatMapSingle.java */
        /* renamed from: h.c.n0.e.e.z0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0391a extends AtomicReference<h.c.k0.b> implements h.c.e0<R>, h.c.k0.b {
            C0391a() {
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
                a.this.e(this, th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(R r) {
                a.this.f(this, r);
            }
        }

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> nVar, boolean z) {
            this.a = zVar;
            this.f16434f = nVar;
            this.f16430b = z;
        }

        void a() {
            h.c.n0.f.c<R> cVar = this.f16435g.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        void c() {
            h.c.z<? super R> zVar = this.a;
            AtomicInteger atomicInteger = this.f16432d;
            AtomicReference<h.c.n0.f.c<R>> atomicReference = this.f16435g;
            int i2 = 1;
            while (!this.f16437j) {
                if (!this.f16430b && this.f16433e.get() != null) {
                    Throwable b2 = this.f16433e.b();
                    a();
                    zVar.onError(b2);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                h.c.n0.f.c<R> cVar = atomicReference.get();
                R poll = cVar != null ? cVar.poll() : (Object) null;
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = this.f16433e.b();
                    if (b3 != null) {
                        zVar.onError(b3);
                        return;
                    } else {
                        zVar.onComplete();
                        return;
                    }
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    zVar.onNext(poll);
                }
            }
            a();
        }

        h.c.n0.f.c<R> d() {
            h.c.n0.f.c<R> cVar;
            do {
                h.c.n0.f.c<R> cVar2 = this.f16435g.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.c.n0.f.c<>(h.c.s.bufferSize());
            } while (!this.f16435g.compareAndSet(null, cVar));
            return cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16437j = true;
            this.f16436h.dispose();
            this.f16431c.dispose();
        }

        void e(a<T, R>.C0391a c0391a, Throwable th) {
            this.f16431c.c(c0391a);
            if (this.f16433e.a(th)) {
                if (!this.f16430b) {
                    this.f16436h.dispose();
                    this.f16431c.dispose();
                }
                this.f16432d.decrementAndGet();
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        void f(a<T, R>.C0391a c0391a, R r) {
            this.f16431c.c(c0391a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.a.onNext(r);
                    boolean z = this.f16432d.decrementAndGet() == 0;
                    h.c.n0.f.c<R> cVar = this.f16435g.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable b2 = this.f16433e.b();
                        if (b2 != null) {
                            this.a.onError(b2);
                            return;
                        } else {
                            this.a.onComplete();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            h.c.n0.f.c<R> d2 = d();
            synchronized (d2) {
                d2.offer(r);
            }
            this.f16432d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16437j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16432d.decrementAndGet();
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16432d.decrementAndGet();
            if (this.f16433e.a(th)) {
                if (!this.f16430b) {
                    this.f16431c.dispose();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            try {
                h.c.h0 h0Var = (h.c.h0) h.c.n0.b.b.e(this.f16434f.apply(t), "The mapper returned a null SingleSource");
                this.f16432d.getAndIncrement();
                C0391a c0391a = new C0391a();
                if (this.f16437j || !this.f16431c.b(c0391a)) {
                    return;
                }
                h0Var.subscribe(c0391a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16436h.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16436h, bVar)) {
                this.f16436h = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public z0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> nVar, boolean z) {
        super(xVar);
        this.f16428b = nVar;
        this.f16429c = z;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        this.a.subscribe(new a(zVar, this.f16428b, this.f16429c));
    }
}