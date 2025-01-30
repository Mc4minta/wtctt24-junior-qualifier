package com.coinbase.wallet.core.extensions;

import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import h.c.b0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: Single+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00018\u00008\u0000 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0004\b\u0018\u0010\u0019\u001aO\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0004\b\u001a\u0010\u001b\u001a;\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c*\b\u0012\u0004\u0012\u00020\u00150\u001c2\u0006\u0010\r\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"T", "Lh/c/b0;", "Lcom/coinbase/wallet/core/models/TraceKey;", "traceKey", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "kotlin.jvm.PlatformType", "trace", "(Lh/c/b0;Lcom/coinbase/wallet/core/models/TraceKey;Lcom/coinbase/wallet/core/interfaces/Tracing;)Lh/c/b0;", "Lkotlin/x;", "asUnit", "(Lh/c/b0;)Lh/c/b0;", "", "maxAttempts", "delay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "retryWithDelay", "(Lh/c/b0;JJLjava/util/concurrent/TimeUnit;)Lh/c/b0;", "", "Lkotlin/Function1;", "", "", "shouldRetry", "retryIfNeeded", "(Lh/c/b0;ILkotlin/e0/c/l;)Lh/c/b0;", "retryWithBackoffDelay", "(Lh/c/b0;IJLjava/util/concurrent/TimeUnit;Lkotlin/e0/c/l;)Lh/c/b0;", "Lh/c/h;", "retryHandler", "(Lh/c/h;ILkotlin/e0/c/l;)Lh/c/h;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Single_CoreKt {
    public static /* synthetic */ void a(Tracing tracing, TraceKey traceKey, h.c.k0.b bVar) {
        m1068trace$lambda0(tracing, traceKey, bVar);
    }

    public static final <T> b0<x> asUnit(b0<T> b0Var) {
        kotlin.jvm.internal.m.g(b0Var, "<this>");
        b0 map = b0Var.map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Single_CoreKt.k(obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "this.map { Unit }");
        return map;
    }

    /* renamed from: asUnit$lambda-2 */
    public static final x m1059asUnit$lambda2(Object obj) {
        return x.a;
    }

    public static /* synthetic */ Integer b(kotlin.jvm.internal.b0 b0Var, int i2, kotlin.e0.c.l lVar, kotlin.o oVar) {
        return m1060retryHandler$lambda10(b0Var, i2, lVar, oVar);
    }

    public static /* synthetic */ k.a.b d(long j2, TimeUnit timeUnit, Integer num) {
        return m1065retryWithBackoffDelay$lambda8$lambda7(j2, timeUnit, num);
    }

    public static /* synthetic */ x e(Long l2) {
        return m1066retryWithBackoffDelay$lambda8$lambda7$lambda6(l2);
    }

    public static /* synthetic */ x g(Integer num) {
        return m1063retryIfNeeded$lambda5$lambda4(num);
    }

    public static /* synthetic */ kotlin.o h(kotlin.jvm.internal.b0 b0Var, Throwable th) {
        return m1061retryHandler$lambda9(b0Var, th);
    }

    public static /* synthetic */ void i(Tracing tracing, TraceKey traceKey) {
        m1069trace$lambda1(tracing, traceKey);
    }

    public static /* synthetic */ x k(Object obj) {
        return m1059asUnit$lambda2(obj);
    }

    private static final h.c.h<Integer> retryHandler(h.c.h<Throwable> hVar, final int i2, final kotlin.e0.c.l<? super Throwable, Boolean> lVar) {
        final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        h.c.h<Integer> map = hVar.map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Single_CoreKt.h(kotlin.jvm.internal.b0.this, (Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Single_CoreKt.b(kotlin.jvm.internal.b0.this, i2, lVar, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n        .map { Pair(count, it) }\n        .map { (attempt, error) ->\n            count++\n            if (maxAttempts == attempt + 1 || !shouldRetry(error)) {\n                throw error\n            }\n\n            attempt\n        }");
        return map;
    }

    /* renamed from: retryHandler$lambda-10 */
    public static final Integer m1060retryHandler$lambda10(kotlin.jvm.internal.b0 count, int i2, kotlin.e0.c.l shouldRetry, kotlin.o dstr$attempt$error) {
        kotlin.jvm.internal.m.g(count, "$count");
        kotlin.jvm.internal.m.g(shouldRetry, "$shouldRetry");
        kotlin.jvm.internal.m.g(dstr$attempt$error, "$dstr$attempt$error");
        int intValue = ((Number) dstr$attempt$error.a()).intValue();
        Throwable error = (Throwable) dstr$attempt$error.b();
        count.a++;
        if (i2 != intValue + 1) {
            kotlin.jvm.internal.m.f(error, "error");
            if (((Boolean) shouldRetry.invoke(error)).booleanValue()) {
                return Integer.valueOf(intValue);
            }
        }
        kotlin.jvm.internal.m.f(error, "error");
        throw error;
    }

    /* renamed from: retryHandler$lambda-9 */
    public static final kotlin.o m1061retryHandler$lambda9(kotlin.jvm.internal.b0 count, Throwable it) {
        kotlin.jvm.internal.m.g(count, "$count");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(Integer.valueOf(count.a), it);
    }

    public static final <T> b0<T> retryIfNeeded(b0<T> b0Var, final int i2, final kotlin.e0.c.l<? super Throwable, Boolean> shouldRetry) {
        kotlin.jvm.internal.m.g(b0Var, "<this>");
        kotlin.jvm.internal.m.g(shouldRetry, "shouldRetry");
        b0<T> retryWhen = b0Var.retryWhen(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                k.a.b m1062retryIfNeeded$lambda5;
                m1062retryIfNeeded$lambda5 = Single_CoreKt.m1062retryIfNeeded$lambda5(i2, shouldRetry, (h.c.h) obj);
                return m1062retryIfNeeded$lambda5;
            }
        });
        kotlin.jvm.internal.m.f(retryWhen, "this\n    .retryWhen { errors -> errors.retryHandler(maxAttempts, shouldRetry).map { Unit } }");
        return retryWhen;
    }

    /* renamed from: retryIfNeeded$lambda-5 */
    public static final k.a.b m1062retryIfNeeded$lambda5(int i2, kotlin.e0.c.l shouldRetry, h.c.h errors) {
        kotlin.jvm.internal.m.g(shouldRetry, "$shouldRetry");
        kotlin.jvm.internal.m.g(errors, "errors");
        return retryHandler(errors, i2, shouldRetry).map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Single_CoreKt.g((Integer) obj);
            }
        });
    }

    /* renamed from: retryIfNeeded$lambda-5$lambda-4 */
    public static final x m1063retryIfNeeded$lambda5$lambda4(Integer it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static final <T> b0<T> retryWithBackoffDelay(b0<T> b0Var, final int i2, final long j2, final TimeUnit timeUnit, final kotlin.e0.c.l<? super Throwable, Boolean> shouldRetry) {
        kotlin.jvm.internal.m.g(b0Var, "<this>");
        kotlin.jvm.internal.m.g(timeUnit, "timeUnit");
        kotlin.jvm.internal.m.g(shouldRetry, "shouldRetry");
        b0<T> retryWhen = b0Var.retryWhen(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                k.a.b m1064retryWithBackoffDelay$lambda8;
                m1064retryWithBackoffDelay$lambda8 = Single_CoreKt.m1064retryWithBackoffDelay$lambda8(i2, shouldRetry, j2, timeUnit, (h.c.h) obj);
                return m1064retryWithBackoffDelay$lambda8;
            }
        });
        kotlin.jvm.internal.m.f(retryWhen, "this.retryWhen { errors ->\n    errors.retryHandler(maxAttempts, shouldRetry)\n        .flatMap { attempt -> Flowable.timer((attempt + 1) * delay, timeUnit).map { Unit } }\n}");
        return retryWhen;
    }

    /* renamed from: retryWithBackoffDelay$lambda-8 */
    public static final k.a.b m1064retryWithBackoffDelay$lambda8(int i2, kotlin.e0.c.l shouldRetry, final long j2, final TimeUnit timeUnit, h.c.h errors) {
        kotlin.jvm.internal.m.g(shouldRetry, "$shouldRetry");
        kotlin.jvm.internal.m.g(timeUnit, "$timeUnit");
        kotlin.jvm.internal.m.g(errors, "errors");
        return retryHandler(errors, i2, shouldRetry).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Single_CoreKt.d(j2, timeUnit, (Integer) obj);
            }
        });
    }

    /* renamed from: retryWithBackoffDelay$lambda-8$lambda-7 */
    public static final k.a.b m1065retryWithBackoffDelay$lambda8$lambda7(long j2, TimeUnit timeUnit, Integer attempt) {
        kotlin.jvm.internal.m.g(timeUnit, "$timeUnit");
        kotlin.jvm.internal.m.g(attempt, "attempt");
        return h.c.h.timer((attempt.intValue() + 1) * j2, timeUnit).map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Single_CoreKt.e((Long) obj);
            }
        });
    }

    /* renamed from: retryWithBackoffDelay$lambda-8$lambda-7$lambda-6 */
    public static final x m1066retryWithBackoffDelay$lambda8$lambda7$lambda6(Long it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static final <T> b0<T> retryWithDelay(b0<T> b0Var, final long j2, final long j3, final TimeUnit timeUnit) {
        kotlin.jvm.internal.m.g(b0Var, "<this>");
        kotlin.jvm.internal.m.g(timeUnit, "timeUnit");
        b0<T> retryWhen = b0Var.retryWhen(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                k.a.b m1067retryWithDelay$lambda3;
                m1067retryWithDelay$lambda3 = Single_CoreKt.m1067retryWithDelay$lambda3(j2, j3, timeUnit, (h.c.h) obj);
                return m1067retryWithDelay$lambda3;
            }
        });
        kotlin.jvm.internal.m.f(retryWhen, "this.retryWhen { it.take(maxAttempts).delay(delay, timeUnit) }");
        return retryWhen;
    }

    /* renamed from: retryWithDelay$lambda-3 */
    public static final k.a.b m1067retryWithDelay$lambda3(long j2, long j3, TimeUnit timeUnit, h.c.h it) {
        kotlin.jvm.internal.m.g(timeUnit, "$timeUnit");
        kotlin.jvm.internal.m.g(it, "it");
        return it.take(j2).delay(j3, timeUnit);
    }

    public static final <T> b0<T> trace(b0<T> b0Var, final TraceKey traceKey, final Tracing tracer) {
        kotlin.jvm.internal.m.g(b0Var, "<this>");
        kotlin.jvm.internal.m.g(traceKey, "traceKey");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        return b0Var.doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.core.extensions.e
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Single_CoreKt.a(Tracing.this, traceKey, (h.c.k0.b) obj);
            }
        }).doFinally(new h.c.m0.a() { // from class: com.coinbase.wallet.core.extensions.m
            @Override // h.c.m0.a
            public final void run() {
                Single_CoreKt.i(Tracing.this, traceKey);
            }
        });
    }

    /* renamed from: trace$lambda-0 */
    public static final void m1068trace$lambda0(Tracing tracer, TraceKey traceKey, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(tracer, "$tracer");
        kotlin.jvm.internal.m.g(traceKey, "$traceKey");
        tracer.start(traceKey);
    }

    /* renamed from: trace$lambda-1 */
    public static final void m1069trace$lambda1(Tracing tracer, TraceKey traceKey) {
        kotlin.jvm.internal.m.g(tracer, "$tracer");
        kotlin.jvm.internal.m.g(traceKey, "$traceKey");
        tracer.stop(traceKey);
    }
}