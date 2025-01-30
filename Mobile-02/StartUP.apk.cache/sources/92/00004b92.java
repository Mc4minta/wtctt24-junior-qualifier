package h.c;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import h.c.n0.e.b.c1;
import h.c.n0.e.b.q3;
import h.c.n0.e.e.d3;
import h.c.n0.e.g.j0;
import h.c.n0.e.g.k0;
import h.c.n0.e.g.l0;
import h.c.n0.e.g.m0;
import h.c.n0.e.g.n0;
import h.c.n0.e.g.o0;
import h.c.n0.e.g.p0;
import h.c.n0.e.g.q0;
import h.c.n0.e.g.r0;
import h.c.n0.e.g.s0;
import h.c.n0.e.g.t0;
import h.c.n0.e.g.u0;
import h.c.n0.e.g.v0;
import h.c.n0.e.g.w0;
import h.c.n0.e.g.x0;
import h.c.n0.e.g.y0;
import h.c.n0.e.g.z0;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Single.java */
/* loaded from: classes2.dex */
public abstract class b0<T> implements h0<T> {
    public static <T> b0<T> amb(Iterable<? extends h0<? extends T>> iterable) {
        h.c.n0.b.b.e(iterable, "sources is null");
        return h.c.r0.a.o(new h.c.n0.e.g.a(null, iterable));
    }

    public static <T> b0<T> ambArray(h0<? extends T>... h0VarArr) {
        if (h0VarArr.length == 0) {
            return error(h.c.n0.e.g.h0.a());
        }
        if (h0VarArr.length == 1) {
            return wrap(h0VarArr[0]);
        }
        return h.c.r0.a.o(new h.c.n0.e.g.a(h0VarArr, null));
    }

    public static <T> h<T> concat(Iterable<? extends h0<? extends T>> iterable) {
        return concat(h.fromIterable(iterable));
    }

    public static <T> h<T> concatArray(h0<? extends T>... h0VarArr) {
        return h.c.r0.a.l(new h.c.n0.e.b.v(h.fromArray(h0VarArr), h.c.n0.e.g.h0.b(), 2, h.c.n0.j.i.BOUNDARY));
    }

    public static <T> h<T> concatArrayEager(h0<? extends T>... h0VarArr) {
        return h.fromArray(h0VarArr).concatMapEager(h.c.n0.e.g.h0.b());
    }

    public static <T> h<T> concatEager(k.a.b<? extends h0<? extends T>> bVar) {
        return h.fromPublisher(bVar).concatMapEager(h.c.n0.e.g.h0.b());
    }

    public static <T> b0<T> create(f0<T> f0Var) {
        h.c.n0.b.b.e(f0Var, "source is null");
        return h.c.r0.a.o(new h.c.n0.e.g.d(f0Var));
    }

    public static <T> b0<T> defer(Callable<? extends h0<? extends T>> callable) {
        h.c.n0.b.b.e(callable, "singleSupplier is null");
        return h.c.r0.a.o(new h.c.n0.e.g.e(callable));
    }

    public static <T> b0<Boolean> equals(h0<? extends T> h0Var, h0<? extends T> h0Var2) {
        h.c.n0.b.b.e(h0Var, "first is null");
        h.c.n0.b.b.e(h0Var2, "second is null");
        return h.c.r0.a.o(new h.c.n0.e.g.v(h0Var, h0Var2));
    }

    public static <T> b0<T> error(Callable<? extends Throwable> callable) {
        h.c.n0.b.b.e(callable, "errorSupplier is null");
        return h.c.r0.a.o(new h.c.n0.e.g.w(callable));
    }

    public static <T> b0<T> fromCallable(Callable<? extends T> callable) {
        h.c.n0.b.b.e(callable, "callable is null");
        return h.c.r0.a.o(new h.c.n0.e.g.d0(callable));
    }

    public static <T> b0<T> fromFuture(Future<? extends T> future) {
        return toSingle(h.fromFuture(future));
    }

    public static <T> b0<T> fromObservable(x<? extends T> xVar) {
        h.c.n0.b.b.e(xVar, "observableSource is null");
        return h.c.r0.a.o(new d3(xVar, null));
    }

