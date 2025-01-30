package com.coinbase.wallet.di;

import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.features.send.daos.RecipientDao;
import com.coinbase.wallet.libraries.databases.db.Database;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesSuggestedRecipientDaoFactory implements f.c.d<RecipientDao> {
    private final Provider<Database<AppDatabase>> dbProvider;

    public DatabaseModule_Companion_ProvidesSuggestedRecipientDaoFactory(Provider<Database<AppDatabase>> provider) {
        this.dbProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesSuggestedRecipientDaoFactory create(Provider<Database<AppDatabase>> provider) {
        return new DatabaseModule_Companion_ProvidesSuggestedRecipientDaoFactory(provider);
    }

    public static RecipientDao providesSuggestedRecipientDao(Database<AppDatabase> database) {
        return (RecipientDao) f.c.h.f(DatabaseModule.Companion.providesSuggestedRecipientDao(database));
    }

    @Override // javax.inject.Provider
    public RecipientDao get() {
        return providesSuggestedRecipientDao(this.dbProvider.get());
    }
}