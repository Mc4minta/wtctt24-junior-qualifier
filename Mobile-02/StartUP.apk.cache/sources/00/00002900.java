package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.compoundfinance.daos.CompoundTokenDAO;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_ProvidesCompoundTokenDAOFactory implements d<CompoundTokenDAO> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_ProvidesCompoundTokenDAOFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_ProvidesCompoundTokenDAOFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_ProvidesCompoundTokenDAOFactory(provider);
    }

    public static CompoundTokenDAO providesCompoundTokenDAO(Database<WalletsDatabase> database) {
        return (CompoundTokenDAO) h.f(DAOModule.providesCompoundTokenDAO(database));
    }

    @Override // javax.inject.Provider
    public CompoundTokenDAO get() {
        return providesCompoundTokenDAO(this.databaseProvider.get());
    }
}