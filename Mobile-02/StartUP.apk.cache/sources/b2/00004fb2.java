package h.c.n0.e.g;

/* compiled from: SingleMaterialize.java */
/* loaded from: classes3.dex */
public final class l0<T> extends h.c.b0<h.c.r<T>> {
    final h.c.b0<T> a;

    public l0(h.c.b0<T> b0Var) {
        this.a = b0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super h.c.r<T>> e0Var) {
        this.a.subscribe(new h.c.n0.e.d.g(e0Var));
    }
}