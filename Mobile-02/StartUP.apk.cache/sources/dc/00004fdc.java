package h.c.n0.e.g;

import java.util.concurrent.Callable;

/* compiled from: SingleError.java */
/* loaded from: classes3.dex */
public final class w<T> extends h.c.b0<T> {
    final Callable<? extends Throwable> a;

    public w(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        try {
            th = (Throwable) h.c.n0.b.b.e(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            io.reactivex.exceptions.a.b(th);
        }
        h.c.n0.a.d.z(th, e0Var);
    }
}