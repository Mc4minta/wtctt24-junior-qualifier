package h.c.n0.d;

import h.c.e0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver.java */
/* loaded from: classes.dex */
public final class y<T> implements e0<T> {
    final AtomicReference<h.c.k0.b> a;

    /* renamed from: b  reason: collision with root package name */
    final e0<? super T> f14148b;

    public y(AtomicReference<h.c.k0.b> atomicReference, e0<? super T> e0Var) {
        this.a = atomicReference;
        this.f14148b = e0Var;
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        this.f14148b.onError(th);
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.q(this.a, bVar);
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        this.f14148b.onSuccess(t);
    }
}