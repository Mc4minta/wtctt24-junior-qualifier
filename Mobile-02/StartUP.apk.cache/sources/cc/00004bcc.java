package h.c.n0.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequentialDisposable.java */
/* loaded from: classes.dex */
public final class g extends AtomicReference<h.c.k0.b> implements h.c.k0.b {
    public g() {
    }

    public boolean a(h.c.k0.b bVar) {
        return c.q(this, bVar);
    }

    public boolean b(h.c.k0.b bVar) {
        return c.y(this, bVar);
    }

    @Override // h.c.k0.b
    public void dispose() {
        c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return c.n(get());
    }

    public g(h.c.k0.b bVar) {
        lazySet(bVar);
    }
}