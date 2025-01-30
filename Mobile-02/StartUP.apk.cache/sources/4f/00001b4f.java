package com.coinbase.wallet.di;

import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import e.j.i.a2;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NotificationsModule_ProvidesNewUserCloudBackupPrompt$app_productionReleaseFactory implements f.c.d<Notification> {
    private final Provider<a2> mnemonicBackupRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;

    public NotificationsModule_ProvidesNewUserCloudBackupPrompt$app_productionReleaseFactory(Provider<a2> provider, Provider<StoreInterface> provider2) {
        this.mnemonicBackupRepositoryProvider = provider;
        this.storeProvider = provider2;
    }

    public static NotificationsModule_ProvidesNewUserCloudBackupPrompt$app_productionReleaseFactory create(Provider<a2> provider, Provider<StoreInterface> provider2) {
        return new NotificationsModule_ProvidesNewUserCloudBackupPrompt$app_productionReleaseFactory(provider, provider2);
    }

    public static Notification providesNewUserCloudBackupPrompt$app_productionRelease(a2 a2Var, StoreInterface storeInterface) {
        Notification providesNewUserCloudBackupPrompt$app_productionRelease;
        providesNewUserCloudBackupPrompt$app_productionRelease = NotificationsModule.Companion.providesNewUserCloudBackupPrompt$app_productionRelease(a2Var, storeInterface);
        return (Notification) f.c.h.f(providesNewUserCloudBackupPrompt$app_productionRelease);
    }

    @Override // javax.inject.Provider
    public Notification get() {
        return providesNewUserCloudBackupPrompt$app_productionRelease(this.mnemonicBackupRepositoryProvider.get(), this.storeProvider.get());
    }
}