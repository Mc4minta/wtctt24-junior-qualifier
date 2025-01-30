package h.c.n0.e.g;

import java.util.concurrent.Callable;

/* compiled from: SingleFromCallable.java */
/* loaded from: classes3.dex */
public final class d0<T> extends h.c.b0<T> {
    final Callable<? extends T> a;

    public d0(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        h.c.k0.b b2 = h.c.k0.c.b();
        e0Var.onSubscribe(b2);
        if (b2.isDisposed()) {
            return;
        }
        try {
            Object obj = (Object) h.c.n0.b.b.e(this.a.call(), "The callable returned a null value");
            if (b2.isDisposed()) {
                return;
            }
            e0Var.onSuccess(obj);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!b2.isDisposed()) {
                e0Var.onError(th);
            } else {
                h.c.r0.a.u(th);
            }
        }
    }
}