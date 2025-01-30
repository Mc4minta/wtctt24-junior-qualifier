package h.c.n0.e.b;

import h.c.n0.e.b.w2;
import java.util.concurrent.Callable;

/* compiled from: FlowableReduceWithSingle.java */
/* loaded from: classes3.dex */
public final class x2<T, R> extends h.c.b0<R> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<R> f15211b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.c<R, ? super T, R> f15212c;

    public x2(k.a.b<T> bVar, Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        this.a = bVar;
        this.f15211b = callable;
        this.f15212c = cVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        try {
            this.a.subscribe(new w2.a(e0Var, this.f15212c, h.c.n0.b.b.e(this.f15211b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}