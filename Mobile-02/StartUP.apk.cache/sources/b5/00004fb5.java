package h.c.n0.e.g;

/* compiled from: SingleNever.java */
/* loaded from: classes3.dex */
public final class m0 extends h.c.b0<Object> {
    public static final h.c.b0<Object> a = new m0();

    private m0() {
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Object> e0Var) {
        e0Var.onSubscribe(h.c.n0.a.d.NEVER);
    }
}