    public static <T> b0<T> fromPublisher(k.a.b<? extends T> bVar) {
        h.c.n0.b.b.e(bVar, "publisher is null");
        return h.c.r0.a.o(new h.c.n0.e.g.e0(bVar));
    }

    public static <T> b0<T> just(T t) {
        h.c.n0.b.b.e(t, "item is null");
        return h.c.r0.a.o(new h.c.n0.e.g.i0(t));
    }

    public static <T> h<T> merge(Iterable<? extends h0<? extends T>> iterable) {
        return merge(h.fromIterable(iterable));
    }

    public static <T> h<T> mergeDelayError(Iterable<? extends h0<? extends T>> iterable) {
        return mergeDelayError(h.fromIterable(iterable));
    }

    public static <T> b0<T> never() {
        return h.c.r0.a.o(m0.a);
    }

    private b0<T> timeout0(long j2, TimeUnit timeUnit, a0 a0Var, h0<? extends T> h0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.o(new s0(this, j2, timeUnit, a0Var, h0Var));
    }

    public static b0<Long> timer(long j2, TimeUnit timeUnit) {
        return timer(j2, timeUnit, h.c.u0.a.a());
    }

    private static <T> b0<T> toSingle(h<T> hVar) {
        return h.c.r0.a.o(new q3(hVar, null));
    }

    public static <T> b0<T> unsafeCreate(h0<T> h0Var) {
        h.c.n0.b.b.e(h0Var, "onSubscribe is null");
        if (!(h0Var instanceof b0)) {
            return h.c.r0.a.o(new h.c.n0.e.g.f0(h0Var));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    public static <T, U> b0<T> using(Callable<U> callable, h.c.m0.n<? super U, ? extends h0<? extends T>> nVar, h.c.m0.f<? super U> fVar) {
        return using(callable, nVar, fVar, true);
    }

    public static <T> b0<T> wrap(h0<T> h0Var) {
        h.c.n0.b.b.e(h0Var, "source is null");
        if (h0Var instanceof b0) {
            return h.c.r0.a.o((b0) h0Var);
        }
        return h.c.r0.a.o(new h.c.n0.e.g.f0(h0Var));
    }

    public static <T, R> b0<R> zip(Iterable<? extends h0<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(iterable, "sources is null");
        return h.c.r0.a.o(new z0(iterable, nVar));
    }

    public static <T, R> b0<R> zipArray(h.c.m0.n<? super Object[], ? extends R> nVar, h0<? extends T>... h0VarArr) {
        h.c.n0.b.b.e(nVar, "zipper is null");
        h.c.n0.b.b.e(h0VarArr, "sources is null");
        if (h0VarArr.length == 0) {
            return error(new NoSuchElementException());
        }
        return h.c.r0.a.o(new y0(h0VarArr, nVar));
    }

    public final b0<T> ambWith(h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return ambArray(this, h0Var);
    }

    public final <R> R as(c0<T, ? extends R> c0Var) {
        return (R) ((c0) h.c.n0.b.b.e(c0Var, "converter is null")).a(this);
    }

    public final T blockingGet() {
        h.c.n0.d.h hVar = new h.c.n0.d.h();
        subscribe(hVar);
        return (T) hVar.a();
    }

    public final b0<T> cache() {
        return h.c.r0.a.o(new h.c.n0.e.g.b(this));
    }

    public final <U> b0<U> cast(Class<? extends U> cls) {
        h.c.n0.b.b.e(cls, "clazz is null");
        return (b0<U>) map(h.c.n0.b.a.e(cls));
    }

    public final <R> b0<R> compose(i0<? super T, ? extends R> i0Var) {
        return wrap(((i0) h.c.n0.b.b.e(i0Var, "transformer is null")).a(this));
    }

    public final h<T> concatWith(h0<? extends T> h0Var) {
        return concat(this, h0Var);
    }

    public final b0<Boolean> contains(Object obj) {
        return contains(obj, h.c.n0.b.b.d());
    }

    public final b0<T> delay(long j2, TimeUnit timeUnit) {
        return delay(j2, timeUnit, h.c.u0.a.a(), false);
    }

    public final b0<T> delaySubscription(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return h.c.r0.a.o(new h.c.n0.e.g.g(this, fVar));
    }

    public final <R> o<R> dematerialize(h.c.m0.n<? super T, r<R>> nVar) {
        h.c.n0.b.b.e(nVar, "selector is null");
        return h.c.r0.a.m(new h.c.n0.e.g.k(this, nVar));
    }

    public final b0<T> doAfterSuccess(h.c.m0.f<? super T> fVar) {
        h.c.n0.b.b.e(fVar, "onAfterSuccess is null");
        return h.c.r0.a.o(new h.c.n0.e.g.m(this, fVar));
    }

    public final b0<T> doAfterTerminate(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onAfterTerminate is null");
        return h.c.r0.a.o(new h.c.n0.e.g.n(this, aVar));
    }

    public final b0<T> doFinally(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onFinally is null");
        return h.c.r0.a.o(new h.c.n0.e.g.o(this, aVar));
    }

    public final b0<T> doOnDispose(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onDispose is null");
        return h.c.r0.a.o(new h.c.n0.e.g.p(this, aVar));
    }

    public final b0<T> doOnError(h.c.m0.f<? super Throwable> fVar) {
        h.c.n0.b.b.e(fVar, "onError is null");
        return h.c.r0.a.o(new h.c.n0.e.g.q(this, fVar));
    }

    public final b0<T> doOnEvent(h.c.m0.b<? super T, ? super Throwable> bVar) {
        h.c.n0.b.b.e(bVar, "onEvent is null");
        return h.c.r0.a.o(new h.c.n0.e.g.r(this, bVar));
    }

    public final b0<T> doOnSubscribe(h.c.m0.f<? super h.c.k0.b> fVar) {
        h.c.n0.b.b.e(fVar, "onSubscribe is null");
        return h.c.r0.a.o(new h.c.n0.e.g.s(this, fVar));
    }

    public final b0<T> doOnSuccess(h.c.m0.f<? super T> fVar) {
        h.c.n0.b.b.e(fVar, "onSuccess is null");
        return h.c.r0.a.o(new h.c.n0.e.g.t(this, fVar));
    }

    public final b0<T> doOnTerminate(h.c.m0.a aVar) {
        h.c.n0.b.b.e(aVar, "onTerminate is null");
        return h.c.r0.a.o(new h.c.n0.e.g.u(this, aVar));
    }

    public final o<T> filter(h.c.m0.p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "predicate is null");
        return h.c.r0.a.m(new h.c.n0.e.c.a(this, pVar));
    }

    public final <R> b0<R> flatMap(h.c.m0.n<? super T, ? extends h0<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.o(new h.c.n0.e.g.x(this, nVar));
    }

    public final c flatMapCompletable(h.c.m0.n<? super T, ? extends f> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.k(new h.c.n0.e.g.y(this, nVar));
    }

    public final <R> o<R> flatMapMaybe(h.c.m0.n<? super T, ? extends q<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.m(new h.c.n0.e.g.b0(this, nVar));
    }

    public final <R> s<R> flatMapObservable(h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new h.c.n0.e.d.o(this, nVar));
    }

