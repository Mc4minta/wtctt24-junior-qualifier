package com.coinbase.wallet.di;

import android.app.Application;
import com.toshi.db.DerivedDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_ProvidesDerivedDatabaseFactory implements f.c.d<DerivedDatabase> {
    private final Provider<Application> appProvider;

    public DatabaseModule_ProvidesDerivedDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static DatabaseModule_ProvidesDerivedDatabaseFactory create(Provider<Application> provider) {
        return new DatabaseModule_ProvidesDerivedDatabaseFactory(provider);
    }

    public static DerivedDatabase providesDerivedDatabase(Application application) {
        return (DerivedDatabase) f.c.h.f(DatabaseModule.providesDerivedDatabase(application));
    }

    @Override // javax.inject.Provider
    public DerivedDatabase get() {
        return providesDerivedDatabase(this.appProvider.get());
    }
}