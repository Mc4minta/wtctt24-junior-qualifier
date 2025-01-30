package com.coinbase.wallet.features.walletlink.repositories;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.pushnotifications.viewmodels.PushNotificationViewModel;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.HostRequest;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/walletlink/models/HostRequest;", "hostRequest", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/walletlink/models/HostRequest;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkRepository$handlePushNotification$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<HostRequest, kotlin.x> {
    final /* synthetic */ WalletLinkPushNotification $notification;
    final /* synthetic */ WalletLinkRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkRepository$handlePushNotification$1(WalletLinkRepository walletLinkRepository, WalletLinkPushNotification walletLinkPushNotification) {
        super(1);
        this.this$0 = walletLinkRepository;
        this.$notification = walletLinkPushNotification;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(HostRequest hostRequest) {
        invoke2(hostRequest);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HostRequest hostRequest) {
        Optional titleAndBodyFor;
        PushNotificationRepository pushNotificationRepository;
        kotlin.jvm.internal.m.g(hostRequest, "hostRequest");
        titleAndBodyFor = this.this$0.titleAndBodyFor(hostRequest);
        kotlin.o oVar = (kotlin.o) titleAndBodyFor.toNullable();
        if (oVar == null) {
            return;
        }
        Map<String, String> data = this.$notification.getData();
        PushNotificationViewModel pushNotificationViewModel = new PushNotificationViewModel(this.$notification.getChannelId(), (String) oVar.a(), (String) oVar.b(), data);
        pushNotificationRepository = this.this$0.pushNotificationRepository;
        pushNotificationRepository.displayNotification(pushNotificationViewModel);
    }
}