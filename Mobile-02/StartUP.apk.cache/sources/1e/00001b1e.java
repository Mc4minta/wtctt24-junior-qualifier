package com.coinbase.wallet.di;

import android.app.Application;
import com.toshi.db.WalletDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesWalletDatabaseFactory implements f.c.d<WalletDatabase> {
    private final Provider<Application> appProvider;

    public DatabaseModule_Companion_ProvidesWalletDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesWalletDatabaseFactory create(Provider<Application> provider) {
        return new DatabaseModule_Companion_ProvidesWalletDatabaseFactory(provider);
    }

    public static WalletDatabase providesWalletDatabase(Application application) {
        return (WalletDatabase) f.c.h.f(DatabaseModule.Companion.providesWalletDatabase(application));
    }

    @Override // javax.inject.Provider
    public WalletDatabase get() {
        return providesWalletDatabase(this.appProvider.get());
    }
}