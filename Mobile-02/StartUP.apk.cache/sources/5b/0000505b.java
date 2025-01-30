package h.c.r0;

import h.c.a0;
import h.c.b0;
import h.c.c;
import h.c.e;
import h.c.e0;
import h.c.h;
import h.c.m0.f;
import h.c.m0.n;
import h.c.n0.b.b;
import h.c.n0.j.j;
import h.c.o;
import h.c.p;
import h.c.s;
import h.c.z;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes3.dex */
public final class a {
    static volatile f<? super Throwable> a;

    /* renamed from: b  reason: collision with root package name */
    static volatile n<? super Runnable, ? extends Runnable> f16798b;

    /* renamed from: c  reason: collision with root package name */
    static volatile n<? super Callable<a0>, ? extends a0> f16799c;

    /* renamed from: d  reason: collision with root package name */
    static volatile n<? super Callable<a0>, ? extends a0> f16800d;

    /* renamed from: e  reason: collision with root package name */
    static volatile n<? super Callable<a0>, ? extends a0> f16801e;

    /* renamed from: f  reason: collision with root package name */
    static volatile n<? super Callable<a0>, ? extends a0> f16802f;

    /* renamed from: g  reason: collision with root package name */
    static volatile n<? super a0, ? extends a0> f16803g;

    /* renamed from: h  reason: collision with root package name */
    static volatile n<? super a0, ? extends a0> f16804h;

    /* renamed from: i  reason: collision with root package name */
    static volatile n<? super a0, ? extends a0> f16805i;

    /* renamed from: j  reason: collision with root package name */
    static volatile n<? super h, ? extends h> f16806j;

    /* renamed from: k  reason: collision with root package name */
    static volatile n<? super h.c.l0.a, ? extends h.c.l0.a> f16807k;

    /* renamed from: l  reason: collision with root package name */
    static volatile n<? super s, ? extends s> f16808l;
    static volatile n<? super h.c.o0.a, ? extends h.c.o0.a> m;
    static volatile n<? super o, ? extends o> n;
    static volatile n<? super b0, ? extends b0> o;
    static volatile n<? super c, ? extends c> p;
    static volatile n<? super h.c.q0.a, ? extends h.c.q0.a> q;
    static volatile h.c.m0.c<? super h, ? super k.a.c, ? extends k.a.c> r;
    static volatile h.c.m0.c<? super o, ? super p, ? extends p> s;
    static volatile h.c.m0.c<? super s, ? super z, ? extends z> t;
    static volatile h.c.m0.c<? super b0, ? super e0, ? extends e0> u;
    static volatile h.c.m0.c<? super c, ? super e, ? extends e> v;
    static volatile h.c.m0.e w;
    static volatile boolean x;
    static volatile boolean y;

    public static <T> z<? super T> A(s<T> sVar, z<? super T> zVar) {
        h.c.m0.c<? super s, ? super z, ? extends z> cVar = t;
        return cVar != null ? (z) a(cVar, sVar, zVar) : zVar;
    }

    public static <T> e0<? super T> B(b0<T> b0Var, e0<? super T> e0Var) {
        h.c.m0.c<? super b0, ? super e0, ? extends e0> cVar = u;
        return cVar != null ? (e0) a(cVar, b0Var, e0Var) : e0Var;
    }

    public static <T> k.a.c<? super T> C(h<T> hVar, k.a.c<? super T> cVar) {
        h.c.m0.c<? super h, ? super k.a.c, ? extends k.a.c> cVar2 = r;
        return cVar2 != null ? (k.a.c) a(cVar2, hVar, cVar) : cVar;
    }

