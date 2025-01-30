package com.coinbase.wallet.wallets.di;

import android.app.Application;
import androidx.room.s.a;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import f.c.d;
import f.c.h;
import java.util.List;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DAOModule_Companion_ProvidesDatabaseFactory implements d<Database<WalletsDatabase>> {
    private final Provider<Application> appProvider;
    private final Provider<List<a>> migrationsProvider;

    public DAOModule_Companion_ProvidesDatabaseFactory(Provider<Application> provider, Provider<List<a>> provider2) {
        this.appProvider = provider;
        this.migrationsProvider = provider2;
    }

    public static DAOModule_Companion_ProvidesDatabaseFactory create(Provider<Application> provider, Provider<List<a>> provider2) {
        return new DAOModule_Companion_ProvidesDatabaseFactory(provider, provider2);
    }

    public static Database<WalletsDatabase> providesDatabase(Application application, List<a> list) {
        return (Database) h.f(DAOModule.Companion.providesDatabase(application, list));
    }

    @Override // javax.inject.Provider
    public Database<WalletsDatabase> get() {
        return providesDatabase(this.appProvider.get(), this.migrationsProvider.get());
    }
}