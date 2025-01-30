package com.coinbase.wallet.features.pushnotifications.interfaces;

import com.coinbase.wallet.features.pushnotifications.interfaces.PushNotification;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: PushNotificationCreator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J'\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotificationCreator;", "Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotification;", "T", "", "", "", "data", "create", "(Ljava/util/Map;)Lcom/coinbase/wallet/features/pushnotifications/interfaces/PushNotification;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface PushNotificationCreator<T extends PushNotification> {
    T create(Map<String, String> map);
}