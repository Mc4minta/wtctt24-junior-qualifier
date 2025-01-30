package h.c.j0.b;

import h.c.a0;
import h.c.m0.n;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes2.dex */
public final class a {
    private static volatile n<Callable<a0>, a0> a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile n<a0, a0> f14083b;

    static <T, R> R a(n<T, R> nVar, T t) {
        try {
            return nVar.apply(t);
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.a(th);
        }
    }

    static a0 b(n<Callable<a0>, a0> nVar, Callable<a0> callable) {
        a0 a0Var = (a0) a(nVar, callable);
        Objects.requireNonNull(a0Var, "Scheduler Callable returned null");
        return a0Var;
    }

    static a0 c(Callable<a0> callable) {
        try {
            a0 call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.a(th);
        }
    }

    public static a0 d(Callable<a0> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        n<Callable<a0>, a0> nVar = a;
        if (nVar == null) {
            return c(callable);
        }
        return b(nVar, callable);
    }

    public static a0 e(a0 a0Var) {
        Objects.requireNonNull(a0Var, "scheduler == null");
        n<a0, a0> nVar = f14083b;
        return nVar == null ? a0Var : (a0) a(nVar, a0Var);
    }

    public static void f(n<a0, a0> nVar) {
        f14083b = nVar;
    }
}