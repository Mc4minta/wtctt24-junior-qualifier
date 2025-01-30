package h.c;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: Completable.java */
/* loaded from: classes2.dex */
public abstract class c implements f {
    public static c g() {
        return h.c.r0.a.k(h.c.n0.e.a.d.a);
    }

    public static c i(Callable<? extends f> callable) {
        h.c.n0.b.b.e(callable, "completableSupplier");
        return h.c.r0.a.k(new h.c.n0.e.a.b(callable));
    }

    private c n(h.c.m0.f<? super h.c.k0.b> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2, h.c.m0.a aVar3, h.c.m0.a aVar4) {
        h.c.n0.b.b.e(fVar, "onSubscribe is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.b.b.e(aVar2, "onTerminate is null");
        h.c.n0.b.b.e(aVar3, "onAfterTerminate is null");
        h.c.n0.b.b.e(aVar4, "onDispose is null");
        return h.c.r0.a.k(new h.c.n0.e.a.i(this, fVar, fVar2, aVar, aVar2, aVar3, aVar4));
    }

    public static c q(Throwable th) {
        h.c.n0.b.b.e(th, "error is null");
        return h.c.r0.a.k(new h.c.n0.e.a.e(th));
    }

    public static c r(Callable<?> callable) {
        h.c.n0.b.b.e(callable, "callable is null");
        return h.c.r0.a.k(new h.c.n0.e.a.f(callable));
    }

    public static c u(long j2, TimeUnit timeUnit) {
        return v(j2, timeUnit, h.c.u0.a.a());
    }

    public static c v(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.k(new h.c.n0.e.a.j(j2, timeUnit, a0Var));
    }

    private static NullPointerException w(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final h.c.k0.b b(h.c.m0.a aVar, h.c.m0.f<? super Throwable> fVar) {
        h.c.n0.b.b.e(fVar, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.d.j jVar = new h.c.n0.d.j(fVar, aVar);
        c(jVar);
        return jVar;
    }

    @Override // h.c.f
    public final void c(e eVar) {
        h.c.n0.b.b.e(eVar, "observer is null");
        try {
            e y = h.c.r0.a.y(this, eVar);
            h.c.n0.b.b.e(y, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            t(y);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
            throw w(th);
        }
    }

    public final h.c.k0.b d(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.d.j jVar = new h.c.n0.d.j(aVar);
        c(jVar);
        return jVar;
    }

    public final <R> R f(d<? extends R> dVar) {
        return (R) ((d) h.c.n0.b.b.e(dVar, "converter is null")).b(this);
    }

    public final c h(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return h.c.r0.a.k(new h.c.n0.e.a.a(this, fVar));
    }

    public final c j(long j2, TimeUnit timeUnit) {
        return k(j2, timeUnit, h.c.u0.a.a(), false);
    }

    public final c k(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.k(new h.c.n0.e.a.c(this, j2, timeUnit, a0Var, z));
    }

    public final c l(h.c.m0.a aVar) {
        h.c.m0.f<? super h.c.k0.b> h2 = h.c.n0.b.a.h();
        h.c.m0.f<? super Throwable> h3 = h.c.n0.b.a.h();
        h.c.m0.a aVar2 = h.c.n0.b.a.f14096c;
        return n(h2, h3, aVar, aVar2, aVar2, aVar2);
    }

    public final c m(h.c.m0.f<? super Throwable> fVar) {
        h.c.m0.f<? super h.c.k0.b> h2 = h.c.n0.b.a.h();
        h.c.m0.a aVar = h.c.n0.b.a.f14096c;
        return n(h2, fVar, aVar, aVar, aVar, aVar);
    }

    public final c o(h.c.m0.f<? super h.c.k0.b> fVar) {
        h.c.m0.f<? super Throwable> h2 = h.c.n0.b.a.h();
        h.c.m0.a aVar = h.c.n0.b.a.f14096c;
        return n(fVar, h2, aVar, aVar, aVar, aVar);
    }

    public final c p(h.c.m0.a aVar) {
        h.c.m0.f<? super h.c.k0.b> h2 = h.c.n0.b.a.h();
        h.c.m0.f<? super Throwable> h3 = h.c.n0.b.a.h();
        h.c.m0.a aVar2 = h.c.n0.b.a.f14096c;
        return n(h2, h3, aVar2, aVar, aVar2, aVar2);
    }

    public final c s(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.k(new h.c.n0.e.a.h(this, a0Var));
    }

    public final h.c.k0.b subscribe() {
        h.c.n0.d.n nVar = new h.c.n0.d.n();
        c(nVar);
        return nVar;
    }

    protected abstract void t(e eVar);

    public final <T> b0<T> x(T t) {
        h.c.n0.b.b.e(t, "completionValue is null");
        return h.c.r0.a.o(new h.c.n0.e.a.l(this, null, t));
    }
}