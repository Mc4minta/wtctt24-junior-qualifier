package h.c.n0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableDefer.java */
/* loaded from: classes3.dex */
public final class h0<T> extends h.c.h<T> {
    final Callable<? extends k.a.b<? extends T>> a;

    public h0(Callable<? extends k.a.b<? extends T>> callable) {
        this.a = callable;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        try {
            ((k.a.b) h.c.n0.b.b.e(this.a.call(), "The publisher supplied is null")).subscribe(cVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}