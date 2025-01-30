package h.c.n0.d;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EmptyCompletableObserver.java */
/* loaded from: classes.dex */
public final class n extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.e
    public void onComplete() {
        lazySet(h.c.n0.a.c.DISPOSED);
    }

    @Override // h.c.e
    public void onError(Throwable th) {
        lazySet(h.c.n0.a.c.DISPOSED);
        h.c.r0.a.u(new OnErrorNotImplementedException(th));
    }

    @Override // h.c.e
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this, bVar);
    }
}