package com.coinbase.wallet.di;

import com.toshi.db.DerivedDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_ProvidesErc721TokenDaoFactory implements f.c.d<com.toshi.db.i.b> {
    private final Provider<DerivedDatabase> derivedDatabaseProvider;

    public DatabaseModule_ProvidesErc721TokenDaoFactory(Provider<DerivedDatabase> provider) {
        this.derivedDatabaseProvider = provider;
    }

    public static DatabaseModule_ProvidesErc721TokenDaoFactory create(Provider<DerivedDatabase> provider) {
        return new DatabaseModule_ProvidesErc721TokenDaoFactory(provider);
    }

    public static com.toshi.db.i.b providesErc721TokenDao(DerivedDatabase derivedDatabase) {
        return (com.toshi.db.i.b) f.c.h.f(DatabaseModule.providesErc721TokenDao(derivedDatabase));
    }

    @Override // javax.inject.Provider
    public com.toshi.db.i.b get() {
        return providesErc721TokenDao(this.derivedDatabaseProvider.get());
    }
}