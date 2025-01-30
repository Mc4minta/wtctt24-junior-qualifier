package h.c.n0.e.g;

/* compiled from: SingleFromUnsafeSource.java */
/* loaded from: classes3.dex */
public final class f0<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    public f0(h.c.h0<T> h0Var) {
        this.a = h0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(e0Var);
    }
}