package com.coinbase.wallet.application.migrations;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppVersion210Migration_Factory implements f.c.d<AppVersion210Migration> {
    private final Provider<e.j.c.a.a> consumerOAuthPrefsProvider;
    private final Provider<MigrationsDaoInterface> legacyStoreProvider;
    private final Provider<StoreInterface> storeProvider;

    public AppVersion210Migration_Factory(Provider<MigrationsDaoInterface> provider, Provider<e.j.c.a.a> provider2, Provider<StoreInterface> provider3) {
        this.legacyStoreProvider = provider;
        this.consumerOAuthPrefsProvider = provider2;
        this.storeProvider = provider3;
    }

    public static AppVersion210Migration_Factory create(Provider<MigrationsDaoInterface> provider, Provider<e.j.c.a.a> provider2, Provider<StoreInterface> provider3) {
        return new AppVersion210Migration_Factory(provider, provider2, provider3);
    }

    public static AppVersion210Migration newInstance(MigrationsDaoInterface migrationsDaoInterface, e.j.c.a.a aVar, StoreInterface storeInterface) {
        return new AppVersion210Migration(migrationsDaoInterface, aVar, storeInterface);
    }

    @Override // javax.inject.Provider
    public AppVersion210Migration get() {
        return newInstance(this.legacyStoreProvider.get(), this.consumerOAuthPrefsProvider.get(), this.storeProvider.get());
    }
}