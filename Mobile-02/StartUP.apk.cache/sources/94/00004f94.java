package h.c.n0.e.g;

import java.util.concurrent.Callable;

/* compiled from: SingleDefer.java */
/* loaded from: classes3.dex */
public final class e<T> extends h.c.b0<T> {
    final Callable<? extends h.c.h0<? extends T>> a;

    public e(Callable<? extends h.c.h0<? extends T>> callable) {
        this.a = callable;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        try {
            ((h.c.h0) h.c.n0.b.b.e(this.a.call(), "The singleSupplier returned a null SingleSource")).subscribe(e0Var);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}