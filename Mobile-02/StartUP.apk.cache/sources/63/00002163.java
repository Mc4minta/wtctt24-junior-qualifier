package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.signer.models.SignatureRequest;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.coinbase.walletlink.models.HostRequestId;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "Lcom/coinbase/wallet/features/signer/models/SignatureRequest;", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "notification", "", "firstIndex", "(Ljava/util/List;Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;)Ljava/lang/Integer;", "Lcom/coinbase/walletlink/models/HostRequestId;", "", "equalsNotification", "(Lcom/coinbase/walletlink/models/HostRequestId;Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;)Z", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean equalsNotification(HostRequestId hostRequestId, WalletLinkPushNotification walletLinkPushNotification) {
        return kotlin.jvm.internal.m.c(hostRequestId.getEventId(), walletLinkPushNotification.getEventId()) && kotlin.jvm.internal.m.c(hostRequestId.getUrl(), walletLinkPushNotification.getServerUrl()) && kotlin.jvm.internal.m.c(hostRequestId.getSessionId(), walletLinkPushNotification.getSessionId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer firstIndex(List<? extends SignatureRequest> list, WalletLinkPushNotification walletLinkPushNotification) {
        Iterator<? extends SignatureRequest> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            HostRequestId hostRequestId = it.next().getHostRequestId();
            if (hostRequestId == null ? false : equalsNotification(hostRequestId, walletLinkPushNotification)) {
                break;
            }
            i2++;
        }
        return Integer.valueOf(i2);
    }
}