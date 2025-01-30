package h.c.n0.e.a;

import h.c.n0.d.z;

/* compiled from: CompletableToFlowable.java */
/* loaded from: classes.dex */
public final class k<T> extends h.c.h<T> {
    final h.c.f a;

    public k(h.c.f fVar) {
        this.a = fVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.c(new z(cVar));
    }
}