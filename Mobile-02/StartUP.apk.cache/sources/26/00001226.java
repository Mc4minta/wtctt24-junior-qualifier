package com.coinbase.wallet.application.service;

import android.app.Application;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.application.migrations.Migrations;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.features.debugmenu.util.DebugSettings;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.pushnotifications.services.PushNotificationDisplayService;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletlink.WalletLinkInterface;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ApplicationService_Factory implements f.c.d<ApplicationService> {
    private final Provider<Database<AppDatabase>> appDatabaseProvider;
    private final Provider<AppLockRepositoryInterface> appLockRepositoryProvider;
    private final Provider<e.j.j.b> appPrefsProvider;
    private final Provider<Application> appProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<Database<ConsumerDatabase>> consumerDatabaseProvider;
    private final Provider<DebugSettings> debugSettingsProvider;
    private final Provider<com.toshi.db.c> derivedDatabaseDestroyableProvider;
    private final Provider<Map<Integer, Provider<Destroyable>>> destroyablesProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<Database<LendDatabase>> lendDatabaseProvider;
    private final Provider<Migrations> migrationsProvider;
    private final Provider<e.j.i.i2.d> mnemonicBackupRepositoryProvider;
    private final Provider<MnemonicRepositoryInterface> mnemonicRepositoryProvider;
    private final Provider<PushNotificationDisplayService> pushNotificationDisplayServiceProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private final Provider<Map<Integer, Provider<Startable>>> startablesProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<com.toshi.db.e> walletDatabaseDestroyableProvider;
    private final Provider<WalletEngine> walletEngineProvider;
    private final Provider<WalletLinkInterface> walletLinkProvider;
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;
    private final Provider<Database<WalletsDatabase>> walletsDatabaseProvider;

    public ApplicationService_Factory(Provider<Application> provider, Provider<Database<WalletsDatabase>> provider2, Provider<Database<AppDatabase>> provider3, Provider<Database<ConsumerDatabase>> provider4, Provider<Database<LendDatabase>> provider5, Provider<com.toshi.db.e> provider6, Provider<com.toshi.db.c> provider7, Provider<WalletLinkInterface> provider8, Provider<e.j.j.b> provider9, Provider<Map<Integer, Provider<Destroyable>>> provider10, Provider<Map<Integer, Provider<Startable>>> provider11, Provider<StoreInterface> provider12, Provider<AppLockRepositoryInterface> provider13, Provider<Migrations> provider14, Provider<WalletEngine> provider15, Provider<CipherCoreInterface> provider16, Provider<e.j.i.i2.d> provider17, Provider<MnemonicRepositoryInterface> provider18, Provider<IWalletRepository> provider19, Provider<IExchangeRateRepository> provider20, Provider<DebugSettings> provider21, Provider<WalletLinkRepository> provider22, Provider<PushNotificationRepository> provider23, Provider<PushNotificationDisplayService> provider24) {
        this.appProvider = provider;
        this.walletsDatabaseProvider = provider2;
        this.appDatabaseProvider = provider3;
        this.consumerDatabaseProvider = provider4;
        this.lendDatabaseProvider = provider5;
        this.walletDatabaseDestroyableProvider = provider6;
        this.derivedDatabaseDestroyableProvider = provider7;
        this.walletLinkProvider = provider8;
        this.appPrefsProvider = provider9;
        this.destroyablesProvider = provider10;
        this.startablesProvider = provider11;
        this.storeProvider = provider12;
        this.appLockRepositoryProvider = provider13;
        this.migrationsProvider = provider14;
        this.walletEngineProvider = provider15;
        this.cipherCoreProvider = provider16;
        this.mnemonicBackupRepositoryProvider = provider17;
        this.mnemonicRepositoryProvider = provider18;
        this.walletRepositoryProvider = provider19;
        this.exchangeRateRepositoryProvider = provider20;
        this.debugSettingsProvider = provider21;
        this.walletLinkRepositoryProvider = provider22;
        this.pushNotificationRepositoryProvider = provider23;
        this.pushNotificationDisplayServiceProvider = provider24;
    }

    public static ApplicationService_Factory create(Provider<Application> provider, Provider<Database<WalletsDatabase>> provider2, Provider<Database<AppDatabase>> provider3, Provider<Database<ConsumerDatabase>> provider4, Provider<Database<LendDatabase>> provider5, Provider<com.toshi.db.e> provider6, Provider<com.toshi.db.c> provider7, Provider<WalletLinkInterface> provider8, Provider<e.j.j.b> provider9, Provider<Map<Integer, Provider<Destroyable>>> provider10, Provider<Map<Integer, Provider<Startable>>> provider11, Provider<StoreInterface> provider12, Provider<AppLockRepositoryInterface> provider13, Provider<Migrations> provider14, Provider<WalletEngine> provider15, Provider<CipherCoreInterface> provider16, Provider<e.j.i.i2.d> provider17, Provider<MnemonicRepositoryInterface> provider18, Provider<IWalletRepository> provider19, Provider<IExchangeRateRepository> provider20, Provider<DebugSettings> provider21, Provider<WalletLinkRepository> provider22, Provider<PushNotificationRepository> provider23, Provider<PushNotificationDisplayService> provider24) {
        return new ApplicationService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24);
    }

    public static ApplicationService newInstance(Application application, Provider<Database<WalletsDatabase>> provider, Provider<Database<AppDatabase>> provider2, Provider<Database<ConsumerDatabase>> provider3, Provider<Database<LendDatabase>> provider4, Provider<com.toshi.db.e> provider5, Provider<com.toshi.db.c> provider6, Provider<WalletLinkInterface> provider7, Provider<e.j.j.b> provider8, Map<Integer, Provider<Destroyable>> map, Map<Integer, Provider<Startable>> map2, Provider<StoreInterface> provider9, Provider<AppLockRepositoryInterface> provider10, Provider<Migrations> provider11, Provider<WalletEngine> provider12, Provider<CipherCoreInterface> provider13, e.j.i.i2.d dVar, MnemonicRepositoryInterface mnemonicRepositoryInterface, Provider<IWalletRepository> provider14, Provider<IExchangeRateRepository> provider15, Provider<DebugSettings> provider16, Provider<WalletLinkRepository> provider17, Provider<PushNotificationRepository> provider18, Provider<PushNotificationDisplayService> provider19) {
        return new ApplicationService(application, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, map, map2, provider9, provider10, provider11, provider12, provider13, dVar, mnemonicRepositoryInterface, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    @Override // javax.inject.Provider
    public ApplicationService get() {
        return newInstance(this.appProvider.get(), this.walletsDatabaseProvider, this.appDatabaseProvider, this.consumerDatabaseProvider, this.lendDatabaseProvider, this.walletDatabaseDestroyableProvider, this.derivedDatabaseDestroyableProvider, this.walletLinkProvider, this.appPrefsProvider, this.destroyablesProvider.get(), this.startablesProvider.get(), this.storeProvider, this.appLockRepositoryProvider, this.migrationsProvider, this.walletEngineProvider, this.cipherCoreProvider, this.mnemonicBackupRepositoryProvider.get(), this.mnemonicRepositoryProvider.get(), this.walletRepositoryProvider, this.exchangeRateRepositoryProvider, this.debugSettingsProvider, this.walletLinkRepositoryProvider, this.pushNotificationRepositoryProvider, this.pushNotificationDisplayServiceProvider);
    }
}