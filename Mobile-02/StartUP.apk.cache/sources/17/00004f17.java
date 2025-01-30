package h.c.n0.e.e;

import h.c.n0.e.e.w2;

/* compiled from: ObservableJust.java */
/* loaded from: classes3.dex */
public final class r1<T> extends h.c.s<T> implements h.c.n0.c.h<T> {
    private final T a;

    public r1(T t) {
        this.a = t;
    }

    @Override // h.c.n0.c.h, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        w2.a aVar = new w2.a(zVar, this.a);
        zVar.onSubscribe(aVar);
        aVar.run();
    }
}