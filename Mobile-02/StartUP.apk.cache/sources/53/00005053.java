package h.c.p0;

import h.c.n0.j.h;
import h.c.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableObserver.java */
/* loaded from: classes3.dex */
public abstract class d<T> implements z<T>, h.c.k0.b {
    final AtomicReference<h.c.k0.b> a = new AtomicReference<>();

    protected void b() {
    }

    @Override // h.c.k0.b
    public final void dispose() {
        h.c.n0.a.c.h(this.a);
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.a.get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.z
    public final void onSubscribe(h.c.k0.b bVar) {
        if (h.c(this.a, bVar, getClass())) {
            b();
        }
    }
}