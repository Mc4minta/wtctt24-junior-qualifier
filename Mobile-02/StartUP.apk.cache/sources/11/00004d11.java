package h.c.n0.e.b;

/* compiled from: FlowableSerialized.java */
/* loaded from: classes3.dex */
public final class n3<T> extends a<T, T> {
    public n3(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new h.c.w0.d(cVar));
    }
}