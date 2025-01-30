package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_ProvidesBtcTxDAOFactory implements d<BIP44SignedTxDao> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_ProvidesBtcTxDAOFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_ProvidesBtcTxDAOFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_ProvidesBtcTxDAOFactory(provider);
    }

    public static BIP44SignedTxDao providesBtcTxDAO(Database<WalletsDatabase> database) {
        return (BIP44SignedTxDao) h.f(DAOModule.providesBtcTxDAO(database));
    }

    @Override // javax.inject.Provider
    public BIP44SignedTxDao get() {
        return providesBtcTxDAO(this.databaseProvider.get());
    }
}