package com.coinbase.wallet.di;

import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.model.Notification;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationsModule_ProvidesSecurityProviderPrompt$app_productionReleaseFactory implements f.c.d<Notification> {
    private final Provider<BaseApplication> appContextProvider;

    public NotificationsModule_ProvidesSecurityProviderPrompt$app_productionReleaseFactory(Provider<BaseApplication> provider) {
        this.appContextProvider = provider;
    }

    public static NotificationsModule_ProvidesSecurityProviderPrompt$app_productionReleaseFactory create(Provider<BaseApplication> provider) {
        return new NotificationsModule_ProvidesSecurityProviderPrompt$app_productionReleaseFactory(provider);
    }

    public static Notification providesSecurityProviderPrompt$app_productionRelease(BaseApplication baseApplication) {
        Notification providesSecurityProviderPrompt$app_productionRelease;
        providesSecurityProviderPrompt$app_productionRelease = NotificationsModule.Companion.providesSecurityProviderPrompt$app_productionRelease(baseApplication);
        return (Notification) f.c.h.f(providesSecurityProviderPrompt$app_productionRelease);
    }

    @Override // javax.inject.Provider
    public Notification get() {
        return providesSecurityProviderPrompt$app_productionRelease(this.appContextProvider.get());
    }
}