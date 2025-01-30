package com.coinbase.wallet.di;

import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.toshi.db.DerivedDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesUserDaoFactory implements f.c.d<UserDaoInterface> {
    private final Provider<DerivedDatabase> derivedDatabaseProvider;

    public DatabaseModule_Companion_ProvidesUserDaoFactory(Provider<DerivedDatabase> provider) {
        this.derivedDatabaseProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesUserDaoFactory create(Provider<DerivedDatabase> provider) {
        return new DatabaseModule_Companion_ProvidesUserDaoFactory(provider);
    }

    public static UserDaoInterface providesUserDao(DerivedDatabase derivedDatabase) {
        return (UserDaoInterface) f.c.h.f(DatabaseModule.Companion.providesUserDao(derivedDatabase));
    }

    @Override // javax.inject.Provider
    public UserDaoInterface get() {
        return providesUserDao(this.derivedDatabaseProvider.get());
    }
}