package h.c.n0.d;

import h.c.e0;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ConsumerSingleObserver.java */
/* loaded from: classes.dex */
public final class k<T> extends AtomicReference<h.c.k0.b> implements e0<T>, h.c.k0.b {
    final h.c.m0.f<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f14124b;

    public k(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
        this.a = fVar;
        this.f14124b = fVar2;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        lazySet(h.c.n0.a.c.DISPOSED);
        try {
            this.f14124b.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.r0.a.u(new CompositeException(th, th2));
        }
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this, bVar);
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        lazySet(h.c.n0.a.c.DISPOSED);
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }
}