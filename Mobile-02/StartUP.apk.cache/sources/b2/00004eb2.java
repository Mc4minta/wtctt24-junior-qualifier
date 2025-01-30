package h.c.n0.e.e;

import h.c.n0.e.e.k2;
import java.util.concurrent.Callable;

/* compiled from: ObservableReduceWithSingle.java */
/* loaded from: classes3.dex */
public final class l2<T, R> extends h.c.b0<R> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<R> f15912b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.c<R, ? super T, R> f15913c;

    public l2(h.c.x<T> xVar, Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        this.a = xVar;
        this.f15912b = callable;
        this.f15913c = cVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        try {
            this.a.subscribe(new k2.a(e0Var, this.f15913c, h.c.n0.b.b.e(this.f15912b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}