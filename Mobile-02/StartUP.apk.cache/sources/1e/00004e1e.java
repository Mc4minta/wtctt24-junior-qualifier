package h.c.n0.e.e;

/* compiled from: ObservableSerialized.java */
/* loaded from: classes3.dex */
public final class b3<T> extends a<T, T> {
    public b3(h.c.s<T> sVar) {
        super(sVar);
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new h.c.p0.f(zVar));
    }
}