package com.coinbase.wallet.common.extensions;

import com.uber.autodispose.a0;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: SingleSubscribeProxy+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "T", "Lcom/uber/autodispose/a0;", "Lkotlin/Function1;", "", "Lkotlin/x;", "onError", "onSuccess", "Lh/c/k0/b;", "subscribeBy", "(Lcom/uber/autodispose/a0;Lkotlin/e0/c/l;Lkotlin/e0/c/l;)Lh/c/k0/b;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SingleSubscribeProxy_CommonKt {
    public static final <T> h.c.k0.b subscribeBy(a0<T> a0Var, l<? super Throwable, x> onError, l<? super T, x> onSuccess) {
        m.g(a0Var, "<this>");
        m.g(onError, "onError");
        m.g(onSuccess, "onSuccess");
        h.c.k0.b subscribe = a0Var.subscribe(ObservableSubscribeProxy_CommonKt.asConsumer(onSuccess), ObservableSubscribeProxy_CommonKt.asOnErrorConsumer(onError));
        m.f(subscribe, "subscribe(onSuccess.asConsumer(), onError.asOnErrorConsumer())");
        return subscribe;
    }

    public static /* synthetic */ h.c.k0.b subscribeBy$default(a0 a0Var, l lVar, l lVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = ObservableSubscribeProxy_CommonKt.getOnErrorStub();
        }
        if ((i2 & 2) != 0) {
            lVar2 = ObservableSubscribeProxy_CommonKt.getOnNextStub();
        }
        return subscribeBy(a0Var, lVar, lVar2);
    }
}