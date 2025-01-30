package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableFromCallable.java */
/* loaded from: classes3.dex */
public final class c1<T> extends h.c.s<T> implements Callable<T> {
    final Callable<? extends T> a;

    public c1(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) h.c.n0.b.b.e(this.a.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.d.l lVar = new h.c.n0.d.l(zVar);
        zVar.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            lVar.b(h.c.n0.b.b.e(this.a.call(), "Callable returned null"));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!lVar.isDisposed()) {
                zVar.onError(th);
            } else {
                h.c.r0.a.u(th);
            }
        }
    }
}