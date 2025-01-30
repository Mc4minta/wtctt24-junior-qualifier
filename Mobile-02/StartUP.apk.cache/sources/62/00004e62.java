package h.c.n0.e.e;

/* compiled from: ObservableFromUnsafeSource.java */
/* loaded from: classes3.dex */
public final class g1<T> extends h.c.s<T> {
    final h.c.x<T> a;

    public g1(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(zVar);
    }
}