    public static void D(f<? super Throwable> fVar) {
        if (!x) {
            a = fVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void E(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static <T, U, R> R a(h.c.m0.c<T, U, R> cVar, T t2, U u2) {
        try {
            return cVar.apply(t2, u2);
        } catch (Throwable th) {
            throw j.e(th);
        }
    }

    static <T, R> R b(n<T, R> nVar, T t2) {
        try {
            return nVar.apply(t2);
        } catch (Throwable th) {
            throw j.e(th);
        }
    }

    static a0 c(n<? super Callable<a0>, ? extends a0> nVar, Callable<a0> callable) {
        return (a0) b.e(b(nVar, callable), "Scheduler Callable result can't be null");
    }

    static a0 d(Callable<a0> callable) {
        try {
            return (a0) b.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw j.e(th);
        }
    }

    public static a0 e(Callable<a0> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n<? super Callable<a0>, ? extends a0> nVar = f16799c;
        if (nVar == null) {
            return d(callable);
        }
        return c(nVar, callable);
    }

    public static a0 f(Callable<a0> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n<? super Callable<a0>, ? extends a0> nVar = f16801e;
        if (nVar == null) {
            return d(callable);
        }
        return c(nVar, callable);
    }

    public static a0 g(Callable<a0> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n<? super Callable<a0>, ? extends a0> nVar = f16802f;
        if (nVar == null) {
            return d(callable);
        }
        return c(nVar, callable);
    }

    public static a0 h(Callable<a0> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n<? super Callable<a0>, ? extends a0> nVar = f16800d;
        if (nVar == null) {
            return d(callable);
        }
        return c(nVar, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static boolean j() {
        return y;
    }

    public static c k(c cVar) {
        n<? super c, ? extends c> nVar = p;
        return nVar != null ? (c) b(nVar, cVar) : cVar;
    }

    public static <T> h<T> l(h<T> hVar) {
        n<? super h, ? extends h> nVar = f16806j;
        return nVar != null ? (h) b(nVar, hVar) : hVar;
    }

    public static <T> o<T> m(o<T> oVar) {
        n<? super o, ? extends o> nVar = n;
        return nVar != null ? (o) b(nVar, oVar) : oVar;
    }

    public static <T> s<T> n(s<T> sVar) {
        n<? super s, ? extends s> nVar = f16808l;
        return nVar != null ? (s) b(nVar, sVar) : sVar;
    }

    public static <T> b0<T> o(b0<T> b0Var) {
        n<? super b0, ? extends b0> nVar = o;
        return nVar != null ? (b0) b(nVar, b0Var) : b0Var;
    }

    public static <T> h.c.l0.a<T> p(h.c.l0.a<T> aVar) {
        n<? super h.c.l0.a, ? extends h.c.l0.a> nVar = f16807k;
        return nVar != null ? (h.c.l0.a) b(nVar, aVar) : aVar;
    }

    public static <T> h.c.o0.a<T> q(h.c.o0.a<T> aVar) {
        n<? super h.c.o0.a, ? extends h.c.o0.a> nVar = m;
        return nVar != null ? (h.c.o0.a) b(nVar, aVar) : aVar;
    }

    public static <T> h.c.q0.a<T> r(h.c.q0.a<T> aVar) {
        n<? super h.c.q0.a, ? extends h.c.q0.a> nVar = q;
        return nVar != null ? (h.c.q0.a) b(nVar, aVar) : aVar;
    }

    public static boolean s() {
        h.c.m0.e eVar = w;
        if (eVar != null) {
            try {
                return eVar.a();
            } catch (Throwable th) {
                throw j.e(th);
            }
        }
        return false;
    }

    public static a0 t(a0 a0Var) {
        n<? super a0, ? extends a0> nVar = f16803g;
        return nVar == null ? a0Var : (a0) b(nVar, a0Var);
    }

    public static void u(Throwable th) {
        f<? super Throwable> fVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (fVar != null) {
            try {
                fVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                E(th2);
            }
        }
        th.printStackTrace();
        E(th);
    }

    public static a0 v(a0 a0Var) {
        n<? super a0, ? extends a0> nVar = f16805i;
        return nVar == null ? a0Var : (a0) b(nVar, a0Var);
    }

    public static Runnable w(Runnable runnable) {
        b.e(runnable, "run is null");
        n<? super Runnable, ? extends Runnable> nVar = f16798b;
        return nVar == null ? runnable : (Runnable) b(nVar, runnable);
    }

    public static a0 x(a0 a0Var) {
        n<? super a0, ? extends a0> nVar = f16804h;
        return nVar == null ? a0Var : (a0) b(nVar, a0Var);
    }

    public static e y(c cVar, e eVar) {
        h.c.m0.c<? super c, ? super e, ? extends e> cVar2 = v;
        return cVar2 != null ? (e) a(cVar2, cVar, eVar) : eVar;
    }

    public static <T> p<? super T> z(o<T> oVar, p<? super T> pVar) {
        h.c.m0.c<? super o, ? super p, ? extends p> cVar = s;
        return cVar != null ? (p) a(cVar, oVar, pVar) : pVar;
    }
}