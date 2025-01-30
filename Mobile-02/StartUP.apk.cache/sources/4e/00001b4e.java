package com.coinbase.wallet.di;

import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationsModule_ProvidesConsumerOnrampNotification$app_productionReleaseFactory implements f.c.d<Notification> {
    private final Provider<e.j.j.b> appPrefsProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;

    public NotificationsModule_ProvidesConsumerOnrampNotification$app_productionReleaseFactory(Provider<ConsumerUserRepository> provider, Provider<e.j.j.b> provider2, Provider<FeatureFlagsRepository> provider3) {
        this.consumerUserRepositoryProvider = provider;
        this.appPrefsProvider = provider2;
        this.featureFlagsRepositoryProvider = provider3;
    }

    public static NotificationsModule_ProvidesConsumerOnrampNotification$app_productionReleaseFactory create(Provider<ConsumerUserRepository> provider, Provider<e.j.j.b> provider2, Provider<FeatureFlagsRepository> provider3) {
        return new NotificationsModule_ProvidesConsumerOnrampNotification$app_productionReleaseFactory(provider, provider2, provider3);
    }

    public static Notification providesConsumerOnrampNotification$app_productionRelease(ConsumerUserRepository consumerUserRepository, e.j.j.b bVar, FeatureFlagsRepository featureFlagsRepository) {
        Notification providesConsumerOnrampNotification$app_productionRelease;
        providesConsumerOnrampNotification$app_productionRelease = NotificationsModule.Companion.providesConsumerOnrampNotification$app_productionRelease(consumerUserRepository, bVar, featureFlagsRepository);
        return (Notification) f.c.h.f(providesConsumerOnrampNotification$app_productionRelease);
    }

    @Override // javax.inject.Provider
    public Notification get() {
        return providesConsumerOnrampNotification$app_productionRelease(this.consumerUserRepositoryProvider.get(), this.appPrefsProvider.get(), this.featureFlagsRepositoryProvider.get());
    }
}