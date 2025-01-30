package com.coinbase.wallet.di;

import com.toshi.db.WalletDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_ProvidesBookmarkDaoFactory implements f.c.d<com.toshi.db.g.b> {
    private final Provider<WalletDatabase> walletDatabaseProvider;

    public DatabaseModule_ProvidesBookmarkDaoFactory(Provider<WalletDatabase> provider) {
        this.walletDatabaseProvider = provider;
    }

    public static DatabaseModule_ProvidesBookmarkDaoFactory create(Provider<WalletDatabase> provider) {
        return new DatabaseModule_ProvidesBookmarkDaoFactory(provider);
    }

    public static com.toshi.db.g.b providesBookmarkDao(WalletDatabase walletDatabase) {
        return (com.toshi.db.g.b) f.c.h.f(DatabaseModule.providesBookmarkDao(walletDatabase));
    }

    @Override // javax.inject.Provider
    public com.toshi.db.g.b get() {
        return providesBookmarkDao(this.walletDatabaseProvider.get());
    }
}