package com.coinbase.wallet.common.extensions;

import com.uber.autodispose.w;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: MaybeSubscribeProxy+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "T", "Lcom/uber/autodispose/w;", "Lkotlin/Function1;", "", "Lkotlin/x;", "onError", "Lkotlin/Function0;", "onComplete", "onSuccess", "Lh/c/k0/b;", "subscribeBy", "(Lcom/uber/autodispose/w;Lkotlin/e0/c/l;Lkotlin/e0/c/a;Lkotlin/e0/c/l;)Lh/c/k0/b;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MaybeSubscribeProxy_CommonKt {
    public static final <T> h.c.k0.b subscribeBy(w<T> wVar, l<? super Throwable, x> onError, kotlin.e0.c.a<x> onComplete, l<? super T, x> onSuccess) {
        m.g(wVar, "<this>");
        m.g(onError, "onError");
        m.g(onComplete, "onComplete");
        m.g(onSuccess, "onSuccess");
        h.c.k0.b subscribe = wVar.subscribe(ObservableSubscribeProxy_CommonKt.asConsumer(onSuccess), ObservableSubscribeProxy_CommonKt.asOnErrorConsumer(onError), ObservableSubscribeProxy_CommonKt.asOnCompleteAction(onComplete));
        m.f(subscribe, "subscribe(onSuccess.asConsumer(), onError.asOnErrorConsumer(), onComplete.asOnCompleteAction())");
        return subscribe;
    }

    public static /* synthetic */ h.c.k0.b subscribeBy$default(w wVar, l lVar, kotlin.e0.c.a aVar, l lVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = ObservableSubscribeProxy_CommonKt.getOnErrorStub();
        }
        if ((i2 & 2) != 0) {
            aVar = ObservableSubscribeProxy_CommonKt.getOnCompleteStub();
        }
        if ((i2 & 4) != 0) {
            lVar2 = ObservableSubscribeProxy_CommonKt.getOnNextStub();
        }
        return subscribeBy(wVar, lVar, aVar, lVar2);
    }
}