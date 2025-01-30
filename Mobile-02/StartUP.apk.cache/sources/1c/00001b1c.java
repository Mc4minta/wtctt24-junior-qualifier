package com.coinbase.wallet.di;

import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesTxHistoryDaoFactory implements f.c.d<TxHistoryDAO> {
    private final Provider<Database<AppDatabase>> dbProvider;

    public DatabaseModule_Companion_ProvidesTxHistoryDaoFactory(Provider<Database<AppDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesTxHistoryDaoFactory create(Provider<Database<AppDatabase>> provider) {
        return new DatabaseModule_Companion_ProvidesTxHistoryDaoFactory(provider);
    }

    public static TxHistoryDAO providesTxHistoryDao(Database<AppDatabase> database) {
        return (TxHistoryDAO) f.c.h.f(DatabaseModule.Companion.providesTxHistoryDao(database));
    }

    @Override // javax.inject.Provider
    public TxHistoryDAO get() {
        return providesTxHistoryDao(this.dbProvider.get());
    }
}