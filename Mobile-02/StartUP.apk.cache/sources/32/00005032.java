package h.c.n0.i;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SubscriptionArbiter.java */
/* loaded from: classes3.dex */
public class f extends AtomicInteger implements k.a.d {
    k.a.d a;

    /* renamed from: b  reason: collision with root package name */
    long f16757b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<k.a.d> f16758c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    final AtomicLong f16759d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f16760e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    final boolean f16761f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f16762g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f16763h;

    public f(boolean z) {
        this.f16761f = z;
    }

    final void c() {
        if (getAndIncrement() != 0) {
            return;
        }
        d();
    }

    public void cancel() {
        if (this.f16762g) {
            return;
        }
        this.f16762g = true;
        c();
    }

    final void d() {
        int i2 = 1;
        k.a.d dVar = null;
        long j2 = 0;
        do {
            k.a.d dVar2 = this.f16758c.get();
            if (dVar2 != null) {
                dVar2 = this.f16758c.getAndSet(null);
            }
            long j3 = this.f16759d.get();
            if (j3 != 0) {
                j3 = this.f16759d.getAndSet(0L);
            }
            long j4 = this.f16760e.get();
            if (j4 != 0) {
                j4 = this.f16760e.getAndSet(0L);
            }
            k.a.d dVar3 = this.a;
            if (this.f16762g) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.a = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long j5 = this.f16757b;
                if (j5 != Long.MAX_VALUE) {
                    j5 = h.c.n0.j.d.c(j5, j3);
                    if (j5 != Long.MAX_VALUE) {
                        j5 -= j4;
                        if (j5 < 0) {
                            g.s(j5);
                            j5 = 0;
                        }
                    }
                    this.f16757b = j5;
                }
                if (dVar2 != null) {
                    if (dVar3 != null && this.f16761f) {
                        dVar3.cancel();
                    }
                    this.a = dVar2;
                    if (j5 != 0) {
                        j2 = h.c.n0.j.d.c(j2, j5);
                        dVar = dVar2;
                    }
                } else if (dVar3 != null && j3 != 0) {
                    j2 = h.c.n0.j.d.c(j2, j3);
                    dVar = dVar3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j2 != 0) {
            dVar.request(j2);
        }
    }

    public final boolean e() {
        return this.f16762g;
    }

    public final boolean f() {
        return this.f16763h;
    }

    public final void g(long j2) {
        if (this.f16763h) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j3 = this.f16757b;
            if (j3 != Long.MAX_VALUE) {
                long j4 = j3 - j2;
                if (j4 < 0) {
                    g.s(j4);
                    j4 = 0;
                }
                this.f16757b = j4;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            d();
            return;
        }
        h.c.n0.j.d.a(this.f16760e, j2);
        c();
    }

    public final void i(k.a.d dVar) {
        if (this.f16762g) {
            dVar.cancel();
            return;
        }
        h.c.n0.b.b.e(dVar, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            k.a.d dVar2 = this.a;
            if (dVar2 != null && this.f16761f) {
                dVar2.cancel();
            }
            this.a = dVar;
            long j2 = this.f16757b;
            if (decrementAndGet() != 0) {
                d();
            }
            if (j2 != 0) {
                dVar.request(j2);
                return;
            }
            return;
        }
        k.a.d andSet = this.f16758c.getAndSet(dVar);
        if (andSet != null && this.f16761f) {
            andSet.cancel();
        }
        c();
    }

    @Override // k.a.d
    public final void request(long j2) {
        if (!g.B(j2) || this.f16763h) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j3 = this.f16757b;
            if (j3 != Long.MAX_VALUE) {
                long c2 = h.c.n0.j.d.c(j3, j2);
                this.f16757b = c2;
                if (c2 == Long.MAX_VALUE) {
                    this.f16763h = true;
                }
            }
            k.a.d dVar = this.a;
            if (decrementAndGet() != 0) {
                d();
            }
            if (dVar != null) {
                dVar.request(j2);
                return;
            }
            return;
        }
        h.c.n0.j.d.a(this.f16759d, j2);
        c();
    }
}