    public final <R> h<R> flatMapPublisher(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new h.c.n0.e.g.c0(this, nVar));
    }

    public final <U> h<U> flattenAsFlowable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.l(new h.c.n0.e.g.z(this, nVar));
    }

    public final <U> s<U> flattenAsObservable(h.c.m0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.n(new h.c.n0.e.g.a0(this, nVar));
    }

    public final b0<T> hide() {
        return h.c.r0.a.o(new h.c.n0.e.g.g0(this));
    }

    public final c ignoreElement() {
        return h.c.r0.a.k(new h.c.n0.e.a.g(this));
    }

    public final <R> b0<R> lift(g0<? extends R, ? super T> g0Var) {
        h.c.n0.b.b.e(g0Var, "lift is null");
        return h.c.r0.a.o(new j0(this, g0Var));
    }

    public final <R> b0<R> map(h.c.m0.n<? super T, ? extends R> nVar) {
        h.c.n0.b.b.e(nVar, "mapper is null");
        return h.c.r0.a.o(new k0(this, nVar));
    }

    public final b0<r<T>> materialize() {
        return h.c.r0.a.o(new l0(this));
    }

    public final h<T> mergeWith(h0<? extends T> h0Var) {
        return merge(this, h0Var);
    }

    public final b0<T> observeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.o(new n0(this, a0Var));
    }

    public final b0<T> onErrorResumeNext(b0<? extends T> b0Var) {
        h.c.n0.b.b.e(b0Var, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(h.c.n0.b.a.m(b0Var));
    }

    public final b0<T> onErrorReturn(h.c.m0.n<Throwable, ? extends T> nVar) {
        h.c.n0.b.b.e(nVar, "resumeFunction is null");
        return h.c.r0.a.o(new o0(this, nVar, null));
    }

    public final b0<T> onErrorReturnItem(T t) {
        h.c.n0.b.b.e(t, "value is null");
        return h.c.r0.a.o(new o0(this, null, t));
    }

    public final b0<T> onTerminateDetach() {
        return h.c.r0.a.o(new h.c.n0.e.g.l(this));
    }

    public final h<T> repeat() {
        return toFlowable().repeat();
    }

    public final h<T> repeatUntil(h.c.m0.e eVar) {
        return toFlowable().repeatUntil(eVar);
    }

    public final h<T> repeatWhen(h.c.m0.n<? super h<Object>, ? extends k.a.b<?>> nVar) {
        return toFlowable().repeatWhen(nVar);
    }

    public final b0<T> retry() {
        return toSingle(toFlowable().retry());
    }

    public final b0<T> retryWhen(h.c.m0.n<? super h<Throwable>, ? extends k.a.b<?>> nVar) {
        return toSingle(toFlowable().retryWhen(nVar));
    }

    public final h.c.k0.b subscribe() {
        return subscribe(h.c.n0.b.a.h(), h.c.n0.b.a.f14099f);
    }

    protected abstract void subscribeActual(e0<? super T> e0Var);

    public final b0<T> subscribeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.o(new q0(this, a0Var));
    }

    public final <E extends e0<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final b0<T> takeUntil(f fVar) {
        h.c.n0.b.b.e(fVar, "other is null");
        return takeUntil(new h.c.n0.e.a.k(fVar));
    }

    public final h.c.p0.g<T> test() {
        h.c.p0.g<T> gVar = new h.c.p0.g<>();
        subscribe(gVar);
        return gVar;
    }

    public final b0<T> timeout(long j2, TimeUnit timeUnit) {
        return timeout0(j2, timeUnit, h.c.u0.a.a(), null);
    }

    public final <R> R to(h.c.m0.n<? super b0<T>, R> nVar) {
        try {
            return (R) ((h.c.m0.n) h.c.n0.b.b.e(nVar, "convert is null")).apply(this);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw h.c.n0.j.j.e(th);
        }
    }

    @Deprecated
    public final c toCompletable() {
        return h.c.r0.a.k(new h.c.n0.e.a.g(this));
    }

    public final h<T> toFlowable() {
        if (this instanceof h.c.n0.c.b) {
            return ((h.c.n0.c.b) this).e();
        }
        return h.c.r0.a.l(new u0(this));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new h.c.n0.d.q());
    }

    public final o<T> toMaybe() {
        if (this instanceof h.c.n0.c.c) {
            return ((h.c.n0.c.c) this).a();
        }
        return h.c.r0.a.m(new h.c.n0.e.c.b(this));
    }

    public final s<T> toObservable() {
        if (this instanceof h.c.n0.c.d) {
            return ((h.c.n0.c.d) this).a();
        }
        return h.c.r0.a.n(new v0(this));
    }

    public final b0<T> unsubscribeOn(a0 a0Var) {
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.o(new w0(this, a0Var));
    }

    public final <U, R> b0<R> zipWith(h0<U> h0Var, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
        return zip(this, h0Var, cVar);
    }

    public static <T> s<T> concat(x<? extends h0<? extends T>> xVar) {
        h.c.n0.b.b.e(xVar, "sources is null");
        return h.c.r0.a.n(new h.c.n0.e.e.u(xVar, h.c.n0.e.g.h0.c(), 2, h.c.n0.j.i.IMMEDIATE));
    }

    public static <T> h<T> concatEager(Iterable<? extends h0<? extends T>> iterable) {
        return h.fromIterable(iterable).concatMapEager(h.c.n0.e.g.h0.b());
    }

    public static <T> b0<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return toSingle(h.fromFuture(future, j2, timeUnit));
    }

    public static <T> h<T> merge(k.a.b<? extends h0<? extends T>> bVar) {
        h.c.n0.b.b.e(bVar, "sources is null");
        return h.c.r0.a.l(new c1(bVar, h.c.n0.e.g.h0.b(), false, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, h.bufferSize()));
    }

    public static <T> h<T> mergeDelayError(k.a.b<? extends h0<? extends T>> bVar) {
        h.c.n0.b.b.e(bVar, "sources is null");
        return h.c.r0.a.l(new c1(bVar, h.c.n0.e.g.h0.b(), true, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, h.bufferSize()));
    }

    public static b0<Long> timer(long j2, TimeUnit timeUnit, a0 a0Var) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.o(new t0(j2, timeUnit, a0Var));
    }

    public static <T, U> b0<T> using(Callable<U> callable, h.c.m0.n<? super U, ? extends h0<? extends T>> nVar, h.c.m0.f<? super U> fVar, boolean z) {
        h.c.n0.b.b.e(callable, "resourceSupplier is null");
        h.c.n0.b.b.e(nVar, "singleFunction is null");
        h.c.n0.b.b.e(fVar, "disposer is null");
        return h.c.r0.a.o(new x0(callable, nVar, fVar, z));
    }

    public final b0<Boolean> contains(Object obj, h.c.m0.d<Object, Object> dVar) {
        h.c.n0.b.b.e(obj, "value is null");
        h.c.n0.b.b.e(dVar, "comparer is null");
        return h.c.r0.a.o(new h.c.n0.e.g.c(this, obj, dVar));
    }

    public final b0<T> delay(long j2, TimeUnit timeUnit, boolean z) {
        return delay(j2, timeUnit, h.c.u0.a.a(), z);
    }

    public final h<T> repeat(long j2) {
        return toFlowable().repeat(j2);
    }

    public final b0<T> retry(long j2) {
        return toSingle(toFlowable().retry(j2));
    }

    public final h.c.k0.b subscribe(h.c.m0.b<? super T, ? super Throwable> bVar) {
        h.c.n0.b.b.e(bVar, "onCallback is null");
        h.c.n0.d.d dVar = new h.c.n0.d.d(bVar);
        subscribe(dVar);
        return dVar;
    }

    public final b0<T> timeout(long j2, TimeUnit timeUnit, a0 a0Var) {
        return timeout0(j2, timeUnit, a0Var, null);
    }

    public static <T> b0<T> error(Throwable th) {
        h.c.n0.b.b.e(th, "exception is null");
        return error(h.c.n0.b.a.l(th));
    }

    public static <T> b0<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit, a0 a0Var) {
        return toSingle(h.fromFuture(future, j2, timeUnit, a0Var));
    }

    public final b0<T> delay(long j2, TimeUnit timeUnit, a0 a0Var) {
        return delay(j2, timeUnit, a0Var, false);
    }

    public final <U> b0<T> delaySubscription(h0<U> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return h.c.r0.a.o(new h.c.n0.e.g.j(this, h0Var));
    }

    public final b0<T> onErrorResumeNext(h.c.m0.n<? super Throwable, ? extends h0<? extends T>> nVar) {
        h.c.n0.b.b.e(nVar, "resumeFunctionInCaseOfError is null");
        return h.c.r0.a.o(new p0(this, nVar));
    }

    public final b0<T> retry(h.c.m0.d<? super Integer, ? super Throwable> dVar) {
        return toSingle(toFlowable().retry(dVar));
    }

    public final <E> b0<T> takeUntil(k.a.b<E> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return h.c.r0.a.o(new r0(this, bVar));
    }

    public final h.c.p0.g<T> test(boolean z) {
        h.c.p0.g<T> gVar = new h.c.p0.g<>();
        if (z) {
            gVar.cancel();
        }
        subscribe(gVar);
        return gVar;
    }

    public final b0<T> timeout(long j2, TimeUnit timeUnit, a0 a0Var, h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return timeout0(j2, timeUnit, a0Var, h0Var);
    }

    public static <T> h<T> concat(k.a.b<? extends h0<? extends T>> bVar) {
        return concat(bVar, 2);
    }

    public static <T> b0<T> fromFuture(Future<? extends T> future, a0 a0Var) {
        return toSingle(h.fromFuture(future, a0Var));
    }

    public static <T> b0<T> merge(h0<? extends h0<? extends T>> h0Var) {
        h.c.n0.b.b.e(h0Var, "source is null");
        return h.c.r0.a.o(new h.c.n0.e.g.x(h0Var, h.c.n0.b.a.j()));
    }

    public static <T> h<T> mergeDelayError(h0<? extends T> h0Var, h0<? extends T> h0Var2) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        return mergeDelayError(h.fromArray(h0Var, h0Var2));
    }

    public static <T1, T2, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h.c.m0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        return zipArray(h.c.n0.b.a.w(cVar), h0Var, h0Var2);
    }

    public final b0<T> delay(long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        h.c.n0.b.b.e(timeUnit, "unit is null");
        h.c.n0.b.b.e(a0Var, "scheduler is null");
        return h.c.r0.a.o(new h.c.n0.e.g.f(this, j2, timeUnit, a0Var, z));
    }

    public final b0<T> retry(long j2, h.c.m0.p<? super Throwable> pVar) {
        return toSingle(toFlowable().retry(j2, pVar));
    }

    public static <T> h<T> concat(k.a.b<? extends h0<? extends T>> bVar, int i2) {
        h.c.n0.b.b.e(bVar, "sources is null");
        h.c.n0.b.b.f(i2, "prefetch");
        return h.c.r0.a.l(new h.c.n0.e.b.y(bVar, h.c.n0.e.g.h0.b(), i2, h.c.n0.j.i.IMMEDIATE));
    }

    public final <U> b0<T> delaySubscription(x<U> xVar) {
        h.c.n0.b.b.e(xVar, "other is null");
        return h.c.r0.a.o(new h.c.n0.e.g.h(this, xVar));
    }

    public final b0<T> retry(h.c.m0.p<? super Throwable> pVar) {
        return toSingle(toFlowable().retry(pVar));
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar) {
        return subscribe(fVar, h.c.n0.b.a.f14099f);
    }

    public final <E> b0<T> takeUntil(h0<? extends E> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return takeUntil(new u0(h0Var));
    }

    public final b0<T> timeout(long j2, TimeUnit timeUnit, h0<? extends T> h0Var) {
        h.c.n0.b.b.e(h0Var, "other is null");
        return timeout0(j2, timeUnit, h.c.u0.a.a(), h0Var);
    }

    public static <T> h<T> merge(h0<? extends T> h0Var, h0<? extends T> h0Var2) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        return merge(h.fromArray(h0Var, h0Var2));
    }

    public final h.c.k0.b subscribe(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2) {
        h.c.n0.b.b.e(fVar, "onSuccess is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.d.k kVar = new h.c.n0.d.k(fVar, fVar2);
        subscribe(kVar);
        return kVar;
    }

    public static <T> h<T> mergeDelayError(h0<? extends T> h0Var, h0<? extends T> h0Var2, h0<? extends T> h0Var3) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        return mergeDelayError(h.fromArray(h0Var, h0Var2, h0Var3));
    }

    public static <T1, T2, T3, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h.c.m0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        return zipArray(h.c.n0.b.a.x(gVar), h0Var, h0Var2, h0Var3);
    }

    public final <U> b0<T> delaySubscription(k.a.b<U> bVar) {
        h.c.n0.b.b.e(bVar, "other is null");
        return h.c.r0.a.o(new h.c.n0.e.g.i(this, bVar));
    }

    public static <T> h<T> concat(h0<? extends T> h0Var, h0<? extends T> h0Var2) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        return concat(h.fromArray(h0Var, h0Var2));
    }

    public static <T> h<T> merge(h0<? extends T> h0Var, h0<? extends T> h0Var2, h0<? extends T> h0Var3) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        return merge(h.fromArray(h0Var, h0Var2, h0Var3));
    }

    public final b0<T> delaySubscription(long j2, TimeUnit timeUnit) {
        return delaySubscription(j2, timeUnit, h.c.u0.a.a());
    }

    public final b0<T> delaySubscription(long j2, TimeUnit timeUnit, a0 a0Var) {
        return delaySubscription(s.timer(j2, timeUnit, a0Var));
    }

    @Override // h.c.h0
    public final void subscribe(e0<? super T> e0Var) {
        h.c.n0.b.b.e(e0Var, "observer is null");
        e0<? super T> B = h.c.r0.a.B(this, e0Var);
        h.c.n0.b.b.e(B, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(B);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T> h<T> concat(h0<? extends T> h0Var, h0<? extends T> h0Var2, h0<? extends T> h0Var3) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        return concat(h.fromArray(h0Var, h0Var2, h0Var3));
    }

    public static <T> h<T> mergeDelayError(h0<? extends T> h0Var, h0<? extends T> h0Var2, h0<? extends T> h0Var3, h0<? extends T> h0Var4) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        return mergeDelayError(h.fromArray(h0Var, h0Var2, h0Var3, h0Var4));
    }

    public static <T1, T2, T3, T4, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h0<? extends T4> h0Var4, h.c.m0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        return zipArray(h.c.n0.b.a.y(hVar), h0Var, h0Var2, h0Var3, h0Var4);
    }

    public static <T> h<T> merge(h0<? extends T> h0Var, h0<? extends T> h0Var2, h0<? extends T> h0Var3, h0<? extends T> h0Var4) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        return merge(h.fromArray(h0Var, h0Var2, h0Var3, h0Var4));
    }

    public static <T> h<T> concat(h0<? extends T> h0Var, h0<? extends T> h0Var2, h0<? extends T> h0Var3, h0<? extends T> h0Var4) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        return concat(h.fromArray(h0Var, h0Var2, h0Var3, h0Var4));
    }

    public static <T1, T2, T3, T4, T5, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h0<? extends T4> h0Var4, h0<? extends T5> h0Var5, h.c.m0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        h.c.n0.b.b.e(h0Var5, "source5 is null");
        return zipArray(h.c.n0.b.a.z(iVar), h0Var, h0Var2, h0Var3, h0Var4, h0Var5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h0<? extends T4> h0Var4, h0<? extends T5> h0Var5, h0<? extends T6> h0Var6, h.c.m0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        h.c.n0.b.b.e(h0Var5, "source5 is null");
        h.c.n0.b.b.e(h0Var6, "source6 is null");
        return zipArray(h.c.n0.b.a.A(jVar), h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h0<? extends T4> h0Var4, h0<? extends T5> h0Var5, h0<? extends T6> h0Var6, h0<? extends T7> h0Var7, h.c.m0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        h.c.n0.b.b.e(h0Var5, "source5 is null");
        h.c.n0.b.b.e(h0Var6, "source6 is null");
        h.c.n0.b.b.e(h0Var7, "source7 is null");
        return zipArray(h.c.n0.b.a.B(kVar), h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h0<? extends T4> h0Var4, h0<? extends T5> h0Var5, h0<? extends T6> h0Var6, h0<? extends T7> h0Var7, h0<? extends T8> h0Var8, h.c.m0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        h.c.n0.b.b.e(h0Var5, "source5 is null");
        h.c.n0.b.b.e(h0Var6, "source6 is null");
        h.c.n0.b.b.e(h0Var7, "source7 is null");
        h.c.n0.b.b.e(h0Var8, "source8 is null");
        return zipArray(h.c.n0.b.a.C(lVar), h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7, h0Var8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> b0<R> zip(h0<? extends T1> h0Var, h0<? extends T2> h0Var2, h0<? extends T3> h0Var3, h0<? extends T4> h0Var4, h0<? extends T5> h0Var5, h0<? extends T6> h0Var6, h0<? extends T7> h0Var7, h0<? extends T8> h0Var8, h0<? extends T9> h0Var9, h.c.m0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        h.c.n0.b.b.e(h0Var, "source1 is null");
        h.c.n0.b.b.e(h0Var2, "source2 is null");
        h.c.n0.b.b.e(h0Var3, "source3 is null");
        h.c.n0.b.b.e(h0Var4, "source4 is null");
        h.c.n0.b.b.e(h0Var5, "source5 is null");
        h.c.n0.b.b.e(h0Var6, "source6 is null");
        h.c.n0.b.b.e(h0Var7, "source7 is null");
        h.c.n0.b.b.e(h0Var8, "source8 is null");
        h.c.n0.b.b.e(h0Var9, "source9 is null");
        return zipArray(h.c.n0.b.a.D(mVar), h0Var, h0Var2, h0Var3, h0Var4, h0Var5, h0Var6, h0Var7, h0Var8, h0Var9);
    }
}