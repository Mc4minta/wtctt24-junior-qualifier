package com.coinbase.wallet.swap.di;

import android.app.Application;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.swap.db.SwapDatabase;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SwapModule_Companion_ProvidesDatabaseFactory implements d<Database<SwapDatabase>> {
    private final Provider<Application> appProvider;

    public SwapModule_Companion_ProvidesDatabaseFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static SwapModule_Companion_ProvidesDatabaseFactory create(Provider<Application> provider) {
        return new SwapModule_Companion_ProvidesDatabaseFactory(provider);
    }

    public static Database<SwapDatabase> providesDatabase(Application application) {
        return (Database) h.f(SwapModule.Companion.providesDatabase(application));
    }

    @Override // javax.inject.Provider
    public Database<SwapDatabase> get() {
        return providesDatabase(this.appProvider.get());
    }
}