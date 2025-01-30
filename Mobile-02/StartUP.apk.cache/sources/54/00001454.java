package com.coinbase.wallet.common.extensions;

import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: ObservableSubscribeProxy+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\u0006\u001a\u0017\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u000b\u0010\f\u001a_\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\"%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"%\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"", "T", "Lkotlin/Function1;", "Lkotlin/x;", "Lh/c/m0/f;", "asConsumer", "(Lkotlin/e0/c/l;)Lh/c/m0/f;", "", "asOnErrorConsumer", "Lkotlin/Function0;", "Lh/c/m0/a;", "asOnCompleteAction", "(Lkotlin/e0/c/a;)Lh/c/m0/a;", "Lcom/uber/autodispose/x;", "onError", "onComplete", "onNext", "Lh/c/k0/b;", "subscribeBy", "(Lcom/uber/autodispose/x;Lkotlin/e0/c/l;Lkotlin/e0/c/a;Lkotlin/e0/c/l;)Lh/c/k0/b;", "onNextStub", "Lkotlin/e0/c/l;", "getOnNextStub", "()Lkotlin/e0/c/l;", "onCompleteStub", "Lkotlin/e0/c/a;", "getOnCompleteStub", "()Lkotlin/e0/c/a;", "onErrorStub", "getOnErrorStub", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ObservableSubscribeProxy_CommonKt {
    private static final l<Object, x> onNextStub = ObservableSubscribeProxy_CommonKt$onNextStub$1.INSTANCE;
    private static final l<Throwable, x> onErrorStub = ObservableSubscribeProxy_CommonKt$onErrorStub$1.INSTANCE;
    private static final kotlin.e0.c.a<x> onCompleteStub = ObservableSubscribeProxy_CommonKt$onCompleteStub$1.INSTANCE;

    public static /* synthetic */ void a(l lVar, Throwable th) {
        m790asOnErrorConsumer$lambda1(lVar, th);
    }

    public static final <T> h.c.m0.f<T> asConsumer(final l<? super T, x> lVar) {
        m.g(lVar, "<this>");
        if (lVar == onNextStub) {
            h.c.m0.f<T> h2 = h.c.n0.b.a.h();
            m.f(h2, "emptyConsumer()");
            return h2;
        }
        return new h.c.m0.f() { // from class: com.coinbase.wallet.common.extensions.e
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ObservableSubscribeProxy_CommonKt.c(l.this, obj);
            }
        };
    }

    /* renamed from: asConsumer$lambda-0 */
    public static final void m788asConsumer$lambda0(l tmp0, Object obj) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final h.c.m0.a asOnCompleteAction(final kotlin.e0.c.a<x> aVar) {
        m.g(aVar, "<this>");
        if (aVar == onCompleteStub) {
            h.c.m0.a EMPTY_ACTION = h.c.n0.b.a.f14096c;
            m.f(EMPTY_ACTION, "EMPTY_ACTION");
            return EMPTY_ACTION;
        }
        return new h.c.m0.a() { // from class: com.coinbase.wallet.common.extensions.d
            @Override // h.c.m0.a
            public final void run() {
                ObservableSubscribeProxy_CommonKt.b(kotlin.e0.c.a.this);
            }
        };
    }

    /* renamed from: asOnCompleteAction$lambda-2 */
    public static final void m789asOnCompleteAction$lambda2(kotlin.e0.c.a tmp0) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final h.c.m0.f<Throwable> asOnErrorConsumer(final l<? super Throwable, x> lVar) {
        m.g(lVar, "<this>");
        if (lVar == onErrorStub) {
            h.c.m0.f<Throwable> ON_ERROR_MISSING = h.c.n0.b.a.f14099f;
            m.f(ON_ERROR_MISSING, "ON_ERROR_MISSING");
            return ON_ERROR_MISSING;
        }
        return new h.c.m0.f() { // from class: com.coinbase.wallet.common.extensions.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                ObservableSubscribeProxy_CommonKt.a(l.this, (Throwable) obj);
            }
        };
    }

    /* renamed from: asOnErrorConsumer$lambda-1 */
    public static final void m790asOnErrorConsumer$lambda1(l tmp0, Throwable th) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke(th);
    }

    public static /* synthetic */ void b(kotlin.e0.c.a aVar) {
        m789asOnCompleteAction$lambda2(aVar);
    }

    public static /* synthetic */ void c(l lVar, Object obj) {
        m788asConsumer$lambda0(lVar, obj);
    }

    public static final kotlin.e0.c.a<x> getOnCompleteStub() {
        return onCompleteStub;
    }

    public static final l<Throwable, x> getOnErrorStub() {
        return onErrorStub;
    }

    public static final l<Object, x> getOnNextStub() {
        return onNextStub;
    }

    public static final <T> h.c.k0.b subscribeBy(com.uber.autodispose.x<T> xVar, l<? super Throwable, x> onError, kotlin.e0.c.a<x> onComplete, l<? super T, x> onNext) {
        m.g(xVar, "<this>");
        m.g(onError, "onError");
        m.g(onComplete, "onComplete");
        m.g(onNext, "onNext");
        h.c.k0.b subscribe = xVar.subscribe(asConsumer(onNext), asOnErrorConsumer(onError), asOnCompleteAction(onComplete));
        m.f(subscribe, "subscribe(onNext.asConsumer(), onError.asOnErrorConsumer(), onComplete.asOnCompleteAction())");
        return subscribe;
    }

    public static /* synthetic */ h.c.k0.b subscribeBy$default(com.uber.autodispose.x xVar, l lVar, kotlin.e0.c.a aVar, l lVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = onErrorStub;
        }
        if ((i2 & 2) != 0) {
            aVar = onCompleteStub;
        }
        if ((i2 & 4) != 0) {
            lVar2 = onNextStub;
        }
        return subscribeBy(xVar, lVar, aVar, lVar2);
    }
}