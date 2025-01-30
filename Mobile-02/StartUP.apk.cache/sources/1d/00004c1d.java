package h.c.n0.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableDefer.java */
/* loaded from: classes.dex */
public final class b extends h.c.c {
    final Callable<? extends h.c.f> a;

    public b(Callable<? extends h.c.f> callable) {
        this.a = callable;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        try {
            ((h.c.f) h.c.n0.b.b.e(this.a.call(), "The completableSupplier returned a null CompletableSource")).c(eVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.s(th, eVar);
        }
    }
}