package com.coinbase.wallet.di;

import com.toshi.db.DerivedDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesCollectibleTypeDaoFactory implements f.c.d<com.toshi.db.h.b> {
    private final Provider<DerivedDatabase> derivedDatabaseProvider;

    public DatabaseModule_Companion_ProvidesCollectibleTypeDaoFactory(Provider<DerivedDatabase> provider) {
        this.derivedDatabaseProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesCollectibleTypeDaoFactory create(Provider<DerivedDatabase> provider) {
        return new DatabaseModule_Companion_ProvidesCollectibleTypeDaoFactory(provider);
    }

    public static com.toshi.db.h.b providesCollectibleTypeDao(DerivedDatabase derivedDatabase) {
        return (com.toshi.db.h.b) f.c.h.f(DatabaseModule.Companion.providesCollectibleTypeDao(derivedDatabase));
    }

    @Override // javax.inject.Provider
    public com.toshi.db.h.b get() {
        return providesCollectibleTypeDao(this.derivedDatabaseProvider.get());
    }
}