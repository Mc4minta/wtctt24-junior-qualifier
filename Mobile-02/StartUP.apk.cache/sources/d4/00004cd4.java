package h.c.n0.e.b;

/* compiled from: FlowableFromPublisher.java */
/* loaded from: classes3.dex */
public final class k1<T> extends h.c.h<T> {
    final k.a.b<? extends T> a;

    public k1(k.a.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe(cVar);
    }
}