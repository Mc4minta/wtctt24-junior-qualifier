package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesXrpTxDAOFactory implements d<XRPSignedTxDAO> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_Companion_ProvidesXrpTxDAOFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_Companion_ProvidesXrpTxDAOFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_Companion_ProvidesXrpTxDAOFactory(provider);
    }

    public static XRPSignedTxDAO providesXrpTxDAO(Database<WalletsDatabase> database) {
        return (XRPSignedTxDAO) h.f(DAOModule.Companion.providesXrpTxDAO(database));
    }

    @Override // javax.inject.Provider
    public XRPSignedTxDAO get() {
        return providesXrpTxDAO(this.databaseProvider.get());
    }
}