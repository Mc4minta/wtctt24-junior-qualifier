package h.c.s0;

import h.c.h;
import h.c.n0.i.g;
import h.c.n0.j.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastProcessor.java */
/* loaded from: classes3.dex */
public final class c<T> extends h.c.s0.a<T> {
    final h.c.n0.f.c<T> a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Runnable> f16812b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16813c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f16814d;

    /* renamed from: e  reason: collision with root package name */
    Throwable f16815e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<k.a.c<? super T>> f16816f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f16817g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f16818h;

    /* renamed from: j  reason: collision with root package name */
    final h.c.n0.i.a<T> f16819j;

    /* renamed from: k  reason: collision with root package name */
    final AtomicLong f16820k;

    /* renamed from: l  reason: collision with root package name */
    boolean f16821l;

    /* compiled from: UnicastProcessor.java */
    /* loaded from: classes3.dex */
    final class a extends h.c.n0.i.a<T> {
        a() {
        }

        @Override // k.a.d
        public void cancel() {
            if (c.this.f16817g) {
                return;
            }
            c.this.f16817g = true;
            c.this.g();
            c cVar = c.this;
            if (cVar.f16821l || cVar.f16819j.getAndIncrement() != 0) {
                return;
            }
            c.this.a.clear();
            c.this.f16816f.lazySet(null);
        }

        @Override // h.c.n0.c.j
        public void clear() {
            c.this.a.clear();
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return c.this.a.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                c.this.f16821l = true;
                return 2;
            }
            return 0;
        }

        @Override // h.c.n0.c.j
        public T poll() {
            return c.this.a.poll();
        }

        @Override // k.a.d
        public void request(long j2) {
            if (g.B(j2)) {
                d.a(c.this.f16820k, j2);
                c.this.i();
            }
        }
    }

    c(int i2) {
        this(i2, null, true);
    }

    public static <T> c<T> d() {
        return new c<>(h.bufferSize());
    }

    public static <T> c<T> e(int i2) {
        return new c<>(i2);
    }

    public static <T> c<T> f(int i2, Runnable runnable) {
        h.c.n0.b.b.e(runnable, "onTerminate");
        return new c<>(i2, runnable);
    }

    boolean c(boolean z, boolean z2, boolean z3, k.a.c<? super T> cVar, h.c.n0.f.c<T> cVar2) {
        if (this.f16817g) {
            cVar2.clear();
            this.f16816f.lazySet(null);
            return true;
        } else if (z2) {
            if (z && this.f16815e != null) {
                cVar2.clear();
                this.f16816f.lazySet(null);
                cVar.onError(this.f16815e);
                return true;
            } else if (z3) {
                Throwable th = this.f16815e;
                this.f16816f.lazySet(null);
                if (th != null) {
                    cVar.onError(th);
                } else {
                    cVar.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void g() {
        Runnable andSet = this.f16812b.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    void i() {
        if (this.f16819j.getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        k.a.c<? super T> cVar = this.f16816f.get();
        while (cVar == null) {
            i2 = this.f16819j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            cVar = this.f16816f.get();
        }
        if (this.f16821l) {
            j(cVar);
        } else {
            k(cVar);
        }
    }

    void j(k.a.c<? super T> cVar) {
        h.c.n0.f.c<T> cVar2 = this.a;
        int i2 = 1;
        boolean z = !this.f16813c;
        while (!this.f16817g) {
            boolean z2 = this.f16814d;
            if (z && z2 && this.f16815e != null) {
                cVar2.clear();
                this.f16816f.lazySet(null);
                cVar.onError(this.f16815e);
                return;
            }
            cVar.onNext(null);
            if (z2) {
                this.f16816f.lazySet(null);
                Throwable th = this.f16815e;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            i2 = this.f16819j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        cVar2.clear();
        this.f16816f.lazySet(null);
    }

    void k(k.a.c<? super T> cVar) {
        int i2;
        long j2;
        h.c.n0.f.c<T> cVar2 = this.a;
        boolean z = true;
        boolean z2 = !this.f16813c;
        int i3 = 1;
        while (true) {
            long j3 = this.f16820k.get();
            long j4 = 0;
            while (true) {
                i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
                if (i2 == 0) {
                    j2 = j4;
                    break;
                }
                boolean z3 = this.f16814d;
                T poll = cVar2.poll();
                boolean z4 = poll == null ? z : false;
                j2 = j4;
                if (c(z2, z3, z4, cVar, cVar2)) {
                    return;
                }
                if (z4) {
                    break;
                }
                cVar.onNext(poll);
                j4 = 1 + j2;
                z = true;
            }
            if (i2 == 0 && c(z2, this.f16814d, cVar2.isEmpty(), cVar, cVar2)) {
                return;
            }
            if (j2 != 0 && j3 != Long.MAX_VALUE) {
                this.f16820k.addAndGet(-j2);
            }
            i3 = this.f16819j.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
            z = true;
        }
    }

    @Override // k.a.c
    public void onComplete() {
        if (this.f16814d || this.f16817g) {
            return;
        }
        this.f16814d = true;
        g();
        i();
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        h.c.n0.b.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f16814d && !this.f16817g) {
            this.f16815e = th;
            this.f16814d = true;
            g();
            i();
            return;
        }
        h.c.r0.a.u(th);
    }

    @Override // k.a.c
    public void onNext(T t) {
        h.c.n0.b.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16814d || this.f16817g) {
            return;
        }
        this.a.offer(t);
        i();
    }

    @Override // k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (!this.f16814d && !this.f16817g) {
            dVar.request(Long.MAX_VALUE);
        } else {
            dVar.cancel();
        }
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (!this.f16818h.get() && this.f16818h.compareAndSet(false, true)) {
            cVar.onSubscribe(this.f16819j);
            this.f16816f.set(cVar);
            if (this.f16817g) {
                this.f16816f.lazySet(null);
                return;
            } else {
                i();
                return;
            }
        }
        h.c.n0.i.d.q(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
    }

    c(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    c(int i2, Runnable runnable, boolean z) {
        this.a = new h.c.n0.f.c<>(h.c.n0.b.b.f(i2, "capacityHint"));
        this.f16812b = new AtomicReference<>(runnable);
        this.f16813c = z;
        this.f16816f = new AtomicReference<>();
        this.f16818h = new AtomicBoolean();
        this.f16819j = new a();
        this.f16820k = new AtomicLong();
    }
}