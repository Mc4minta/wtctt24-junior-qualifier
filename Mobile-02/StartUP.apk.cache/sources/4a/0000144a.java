package com.coinbase.wallet.common.extensions;

import com.uber.autodispose.s;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: CompleteSubscribeProxy+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/uber/autodispose/s;", "Lkotlin/Function1;", "", "Lkotlin/x;", "onError", "Lkotlin/Function0;", "onComplete", "Lh/c/k0/b;", "subscribeBy", "(Lcom/uber/autodispose/s;Lkotlin/e0/c/l;Lkotlin/e0/c/a;)Lh/c/k0/b;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompleteSubscribeProxy_CommonKt {
    public static /* synthetic */ void a(kotlin.e0.c.a aVar) {
        m786subscribeBy$lambda0(aVar);
    }

    public static /* synthetic */ void b(l lVar, Throwable th) {
        m787subscribeBy$lambda1(lVar, th);
    }

    public static final h.c.k0.b subscribeBy(s sVar, final l<? super Throwable, x> onError, final kotlin.e0.c.a<x> onComplete) {
        m.g(sVar, "<this>");
        m.g(onError, "onError");
        m.g(onComplete, "onComplete");
        if (onError == ObservableSubscribeProxy_CommonKt.getOnErrorStub() && onComplete == ObservableSubscribeProxy_CommonKt.getOnCompleteStub()) {
            h.c.k0.b subscribe = sVar.subscribe();
            m.f(subscribe, "subscribe()");
            return subscribe;
        } else if (onError == ObservableSubscribeProxy_CommonKt.getOnErrorStub()) {
            h.c.k0.b d2 = sVar.d(new h.c.m0.a() { // from class: com.coinbase.wallet.common.extensions.a
                @Override // h.c.m0.a
                public final void run() {
                    CompleteSubscribeProxy_CommonKt.a(kotlin.e0.c.a.this);
                }
            });
            m.f(d2, "subscribe(onComplete)");
            return d2;
        } else {
            h.c.k0.b b2 = sVar.b(ObservableSubscribeProxy_CommonKt.asOnCompleteAction(onComplete), new h.c.m0.f() { // from class: com.coinbase.wallet.common.extensions.b
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    CompleteSubscribeProxy_CommonKt.b(l.this, (Throwable) obj);
                }
            });
            m.f(b2, "subscribe(onComplete.asOnCompleteAction(), Consumer(onError))");
            return b2;
        }
    }

    public static /* synthetic */ h.c.k0.b subscribeBy$default(s sVar, l lVar, kotlin.e0.c.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = ObservableSubscribeProxy_CommonKt.getOnErrorStub();
        }
        if ((i2 & 2) != 0) {
            aVar = ObservableSubscribeProxy_CommonKt.getOnCompleteStub();
        }
        return subscribeBy(sVar, lVar, aVar);
    }

    /* renamed from: subscribeBy$lambda-0 */
    public static final void m786subscribeBy$lambda0(kotlin.e0.c.a tmp0) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* renamed from: subscribeBy$lambda-1 */
    public static final void m787subscribeBy$lambda1(l tmp0, Throwable th) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke(th);
    }
}