package h.c;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import h.c.n0.e.b.m2;
import h.c.n0.e.e.a1;
import h.c.n0.e.e.a2;
import h.c.n0.e.e.a3;
import h.c.n0.e.e.a4;
import h.c.n0.e.e.b1;
import h.c.n0.e.e.b2;
import h.c.n0.e.e.b3;
import h.c.n0.e.e.b4;
import h.c.n0.e.e.c1;
import h.c.n0.e.e.c2;
import h.c.n0.e.e.c3;
import h.c.n0.e.e.c4;
import h.c.n0.e.e.d1;
import h.c.n0.e.e.d2;
import h.c.n0.e.e.d3;
import h.c.n0.e.e.d4;
import h.c.n0.e.e.e1;
import h.c.n0.e.e.e2;
import h.c.n0.e.e.e3;
import h.c.n0.e.e.e4;
import h.c.n0.e.e.f1;
import h.c.n0.e.e.f2;
import h.c.n0.e.e.f3;
import h.c.n0.e.e.f4;
import h.c.n0.e.e.g1;
import h.c.n0.e.e.g2;
import h.c.n0.e.e.g3;
import h.c.n0.e.e.g4;
import h.c.n0.e.e.h1;
import h.c.n0.e.e.h2;
import h.c.n0.e.e.h3;
import h.c.n0.e.e.h4;
import h.c.n0.e.e.i1;
import h.c.n0.e.e.i2;
import h.c.n0.e.e.i3;
import h.c.n0.e.e.i4;
import h.c.n0.e.e.j0;
import h.c.n0.e.e.j1;
import h.c.n0.e.e.j2;
import h.c.n0.e.e.j3;
import h.c.n0.e.e.j4;
import h.c.n0.e.e.k0;
import h.c.n0.e.e.k1;
import h.c.n0.e.e.k2;
import h.c.n0.e.e.k3;
import h.c.n0.e.e.k4;
import h.c.n0.e.e.l0;
import h.c.n0.e.e.l1;
import h.c.n0.e.e.l2;
import h.c.n0.e.e.l3;
import h.c.n0.e.e.l4;
import h.c.n0.e.e.m0;
import h.c.n0.e.e.m1;
import h.c.n0.e.e.m3;
import h.c.n0.e.e.n0;
import h.c.n0.e.e.n1;
import h.c.n0.e.e.n2;
import h.c.n0.e.e.n3;
import h.c.n0.e.e.o0;
import h.c.n0.e.e.o1;
import h.c.n0.e.e.o2;
import h.c.n0.e.e.o3;
import h.c.n0.e.e.p1;
import h.c.n0.e.e.p2;
import h.c.n0.e.e.p3;
import h.c.n0.e.e.q0;
import h.c.n0.e.e.q1;
import h.c.n0.e.e.q2;
import h.c.n0.e.e.q3;
import h.c.n0.e.e.r0;
import h.c.n0.e.e.r1;
import h.c.n0.e.e.r2;
import h.c.n0.e.e.r3;
import h.c.n0.e.e.s0;
import h.c.n0.e.e.s1;
import h.c.n0.e.e.s2;
import h.c.n0.e.e.s3;
import h.c.n0.e.e.t0;
import h.c.n0.e.e.t1;
import h.c.n0.e.e.t2;
import h.c.n0.e.e.t3;
import h.c.n0.e.e.u0;
import h.c.n0.e.e.u1;
import h.c.n0.e.e.u2;
import h.c.n0.e.e.u3;
import h.c.n0.e.e.v0;
import h.c.n0.e.e.v1;
import h.c.n0.e.e.v2;
import h.c.n0.e.e.v3;
import h.c.n0.e.e.w1;
import h.c.n0.e.e.w2;
import h.c.n0.e.e.w3;
import h.c.n0.e.e.x0;
import h.c.n0.e.e.x1;
import h.c.n0.e.e.x2;
import h.c.n0.e.e.x3;
import h.c.n0.e.e.y0;
import h.c.n0.e.e.y1;
import h.c.n0.e.e.y2;
import h.c.n0.e.e.y3;
import h.c.n0.e.e.z0;
import h.c.n0.e.e.z1;
import h.c.n0.e.e.z3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Observable.java */
/* loaded from: classes2.dex */
public abstract class s<T> implements x<T> {

