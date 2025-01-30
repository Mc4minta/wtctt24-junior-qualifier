package h.c.n0.e.e;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMap.java */
/* loaded from: classes3.dex */
public final class u<T, U> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<? extends U>> f16234b;

    /* renamed from: c  reason: collision with root package name */
    final int f16235c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.n0.j.i f16236d;

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f16237b;

        /* renamed from: c  reason: collision with root package name */
        final int f16238c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f16239d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final C0386a<R> f16240e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f16241f;

        /* renamed from: g  reason: collision with root package name */
        h.c.n0.c.j<T> f16242g;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f16243h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f16244j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f16245k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f16246l;
        int m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: h.c.n0.e.e.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0386a<R> extends AtomicReference<h.c.k0.b> implements h.c.z<R> {
            final h.c.z<? super R> a;

            /* renamed from: b  reason: collision with root package name */
            final a<?, R> f16247b;

            C0386a(h.c.z<? super R> zVar, a<?, R> aVar) {
                this.a = zVar;
                this.f16247b = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                a<?, R> aVar = this.f16247b;
                aVar.f16244j = false;
                aVar.a();
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                a<?, R> aVar = this.f16247b;
                if (aVar.f16239d.a(th)) {
                    if (!aVar.f16241f) {
                        aVar.f16243h.dispose();
                    }
                    aVar.f16244j = false;
                    aVar.a();
                    return;
                }
                h.c.r0.a.u(th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // h.c.z
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this, bVar);
            }
        }

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, int i2, boolean z) {
            this.a = zVar;
            this.f16237b = nVar;
            this.f16238c = i2;
            this.f16241f = z;
            this.f16240e = new C0386a<>(zVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.z<? super R> zVar = this.a;
            h.c.n0.c.j<T> jVar = this.f16242g;
            h.c.n0.j.c cVar = this.f16239d;
            while (true) {
                if (!this.f16244j) {
                    if (this.f16246l) {
                        jVar.clear();
                        return;
                    } else if (!this.f16241f && cVar.get() != null) {
                        jVar.clear();
                        this.f16246l = true;
                        zVar.onError(cVar.b());
                        return;
                    } else {
                        boolean z = this.f16245k;
                        try {
                            T poll = jVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.f16246l = true;
                                Throwable b2 = cVar.b();
                                if (b2 != null) {
                                    zVar.onError(b2);
                                    return;
                                } else {
                                    zVar.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16237b.apply(poll), "The mapper returned a null ObservableSource");
                                    if (xVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) xVar).call();
                                            if (obj != 0 && !this.f16246l) {
                                                zVar.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            cVar.a(th);
                                        }
                                    } else {
                                        this.f16244j = true;
                                        xVar.subscribe(this.f16240e);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.f16246l = true;
                                    this.f16243h.dispose();
                                    jVar.clear();
                                    cVar.a(th2);
                                    zVar.onError(cVar.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.f16246l = true;
                            this.f16243h.dispose();
                            cVar.a(th3);
                            zVar.onError(cVar.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16246l = true;
            this.f16243h.dispose();
            this.f16240e.a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16246l;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16245k = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16239d.a(th)) {
                this.f16245k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.m == 0) {
                this.f16242g.offer(t);
            }
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16243h, bVar)) {
                this.f16243h = bVar;
                if (bVar instanceof h.c.n0.c.e) {
                    h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                    int n = eVar.n(3);
                    if (n == 1) {
                        this.m = n;
                        this.f16242g = eVar;
                        this.f16245k = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (n == 2) {
                        this.m = n;
                        this.f16242g = eVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.f16242g = new h.c.n0.f.c(this.f16238c);
                this.a.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends U>> f16248b;

        /* renamed from: c  reason: collision with root package name */
        final a<U> f16249c;

        /* renamed from: d  reason: collision with root package name */
        final int f16250d;

        /* renamed from: e  reason: collision with root package name */
        h.c.n0.c.j<T> f16251e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f16252f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16253g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f16254h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f16255j;

        /* renamed from: k  reason: collision with root package name */
        int f16256k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* loaded from: classes3.dex */
        public static final class a<U> extends AtomicReference<h.c.k0.b> implements h.c.z<U> {
            final h.c.z<? super U> a;

            /* renamed from: b  reason: collision with root package name */
            final b<?, ?> f16257b;

            a(h.c.z<? super U> zVar, b<?, ?> bVar) {
                this.a = zVar;
                this.f16257b = bVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                this.f16257b.b();
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                this.f16257b.dispose();
                this.a.onError(th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(U u) {
                this.a.onNext(u);
            }

            @Override // h.c.z
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this, bVar);
            }
        }

        b(h.c.z<? super U> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar, int i2) {
            this.a = zVar;
            this.f16248b = nVar;
            this.f16250d = i2;
            this.f16249c = new a<>(zVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f16254h) {
                if (!this.f16253g) {
                    boolean z = this.f16255j;
                    try {
                        T poll = this.f16251e.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.f16254h = true;
                            this.a.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16248b.apply(poll), "The mapper returned a null ObservableSource");
                                this.f16253g = true;
                                xVar.subscribe(this.f16249c);
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                dispose();
                                this.f16251e.clear();
                                this.a.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        dispose();
                        this.f16251e.clear();
                        this.a.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f16251e.clear();
        }

        void b() {
            this.f16253g = false;
            a();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16254h = true;
            this.f16249c.a();
            this.f16252f.dispose();
            if (getAndIncrement() == 0) {
                this.f16251e.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16254h;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16255j) {
                return;
            }
            this.f16255j = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16255j) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16255j = true;
            dispose();
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16255j) {
                return;
            }
            if (this.f16256k == 0) {
                this.f16251e.offer(t);
            }
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16252f, bVar)) {
                this.f16252f = bVar;
                if (bVar instanceof h.c.n0.c.e) {
                    h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                    int n = eVar.n(3);
                    if (n == 1) {
                        this.f16256k = n;
                        this.f16251e = eVar;
                        this.f16255j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (n == 2) {
                        this.f16256k = n;
                        this.f16251e = eVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.f16251e = new h.c.n0.f.c(this.f16250d);
                this.a.onSubscribe(this);
            }
        }
    }

    public u(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar, int i2, h.c.n0.j.i iVar) {
        super(xVar);
        this.f16234b = nVar;
        this.f16236d = iVar;
        this.f16235c = Math.max(8, i2);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super U> zVar) {
        if (w2.b(this.a, zVar, this.f16234b)) {
            return;
        }
        if (this.f16236d == h.c.n0.j.i.IMMEDIATE) {
            this.a.subscribe(new b(new h.c.p0.f(zVar), this.f16234b, this.f16235c));
        } else {
            this.a.subscribe(new a(zVar, this.f16234b, this.f16235c, this.f16236d == h.c.n0.j.i.END));
        }
    }
}