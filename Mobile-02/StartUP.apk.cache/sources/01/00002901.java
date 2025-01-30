package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.daos.CryptoCurrencyDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_ProvidesCryptoCurrencyDao$wallets_releaseFactory implements d<CryptoCurrencyDAO> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_ProvidesCryptoCurrencyDao$wallets_releaseFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_ProvidesCryptoCurrencyDao$wallets_releaseFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_ProvidesCryptoCurrencyDao$wallets_releaseFactory(provider);
    }

    public static CryptoCurrencyDAO providesCryptoCurrencyDao$wallets_release(Database<WalletsDatabase> database) {
        CryptoCurrencyDAO providesCryptoCurrencyDao$wallets_release;
        providesCryptoCurrencyDao$wallets_release = DAOModule.Companion.providesCryptoCurrencyDao$wallets_release(database);
        return (CryptoCurrencyDAO) h.f(providesCryptoCurrencyDao$wallets_release);
    }

    @Override // javax.inject.Provider
    public CryptoCurrencyDAO get() {
        return providesCryptoCurrencyDao$wallets_release(this.databaseProvider.get());
    }
}