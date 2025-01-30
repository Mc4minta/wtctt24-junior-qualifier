package com.coinbase.wallet.core.extensions;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.ReplayingShare;
import h.c.m0.p;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlin.x;

/* compiled from: Observable+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0001H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0012\u0010\b\u001a1\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"T", "Lh/c/s;", "Lh/c/b0;", "takeSingle", "(Lh/c/s;)Lh/c/b0;", "", "Lcom/coinbase/wallet/core/util/Optional;", "unwrap", "(Lh/c/s;)Lh/c/s;", "", "maxAttempts", "Lkotlin/Function1;", "", "", "shouldRetry", "retryIfNeeded", "(Lh/c/s;ILkotlin/e0/c/l;)Lh/c/s;", "Lkotlin/x;", "asUnit", "defaultValue", "replayingShare", "(Lh/c/s;Ljava/lang/Object;)Lh/c/s;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Observable_CoreKt {
    public static final <T> s<x> asUnit(s<T> sVar) {
        kotlin.jvm.internal.m.g(sVar, "<this>");
        s map = sVar.map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Observable_CoreKt.c(obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "this.map { Unit }");
        return map;
    }

    /* renamed from: asUnit$lambda-3 */
    public static final x m1055asUnit$lambda3(Object obj) {
        return x.a;
    }

    public static /* synthetic */ x b(b0 b0Var, int i2, kotlin.e0.c.l lVar, kotlin.o oVar) {
        return m1058retryIfNeeded$lambda2$lambda1(b0Var, i2, lVar, oVar);
    }

    public static /* synthetic */ x c(Object obj) {
        return m1055asUnit$lambda3(obj);
    }

    public static /* synthetic */ kotlin.o d(b0 b0Var, Throwable th) {
        return m1057retryIfNeeded$lambda2$lambda0(b0Var, th);
    }

    public static final <T> s<T> replayingShare(s<T> sVar) {
        kotlin.jvm.internal.m.g(sVar, "<this>");
        return replayingShare$default(sVar, null, 1, null);
    }

    public static final <T> s<T> replayingShare(s<T> sVar, T t) {
        kotlin.jvm.internal.m.g(sVar, "<this>");
        s<T> sVar2 = (s<T>) sVar.compose(ReplayingShare.Companion.create(t));
        kotlin.jvm.internal.m.f(sVar2, "compose(ReplayingShare.create(defaultValue))");
        return sVar2;
    }

    public static /* synthetic */ s replayingShare$default(s sVar, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return replayingShare(sVar, obj);
    }

    public static final <T> s<T> retryIfNeeded(s<T> sVar, final int i2, final kotlin.e0.c.l<? super Throwable, Boolean> shouldRetry) {
        kotlin.jvm.internal.m.g(sVar, "<this>");
        kotlin.jvm.internal.m.g(shouldRetry, "shouldRetry");
        s<T> retryWhen = sVar.retryWhen(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.x m1056retryIfNeeded$lambda2;
                m1056retryIfNeeded$lambda2 = Observable_CoreKt.m1056retryIfNeeded$lambda2(i2, shouldRetry, (s) obj);
                return m1056retryIfNeeded$lambda2;
            }
        });
        kotlin.jvm.internal.m.f(retryWhen, "this\n    .retryWhen { errors ->\n        var count = 0\n\n        errors\n            .map { Pair(count, it) }\n            .map { (attempt, error) ->\n                count++\n                if (maxAttempts == attempt + 1 || !shouldRetry(error)) {\n                    throw error\n                }\n\n                Unit\n            }\n    }");
        return retryWhen;
    }

    /* renamed from: retryIfNeeded$lambda-2 */
    public static final h.c.x m1056retryIfNeeded$lambda2(final int i2, final kotlin.e0.c.l shouldRetry, s errors) {
        kotlin.jvm.internal.m.g(shouldRetry, "$shouldRetry");
        kotlin.jvm.internal.m.g(errors, "errors");
        final b0 b0Var = new b0();
        return errors.map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Observable_CoreKt.d(b0.this, (Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return Observable_CoreKt.b(b0.this, i2, shouldRetry, (kotlin.o) obj);
            }
        });
    }

    /* renamed from: retryIfNeeded$lambda-2$lambda-0 */
    public static final kotlin.o m1057retryIfNeeded$lambda2$lambda0(b0 count, Throwable it) {
        kotlin.jvm.internal.m.g(count, "$count");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(Integer.valueOf(count.a), it);
    }

    /* renamed from: retryIfNeeded$lambda-2$lambda-1 */
    public static final x m1058retryIfNeeded$lambda2$lambda1(b0 count, int i2, kotlin.e0.c.l shouldRetry, kotlin.o dstr$attempt$error) {
        kotlin.jvm.internal.m.g(count, "$count");
        kotlin.jvm.internal.m.g(shouldRetry, "$shouldRetry");
        kotlin.jvm.internal.m.g(dstr$attempt$error, "$dstr$attempt$error");
        int intValue = ((Number) dstr$attempt$error.a()).intValue();
        Throwable error = (Throwable) dstr$attempt$error.b();
        count.a++;
        if (i2 != intValue + 1) {
            kotlin.jvm.internal.m.f(error, "error");
            if (((Boolean) shouldRetry.invoke(error)).booleanValue()) {
                return x.a;
            }
        }
        kotlin.jvm.internal.m.f(error, "error");
        throw error;
    }

    public static final <T> h.c.b0<T> takeSingle(s<T> sVar) {
        kotlin.jvm.internal.m.g(sVar, "<this>");
        h.c.b0<T> singleOrError = sVar.take(1L).singleOrError();
        kotlin.jvm.internal.m.f(singleOrError, "this.take(1).singleOrError()");
        return singleOrError;
    }

    public static final /* synthetic */ <T> s<T> unwrap(s<Optional<T>> sVar) {
        kotlin.jvm.internal.m.g(sVar, "<this>");
        s<T> sVar2 = (s<T>) sVar.filter(new p() { // from class: com.coinbase.wallet.core.extensions.Observable_CoreKt$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.core.extensions.Observable_CoreKt$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(sVar2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return sVar2;
    }
}