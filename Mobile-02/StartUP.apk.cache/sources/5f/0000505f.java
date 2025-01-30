package h.c.s0;

import h.c.n0.j.m;
import k.a.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializedProcessor.java */
/* loaded from: classes3.dex */
public final class b<T> extends a<T> {
    final a<T> a;

    /* renamed from: b  reason: collision with root package name */
    boolean f16809b;

    /* renamed from: c  reason: collision with root package name */
    h.c.n0.j.a<Object> f16810c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f16811d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a<T> aVar) {
        this.a = aVar;
    }

    void c() {
        h.c.n0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f16810c;
                if (aVar == null) {
                    this.f16809b = false;
                    return;
                }
                this.f16810c = null;
            }
            aVar.b(this.a);
        }
    }

    @Override // k.a.c
    public void onComplete() {
        if (this.f16811d) {
            return;
        }
        synchronized (this) {
            if (this.f16811d) {
                return;
            }
            this.f16811d = true;
            if (this.f16809b) {
                h.c.n0.j.a<Object> aVar = this.f16810c;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16810c = aVar;
                }
                aVar.c(m.y());
                return;
            }
            this.f16809b = true;
            this.a.onComplete();
        }
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.f16811d) {
            h.c.r0.a.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f16811d) {
                this.f16811d = true;
                if (this.f16809b) {
                    h.c.n0.j.a<Object> aVar = this.f16810c;
                    if (aVar == null) {
                        aVar = new h.c.n0.j.a<>(4);
                        this.f16810c = aVar;
                    }
                    aVar.e(m.A(th));
                    return;
                }
                this.f16809b = true;
                z = false;
            }
            if (z) {
                h.c.r0.a.u(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (this.f16811d) {
            return;
        }
        synchronized (this) {
            if (this.f16811d) {
                return;
            }
            if (this.f16809b) {
                h.c.n0.j.a<Object> aVar = this.f16810c;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16810c = aVar;
                }
                aVar.c(m.F(t));
                return;
            }
            this.f16809b = true;
            this.a.onNext(t);
            c();
        }
    }

    @Override // k.a.c
    public void onSubscribe(d dVar) {
        boolean z = true;
        if (!this.f16811d) {
            synchronized (this) {
                if (!this.f16811d) {
                    if (this.f16809b) {
                        h.c.n0.j.a<Object> aVar = this.f16810c;
                        if (aVar == null) {
                            aVar = new h.c.n0.j.a<>(4);
                            this.f16810c = aVar;
                        }
                        aVar.c(m.G(dVar));
                        return;
                    }
                    this.f16809b = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
            return;
        }
        this.a.onSubscribe(dVar);
        c();
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe(cVar);
    }
}