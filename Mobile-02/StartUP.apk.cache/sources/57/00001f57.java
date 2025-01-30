package com.coinbase.wallet.features.pushnotifications.services;

import android.content.Context;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PushNotificationDisplayService_Factory implements d<PushNotificationDisplayService> {
    private final Provider<Context> contextProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;

    public PushNotificationDisplayService_Factory(Provider<PushNotificationRepository> provider, Provider<Context> provider2) {
        this.pushNotificationRepositoryProvider = provider;
        this.contextProvider = provider2;
    }

    public static PushNotificationDisplayService_Factory create(Provider<PushNotificationRepository> provider, Provider<Context> provider2) {
        return new PushNotificationDisplayService_Factory(provider, provider2);
    }

    public static PushNotificationDisplayService newInstance(PushNotificationRepository pushNotificationRepository, Context context) {
        return new PushNotificationDisplayService(pushNotificationRepository, context);
    }

    @Override // javax.inject.Provider
    public PushNotificationDisplayService get() {
        return newInstance(this.pushNotificationRepositoryProvider.get(), this.contextProvider.get());
    }
}