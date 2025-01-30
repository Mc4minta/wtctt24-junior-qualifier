package h.c.w0;

import h.c.m;
import h.c.n0.j.h;

/* compiled from: DefaultSubscriber.java */
/* loaded from: classes3.dex */
public abstract class a<T> implements m<T> {
    k.a.d a;

    protected void a() {
        b(Long.MAX_VALUE);
    }

    protected final void b(long j2) {
        k.a.d dVar = this.a;
        if (dVar != null) {
            dVar.request(j2);
        }
    }

    @Override // h.c.m, k.a.c
    public final void onSubscribe(k.a.d dVar) {
        if (h.f(this.a, dVar, getClass())) {
            this.a = dVar;
            a();
        }
    }
}