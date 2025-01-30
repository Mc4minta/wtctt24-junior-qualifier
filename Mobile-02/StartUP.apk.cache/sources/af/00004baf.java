package h.c.k0;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceDisposable.java */
/* loaded from: classes2.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(T t) {
        super(h.c.n0.b.b.e(t, "value is null"));
    }

    protected abstract void a(T t);

    @Override // h.c.k0.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return get() == null;
    }
}