package com.coinbase.wallet.di;

import com.coinbase.wallet.application.BaseApplication;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: NotificationsModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class NotificationsModule$Companion$providesSecurityProviderPrompt$callToAction$1 extends o implements kotlin.e0.c.a<x> {
    final /* synthetic */ BaseApplication $appContext;
    final /* synthetic */ AtomicInteger $connectionStatusCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsModule$Companion$providesSecurityProviderPrompt$callToAction$1(BaseApplication baseApplication, AtomicInteger atomicInteger) {
        super(0);
        this.$appContext = baseApplication;
        this.$connectionStatusCode = atomicInteger;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ x invoke() {
        invoke2();
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.google.android.gms.common.e.o().q(this.$appContext, this.$connectionStatusCode.get());
    }
}