package h.c.n0.e.d;

import h.c.e0;
import h.c.p;
import h.c.r;

/* compiled from: MaterializeSingleObserver.java */
/* loaded from: classes3.dex */
public final class g<T> implements e0<T>, p<T>, h.c.e, h.c.k0.b {
    final e0<? super r<T>> a;

    /* renamed from: b  reason: collision with root package name */
    h.c.k0.b f15413b;

    public g(e0<? super r<T>> e0Var) {
        this.a = e0Var;
    }

    @Override // h.c.k0.b
    public void dispose() {
        this.f15413b.dispose();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f15413b.isDisposed();
    }

    @Override // h.c.p
    public void onComplete() {
        this.a.onSuccess(r.a());
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        this.a.onSuccess(r.b(th));
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.B(this.f15413b, bVar)) {
            this.f15413b = bVar;
            this.a.onSubscribe(this);
        }
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        this.a.onSuccess(r.c(t));
    }
}