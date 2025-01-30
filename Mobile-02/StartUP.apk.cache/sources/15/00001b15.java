package com.coinbase.wallet.di;

import android.app.Application;
import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_Companion_ProvidesAppDatabaseFactory implements f.c.d<Database<AppDatabase>> {
    private final Provider<Application> appProvider;

    public DatabaseModule_Companion_ProvidesAppDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static DatabaseModule_Companion_ProvidesAppDatabaseFactory create(Provider<Application> provider) {
        return new DatabaseModule_Companion_ProvidesAppDatabaseFactory(provider);
    }

    public static Database<AppDatabase> providesAppDatabase(Application application) {
        return (Database) f.c.h.f(DatabaseModule.Companion.providesAppDatabase(application));
    }

    @Override // javax.inject.Provider
    public Database<AppDatabase> get() {
        return providesAppDatabase(this.appProvider.get());
    }
}