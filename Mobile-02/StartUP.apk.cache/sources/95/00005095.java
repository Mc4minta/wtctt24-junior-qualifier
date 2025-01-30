package h.c.w0;

import h.c.m;
import h.c.n0.i.g;

/* compiled from: SerializedSubscriber.java */
/* loaded from: classes3.dex */
public final class d<T> implements m<T>, k.a.d {
    final k.a.c<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f16881b;

    /* renamed from: c  reason: collision with root package name */
    k.a.d f16882c;

    /* renamed from: d  reason: collision with root package name */
    boolean f16883d;

    /* renamed from: e  reason: collision with root package name */
    h.c.n0.j.a<Object> f16884e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f16885f;

    public d(k.a.c<? super T> cVar) {
        this(cVar, false);
    }

    void a() {
        h.c.n0.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f16884e;
                if (aVar == null) {
                    this.f16883d = false;
                    return;
                }
                this.f16884e = null;
            }
        } while (!aVar.b((k.a.c<? super T>) this.a));
    }

    @Override // k.a.d
    public void cancel() {
        this.f16882c.cancel();
    }

    @Override // k.a.c
    public void onComplete() {
        if (this.f16885f) {
            return;
        }
        synchronized (this) {
            if (this.f16885f) {
                return;
            }
            if (this.f16883d) {
                h.c.n0.j.a<Object> aVar = this.f16884e;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16884e = aVar;
                }
                aVar.c(h.c.n0.j.m.y());
                return;
            }
            this.f16885f = true;
            this.f16883d = true;
            this.a.onComplete();
        }
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.f16885f) {
            h.c.r0.a.u(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f16885f) {
                if (this.f16883d) {
                    this.f16885f = true;
                    h.c.n0.j.a<Object> aVar = this.f16884e;
                    if (aVar == null) {
                        aVar = new h.c.n0.j.a<>(4);
                        this.f16884e = aVar;
                    }
                    Object A = h.c.n0.j.m.A(th);
                    if (this.f16881b) {
                        aVar.c(A);
                    } else {
                        aVar.e(A);
                    }
                    return;
                }
                this.f16885f = true;
                this.f16883d = true;
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
        if (this.f16885f) {
            return;
        }
        if (t == null) {
            this.f16882c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f16885f) {
                return;
            }
            if (this.f16883d) {
                h.c.n0.j.a<Object> aVar = this.f16884e;
                if (aVar == null) {
                    aVar = new h.c.n0.j.a<>(4);
                    this.f16884e = aVar;
                }
                aVar.c(h.c.n0.j.m.F(t));
                return;
            }
            this.f16883d = true;
            this.a.onNext(t);
            a();
        }
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (g.C(this.f16882c, dVar)) {
            this.f16882c = dVar;
            this.a.onSubscribe(this);
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        this.f16882c.request(j2);
    }

    public d(k.a.c<? super T> cVar, boolean z) {
        this.a = cVar;
        this.f16881b = z;
    }
}