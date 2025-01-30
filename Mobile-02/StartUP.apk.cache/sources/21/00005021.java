package h.c.n0.h;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InnerQueuedSubscriber.java */
/* loaded from: classes3.dex */
public final class j<T> extends AtomicReference<k.a.d> implements h.c.m<T>, k.a.d {
    final k<T> a;

    /* renamed from: b  reason: collision with root package name */
    final int f16730b;

    /* renamed from: c  reason: collision with root package name */
    final int f16731c;

    /* renamed from: d  reason: collision with root package name */
    volatile h.c.n0.c.j<T> f16732d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f16733e;

    /* renamed from: f  reason: collision with root package name */
    long f16734f;

    /* renamed from: g  reason: collision with root package name */
    int f16735g;

    public j(k<T> kVar, int i2) {
        this.a = kVar;
        this.f16730b = i2;
        this.f16731c = i2 - (i2 >> 2);
    }

    public boolean a() {
        return this.f16733e;
    }

    public h.c.n0.c.j<T> b() {
        return this.f16732d;
    }

    public void c() {
        if (this.f16735g != 1) {
            long j2 = this.f16734f + 1;
            if (j2 == this.f16731c) {
                this.f16734f = 0L;
                get().request(j2);
                return;
            }
            this.f16734f = j2;
        }
    }

    @Override // k.a.d
    public void cancel() {
        h.c.n0.i.g.h(this);
    }

    public void d() {
        this.f16733e = true;
    }

    @Override // k.a.c
    public void onComplete() {
        this.a.a(this);
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        this.a.d(this, th);
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (this.f16735g == 0) {
            this.a.c(this, t);
        } else {
            this.a.b();
        }
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.z(this, dVar)) {
            if (dVar instanceof h.c.n0.c.g) {
                h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                int n = gVar.n(3);
                if (n == 1) {
                    this.f16735g = n;
                    this.f16732d = gVar;
                    this.f16733e = true;
                    this.a.a(this);
                    return;
                } else if (n == 2) {
                    this.f16735g = n;
                    this.f16732d = gVar;
                    h.c.n0.j.r.j(dVar, this.f16730b);
                    return;
                }
            }
            this.f16732d = h.c.n0.j.r.c(this.f16730b);
            h.c.n0.j.r.j(dVar, this.f16730b);
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        if (this.f16735g != 1) {
            long j3 = this.f16734f + j2;
            if (j3 >= this.f16731c) {
                this.f16734f = 0L;
                get().request(j3);
                return;
            }
            this.f16734f = j3;
        }
    }
}