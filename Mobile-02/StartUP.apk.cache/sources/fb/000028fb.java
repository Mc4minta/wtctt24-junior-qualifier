package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.stellar.daos.StellarSignedTxDao;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesStellarTxDAOFactory implements d<StellarSignedTxDao> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_Companion_ProvidesStellarTxDAOFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_Companion_ProvidesStellarTxDAOFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_Companion_ProvidesStellarTxDAOFactory(provider);
    }

    public static StellarSignedTxDao providesStellarTxDAO(Database<WalletsDatabase> database) {
        return (StellarSignedTxDao) h.f(DAOModule.Companion.providesStellarTxDAO(database));
    }

    @Override // javax.inject.Provider
    public StellarSignedTxDao get() {
        return providesStellarTxDAO(this.databaseProvider.get());
    }
}