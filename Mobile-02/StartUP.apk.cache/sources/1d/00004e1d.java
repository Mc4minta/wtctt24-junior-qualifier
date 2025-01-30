package h.c.n0.e.e;

/* compiled from: ObservableNever.java */
/* loaded from: classes3.dex */
public final class b2 extends h.c.s<Object> {
    public static final h.c.s<Object> a = new b2();

    private b2() {
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super Object> zVar) {
        zVar.onSubscribe(h.c.n0.a.d.NEVER);
    }
}