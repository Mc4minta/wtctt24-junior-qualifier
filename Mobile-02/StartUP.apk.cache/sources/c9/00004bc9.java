package h.c.n0.a;

import h.c.e0;
import h.c.z;

/* compiled from: EmptyDisposable.java */
/* loaded from: classes.dex */
public enum d implements h.c.n0.c.e<Object> {
    INSTANCE,
    NEVER;

    public static void h(h.c.e eVar) {
        eVar.onSubscribe(INSTANCE);
        eVar.onComplete();
    }

    public static void q(z<?> zVar) {
        zVar.onSubscribe(INSTANCE);
        zVar.onComplete();
    }

    public static void s(Throwable th, h.c.e eVar) {
        eVar.onSubscribe(INSTANCE);
        eVar.onError(th);
    }

    public static void y(Throwable th, z<?> zVar) {
        zVar.onSubscribe(INSTANCE);
        zVar.onError(th);
    }

    public static void z(Throwable th, e0<?> e0Var) {
        e0Var.onSubscribe(INSTANCE);
        e0Var.onError(th);
    }

    @Override // h.c.n0.c.j
    public void clear() {
    }

    @Override // h.c.k0.b
    public void dispose() {
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return true;
    }

    @Override // h.c.n0.c.f
    public int n(int i2) {
        return i2 & 2;
    }

    @Override // h.c.n0.c.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.c.n0.c.j
    public Object poll() throws Exception {
        return null;
    }
}