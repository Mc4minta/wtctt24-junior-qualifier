package h.c.w0;

import h.c.m;
import h.c.n0.i.g;
import h.c.n0.j.h;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableSubscriber.java */
/* loaded from: classes3.dex */
public abstract class b<T> implements m<T>, h.c.k0.b {
    final AtomicReference<k.a.d> a = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        dispose();
    }

    protected void c() {
        this.a.get().request(Long.MAX_VALUE);
    }

    @Override // h.c.k0.b
    public final void dispose() {
        g.h(this.a);
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.a.get() == g.CANCELLED;
    }

    @Override // h.c.m, k.a.c
    public final void onSubscribe(k.a.d dVar) {
        if (h.d(this.a, dVar, getClass())) {
            c();
        }
    }
}