    /* compiled from: Observable.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> s<T> amb(Iterable<? extends x<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return h.c.r0.a.n(new h.c.n0.e.e.h(null, iterable));
    }

    public static <T> s<T> ambArray(x<? extends T>... xVarArr) {
        h.c.n0.b.b.e(xVarArr, "sources is null");
        int length = xVarArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(xVarArr[0]);
        }
        return h.c.r0.a.n(new h.c.n0.e.e.h(xVarArr, null));
    }

    public static int bufferSize() {
        return h.bufferSize();
    }

    public static <T, R> s<R> combineLatest(h.c.m0.n<? super Object[], ? extends R> nVar, int i2, x<? extends T>... xVarArr) {
        return combineLatest(xVarArr, nVar, i2);
    }

    public static <T, R> s<R> combineLatestDelayError(x<? extends T>[] xVarArr, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatestDelayError(xVarArr, nVar, bufferSize());
    }

    public static <T> s<T> concat(Iterable<? extends x<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(h.c.n0.b.a.j(), bufferSize(), false);
    }

    public static <T> s<T> concatArray(x<? extends T>... xVarArr) {
        if (xVarArr.length == 0) {
            return empty();
        }
        if (xVarArr.length == 1) {
            return wrap(xVarArr[0]);
        }
        return h.c.r0.a.n(new h.c.n0.e.e.u(fromArray(xVarArr), h.c.n0.b.a.j(), bufferSize(), h.c.n0.j.i.BOUNDARY));
    }

    public static <T> s<T> concatArrayDelayError(x<? extends T>... xVarArr) {
        if (xVarArr.length == 0) {
            return empty();
        }
        if (xVarArr.length == 1) {
            return wrap(xVarArr[0]);
        }
        return concatDelayError(fromArray(xVarArr));
    }

    public static <T> s<T> concatArrayEager(x<? extends T>... xVarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), xVarArr);
    }

    public static <T> s<T> concatArrayEagerDelayError(x<? extends T>... xVarArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), xVarArr);
    }

    public static <T> s<T> concatDelayError(Iterable<? extends x<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> s<T> concatEager(x<? extends x<? extends T>> xVar) {
        return concatEager(xVar, bufferSize(), bufferSize());
    }

    public static <T> s<T> create(v<T> vVar) {
        h.c.n0.b.b.e(vVar, "source is null");
        return h.c.r0.a.n(new h.c.n0.e.e.b0(vVar));
    }

    public static <T> s<T> defer(Callable<? extends x<? extends T>> callable) {
        h.c.n0.b.b.e(callable, "supplier is null");
        return h.c.r0.a.n(new h.c.n0.e.e.e0(callable));
    }

    private s<T> doOnEach(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.b.b.e(aVar2, "onAfterTerminate is null");
        return h.c.r0.a.n(new n0(this, fVar, fVar2, aVar, aVar2));
    }

    public static <T> s<T> empty() {
        return h.c.r0.a.n(s0.a);
    }

    public static <T> s<T> error(Callable<? extends Throwable> callable) {
        h.c.n0.b.b.e(callable, "errorSupplier is null");
        return h.c.r0.a.n(new t0(callable));
    }

    public static <T> s<T> fromArray(T... tArr) {
        h.c.n0.b.b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return h.c.r0.a.n(new b1(tArr));
    }

    public static <T> s<T> fromCallable(Callable<? extends T> callable) {
        h.c.n0.b.b.e(callable, "supplier is null");
        return h.c.r0.a.n(new c1(callable));
    }

    public static <T> s<T> fromFuture(Future<? extends T> future) {
        h.c.n0.b.b.e(future, "future is null");
        return h.c.r0.a.n(new d1(future, 0L, null));
    }

    public static <T> s<T> fromIterable(Iterable<? extends T> iterable) {
        h.c.n0.b.b.e(iterable, "source is null");
        return h.c.r0.a.n(new e1(iterable));
    }

    public static <T> s<T> fromPublisher(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "publisher is null");
        return h.c.r0.a.n(new f1(bVar));
    }

    public static <T> s<T> generate(h.c.m0.f<g<T>> fVar) {
        h.c.n0.b.b.e(fVar, "generator is null");
        return generate(h.c.n0.b.a.t(), n1.m(fVar), h.c.n0.b.a.h());
    }

    public static s<Long> interval(long j2, long j3, TimeUnit timeUnit) {
        return interval(j2, j3, timeUnit, h.c.u0.a.a());
    }

    public static s<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return intervalRange(j2, j3, j4, j5, timeUnit, h.c.u0.a.a());
    }

    public static <T> s<T> just(T t) {
        h.c.n0.b.b.e(t, "item is null");
        return h.c.r0.a.n(new r1(t));
    }

    public static <T> s<T> merge(Iterable<? extends x<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), false, i2, i3);
    }

    public static <T> s<T> mergeArray(int i2, int i3, x<? extends T>... xVarArr) {
        return fromArray(xVarArr).flatMap(h.c.n0.b.a.j(), false, i2, i3);
    }

    public static <T> s<T> mergeArrayDelayError(int i2, int i3, x<? extends T>... xVarArr) {
        return fromArray(xVarArr).flatMap(h.c.n0.b.a.j(), true, i2, i3);
    }

    public static <T> s<T> mergeDelayError(Iterable<? extends x<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), true);
    }

    public static <T> s<T> never() {
        return h.c.r0.a.n(b2.a);
    }

    public static s<Integer> range(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        } else if (i3 == 0) {
            return empty();
        } else {
            if (i3 == 1) {
                return just(Integer.valueOf(i2));
            }
            if (i2 + (i3 - 1) <= 2147483647L) {
                return h.c.r0.a.n(new h2(i2, i3));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static s<Long> rangeLong(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        } else if (i2 == 0) {
            return empty();
        } else {
            if (j3 == 1) {
                return just(Long.valueOf(j2));
            }
            long j4 = (j3 - 1) + j2;
            if (j2 > 0 && j4 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            return h.c.r0.a.n(new i2(j2, j3));
        }
    }

    public static <T> b0<Boolean> sequenceEqual(x<? extends T> xVar, x<? extends T> xVar2) {
        return sequenceEqual(xVar, xVar2, h.c.n0.b.b.d(), bufferSize());
    }

    public static <T> s<T> switchOnNext(x<? extends x<? extends T>> xVar, int i2) {
        h.c.n0.b.b.e(xVar, "sources is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new l3(xVar, h.c.n0.b.a.j(), i2, false));
    }

    public static <T> s<T> switchOnNextDelayError(x<? extends x<? extends T>> xVar) {
        return switchOnNextDelayError(xVar, bufferSize());
    }

    private s<T> timeout0(long j2, TimeUnit timeUnit, x<? extends T> xVar, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "timeUnit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new x3(this, j2, timeUnit, a0Var, xVar));
    }

    public static s<Long> timer(long j2, TimeUnit timeUnit) {
        return timer(j2, timeUnit, h.c.u0.a.a());
    }

    public static <T> s<T> unsafeCreate(x<T> xVar) {
        h.c.n0.b.b.e(xVar, "onSubscribe is null");
        if (!(xVar instanceof s)) {
            return h.c.r0.a.n(new g1(xVar));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> s<T> using(Callable<? extends D> callable, h.c.m0.n<? super D, ? extends x<? extends T>> nVar, h.c.m0.f<? super D> fVar) {
        return using(callable, nVar, fVar, true);
    }

    public static <T> s<T> wrap(x<T> xVar) {
        h.c.n0.b.b.e(xVar, "source is null");
        if (xVar instanceof s) {
            return h.c.r0.a.n((s) xVar);
        }
        return h.c.r0.a.n(new g1(xVar));
    }

    public static <T, R> s<R> zip(Iterable<? extends x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(iterable, "sources is null");
        return h.c.r0.a.n(new k4(null, iterable, nVar, bufferSize(), false));
    }

    public static <T, R> s<R> zipArray(h.c.m0.n<? super Object[], ? extends R> nVar, boolean z, int i2, x<? extends T>... xVarArr) {
        if (xVarArr.length == 0) {
            return empty();
        }
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new k4(xVarArr, null, nVar, i2, z));
    }

    public static <T, R> s<R> zipIterable(Iterable<? extends x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new k4(null, iterable, nVar, i2, z));
    }

    public final b0<Boolean> all(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.o(new h.c.n0.e.e.g(this, pVar));
    }

    public final s<T> ambWith(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return ambArray(this, xVar);
    }

    public final b0<Boolean> any(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.o(new h.c.n0.e.e.j(this, pVar));
    }

    public final <R> R as(t<T, ? extends R> tVar) {
        return (R) ((t) h.c.n0.b.b.e(tVar, "converter is null")).apply(this);
    }

    public final T blockingFirst() {
        h.c.n0.d.f fVar = new h.c.n0.d.f();
        subscribe(fVar);
        T a2 = fVar.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(h.c.m0.f<? super T> fVar) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                fVar.accept(it.next());
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ((h.c.k0.b) it).dispose();
                throw h.c.n0.j.j.e(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        h.c.n0.d.g gVar = new h.c.n0.d.g();
        subscribe(gVar);
        T a2 = gVar.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new h.c.n0.e.e.c(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new h.c.n0.e.e.d(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new h.c.n0.e.e.e(this);
    }

    public final T blockingSingle() {
        T c2 = singleElement().c();
        if (c2 != null) {
            return c2;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        h.c.n0.e.e.k.a(this);
    }

    public final s<List<T>> buffer(int i2) {
        return buffer(i2, i2);
    }

    public final s<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final s<T> cacheWithInitialCapacity(int i2) {
        h.c.n0.b.b.f(i2, "initialCapacity");
        return h.c.r0.a.n(new h.c.n0.e.e.q(this, i2));
    }

    public final <U> s<U> cast(Class<U> cls) {
        h.c.n0.b.b.e(cls, "clazz is null");
        return (s<U>) map(h.c.n0.b.a.e(cls));
    }

    public final <U> b0<U> collect(Callable<? extends U> callable, h.c.m0.b<? super U, ? super T> bVar) {
        h.c.n0.b.b.e(callable, "initialValueSupplier is null");
        h.c.n0.b.b.e(bVar, "collector is null");
        return h.c.r0.a.o(new h.c.n0.e.e.s(this, callable, bVar));
    }

    public final <U> b0<U> collectInto(U u, h.c.m0.b<? super U, ? super T> bVar) {
        h.c.n0.b.b.e(u, "initialValue is null");
        return collect(h.c.n0.b.a.l(u), bVar);
    }

    public final <R> s<R> compose(y<? super T, ? extends R> yVar) {
        return wrap(((y) h.c.n0.b.b.e(yVar, "composer is null")).apply(this));
    }

    public final <R> s<R> concatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        return concatMap(nVar, 2);
    }

    public final c concatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        return concatMapCompletable(nVar, 2);
    }

    public final c concatMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar) {
        return concatMapCompletableDelayError(nVar, true, 2);
    }

    public final <R> s<R> concatMapDelayError(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        return concatMapDelayError(nVar, bufferSize(), true);
    }

    public final <R> s<R> concatMapEager(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        return concatMapEager(nVar, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, bufferSize());
    }

    public final <R> s<R> concatMapEagerDelayError(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, boolean z) {
        return concatMapEagerDelayError(nVar, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, bufferSize(), z);
    }

    public final <U> s<U> concatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new a1(this, nVar));
    }

    public final <R> s<R> concatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        return concatMapMaybe(nVar, 2);
    }

    public final <R> s<R> concatMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        return concatMapMaybeDelayError(nVar, true, 2);
    }

    public final <R> s<R> concatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        return concatMapSingle(nVar, 2);
    }

    public final <R> s<R> concatMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        return concatMapSingleDelayError(nVar, true, 2);
    }

    public final s<T> concatWith(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return concat(this, xVar);
    }

    public final b0<Boolean> contains(Object obj) {
        h.c.n0.b.b.e(obj, "element is null");
        return any(h.c.n0.b.a.i(obj));
    }

    public final b0<Long> count() {
        return h.c.r0.a.o(new h.c.n0.e.e.a0(this));
    }

    public final <U> s<T> debounce(h.c.m0.n<? super T, ? extends x<U>> nVar) {
        h.c.n0.b.b.e(nVar, "debounceSelector is null");
        return h.c.r0.a.n(new h.c.n0.e.e.c0(this, nVar));
    }

    public final s<T> defaultIfEmpty(T t) {
        h.c.n0.b.b.e(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> s<T> delay(h.c.m0.n<? super T, ? extends x<U>> nVar) {
        h.c.n0.b.b.e(nVar, "itemDelay is null");
        return (s<T>) flatMap(n1.c(nVar));
    }

    public final <U> s<T> delaySubscription(x<U> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return h.c.r0.a.n(new h.c.n0.e.e.g0(this, xVar));
    }

    @Deprecated
    public final <T2> s<T2> dematerialize() {
        return h.c.r0.a.n(new h.c.n0.e.e.h0(this, h.c.n0.b.a.j()));
    }

    public final s<T> distinct() {
        return distinct(h.c.n0.b.a.j(), h.c.n0.b.a.g());
    }

    public final s<T> distinctUntilChanged() {
        return distinctUntilChanged(h.c.n0.b.a.j());
    }

    public final s<T> doAfterNext(h.c.m0.f<? super T> fVar) {
        h.c.n0.b.b.e(fVar, "onAfterNext is null");
        return h.c.r0.a.n(new l0(this, fVar));
    }

    public final s<T> doAfterTerminate(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onFinally is null");
        return doOnEach(h.c.n0.b.a.h(), h.c.n0.b.a.h(), h.c.n0.b.a.f14096c, aVar);
    }

    public final s<T> doFinally(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onFinally is null");
        return h.c.r0.a.n(new m0(this, aVar));
    }

    public final s<T> doOnComplete(h.c.m0.a aVar) {
        return doOnEach(h.c.n0.b.a.h(), h.c.n0.b.a.h(), aVar, h.c.n0.b.a.f14096c);
    }

    public final s<T> doOnDispose(h.c.m0.a aVar) {
        return doOnLifecycle(h.c.n0.b.a.h(), aVar);
    }

    public final s<T> doOnError(h.c.m0.f<? super Throwable> fVar) {
        h.c.m0.f<? super T> h2 = h.c.n0.b.a.h();
        h.c.m0.a aVar = h.c.n0.b.a.f14096c;
        return doOnEach(h2, fVar, aVar, aVar);
    }

    public final s<T> doOnLifecycle(h.c.m0.f<? super h.c.k0.b> fVar, h.c.m0.a aVar) {
        h.c.n0.b.b.e(fVar, "onSubscribe is null");
        h.c.n0.b.b.e(aVar, "onDispose is null");
        return h.c.r0.a.n(new o0(this, fVar, aVar));
    }

    public final s<T> doOnNext(h.c.m0.f<? super T> fVar) {
        h.c.m0.f<? super Throwable> h2 = h.c.n0.b.a.h();
        h.c.m0.a aVar = h.c.n0.b.a.f14096c;
        return doOnEach(fVar, h2, aVar, aVar);
    }

    public final s<T> doOnSubscribe(h.c.m0.f<? super h.c.k0.b> fVar) {
        return doOnLifecycle(fVar, h.c.n0.b.a.f14096c);
    }

    public final s<T> doOnTerminate(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onTerminate is null");
        return doOnEach(h.c.n0.b.a.h(), h.c.n0.b.a.a(aVar), aVar, h.c.n0.b.a.f14096c);
    }

    public final o<T> elementAt(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.m(new q0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    public final b0<T> elementAtOrError(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.o(new r0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    public final s<T> filter(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.n(new u0(this, pVar));
    }

    public final b0<T> first(T t) {
        return elementAt(0L, t);
    }

    public final o<T> firstElement() {
        return elementAt(0L);
    }

    public final b0<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        return flatMap((h.c.m0.n) nVar, false);
    }

    public final c flatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        return flatMapCompletable(nVar, false);
    }

    public final <U> s<U> flatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new a1(this, nVar));
    }

    public final <R> s<R> flatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        return flatMapMaybe(nVar, false);
    }

    public final <R> s<R> flatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        return flatMapSingle(nVar, false);
    }

    public final h.c.k0.b forEach(h.c.m0.f<? super T> fVar) {
        return subscribe(fVar);
    }

    public final h.c.k0.b forEachWhile(h.c.m0.p<? super T> pVar) {
        return forEachWhile(pVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c);
    }

    public final <K> s<h.c.o0.b<K, T>> groupBy(h.c.m0.n<? super T, ? extends K> nVar) {
        return (s<h.c.o0.b<K, T>>) groupBy(nVar, h.c.n0.b.a.j(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> s<R> groupJoin(x<? extends TRight> xVar, h.c.m0.n<? super T, ? extends x<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends x<TRightEnd>> nVar2, h.c.m0.c<? super T, ? super s<TRight>, ? extends R> cVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        h.c.n0.b.b.e(nVar, "leftEnd is null");
        h.c.n0.b.b.e(nVar2, "rightEnd is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return h.c.r0.a.n(new j1(this, xVar, nVar, nVar2, cVar));
    }

    public final s<T> hide() {
        return h.c.r0.a.n(new k1(this));
    }

    public final c ignoreElements() {
        return h.c.r0.a.k(new m1(this));
    }

    public final b0<Boolean> isEmpty() {
        return all(h.c.n0.b.a.b());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> s<R> join(x<? extends TRight> xVar, h.c.m0.n<? super T, ? extends x<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends x<TRightEnd>> nVar2, h.c.m0.c<? super T, ? super TRight, ? extends R> cVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        h.c.n0.b.b.e(nVar, "leftEnd is null");
        h.c.n0.b.b.e(nVar2, "rightEnd is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return h.c.r0.a.n(new q1(this, xVar, nVar, nVar2, cVar));
    }

    public final b0<T> last(T t) {
        h.c.n0.b.b.e(t, "defaultItem is null");
        return h.c.r0.a.o(new t1(this, t));
    }

    public final o<T> lastElement() {
        return h.c.r0.a.m(new s1(this));
    }

    public final b0<T> lastOrError() {
        return h.c.r0.a.o(new t1(this, null));
    }

    public final <R> s<R> lift(w<? extends R, ? super T> wVar) {
        h.c.n0.b.b.e(wVar, "lifter is null");
        return h.c.r0.a.n(new u1(this, wVar));
    }

    public final <R> s<R> map(h.c.m0.n<? super T, ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new v1(this, nVar));
    }

    public final s<r<T>> materialize() {
        return h.c.r0.a.n(new x1(this));
    }

    public final s<T> mergeWith(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return merge(this, xVar);
    }

    public final s<T> observeOn(a0 a0Var) {
        return observeOn(a0Var, false, bufferSize());
    }

    public final <U> s<U> ofType(Class<U> cls) {
        h.c.n0.b.b.e(cls, "clazz is null");
        return filter(h.c.n0.b.a.k(cls)).cast(cls);
    }

    public final s<T> onErrorResumeNext(h.c.m0.n<? super Throwable, ? extends x<? extends T>> nVar) {
        h.c.n0.b.b.e(nVar, "resumeFunction is null");
        return h.c.r0.a.n(new d2(this, nVar, false));
    }

    public final s<T> onErrorReturn(h.c.m0.n<? super Throwable, ? extends T> nVar) {
        h.c.n0.b.b.e(nVar, "valueSupplier is null");
        return h.c.r0.a.n(new e2(this, nVar));
    }

    public final s<T> onErrorReturnItem(T t) {
        h.c.n0.b.b.e(t, "item is null");
        return onErrorReturn(h.c.n0.b.a.m(t));
    }

    public final s<T> onExceptionResumeNext(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "next is null");
        return h.c.r0.a.n(new d2(this, h.c.n0.b.a.m(xVar), true));
    }

    public final s<T> onTerminateDetach() {
        return h.c.r0.a.n(new h.c.n0.e.e.i0(this));
    }

    public final h.c.o0.a<T> publish() {
        return f2.d(this);
    }

    public final o<T> reduce(h.c.m0.c<T, T, T> cVar) {
        h.c.n0.b.b.e(cVar, "reducer is null");
        return h.c.r0.a.m(new j2(this, cVar));
    }

    public final <R> b0<R> reduceWith(Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(callable, "seedSupplier is null");
        h.c.n0.b.b.e(cVar, "reducer is null");
        return h.c.r0.a.o(new l2(this, callable, cVar));
    }

    public final s<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final s<T> repeatUntil(h.c.m0.e eVar) {
        h.c.n0.b.b.e(eVar, "stop is null");
        return h.c.r0.a.n(new o2(this, eVar));
    }

    public final s<T> repeatWhen(h.c.m0.n<? super s<Object>, ? extends x<?>> nVar) {
        h.c.n0.b.b.e(nVar, "handler is null");
        return h.c.r0.a.n(new p2(this, nVar));
    }

    public final h.c.o0.a<T> replay() {
        return q2.h(this);
    }

    public final s<T> retry() {
        return retry(Long.MAX_VALUE, h.c.n0.b.a.c());
    }

    public final s<T> retryUntil(h.c.m0.e eVar) {
        h.c.n0.b.b.e(eVar, "stop is null");
        return retry(Long.MAX_VALUE, h.c.n0.b.a.u(eVar));
    }

    public final s<T> retryWhen(h.c.m0.n<? super s<Throwable>, ? extends x<?>> nVar) {
        h.c.n0.b.b.e(nVar, "handler is null");
        return h.c.r0.a.n(new t2(this, nVar));
    }

    public final void safeSubscribe(z<? super T> zVar) {
        h.c.n0.b.b.e(zVar, "observer is null");
        if (zVar instanceof h.c.p0.e) {
            subscribe(zVar);
        } else {
            subscribe(new h.c.p0.e(zVar));
        }
    }

    public final s<T> sample(long j2, TimeUnit timeUnit) {
        return sample(j2, timeUnit, h.c.u0.a.a());
    }

    public final s<T> scan(h.c.m0.c<T, T, T> cVar) {
        h.c.n0.b.b.e(cVar, "accumulator is null");
        return h.c.r0.a.n(new x2(this, cVar));
    }

    public final <R> s<R> scanWith(Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(callable, "seedSupplier is null");
        h.c.n0.b.b.e(cVar, "accumulator is null");
        return h.c.r0.a.n(new y2(this, callable, cVar));
    }

    public final s<T> serialize() {
        return h.c.r0.a.n(new b3(this));
    }

    public final s<T> share() {
        return publish().c();
    }

    public final b0<T> single(T t) {
        h.c.n0.b.b.e(t, "defaultItem is null");
        return h.c.r0.a.o(new d3(this, t));
    }

    public final o<T> singleElement() {
        return h.c.r0.a.m(new c3(this));
    }

    public final b0<T> singleOrError() {
        return h.c.r0.a.o(new d3(this, null));
    }

    public final s<T> skip(long j2) {
        if (j2 <= 0) {
            return h.c.r0.a.n(this);
        }
        return h.c.r0.a.n(new e3(this, j2));
    }

    public final s<T> skipLast(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return h.c.r0.a.n(this);
            }
            return h.c.r0.a.n(new f3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    public final <U> s<T> skipUntil(x<U> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return h.c.r0.a.n(new h3(this, xVar));
    }

    public final s<T> skipWhile(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.n(new i3(this, pVar));
    }

    public final s<T> sorted() {
        return toList().toObservable().map(h.c.n0.b.a.n(h.c.n0.b.a.o())).flatMapIterable(h.c.n0.b.a.j());
    }

    public final s<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final s<T> startWithArray(T... tArr) {
        s fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return h.c.r0.a.n(this);
        }
        return concatArray(fromArray, this);
    }

    public final h.c.k0.b subscribe() {
        return subscribe(h.c.n0.b.a.h(), h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c, h.c.n0.b.a.h());
    }

    protected abstract void subscribeActual(z<? super T> zVar);

    public final s<T> subscribeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new j3(this, a0Var));
    }

    public final <E extends z<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final s<T> switchIfEmpty(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return h.c.r0.a.n(new k3(this, xVar));
    }

    public final <R> s<R> switchMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        return switchMap(nVar, bufferSize());
    }

    public final c switchMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.k(new h.c.n0.e.d.k(this, nVar, false));
    }

    public final c switchMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.k(new h.c.n0.e.d.k(this, nVar, true));
    }

    public final <R> s<R> switchMapDelayError(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        return switchMapDelayError(nVar, bufferSize());
    }

    public final <R> s<R> switchMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new h.c.n0.e.d.l(this, nVar, false));
    }

    public final <R> s<R> switchMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new h.c.n0.e.d.l(this, nVar, true));
    }

    public final <R> s<R> switchMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new h.c.n0.e.d.m(this, nVar, false));
    }

    public final <R> s<R> switchMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new h.c.n0.e.d.m(this, nVar, true));
    }

    public final s<T> take(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.n(new m3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    public final s<T> takeLast(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return h.c.r0.a.n(new l1(this));
        } else {
            if (i2 == 1) {
                return h.c.r0.a.n(new o3(this));
            }
            return h.c.r0.a.n(new n3(this, i2));
        }
    }

    public final <U> s<T> takeUntil(x<U> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return h.c.r0.a.n(new q3(this, xVar));
    }

    public final s<T> takeWhile(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.n(new s3(this, pVar));
    }

    public final h.c.p0.g<T> test() {
        h.c.p0.g<T> gVar = new h.c.p0.g<>();
        subscribe(gVar);
        return gVar;
    }

    public final s<T> throttleFirst(long j2, TimeUnit timeUnit) {
        return throttleFirst(j2, timeUnit, h.c.u0.a.a());
    }

    public final s<T> throttleLast(long j2, TimeUnit timeUnit) {
        return sample(j2, timeUnit);
    }

    public final s<T> throttleLatest(long j2, TimeUnit timeUnit) {
        return throttleLatest(j2, timeUnit, h.c.u0.a.a(), false);
    }

    public final s<T> throttleWithTimeout(long j2, TimeUnit timeUnit) {
        return debounce(j2, timeUnit);
    }

    public final s<h.c.u0.b<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, h.c.u0.a.a());
    }

    public final <V> s<T> timeout(h.c.m0.n<? super T, ? extends x<V>> nVar) {
        return timeout0(null, nVar, null);
    }

    public final s<h.c.u0.b<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, h.c.u0.a.a());
    }

    public final <R> R to(h.c.m0.n<? super s<T>, R> nVar) {
        try {
            return (R) ((h.c.m0.n) h.c.n0.b.b.e(nVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw h.c.n0.j.j.e(th);
        }
    }

    public final h<T> toFlowable(b bVar) {
        h.c.n0.e.b.j1 j1Var = new h.c.n0.e.b.j1(this);
        int i2 = a.a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return j1Var.onBackpressureBuffer();
                    }
                    return h.c.r0.a.l(new m2(j1Var));
                }
                return j1Var;
            }
            return j1Var.onBackpressureLatest();
        }
        return j1Var.onBackpressureDrop();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new h.c.n0.d.p());
    }

    public final b0<List<T>> toList() {
        return toList(16);
    }

    public final <K> b0<Map<K, T>> toMap(h.c.m0.n<? super T, ? extends K> nVar) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        return (b0<Map<K, T>>) collect(h.c.n0.j.l.h(), h.c.n0.b.a.E(nVar));
    }

    public final <K> b0<Map<K, Collection<T>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar) {
        return (b0<Map<K, Collection<T>>>) toMultimap(nVar, h.c.n0.b.a.j(), h.c.n0.j.l.h(), h.c.n0.j.b.q());
    }

    public final b0<List<T>> toSortedList() {
        return toSortedList(h.c.n0.b.a.p());
    }

    public final s<T> unsubscribeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new b4(this, a0Var));
    }

    public final s<s<T>> window(long j2) {
        return window(j2, j2, bufferSize());
    }

    public final <U, R> s<R> withLatestFrom(x<? extends U> xVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        h.c.n0.b.b.e(cVar, "combiner is null");
        return h.c.r0.a.n(new i4(this, cVar, xVar));
    }

    public final <U, R> s<R> zipWith(Iterable<U> iterable, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        h.c.n0.b.b.e(iterable, "other is null");
        h.c.n0.b.b.e(cVar, "zipper is null");
        return h.c.r0.a.n(new l4(this, iterable, cVar));
    }

    public static <T, R> s<R> combineLatest(Iterable<? extends x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatest(iterable, nVar, bufferSize());
    }

    public static <T, R> s<R> combineLatestDelayError(h.c.m0.n<? super Object[], ? extends R> nVar, int i2, x<? extends T>... xVarArr) {
        return combineLatestDelayError(xVarArr, nVar, i2);
    }

    public static <T> s<T> concatArrayEager(int i2, int i3, x<? extends T>... xVarArr) {
        return fromArray(xVarArr).concatMapEagerDelayError(h.c.n0.b.a.j(), i2, i3, false);
    }

    public static <T> s<T> concatArrayEagerDelayError(int i2, int i3, x<? extends T>... xVarArr) {
        return fromArray(xVarArr).concatMapEagerDelayError(h.c.n0.b.a.j(), i2, i3, true);
    }

    public static <T> s<T> concatEager(x<? extends x<? extends T>> xVar, int i2, int i3) {
        return wrap(xVar).concatMapEager(h.c.n0.b.a.j(), i2, i3);
    }

    public static s<Long> interval(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new o1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, a0Var));
    }

    public static s<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, a0 a0Var) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        } else if (i2 == 0) {
            return empty().delay(j4, timeUnit, a0Var);
        } else {
            long j6 = j2 + (j3 - 1);
            if (j2 > 0 && j6 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            h.c.n0.b.b.e(timeUnit, "unit is null");
            h.c.n0.b.b.e(a0Var, "scheduler is null");
            return h.c.r0.a.n(new p1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, a0Var));
        }
    }

    public static <T> s<T> merge(Iterable<? extends x<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j());
    }

    public static <T> s<T> mergeArray(x<? extends T>... xVarArr) {
        return fromArray(xVarArr).flatMap(h.c.n0.b.a.j(), xVarArr.length);
    }

    public static <T> s<T> mergeArrayDelayError(x<? extends T>... xVarArr) {
        return fromArray(xVarArr).flatMap(h.c.n0.b.a.j(), true, xVarArr.length);
    }

    public static <T> s<T> mergeDelayError(Iterable<? extends x<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), true, i2, i3);
    }

    public static <T> b0<Boolean> sequenceEqual(x<? extends T> xVar, x<? extends T> xVar2, h.c.m0.d<? super T, ? super T> dVar) {
        return sequenceEqual(xVar, xVar2, dVar, bufferSize());
    }

    public static <T> s<T> switchOnNextDelayError(x<? extends x<? extends T>> xVar, int i2) {
        h.c.n0.b.b.e(xVar, "sources is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.n(new l3(xVar, h.c.n0.b.a.j(), i2, true));
    }

    public static s<Long> timer(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new y3(Math.max(j2, 0L), timeUnit, a0Var));
    }

    public static <T, D> s<T> using(Callable<? extends D> callable, h.c.m0.n<? super D, ? extends x<? extends T>> nVar, h.c.m0.f<? super D> fVar, boolean z) {
        h.c.n0.b.b.e(callable, "resourceSupplier is null");
        h.c.n0.b.b.e(nVar, "sourceSupplier is null");
        h.c.n0.b.b.e(fVar, "disposer is null");
        return h.c.r0.a.n(new c4(callable, nVar, fVar, z));
    }

    public final Iterable<T> blockingIterable(int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        return new h.c.n0.e.e.b(this, i2);
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar) {
        h.c.n0.e.e.k.c(this, fVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c);
    }

    public final s<List<T>> buffer(int i2, int i3) {
        return (s<List<T>>) buffer(i2, i3, h.c.n0.j.b.n());
    }

    public final <R> s<R> concatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return w2.a(call, nVar);
        }
        return h.c.r0.a.n(new h.c.n0.e.e.u(this, nVar, i2, h.c.n0.j.i.IMMEDIATE));
    }

    public final c concatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "capacityHint");
        return h.c.r0.a.k(new h.c.n0.e.d.h(this, nVar, h.c.n0.j.i.IMMEDIATE, i2));
    }

    public final c concatMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar, boolean z) {
        return concatMapCompletableDelayError(nVar, z, 2);
    }

    public final <R> s<R> concatMapDelayError(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return w2.a(call, nVar);
        }
        return h.c.r0.a.n(new h.c.n0.e.e.u(this, nVar, i2, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY));
    }

    public final <R> s<R> concatMapEager(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2, int i3) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.e.v(this, nVar, h.c.n0.j.i.IMMEDIATE, i2, i3));
    }

    public final <R> s<R> concatMapEagerDelayError(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2, int i3, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.e.v(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2, i3));
    }

    public final <R> s<R> concatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.d.i(this, nVar, h.c.n0.j.i.IMMEDIATE, i2));
    }

    public final <R> s<R> concatMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
        return concatMapMaybeDelayError(nVar, z, 2);
    }

    public final <R> s<R> concatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.d.j(this, nVar, h.c.n0.j.i.IMMEDIATE, i2));
    }

    public final <R> s<R> concatMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
        return concatMapSingleDelayError(nVar, z, 2);
    }

    public final <R> s<R> dematerialize(h.c.m0.n<? super T, r<R>> nVar) {
        h.c.n0.b.b.e(nVar, "selector is null");
        return h.c.r0.a.n(new h.c.n0.e.e.h0(this, nVar));
    }

    public final <K> s<T> distinct(h.c.m0.n<? super T, K> nVar) {
        return distinct(nVar, h.c.n0.b.a.g());
    }

    public final <K> s<T> distinctUntilChanged(h.c.m0.n<? super T, K> nVar) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        return h.c.r0.a.n(new k0(this, nVar, h.c.n0.b.b.d()));
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, boolean z) {
        return flatMap(nVar, z, (int) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final c flatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.k(new x0(this, nVar, z));
    }

    public final <R> s<R> flatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new y0(this, nVar, z));
    }

    public final <R> s<R> flatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new z0(this, nVar, z));
    }

    public final h.c.k0.b forEachWhile(h.c.m0.p<? super T> pVar, h.c.m0.f<? super Throwable> fVar) {
        return forEachWhile(pVar, fVar, h.c.n0.b.a.f14096c);
    }

    public final <K> s<h.c.o0.b<K, T>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, boolean z) {
        return (s<h.c.o0.b<K, T>>) groupBy(nVar, h.c.n0.b.a.j(), z, bufferSize());
    }

    public final s<T> observeOn(a0 a0Var, boolean z) {
        return observeOn(a0Var, z, bufferSize());
    }

    public final <R> s<R> publish(h.c.m0.n<? super s<T>, ? extends x<R>> nVar) {
        h.c.n0.b.b.e(nVar, "selector is null");
        return h.c.r0.a.n(new g2(this, nVar));
    }

    public final s<T> repeat(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (i2 == 0) {
                return empty();
            }
            return h.c.r0.a.n(new n2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar) {
        h.c.n0.b.b.e(nVar, "selector is null");
        return q2.i(n1.g(this), nVar);
    }

    public final s<T> retry(h.c.m0.d<? super Integer, ? super Throwable> dVar) {
        h.c.n0.b.b.e(dVar, "predicate is null");
        return h.c.r0.a.n(new r2(this, dVar));
    }

    public final s<T> sample(long j2, TimeUnit timeUnit, boolean z) {
        return sample(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final s<T> sorted(Comparator<? super T> comparator) {
        h.c.n0.b.b.e(comparator, "sortFunction is null");
        return toList().toObservable().map(h.c.n0.b.a.n(comparator)).flatMapIterable(h.c.n0.b.a.j());
    }

    public final s<T> startWith(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return concatArray(xVar, this);
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar) {
        return subscribe(fVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c, h.c.n0.b.a.h());
    }

    public final <R> s<R> switchMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return w2.a(call, nVar);
        }
        return h.c.r0.a.n(new l3(this, nVar, i2, false));
    }

    public final <R> s<R> switchMapDelayError(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return w2.a(call, nVar);
        }
        return h.c.r0.a.n(new l3(this, nVar, i2, true));
    }

    public final s<T> throttleFirst(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new t3(this, j2, timeUnit, a0Var));
    }

    public final s<T> throttleLast(long j2, TimeUnit timeUnit, a0 a0Var) {
        return sample(j2, timeUnit, a0Var);
    }

    public final s<T> throttleLatest(long j2, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final s<T> throttleWithTimeout(long j2, TimeUnit timeUnit, a0 a0Var) {
        return debounce(j2, timeUnit, a0Var);
    }

    public final s<h.c.u0.b<T>> timeInterval(a0 a0Var) {
        return timeInterval(TimeUnit.MILLISECONDS, a0Var);
    }

    public final <V> s<T> timeout(h.c.m0.n<? super T, ? extends x<V>> nVar, x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return timeout0(null, nVar, xVar);
    }

    public final s<h.c.u0.b<T>> timestamp(a0 a0Var) {
        return timestamp(TimeUnit.MILLISECONDS, a0Var);
    }

    public final b0<List<T>> toList(int i2) {
        h.c.n0.b.b.f(i2, "capacityHint");
        return h.c.r0.a.o(new a4(this, i2));
    }

    public final b0<List<T>> toSortedList(Comparator<? super T> comparator) {
        h.c.n0.b.b.e(comparator, "comparator is null");
        return (b0<List<T>>) toList().map(h.c.n0.b.a.n(comparator));
    }

    public final s<s<T>> window(long j2, long j3) {
        return window(j2, j3, bufferSize());
    }

    public static <T, R> s<R> combineLatest(Iterable<? extends x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new h.c.n0.e.e.t(null, iterable, nVar, i2 << 1, false));
    }

    public static <T, R> s<R> combineLatestDelayError(x<? extends T>[] xVarArr, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(nVar, "combiner is null");
        if (xVarArr.length == 0) {
            return empty();
        }
        return h.c.r0.a.n(new h.c.n0.e.e.t(xVarArr, null, nVar, i2 << 1, true));
    }

    public static <T> s<T> concat(x<? extends x<? extends T>> xVar) {
        return concat(xVar, bufferSize());
    }

    public static <T> s<T> concatDelayError(x<? extends x<? extends T>> xVar) {
        return concatDelayError(xVar, bufferSize(), true);
    }

    public static <T> s<T> concatEager(Iterable<? extends x<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> s<T> error(Throwable th) {
        h.c.n0.b.b.e(th, "exception is null");
        return error(h.c.n0.b.a.l(th));
    }

    public static <T> s<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        h.c.n0.b.b.e(future, "future is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        return h.c.r0.a.n(new d1(future, j2, timeUnit));
    }

    public static <T> s<T> just(T t, T t2) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        return fromArray(t, t2);
    }

    public static <T> s<T> merge(Iterable<? extends x<? extends T>> iterable, int i2) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), i2);
    }

    public static <T> s<T> mergeDelayError(Iterable<? extends x<? extends T>> iterable, int i2) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), true, i2);
    }

    public static <T> b0<Boolean> sequenceEqual(x<? extends T> xVar, x<? extends T> xVar2, h.c.m0.d<? super T, ? super T> dVar, int i2) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(dVar, "isEqual is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.o(new a3(xVar, xVar2, dVar, i2));
    }

    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
        h.c.n0.e.e.k.c(this, fVar, fVar2, h.c.n0.b.a.f14096c);
    }

    public final <U extends Collection<? super T>> s<U> buffer(int i2, int i3, Callable<U> callable) {
        h.c.n0.b.b.f(i2, "count");
        h.c.n0.b.b.f(i3, "skip");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.n(new h.c.n0.e.e.l(this, i2, i3, callable));
    }

    public final c concatMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.k(new h.c.n0.e.d.h(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2));
    }

    public final <U> s<U> concatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return (s<U>) concatMap(n1.a(nVar), i2);
    }

    public final <R> s<R> concatMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.d.i(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2));
    }

    public final <R> s<R> concatMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.d.j(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2));
    }

    public final s<T> concatWith(h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return h.c.r0.a.n(new h.c.n0.e.e.y(this, h0Var));
    }

    public final s<T> debounce(long j2, TimeUnit timeUnit) {
        return debounce(j2, timeUnit, h.c.u0.a.a());
    }

    public final s<T> delay(long j2, TimeUnit timeUnit) {
        return delay(j2, timeUnit, h.c.u0.a.a(), false);
    }

    public final s<T> delaySubscription(long j2, TimeUnit timeUnit) {
        return delaySubscription(j2, timeUnit, h.c.u0.a.a());
    }

    public final <K> s<T> distinct(h.c.m0.n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(callable, "collectionSupplier is null");
        return h.c.r0.a.n(new j0(this, nVar, callable));
    }

    public final b0<T> elementAt(long j2, T t) {
        if (j2 >= 0) {
            h.c.n0.b.b.e(t, "defaultItem is null");
            return h.c.r0.a.o(new r0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, boolean z, int i2) {
        return flatMap(nVar, z, i2, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> s<V> flatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends V> cVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return (s<V>) flatMap(n1.a(nVar), cVar, false, bufferSize(), bufferSize());
    }

    public final h.c.k0.b forEachWhile(h.c.m0.p<? super T> pVar, h.c.m0.f<? super Throwable> fVar, h.c.m0.a aVar) {
        h.c.n0.b.b.e(pVar, "onNext is null");
        h.c.n0.b.b.e(fVar, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.d.o oVar = new h.c.n0.d.o(pVar, fVar, aVar);
        subscribe(oVar);
        return oVar;
    }

    public final <K, V> s<h.c.o0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        return groupBy(nVar, nVar2, false, bufferSize());
    }

    public final s<T> mergeWith(h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return h.c.r0.a.n(new a2(this, h0Var));
    }

    public final s<T> observeOn(a0 a0Var, boolean z, int i2) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new c2(this, a0Var, z, i2));
    }

    public final s<T> onErrorResumeNext(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "next is null");
        return onErrorResumeNext(h.c.n0.b.a.m(xVar));
    }

    public final <R> b0<R> reduce(R r, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(r, "seed is null");
        h.c.n0.b.b.e(cVar, "reducer is null");
        return h.c.r0.a.o(new k2(this, r, cVar));
    }

    public final s<T> sample(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new u2(this, j2, timeUnit, a0Var, false));
    }

    public final <R> s<R> scan(R r, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(r, "initialValue is null");
        return scanWith(h.c.n0.b.a.l(r), cVar);
    }

    public final s<T> skip(long j2, TimeUnit timeUnit) {
        return skipUntil(timer(j2, timeUnit));
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
        return subscribe(fVar, fVar2, h.c.n0.b.a.f14096c, h.c.n0.b.a.h());
    }

    public final s<T> take(long j2, TimeUnit timeUnit) {
        return takeUntil(timer(j2, timeUnit));
    }

    public final s<T> takeUntil(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "stopPredicate is null");
        return h.c.r0.a.n(new r3(this, pVar));
    }

    public final h.c.p0.g<T> test(boolean z) {
        h.c.p0.g<T> gVar = new h.c.p0.g<>();
        if (z) {
            gVar.dispose();
        }
        subscribe(gVar);
        return gVar;
    }

    public final s<T> throttleLatest(long j2, TimeUnit timeUnit, a0 a0Var) {
        return throttleLatest(j2, timeUnit, a0Var, false);
    }

    public final s<h.c.u0.b<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, h.c.u0.a.a());
    }

    public final s<h.c.u0.b<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, h.c.u0.a.a());
    }

    public final <K, V> b0<Map<K, V>> toMap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        return (b0<Map<K, V>>) collect(h.c.n0.j.l.h(), h.c.n0.b.a.F(nVar, nVar2));
    }

    public final s<s<T>> window(long j2, long j3, int i2) {
        h.c.n0.b.b.g(j2, "count");
        h.c.n0.b.b.g(j3, "skip");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new d4(this, j2, j3, i2));
    }

    public static <T> s<T> concat(x<? extends x<? extends T>> xVar, int i2) {
        h.c.n0.b.b.e(xVar, "sources is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.n(new h.c.n0.e.e.u(xVar, h.c.n0.b.a.j(), i2, h.c.n0.j.i.IMMEDIATE));
    }

    public static <T> s<T> concatDelayError(x<? extends x<? extends T>> xVar, int i2, boolean z) {
        h.c.n0.b.b.e(xVar, "sources is null");
        h.c.n0.b.b.f(i2, "prefetch is null");
        return h.c.r0.a.n(new h.c.n0.e.e.u(xVar, h.c.n0.b.a.j(), i2, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY));
    }

    public static <T> s<T> concatEager(Iterable<? extends x<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).concatMapEagerDelayError(h.c.n0.b.a.j(), i2, i3, false);
    }

    public static <T> s<T> merge(x<? extends x<? extends T>> xVar) {
        h.c.n0.b.b.e(xVar, "sources is null");
        return h.c.r0.a.n(new v0(xVar, h.c.n0.b.a.j(), false, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, bufferSize()));
    }

    public static <T> s<T> mergeDelayError(x<? extends x<? extends T>> xVar) {
        h.c.n0.b.b.e(xVar, "sources is null");
        return h.c.r0.a.n(new v0(xVar, h.c.n0.b.a.j(), true, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, bufferSize()));
    }

    public static <T> s<T> switchOnNext(x<? extends x<? extends T>> xVar) {
        return switchOnNext(xVar, bufferSize());
    }

    private <U, V> s<T> timeout0(x<U> xVar, h.c.m0.n<? super T, ? extends x<V>> nVar, x<? extends T> xVar2) {
        h.c.n0.b.b.e(nVar, "itemTimeoutIndicator is null");
        return h.c.r0.a.n(new w3(this, xVar, nVar, xVar2));
    }

    public static <T, R> s<R> zip(x<? extends x<? extends T>> xVar, h.c.m0.n<? super Object[], ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(xVar, "sources is null");
        return h.c.r0.a.n(new z3(xVar, 16).flatMap(n1.n(nVar)));
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
        h.c.n0.e.e.k.c(this, fVar, fVar2, aVar);
    }

    public final s<T> debounce(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new h.c.n0.e.e.d0(this, j2, timeUnit, a0Var));
    }

    public final s<T> delay(long j2, TimeUnit timeUnit, boolean z) {
        return delay(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final s<T> delaySubscription(long j2, TimeUnit timeUnit, a0 a0Var) {
        return delaySubscription(timer(j2, timeUnit, a0Var));
    }

    public final s<T> distinctUntilChanged(h.c.m0.d<? super T, ? super T> dVar) {
        h.c.n0.b.b.e(dVar, "comparer is null");
        return h.c.r0.a.n(new k0(this, h.c.n0.b.a.j(), dVar));
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, boolean z, int i2, int i3) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "bufferSize");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return w2.a(call, nVar);
        }
        return h.c.r0.a.n(new v0(this, nVar, z, i2, i3));
    }

    public final <K, V> s<h.c.o0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, boolean z) {
        return groupBy(nVar, nVar2, z, bufferSize());
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return q2.i(n1.h(this, i2), nVar);
    }

    public final s<T> retry(long j2) {
        return retry(j2, h.c.n0.b.a.c());
    }

    public final s<T> skip(long j2, TimeUnit timeUnit, a0 a0Var) {
        return skipUntil(timer(j2, timeUnit, a0Var));
    }

    public final s<T> skipLast(long j2, TimeUnit timeUnit) {
        return skipLast(j2, timeUnit, h.c.u0.a.e(), false, bufferSize());
    }

    public final s<T> startWith(T t) {
        h.c.n0.b.b.e(t, "item is null");
        return concatArray(just(t), this);
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
        return subscribe(fVar, fVar2, aVar, h.c.n0.b.a.h());
    }

    public final s<T> take(long j2, TimeUnit timeUnit, a0 a0Var) {
        return takeUntil(timer(j2, timeUnit, a0Var));
    }

    public final s<T> throttleLatest(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new u3(this, j2, timeUnit, a0Var, z));
    }

    public final s<h.c.u0.b<T>> timeInterval(TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new v3(this, timeUnit, a0Var));
    }

    public final s<T> timeout(long j2, TimeUnit timeUnit) {
        return timeout0(j2, timeUnit, null, h.c.u0.a.a());
    }

    public final s<h.c.u0.b<T>> timestamp(TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return (s<h.c.u0.b<T>>) map(h.c.n0.b.a.v(timeUnit, a0Var));
    }

    public final <U extends Collection<? super T>> b0<U> toList(Callable<U> callable) {
        h.c.n0.b.b.e(callable, "collectionSupplier is null");
        return h.c.r0.a.o(new a4(this, callable));
    }

    public final b0<List<T>> toSortedList(Comparator<? super T> comparator, int i2) {
        h.c.n0.b.b.e(comparator, "comparator is null");
        return (b0<List<T>>) toList(i2).map(h.c.n0.b.a.n(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> s<R> withLatestFrom(x<T1> xVar, x<T2> xVar2, h.c.m0.g<? super T, ? super T1, ? super T2, R> gVar) {
        h.c.n0.b.b.e(xVar, "o1 is null");
        h.c.n0.b.b.e(xVar2, "o2 is null");
        h.c.n0.b.b.e(gVar, "combiner is null");
        return withLatestFrom(new x[]{xVar, xVar2}, h.c.n0.b.a.x(gVar));
    }

    public final <U, R> s<R> zipWith(x<? extends U> xVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return zip(this, xVar, cVar);
    }

    public static <T, S> s<T> generate(Callable<S> callable, h.c.m0.b<S, g<T>> bVar) {
        h.c.n0.b.b.e(bVar, "generator is null");
        return generate(callable, n1.l(bVar), h.c.n0.b.a.h());
    }

    public static s<Long> interval(long j2, TimeUnit timeUnit) {
        return interval(j2, j2, timeUnit, h.c.u0.a.a());
    }

    public final T blockingFirst(T t) {
        h.c.n0.d.f fVar = new h.c.n0.d.f();
        subscribe(fVar);
        T a2 = fVar.a();
        return a2 != null ? a2 : t;
    }

    public final T blockingLast(T t) {
        h.c.n0.d.g gVar = new h.c.n0.d.g();
        subscribe(gVar);
        T a2 = gVar.a();
        return a2 != null ? a2 : t;
    }

    public final void blockingSubscribe(z<? super T> zVar) {
        h.c.n0.e.e.k.b(this, zVar);
    }

    public final s<T> concatWith(q<? extends T> qVar) {
        h.c.n0.b.b.e(qVar, "other is null");
        return h.c.r0.a.n(new h.c.n0.e.e.x(this, qVar));
    }

    public final s<T> delay(long j2, TimeUnit timeUnit, a0 a0Var) {
        return delay(j2, timeUnit, a0Var, false);
    }

    public final <K, V> s<h.c.o0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new i1(this, nVar, nVar2, i2, z));
    }

    public final s<T> mergeWith(q<? extends T> qVar) {
        h.c.n0.b.b.e(qVar, "other is null");
        return h.c.r0.a.n(new z1(this, qVar));
    }

    public final s<T> retry(long j2, h.c.m0.p<? super Throwable> pVar) {
        if (j2 >= 0) {
            h.c.n0.b.b.e(pVar, "predicate is null");
            return h.c.r0.a.n(new s2(this, j2, pVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    public final s<T> skipLast(long j2, TimeUnit timeUnit, boolean z) {
        return skipLast(j2, timeUnit, h.c.u0.a.e(), z, bufferSize());
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.f<? super h.c.k0.b> fVar3) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.b.b.e(fVar3, "onSubscribe is null");
        h.c.n0.d.t tVar = new h.c.n0.d.t(fVar, fVar2, aVar, fVar3);
        subscribe(tVar);
        return tVar;
    }

    public final s<T> takeLast(long j2, long j3, TimeUnit timeUnit) {
        return takeLast(j2, j3, timeUnit, h.c.u0.a.e(), false, bufferSize());
    }

    public final s<T> timeout(long j2, TimeUnit timeUnit, x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return timeout0(j2, timeUnit, xVar, h.c.u0.a.a());
    }

    public final <K, V> b0<Map<K, Collection<V>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        return toMultimap(nVar, nVar2, h.c.n0.j.l.h(), h.c.n0.j.b.q());
    }

    public static <T> s<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return fromFuture(future, j2, timeUnit).subscribeOn(a0Var);
    }

    public static s<Long> interval(long j2, TimeUnit timeUnit, a0 a0Var) {
        return interval(j2, j2, timeUnit, a0Var);
    }

    public static <T> s<T> just(T t, T t2, T t3) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    public static <T> s<T> merge(x<? extends x<? extends T>> xVar, int i2) {
        h.c.n0.b.b.e(xVar, "sources is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        return h.c.r0.a.n(new v0(xVar, h.c.n0.b.a.j(), false, i2, bufferSize()));
    }

    public static <T> s<T> mergeDelayError(x<? extends x<? extends T>> xVar, int i2) {
        h.c.n0.b.b.e(xVar, "sources is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        return h.c.r0.a.n(new v0(xVar, h.c.n0.b.a.j(), true, i2, bufferSize()));
    }

    public final s<T> delay(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new h.c.n0.e.e.f0(this, j2, timeUnit, a0Var, z));
    }

    public final s<T> doOnEach(h.c.m0.f<? super r<T>> fVar) {
        h.c.n0.b.b.e(fVar, "onNotification is null");
        return doOnEach(h.c.n0.b.a.s(fVar), h.c.n0.b.a.r(fVar), h.c.n0.b.a.q(fVar), h.c.n0.b.a.f14096c);
    }

    public final s<T> sample(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.n(new u2(this, j2, timeUnit, a0Var, z));
    }

    public final s<T> skipLast(long j2, TimeUnit timeUnit, a0 a0Var) {
        return skipLast(j2, timeUnit, a0Var, false, bufferSize());
    }

    public final s<T> takeLast(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        return takeLast(j2, j3, timeUnit, a0Var, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> b0<Map<K, V>> toMap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, Callable<? extends Map<K, V>> callable) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        h.c.n0.b.b.e(callable, "mapSupplier is null");
        return (b0<Map<K, V>>) collect(callable, h.c.n0.b.a.F(nVar, nVar2));
    }

    public final b0<List<T>> toSortedList(int i2) {
        return toSortedList(h.c.n0.b.a.p(), i2);
    }

    public final <U, R> s<R> zipWith(x<? extends U> xVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return zip(this, xVar, cVar, z);
    }

    public static <T, R> s<R> combineLatest(x<? extends T>[] xVarArr, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatest(xVarArr, nVar, bufferSize());
    }

    public static <T> s<T> concat(x<? extends T> xVar, x<? extends T> xVar2) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return concatArray(xVar, xVar2);
    }

    public static <T, S> s<T> generate(Callable<S> callable, h.c.m0.b<S, g<T>> bVar, h.c.m0.f<? super S> fVar) {
        h.c.n0.b.b.e(bVar, "generator is null");
        return generate(callable, n1.l(bVar), fVar);
    }

    public final <U extends Collection<? super T>> s<U> buffer(int i2, Callable<U> callable) {
        return buffer(i2, i2, callable);
    }

    public final s<T> concatWith(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return h.c.r0.a.n(new h.c.n0.e.e.w(this, fVar));
    }

    public final s<T> mergeWith(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return h.c.r0.a.n(new y1(this, fVar));
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, int i2, long j2, TimeUnit timeUnit) {
        return replay(nVar, i2, j2, timeUnit, h.c.u0.a.a());
    }

    public final s<T> skipLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        return skipLast(j2, timeUnit, a0Var, z, bufferSize());
    }

    public final s<T> takeLast(long j2, long j3, TimeUnit timeUnit, a0 a0Var, boolean z, int i2) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        if (j2 >= 0) {
            return h.c.r0.a.n(new p3(this, j2, j3, timeUnit, a0Var, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    public final s<T> timeout(long j2, TimeUnit timeUnit, a0 a0Var, x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return timeout0(j2, timeUnit, xVar, a0Var);
    }

    public final s<s<T>> window(long j2, long j3, TimeUnit timeUnit) {
        return window(j2, j3, timeUnit, h.c.u0.a.a(), bufferSize());
    }

    public final <U, R> s<R> zipWith(x<? extends U> xVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return zip(this, xVar, cVar, z, i2);
    }

    public static <T, R> s<R> combineLatest(x<? extends T>[] xVarArr, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(xVarArr, "sources is null");
        if (xVarArr.length == 0) {
            return empty();
        }
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new h.c.n0.e.e.t(xVarArr, null, nVar, i2 << 1, false));
    }

    public static <T, R> s<R> combineLatestDelayError(Iterable<? extends x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatestDelayError(iterable, nVar, bufferSize());
    }

    public static <T> b0<Boolean> sequenceEqual(x<? extends T> xVar, x<? extends T> xVar2, int i2) {
        return sequenceEqual(xVar, xVar2, h.c.n0.b.b.d(), i2);
    }

    public final s<List<T>> buffer(long j2, long j3, TimeUnit timeUnit) {
        return (s<List<T>>) buffer(j2, j3, timeUnit, h.c.u0.a.a(), h.c.n0.j.b.n());
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, int i2, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return q2.i(n1.i(this, i2, j2, timeUnit, a0Var), nVar);
    }

    public final s<T> retry(h.c.m0.p<? super Throwable> pVar) {
        return retry(Long.MAX_VALUE, pVar);
    }

    public final s<T> skipLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z, int i2) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new g3(this, j2, timeUnit, a0Var, i2 << 1, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> b0<Map<K, Collection<V>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, Callable<? extends Map<K, Collection<V>>> callable, h.c.m0.n<? super K, ? extends Collection<? super V>> nVar3) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        h.c.n0.b.b.e(callable, "mapSupplier is null");
        h.c.n0.b.b.e(nVar3, "collectionFactory is null");
        return (b0<Map<K, Collection<V>>>) collect(callable, h.c.n0.b.a.G(nVar, nVar2, nVar3));
    }

    public final s<s<T>> window(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        return window(j2, j3, timeUnit, a0Var, bufferSize());
    }

    public static <T, R> s<R> combineLatestDelayError(Iterable<? extends x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new h.c.n0.e.e.t(null, iterable, nVar, i2 << 1, true));
    }

    public static <T> s<T> fromFuture(Future<? extends T> future, a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return fromFuture(future).subscribeOn(a0Var);
    }

    public static <T, S> s<T> generate(Callable<S> callable, h.c.m0.c<S, g<T>, S> cVar) {
        return generate(callable, cVar, h.c.n0.b.a.h());
    }

    public static <T> s<T> merge(x<? extends T> xVar, x<? extends T> xVar2) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return fromArray(xVar, xVar2).flatMap(h.c.n0.b.a.j(), false, 2);
    }

    public static <T> s<T> mergeDelayError(x<? extends T> xVar, x<? extends T> xVar2) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return fromArray(xVar, xVar2).flatMap(h.c.n0.b.a.j(), true, 2);
    }

    public static <T1, T2, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), false, bufferSize(), xVar, xVar2);
    }

    public final s<List<T>> buffer(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        return (s<List<T>>) buffer(j2, j3, timeUnit, a0Var, h.c.n0.j.b.n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> s<T> delay(x<U> xVar, h.c.m0.n<? super T, ? extends x<V>> nVar) {
        return delaySubscription(xVar).delay(nVar);
    }

    public final <U> s<T> sample(x<U> xVar) {
        h.c.n0.b.b.e(xVar, "sampler is null");
        return h.c.r0.a.n(new v2(this, xVar, false));
    }

    public final s<T> timeout(long j2, TimeUnit timeUnit, a0 a0Var) {
        return timeout0(j2, timeUnit, null, a0Var);
    }

    public final s<s<T>> window(long j2, long j3, TimeUnit timeUnit, a0 a0Var, int i2) {
        h.c.n0.b.b.g(j2, "timespan");
        h.c.n0.b.b.g(j3, "timeskip");
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        return h.c.r0.a.n(new h4(this, j2, j3, timeUnit, a0Var, Long.MAX_VALUE, i2, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> s<R> withLatestFrom(x<T1> xVar, x<T2> xVar2, x<T3> xVar3, h.c.m0.h<? super T, ? super T1, ? super T2, ? super T3, R> hVar) {
        h.c.n0.b.b.e(xVar, "o1 is null");
        h.c.n0.b.b.e(xVar2, "o2 is null");
        h.c.n0.b.b.e(xVar3, "o3 is null");
        h.c.n0.b.b.e(hVar, "combiner is null");
        return withLatestFrom(new x[]{xVar, xVar2, xVar3}, h.c.n0.b.a.y(hVar));
    }

    public static <T> s<T> concat(x<? extends T> xVar, x<? extends T> xVar2, x<? extends T> xVar3) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        return concatArray(xVar, xVar2, xVar3);
    }

    public static <T, S> s<T> generate(Callable<S> callable, h.c.m0.c<S, g<T>, S> cVar, h.c.m0.f<? super S> fVar) {
        h.c.n0.b.b.e(callable, "initialState is null");
        h.c.n0.b.b.e(cVar, "generator is null");
        h.c.n0.b.b.e(fVar, "disposeState is null");
        return h.c.r0.a.n(new h1(callable, cVar, fVar));
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    public final <U extends Collection<? super T>> s<U> buffer(long j2, long j3, TimeUnit timeUnit, a0 a0Var, Callable<U> callable) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.n(new h.c.n0.e.e.p(this, j2, j3, timeUnit, a0Var, callable, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, false));
    }

    public final <U, V> s<T> timeout(x<U> xVar, h.c.m0.n<? super T, ? extends x<V>> nVar) {
        h.c.n0.b.b.e(xVar, "firstTimeoutIndicator is null");
        return timeout0(xVar, nVar, null);
    }

    public final s<T> doOnEach(z<? super T> zVar) {
        h.c.n0.b.b.e(zVar, "observer is null");
        return doOnEach(n1.f(zVar), n1.e(zVar), n1.d(zVar), h.c.n0.b.a.f14096c);
    }

    public final <U> s<T> sample(x<U> xVar, boolean z) {
        h.c.n0.b.b.e(xVar, "sampler is null");
        return h.c.r0.a.n(new v2(this, xVar, z));
    }

    @Override // h.c.x
    public final void subscribe(z<? super T> zVar) {
        h.c.n0.b.b.e(zVar, "observer is null");
        try {
            z<? super T> A = h.c.r0.a.A(this, zVar);
            h.c.n0.b.b.e(A, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(A);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T> s<T> merge(x<? extends T> xVar, x<? extends T> xVar2, x<? extends T> xVar3) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        return fromArray(xVar, xVar2, xVar3).flatMap(h.c.n0.b.a.j(), false, 3);
    }

    public static <T> s<T> mergeDelayError(x<? extends T> xVar, x<? extends T> xVar2, x<? extends T> xVar3) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        return fromArray(xVar, xVar2, xVar3).flatMap(h.c.n0.b.a.j(), true, 3);
    }

    public static <T1, T2, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), z, bufferSize(), xVar, xVar2);
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, h.c.m0.n<? super Throwable, ? extends x<? extends R>> nVar2, Callable<? extends x<? extends R>> callable) {
        h.c.n0.b.b.e(nVar, "onNextMapper is null");
        h.c.n0.b.b.e(nVar2, "onErrorMapper is null");
        h.c.n0.b.b.e(callable, "onCompleteSupplier is null");
        return merge(new w1(this, nVar, nVar2, callable));
    }

    public final s<T> takeLast(long j2, TimeUnit timeUnit) {
        return takeLast(j2, timeUnit, h.c.u0.a.e(), false, bufferSize());
    }

    public final <U, V> s<T> timeout(x<U> xVar, h.c.m0.n<? super T, ? extends x<V>> nVar, x<? extends T> xVar2) {
        h.c.n0.b.b.e(xVar, "firstTimeoutIndicator is null");
        h.c.n0.b.b.e(xVar2, "other is null");
        return timeout0(xVar, nVar, xVar2);
    }

    public final s<T> takeLast(long j2, TimeUnit timeUnit, boolean z) {
        return takeLast(j2, timeUnit, h.c.u0.a.e(), z, bufferSize());
    }

    public final <K, V> b0<Map<K, Collection<V>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(nVar, nVar2, callable, h.c.n0.j.b.q());
    }

    public static <T1, T2, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return combineLatest(h.c.n0.b.a.w(cVar), bufferSize(), xVar, xVar2);
    }

    public static <T> s<T> concat(x<? extends T> xVar, x<? extends T> xVar2, x<? extends T> xVar3, x<? extends T> xVar4) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        return concatArray(xVar, xVar2, xVar3, xVar4);
    }

    public final s<List<T>> buffer(long j2, TimeUnit timeUnit) {
        return buffer(j2, timeUnit, h.c.u0.a.a(), (int) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, int i2, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return q2.i(n1.h(this, i2), n1.k(nVar, a0Var));
    }

    public final s<T> takeLast(long j2, TimeUnit timeUnit, a0 a0Var) {
        return takeLast(j2, timeUnit, a0Var, false, bufferSize());
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4, T t5) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T1, T2, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i2) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), z, i2, xVar, xVar2);
    }

    public final s<List<T>> buffer(long j2, TimeUnit timeUnit, int i2) {
        return buffer(j2, timeUnit, h.c.u0.a.a(), i2);
    }

    public final s<T> takeLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        return takeLast(j2, timeUnit, a0Var, z, bufferSize());
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit) {
        return window(j2, timeUnit, h.c.u0.a.a(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> s<R> withLatestFrom(x<T1> xVar, x<T2> xVar2, x<T3> xVar3, x<T4> xVar4, h.c.m0.i<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> iVar) {
        h.c.n0.b.b.e(xVar, "o1 is null");
        h.c.n0.b.b.e(xVar2, "o2 is null");
        h.c.n0.b.b.e(xVar3, "o3 is null");
        h.c.n0.b.b.e(xVar4, "o4 is null");
        h.c.n0.b.b.e(iVar, "combiner is null");
        return withLatestFrom(new x[]{xVar, xVar2, xVar3, xVar4}, h.c.n0.b.a.z(iVar));
    }

    public static <T> s<T> merge(x<? extends T> xVar, x<? extends T> xVar2, x<? extends T> xVar3, x<? extends T> xVar4) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        return fromArray(xVar, xVar2, xVar3, xVar4).flatMap(h.c.n0.b.a.j(), false, 4);
    }

    public static <T> s<T> mergeDelayError(x<? extends T> xVar, x<? extends T> xVar2, x<? extends T> xVar3, x<? extends T> xVar4) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        return fromArray(xVar, xVar2, xVar3, xVar4).flatMap(h.c.n0.b.a.j(), true, 4);
    }

    public final s<List<T>> buffer(long j2, TimeUnit timeUnit, a0 a0Var, int i2) {
        return (s<List<T>>) buffer(j2, timeUnit, a0Var, i2, h.c.n0.j.b.n(), false);
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, h.c.m0.n<Throwable, ? extends x<? extends R>> nVar2, Callable<? extends x<? extends R>> callable, int i2) {
        h.c.n0.b.b.e(nVar, "onNextMapper is null");
        h.c.n0.b.b.e(nVar2, "onErrorMapper is null");
        h.c.n0.b.b.e(callable, "onCompleteSupplier is null");
        return merge(new w1(this, nVar, nVar2, callable), i2);
    }

    public final s<T> takeLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z, int i2) {
        return takeLast(Long.MAX_VALUE, j2, timeUnit, a0Var, z, i2);
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit, long j3) {
        return window(j2, timeUnit, h.c.u0.a.a(), j3, false);
    }

    public static <T1, T2, T3, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, h.c.m0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        return combineLatest(h.c.n0.b.a.x(gVar), bufferSize(), xVar, xVar2, xVar3);
    }

    public final <U extends Collection<? super T>> s<U> buffer(long j2, TimeUnit timeUnit, a0 a0Var, int i2, Callable<U> callable, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        h.c.n0.b.b.f(i2, "count");
        return h.c.r0.a.n(new h.c.n0.e.e.p(this, j2, j2, timeUnit, a0Var, callable, i2, z));
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return window(j2, timeUnit, h.c.u0.a.a(), j3, z);
    }

    public static <T1, T2, T3, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, h.c.m0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        return zipArray(h.c.n0.b.a.x(gVar), false, bufferSize(), xVar, xVar2, xVar3);
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit, a0 a0Var) {
        return window(j2, timeUnit, a0Var, Long.MAX_VALUE, false);
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit, a0 a0Var, long j3) {
        return window(j2, timeUnit, a0Var, j3, false);
    }

    public final <R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends R>> nVar, int i2) {
        return flatMap((h.c.m0.n) nVar, false, i2, bufferSize());
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, long j2, TimeUnit timeUnit) {
        return replay(nVar, j2, timeUnit, h.c.u0.a.a());
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit, a0 a0Var, long j3, boolean z) {
        return window(j2, timeUnit, a0Var, j3, z, bufferSize());
    }

    public static <T1, T2, T3, T4, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, h.c.m0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        return combineLatest(h.c.n0.b.a.y(hVar), bufferSize(), xVar, xVar2, xVar3, xVar4);
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public final <U, R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        return flatMap(nVar, cVar, false, bufferSize(), bufferSize());
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return q2.i(n1.j(this, j2, timeUnit, a0Var), nVar);
    }

    public final s<s<T>> window(long j2, TimeUnit timeUnit, a0 a0Var, long j3, boolean z, int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.g(j3, "count");
        return h.c.r0.a.n(new h4(this, j2, j2, timeUnit, a0Var, j3, i2, z));
    }

    public static <T1, T2, T3, T4, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, h.c.m0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        return zipArray(h.c.n0.b.a.y(hVar), false, bufferSize(), xVar, xVar2, xVar3, xVar4);
    }

    public final s<List<T>> buffer(long j2, TimeUnit timeUnit, a0 a0Var) {
        return (s<List<T>>) buffer(j2, timeUnit, a0Var, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, h.c.n0.j.b.n(), false);
    }

    public final <U, R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return flatMap(nVar, cVar, z, bufferSize(), bufferSize());
    }

    public final <R> s<R> withLatestFrom(x<?>[] xVarArr, h.c.m0.n<? super Object[], R> nVar) {
        h.c.n0.b.b.e(xVarArr, "others is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        return h.c.r0.a.n(new j4(this, xVarArr, nVar));
    }

    public final <TOpening, TClosing> s<List<T>> buffer(x<? extends TOpening> xVar, h.c.m0.n<? super TOpening, ? extends x<? extends TClosing>> nVar) {
        return (s<List<T>>) buffer(xVar, nVar, h.c.n0.j.b.n());
    }

    public final <U, R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return flatMap(nVar, cVar, z, i2, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> s<U> buffer(x<? extends TOpening> xVar, h.c.m0.n<? super TOpening, ? extends x<? extends TClosing>> nVar, Callable<U> callable) {
        h.c.n0.b.b.e(xVar, "openingIndicator is null");
        h.c.n0.b.b.e(nVar, "closingIndicator is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.n(new h.c.n0.e.e.m(this, xVar, nVar, callable));
    }

    public final <U, R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2, int i3) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.e(cVar, "combiner is null");
        return flatMap(n1.b(nVar, cVar), z, i2, i3);
    }

    public final <R> s<R> replay(h.c.m0.n<? super s<T>, ? extends x<R>> nVar, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return q2.i(n1.g(this), n1.k(nVar, a0Var));
    }

    public final <R> s<R> withLatestFrom(Iterable<? extends x<?>> iterable, h.c.m0.n<? super Object[], R> nVar) {
        h.c.n0.b.b.e(iterable, "others is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        return h.c.r0.a.n(new j4(this, iterable, nVar));
    }

    public static <T1, T2, T3, T4, T5, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, h.c.m0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        return combineLatest(h.c.n0.b.a.z(iVar), bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5);
    }

    public final <B> s<s<T>> window(x<B> xVar) {
        return window(xVar, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, h.c.m0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        return zipArray(h.c.n0.b.a.z(iVar), false, bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5);
    }

    public final <U, R> s<R> flatMap(h.c.m0.n<? super T, ? extends x<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, int i2) {
        return flatMap(nVar, cVar, false, i2, bufferSize());
    }

    public final <B> s<s<T>> window(x<B> xVar, int i2) {
        h.c.n0.b.b.e(xVar, "boundary is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new e4(this, xVar, i2));
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        h.c.n0.b.b.e(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public final <B> s<List<T>> buffer(x<B> xVar) {
        return (s<List<T>>) buffer(xVar, h.c.n0.j.b.n());
    }

    public final <B> s<List<T>> buffer(x<B> xVar, int i2) {
        h.c.n0.b.b.f(i2, "initialCapacity");
        return (s<List<T>>) buffer(xVar, h.c.n0.b.a.f(i2));
    }

    public final h.c.o0.a<T> replay(int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        return q2.d(this, i2);
    }

    public final <U, V> s<s<T>> window(x<U> xVar, h.c.m0.n<? super U, ? extends x<V>> nVar) {
        return window(xVar, nVar, bufferSize());
    }

    public final <B, U extends Collection<? super T>> s<U> buffer(x<B> xVar, Callable<U> callable) {
        h.c.n0.b.b.e(xVar, "boundary is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.n(new h.c.n0.e.e.o(this, xVar, callable));
    }

    public final <U, V> s<s<T>> window(x<U> xVar, h.c.m0.n<? super U, ? extends x<V>> nVar, int i2) {
        h.c.n0.b.b.e(xVar, "openingIndicator is null");
        h.c.n0.b.b.e(nVar, "closingIndicator is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new f4(this, xVar, nVar, i2));
    }

    public static <T1, T2, T3, T4, T5, T6, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, h.c.m0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        return combineLatest(h.c.n0.b.a.A(jVar), bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6);
    }

    public final h.c.o0.a<T> replay(int i2, long j2, TimeUnit timeUnit) {
        return replay(i2, j2, timeUnit, h.c.u0.a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, h.c.m0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        return zipArray(h.c.n0.b.a.A(jVar), false, bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6);
    }

    public final h.c.o0.a<T> replay(int i2, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return q2.f(this, j2, timeUnit, a0Var, i2);
    }

    public final <B> s<List<T>> buffer(Callable<? extends x<B>> callable) {
        return (s<List<T>>) buffer(callable, h.c.n0.j.b.n());
    }

    public final <B, U extends Collection<? super T>> s<U> buffer(Callable<? extends x<B>> callable, Callable<U> callable2) {
        h.c.n0.b.b.e(callable, "boundarySupplier is null");
        h.c.n0.b.b.e(callable2, "bufferSupplier is null");
        return h.c.r0.a.n(new h.c.n0.e.e.n(this, callable, callable2));
    }

    public final <B> s<s<T>> window(Callable<? extends x<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        h.c.n0.b.b.e(t7, "item7 is null");
        h.c.n0.b.b.e(t8, "item8 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    public final <B> s<s<T>> window(Callable<? extends x<B>> callable, int i2) {
        h.c.n0.b.b.e(callable, "boundary is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.n(new g4(this, callable, i2));
    }

    public final h.c.o0.a<T> replay(int i2, a0 a0Var) {
        h.c.n0.b.b.f(i2, "bufferSize");
        return q2.j(replay(i2), a0Var);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, x<? extends T7> xVar7, h.c.m0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        h.c.n0.b.b.e(xVar7, "source7 is null");
        return combineLatest(h.c.n0.b.a.B(kVar), bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7);
    }

    public final h.c.o0.a<T> replay(long j2, TimeUnit timeUnit) {
        return replay(j2, timeUnit, h.c.u0.a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, x<? extends T7> xVar7, h.c.m0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        h.c.n0.b.b.e(xVar7, "source7 is null");
        return zipArray(h.c.n0.b.a.B(kVar), false, bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7);
    }

    public final h.c.o0.a<T> replay(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return q2.e(this, j2, timeUnit, a0Var);
    }

    public final h.c.o0.a<T> replay(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return q2.j(replay(), a0Var);
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        h.c.n0.b.b.e(t7, "item7 is null");
        h.c.n0.b.b.e(t8, "item8 is null");
        h.c.n0.b.b.e(t9, "item9 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, x<? extends T7> xVar7, x<? extends T8> xVar8, h.c.m0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        h.c.n0.b.b.e(xVar7, "source7 is null");
        h.c.n0.b.b.e(xVar8, "source8 is null");
        return combineLatest(h.c.n0.b.a.C(lVar), bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7, xVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, x<? extends T7> xVar7, x<? extends T8> xVar8, h.c.m0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        h.c.n0.b.b.e(xVar7, "source7 is null");
        h.c.n0.b.b.e(xVar8, "source8 is null");
        return zipArray(h.c.n0.b.a.C(lVar), false, bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7, xVar8);
    }

    public static <T> s<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        h.c.n0.b.b.e(t7, "item7 is null");
        h.c.n0.b.b.e(t8, "item8 is null");
        h.c.n0.b.b.e(t9, "item9 is null");
        h.c.n0.b.b.e(t10, "item10 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> s<R> combineLatest(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, x<? extends T7> xVar7, x<? extends T8> xVar8, x<? extends T9> xVar9, h.c.m0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        h.c.n0.b.b.e(xVar7, "source7 is null");
        h.c.n0.b.b.e(xVar8, "source8 is null");
        h.c.n0.b.b.e(xVar9, "source9 is null");
        return combineLatest(h.c.n0.b.a.D(mVar), bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7, xVar8, xVar9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> s<R> zip(x<? extends T1> xVar, x<? extends T2> xVar2, x<? extends T3> xVar3, x<? extends T4> xVar4, x<? extends T5> xVar5, x<? extends T6> xVar6, x<? extends T7> xVar7, x<? extends T8> xVar8, x<? extends T9> xVar9, h.c.m0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        h.c.n0.b.b.e(xVar, "source1 is null");
        h.c.n0.b.b.e(xVar2, "source2 is null");
        h.c.n0.b.b.e(xVar3, "source3 is null");
        h.c.n0.b.b.e(xVar4, "source4 is null");
        h.c.n0.b.b.e(xVar5, "source5 is null");
        h.c.n0.b.b.e(xVar6, "source6 is null");
        h.c.n0.b.b.e(xVar7, "source7 is null");
        h.c.n0.b.b.e(xVar8, "source8 is null");
        h.c.n0.b.b.e(xVar9, "source9 is null");
        return zipArray(h.c.n0.b.a.D(mVar), false, bufferSize(), xVar, xVar2, xVar3, xVar4, xVar5, xVar6, xVar7, xVar8, xVar9);
    }
}