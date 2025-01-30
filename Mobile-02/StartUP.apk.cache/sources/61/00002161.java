package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.signer.models.SignatureRequest;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.HostRequestId;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "kotlin.jvm.PlatformType", "notification", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewModel$observePushNotifications$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<WalletLinkPushNotification, x> {
    final /* synthetic */ SignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignerViewModel$observePushNotifications$1(SignerViewModel signerViewModel) {
        super(1);
        this.this$0 = signerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(WalletLinkPushNotification walletLinkPushNotification) {
        invoke2(walletLinkPushNotification);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(WalletLinkPushNotification notification) {
        List list;
        Integer firstIndex;
        List list2;
        h.c.v0.c cVar;
        List list3;
        List list4;
        List list5;
        boolean equalsNotification;
        l.a.a.a(kotlin.jvm.internal.m.o("[signer] push notification ", notification), new Object[0]);
        this.this$0.pushNotificationRequest = notification;
        SignatureRequest currentRequest = this.this$0.getCurrentRequest();
        HostRequestId hostRequestId = currentRequest == null ? null : currentRequest.getHostRequestId();
        if (hostRequestId != null) {
            kotlin.jvm.internal.m.f(notification, "notification");
            equalsNotification = SignerViewModelKt.equalsNotification(hostRequestId, notification);
            if (equalsNotification) {
                this.this$0.pushNotificationRequest = null;
                return;
            }
        }
        list = this.this$0.signatureRequests;
        kotlin.jvm.internal.m.f(notification, "notification");
        firstIndex = SignerViewModelKt.firstIndex(list, notification);
        if (firstIndex == null || firstIndex.intValue() == 0) {
            return;
        }
        SignerViewModel signerViewModel = this.this$0;
        int intValue = firstIndex.intValue();
        list2 = signerViewModel.signatureRequests;
        SignatureRequest signatureRequest = (SignatureRequest) kotlin.a0.p.b0(list2, intValue);
        if (signatureRequest == null) {
            return;
        }
        try {
            list3 = this.this$0.signatureRequests;
            list3.remove(firstIndex.intValue());
            list4 = this.this$0.signatureRequests;
            list4.add(0, signatureRequest);
            SignatureRequest currentRequest2 = this.this$0.getCurrentRequest();
            if (currentRequest2 != null) {
                list5 = this.this$0.signatureRequests;
                list5.add(1, currentRequest2);
            }
        } finally {
            cVar = this.this$0.presentNextRequestSubject;
            cVar.onNext(Boolean.valueOf(this.this$0.getCurrentRequest() != null));
        }
    }
}