package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class w0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f16335b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16336c;

    /* compiled from: ObservableFlatMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.b<T> implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f16338c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f16339d;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f16341f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16342g;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.j.c f16337b = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f16340e = new h.c.k0.a();

        /* compiled from: ObservableFlatMapCompletable.java */
        /* renamed from: h.c.n0.e.e.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0387a extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
            C0387a() {
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

        a(h.c.z<? super T> zVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
            this.a = zVar;
            this.f16338c = nVar;
            this.f16339d = z;
            lazySet(1);
        }

        void a(a<T>.C0387a c0387a) {
            this.f16340e.c(c0387a);
            onComplete();
        }

        void b(a<T>.C0387a c0387a, Throwable th) {
            this.f16340e.c(c0387a);
            onError(th);
        }

        @Override // h.c.n0.c.j
        public void clear() {
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16342g = true;
            this.f16341f.dispose();
            this.f16340e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16341f.isDisposed();
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return true;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return i2 & 2;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b2 = this.f16337b.b();
                if (b2 != null) {
                    this.a.onError(b2);
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16337b.a(th)) {
                if (this.f16339d) {
                    if (decrementAndGet() == 0) {
                        this.a.onError(this.f16337b.b());
                        return;
                    }
                    return;
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.a.onError(this.f16337b.b());
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f16338c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0387a c0387a = new C0387a();
                if (this.f16342g || !this.f16340e.b(c0387a)) {
                    return;
                }
                fVar.c(c0387a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16341f.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16341f, bVar)) {
                this.f16341f = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            return null;
        }
    }

    public w0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
        super(xVar);
        this.f16335b = nVar;
        this.f16336c = z;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16335b, this.f16336c));
    }
}