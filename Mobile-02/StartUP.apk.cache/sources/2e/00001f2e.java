package com.coinbase.wallet.features.pushnotifications.apis;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PushNotificationApi_Factory implements f.c.d<PushNotificationApi> {
    private final Provider<PushNotificationApiInterface> apiProvider;

    public PushNotificationApi_Factory(Provider<PushNotificationApiInterface> provider) {
        this.apiProvider = provider;
    }

    public static PushNotificationApi_Factory create(Provider<PushNotificationApiInterface> provider) {
        return new PushNotificationApi_Factory(provider);
    }

    public static PushNotificationApi newInstance(PushNotificationApiInterface pushNotificationApiInterface) {
        return new PushNotificationApi(pushNotificationApiInterface);
    }

    @Override // javax.inject.Provider
    public PushNotificationApi get() {
        return newInstance(this.apiProvider.get());
    }
}