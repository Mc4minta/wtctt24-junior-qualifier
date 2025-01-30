package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesAddressDaoFactory implements d<AddressDao> {
    private final Provider<Database<WalletsDatabase>> databaseProvider;

    public DAOModule_Companion_ProvidesAddressDaoFactory(Provider<Database<WalletsDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static DAOModule_Companion_ProvidesAddressDaoFactory create(Provider<Database<WalletsDatabase>> provider) {
        return new DAOModule_Companion_ProvidesAddressDaoFactory(provider);
    }

    public static AddressDao providesAddressDao(Database<WalletsDatabase> database) {
        return (AddressDao) h.f(DAOModule.Companion.providesAddressDao(database));
    }

    @Override // javax.inject.Provider
    public AddressDao get() {
        return providesAddressDao(this.databaseProvider.get());
    }
}