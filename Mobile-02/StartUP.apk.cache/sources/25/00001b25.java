package com.coinbase.wallet.di;

import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_ProvidesTxAddressDAOFactory implements f.c.d<TxAddressDAO> {
    private final Provider<Database<AppDatabase>> dbProvider;

    public DatabaseModule_ProvidesTxAddressDAOFactory(Provider<Database<AppDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static DatabaseModule_ProvidesTxAddressDAOFactory create(Provider<Database<AppDatabase>> provider) {
        return new DatabaseModule_ProvidesTxAddressDAOFactory(provider);
    }

    public static TxAddressDAO providesTxAddressDAO(Database<AppDatabase> database) {
        return (TxAddressDAO) f.c.h.f(DatabaseModule.providesTxAddressDAO(database));
    }

    @Override // javax.inject.Provider
    public TxAddressDAO get() {
        return providesTxAddressDAO(this.dbProvider.get());
    }
}