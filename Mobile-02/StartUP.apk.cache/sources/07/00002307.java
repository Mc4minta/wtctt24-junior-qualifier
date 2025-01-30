package com.coinbase.wallet.features.walletlink.models;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.pushnotifications.interfaces.PushNotificationCreator;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: WalletLinkPushNotificationCreator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotificationCreator;", "Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotificationCreator;", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "", "", "data", "create", "(Ljava/util/Map;)Lcom/coinbase/wallet/features/walletlink/models/WalletLinkPushNotification;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkPushNotificationCreator implements PushNotificationCreator<WalletLinkPushNotification> {
    @Override // com.coinbase.wallet.features.pushnotifications.interfaces.PushNotificationCreator
    public /* bridge */ /* synthetic */ WalletLinkPushNotification create(Map map) {
        return create2((Map<String, String>) map);
    }

    @Override // com.coinbase.wallet.features.pushnotifications.interfaces.PushNotificationCreator
    /* renamed from: create  reason: avoid collision after fix types in other method */
    public WalletLinkPushNotification create2(Map<String, String> data) {
        String str;
        String str2;
        m.g(data, "data");
        String str3 = data.get(WalletLinkPushNotification.sessionIdKey);
        if (str3 == null || (str = data.get(WalletLinkPushNotification.eventIdKey)) == null || (str2 = data.get(WalletLinkPushNotification.serverUrlKey)) == null) {
            return null;
        }
        try {
            return new WalletLinkPushNotification(LocalizedStrings.INSTANCE.get(R.string.wallet_link_channel_id), str3, str, new URL(str2));
        } catch (Exception unused) {
            return null;
        }
    }
}