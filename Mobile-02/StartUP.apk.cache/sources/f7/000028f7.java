package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.daos.FiatCurrencyDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesFiatCurrencyDao$wallets_releaseFactory implements d<FiatCurrencyDAO> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_Companion_ProvidesFiatCurrencyDao$wallets_releaseFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_Companion_ProvidesFiatCurrencyDao$wallets_releaseFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_Companion_ProvidesFiatCurrencyDao$wallets_releaseFactory(provider);
    }

    public static FiatCurrencyDAO providesFiatCurrencyDao$wallets_release(Database<WalletsDatabase> database) {
        return (FiatCurrencyDAO) h.f(DAOModule.Companion.providesFiatCurrencyDao$wallets_release(database));
    }

    @Override // javax.inject.Provider
    public FiatCurrencyDAO get() {
        return providesFiatCurrencyDao$wallets_release(this.databaseProvider.get());
    }
}