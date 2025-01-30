package h.c;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import h.c.n0.e.b.a1;
import h.c.n0.e.b.a2;
import h.c.n0.e.b.a3;
import h.c.n0.e.b.a4;
import h.c.n0.e.b.b1;
import h.c.n0.e.b.b2;
import h.c.n0.e.b.b3;
import h.c.n0.e.b.b4;
import h.c.n0.e.b.c3;
import h.c.n0.e.b.c4;
import h.c.n0.e.b.d1;
import h.c.n0.e.b.d2;
import h.c.n0.e.b.d3;
import h.c.n0.e.b.e1;
import h.c.n0.e.b.e2;
import h.c.n0.e.b.e3;
import h.c.n0.e.b.e4;
import h.c.n0.e.b.f1;
import h.c.n0.e.b.f2;
import h.c.n0.e.b.f3;
import h.c.n0.e.b.f4;
import h.c.n0.e.b.g1;
import h.c.n0.e.b.g2;
import h.c.n0.e.b.g3;
import h.c.n0.e.b.g4;
import h.c.n0.e.b.h1;
import h.c.n0.e.b.h2;
import h.c.n0.e.b.h3;
import h.c.n0.e.b.h4;
import h.c.n0.e.b.i1;
import h.c.n0.e.b.i2;
import h.c.n0.e.b.i3;
import h.c.n0.e.b.i4;
import h.c.n0.e.b.j0;
import h.c.n0.e.b.j2;
import h.c.n0.e.b.j3;
import h.c.n0.e.b.j4;
import h.c.n0.e.b.k0;
import h.c.n0.e.b.k1;
import h.c.n0.e.b.k2;
import h.c.n0.e.b.k3;
import h.c.n0.e.b.k4;
import h.c.n0.e.b.l0;
import h.c.n0.e.b.l1;
import h.c.n0.e.b.l2;
import h.c.n0.e.b.l4;
import h.c.n0.e.b.m0;
import h.c.n0.e.b.m1;
import h.c.n0.e.b.m3;
import h.c.n0.e.b.m4;
import h.c.n0.e.b.n0;
import h.c.n0.e.b.n1;
import h.c.n0.e.b.n2;
import h.c.n0.e.b.n3;
import h.c.n0.e.b.o0;
import h.c.n0.e.b.o1;
import h.c.n0.e.b.o2;
import h.c.n0.e.b.o4;
import h.c.n0.e.b.p0;
import h.c.n0.e.b.p1;
import h.c.n0.e.b.p2;
import h.c.n0.e.b.p3;
import h.c.n0.e.b.p4;
import h.c.n0.e.b.q0;
import h.c.n0.e.b.q1;
import h.c.n0.e.b.q2;
import h.c.n0.e.b.q3;
import h.c.n0.e.b.q4;
import h.c.n0.e.b.r0;
import h.c.n0.e.b.r1;
import h.c.n0.e.b.r2;
import h.c.n0.e.b.r3;
import h.c.n0.e.b.r4;
import h.c.n0.e.b.s1;
import h.c.n0.e.b.s2;
import h.c.n0.e.b.s3;
import h.c.n0.e.b.s4;
import h.c.n0.e.b.t0;
import h.c.n0.e.b.t1;
import h.c.n0.e.b.t2;
import h.c.n0.e.b.t3;
import h.c.n0.e.b.t4;
import h.c.n0.e.b.u0;
import h.c.n0.e.b.u1;
import h.c.n0.e.b.u3;
import h.c.n0.e.b.u4;
import h.c.n0.e.b.v0;
import h.c.n0.e.b.v1;
import h.c.n0.e.b.v2;
import h.c.n0.e.b.v3;
import h.c.n0.e.b.v4;
import h.c.n0.e.b.w0;
import h.c.n0.e.b.w1;
import h.c.n0.e.b.w2;
import h.c.n0.e.b.w3;
import h.c.n0.e.b.w4;
import h.c.n0.e.b.x0;
import h.c.n0.e.b.x1;
import h.c.n0.e.b.x2;
import h.c.n0.e.b.x3;
import h.c.n0.e.b.x4;
import h.c.n0.e.b.y0;
import h.c.n0.e.b.y1;
import h.c.n0.e.b.y3;
import h.c.n0.e.b.y4;
import h.c.n0.e.b.z1;
import h.c.n0.e.b.z2;
import h.c.n0.e.b.z3;
import h.c.n0.e.b.z4;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Flowable.java */
/* loaded from: classes2.dex */
public abstract class h<T> implements k.a.b<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static <T> h<T> amb(Iterable<? extends k.a.b<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return h.c.r0.a.l(new h.c.n0.e.b.h(null, iterable));
    }

    public static <T> h<T> ambArray(k.a.b<? extends T>... bVarArr) {
        h.c.n0.b.b.e(bVarArr, "sources is null");
        int length = bVarArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return fromPublisher(bVarArr[0]);
        }
        return h.c.r0.a.l(new h.c.n0.e.b.h(bVarArr, null));
    }

    public static int bufferSize() {
        return BUFFER_SIZE;
    }

    public static <T, R> h<R> combineLatest(k.a.b<? extends T>[] bVarArr, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatest(bVarArr, nVar, bufferSize());
    }

    public static <T, R> h<R> combineLatestDelayError(k.a.b<? extends T>[] bVarArr, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatestDelayError(bVarArr, nVar, bufferSize());
    }

    public static <T> h<T> concat(Iterable<? extends k.a.b<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(h.c.n0.b.a.j(), 2, false);
    }

    public static <T> h<T> concatArray(k.a.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return fromPublisher(bVarArr[0]);
        }
        return h.c.r0.a.l(new h.c.n0.e.b.u(bVarArr, false));
    }

    public static <T> h<T> concatArrayDelayError(k.a.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        if (bVarArr.length == 1) {
            return fromPublisher(bVarArr[0]);
        }
        return h.c.r0.a.l(new h.c.n0.e.b.u(bVarArr, true));
    }

    public static <T> h<T> concatArrayEager(k.a.b<? extends T>... bVarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), bVarArr);
    }

    public static <T> h<T> concatArrayEagerDelayError(k.a.b<? extends T>... bVarArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), bVarArr);
    }

    public static <T> h<T> concatDelayError(Iterable<? extends k.a.b<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(h.c.n0.b.a.j());
    }

    public static <T> h<T> concatEager(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return concatEager(bVar, bufferSize(), bufferSize());
    }

    public static <T> h<T> create(k<T> kVar, b bVar) {
        h.c.n0.b.b.e(kVar, "source is null");
        h.c.n0.b.b.e(bVar, "mode is null");
        return h.c.r0.a.l(new h.c.n0.e.b.e0(kVar, bVar));
    }

    public static <T> h<T> defer(Callable<? extends k.a.b<? extends T>> callable) {
        h.c.n0.b.b.e(callable, "supplier is null");
        return h.c.r0.a.l(new h.c.n0.e.b.h0(callable));
    }

    private h<T> doOnEach(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.b.b.e(aVar2, "onAfterTerminate is null");
        return h.c.r0.a.l(new q0(this, fVar, fVar2, aVar, aVar2));
    }

    public static <T> h<T> empty() {
        return h.c.r0.a.l(v0.a);
    }

    public static <T> h<T> error(Callable<? extends Throwable> callable) {
        h.c.n0.b.b.e(callable, "supplier is null");
        return h.c.r0.a.l(new w0(callable));
    }

    public static <T> h<T> fromArray(T... tArr) {
        h.c.n0.b.b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return h.c.r0.a.l(new f1(tArr));
    }

    public static <T> h<T> fromCallable(Callable<? extends T> callable) {
        h.c.n0.b.b.e(callable, "supplier is null");
        return h.c.r0.a.l(new g1(callable));
    }

    public static <T> h<T> fromFuture(Future<? extends T> future) {
        h.c.n0.b.b.e(future, "future is null");
        return h.c.r0.a.l(new h1(future, 0L, null));
    }

    public static <T> h<T> fromIterable(Iterable<? extends T> iterable) {
        h.c.n0.b.b.e(iterable, "source is null");
        return h.c.r0.a.l(new i1(iterable));
    }

    public static <T> h<T> fromPublisher(k.a.b<? extends T> bVar) {
        if (bVar instanceof h) {
            return h.c.r0.a.l((h) bVar);
        }
        h.c.n0.b.b.e(bVar, "source is null");
        return h.c.r0.a.l(new k1(bVar));
    }

    public static <T> h<T> generate(h.c.m0.f<g<T>> fVar) {
        h.c.n0.b.b.e(fVar, "generator is null");
        return generate(h.c.n0.b.a.t(), r1.j(fVar), h.c.n0.b.a.h());
    }

    public static h<Long> interval(long j2, long j3, TimeUnit timeUnit) {
        return interval(j2, j3, timeUnit, h.c.u0.a.a());
    }

    public static h<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return intervalRange(j2, j3, j4, j5, timeUnit, h.c.u0.a.a());
    }

    public static <T> h<T> just(T t) {
        h.c.n0.b.b.e(t, "item is null");
        return h.c.r0.a.l(new v1(t));
    }

    public static <T> h<T> merge(Iterable<? extends k.a.b<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), false, i2, i3);
    }

    public static <T> h<T> mergeArray(int i2, int i3, k.a.b<? extends T>... bVarArr) {
        return fromArray(bVarArr).flatMap(h.c.n0.b.a.j(), false, i2, i3);
    }

    public static <T> h<T> mergeArrayDelayError(int i2, int i3, k.a.b<? extends T>... bVarArr) {
        return fromArray(bVarArr).flatMap(h.c.n0.b.a.j(), true, i2, i3);
    }

    public static <T> h<T> mergeDelayError(Iterable<? extends k.a.b<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), true);
    }

    public static <T> h<T> never() {
        return h.c.r0.a.l(h2.a);
    }

    public static h<Integer> range(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        } else if (i3 == 0) {
            return empty();
        } else {
            if (i3 == 1) {
                return just(Integer.valueOf(i2));
            }
            if (i2 + (i3 - 1) <= 2147483647L) {
                return h.c.r0.a.l(new s2(i2, i3));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static h<Long> rangeLong(long j2, long j3) {
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
            return h.c.r0.a.l(new t2(j2, j3));
        }
    }

    public static <T> b0<Boolean> sequenceEqual(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2) {
        return sequenceEqual(bVar, bVar2, h.c.n0.b.b.d(), bufferSize());
    }

    public static <T> h<T> switchOnNext(k.a.b<? extends k.a.b<? extends T>> bVar, int i2) {
        return fromPublisher(bVar).switchMap(h.c.n0.b.a.j(), i2);
    }

    public static <T> h<T> switchOnNextDelayError(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return switchOnNextDelayError(bVar, bufferSize());
    }

    private h<T> timeout0(long j2, TimeUnit timeUnit, k.a.b<? extends T> bVar, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "timeUnit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new l4(this, j2, timeUnit, a0Var, bVar));
    }

    public static h<Long> timer(long j2, TimeUnit timeUnit) {
        return timer(j2, timeUnit, h.c.u0.a.a());
    }

    public static <T> h<T> unsafeCreate(k.a.b<T> bVar) {
        h.c.n0.b.b.e(bVar, "onSubscribe is null");
        if (!(bVar instanceof h)) {
            return h.c.r0.a.l(new k1(bVar));
        }
        throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
    }

    public static <T, D> h<T> using(Callable<? extends D> callable, h.c.m0.n<? super D, ? extends k.a.b<? extends T>> nVar, h.c.m0.f<? super D> fVar) {
        return using(callable, nVar, fVar, true);
    }

    public static <T, R> h<R> zip(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(iterable, "sources is null");
        return h.c.r0.a.l(new y4(null, iterable, nVar, bufferSize(), false));
    }

    public static <T, R> h<R> zipArray(h.c.m0.n<? super Object[], ? extends R> nVar, boolean z, int i2, k.a.b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return empty();
        }
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new y4(bVarArr, null, nVar, i2, z));
    }

    public static <T, R> h<R> zipIterable(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new y4(null, iterable, nVar, i2, z));
    }

    public final b0<Boolean> all(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.o(new h.c.n0.e.b.g(this, pVar));
    }

    public final h<T> ambWith(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return ambArray(this, bVar);
    }

    public final b0<Boolean> any(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.o(new h.c.n0.e.b.j(this, pVar));
    }

    public final <R> R as(i<T, ? extends R> iVar) {
        return (R) ((i) h.c.n0.b.b.e(iVar, "converter is null")).apply(this);
    }

    public final T blockingFirst() {
        h.c.n0.h.d dVar = new h.c.n0.h.d();
        subscribe((m) dVar);
        T a = dVar.a();
        if (a != null) {
            return a;
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
        h.c.n0.h.e eVar = new h.c.n0.h.e();
        subscribe((m) eVar);
        T a = eVar.a();
        if (a != null) {
            return a;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new h.c.n0.e.b.c(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new h.c.n0.e.b.d(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new h.c.n0.e.b.e(this);
    }

    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    public final void blockingSubscribe() {
        h.c.n0.e.b.k.a(this);
    }

    public final h<List<T>> buffer(int i2) {
        return buffer(i2, i2);
    }

    public final h<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final h<T> cacheWithInitialCapacity(int i2) {
        h.c.n0.b.b.f(i2, "initialCapacity");
        return h.c.r0.a.l(new h.c.n0.e.b.q(this, i2));
    }

    public final <U> h<U> cast(Class<U> cls) {
        h.c.n0.b.b.e(cls, "clazz is null");
        return (h<U>) map(h.c.n0.b.a.e(cls));
    }

    public final <U> b0<U> collect(Callable<? extends U> callable, h.c.m0.b<? super U, ? super T> bVar) {
        h.c.n0.b.b.e(callable, "initialItemSupplier is null");
        h.c.n0.b.b.e(bVar, "collector is null");
        return h.c.r0.a.o(new h.c.n0.e.b.s(this, callable, bVar));
    }

    public final <U> b0<U> collectInto(U u, h.c.m0.b<? super U, ? super T> bVar) {
        h.c.n0.b.b.e(u, "initialItem is null");
        return collect(h.c.n0.b.a.l(u), bVar);
    }

    public final <R> h<R> compose(n<? super T, ? extends R> nVar) {
        return fromPublisher(((n) h.c.n0.b.b.e(nVar, "composer is null")).apply(this));
    }

    public final <R> h<R> concatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        return concatMap(nVar, 2);
    }

    public final c concatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        return concatMapCompletable(nVar, 2);
    }

    public final c concatMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar) {
        return concatMapCompletableDelayError(nVar, true, 2);
    }

    public final <R> h<R> concatMapDelayError(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        return concatMapDelayError(nVar, 2, true);
    }

    public final <R> h<R> concatMapEager(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        return concatMapEager(nVar, bufferSize(), bufferSize());
    }

    public final <R> h<R> concatMapEagerDelayError(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, boolean z) {
        return concatMapEagerDelayError(nVar, bufferSize(), bufferSize(), z);
    }

    public final <U> h<U> concatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return concatMapIterable(nVar, 2);
    }

    public final <R> h<R> concatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        return concatMapMaybe(nVar, 2);
    }

    public final <R> h<R> concatMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        return concatMapMaybeDelayError(nVar, true, 2);
    }

    public final <R> h<R> concatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        return concatMapSingle(nVar, 2);
    }

    public final <R> h<R> concatMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        return concatMapSingleDelayError(nVar, true, 2);
    }

    public final h<T> concatWith(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return concat(this, bVar);
    }

    public final b0<Boolean> contains(Object obj) {
        h.c.n0.b.b.e(obj, "item is null");
        return any(h.c.n0.b.a.i(obj));
    }

    public final b0<Long> count() {
        return h.c.r0.a.o(new h.c.n0.e.b.d0(this));
    }

    public final <U> h<T> debounce(h.c.m0.n<? super T, ? extends k.a.b<U>> nVar) {
        h.c.n0.b.b.e(nVar, "debounceIndicator is null");
        return h.c.r0.a.l(new h.c.n0.e.b.f0(this, nVar));
    }

    public final h<T> defaultIfEmpty(T t) {
        h.c.n0.b.b.e(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> h<T> delay(h.c.m0.n<? super T, ? extends k.a.b<U>> nVar) {
        h.c.n0.b.b.e(nVar, "itemDelayIndicator is null");
        return (h<T>) flatMap(r1.c(nVar));
    }

    public final <U> h<T> delaySubscription(k.a.b<U> bVar) {
        h.c.n0.b.b.e(bVar, "subscriptionIndicator is null");
        return h.c.r0.a.l(new j0(this, bVar));
    }

    @Deprecated
    public final <T2> h<T2> dematerialize() {
        return h.c.r0.a.l(new k0(this, h.c.n0.b.a.j()));
    }

    public final h<T> distinct() {
        return distinct(h.c.n0.b.a.j(), h.c.n0.b.a.g());
    }

    public final h<T> distinctUntilChanged() {
        return distinctUntilChanged(h.c.n0.b.a.j());
    }

    public final h<T> doAfterNext(h.c.m0.f<? super T> fVar) {
        h.c.n0.b.b.e(fVar, "onAfterNext is null");
        return h.c.r0.a.l(new o0(this, fVar));
    }

    public final h<T> doAfterTerminate(h.c.m0.a aVar) {
        return doOnEach(h.c.n0.b.a.h(), h.c.n0.b.a.h(), h.c.n0.b.a.f14096c, aVar);
    }

    public final h<T> doFinally(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onFinally is null");
        return h.c.r0.a.l(new p0(this, aVar));
    }

    public final h<T> doOnCancel(h.c.m0.a aVar) {
        return doOnLifecycle(h.c.n0.b.a.h(), h.c.n0.b.a.f14100g, aVar);
    }

    public final h<T> doOnComplete(h.c.m0.a aVar) {
        return doOnEach(h.c.n0.b.a.h(), h.c.n0.b.a.h(), aVar, h.c.n0.b.a.f14096c);
    }

    public final h<T> doOnError(h.c.m0.f<? super Throwable> fVar) {
        h.c.m0.f<? super T> h2 = h.c.n0.b.a.h();
        h.c.m0.a aVar = h.c.n0.b.a.f14096c;
        return doOnEach(h2, fVar, aVar, aVar);
    }

    public final h<T> doOnLifecycle(h.c.m0.f<? super k.a.d> fVar, h.c.m0.o oVar, h.c.m0.a aVar) {
        h.c.n0.b.b.e(fVar, "onSubscribe is null");
        h.c.n0.b.b.e(oVar, "onRequest is null");
        h.c.n0.b.b.e(aVar, "onCancel is null");
        return h.c.r0.a.l(new r0(this, fVar, oVar, aVar));
    }

    public final h<T> doOnNext(h.c.m0.f<? super T> fVar) {
        h.c.m0.f<? super Throwable> h2 = h.c.n0.b.a.h();
        h.c.m0.a aVar = h.c.n0.b.a.f14096c;
        return doOnEach(fVar, h2, aVar, aVar);
    }

    public final h<T> doOnRequest(h.c.m0.o oVar) {
        return doOnLifecycle(h.c.n0.b.a.h(), oVar, h.c.n0.b.a.f14096c);
    }

    public final h<T> doOnSubscribe(h.c.m0.f<? super k.a.d> fVar) {
        return doOnLifecycle(fVar, h.c.n0.b.a.f14100g, h.c.n0.b.a.f14096c);
    }

    public final h<T> doOnTerminate(h.c.m0.a aVar) {
        return doOnEach(h.c.n0.b.a.h(), h.c.n0.b.a.a(aVar), aVar, h.c.n0.b.a.f14096c);
    }

    public final o<T> elementAt(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.m(new t0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    public final b0<T> elementAtOrError(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.o(new u0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    public final h<T> filter(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.l(new x0(this, pVar));
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

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        return flatMap((h.c.m0.n) nVar, false, bufferSize(), bufferSize());
    }

    public final c flatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        return flatMapCompletable(nVar, false, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final <U> h<U> flatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return flatMapIterable(nVar, bufferSize());
    }

    public final <R> h<R> flatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        return flatMapMaybe(nVar, false, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final <R> h<R> flatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        return flatMapSingle(nVar, false, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final h.c.k0.b forEach(h.c.m0.f<? super T> fVar) {
        return subscribe(fVar);
    }

    public final h.c.k0.b forEachWhile(h.c.m0.p<? super T> pVar) {
        return forEachWhile(pVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c);
    }

    public final <K> h<h.c.l0.b<K, T>> groupBy(h.c.m0.n<? super T, ? extends K> nVar) {
        return (h<h.c.l0.b<K, T>>) groupBy(nVar, h.c.n0.b.a.j(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> h<R> groupJoin(k.a.b<? extends TRight> bVar, h.c.m0.n<? super T, ? extends k.a.b<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> nVar2, h.c.m0.c<? super T, ? super h<TRight>, ? extends R> cVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        h.c.n0.b.b.e(nVar, "leftEnd is null");
        h.c.n0.b.b.e(nVar2, "rightEnd is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return h.c.r0.a.l(new n1(this, bVar, nVar, nVar2, cVar));
    }

    public final h<T> hide() {
        return h.c.r0.a.l(new o1(this));
    }

    public final c ignoreElements() {
        return h.c.r0.a.k(new q1(this));
    }

    public final b0<Boolean> isEmpty() {
        return all(h.c.n0.b.a.b());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> h<R> join(k.a.b<? extends TRight> bVar, h.c.m0.n<? super T, ? extends k.a.b<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> nVar2, h.c.m0.c<? super T, ? super TRight, ? extends R> cVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        h.c.n0.b.b.e(nVar, "leftEnd is null");
        h.c.n0.b.b.e(nVar2, "rightEnd is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return h.c.r0.a.l(new u1(this, bVar, nVar, nVar2, cVar));
    }

    public final b0<T> last(T t) {
        h.c.n0.b.b.e(t, "defaultItem");
        return h.c.r0.a.o(new x1(this, t));
    }

    public final o<T> lastElement() {
        return h.c.r0.a.m(new w1(this));
    }

    public final b0<T> lastOrError() {
        return h.c.r0.a.o(new x1(this, null));
    }

    public final <R> h<R> lift(l<? extends R, ? super T> lVar) {
        h.c.n0.b.b.e(lVar, "lifter is null");
        return h.c.r0.a.l(new y1(this, lVar));
    }

    public final h<T> limit(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.l(new z1(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    public final <R> h<R> map(h.c.m0.n<? super T, ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new a2(this, nVar));
    }

    public final h<r<T>> materialize() {
        return h.c.r0.a.l(new d2(this));
    }

    public final h<T> mergeWith(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return merge(this, bVar);
    }

    public final h<T> observeOn(a0 a0Var) {
        return observeOn(a0Var, false, bufferSize());
    }

    public final <U> h<U> ofType(Class<U> cls) {
        h.c.n0.b.b.e(cls, "clazz is null");
        return filter(h.c.n0.b.a.k(cls)).cast(cls);
    }

    public final h<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    public final h<T> onBackpressureDrop() {
        return h.c.r0.a.l(new l2(this));
    }

    public final h<T> onBackpressureLatest() {
        return h.c.r0.a.l(new n2(this));
    }

    public final h<T> onErrorResumeNext(h.c.m0.n<? super Throwable, ? extends k.a.b<? extends T>> nVar) {
        h.c.n0.b.b.e(nVar, "resumeFunction is null");
        return h.c.r0.a.l(new o2(this, nVar, false));
    }

    public final h<T> onErrorReturn(h.c.m0.n<? super Throwable, ? extends T> nVar) {
        h.c.n0.b.b.e(nVar, "valueSupplier is null");
        return h.c.r0.a.l(new p2(this, nVar));
    }

    public final h<T> onErrorReturnItem(T t) {
        h.c.n0.b.b.e(t, "item is null");
        return onErrorReturn(h.c.n0.b.a.m(t));
    }

    public final h<T> onExceptionResumeNext(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "next is null");
        return h.c.r0.a.l(new o2(this, h.c.n0.b.a.m(bVar), true));
    }

    public final h<T> onTerminateDetach() {
        return h.c.r0.a.l(new l0(this));
    }

    public final h.c.q0.a<T> parallel() {
        return h.c.q0.a.a(this);
    }

    public final h.c.l0.a<T> publish() {
        return publish(bufferSize());
    }

    public final h<T> rebatchRequests(int i2) {
        return observeOn(h.c.n0.g.e.f16653b, true, i2);
    }

    public final o<T> reduce(h.c.m0.c<T, T, T> cVar) {
        h.c.n0.b.b.e(cVar, "reducer is null");
        return h.c.r0.a.m(new v2(this, cVar));
    }

    public final <R> b0<R> reduceWith(Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(callable, "seedSupplier is null");
        h.c.n0.b.b.e(cVar, "reducer is null");
        return h.c.r0.a.o(new x2(this, callable, cVar));
    }

    public final h<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final h<T> repeatUntil(h.c.m0.e eVar) {
        h.c.n0.b.b.e(eVar, "stop is null");
        return h.c.r0.a.l(new a3(this, eVar));
    }

    public final h<T> repeatWhen(h.c.m0.n<? super h<Object>, ? extends k.a.b<?>> nVar) {
        h.c.n0.b.b.e(nVar, "handler is null");
        return h.c.r0.a.l(new b3(this, nVar));
    }

    public final h.c.l0.a<T> replay() {
        return c3.i(this);
    }

    public final h<T> retry() {
        return retry(Long.MAX_VALUE, h.c.n0.b.a.c());
    }

    public final h<T> retryUntil(h.c.m0.e eVar) {
        h.c.n0.b.b.e(eVar, "stop is null");
        return retry(Long.MAX_VALUE, h.c.n0.b.a.u(eVar));
    }

    public final h<T> retryWhen(h.c.m0.n<? super h<Throwable>, ? extends k.a.b<?>> nVar) {
        h.c.n0.b.b.e(nVar, "handler is null");
        return h.c.r0.a.l(new f3(this, nVar));
    }

    public final void safeSubscribe(k.a.c<? super T> cVar) {
        h.c.n0.b.b.e(cVar, "s is null");
        if (cVar instanceof h.c.w0.c) {
            subscribe((m) ((h.c.w0.c) cVar));
        } else {
            subscribe((m) new h.c.w0.c(cVar));
        }
    }

    public final h<T> sample(long j2, TimeUnit timeUnit) {
        return sample(j2, timeUnit, h.c.u0.a.a());
    }

    public final h<T> scan(h.c.m0.c<T, T, T> cVar) {
        h.c.n0.b.b.e(cVar, "accumulator is null");
        return h.c.r0.a.l(new j3(this, cVar));
    }

    public final <R> h<R> scanWith(Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(callable, "seedSupplier is null");
        h.c.n0.b.b.e(cVar, "accumulator is null");
        return h.c.r0.a.l(new k3(this, callable, cVar));
    }

    public final h<T> serialize() {
        return h.c.r0.a.l(new n3(this));
    }

    public final h<T> share() {
        return publish().c();
    }

    public final b0<T> single(T t) {
        h.c.n0.b.b.e(t, "defaultItem is null");
        return h.c.r0.a.o(new q3(this, t));
    }

    public final o<T> singleElement() {
        return h.c.r0.a.m(new p3(this));
    }

    public final b0<T> singleOrError() {
        return h.c.r0.a.o(new q3(this, null));
    }

    public final h<T> skip(long j2) {
        if (j2 <= 0) {
            return h.c.r0.a.l(this);
        }
        return h.c.r0.a.l(new r3(this, j2));
    }

    public final h<T> skipLast(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return h.c.r0.a.l(this);
            }
            return h.c.r0.a.l(new s3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    public final <U> h<T> skipUntil(k.a.b<U> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return h.c.r0.a.l(new u3(this, bVar));
    }

    public final h<T> skipWhile(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.l(new v3(this, pVar));
    }

    public final h<T> sorted() {
        return toList().toFlowable().map(h.c.n0.b.a.n(h.c.n0.b.a.o())).flatMapIterable(h.c.n0.b.a.j());
    }

    public final h<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final h<T> startWithArray(T... tArr) {
        h fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return h.c.r0.a.l(this);
        }
        return concatArray(fromArray, this);
    }

    public final h.c.k0.b subscribe() {
        return subscribe(h.c.n0.b.a.h(), h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c, r1.i.INSTANCE);
    }

    protected abstract void subscribeActual(k.a.c<? super T> cVar);

    public final h<T> subscribeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return subscribeOn(a0Var, !(this instanceof h.c.n0.e.b.e0));
    }

    public final <E extends k.a.c<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final h<T> switchIfEmpty(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return h.c.r0.a.l(new x3(this, bVar));
    }

    public final <R> h<R> switchMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        return switchMap(nVar, bufferSize());
    }

    <R> h<R> switchMap0(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return i3.a(call, nVar);
        }
        return h.c.r0.a.l(new y3(this, nVar, i2, z));
    }

    public final c switchMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.k(new h.c.n0.e.d.d(this, nVar, false));
    }

    public final c switchMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.k(new h.c.n0.e.d.d(this, nVar, true));
    }

    public final <R> h<R> switchMapDelayError(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        return switchMapDelayError(nVar, bufferSize());
    }

    public final <R> h<R> switchMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new h.c.n0.e.d.e(this, nVar, false));
    }

    public final <R> h<R> switchMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new h.c.n0.e.d.e(this, nVar, true));
    }

    public final <R> h<R> switchMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new h.c.n0.e.d.f(this, nVar, false));
    }

    public final <R> h<R> switchMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new h.c.n0.e.d.f(this, nVar, true));
    }

    public final h<T> take(long j2) {
        if (j2 >= 0) {
            return h.c.r0.a.l(new z3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    public final h<T> takeLast(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return h.c.r0.a.l(new p1(this));
        } else {
            if (i2 == 1) {
                return h.c.r0.a.l(new b4(this));
            }
            return h.c.r0.a.l(new a4(this, i2));
        }
    }

    public final h<T> takeUntil(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "stopPredicate is null");
        return h.c.r0.a.l(new f4(this, pVar));
    }

    public final h<T> takeWhile(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.l(new g4(this, pVar));
    }

    public final h.c.w0.e<T> test() {
        h.c.w0.e<T> eVar = new h.c.w0.e<>();
        subscribe((m) eVar);
        return eVar;
    }

    public final h<T> throttleFirst(long j2, TimeUnit timeUnit) {
        return throttleFirst(j2, timeUnit, h.c.u0.a.a());
    }

    public final h<T> throttleLast(long j2, TimeUnit timeUnit) {
        return sample(j2, timeUnit);
    }

    public final h<T> throttleLatest(long j2, TimeUnit timeUnit) {
        return throttleLatest(j2, timeUnit, h.c.u0.a.a(), false);
    }

    public final h<T> throttleWithTimeout(long j2, TimeUnit timeUnit) {
        return debounce(j2, timeUnit);
    }

    public final h<h.c.u0.b<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, h.c.u0.a.a());
    }

    public final <V> h<T> timeout(h.c.m0.n<? super T, ? extends k.a.b<V>> nVar) {
        return timeout0(null, nVar, null);
    }

    public final h<h.c.u0.b<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, h.c.u0.a.a());
    }

    public final <R> R to(h.c.m0.n<? super h<T>, R> nVar) {
        try {
            return (R) ((h.c.m0.n) h.c.n0.b.b.e(nVar, "converter is null")).apply(this);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw h.c.n0.j.j.e(th);
        }
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new h.c.n0.h.i());
    }

    public final b0<List<T>> toList() {
        return h.c.r0.a.o(new o4(this));
    }

    public final <K> b0<Map<K, T>> toMap(h.c.m0.n<? super T, ? extends K> nVar) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        return (b0<Map<K, T>>) collect(h.c.n0.j.l.h(), h.c.n0.b.a.E(nVar));
    }

    public final <K> b0<Map<K, Collection<T>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar) {
        return (b0<Map<K, Collection<T>>>) toMultimap(nVar, h.c.n0.b.a.j(), h.c.n0.j.l.h(), h.c.n0.j.b.q());
    }

    public final s<T> toObservable() {
        return h.c.r0.a.n(new h.c.n0.e.e.f1(this));
    }

    public final b0<List<T>> toSortedList() {
        return toSortedList(h.c.n0.b.a.o());
    }

    public final h<T> unsubscribeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new p4(this, a0Var));
    }

    public final h<h<T>> window(long j2) {
        return window(j2, j2, bufferSize());
    }

    public final <U, R> h<R> withLatestFrom(k.a.b<? extends U> bVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        h.c.n0.b.b.e(cVar, "combiner is null");
        return h.c.r0.a.l(new w4(this, cVar, bVar));
    }

    public final <U, R> h<R> zipWith(Iterable<U> iterable, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        h.c.n0.b.b.e(iterable, "other is null");
        h.c.n0.b.b.e(cVar, "zipper is null");
        return h.c.r0.a.l(new z4(this, iterable, cVar));
    }

    public static <T, R> h<R> combineLatest(h.c.m0.n<? super Object[], ? extends R> nVar, k.a.b<? extends T>... bVarArr) {
        return combineLatest(bVarArr, nVar, bufferSize());
    }

    public static <T, R> h<R> combineLatestDelayError(h.c.m0.n<? super Object[], ? extends R> nVar, k.a.b<? extends T>... bVarArr) {
        return combineLatestDelayError(bVarArr, nVar, bufferSize());
    }

    public static <T> h<T> concatArrayEager(int i2, int i3, k.a.b<? extends T>... bVarArr) {
        h.c.n0.b.b.e(bVarArr, "sources is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.b.w(new f1(bVarArr), h.c.n0.b.a.j(), i2, i3, h.c.n0.j.i.IMMEDIATE));
    }

    public static <T> h<T> concatArrayEagerDelayError(int i2, int i3, k.a.b<? extends T>... bVarArr) {
        return fromArray(bVarArr).concatMapEagerDelayError(h.c.n0.b.a.j(), i2, i3, true);
    }

    public static <T> h<T> concatEager(k.a.b<? extends k.a.b<? extends T>> bVar, int i2, int i3) {
        h.c.n0.b.b.e(bVar, "sources is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.b.x(bVar, h.c.n0.b.a.j(), i2, i3, h.c.n0.j.i.IMMEDIATE));
    }

    public static h<Long> interval(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new s1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, a0Var));
    }

    public static h<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, a0 a0Var) {
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
            return h.c.r0.a.l(new t1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, a0Var));
        }
    }

    public static <T> h<T> merge(Iterable<? extends k.a.b<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j());
    }

    public static <T> h<T> mergeArray(k.a.b<? extends T>... bVarArr) {
        return fromArray(bVarArr).flatMap(h.c.n0.b.a.j(), bVarArr.length);
    }

    public static <T> h<T> mergeArrayDelayError(k.a.b<? extends T>... bVarArr) {
        return fromArray(bVarArr).flatMap(h.c.n0.b.a.j(), true, bVarArr.length);
    }

    public static <T> h<T> mergeDelayError(Iterable<? extends k.a.b<? extends T>> iterable, int i2, int i3) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), true, i2, i3);
    }

    public static <T> b0<Boolean> sequenceEqual(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, h.c.m0.d<? super T, ? super T> dVar) {
        return sequenceEqual(bVar, bVar2, dVar, bufferSize());
    }

    public static <T> h<T> switchOnNext(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return fromPublisher(bVar).switchMap(h.c.n0.b.a.j());
    }

    public static <T> h<T> switchOnNextDelayError(k.a.b<? extends k.a.b<? extends T>> bVar, int i2) {
        return fromPublisher(bVar).switchMapDelayError(h.c.n0.b.a.j(), i2);
    }

    public static h<Long> timer(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new m4(Math.max(0L, j2), timeUnit, a0Var));
    }

    public static <T, D> h<T> using(Callable<? extends D> callable, h.c.m0.n<? super D, ? extends k.a.b<? extends T>> nVar, h.c.m0.f<? super D> fVar, boolean z) {
        h.c.n0.b.b.e(callable, "resourceSupplier is null");
        h.c.n0.b.b.e(nVar, "sourceSupplier is null");
        h.c.n0.b.b.e(fVar, "resourceDisposer is null");
        return h.c.r0.a.l(new q4(callable, nVar, fVar, z));
    }

    public final Iterable<T> blockingIterable(int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        return new h.c.n0.e.b.b(this, i2);
    }

    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar) {
        h.c.n0.e.b.k.b(this, fVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c);
    }

    public final h<List<T>> buffer(int i2, int i3) {
        return (h<List<T>>) buffer(i2, i3, h.c.n0.j.b.n());
    }

    public final <R> h<R> concatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return i3.a(call, nVar);
        }
        return h.c.r0.a.l(new h.c.n0.e.b.v(this, nVar, i2, h.c.n0.j.i.IMMEDIATE));
    }

    public final c concatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.k(new h.c.n0.e.d.a(this, nVar, h.c.n0.j.i.IMMEDIATE, i2));
    }

    public final c concatMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar, boolean z) {
        return concatMapCompletableDelayError(nVar, z, 2);
    }

    public final <R> h<R> concatMapDelayError(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return i3.a(call, nVar);
        }
        return h.c.r0.a.l(new h.c.n0.e.b.v(this, nVar, i2, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY));
    }

    public final <R> h<R> concatMapEager(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, int i3) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.b.w(this, nVar, i2, i3, h.c.n0.j.i.IMMEDIATE));
    }

    public final <R> h<R> concatMapEagerDelayError(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, int i3, boolean z) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.b.w(this, nVar, i2, i3, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY));
    }

    public final <U> h<U> concatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new e1(this, nVar, i2));
    }

    public final <R> h<R> concatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.d.b(this, nVar, h.c.n0.j.i.IMMEDIATE, i2));
    }

    public final <R> h<R> concatMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
        return concatMapMaybeDelayError(nVar, z, 2);
    }

    public final <R> h<R> concatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.d.c(this, nVar, h.c.n0.j.i.IMMEDIATE, i2));
    }

    public final <R> h<R> concatMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
        return concatMapSingleDelayError(nVar, z, 2);
    }

    public final <R> h<R> dematerialize(h.c.m0.n<? super T, r<R>> nVar) {
        h.c.n0.b.b.e(nVar, "selector is null");
        return h.c.r0.a.l(new k0(this, nVar));
    }

    public final <K> h<T> distinct(h.c.m0.n<? super T, K> nVar) {
        return distinct(nVar, h.c.n0.b.a.g());
    }

    public final <K> h<T> distinctUntilChanged(h.c.m0.n<? super T, K> nVar) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        return h.c.r0.a.l(new n0(this, nVar, h.c.n0.b.b.d()));
    }

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, boolean z) {
        return flatMap(nVar, z, bufferSize(), bufferSize());
    }

    public final c flatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        return h.c.r0.a.k(new a1(this, nVar, z, i2));
    }

    public final <U> h<U> flatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new e1(this, nVar, i2));
    }

    public final <R> h<R> flatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        return h.c.r0.a.l(new b1(this, nVar, z, i2));
    }

    public final <R> h<R> flatMapSingle(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        return h.c.r0.a.l(new d1(this, nVar, z, i2));
    }

    public final h.c.k0.b forEachWhile(h.c.m0.p<? super T> pVar, h.c.m0.f<? super Throwable> fVar) {
        return forEachWhile(pVar, fVar, h.c.n0.b.a.f14096c);
    }

    public final <K> h<h.c.l0.b<K, T>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, boolean z) {
        return (h<h.c.l0.b<K, T>>) groupBy(nVar, h.c.n0.b.a.j(), z, bufferSize());
    }

    public final h<T> observeOn(a0 a0Var, boolean z) {
        return observeOn(a0Var, z, bufferSize());
    }

    public final h<T> onBackpressureBuffer(boolean z) {
        return onBackpressureBuffer(bufferSize(), z, true);
    }

    public final h<T> onBackpressureDrop(h.c.m0.f<? super T> fVar) {
        h.c.n0.b.b.e(fVar, "onDrop is null");
        return h.c.r0.a.l(new l2(this, fVar));
    }

    public final h.c.q0.a<T> parallel(int i2) {
        h.c.n0.b.b.f(i2, "parallelism");
        return h.c.q0.a.b(this, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> h<R> publish(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar) {
        return publish(nVar, bufferSize());
    }

    public final h<T> repeat(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (i2 == 0) {
                return empty();
            }
            return h.c.r0.a.l(new z2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar) {
        h.c.n0.b.b.e(nVar, "selector is null");
        return c3.j(r1.d(this), nVar);
    }

    public final h<T> retry(h.c.m0.d<? super Integer, ? super Throwable> dVar) {
        h.c.n0.b.b.e(dVar, "predicate is null");
        return h.c.r0.a.l(new d3(this, dVar));
    }

    public final h<T> sample(long j2, TimeUnit timeUnit, boolean z) {
        return sample(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final h<T> sorted(Comparator<? super T> comparator) {
        h.c.n0.b.b.e(comparator, "sortFunction");
        return toList().toFlowable().map(h.c.n0.b.a.n(comparator)).flatMapIterable(h.c.n0.b.a.j());
    }

    public final h<T> startWith(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return concatArray(bVar, this);
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar) {
        return subscribe(fVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c, r1.i.INSTANCE);
    }

    public final <R> h<R> switchMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2) {
        return switchMap0(nVar, i2, false);
    }

    public final <R> h<R> switchMapDelayError(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2) {
        return switchMap0(nVar, i2, true);
    }

    public final h<T> throttleFirst(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new h4(this, j2, timeUnit, a0Var));
    }

    public final h<T> throttleLast(long j2, TimeUnit timeUnit, a0 a0Var) {
        return sample(j2, timeUnit, a0Var);
    }

    public final h<T> throttleLatest(long j2, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final h<T> throttleWithTimeout(long j2, TimeUnit timeUnit, a0 a0Var) {
        return debounce(j2, timeUnit, a0Var);
    }

    public final h<h.c.u0.b<T>> timeInterval(a0 a0Var) {
        return timeInterval(TimeUnit.MILLISECONDS, a0Var);
    }

    public final <V> h<T> timeout(h.c.m0.n<? super T, ? extends k.a.b<V>> nVar, h<? extends T> hVar) {
        h.c.n0.b.b.e(hVar, "other is null");
        return timeout0(null, nVar, hVar);
    }

    public final h<h.c.u0.b<T>> timestamp(a0 a0Var) {
        return timestamp(TimeUnit.MILLISECONDS, a0Var);
    }

    public final b0<List<T>> toList(int i2) {
        h.c.n0.b.b.f(i2, "capacityHint");
        return h.c.r0.a.o(new o4(this, h.c.n0.b.a.f(i2)));
    }

    public final b0<List<T>> toSortedList(Comparator<? super T> comparator) {
        h.c.n0.b.b.e(comparator, "comparator is null");
        return (b0<List<T>>) toList().map(h.c.n0.b.a.n(comparator));
    }

    public final h<h<T>> window(long j2, long j3) {
        return window(j2, j3, bufferSize());
    }

    public static <T, R> h<R> combineLatest(k.a.b<? extends T>[] bVarArr, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(bVarArr, "sources is null");
        if (bVarArr.length == 0) {
            return empty();
        }
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new h.c.n0.e.b.t((k.a.b[]) bVarArr, (h.c.m0.n) nVar, i2, false));
    }

    public static <T, R> h<R> combineLatestDelayError(h.c.m0.n<? super Object[], ? extends R> nVar, int i2, k.a.b<? extends T>... bVarArr) {
        return combineLatestDelayError(bVarArr, nVar, i2);
    }

    public static <T> h<T> concat(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return concat(bVar, bufferSize());
    }

    public static <T> h<T> concatDelayError(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return concatDelayError(bVar, bufferSize(), true);
    }

    public static <T> h<T> error(Throwable th) {
        h.c.n0.b.b.e(th, "throwable is null");
        return error(h.c.n0.b.a.l(th));
    }

    public static <T> h<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        h.c.n0.b.b.e(future, "future is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        return h.c.r0.a.l(new h1(future, j2, timeUnit));
    }

    public static <T> h<T> just(T t, T t2) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        return fromArray(t, t2);
    }

    public static <T> h<T> merge(Iterable<? extends k.a.b<? extends T>> iterable, int i2) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), i2);
    }

    public static <T> h<T> mergeDelayError(Iterable<? extends k.a.b<? extends T>> iterable, int i2) {
        return fromIterable(iterable).flatMap(h.c.n0.b.a.j(), true, i2);
    }

    public static <T> b0<Boolean> sequenceEqual(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, h.c.m0.d<? super T, ? super T> dVar, int i2) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(dVar, "isEqual is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.o(new m3(bVar, bVar2, dVar, i2));
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, int i2) {
        h.c.n0.e.b.k.c(this, fVar, h.c.n0.b.a.f14099f, h.c.n0.b.a.f14096c, i2);
    }

    public final <U extends Collection<? super T>> h<U> buffer(int i2, int i3, Callable<U> callable) {
        h.c.n0.b.b.f(i2, "count");
        h.c.n0.b.b.f(i3, "skip");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.l(new h.c.n0.e.b.l(this, i2, i3, callable));
    }

    public final c concatMapCompletableDelayError(h.c.m0.n<? super T, ? extends f> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.k(new h.c.n0.e.d.a(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2));
    }

    public final <R> h<R> concatMapMaybeDelayError(h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.d.b(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2));
    }

    public final <R> h<R> concatMapSingleDelayError(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.d.c(this, nVar, z ? h.c.n0.j.i.END : h.c.n0.j.i.BOUNDARY, i2));
    }

    public final h<T> concatWith(h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return h.c.r0.a.l(new h.c.n0.e.b.b0(this, h0Var));
    }

    public final h<T> debounce(long j2, TimeUnit timeUnit) {
        return debounce(j2, timeUnit, h.c.u0.a.a());
    }

    public final h<T> delay(long j2, TimeUnit timeUnit) {
        return delay(j2, timeUnit, h.c.u0.a.a(), false);
    }

    public final h<T> delaySubscription(long j2, TimeUnit timeUnit) {
        return delaySubscription(j2, timeUnit, h.c.u0.a.a());
    }

    public final <K> h<T> distinct(h.c.m0.n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(callable, "collectionSupplier is null");
        return h.c.r0.a.l(new m0(this, nVar, callable));
    }

    public final b0<T> elementAt(long j2, T t) {
        if (j2 >= 0) {
            h.c.n0.b.b.e(t, "defaultItem is null");
            return h.c.r0.a.o(new u0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2) {
        return flatMap((h.c.m0.n) nVar, false, i2, bufferSize());
    }

    public final h.c.k0.b forEachWhile(h.c.m0.p<? super T> pVar, h.c.m0.f<? super Throwable> fVar, h.c.m0.a aVar) {
        h.c.n0.b.b.e(pVar, "onNext is null");
        h.c.n0.b.b.e(fVar, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.h.h hVar = new h.c.n0.h.h(pVar, fVar, aVar);
        subscribe((m) hVar);
        return hVar;
    }

    public final <K, V> h<h.c.l0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        return groupBy(nVar, nVar2, false, bufferSize());
    }

    public final h<T> mergeWith(h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return h.c.r0.a.l(new g2(this, h0Var));
    }

    public final h<T> observeOn(a0 a0Var, boolean z, int i2) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new i2(this, a0Var, z, i2));
    }

    public final h<T> onBackpressureBuffer(int i2) {
        return onBackpressureBuffer(i2, false, false);
    }

    public final h<T> onErrorResumeNext(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "next is null");
        return onErrorResumeNext(h.c.n0.b.a.m(bVar));
    }

    public final <R> h<R> publish(h.c.m0.n<? super h<T>, ? extends k.a.b<? extends R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new r2(this, nVar, i2, false));
    }

    public final <R> b0<R> reduce(R r, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(r, "seed is null");
        h.c.n0.b.b.e(cVar, "reducer is null");
        return h.c.r0.a.o(new w2(this, r, cVar));
    }

    public final h<T> sample(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new h3(this, j2, timeUnit, a0Var, false));
    }

    public final <R> h<R> scan(R r, h.c.m0.c<R, ? super T, R> cVar) {
        h.c.n0.b.b.e(r, "initialValue is null");
        return scanWith(h.c.n0.b.a.l(r), cVar);
    }

    public final h<T> skip(long j2, TimeUnit timeUnit) {
        return skipUntil(timer(j2, timeUnit));
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
        return subscribe(fVar, fVar2, h.c.n0.b.a.f14096c, r1.i.INSTANCE);
    }

    public final h<T> subscribeOn(a0 a0Var, boolean z) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new w3(this, a0Var, z));
    }

    public final h<T> take(long j2, TimeUnit timeUnit) {
        return takeUntil(timer(j2, timeUnit));
    }

    public final <U> h<T> takeUntil(k.a.b<U> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return h.c.r0.a.l(new e4(this, bVar));
    }

    public final h.c.w0.e<T> test(long j2) {
        h.c.w0.e<T> eVar = new h.c.w0.e<>(j2);
        subscribe((m) eVar);
        return eVar;
    }

    public final h<T> throttleLatest(long j2, TimeUnit timeUnit, a0 a0Var) {
        return throttleLatest(j2, timeUnit, a0Var, false);
    }

    public final h<h.c.u0.b<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, h.c.u0.a.a());
    }

    public final h<h.c.u0.b<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, h.c.u0.a.a());
    }

    public final <K, V> b0<Map<K, V>> toMap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        return (b0<Map<K, V>>) collect(h.c.n0.j.l.h(), h.c.n0.b.a.F(nVar, nVar2));
    }

    public final h<h<T>> window(long j2, long j3, int i2) {
        h.c.n0.b.b.g(j3, "skip");
        h.c.n0.b.b.g(j2, "count");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new r4(this, j2, j3, i2));
    }

    public static <T, R> h<R> combineLatestDelayError(k.a.b<? extends T>[] bVarArr, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(bVarArr, "sources is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        if (bVarArr.length == 0) {
            return empty();
        }
        return h.c.r0.a.l(new h.c.n0.e.b.t((k.a.b[]) bVarArr, (h.c.m0.n) nVar, i2, true));
    }

    public static <T> h<T> concat(k.a.b<? extends k.a.b<? extends T>> bVar, int i2) {
        return fromPublisher(bVar).concatMap(h.c.n0.b.a.j(), i2);
    }

    public static <T> h<T> concatDelayError(k.a.b<? extends k.a.b<? extends T>> bVar, int i2, boolean z) {
        return fromPublisher(bVar).concatMapDelayError(h.c.n0.b.a.j(), i2, z);
    }

    public static <T> h<T> merge(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return merge(bVar, bufferSize());
    }

    public static <T> h<T> mergeDelayError(k.a.b<? extends k.a.b<? extends T>> bVar) {
        return mergeDelayError(bVar, bufferSize());
    }

    private <U, V> h<T> timeout0(k.a.b<U> bVar, h.c.m0.n<? super T, ? extends k.a.b<V>> nVar, k.a.b<? extends T> bVar2) {
        h.c.n0.b.b.e(nVar, "itemTimeoutIndicator is null");
        return h.c.r0.a.l(new k4(this, bVar, nVar, bVar2));
    }

    public static <T, R> h<R> zip(k.a.b<? extends k.a.b<? extends T>> bVar, h.c.m0.n<? super Object[], ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        return fromPublisher(bVar).toList().flatMapPublisher(r1.n(nVar));
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
        h.c.n0.e.b.k.b(this, fVar, fVar2, h.c.n0.b.a.f14096c);
    }

    public final h<T> debounce(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new h.c.n0.e.b.g0(this, j2, timeUnit, a0Var));
    }

    public final h<T> delay(long j2, TimeUnit timeUnit, boolean z) {
        return delay(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final h<T> delaySubscription(long j2, TimeUnit timeUnit, a0 a0Var) {
        return delaySubscription(timer(j2, timeUnit, a0Var));
    }

    public final h<T> distinctUntilChanged(h.c.m0.d<? super T, ? super T> dVar) {
        h.c.n0.b.b.e(dVar, "comparer is null");
        return h.c.r0.a.l(new n0(this, h.c.n0.b.a.j(), dVar));
    }

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, boolean z, int i2) {
        return flatMap(nVar, z, i2, bufferSize());
    }

    public final <K, V> h<h.c.l0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, boolean z) {
        return groupBy(nVar, nVar2, z, bufferSize());
    }

    public final h<T> onBackpressureBuffer(int i2, boolean z) {
        return onBackpressureBuffer(i2, z, false);
    }

    public final h.c.q0.a<T> parallel(int i2, int i3) {
        h.c.n0.b.b.f(i2, "parallelism");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.q0.a.c(this, i2, i3);
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, int i2) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return c3.j(r1.e(this, i2), nVar);
    }

    public final h<T> retry(long j2) {
        return retry(j2, h.c.n0.b.a.c());
    }

    public final h<T> skip(long j2, TimeUnit timeUnit, a0 a0Var) {
        return skipUntil(timer(j2, timeUnit, a0Var));
    }

    public final h<T> skipLast(long j2, TimeUnit timeUnit) {
        return skipLast(j2, timeUnit, h.c.u0.a.a(), false, bufferSize());
    }

    public final h<T> startWith(T t) {
        h.c.n0.b.b.e(t, "value is null");
        return concatArray(just(t), this);
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
        return subscribe(fVar, fVar2, aVar, r1.i.INSTANCE);
    }

    public final h<T> take(long j2, TimeUnit timeUnit, a0 a0Var) {
        return takeUntil(timer(j2, timeUnit, a0Var));
    }

    public final h<T> throttleLatest(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new i4(this, j2, timeUnit, a0Var, z));
    }

    public final h<h.c.u0.b<T>> timeInterval(TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new j4(this, timeUnit, a0Var));
    }

    public final h<T> timeout(long j2, TimeUnit timeUnit) {
        return timeout0(j2, timeUnit, null, h.c.u0.a.a());
    }

    public final h<h.c.u0.b<T>> timestamp(TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return (h<h.c.u0.b<T>>) map(h.c.n0.b.a.v(timeUnit, a0Var));
    }

    public final <U extends Collection<? super T>> b0<U> toList(Callable<U> callable) {
        h.c.n0.b.b.e(callable, "collectionSupplier is null");
        return h.c.r0.a.o(new o4(this, callable));
    }

    public final b0<List<T>> toSortedList(Comparator<? super T> comparator, int i2) {
        h.c.n0.b.b.e(comparator, "comparator is null");
        return (b0<List<T>>) toList(i2).map(h.c.n0.b.a.n(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> h<R> withLatestFrom(k.a.b<T1> bVar, k.a.b<T2> bVar2, h.c.m0.g<? super T, ? super T1, ? super T2, R> gVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return withLatestFrom(new k.a.b[]{bVar, bVar2}, h.c.n0.b.a.x(gVar));
    }

    public final <U, R> h<R> zipWith(k.a.b<? extends U> bVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return zip(this, bVar, cVar);
    }

    public static <T> h<T> concat(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return concatArray(bVar, bVar2);
    }

    public static h<Long> interval(long j2, TimeUnit timeUnit) {
        return interval(j2, j2, timeUnit, h.c.u0.a.a());
    }

    public static <T> h<T> merge(k.a.b<? extends k.a.b<? extends T>> bVar, int i2) {
        return fromPublisher(bVar).flatMap(h.c.n0.b.a.j(), i2);
    }

    public static <T> h<T> mergeDelayError(k.a.b<? extends k.a.b<? extends T>> bVar, int i2) {
        return fromPublisher(bVar).flatMap(h.c.n0.b.a.j(), true, i2);
    }

    public final T blockingFirst(T t) {
        h.c.n0.h.d dVar = new h.c.n0.h.d();
        subscribe((m) dVar);
        T a = dVar.a();
        return a != null ? a : t;
    }

    public final T blockingLast(T t) {
        h.c.n0.h.e eVar = new h.c.n0.h.e();
        subscribe((m) eVar);
        T a = eVar.a();
        return a != null ? a : t;
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, int i2) {
        h.c.n0.e.b.k.c(this, fVar, fVar2, h.c.n0.b.a.f14096c, i2);
    }

    public final h<T> concatWith(q<? extends T> qVar) {
        h.c.n0.b.b.e(qVar, "other is null");
        return h.c.r0.a.l(new h.c.n0.e.b.a0(this, qVar));
    }

    public final h<T> delay(long j2, TimeUnit timeUnit, a0 a0Var) {
        return delay(j2, timeUnit, a0Var, false);
    }

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, boolean z, int i2, int i3) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "bufferSize");
        if (this instanceof h.c.n0.c.h) {
            Object call = ((h.c.n0.c.h) this).call();
            if (call == null) {
                return empty();
            }
            return i3.a(call, nVar);
        }
        return h.c.r0.a.l(new y0(this, nVar, z, i2, i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> h<V> flatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends V> cVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return (h<V>) flatMap(r1.a(nVar), cVar, false, bufferSize(), bufferSize());
    }

    public final <K, V> h<h.c.l0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, boolean z, int i2) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new m1(this, nVar, nVar2, i2, z, null));
    }

    public final h<T> mergeWith(q<? extends T> qVar) {
        h.c.n0.b.b.e(qVar, "other is null");
        return h.c.r0.a.l(new f2(this, qVar));
    }

    public final h<T> onBackpressureBuffer(int i2, boolean z, boolean z2) {
        h.c.n0.b.b.f(i2, "capacity");
        return h.c.r0.a.l(new j2(this, i2, z2, z, h.c.n0.b.a.f14096c));
    }

    public final h<T> retry(long j2, h.c.m0.p<? super Throwable> pVar) {
        if (j2 >= 0) {
            h.c.n0.b.b.e(pVar, "predicate is null");
            return h.c.r0.a.l(new e3(this, j2, pVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    public final h<T> skipLast(long j2, TimeUnit timeUnit, boolean z) {
        return skipLast(j2, timeUnit, h.c.u0.a.a(), z, bufferSize());
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.f<? super k.a.d> fVar3) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.b.b.e(fVar3, "onSubscribe is null");
        h.c.n0.h.l lVar = new h.c.n0.h.l(fVar, fVar2, aVar, fVar3);
        subscribe((m) lVar);
        return lVar;
    }

    public final h<T> takeLast(long j2, long j3, TimeUnit timeUnit) {
        return takeLast(j2, j3, timeUnit, h.c.u0.a.a(), false, bufferSize());
    }

    public final h.c.w0.e<T> test(long j2, boolean z) {
        h.c.w0.e<T> eVar = new h.c.w0.e<>(j2);
        if (z) {
            eVar.cancel();
        }
        subscribe((m) eVar);
        return eVar;
    }

    public final h<T> timeout(long j2, TimeUnit timeUnit, k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return timeout0(j2, timeUnit, bVar, h.c.u0.a.a());
    }

    public final <K, V> b0<Map<K, Collection<V>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2) {
        return toMultimap(nVar, nVar2, h.c.n0.j.l.h(), h.c.n0.j.b.q());
    }

    public static <T> h<T> concatEager(Iterable<? extends k.a.b<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> h<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return fromFuture(future, j2, timeUnit).subscribeOn(a0Var);
    }

    public static <T, S> h<T> generate(Callable<S> callable, h.c.m0.b<S, g<T>> bVar) {
        h.c.n0.b.b.e(bVar, "generator is null");
        return generate(callable, r1.i(bVar), h.c.n0.b.a.h());
    }

    public static h<Long> interval(long j2, TimeUnit timeUnit, a0 a0Var) {
        return interval(j2, j2, timeUnit, a0Var);
    }

    public static <T> h<T> just(T t, T t2, T t3) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    public static <T> h<T> merge(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return fromArray(bVar, bVar2).flatMap(h.c.n0.b.a.j(), false, 2);
    }

    public static <T> h<T> mergeDelayError(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return fromArray(bVar, bVar2).flatMap(h.c.n0.b.a.j(), true, 2);
    }

    public static <T1, T2, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), false, bufferSize(), bVar, bVar2);
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
        h.c.n0.e.b.k.b(this, fVar, fVar2, aVar);
    }

    public final h<T> delay(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new h.c.n0.e.b.i0(this, Math.max(0L, j2), timeUnit, a0Var, z));
    }

    public final h<T> doOnEach(h.c.m0.f<? super r<T>> fVar) {
        h.c.n0.b.b.e(fVar, "onNotification is null");
        return doOnEach(h.c.n0.b.a.s(fVar), h.c.n0.b.a.r(fVar), h.c.n0.b.a.q(fVar), h.c.n0.b.a.f14096c);
    }

    public final h.c.l0.a<T> publish(int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        return q2.d(this, i2);
    }

    public final h<T> sample(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.l(new h3(this, j2, timeUnit, a0Var, z));
    }

    public final h<T> skipLast(long j2, TimeUnit timeUnit, a0 a0Var) {
        return skipLast(j2, timeUnit, a0Var, false, bufferSize());
    }

    public final h<T> takeLast(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        return takeLast(j2, j3, timeUnit, a0Var, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> b0<Map<K, V>> toMap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, Callable<? extends Map<K, V>> callable) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        return (b0<Map<K, V>>) collect(callable, h.c.n0.b.a.F(nVar, nVar2));
    }

    public final b0<List<T>> toSortedList(int i2) {
        return toSortedList(h.c.n0.b.a.o(), i2);
    }

    public final <U, R> h<R> zipWith(k.a.b<? extends U> bVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return zip(this, bVar, cVar, z);
    }

    public static <T> h<T> concatEager(Iterable<? extends k.a.b<? extends T>> iterable, int i2, int i3) {
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.b.w(new i1(iterable), h.c.n0.b.a.j(), i2, i3, h.c.n0.j.i.IMMEDIATE));
    }

    public final void blockingSubscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, int i2) {
        h.c.n0.e.b.k.c(this, fVar, fVar2, aVar, i2);
    }

    public final <U extends Collection<? super T>> h<U> buffer(int i2, Callable<U> callable) {
        return buffer(i2, i2, callable);
    }

    public final h<T> concatWith(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return h.c.r0.a.l(new h.c.n0.e.b.z(this, fVar));
    }

    public final h<T> mergeWith(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return h.c.r0.a.l(new e2(this, fVar));
    }

    public final h<T> onBackpressureBuffer(int i2, boolean z, boolean z2, h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onOverflow is null");
        h.c.n0.b.b.f(i2, "capacity");
        return h.c.r0.a.l(new j2(this, i2, z2, z, aVar));
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, int i2, long j2, TimeUnit timeUnit) {
        return replay(nVar, i2, j2, timeUnit, h.c.u0.a.a());
    }

    public final h<T> skipLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        return skipLast(j2, timeUnit, a0Var, z, bufferSize());
    }

    public final h<T> takeLast(long j2, long j3, TimeUnit timeUnit, a0 a0Var, boolean z, int i2) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        if (j2 >= 0) {
            return h.c.r0.a.l(new c4(this, j2, j3, timeUnit, a0Var, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    public final h<T> timeout(long j2, TimeUnit timeUnit, a0 a0Var, k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return timeout0(j2, timeUnit, bVar, a0Var);
    }

    public final h<h<T>> window(long j2, long j3, TimeUnit timeUnit) {
        return window(j2, j3, timeUnit, h.c.u0.a.a(), bufferSize());
    }

    public final <U, R> h<R> zipWith(k.a.b<? extends U> bVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return zip(this, bVar, cVar, z, i2);
    }

    public static <T> h<T> concat(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, k.a.b<? extends T> bVar3) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        return concatArray(bVar, bVar2, bVar3);
    }

    public static <T> h<T> fromFuture(Future<? extends T> future, a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return fromFuture(future).subscribeOn(a0Var);
    }

    public static <T> b0<Boolean> sequenceEqual(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, int i2) {
        return sequenceEqual(bVar, bVar2, h.c.n0.b.b.d(), i2);
    }

    public final void blockingSubscribe(k.a.c<? super T> cVar) {
        h.c.n0.e.b.k.d(this, cVar);
    }

    public final h<List<T>> buffer(long j2, long j3, TimeUnit timeUnit) {
        return (h<List<T>>) buffer(j2, j3, timeUnit, h.c.u0.a.a(), h.c.n0.j.b.n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> h<V> flatMapIterable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends V> cVar, int i2) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.e(cVar, "resultSelector is null");
        return (h<V>) flatMap(r1.a(nVar), cVar, false, bufferSize(), i2);
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, int i2, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return c3.j(r1.f(this, i2, j2, timeUnit, a0Var), nVar);
    }

    public final h<T> retry(h.c.m0.p<? super Throwable> pVar) {
        return retry(Long.MAX_VALUE, pVar);
    }

    public final h<T> skipLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z, int i2) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new t3(this, j2, timeUnit, a0Var, i2 << 1, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> b0<Map<K, Collection<V>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, Callable<? extends Map<K, Collection<V>>> callable, h.c.m0.n<? super K, ? extends Collection<? super V>> nVar3) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        h.c.n0.b.b.e(callable, "mapSupplier is null");
        h.c.n0.b.b.e(nVar3, "collectionFactory is null");
        return (b0<Map<K, Collection<V>>>) collect(callable, h.c.n0.b.a.G(nVar, nVar2, nVar3));
    }

    public final h<h<T>> window(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        return window(j2, j3, timeUnit, a0Var, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> h<R> withLatestFrom(k.a.b<T1> bVar, k.a.b<T2> bVar2, k.a.b<T3> bVar3, h.c.m0.h<? super T, ? super T1, ? super T2, ? super T3, R> hVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        return withLatestFrom(new k.a.b[]{bVar, bVar2, bVar3}, h.c.n0.b.a.y(hVar));
    }

    public static <T, R> h<R> combineLatest(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatest(iterable, nVar, bufferSize());
    }

    public static <T> h<T> merge(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, k.a.b<? extends T> bVar3) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        return fromArray(bVar, bVar2, bVar3).flatMap(h.c.n0.b.a.j(), false, 3);
    }

    public static <T> h<T> mergeDelayError(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, k.a.b<? extends T> bVar3) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        return fromArray(bVar, bVar2, bVar3).flatMap(h.c.n0.b.a.j(), true, 3);
    }

    public static <T1, T2, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), z, bufferSize(), bVar, bVar2);
    }

    public final h<List<T>> buffer(long j2, long j3, TimeUnit timeUnit, a0 a0Var) {
        return (h<List<T>>) buffer(j2, j3, timeUnit, a0Var, h.c.n0.j.b.n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> h<T> delay(k.a.b<U> bVar, h.c.m0.n<? super T, ? extends k.a.b<V>> nVar) {
        return delaySubscription(bVar).delay(nVar);
    }

    public final <K, V> h<h.c.l0.b<K, V>> groupBy(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, boolean z, int i2, h.c.m0.n<? super h.c.m0.f<Object>, ? extends Map<K, Object>> nVar3) {
        h.c.n0.b.b.e(nVar, "keySelector is null");
        h.c.n0.b.b.e(nVar2, "valueSelector is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(nVar3, "evictingMapFactory is null");
        return h.c.r0.a.l(new m1(this, nVar, nVar2, i2, z, nVar3));
    }

    public final <U> h<T> sample(k.a.b<U> bVar) {
        h.c.n0.b.b.e(bVar, "sampler is null");
        return h.c.r0.a.l(new g3(this, bVar, false));
    }

    public final h<T> timeout(long j2, TimeUnit timeUnit, a0 a0Var) {
        return timeout0(j2, timeUnit, null, a0Var);
    }

    public final h<h<T>> window(long j2, long j3, TimeUnit timeUnit, a0 a0Var, int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.g(j2, "timespan");
        h.c.n0.b.b.g(j3, "timeskip");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        return h.c.r0.a.l(new v4(this, j2, j3, timeUnit, a0Var, Long.MAX_VALUE, i2, false));
    }

    public static <T, R> h<R> combineLatest(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new h.c.n0.e.b.t((Iterable) iterable, (h.c.m0.n) nVar, i2, false));
    }

    public static <T, R> h<R> combineLatestDelayError(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        return combineLatestDelayError(iterable, nVar, bufferSize());
    }

    public static <T, S> h<T> generate(Callable<S> callable, h.c.m0.b<S, g<T>> bVar, h.c.m0.f<? super S> fVar) {
        h.c.n0.b.b.e(bVar, "generator is null");
        return generate(callable, r1.i(bVar), fVar);
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    public final <U extends Collection<? super T>> h<U> buffer(long j2, long j3, TimeUnit timeUnit, a0 a0Var, Callable<U> callable) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.l(new h.c.n0.e.b.p(this, j2, j3, timeUnit, a0Var, callable, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, false));
    }

    public final h<T> onBackpressureBuffer(int i2, h.c.m0.a aVar) {
        return onBackpressureBuffer(i2, false, false, aVar);
    }

    public final <U, V> h<T> timeout(k.a.b<U> bVar, h.c.m0.n<? super T, ? extends k.a.b<V>> nVar) {
        h.c.n0.b.b.e(bVar, "firstTimeoutIndicator is null");
        return timeout0(bVar, nVar, null);
    }

    public static <T, R> h<R> combineLatestDelayError(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2) {
        h.c.n0.b.b.e(iterable, "sources is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new h.c.n0.e.b.t((Iterable) iterable, (h.c.m0.n) nVar, i2, true));
    }

    public final h<T> doOnEach(k.a.c<? super T> cVar) {
        h.c.n0.b.b.e(cVar, "subscriber is null");
        return doOnEach(r1.m(cVar), r1.l(cVar), r1.k(cVar), h.c.n0.b.a.f14096c);
    }

    public final h<T> onBackpressureBuffer(long j2, h.c.m0.a aVar, a aVar2) {
        h.c.n0.b.b.e(aVar2, "overflowStrategy is null");
        h.c.n0.b.b.g(j2, "capacity");
        return h.c.r0.a.l(new k2(this, j2, aVar, aVar2));
    }

    public final <U> h<T> sample(k.a.b<U> bVar, boolean z) {
        h.c.n0.b.b.e(bVar, "sampler is null");
        return h.c.r0.a.l(new g3(this, bVar, z));
    }

    @Override // k.a.b
    public final void subscribe(k.a.c<? super T> cVar) {
        if (cVar instanceof m) {
            subscribe((m) ((m) cVar));
            return;
        }
        h.c.n0.b.b.e(cVar, "s is null");
        subscribe((m) new h.c.n0.h.t(cVar));
    }

    public static <T> h<T> concat(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, k.a.b<? extends T> bVar3, k.a.b<? extends T> bVar4) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        return concatArray(bVar, bVar2, bVar3, bVar4);
    }

    public static <T, S> h<T> generate(Callable<S> callable, h.c.m0.c<S, g<T>, S> cVar) {
        return generate(callable, cVar, h.c.n0.b.a.h());
    }

    public static <T1, T2, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i2) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), z, i2, bVar, bVar2);
    }

    public final h<T> takeLast(long j2, TimeUnit timeUnit) {
        return takeLast(j2, timeUnit, h.c.u0.a.a(), false, bufferSize());
    }

    public final <U, V> h<T> timeout(k.a.b<U> bVar, h.c.m0.n<? super T, ? extends k.a.b<V>> nVar, k.a.b<? extends T> bVar2) {
        h.c.n0.b.b.e(bVar, "firstTimeoutSelector is null");
        h.c.n0.b.b.e(bVar2, "other is null");
        return timeout0(bVar, nVar, bVar2);
    }

    public static <T, S> h<T> generate(Callable<S> callable, h.c.m0.c<S, g<T>, S> cVar, h.c.m0.f<? super S> fVar) {
        h.c.n0.b.b.e(callable, "initialState is null");
        h.c.n0.b.b.e(cVar, "generator is null");
        h.c.n0.b.b.e(fVar, "disposeState is null");
        return h.c.r0.a.l(new l1(callable, cVar, fVar));
    }

    public static <T> h<T> merge(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, k.a.b<? extends T> bVar3, k.a.b<? extends T> bVar4) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        return fromArray(bVar, bVar2, bVar3, bVar4).flatMap(h.c.n0.b.a.j(), false, 4);
    }

    public static <T> h<T> mergeDelayError(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, k.a.b<? extends T> bVar3, k.a.b<? extends T> bVar4) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        return fromArray(bVar, bVar2, bVar3, bVar4).flatMap(h.c.n0.b.a.j(), true, 4);
    }

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, h.c.m0.n<? super Throwable, ? extends k.a.b<? extends R>> nVar2, Callable<? extends k.a.b<? extends R>> callable) {
        h.c.n0.b.b.e(nVar, "onNextMapper is null");
        h.c.n0.b.b.e(nVar2, "onErrorMapper is null");
        h.c.n0.b.b.e(callable, "onCompleteSupplier is null");
        return merge(new b2(this, nVar, nVar2, callable));
    }

    public final h<T> takeLast(long j2, TimeUnit timeUnit, boolean z) {
        return takeLast(j2, timeUnit, h.c.u0.a.a(), z, bufferSize());
    }

    public final <K, V> b0<Map<K, Collection<V>>> toMultimap(h.c.m0.n<? super T, ? extends K> nVar, h.c.m0.n<? super T, ? extends V> nVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(nVar, nVar2, callable, h.c.n0.j.b.q());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> h<R> withLatestFrom(k.a.b<T1> bVar, k.a.b<T2> bVar2, k.a.b<T3> bVar3, k.a.b<T4> bVar4, h.c.m0.i<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> iVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        return withLatestFrom(new k.a.b[]{bVar, bVar2, bVar3, bVar4}, h.c.n0.b.a.z(iVar));
    }

    public static <T1, T2, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        return combineLatest(h.c.n0.b.a.w(cVar), bVar, bVar2);
    }

    public final h<List<T>> buffer(long j2, TimeUnit timeUnit) {
        return buffer(j2, timeUnit, h.c.u0.a.a(), (int) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, int i2, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return c3.j(r1.e(this, i2), r1.h(nVar, a0Var));
    }

    public final h<T> takeLast(long j2, TimeUnit timeUnit, a0 a0Var) {
        return takeLast(j2, timeUnit, a0Var, false, bufferSize());
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4, T t5) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T1, T2, T3, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, h.c.m0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        return zipArray(h.c.n0.b.a.x(gVar), false, bufferSize(), bVar, bVar2, bVar3);
    }

    public final h<List<T>> buffer(long j2, TimeUnit timeUnit, int i2) {
        return buffer(j2, timeUnit, h.c.u0.a.a(), i2);
    }

    public final void subscribe(m<? super T> mVar) {
        h.c.n0.b.b.e(mVar, "s is null");
        try {
            k.a.c<? super T> C = h.c.r0.a.C(this, mVar);
            h.c.n0.b.b.e(C, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(C);
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

    public final h<T> takeLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        return takeLast(j2, timeUnit, a0Var, z, bufferSize());
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit) {
        return window(j2, timeUnit, h.c.u0.a.a(), Long.MAX_VALUE, false);
    }

    public final h<List<T>> buffer(long j2, TimeUnit timeUnit, a0 a0Var, int i2) {
        return (h<List<T>>) buffer(j2, timeUnit, a0Var, i2, h.c.n0.j.b.n(), false);
    }

    public final h<T> takeLast(long j2, TimeUnit timeUnit, a0 a0Var, boolean z, int i2) {
        return takeLast(Long.MAX_VALUE, j2, timeUnit, a0Var, z, i2);
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit, long j3) {
        return window(j2, timeUnit, h.c.u0.a.a(), j3, false);
    }

    public final <U extends Collection<? super T>> h<U> buffer(long j2, TimeUnit timeUnit, a0 a0Var, int i2, Callable<U> callable, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        h.c.n0.b.b.f(i2, "count");
        return h.c.r0.a.l(new h.c.n0.e.b.p(this, j2, j2, timeUnit, a0Var, callable, i2, z));
    }

    public final <R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, h.c.m0.n<Throwable, ? extends k.a.b<? extends R>> nVar2, Callable<? extends k.a.b<? extends R>> callable, int i2) {
        h.c.n0.b.b.e(nVar, "onNextMapper is null");
        h.c.n0.b.b.e(nVar2, "onErrorMapper is null");
        h.c.n0.b.b.e(callable, "onCompleteSupplier is null");
        return merge(new b2(this, nVar, nVar2, callable), i2);
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return window(j2, timeUnit, h.c.u0.a.a(), j3, z);
    }

    public static <T1, T2, T3, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, h.c.m0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        return combineLatest(h.c.n0.b.a.x(gVar), bVar, bVar2, bVar3);
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit, a0 a0Var) {
        return window(j2, timeUnit, a0Var, Long.MAX_VALUE, false);
    }

    public static <T1, T2, T3, T4, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, h.c.m0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        return zipArray(h.c.n0.b.a.y(hVar), false, bufferSize(), bVar, bVar2, bVar3, bVar4);
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit, a0 a0Var, long j3) {
        return window(j2, timeUnit, a0Var, j3, false);
    }

    public final <R> h<R> withLatestFrom(k.a.b<?>[] bVarArr, h.c.m0.n<? super Object[], R> nVar) {
        h.c.n0.b.b.e(bVarArr, "others is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        return h.c.r0.a.l(new x4(this, bVarArr, nVar));
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, long j2, TimeUnit timeUnit) {
        return replay(nVar, j2, timeUnit, h.c.u0.a.a());
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit, a0 a0Var, long j3, boolean z) {
        return window(j2, timeUnit, a0Var, j3, z, bufferSize());
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public final <U, R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        return flatMap(nVar, cVar, false, bufferSize(), bufferSize());
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return c3.j(r1.g(this, j2, timeUnit, a0Var), nVar);
    }

    public final h<h<T>> window(long j2, TimeUnit timeUnit, a0 a0Var, long j3, boolean z, int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.g(j3, "count");
        return h.c.r0.a.l(new v4(this, j2, j2, timeUnit, a0Var, j3, i2, z));
    }

    public static <T1, T2, T3, T4, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, h.c.m0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        return combineLatest(h.c.n0.b.a.y(hVar), bVar, bVar2, bVar3, bVar4);
    }

    public final h<List<T>> buffer(long j2, TimeUnit timeUnit, a0 a0Var) {
        return (h<List<T>>) buffer(j2, timeUnit, a0Var, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, h.c.n0.j.b.n(), false);
    }

    public final <U, R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return flatMap(nVar, cVar, z, bufferSize(), bufferSize());
    }

    public final <R> h<R> withLatestFrom(Iterable<? extends k.a.b<?>> iterable, h.c.m0.n<? super Object[], R> nVar) {
        h.c.n0.b.b.e(iterable, "others is null");
        h.c.n0.b.b.e(nVar, "combiner is null");
        return h.c.r0.a.l(new x4(this, iterable, nVar));
    }

    public final <TOpening, TClosing> h<List<T>> buffer(h<? extends TOpening> hVar, h.c.m0.n<? super TOpening, ? extends k.a.b<? extends TClosing>> nVar) {
        return (h<List<T>>) buffer(hVar, nVar, h.c.n0.j.b.n());
    }

    public final <U, R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2) {
        return flatMap(nVar, cVar, z, i2, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, h.c.m0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        return zipArray(h.c.n0.b.a.z(iVar), false, bufferSize(), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> h<U> buffer(h<? extends TOpening> hVar, h.c.m0.n<? super TOpening, ? extends k.a.b<? extends TClosing>> nVar, Callable<U> callable) {
        h.c.n0.b.b.e(hVar, "openingIndicator is null");
        h.c.n0.b.b.e(nVar, "closingIndicator is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.l(new h.c.n0.e.b.m(this, hVar, nVar, callable));
    }

    public final <U, R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, boolean z, int i2, int i3) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        h.c.n0.b.b.e(cVar, "combiner is null");
        h.c.n0.b.b.f(i2, "maxConcurrency");
        h.c.n0.b.b.f(i3, "bufferSize");
        return flatMap(r1.b(nVar, cVar), z, i2, i3);
    }

    public final <R> h<R> replay(h.c.m0.n<? super h<T>, ? extends k.a.b<R>> nVar, a0 a0Var) {
        h.c.n0.b.b.e(nVar, "selector is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return c3.j(r1.d(this), r1.h(nVar, a0Var));
    }

    public final <B> h<h<T>> window(k.a.b<B> bVar) {
        return window(bVar, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, h.c.m0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        return combineLatest(h.c.n0.b.a.z(iVar), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    public final <B> h<h<T>> window(k.a.b<B> bVar, int i2) {
        h.c.n0.b.b.e(bVar, "boundaryIndicator is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new s4(this, bVar, i2));
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        h.c.n0.b.b.e(t, "item1 is null");
        h.c.n0.b.b.e(t2, "item2 is null");
        h.c.n0.b.b.e(t3, "item3 is null");
        h.c.n0.b.b.e(t4, "item4 is null");
        h.c.n0.b.b.e(t5, "item5 is null");
        h.c.n0.b.b.e(t6, "item6 is null");
        h.c.n0.b.b.e(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public final <B> h<List<T>> buffer(k.a.b<B> bVar) {
        return (h<List<T>>) buffer(bVar, h.c.n0.j.b.n());
    }

    public final <B> h<List<T>> buffer(k.a.b<B> bVar, int i2) {
        h.c.n0.b.b.f(i2, "initialCapacity");
        return (h<List<T>>) buffer(bVar, h.c.n0.b.a.f(i2));
    }

    public final <U, R> h<R> flatMap(h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, int i2) {
        return flatMap(nVar, cVar, false, i2, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, T6, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, h.c.m0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        return zipArray(h.c.n0.b.a.A(jVar), false, bufferSize(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    public final h.c.l0.a<T> replay(int i2) {
        h.c.n0.b.b.f(i2, "bufferSize");
        return c3.d(this, i2);
    }

    public final <U, V> h<h<T>> window(k.a.b<U> bVar, h.c.m0.n<? super U, ? extends k.a.b<V>> nVar) {
        return window(bVar, nVar, bufferSize());
    }

    public final <B, U extends Collection<? super T>> h<U> buffer(k.a.b<B> bVar, Callable<U> callable) {
        h.c.n0.b.b.e(bVar, "boundaryIndicator is null");
        h.c.n0.b.b.e(callable, "bufferSupplier is null");
        return h.c.r0.a.l(new h.c.n0.e.b.o(this, bVar, callable));
    }

    public final <U, V> h<h<T>> window(k.a.b<U> bVar, h.c.m0.n<? super U, ? extends k.a.b<V>> nVar, int i2) {
        h.c.n0.b.b.e(bVar, "openingIndicator is null");
        h.c.n0.b.b.e(nVar, "closingIndicator is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new t4(this, bVar, nVar, i2));
    }

    public final h.c.l0.a<T> replay(int i2, long j2, TimeUnit timeUnit) {
        return replay(i2, j2, timeUnit, h.c.u0.a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, h.c.m0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        return combineLatest(h.c.n0.b.a.A(jVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }

    public final h.c.l0.a<T> replay(int i2, long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.f(i2, "bufferSize");
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return c3.f(this, j2, timeUnit, a0Var, i2);
    }

    public final <B> h<List<T>> buffer(Callable<? extends k.a.b<B>> callable) {
        return (h<List<T>>) buffer(callable, h.c.n0.j.b.n());
    }

    public final <B, U extends Collection<? super T>> h<U> buffer(Callable<? extends k.a.b<B>> callable, Callable<U> callable2) {
        h.c.n0.b.b.e(callable, "boundaryIndicatorSupplier is null");
        h.c.n0.b.b.e(callable2, "bufferSupplier is null");
        return h.c.r0.a.l(new h.c.n0.e.b.n(this, callable, callable2));
    }

    public final <B> h<h<T>> window(Callable<? extends k.a.b<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
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

    public final <B> h<h<T>> window(Callable<? extends k.a.b<B>> callable, int i2) {
        h.c.n0.b.b.e(callable, "boundaryIndicatorSupplier is null");
        h.c.n0.b.b.f(i2, "bufferSize");
        return h.c.r0.a.l(new u4(this, callable, i2));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, k.a.b<? extends T7> bVar7, h.c.m0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        h.c.n0.b.b.e(bVar7, "source7 is null");
        return zipArray(h.c.n0.b.a.B(kVar), false, bufferSize(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    public final h.c.l0.a<T> replay(int i2, a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return c3.k(replay(i2), a0Var);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, k.a.b<? extends T7> bVar7, h.c.m0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        h.c.n0.b.b.e(bVar7, "source7 is null");
        return combineLatest(h.c.n0.b.a.B(kVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7);
    }

    public final h.c.l0.a<T> replay(long j2, TimeUnit timeUnit) {
        return replay(j2, timeUnit, h.c.u0.a.a());
    }

    public final h.c.l0.a<T> replay(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return c3.e(this, j2, timeUnit, a0Var);
    }

    public final h.c.l0.a<T> replay(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return c3.k(replay(), a0Var);
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
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

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, k.a.b<? extends T7> bVar7, k.a.b<? extends T8> bVar8, h.c.m0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        h.c.n0.b.b.e(bVar7, "source7 is null");
        h.c.n0.b.b.e(bVar8, "source8 is null");
        return zipArray(h.c.n0.b.a.C(lVar), false, bufferSize(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, k.a.b<? extends T7> bVar7, k.a.b<? extends T8> bVar8, h.c.m0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        h.c.n0.b.b.e(bVar7, "source7 is null");
        h.c.n0.b.b.e(bVar8, "source8 is null");
        return combineLatest(h.c.n0.b.a.C(lVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> h<R> zip(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, k.a.b<? extends T7> bVar7, k.a.b<? extends T8> bVar8, k.a.b<? extends T9> bVar9, h.c.m0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        h.c.n0.b.b.e(bVar7, "source7 is null");
        h.c.n0.b.b.e(bVar8, "source8 is null");
        h.c.n0.b.b.e(bVar9, "source9 is null");
        return zipArray(h.c.n0.b.a.D(mVar), false, bufferSize(), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9);
    }

    public static <T> h<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> h<R> combineLatest(k.a.b<? extends T1> bVar, k.a.b<? extends T2> bVar2, k.a.b<? extends T3> bVar3, k.a.b<? extends T4> bVar4, k.a.b<? extends T5> bVar5, k.a.b<? extends T6> bVar6, k.a.b<? extends T7> bVar7, k.a.b<? extends T8> bVar8, k.a.b<? extends T9> bVar9, h.c.m0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        h.c.n0.b.b.e(bVar, "source1 is null");
        h.c.n0.b.b.e(bVar2, "source2 is null");
        h.c.n0.b.b.e(bVar3, "source3 is null");
        h.c.n0.b.b.e(bVar4, "source4 is null");
        h.c.n0.b.b.e(bVar5, "source5 is null");
        h.c.n0.b.b.e(bVar6, "source6 is null");
        h.c.n0.b.b.e(bVar7, "source7 is null");
        h.c.n0.b.b.e(bVar8, "source8 is null");
        h.c.n0.b.b.e(bVar9, "source9 is null");
        return combineLatest(h.c.n0.b.a.D(mVar), bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9);
    }
}