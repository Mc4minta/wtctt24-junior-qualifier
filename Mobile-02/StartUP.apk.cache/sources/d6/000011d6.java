package com.coinbase.wallet.application.migrations;

import android.content.Context;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppVersion232Migration_Factory implements f.c.d<AppVersion232Migration> {
    private final Provider<Context> contextProvider;
    private final Provider<MigrationsDaoInterface> legacyStoreProvider;
    private final Provider<StoreInterface> storeProvider;

    public AppVersion232Migration_Factory(Provider<MigrationsDaoInterface> provider, Provider<StoreInterface> provider2, Provider<Context> provider3) {
        this.legacyStoreProvider = provider;
        this.storeProvider = provider2;
        this.contextProvider = provider3;
    }

    public static AppVersion232Migration_Factory create(Provider<MigrationsDaoInterface> provider, Provider<StoreInterface> provider2, Provider<Context> provider3) {
        return new AppVersion232Migration_Factory(provider, provider2, provider3);
    }

    public static AppVersion232Migration newInstance(MigrationsDaoInterface migrationsDaoInterface, StoreInterface storeInterface, Context context) {
        return new AppVersion232Migration(migrationsDaoInterface, storeInterface, context);
    }

    @Override // javax.inject.Provider
    public AppVersion232Migration get() {
        return newInstance(this.legacyStoreProvider.get(), this.storeProvider.get(), this.contextProvider.get());
    }
}