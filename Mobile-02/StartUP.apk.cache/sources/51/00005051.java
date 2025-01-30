package h.c.p0;

import h.c.n0.j.h;
import h.c.z;

/* compiled from: DefaultObserver.java */
/* loaded from: classes3.dex */
public abstract class b<T> implements z<T> {
    private h.c.k0.b a;

    protected void a() {
    }

    @Override // h.c.z
    public final void onSubscribe(h.c.k0.b bVar) {
        if (h.e(this.a, bVar, getClass())) {
            this.a = bVar;
            a();
        }
    }
}