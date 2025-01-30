package h.c.n0.d;

import h.c.e0;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BiConsumerSingleObserver.java */
/* loaded from: classes.dex */
public final class d<T> extends AtomicReference<h.c.k0.b> implements e0<T>, h.c.k0.b {
    final h.c.m0.b<? super T, ? super Throwable> a;

    public d(h.c.m0.b<? super T, ? super Throwable> bVar) {
        this.a = bVar;
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
        try {
            lazySet(h.c.n0.a.c.DISPOSED);
            this.a.a(null, th);
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
        try {
            lazySet(h.c.n0.a.c.DISPOSED);
            this.a.a(t, null);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }
}