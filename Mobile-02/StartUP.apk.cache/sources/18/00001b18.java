package com.coinbase.wallet.di;

import android.app.Application;
import com.toshi.db.DerivedDatabase;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesDerivedDatabaseFactory implements f.c.d<DerivedDatabase> {
    private final Provider<Application> appProvider;

    public DatabaseModule_Companion_ProvidesDerivedDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesDerivedDatabaseFactory create(Provider<Application> provider) {
        return new DatabaseModule_Companion_ProvidesDerivedDatabaseFactory(provider);
    }

    public static DerivedDatabase providesDerivedDatabase(Application application) {
        return (DerivedDatabase) f.c.h.f(DatabaseModule.Companion.providesDerivedDatabase(application));
    }

    @Override // javax.inject.Provider
    public DerivedDatabase get() {
        return providesDerivedDatabase(this.appProvider.get());
    }
}