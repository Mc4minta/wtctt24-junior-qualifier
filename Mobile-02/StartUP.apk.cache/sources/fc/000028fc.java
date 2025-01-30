package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesWalletDaoFactory implements d<WalletDao> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_Companion_ProvidesWalletDaoFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_Companion_ProvidesWalletDaoFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_Companion_ProvidesWalletDaoFactory(provider);
    }

    public static WalletDao providesWalletDao(Database<WalletsDatabase> database) {
        return (WalletDao) h.f(DAOModule.Companion.providesWalletDao(database));
    }

    @Override // javax.inject.Provider
    public WalletDao get() {
        return providesWalletDao(this.databaseProvider.get());
    }
}