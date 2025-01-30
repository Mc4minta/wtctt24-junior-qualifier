package com.coinbase.wallet.di;

import com.coinbase.wallet.application.repository.NotificationRepository;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.send.repositories.RecipientRepository;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import e.j.i.c2;
import e.j.i.w1;
import e.j.i.y1;
import kotlin.Metadata;

/* compiled from: StartableModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H'¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;H'¢\u0006\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/coinbase/wallet/di/StartableModule;", "", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/core/interfaces/Startable;", "providesFeatureRepositoryStartable", "(Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "providesExchangeRateStartable", "(Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "providesUserStartable", "(Lcom/coinbase/wallet/user/repositories/UserRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Le/j/i/w1;", "collectibleTypesRepository", "providesCollectibleTypesStartable", "(Le/j/i/w1;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "providesFiatCurrencyStartable", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/application/repository/NotificationRepository;", "notificationRepository", "providesNotificationStartable", "(Lcom/coinbase/wallet/application/repository/NotificationRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Le/j/i/c2;", "refreshService", "providesRefreshServiceStartable", "(Le/j/i/c2;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "consumerAccountsRepo", "providesConsumerAccountsRepository", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "(Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "txHistoryRepository", "provideTxHistoryStartable", "(Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/features/send/repositories/RecipientRepository;", "recipientRepository", "provideRecipientRepositoryStartable", "(Lcom/coinbase/wallet/features/send/repositories/RecipientRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/lending/interfaces/ILendRepository;", "lendRepository", "providesLendRepositoryStartable", "(Lcom/coinbase/wallet/lending/interfaces/ILendRepository;)Lcom/coinbase/wallet/core/interfaces/Startable;", "Le/j/i/y1;", "erc721Repository", "providesErc721Startable", "(Le/j/i/y1;)Lcom/coinbase/wallet/core/interfaces/Startable;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class StartableModule {
    public abstract Startable compoundFinanceRepository(CompoundFinanceRepository compoundFinanceRepository);

    public abstract Startable currencyFormatter(CurrencyFormatter currencyFormatter);

    public abstract Startable provideRecipientRepositoryStartable(RecipientRepository recipientRepository);

    public abstract Startable provideTxHistoryStartable(TxHistoryRepository txHistoryRepository);

    public abstract Startable providesCollectibleTypesStartable(w1 w1Var);

    public abstract Startable providesConsumerAccountsRepository(ConsumerAccountsRepository consumerAccountsRepository);

    public abstract Startable providesErc721Startable(y1 y1Var);

    public abstract Startable providesExchangeRateStartable(IExchangeRateRepository iExchangeRateRepository);

    public abstract Startable providesFeatureRepositoryStartable(FeatureFlagsRepository featureFlagsRepository);

    public abstract Startable providesFiatCurrencyStartable(IFiatCurrencyRepository iFiatCurrencyRepository);

    public abstract Startable providesLendRepositoryStartable(ILendRepository iLendRepository);

    public abstract Startable providesNotificationStartable(NotificationRepository notificationRepository);

    public abstract Startable providesRefreshServiceStartable(c2 c2Var);

    public abstract Startable providesUserStartable(UserRepository userRepository);

    public abstract Startable txRepository(ITxRepository iTxRepository);

    public abstract Startable walletRepository(IWalletRepository iWalletRepository);
}