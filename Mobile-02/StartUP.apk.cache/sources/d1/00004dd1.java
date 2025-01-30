package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class z0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f15305b;

    /* renamed from: c  reason: collision with root package name */
    final int f15306c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f15307d;

    /* compiled from: FlowableFlatMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.a<T> implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f15309c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15310d;

        /* renamed from: f  reason: collision with root package name */
        final int f15312f;

        /* renamed from: g  reason: collision with root package name */
        k.a.d f15313g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15314h;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.j.c f15308b = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f15311e = new h.c.k0.a();

        /* compiled from: FlowableFlatMapCompletable.java */
        /* renamed from: h.c.n0.e.b.z0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0360a extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
            C0360a() {
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
                a.this.c(this);
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                a.this.d(this, th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(k.a.c<? super T> cVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z, int i2) {
            this.a = cVar;
            this.f15309c = nVar;
            this.f15310d = z;
            this.f15312f = i2;
            lazySet(1);
        }

        void c(a<T>.C0360a c0360a) {
            this.f15311e.c(c0360a);
            onComplete();
        }

        @Override // k.a.d
        public void cancel() {
            this.f15314h = true;
            this.f15313g.cancel();
            this.f15311e.dispose();
        }

        @Override // h.c.n0.c.j
        public void clear() {
        }

        void d(a<T>.C0360a c0360a, Throwable th) {
            this.f15311e.c(c0360a);
            onError(th);
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return true;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return i2 & 2;
        }

        @Override // k.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b2 = this.f15308b.b();
                if (b2 != null) {
                    this.a.onError(b2);
                } else {
                    this.a.onComplete();
                }
            } else if (this.f15312f != Integer.MAX_VALUE) {
                this.f15313g.request(1L);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15308b.a(th)) {
                if (this.f15310d) {
                    if (decrementAndGet() == 0) {
                        this.a.onError(this.f15308b.b());
                        return;
                    } else if (this.f15312f != Integer.MAX_VALUE) {
                        this.f15313g.request(1L);
                        return;
                    } else {
                        return;
                    }
                }
                cancel();
                if (getAndSet(0) > 0) {
                    this.a.onError(this.f15308b.b());
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f15309c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0360a c0360a = new C0360a();
                if (this.f15314h || !this.f15311e.b(c0360a)) {
                    return;
                }
                fVar.c(c0360a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15313g.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15313g, dVar)) {
                this.f15313g = dVar;
                this.a.onSubscribe(this);
                int i2 = this.f15312f;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(i2);
                }
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            return null;
        }

        @Override // k.a.d
        public void request(long j2) {
        }
    }

    public z0(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z, int i2) {
        super(hVar);
        this.f15305b = nVar;
        this.f15307d = z;
        this.f15306c = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15305b, this.f15307d, this.f15306c));
    }
}