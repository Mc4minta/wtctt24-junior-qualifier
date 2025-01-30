package com.coinbase.wallet.features.wallets.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ActionItemsViewModel_Factory implements f.c.d<ActionItemsViewModel> {
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;
    private final Provider<ILendRepository> lendRepositoryProvider;
    private final Provider<TxHistoryRepository> txHistoryRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public ActionItemsViewModel_Factory(Provider<ILendRepository> provider, Provider<TxHistoryRepository> provider2, Provider<IWalletRepository> provider3, Provider<IExchangeRateRepository> provider4, Provider<IFiatCurrencyRepository> provider5, Provider<FeatureFlagsRepository> provider6, Provider<ConsumerUserRepository> provider7, Provider<CurrencyFormatter> provider8) {
        this.lendRepositoryProvider = provider;
        this.txHistoryRepositoryProvider = provider2;
        this.walletRepositoryProvider = provider3;
        this.exchangeRateRepositoryProvider = provider4;
        this.fiatCurrencyRepositoryProvider = provider5;
        this.featureFlagsRepositoryProvider = provider6;
        this.consumerUserRepositoryProvider = provider7;
        this.currencyFormatterProvider = provider8;
    }

    public static ActionItemsViewModel_Factory create(Provider<ILendRepository> provider, Provider<TxHistoryRepository> provider2, Provider<IWalletRepository> provider3, Provider<IExchangeRateRepository> provider4, Provider<IFiatCurrencyRepository> provider5, Provider<FeatureFlagsRepository> provider6, Provider<ConsumerUserRepository> provider7, Provider<CurrencyFormatter> provider8) {
        return new ActionItemsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ActionItemsViewModel newInstance(ILendRepository iLendRepository, TxHistoryRepository txHistoryRepository, IWalletRepository iWalletRepository, IExchangeRateRepository iExchangeRateRepository, IFiatCurrencyRepository iFiatCurrencyRepository, FeatureFlagsRepository featureFlagsRepository, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter) {
        return new ActionItemsViewModel(iLendRepository, txHistoryRepository, iWalletRepository, iExchangeRateRepository, iFiatCurrencyRepository, featureFlagsRepository, consumerUserRepository, currencyFormatter);
    }

    @Override // javax.inject.Provider
    public ActionItemsViewModel get() {
        return newInstance(this.lendRepositoryProvider.get(), this.txHistoryRepositoryProvider.get(), this.walletRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.fiatCurrencyRepositoryProvider.get(), this.featureFlagsRepositoryProvider.get(), this.consumerUserRepositoryProvider.get(), this.currencyFormatterProvider.get());
    }
}