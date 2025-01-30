package com.coinbase.wallet.di;

import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationsModule_ProvidesConsumerNotification$app_productionReleaseFactory implements f.c.d<Notification> {
    private final Provider<e.j.j.b> appPrefsProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;

    public NotificationsModule_ProvidesConsumerNotification$app_productionReleaseFactory(Provider<ConsumerUserRepository> provider, Provider<e.j.j.b> provider2, Provider<FeatureFlagsRepository> provider3) {
        this.consumerUserRepositoryProvider = provider;
        this.appPrefsProvider = provider2;
        this.featureFlagsRepositoryProvider = provider3;
    }

    public static NotificationsModule_ProvidesConsumerNotification$app_productionReleaseFactory create(Provider<ConsumerUserRepository> provider, Provider<e.j.j.b> provider2, Provider<FeatureFlagsRepository> provider3) {
        return new NotificationsModule_ProvidesConsumerNotification$app_productionReleaseFactory(provider, provider2, provider3);
    }

    public static Notification providesConsumerNotification$app_productionRelease(ConsumerUserRepository consumerUserRepository, e.j.j.b bVar, FeatureFlagsRepository featureFlagsRepository) {
        Notification providesConsumerNotification$app_productionRelease;
        providesConsumerNotification$app_productionRelease = NotificationsModule.Companion.providesConsumerNotification$app_productionRelease(consumerUserRepository, bVar, featureFlagsRepository);
        return (Notification) f.c.h.f(providesConsumerNotification$app_productionRelease);
    }

    @Override // javax.inject.Provider
    public Notification get() {
        return providesConsumerNotification$app_productionRelease(this.consumerUserRepositoryProvider.get(), this.appPrefsProvider.get(), this.featureFlagsRepositoryProvider.get());
    }
}