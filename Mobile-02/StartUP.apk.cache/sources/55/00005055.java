package h.c.p0;

import h.c.n0.j.m;
import h.c.z;

/* compiled from: SerializedObserver.java */
/* loaded from: classes3.dex */
public final class f<T> implements z<T>, h.c.k0.b {
    final z<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f16788b;

    /* renamed from: c  reason: collision with root package name */
    h.c.k0.b f16789c;

    /* renamed from: d  reason: collision with root package name */
    boolean f16790d;

    /* renamed from: e  reason: collision with root package name */
    h.c.n0.j.a<Object> f16791e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f16792f;

    public f(z<? super T> zVar) {
        this(zVar, false);
    }

    void a() {
        h.c.n0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f16791e;
                if (aVar == null) {
                    this.f16790d = false;
                    return;
                }
                this.f16791e = null;
            }
        } while (!aVar.a((z<? super T>) this.a));
    }

    @Override // h.c.k0.b
    public void dispose() {
        this.f16789c.dispose();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f16789c.isDisposed();
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f16792f) {
            return;
        }
        synchronized (this) {
            if (this.f16792f) {
                return;
            }
            if (this.f16790d) {
                h.c.n0.j.a<Object> aVar = this.f16791e;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16791e = aVar;
                }
                aVar.c(m.y());
                return;
            }
            this.f16792f = true;
            this.f16790d = true;
            this.a.onComplete();
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (this.f16792f) {
            h.c.r0.a.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f16792f) {
                if (this.f16790d) {
                    this.f16792f = true;
                    h.c.n0.j.a<Object> aVar = this.f16791e;
                    if (aVar == null) {
                        aVar = new h.c.n0.j.a<>(4);
                        this.f16791e = aVar;
                    }
                    Object A = m.A(th);
                    if (this.f16788b) {
                        aVar.c(A);
                    } else {
                        aVar.e(A);
                    }
                    return;
                }
                this.f16792f = true;
                this.f16790d = true;
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
        if (this.f16792f) {
            return;
        }
        if (t == null) {
            this.f16789c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f16792f) {
                return;
            }
            if (this.f16790d) {
                h.c.n0.j.a<Object> aVar = this.f16791e;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16791e = aVar;
                }
                aVar.c(m.F(t));
                return;
            }
            this.f16790d = true;
            this.a.onNext(t);
            a();
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.B(this.f16789c, bVar)) {
            this.f16789c = bVar;
            this.a.onSubscribe(this);
        }
    }

    public f(z<? super T> zVar, boolean z) {
        this.a = zVar;
        this.f16788b = z;
    }
}