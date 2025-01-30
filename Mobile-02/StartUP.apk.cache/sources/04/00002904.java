package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_ProvidesFiatExchangeRateDao$wallets_releaseFactory implements d<FiatExchangeRateDAO> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_ProvidesFiatExchangeRateDao$wallets_releaseFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_ProvidesFiatExchangeRateDao$wallets_releaseFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_ProvidesFiatExchangeRateDao$wallets_releaseFactory(provider);
    }

    public static FiatExchangeRateDAO providesFiatExchangeRateDao$wallets_release(Database<WalletsDatabase> database) {
        FiatExchangeRateDAO providesFiatExchangeRateDao$wallets_release;
        providesFiatExchangeRateDao$wallets_release = DAOModule.Companion.providesFiatExchangeRateDao$wallets_release(database);
        return (FiatExchangeRateDAO) h.f(providesFiatExchangeRateDao$wallets_release);
    }

    @Override // javax.inject.Provider
    public FiatExchangeRateDAO get() {
        return providesFiatExchangeRateDao$wallets_release(this.databaseProvider.get());
    }
}