package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapMaybe.java */
/* loaded from: classes3.dex */
public final class y0<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.q<? extends R>> f16402b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16403c;

    /* compiled from: ObservableFlatMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f16404b;

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.q<? extends R>> f16408f;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f16410h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f16411j;

        /* renamed from: c  reason: collision with root package name */
        final h.c.k0.a f16405c = new h.c.k0.a();

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f16407e = new h.c.n0.j.c();

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f16406d = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<h.c.n0.f.c<R>> f16409g = new AtomicReference<>();

        /* compiled from: ObservableFlatMapMaybe.java */
        /* renamed from: h.c.n0.e.e.y0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0389a extends AtomicReference<h.c.k0.b> implements h.c.p<R>, h.c.k0.b {
            C0389a() {
            }

            @Override // h.c.k0.b
            public void dispose() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return h.c.n0.a.c.n(get());
            }

            @Override // h.c.p
            public void onComplete() {
                a.this.e(this);
            }

            @Override // h.c.p
            public void onError(Throwable th) {
                a.this.f(this, th);
            }

            @Override // h.c.p
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.p
            public void onSuccess(R r) {
                a.this.g(this, r);
            }
        }

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.q<? extends R>> nVar, boolean z) {
            this.a = zVar;
            this.f16408f = nVar;
            this.f16404b = z;
        }

        void a() {
            h.c.n0.f.c<R> cVar = this.f16409g.get();
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
            AtomicInteger atomicInteger = this.f16406d;
            AtomicReference<h.c.n0.f.c<R>> atomicReference = this.f16409g;
            int i2 = 1;
            while (!this.f16411j) {
                if (!this.f16404b && this.f16407e.get() != null) {
                    Throwable b2 = this.f16407e.b();
                    a();
                    zVar.onError(b2);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                h.c.n0.f.c<R> cVar = atomicReference.get();
                R poll = cVar != null ? cVar.poll() : (Object) null;
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = this.f16407e.b();
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
                h.c.n0.f.c<R> cVar2 = this.f16409g.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.c.n0.f.c<>(h.c.s.bufferSize());
            } while (!this.f16409g.compareAndSet(null, cVar));
            return cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16411j = true;
            this.f16410h.dispose();
            this.f16405c.dispose();
        }

        void e(a<T, R>.C0389a c0389a) {
            this.f16405c.c(c0389a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.f16406d.decrementAndGet() == 0;
                    h.c.n0.f.c<R> cVar = this.f16409g.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable b2 = this.f16407e.b();
                        if (b2 != null) {
                            this.a.onError(b2);
                            return;
                        } else {
                            this.a.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() == 0) {
                        return;
                    } else {
                        c();
                        return;
                    }
                }
            }
            this.f16406d.decrementAndGet();
            b();
        }

        void f(a<T, R>.C0389a c0389a, Throwable th) {
            this.f16405c.c(c0389a);
            if (this.f16407e.a(th)) {
                if (!this.f16404b) {
                    this.f16410h.dispose();
                    this.f16405c.dispose();
                }
                this.f16406d.decrementAndGet();
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        void g(a<T, R>.C0389a c0389a, R r) {
            this.f16405c.c(c0389a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.a.onNext(r);
                    boolean z = this.f16406d.decrementAndGet() == 0;
                    h.c.n0.f.c<R> cVar = this.f16409g.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable b2 = this.f16407e.b();
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
            this.f16406d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16411j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16406d.decrementAndGet();
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16406d.decrementAndGet();
            if (this.f16407e.a(th)) {
                if (!this.f16404b) {
                    this.f16405c.dispose();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            try {
                h.c.q qVar = (h.c.q) h.c.n0.b.b.e(this.f16408f.apply(t), "The mapper returned a null MaybeSource");
                this.f16406d.getAndIncrement();
                C0389a c0389a = new C0389a();
                if (this.f16411j || !this.f16405c.b(c0389a)) {
                    return;
                }
                qVar.b(c0389a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16410h.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16410h, bVar)) {
                this.f16410h = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public y0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.q<? extends R>> nVar, boolean z) {
        super(xVar);
        this.f16402b = nVar;
        this.f16403c = z;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        this.a.subscribe(new a(zVar, this.f16402b, this.f16403c));
    }
}