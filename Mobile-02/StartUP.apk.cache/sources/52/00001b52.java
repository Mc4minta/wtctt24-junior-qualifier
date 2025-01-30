package com.coinbase.wallet.di;

import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.model.Notification;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationsModule_ProvidesVerifyAppsPrompt$app_productionReleaseFactory implements f.c.d<Notification> {
    private final Provider<BaseApplication> appContextProvider;

    public NotificationsModule_ProvidesVerifyAppsPrompt$app_productionReleaseFactory(Provider<BaseApplication> provider) {
        this.appContextProvider = provider;
    }

    public static NotificationsModule_ProvidesVerifyAppsPrompt$app_productionReleaseFactory create(Provider<BaseApplication> provider) {
        return new NotificationsModule_ProvidesVerifyAppsPrompt$app_productionReleaseFactory(provider);
    }

    public static Notification providesVerifyAppsPrompt$app_productionRelease(BaseApplication baseApplication) {
        Notification providesVerifyAppsPrompt$app_productionRelease;
        providesVerifyAppsPrompt$app_productionRelease = NotificationsModule.Companion.providesVerifyAppsPrompt$app_productionRelease(baseApplication);
        return (Notification) f.c.h.f(providesVerifyAppsPrompt$app_productionRelease);
    }

    @Override // javax.inject.Provider
    public Notification get() {
        return providesVerifyAppsPrompt$app_productionRelease(this.appContextProvider.get());
    }
}