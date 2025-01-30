package h.c.n0.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableFromCallable.java */
/* loaded from: classes.dex */
public final class f extends h.c.c {
    final Callable<?> a;

    public f(Callable<?> callable) {
        this.a = callable;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        h.c.k0.b b2 = h.c.k0.c.b();
        eVar.onSubscribe(b2);
        try {
            this.a.call();
            if (b2.isDisposed()) {
                return;
            }
            eVar.onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!b2.isDisposed()) {
                eVar.onError(th);
            } else {
                h.c.r0.a.u(th);
            }
        }
    }
}