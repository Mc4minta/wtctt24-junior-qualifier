package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableError.java */
/* loaded from: classes3.dex */
public final class t0<T> extends h.c.s<T> {
    final Callable<? extends Throwable> a;

    public t0(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        try {
            th = (Throwable) h.c.n0.b.b.e(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            io.reactivex.exceptions.a.b(th);
        }
        h.c.n0.a.d.y(th, zVar);
    }
}