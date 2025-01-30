package com.coinbase.wallet.application.migrations;

import android.content.Context;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppVersion304Migration_Factory implements f.c.d<AppVersion304Migration> {
    private final Provider<Context> contextProvider;
    private final Provider<MigrationsDaoInterface> legacyStoreProvider;
    private final Provider<StoreInterface> storeProvider;

    public AppVersion304Migration_Factory(Provider<MigrationsDaoInterface> provider, Provider<Context> provider2, Provider<StoreInterface> provider3) {
        this.legacyStoreProvider = provider;
        this.contextProvider = provider2;
        this.storeProvider = provider3;
    }

    public static AppVersion304Migration_Factory create(Provider<MigrationsDaoInterface> provider, Provider<Context> provider2, Provider<StoreInterface> provider3) {
        return new AppVersion304Migration_Factory(provider, provider2, provider3);
    }

    public static AppVersion304Migration newInstance(MigrationsDaoInterface migrationsDaoInterface, Context context, StoreInterface storeInterface) {
        return new AppVersion304Migration(migrationsDaoInterface, context, storeInterface);
    }

    @Override // javax.inject.Provider
    public AppVersion304Migration get() {
        return newInstance(this.legacyStoreProvider.get(), this.contextProvider.get(), this.storeProvider.get());
    }
}