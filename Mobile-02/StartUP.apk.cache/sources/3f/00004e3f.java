package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableDefer.java */
/* loaded from: classes3.dex */
public final class e0<T> extends h.c.s<T> {
    final Callable<? extends h.c.x<? extends T>> a;

    public e0(Callable<? extends h.c.x<? extends T>> callable) {
        this.a = callable;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        try {
            ((h.c.x) h.c.n0.b.b.e(this.a.call(), "null ObservableSource supplied")).subscribe(zVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }
}