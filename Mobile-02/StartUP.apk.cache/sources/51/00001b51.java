package com.coinbase.wallet.di;

import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationsModule_ProvidesSwapTOSNotification$app_productionReleaseFactory implements f.c.d<Notification> {
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private final Provider<e.j.j.b> prefsProvider;

    public NotificationsModule_ProvidesSwapTOSNotification$app_productionReleaseFactory(Provider<FeatureFlagsRepository> provider, Provider<e.j.j.b> provider2) {
        this.featureFlagsRepositoryProvider = provider;
        this.prefsProvider = provider2;
    }

    public static NotificationsModule_ProvidesSwapTOSNotification$app_productionReleaseFactory create(Provider<FeatureFlagsRepository> provider, Provider<e.j.j.b> provider2) {
        return new NotificationsModule_ProvidesSwapTOSNotification$app_productionReleaseFactory(provider, provider2);
    }

    public static Notification providesSwapTOSNotification$app_productionRelease(FeatureFlagsRepository featureFlagsRepository, e.j.j.b bVar) {
        Notification providesSwapTOSNotification$app_productionRelease;
        providesSwapTOSNotification$app_productionRelease = NotificationsModule.Companion.providesSwapTOSNotification$app_productionRelease(featureFlagsRepository, bVar);
        return (Notification) f.c.h.f(providesSwapTOSNotification$app_productionRelease);
    }

    @Override // javax.inject.Provider
    public Notification get() {
        return providesSwapTOSNotification$app_productionRelease(this.featureFlagsRepositoryProvider.get(), this.prefsProvider.get());
    }
}