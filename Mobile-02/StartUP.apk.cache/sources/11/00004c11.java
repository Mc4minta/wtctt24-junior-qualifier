package h.c.n0.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InnerQueuedObserver.java */
/* loaded from: classes.dex */
public final class r<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final int f14136b;

    /* renamed from: c  reason: collision with root package name */
    h.c.n0.c.j<T> f14137c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f14138d;

    /* renamed from: e  reason: collision with root package name */
    int f14139e;

    public r(s<T> sVar, int i2) {
        this.a = sVar;
        this.f14136b = i2;
    }

    public boolean a() {
        return this.f14138d;
    }

    public h.c.n0.c.j<T> b() {
        return this.f14137c;
    }

    public void c() {
        this.f14138d = true;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return h.c.n0.a.c.n(get());
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        this.a.d(this);
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        this.a.c(this, th);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (this.f14139e == 0) {
            this.a.e(this, t);
        } else {
            this.a.b();
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.z(this, bVar)) {
            if (bVar instanceof h.c.n0.c.e) {
                h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                int n = eVar.n(3);
                if (n == 1) {
                    this.f14139e = n;
                    this.f14137c = eVar;
                    this.f14138d = true;
                    this.a.d(this);
                    return;
                } else if (n == 2) {
                    this.f14139e = n;
                    this.f14137c = eVar;
                    return;
                }
            }
            this.f14137c = h.c.n0.j.r.c(-this.f14136b);
        }
    }
}