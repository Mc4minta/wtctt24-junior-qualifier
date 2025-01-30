package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapCompletableCompletable.java */
/* loaded from: classes3.dex */
public final class a1<T> extends h.c.c implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f14182b;

    /* renamed from: c  reason: collision with root package name */
    final int f14183c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f14184d;

    /* compiled from: FlowableFlatMapCompletableCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, h.c.k0.b {
        final h.c.e a;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f14186c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f14187d;

        /* renamed from: f  reason: collision with root package name */
        final int f14189f;

        /* renamed from: g  reason: collision with root package name */
        k.a.d f14190g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f14191h;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.j.c f14185b = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f14188e = new h.c.k0.a();

        /* compiled from: FlowableFlatMapCompletableCompletable.java */
        /* renamed from: h.c.n0.e.b.a1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0344a extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
            C0344a() {
            }

            @Override // h.c.k0.b
            public void dispose() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return h.c.n0.a.c.n(get());
            }

            @Override // h.c.e
            public void onComplete() {
                a.this.a(this);
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                a.this.b(this, th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.e eVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z, int i2) {
            this.a = eVar;
            this.f14186c = nVar;
            this.f14187d = z;
            this.f14189f = i2;
            lazySet(1);
        }

        void a(a<T>.C0344a c0344a) {
            this.f14188e.c(c0344a);
            onComplete();
        }

        void b(a<T>.C0344a c0344a, Throwable th) {
            this.f14188e.c(c0344a);
            onError(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14191h = true;
            this.f14190g.cancel();
            this.f14188e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14188e.isDisposed();
        }

        @Override // k.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b2 = this.f14185b.b();
                if (b2 != null) {
                    this.a.onError(b2);
                } else {
                    this.a.onComplete();
                }
            } else if (this.f14189f != Integer.MAX_VALUE) {
                this.f14190g.request(1L);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14185b.a(th)) {
                if (this.f14187d) {
                    if (decrementAndGet() == 0) {
                        this.a.onError(this.f14185b.b());
                        return;
                    } else if (this.f14189f != Integer.MAX_VALUE) {
                        this.f14190g.request(1L);
                        return;
                    } else {
                        return;
                    }
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.a.onError(this.f14185b.b());
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f14186c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0344a c0344a = new C0344a();
                if (this.f14191h || !this.f14188e.b(c0344a)) {
                    return;
                }
                fVar.c(c0344a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14190g.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14190g, dVar)) {
                this.f14190g = dVar;
                this.a.onSubscribe(this);
                int i2 = this.f14189f;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(i2);
                }
            }
        }
    }

    public a1(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z, int i2) {
        this.a = hVar;
        this.f14182b = nVar;
        this.f14184d = z;
        this.f14183c = i2;
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new z0(this.a, this.f14182b, this.f14184d, this.f14183c));
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.subscribe((h.c.m) new a(eVar, this.f14182b, this.f14184d, this.f14183c));
    }
}