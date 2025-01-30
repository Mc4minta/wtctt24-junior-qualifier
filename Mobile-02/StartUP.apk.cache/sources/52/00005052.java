package h.c.p0;

import h.c.n0.j.h;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableCompletableObserver.java */
/* loaded from: classes3.dex */
public abstract class c implements h.c.e, h.c.k0.b {
    final AtomicReference<h.c.k0.b> a = new AtomicReference<>();

    protected void a() {
    }

    @Override // h.c.k0.b
    public final void dispose() {
        h.c.n0.a.c.h(this.a);
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.a.get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.e
    public final void onSubscribe(h.c.k0.b bVar) {
        if (h.c(this.a, bVar, getClass())) {
            a();
        }
    }
}