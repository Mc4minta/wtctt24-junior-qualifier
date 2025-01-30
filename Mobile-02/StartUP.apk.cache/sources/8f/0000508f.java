package h.c.v0;

import h.c.n0.c.j;
import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastSubject.java */
/* loaded from: classes3.dex */
public final class g<T> extends f<T> {
    final h.c.n0.f.c<T> a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<z<? super T>> f16870b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Runnable> f16871c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f16872d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f16873e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f16874f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f16875g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f16876h;

    /* renamed from: j  reason: collision with root package name */
    final h.c.n0.d.b<T> f16877j;

    /* renamed from: k  reason: collision with root package name */
    boolean f16878k;

    /* compiled from: UnicastSubject.java */
    /* loaded from: classes3.dex */
    final class a extends h.c.n0.d.b<T> {
        a() {
        }

        @Override // h.c.n0.c.j
        public void clear() {
            g.this.a.clear();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (g.this.f16873e) {
                return;
            }
            g.this.f16873e = true;
            g.this.f();
            g.this.f16870b.lazySet(null);
            if (g.this.f16877j.getAndIncrement() == 0) {
                g.this.f16870b.lazySet(null);
                g.this.a.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return g.this.f16873e;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return g.this.a.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                g.this.f16878k = true;
                return 2;
            }
            return 0;
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            return g.this.a.poll();
        }
    }

    g(int i2, boolean z) {
        this.a = new h.c.n0.f.c<>(h.c.n0.b.b.f(i2, "capacityHint"));
        this.f16871c = new AtomicReference<>();
        this.f16872d = z;
        this.f16870b = new AtomicReference<>();
        this.f16876h = new AtomicBoolean();
        this.f16877j = new a();
    }

    public static <T> g<T> c() {
        return new g<>(s.bufferSize(), true);
    }

    public static <T> g<T> d(int i2) {
        return new g<>(i2, true);
    }

    public static <T> g<T> e(int i2, Runnable runnable) {
        return new g<>(i2, runnable, true);
    }

    void f() {
        Runnable runnable = this.f16871c.get();
        if (runnable == null || !this.f16871c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void g() {
        if (this.f16877j.getAndIncrement() != 0) {
            return;
        }
        z<? super T> zVar = this.f16870b.get();
        int i2 = 1;
        while (zVar == null) {
            i2 = this.f16877j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            zVar = this.f16870b.get();
        }
        if (this.f16878k) {
            h(zVar);
        } else {
            i(zVar);
        }
    }

    void h(z<? super T> zVar) {
        h.c.n0.f.c<T> cVar = this.a;
        int i2 = 1;
        boolean z = !this.f16872d;
        while (!this.f16873e) {
            boolean z2 = this.f16874f;
            if (z && z2 && k(cVar, zVar)) {
                return;
            }
            zVar.onNext(null);
            if (z2) {
                j(zVar);
                return;
            }
            i2 = this.f16877j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        this.f16870b.lazySet(null);
        cVar.clear();
    }

    void i(z<? super T> zVar) {
        h.c.n0.f.c<T> cVar = this.a;
        boolean z = !this.f16872d;
        boolean z2 = true;
        int i2 = 1;
        while (!this.f16873e) {
            boolean z3 = this.f16874f;
            Object obj = (T) this.a.poll();
            boolean z4 = obj == null;
            if (z3) {
                if (z && z2) {
                    if (k(cVar, zVar)) {
                        return;
                    }
                    z2 = false;
                }
                if (z4) {
                    j(zVar);
                    return;
                }
            }
            if (z4) {
                i2 = this.f16877j.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                zVar.onNext(obj);
            }
        }
        this.f16870b.lazySet(null);
        cVar.clear();
    }

    void j(z<? super T> zVar) {
        this.f16870b.lazySet(null);
        Throwable th = this.f16875g;
        if (th != null) {
            zVar.onError(th);
        } else {
            zVar.onComplete();
        }
    }

    boolean k(j<T> jVar, z<? super T> zVar) {
        Throwable th = this.f16875g;
        if (th != null) {
            this.f16870b.lazySet(null);
            jVar.clear();
            zVar.onError(th);
            return true;
        }
        return false;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f16874f || this.f16873e) {
            return;
        }
        this.f16874f = true;
        f();
        g();
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        h.c.n0.b.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f16874f && !this.f16873e) {
            this.f16875g = th;
            this.f16874f = true;
            f();
            g();
            return;
        }
        h.c.r0.a.u(th);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        h.c.n0.b.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16874f || this.f16873e) {
            return;
        }
        this.a.offer(t);
        g();
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (this.f16874f || this.f16873e) {
            bVar.dispose();
        }
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super T> zVar) {
        if (!this.f16876h.get() && this.f16876h.compareAndSet(false, true)) {
            zVar.onSubscribe(this.f16877j);
            this.f16870b.lazySet(zVar);
            if (this.f16873e) {
                this.f16870b.lazySet(null);
                return;
            } else {
                g();
                return;
            }
        }
        h.c.n0.a.d.y(new IllegalStateException("Only a single observer allowed."), zVar);
    }

    g(int i2, Runnable runnable, boolean z) {
        this.a = new h.c.n0.f.c<>(h.c.n0.b.b.f(i2, "capacityHint"));
        this.f16871c = new AtomicReference<>(h.c.n0.b.b.e(runnable, "onTerminate"));
        this.f16872d = z;
        this.f16870b = new AtomicReference<>();
        this.f16876h = new AtomicBoolean();
        this.f16877j = new a();
    }
}