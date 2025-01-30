package h.c.n0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableError.java */
/* loaded from: classes3.dex */
public final class w0<T> extends h.c.h<T> {
    final Callable<? extends Throwable> a;

    public w0(Callable<? extends Throwable> callable) {
        this.a = callable;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        try {
            th = (Throwable) h.c.n0.b.b.e(this.a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            io.reactivex.exceptions.a.b(th);
        }
        h.c.n0.i.d.q(th, cVar);
    }
}