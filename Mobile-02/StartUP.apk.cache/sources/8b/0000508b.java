package h.c.v0;

import h.c.n0.j.a;
import h.c.n0.j.m;
import h.c.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializedSubject.java */
/* loaded from: classes3.dex */
public final class d<T> extends f<T> implements a.InterfaceC0400a<Object> {
    final f<T> a;

    /* renamed from: b  reason: collision with root package name */
    boolean f16862b;

    /* renamed from: c  reason: collision with root package name */
    h.c.n0.j.a<Object> f16863c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f16864d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f<T> fVar) {
        this.a = fVar;
    }

    void c() {
        h.c.n0.j.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f16863c;
                if (aVar == null) {
                    this.f16862b = false;
                    return;
                }
                this.f16863c = null;
            }
            aVar.d(this);
        }
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f16864d) {
            return;
        }
        synchronized (this) {
            if (this.f16864d) {
                return;
            }
            this.f16864d = true;
            if (this.f16862b) {
                h.c.n0.j.a<Object> aVar = this.f16863c;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16863c = aVar;
                }
                aVar.c(m.y());
                return;
            }
            this.f16862b = true;
            this.a.onComplete();
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (this.f16864d) {
            h.c.r0.a.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f16864d) {
                this.f16864d = true;
                if (this.f16862b) {
                    h.c.n0.j.a<Object> aVar = this.f16863c;
                    if (aVar == null) {
                        aVar = new h.c.n0.j.a<>(4);
                        this.f16863c = aVar;
                    }
                    aVar.e(m.A(th));
                    return;
                }
                this.f16862b = true;
                z = false;
            }
            if (z) {
                h.c.r0.a.u(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (this.f16864d) {
            return;
        }
        synchronized (this) {
            if (this.f16864d) {
                return;
            }
            if (this.f16862b) {
                h.c.n0.j.a<Object> aVar = this.f16863c;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16863c = aVar;
                }
                aVar.c(m.F(t));
                return;
            }
            this.f16862b = true;
            this.a.onNext(t);
            c();
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        boolean z = true;
        if (!this.f16864d) {
            synchronized (this) {
                if (!this.f16864d) {
                    if (this.f16862b) {
                        h.c.n0.j.a<Object> aVar = this.f16863c;
                        if (aVar == null) {
                            aVar = new h.c.n0.j.a<>(4);
                            this.f16863c = aVar;
                        }
                        aVar.c(m.z(bVar));
                        return;
                    }
                    this.f16862b = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
            return;
        }
        this.a.onSubscribe(bVar);
        c();
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super T> zVar) {
        this.a.subscribe(zVar);
    }

    @Override // h.c.n0.j.a.InterfaceC0400a, h.c.m0.p
    public boolean test(Object obj) {
        return m.q(obj, this.a);
    }
}