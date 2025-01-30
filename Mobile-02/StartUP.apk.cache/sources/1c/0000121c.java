package com.coinbase.wallet.application.service;

import android.app.Application;
import android.content.SharedPreferences;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.migrations.Migrations;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.consumer.BuildConfig;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.crypto.extensions.String_CryptoKt;
import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.features.debugmenu.util.DebugSettings;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.pushnotifications.services.PushNotificationDisplayService;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKind;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletlink.WalletLinkInterface;
import com.coinbase.walletlink.models.HostRequestId;
import com.coinbase.walletlink.models.Session;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: ApplicationService.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B÷\u0002\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\f\u0012\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00190\f\u0012\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00190\f\u0012\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00190\f\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u0002070\f\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\f\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\f\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\f\u0012\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u0012\u0012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u0012\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\f\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\f\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\f\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010<\u001a\u00020;\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\f\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\f\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\f\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\f¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR(\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u000fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u000fR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u000fR\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00190\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u000fR\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u000fR\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u000fR\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002000\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010\u000fR\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010\u000fR\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002070\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u000fR\"\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00190\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010\u000fR\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010\u000fR\"\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00190\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010\u000fR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010\u000fR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010\u000fR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u000f¨\u0006M"}, d2 = {"Lcom/coinbase/wallet/application/service/ApplicationService;", "", "Lkotlin/x;", "clearLegacySharedPrefences", "()V", "observeBalanceUpdates", "Lh/c/b0;", "warmUp", "()Lh/c/b0;", "start", "reset", "destroy", "Ljavax/inject/Provider;", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "pushNotificationRepository", "Ljavax/inject/Provider;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "", "", "Lcom/coinbase/wallet/core/interfaces/Startable;", "startables", "Ljava/util/Map;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "destroyables", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "walletsDatabase", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Landroid/app/Application;", "app", "Landroid/app/Application;", "Lcom/coinbase/walletlink/WalletLinkInterface;", "walletLink", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/consumer/db/ConsumerDatabase;", "consumerDatabase", "Lcom/toshi/db/c;", "derivedDatabaseDestroyable", "Lcom/coinbase/wallet/application/migrations/Migrations;", "migrations", "Le/j/i/i2/d;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "Lcom/coinbase/wallet/application/repository/interfaces/AppLockRepositoryInterface;", "appLockRepository", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "Lcom/toshi/db/e;", "walletDatabaseDestroyable", "Lcom/coinbase/wallet/db/AppDatabase;", "appDatabase", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "mnemonicRepository", "Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "Lcom/coinbase/wallet/features/walletlink/repositories/WalletLinkRepository;", "walletLinkRepository", "Lcom/coinbase/wallet/lending/db/LendDatabase;", "lendDatabase", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Le/j/j/b;", "appPrefs", "Lcom/coinbase/wallet/features/pushnotifications/services/PushNotificationDisplayService;", "pushNotificationDisplayService", "Lcom/coinbase/wallet/features/debugmenu/util/DebugSettings;", "debugSettings", "<init>", "(Landroid/app/Application;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljava/util/Map;Ljava/util/Map;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Le/j/i/i2/d;Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ApplicationService {
    private final Application app;
    private final Provider<Database<AppDatabase>> appDatabase;
    private final Provider<AppLockRepositoryInterface> appLockRepository;
    private final Provider<e.j.j.b> appPrefs;
    private final Provider<CipherCoreInterface> cipherCore;
    private final a0 concurrentScheduler;
    private final Provider<Database<ConsumerDatabase>> consumerDatabase;
    private final Provider<DebugSettings> debugSettings;
    private final Provider<com.toshi.db.c> derivedDatabaseDestroyable;
    private final Map<Integer, Provider<Destroyable>> destroyables;
    private final h.c.k0.a disposeBag;
    private final Provider<IExchangeRateRepository> exchangeRateRepository;
    private final Provider<Database<LendDatabase>> lendDatabase;
    private final Provider<Migrations> migrations;
    private final e.j.i.i2.d mnemonicBackupRepository;
    private final MnemonicRepositoryInterface mnemonicRepository;
    private final Provider<PushNotificationDisplayService> pushNotificationDisplayService;
    private final Provider<PushNotificationRepository> pushNotificationRepository;
    private final Map<Integer, Provider<Startable>> startables;
    private final Provider<StoreInterface> store;
    private final Provider<com.toshi.db.e> walletDatabaseDestroyable;
    private final Provider<WalletEngine> walletEngine;
    private final Provider<WalletLinkInterface> walletLink;
    private final Provider<WalletLinkRepository> walletLinkRepository;
    private final Provider<IWalletRepository> walletRepository;
    private final Provider<Database<WalletsDatabase>> walletsDatabase;

    public ApplicationService(Application app, Provider<Database<WalletsDatabase>> walletsDatabase, Provider<Database<AppDatabase>> appDatabase, Provider<Database<ConsumerDatabase>> consumerDatabase, Provider<Database<LendDatabase>> lendDatabase, Provider<com.toshi.db.e> walletDatabaseDestroyable, Provider<com.toshi.db.c> derivedDatabaseDestroyable, Provider<WalletLinkInterface> walletLink, Provider<e.j.j.b> appPrefs, Map<Integer, Provider<Destroyable>> destroyables, Map<Integer, Provider<Startable>> startables, Provider<StoreInterface> store, Provider<AppLockRepositoryInterface> appLockRepository, Provider<Migrations> migrations, Provider<WalletEngine> walletEngine, Provider<CipherCoreInterface> cipherCore, e.j.i.i2.d mnemonicBackupRepository, MnemonicRepositoryInterface mnemonicRepository, Provider<IWalletRepository> walletRepository, Provider<IExchangeRateRepository> exchangeRateRepository, Provider<DebugSettings> debugSettings, Provider<WalletLinkRepository> walletLinkRepository, Provider<PushNotificationRepository> pushNotificationRepository, Provider<PushNotificationDisplayService> pushNotificationDisplayService) {
        kotlin.jvm.internal.m.g(app, "app");
        kotlin.jvm.internal.m.g(walletsDatabase, "walletsDatabase");
        kotlin.jvm.internal.m.g(appDatabase, "appDatabase");
        kotlin.jvm.internal.m.g(consumerDatabase, "consumerDatabase");
        kotlin.jvm.internal.m.g(lendDatabase, "lendDatabase");
        kotlin.jvm.internal.m.g(walletDatabaseDestroyable, "walletDatabaseDestroyable");
        kotlin.jvm.internal.m.g(derivedDatabaseDestroyable, "derivedDatabaseDestroyable");
        kotlin.jvm.internal.m.g(walletLink, "walletLink");
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(destroyables, "destroyables");
        kotlin.jvm.internal.m.g(startables, "startables");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(migrations, "migrations");
        kotlin.jvm.internal.m.g(walletEngine, "walletEngine");
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(debugSettings, "debugSettings");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        kotlin.jvm.internal.m.g(pushNotificationRepository, "pushNotificationRepository");
        kotlin.jvm.internal.m.g(pushNotificationDisplayService, "pushNotificationDisplayService");
        this.app = app;
        this.walletsDatabase = walletsDatabase;
        this.appDatabase = appDatabase;
        this.consumerDatabase = consumerDatabase;
        this.lendDatabase = lendDatabase;
        this.walletDatabaseDestroyable = walletDatabaseDestroyable;
        this.derivedDatabaseDestroyable = derivedDatabaseDestroyable;
        this.walletLink = walletLink;
        this.appPrefs = appPrefs;
        this.destroyables = destroyables;
        this.startables = startables;
        this.store = store;
        this.appLockRepository = appLockRepository;
        this.migrations = migrations;
        this.walletEngine = walletEngine;
        this.cipherCore = cipherCore;
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        this.mnemonicRepository = mnemonicRepository;
        this.walletRepository = walletRepository;
        this.exchangeRateRepository = exchangeRateRepository;
        this.debugSettings = debugSettings;
        this.walletLinkRepository = walletLinkRepository;
        this.pushNotificationRepository = pushNotificationRepository;
        this.pushNotificationDisplayService = pushNotificationDisplayService;
        a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.concurrentScheduler = c2;
        this.disposeBag = new h.c.k0.a();
        observeBalanceUpdates();
    }

    public static /* synthetic */ x a(ApplicationService applicationService) {
        return m673reset$lambda11(applicationService);
    }

    public static /* synthetic */ h0 b(ApplicationService applicationService, List list) {
        return m670observeBalanceUpdates$lambda30(applicationService, list);
    }

    public static /* synthetic */ Object c(Provider provider) {
        return m686warmUp$lambda1$lambda0(provider);
    }

    private final void clearLegacySharedPrefences() {
        int r;
        List<String> a = e.j.l.g.a.a();
        r = kotlin.a0.s.r(a, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str : a) {
            SharedPreferences sharedPreferences = this.app.getSharedPreferences(str, 0);
            kotlin.jvm.internal.m.f(sharedPreferences, "app.getSharedPreferences(it, Context.MODE_PRIVATE)");
            e.j.f.s.b(sharedPreferences);
            arrayList.add(x.a);
        }
    }

    public static /* synthetic */ boolean d(Boolean bool) {
        return m685start$lambda6(bool);
    }

    /* renamed from: destroy$lambda-20$lambda-19 */
    public static final Boolean m665destroy$lambda20$lambda19(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.TRUE;
    }

    /* renamed from: destroy$lambda-23 */
    public static final x m666destroy$lambda23(ApplicationService this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.appLockRepository.get().setIsAppLocked(true);
        this$0.mnemonicRepository.deleteMnemonic();
        this$0.appPrefs.get().r(false);
        this$0.clearLegacySharedPrefences();
        this$0.mnemonicBackupRepository.destroy();
        this$0.store.get().destroy();
        this$0.walletsDatabase.get().destroy();
        this$0.appDatabase.get().destroy();
        this$0.consumerDatabase.get().destroy();
        this$0.lendDatabase.get().destroy();
        for (Session session : this$0.walletLink.get().sessions()) {
            b0<x> subscribeOn = this$0.walletLink.get().unlink(session).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.o
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ApplicationService.o((Throwable) obj);
                }
            }).subscribeOn(this$0.concurrentScheduler);
            kotlin.jvm.internal.m.f(subscribeOn, "walletLink\n                        .get()\n                        .unlink(it)\n                        .onErrorReturn { Unit }\n                        .subscribeOn(concurrentScheduler)");
            h.c.t0.g.i(subscribeOn, null, ApplicationService$destroy$3$1$2.INSTANCE, 1, null);
        }
        return x.a;
    }

    /* renamed from: destroy$lambda-23$lambda-22$lambda-21 */
    public static final x m667destroy$lambda23$lambda22$lambda21(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: destroy$lambda-24 */
    public static final x m668destroy$lambda24(x it) {
        kotlin.jvm.internal.m.g(it, "it");
        l.a.a.a("Successfully destroyed all data stores", new Object[0]);
        return x.a;
    }

    public static /* synthetic */ kotlin.o e(Wallet wallet, Boolean bool) {
        return m671observeBalanceUpdates$lambda30$lambda29$lambda28(wallet, bool);
    }

    public static /* synthetic */ Boolean f(Throwable th) {
        return m675reset$lambda15$lambda13(th);
    }

    public static /* synthetic */ x g(ApplicationService applicationService, kotlin.t tVar) {
        return m677reset$lambda16(applicationService, tVar);
    }

    public static /* synthetic */ x h(x xVar) {
        return m668destroy$lambda24(xVar);
    }

    public static /* synthetic */ String i(String str) {
        return m682start$lambda3(str);
    }

    public static /* synthetic */ x j(ApplicationService applicationService) {
        return m680start$lambda10$lambda9(applicationService);
    }

    public static /* synthetic */ h0 k(ApplicationService applicationService, x xVar) {
        return m674reset$lambda15(applicationService, xVar);
    }

    public static /* synthetic */ h.c.x l(ApplicationService applicationService, x xVar) {
        return m684start$lambda5(applicationService, xVar);
    }

    public static /* synthetic */ Boolean m(Throwable th) {
        return m676reset$lambda15$lambda14(th);
    }

    public static /* synthetic */ x n(x xVar) {
        return m678reset$lambda17(xVar);
    }

    public static /* synthetic */ x o(Throwable th) {
        return m667destroy$lambda23$lambda22$lambda21(th);
    }

    private final void observeBalanceUpdates() {
        h.c.s map = h.c.s.just(this.walletRepository.get()).delay(5L, TimeUnit.SECONDS).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.u((IWalletRepository) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.b(ApplicationService.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.p((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "just(walletRepository.get())\n            .delay(5, TimeUnit.SECONDS)\n            .flatMap { it.observeWallets() }\n            .flatMapSingle { wallets ->\n                wallets\n                    .filter { !it.network.isTestnet }\n                    .map { wallet ->\n                        walletRepository.get().isSynced(wallet.blockchain, wallet.network)\n                            .takeSingle()\n                            .map { Pair(wallet, it) }\n                    }\n                    .zipOrEmpty()\n            }\n            .map { entries -> entries.mapNotNull { if (it.second) it.first else null } }");
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(map, "Unable to report balance updates events", null, 2, null), null, null, new ApplicationService$observeBalanceUpdates$4(this), 3, null), this.disposeBag);
    }

    /* renamed from: observeBalanceUpdates$lambda-26 */
    public static final h.c.x m669observeBalanceUpdates$lambda26(IWalletRepository it) {
        kotlin.jvm.internal.m.g(it, "it");
        return IWalletRepository.DefaultImpls.observeWallets$default(it, false, 1, null);
    }

    /* renamed from: observeBalanceUpdates$lambda-30 */
    public static final h0 m670observeBalanceUpdates$lambda30(ApplicationService this$0, List wallets) {
        int r;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList<Wallet> arrayList = new ArrayList();
        for (Object obj : wallets) {
            if (!((Wallet) obj).getNetwork().isTestnet()) {
                arrayList.add(obj);
            }
        }
        r = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (final Wallet wallet : arrayList) {
            arrayList2.add(Observable_CoreKt.takeSingle(this$0.walletRepository.get().isSynced(wallet.getBlockchain(), wallet.getNetwork())).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.e
                @Override // h.c.m0.n
                public final Object apply(Object obj2) {
                    return ApplicationService.e(Wallet.this, (Boolean) obj2);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = kotlin.a0.r.g();
            b0 just = b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        b0 zip = b0.zip(arrayList2, new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.ApplicationService$observeBalanceUpdates$lambda-30$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it, "it");
                if (it.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList3 = new ArrayList();
                int length = it.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj2 = it[i2];
                    if (obj2 != null ? obj2 instanceof kotlin.o : true) {
                        arrayList3.add(obj2);
                    }
                }
                return arrayList3;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: observeBalanceUpdates$lambda-30$lambda-29$lambda-28 */
    public static final kotlin.o m671observeBalanceUpdates$lambda30$lambda29$lambda28(Wallet wallet, Boolean it) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(wallet, it);
    }

    /* renamed from: observeBalanceUpdates$lambda-32 */
    public static final List m672observeBalanceUpdates$lambda32(List entries) {
        kotlin.jvm.internal.m.g(entries, "entries");
        ArrayList arrayList = new ArrayList();
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            Object d2 = oVar.d();
            kotlin.jvm.internal.m.f(d2, "it.second");
            Wallet wallet = ((Boolean) d2).booleanValue() ? (Wallet) oVar.c() : null;
            if (wallet != null) {
                arrayList.add(wallet);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List p(List list) {
        return m672observeBalanceUpdates$lambda32(list);
    }

    public static /* synthetic */ x q(ApplicationService applicationService, x xVar) {
        return m683start$lambda4(applicationService, xVar);
    }

    public static /* synthetic */ x r(ApplicationService applicationService, List list) {
        return m666destroy$lambda23(applicationService, list);
    }

    /* renamed from: reset$lambda-11 */
    public static final x m673reset$lambda11(ApplicationService this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.store.get().removeAll(StoreKind.values());
        this$0.walletsDatabase.get().reset();
        this$0.appDatabase.get().reset();
        this$0.consumerDatabase.get().reset();
        this$0.lendDatabase.get().reset();
        return x.a;
    }

    /* renamed from: reset$lambda-15 */
    public static final h0 m674reset$lambda15(ApplicationService this$0, x it) {
        int r;
        b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        h.c.t0.e eVar = h.c.t0.e.a;
        List<Session> sessions = this$0.walletLink.get().sessions();
        r = kotlin.a0.s.r(sessions, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Session session : sessions) {
            arrayList.add(this$0.walletLink.get().unlink(session));
        }
        h.c.t0.e eVar2 = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.ApplicationService$reset$lambda-15$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof x) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        b0<Boolean> onErrorReturn = this$0.walletDatabaseDestroyable.get().destroy().onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.f((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "walletDatabaseDestroyable.get().destroy().onErrorReturn { true }");
        b0<Boolean> onErrorReturn2 = this$0.derivedDatabaseDestroyable.get().destroy().onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.m((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn2, "derivedDatabaseDestroyable.get().destroy().onErrorReturn { true }");
        return eVar.b(zip, onErrorReturn, onErrorReturn2);
    }

    /* renamed from: reset$lambda-15$lambda-13 */
    public static final Boolean m675reset$lambda15$lambda13(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.TRUE;
    }

    /* renamed from: reset$lambda-15$lambda-14 */
    public static final Boolean m676reset$lambda15$lambda14(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.TRUE;
    }

    /* renamed from: reset$lambda-16 */
    public static final x m677reset$lambda16(ApplicationService this$0, kotlin.t it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.clearLegacySharedPrefences();
        return x.a;
    }

    /* renamed from: reset$lambda-17 */
    public static final x m678reset$lambda17(x it) {
        kotlin.jvm.internal.m.g(it, "it");
        l.a.a.a("Successfully cleared all data stores", new Object[0]);
        return x.a;
    }

    public static /* synthetic */ h0 s(ApplicationService applicationService, Boolean bool) {
        return m679start$lambda10(applicationService, bool);
    }

    /* renamed from: start$lambda-10 */
    public static final h0 m679start$lambda10(ApplicationService this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.application.service.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ApplicationService.j(ApplicationService.this);
            }
        });
    }

    /* renamed from: start$lambda-10$lambda-9 */
    public static final x m680start$lambda10$lambda9(ApplicationService this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Map<Integer, Provider<Startable>> map = this$0.startables;
        ArrayList<Startable> arrayList = new ArrayList(map.size());
        for (Map.Entry<Integer, Provider<Startable>> entry : map.entrySet()) {
            arrayList.add(entry.getValue().get());
        }
        for (Startable startable : arrayList) {
            startable.start();
        }
        return x.a;
    }

    /* renamed from: start$lambda-2 */
    public static final Optional m681start$lambda2(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        Wallet wallet = (Wallet) it.getValue();
        return OptionalKt.toOptional(wallet == null ? null : wallet.getPrimaryAddress());
    }

    /* renamed from: start$lambda-3 */
    public static final String m682start$lambda3(String address) {
        String r1;
        kotlin.jvm.internal.m.g(address, "address");
        Locale US = Locale.US;
        kotlin.jvm.internal.m.f(US, "US");
        String lowerCase = address.toLowerCase(US);
        kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        r1 = kotlin.l0.a0.r1(String_CryptoKt.sha256(lowerCase), new kotlin.i0.c(0, 31));
        return r1;
    }

    /* renamed from: start$lambda-4 */
    public static final x m683start$lambda4(ApplicationService this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.pushNotificationRepository.get().start();
        this$0.pushNotificationDisplayService.get().start();
        this$0.walletLinkRepository.get().start();
        return x.a;
    }

    /* renamed from: start$lambda-5 */
    public static final h.c.x m684start$lambda5(ApplicationService this$0, x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.appLockRepository.get().isAppLockedObservable();
    }

    /* renamed from: start$lambda-6 */
    public static final boolean m685start$lambda6(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.booleanValue();
    }

    public static /* synthetic */ Boolean t(Throwable th) {
        return m665destroy$lambda20$lambda19(th);
    }

    public static /* synthetic */ h.c.x u(IWalletRepository iWalletRepository) {
        return m669observeBalanceUpdates$lambda26(iWalletRepository);
    }

    public static /* synthetic */ Optional v(Optional optional) {
        return m681start$lambda2(optional);
    }

    /* renamed from: warmUp$lambda-1$lambda-0 */
    public static final Object m686warmUp$lambda1$lambda0(Provider provider) {
        kotlin.jvm.internal.m.g(provider, "$provider");
        return provider.get();
    }

    public final b0<x> destroy() {
        int r;
        b0 zip;
        List g2;
        Map<Integer, Provider<Destroyable>> map = this.destroyables;
        ArrayList<Destroyable> arrayList = new ArrayList(map.size());
        for (Map.Entry<Integer, Provider<Destroyable>> entry : map.entrySet()) {
            arrayList.add(entry.getValue().get());
        }
        r = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (Destroyable destroyable : arrayList) {
            arrayList2.add(destroyable.destroy().onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.t
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ApplicationService.t((Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList2, new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.ApplicationService$destroy$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof Boolean : true) {
                            arrayList3.add(obj);
                        }
                    }
                    return arrayList3;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        b0<x> map2 = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.r(ApplicationService.this, (List) obj);
            }
        }).subscribeOn(this.concurrentScheduler).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.h((x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "destroyables\n        .map { it.value.get() }\n        .map { it.destroy().onErrorReturn { true } }\n        .zipOrEmpty()\n        .map {\n            appLockRepository.get().setIsAppLocked(true)\n            mnemonicRepository.deleteMnemonic()\n            appPrefs.get().setHasBackedUpPhrase(false)\n            clearLegacySharedPrefences()\n            mnemonicBackupRepository.destroy()\n            store.get().destroy()\n            walletsDatabase.get().destroy()\n            appDatabase.get().destroy()\n            consumerDatabase.get().destroy()\n            lendDatabase.get().destroy()\n            walletLink.get().sessions()\n                .forEach {\n                    walletLink\n                        .get()\n                        .unlink(it)\n                        .onErrorReturn { Unit }\n                        .subscribeOn(concurrentScheduler).subscribeBy { }\n                }\n        }\n        .subscribeOn(concurrentScheduler)\n        .map { Timber.d(\"Successfully destroyed all data stores\") }");
        return map2;
    }

    public final b0<x> reset() {
        b0<x> map = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.application.service.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ApplicationService.a(ApplicationService.this);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.k(ApplicationService.this, (x) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.g(ApplicationService.this, (kotlin.t) obj);
            }
        }).subscribeOn(this.concurrentScheduler).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.n((x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "fromCallable {\n            store.get().removeAll(StoreKind.values())\n            walletsDatabase.get().reset()\n            appDatabase.get().reset()\n            consumerDatabase.get().reset()\n            lendDatabase.get().reset()\n\n            Unit\n        }\n        .flatMap {\n            Singles.zip(\n                walletLink.get().sessions().map { walletLink.get().unlink(it) }.zipOrEmpty(),\n                walletDatabaseDestroyable.get().destroy().onErrorReturn { true },\n                derivedDatabaseDestroyable.get().destroy().onErrorReturn { true }\n            )\n        }\n        .map { clearLegacySharedPrefences() }\n        .subscribeOn(concurrentScheduler)\n        .map { Timber.d(\"Successfully cleared all data stores\") }");
        return map;
    }

    public final b0<x> start() {
        l.a.a.h(new e.j.l.u.a(null, 1, null));
        IWalletRepository iWalletRepository = this.walletRepository.get();
        kotlin.jvm.internal.m.f(iWalletRepository, "walletRepository.get()");
        h.c.s<R> map = WalletRepository_CommonKt.observeWallet(iWalletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.v((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.get()\n            .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)\n            .map { it.value?.primaryAddress.toOptional() }");
        h.c.s map2 = map.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.application.service.ApplicationService$start$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.ApplicationService$start$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.s map3 = map2.map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.i((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map3, "walletRepository.get()\n            .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)\n            .map { it.value?.primaryAddress.toOptional() }\n            .unwrap()\n            .map { address -> address.toLowerCase(Locale.US).sha256().slice(IntRange(0, 31)) }");
        b0<String> takeSingle = Observable_CoreKt.takeSingle(map3);
        Analytics analytics = Analytics.INSTANCE;
        analytics.setup(this.app, "4b5c59547a46317aee88399fdfc8f1f3", takeSingle);
        analytics.log(AnalyticsEvent_ApplicationKt.appStart(AnalyticsEvent.Companion));
        AppsFlyerLib.getInstance().init(BuildConfig.APPSFLYER_KEY, null, this.app);
        AppsFlyerLib.getInstance().startTracking(this.app);
        e.j.l.f.a.a(this.app);
        SharedPreferences sharedPreferences = this.app.getSharedPreferences("usm", 0);
        kotlin.jvm.internal.m.f(sharedPreferences, "app.getSharedPreferences(FileNames.USER_PREFS, Context.MODE_PRIVATE)");
        SharedPreferences sharedPreferences2 = this.app.getSharedPreferences("lp", 0);
        kotlin.jvm.internal.m.f(sharedPreferences2, "app.getSharedPreferences(FileNames.LOCK_PREFS, Context.MODE_PRIVATE)");
        new e.j.j.p(sharedPreferences, sharedPreferences2).a();
        this.mnemonicBackupRepository.start();
        h.c.s<HostRequestId> childConnectedObservable = this.walletLinkRepository.get().getChildConnectedObservable();
        kotlin.jvm.internal.m.f(childConnectedObservable, "walletLinkRepository.get().childConnectedObservable");
        h.c.t0.a.a(h.c.t0.g.h(childConnectedObservable, null, null, ApplicationService$start$1.INSTANCE, 3, null), this.disposeBag);
        h.c.s filter = this.migrations.get().execute().map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.q(ApplicationService.this, (x) obj);
            }
        }).flatMapObservable(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.l(ApplicationService.this, (x) obj);
            }
        }).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.application.service.d
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ApplicationService.d((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "migrations.get().execute()\n            .map {\n                pushNotificationRepository.get().start()\n                pushNotificationDisplayService.get().start()\n                walletLinkRepository.get().start()\n            }\n            .flatMapObservable { appLockRepository.get().isAppLockedObservable }\n            .filter { !it }");
        b0 flatMap = Observable_CoreKt.takeSingle(filter).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ApplicationService.s(ApplicationService.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "migrations.get().execute()\n            .map {\n                pushNotificationRepository.get().start()\n                pushNotificationDisplayService.get().start()\n                walletLinkRepository.get().start()\n            }\n            .flatMapObservable { appLockRepository.get().isAppLockedObservable }\n            .filter { !it }\n            .takeSingle()\n            .flatMap {\n                Single.fromCallable {\n                    startables\n                        .map { it.value.get() }\n                        .forEach { it.start() }\n                }\n            }");
        return Single_AnalyticsKt.logError$default(flatMap, "Unable to setup app", null, 2, null);
    }

    public final b0<x> warmUp() {
        List<Provider> m;
        int r;
        b0 zip;
        List g2;
        m = kotlin.a0.r.m(this.walletRepository, this.exchangeRateRepository, this.walletEngine, this.cipherCore);
        m.addAll(this.startables.values());
        r = kotlin.a0.s.r(m, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final Provider provider : m) {
            arrayList.add(b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.application.service.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ApplicationService.c(Provider.this);
                }
            }).subscribeOn(this.concurrentScheduler));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.application.service.ApplicationService$warmUp$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it) {
                        arrayList2.add(obj);
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }
}