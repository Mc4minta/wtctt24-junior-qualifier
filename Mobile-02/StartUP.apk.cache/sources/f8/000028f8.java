package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesFiatExchangeRateDao$wallets_releaseFactory implements d<FiatExchangeRateDAO> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_Companion_ProvidesFiatExchangeRateDao$wallets_releaseFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_Companion_ProvidesFiatExchangeRateDao$wallets_releaseFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_Companion_ProvidesFiatExchangeRateDao$wallets_releaseFactory(provider);
    }

    public static FiatExchangeRateDAO providesFiatExchangeRateDao$wallets_release(Database<WalletsDatabase> database) {
        return (FiatExchangeRateDAO) h.f(DAOModule.Companion.providesFiatExchangeRateDao$wallets_release(database));
    }

    @Override // javax.inject.Provider
    public FiatExchangeRateDAO get() {
        return providesFiatExchangeRateDao$wallets_release(this.databaseProvider.get());
    }
}