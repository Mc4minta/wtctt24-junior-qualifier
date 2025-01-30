package com.coinbase.wallet.features.pushnotifications.repositories;

import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApi;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PushNotificationRepository_Factory implements f.c.d<PushNotificationRepository> {
    private final Provider<PushNotificationApi> apiProvider;
    private final Provider<StoreInterface> storeProvider;

    public PushNotificationRepository_Factory(Provider<PushNotificationApi> provider, Provider<StoreInterface> provider2) {
        this.apiProvider = provider;
        this.storeProvider = provider2;
    }

    public static PushNotificationRepository_Factory create(Provider<PushNotificationApi> provider, Provider<StoreInterface> provider2) {
        return new PushNotificationRepository_Factory(provider, provider2);
    }

    public static PushNotificationRepository newInstance(PushNotificationApi pushNotificationApi, StoreInterface storeInterface) {
        return new PushNotificationRepository(pushNotificationApi, storeInterface);
    }

    @Override // javax.inject.Provider
    public PushNotificationRepository get() {
        return newInstance(this.apiProvider.get(), this.storeProvider.get());
    }
}