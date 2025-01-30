package com.coinbase.wallet.application.migrations;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import e.j.j.j;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppVersion251Migration_Factory implements f.c.d<AppVersion251Migration> {
    private final Provider<MigrationsDaoInterface> legacyStoreProvider;
    private final Provider<j> notificationPrefsProvider;
    private final Provider<StoreInterface> storeProvider;

    public AppVersion251Migration_Factory(Provider<MigrationsDaoInterface> provider, Provider<j> provider2, Provider<StoreInterface> provider3) {
        this.legacyStoreProvider = provider;
        this.notificationPrefsProvider = provider2;
        this.storeProvider = provider3;
    }

    public static AppVersion251Migration_Factory create(Provider<MigrationsDaoInterface> provider, Provider<j> provider2, Provider<StoreInterface> provider3) {
        return new AppVersion251Migration_Factory(provider, provider2, provider3);
    }

    public static AppVersion251Migration newInstance(MigrationsDaoInterface migrationsDaoInterface, j jVar, StoreInterface storeInterface) {
        return new AppVersion251Migration(migrationsDaoInterface, jVar, storeInterface);
    }

    @Override // javax.inject.Provider
    public AppVersion251Migration get() {
        return newInstance(this.legacyStoreProvider.get(), this.notificationPrefsProvider.get(), this.storeProvider.get());
    }
}