package com.coinbase.wallet.application.service;

import kotlin.Metadata;
import kotlin.x;

/* compiled from: WalletFirebaseMessagingService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletFirebaseMessagingService$onNewToken$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, x> {
    final /* synthetic */ String $token;
    final /* synthetic */ WalletFirebaseMessagingService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletFirebaseMessagingService$onNewToken$2(WalletFirebaseMessagingService walletFirebaseMessagingService, String str) {
        super(1);
        this.this$0 = walletFirebaseMessagingService;
        this.$token = str;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        this.this$0.getPushNotificationRepository$app_productionRelease().onFCMTokenReceived(this.$token);
    }
}