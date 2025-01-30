package com.coinbase.wallet.lending.di;

import android.app.Application;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendModule_ProvidesDatabaseFactory implements d<Database<LendDatabase>> {
    private final Provider<Application> appProvider;

    public LendModule_ProvidesDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static LendModule_ProvidesDatabaseFactory create(Provider<Application> provider) {
        return new LendModule_ProvidesDatabaseFactory(provider);
    }

    public static Database<LendDatabase> providesDatabase(Application application) {
        return (Database) h.f(LendModule.providesDatabase(application));
    }

    @Override // javax.inject.Provider
    public Database<LendDatabase> get() {
        return providesDatabase(this.appProvider.get());
    }
}