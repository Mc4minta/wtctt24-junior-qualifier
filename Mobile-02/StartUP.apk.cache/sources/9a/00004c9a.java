package h.c.n0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableFromCallable.java */
/* loaded from: classes3.dex */
public final class g1<T> extends h.c.h<T> implements Callable<T> {
    final Callable<? extends T> a;

    public g1(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) h.c.n0.b.b.e(this.a.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.n0.i.c cVar2 = new h.c.n0.i.c(cVar);
        cVar.onSubscribe(cVar2);
        try {
            cVar2.c(h.c.n0.b.b.e(this.a.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (cVar2.d()) {
                h.c.r0.a.u(th);
            } else {
                cVar.onError(th);
            }
        }
    }
}