package com.coinbase.wallet.di;

import android.app.Application;
import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DatabaseModule_ProvidesAppDatabaseFactory implements f.c.d<Database<AppDatabase>> {
    private final Provider<Application> appProvider;

    public DatabaseModule_ProvidesAppDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static DatabaseModule_ProvidesAppDatabaseFactory create(Provider<Application> provider) {
        return new DatabaseModule_ProvidesAppDatabaseFactory(provider);
    }

    public static Database<AppDatabase> providesAppDatabase(Application application) {
        return (Database) f.c.h.f(DatabaseModule.providesAppDatabase(application));
    }

    @Override // javax.inject.Provider
    public Database<AppDatabase> get() {
        return providesAppDatabase(this.appProvider.get());
    }
}