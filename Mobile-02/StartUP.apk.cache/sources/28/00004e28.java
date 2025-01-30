package h.c.n0.e.e;

import h.c.a0;

/* compiled from: ObservableObserveOn.java */
/* loaded from: classes3.dex */
public final class c2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f15544b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15545c;

    /* renamed from: d  reason: collision with root package name */
    final int f15546d;

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.b<T> implements h.c.z<T>, Runnable {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final a0.c f15547b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f15548c;

        /* renamed from: d  reason: collision with root package name */
        final int f15549d;

        /* renamed from: e  reason: collision with root package name */
        h.c.n0.c.j<T> f15550e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f15551f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f15552g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15553h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15554j;

        /* renamed from: k  reason: collision with root package name */
        int f15555k;

        /* renamed from: l  reason: collision with root package name */
        boolean f15556l;

        a(h.c.z<? super T> zVar, a0.c cVar, boolean z, int i2) {
            this.a = zVar;
            this.f15547b = cVar;
            this.f15548c = z;
            this.f15549d = i2;
        }

        boolean a(boolean z, boolean z2, h.c.z<? super T> zVar) {
            if (this.f15554j) {
                this.f15550e.clear();
                return true;
            } else if (z) {
                Throwable th = this.f15552g;
                if (this.f15548c) {
                    if (z2) {
                        this.f15554j = true;
                        if (th != null) {
                            zVar.onError(th);
                        } else {
                            zVar.onComplete();
                        }
                        this.f15547b.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.f15554j = true;
                    this.f15550e.clear();
                    zVar.onError(th);
                    this.f15547b.dispose();
                    return true;
                } else if (z2) {
                    this.f15554j = true;
                    zVar.onComplete();
                    this.f15547b.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            int i2 = 1;
            while (!this.f15554j) {
                boolean z = this.f15553h;
                Throwable th = this.f15552g;
                if (!this.f15548c && z && th != null) {
                    this.f15554j = true;
                    this.a.onError(this.f15552g);
                    this.f15547b.dispose();
                    return;
                }
                this.a.onNext(null);
                if (z) {
                    this.f15554j = true;
                    Throwable th2 = this.f15552g;
                    if (th2 != null) {
                        this.a.onError(th2);
                    } else {
                        this.a.onComplete();
                    }
                    this.f15547b.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        void c() {
            h.c.n0.c.j<T> jVar = this.f15550e;
            h.c.z<? super T> zVar = this.a;
            int i2 = 1;
            while (!a(this.f15553h, jVar.isEmpty(), zVar)) {
                while (true) {
                    boolean z = this.f15553h;
                    try {
                        Object obj = (T) jVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, zVar)) {
                            return;
                        }
                        if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            zVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f15554j = true;
                        this.f15551f.dispose();
                        jVar.clear();
                        zVar.onError(th);
                        this.f15547b.dispose();
                        return;
                    }
                }
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15550e.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                this.f15547b.b(this);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15554j) {
                return;
            }
            this.f15554j = true;
            this.f15551f.dispose();
            this.f15547b.dispose();
            if (getAndIncrement() == 0) {
                this.f15550e.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15554j;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f15550e.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                this.f15556l = true;
                return 2;
            }
            return 0;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15553h) {
                return;
            }
            this.f15553h = true;
            d();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15553h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15552g = th;
            this.f15553h = true;
            d();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15553h) {
                return;
            }
            if (this.f15555k != 2) {
                this.f15550e.offer(t);
            }
            d();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15551f, bVar)) {
                this.f15551f = bVar;
                if (bVar instanceof h.c.n0.c.e) {
                    h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                    int n = eVar.n(7);
                    if (n == 1) {
                        this.f15555k = n;
                        this.f15550e = eVar;
                        this.f15553h = true;
                        this.a.onSubscribe(this);
                        d();
                        return;
                    } else if (n == 2) {
                        this.f15555k = n;
                        this.f15550e = eVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.f15550e = new h.c.n0.f.c(this.f15549d);
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            return this.f15550e.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15556l) {
                b();
            } else {
                c();
            }
        }
    }

    public c2(h.c.x<T> xVar, h.c.a0 a0Var, boolean z, int i2) {
        super(xVar);
        this.f15544b = a0Var;
        this.f15545c = z;
        this.f15546d = i2;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        h.c.a0 a0Var = this.f15544b;
        if (a0Var instanceof h.c.n0.g.q) {
            this.a.subscribe(zVar);
            return;
        }
        this.a.subscribe(new a(zVar, a0Var.a(), this.f15545c, this.f15546d));
    }
}