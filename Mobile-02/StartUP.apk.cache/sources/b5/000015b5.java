package com.coinbase.wallet.consumer.di;

import android.app.Application;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerModule_ProvidesAppDatabaseFactory implements d<Database<ConsumerDatabase>> {
    private final Provider<Application> appProvider;

    public ConsumerModule_ProvidesAppDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static ConsumerModule_ProvidesAppDatabaseFactory create(Provider<Application> provider) {
        return new ConsumerModule_ProvidesAppDatabaseFactory(provider);
    }

    public static Database<ConsumerDatabase> providesAppDatabase(Application application) {
        return (Database) h.f(ConsumerModule.providesAppDatabase(application));
    }

    @Override // javax.inject.Provider
    public Database<ConsumerDatabase> get() {
        return providesAppDatabase(this.appProvider.get());
    }
}