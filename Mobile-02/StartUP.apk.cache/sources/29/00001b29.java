package com.coinbase.wallet.di;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Cache;

/* compiled from: DestroyableModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/coinbase/wallet/di/DestroyableModule;", "", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "accountsDestroyable", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "providesConsumerAccountsDestroyable", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "userDestroyable", "providesConsumerUserDestroyable", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/toshi/db/e;", "walletDatabaseDestroyable", "providesWalletDatabaseDestroyable", "(Lcom/toshi/db/e;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/toshi/db/c;", "derivedDatabaseDestroyable", "providesDerivedDatabaseDestroyable", "(Lcom/toshi/db/c;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;", "pushNotificationRepository", "providesPushNotificationRepository", "(Lcom/coinbase/wallet/features/pushnotifications/repositories/PushNotificationRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "(Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "providesFiatCurrencyDestroyable", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "providesExchangeRateRepositoryDestroyable", "(Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "providesTxHistoryRepositoryDestroyable", "(Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "providesUserRepositoryDestroyable", "(Lcom/coinbase/wallet/user/repositories/UserRepository;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class DestroyableModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: DestroyableModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/di/DestroyableModule$Companion;", "", "Lokhttp3/Cache;", "cache", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "providesCacheDestroyable", "(Lokhttp3/Cache;)Lcom/coinbase/wallet/core/interfaces/Destroyable;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final Destroyable providesCacheDestroyable(Cache cache) {
            m.g(cache, "cache");
            return new DestroyableModule$Companion$providesCacheDestroyable$1(cache);
        }
    }

    @ApplicationScoped
    public static final Destroyable providesCacheDestroyable(Cache cache) {
        return Companion.providesCacheDestroyable(cache);
    }

    public abstract Destroyable compoundFinanceRepository(CompoundFinanceRepository compoundFinanceRepository);

    public abstract Destroyable currencyFormatter(CurrencyFormatter currencyFormatter);

    public abstract Destroyable providesConsumerAccountsDestroyable(ConsumerAccountsRepository consumerAccountsRepository);

    public abstract Destroyable providesConsumerUserDestroyable(ConsumerUserRepository consumerUserRepository);

    public abstract Destroyable providesDerivedDatabaseDestroyable(com.toshi.db.c cVar);

    public abstract Destroyable providesExchangeRateRepositoryDestroyable(IExchangeRateRepository iExchangeRateRepository);

    public abstract Destroyable providesFiatCurrencyDestroyable(IFiatCurrencyRepository iFiatCurrencyRepository);

    public abstract Destroyable providesPushNotificationRepository(PushNotificationRepository pushNotificationRepository);

    public abstract Destroyable providesTxHistoryRepositoryDestroyable(TxHistoryRepository txHistoryRepository);

    public abstract Destroyable providesUserRepositoryDestroyable(UserRepository userRepository);

    public abstract Destroyable providesWalletDatabaseDestroyable(com.toshi.db.e eVar);

    public abstract Destroyable txRepository(ITxRepository iTxRepository);

    public abstract Destroyable walletRepository(IWalletRepository iWalletRepository);
}