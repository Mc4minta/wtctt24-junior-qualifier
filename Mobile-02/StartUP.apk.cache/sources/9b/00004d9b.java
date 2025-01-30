package h.c.n0.e.b;

/* compiled from: FlowableJust.java */
/* loaded from: classes3.dex */
public final class v1<T> extends h.c.h<T> implements h.c.n0.c.h<T> {
    private final T a;

    public v1(T t) {
        this.a = t;
    }

    @Override // h.c.n0.c.h, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        cVar.onSubscribe(new h.c.n0.i.e(cVar, this.a));
    }
}