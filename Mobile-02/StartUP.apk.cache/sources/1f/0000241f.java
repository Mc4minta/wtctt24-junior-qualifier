package com.coinbase.wallet.lending.di;

import com.coinbase.wallet.lending.daos.LendTokenDAO;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendModule_ProvidesLendTokenDAO$lending_releaseFactory implements d<LendTokenDAO> {
    private final Provider<Database<LendDatabase>> databaseProvider;

    public LendModule_ProvidesLendTokenDAO$lending_releaseFactory(Provider<Database<LendDatabase>> provider) {
        this.databaseProvider = provider;
    }

    public static LendModule_ProvidesLendTokenDAO$lending_releaseFactory create(Provider<Database<LendDatabase>> provider) {
        return new LendModule_ProvidesLendTokenDAO$lending_releaseFactory(provider);
    }

    public static LendTokenDAO providesLendTokenDAO$lending_release(Database<LendDatabase> database) {
        LendTokenDAO providesLendTokenDAO$lending_release;
        providesLendTokenDAO$lending_release = LendModule.Companion.providesLendTokenDAO$lending_release(database);
        return (LendTokenDAO) h.f(providesLendTokenDAO$lending_release);
    }

    @Override // javax.inject.Provider
    public LendTokenDAO get() {
        return providesLendTokenDAO$lending_release(this.databaseProvider.get());
    }
}