package com.coinbase.wallet.di;

import com.toshi.db.WalletDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesBookmarkDaoFactory implements f.c.d<com.toshi.db.g.b> {
    private final Provider<WalletDatabase> walletDatabaseProvider;

    public DatabaseModule_Companion_ProvidesBookmarkDaoFactory(Provider<WalletDatabase> provider) {
        this.walletDatabaseProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesBookmarkDaoFactory create(Provider<WalletDatabase> provider) {
        return new DatabaseModule_Companion_ProvidesBookmarkDaoFactory(provider);
    }

    public static com.toshi.db.g.b providesBookmarkDao(WalletDatabase walletDatabase) {
        return (com.toshi.db.g.b) f.c.h.f(DatabaseModule.Companion.providesBookmarkDao(walletDatabase));
    }

    @Override // javax.inject.Provider
    public com.toshi.db.g.b get() {
        return providesBookmarkDao(this.walletDatabaseProvider.get());
    }
}