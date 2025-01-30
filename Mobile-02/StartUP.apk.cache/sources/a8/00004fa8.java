package h.c.n0.e.g;

/* compiled from: SingleJust.java */
/* loaded from: classes3.dex */
public final class i0<T> extends h.c.b0<T> {
    final T a;

    public i0(T t) {
        this.a = t;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        e0Var.onSubscribe(h.c.k0.c.a());
        e0Var.onSuccess((T) this.a);
    }
}