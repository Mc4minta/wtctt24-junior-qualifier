package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendDashboardViewModel_Factory implements f.c.d<LendDashboardViewModel> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;
    private final Provider<ILendRepository> lendRepositoryProvider;
    private final Provider<TxHistoryRepository> txHistoryRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public LendDashboardViewModel_Factory(Provider<TxHistoryRepository> provider, Provider<IWalletRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<ILendRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<IFiatCurrencyRepository> provider6, Provider<CipherCoreInterface> provider7) {
        this.txHistoryRepositoryProvider = provider;
        this.walletRepositoryProvider = provider2;
        this.currencyFormatterProvider = provider3;
        this.lendRepositoryProvider = provider4;
        this.exchangeRateRepositoryProvider = provider5;
        this.fiatCurrencyRepositoryProvider = provider6;
        this.cipherCoreProvider = provider7;
    }

    public static LendDashboardViewModel_Factory create(Provider<TxHistoryRepository> provider, Provider<IWalletRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<ILendRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<IFiatCurrencyRepository> provider6, Provider<CipherCoreInterface> provider7) {
        return new LendDashboardViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static LendDashboardViewModel newInstance(TxHistoryRepository txHistoryRepository, IWalletRepository iWalletRepository, CurrencyFormatter currencyFormatter, ILendRepository iLendRepository, IExchangeRateRepository iExchangeRateRepository, IFiatCurrencyRepository iFiatCurrencyRepository, CipherCoreInterface cipherCoreInterface) {
        return new LendDashboardViewModel(txHistoryRepository, iWalletRepository, currencyFormatter, iLendRepository, iExchangeRateRepository, iFiatCurrencyRepository, cipherCoreInterface);
    }

    @Override // javax.inject.Provider
    public LendDashboardViewModel get() {
        return newInstance(this.txHistoryRepositoryProvider.get(), this.walletRepositoryProvider.get(), this.currencyFormatterProvider.get(), this.lendRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.fiatCurrencyRepositoryProvider.get(), this.cipherCoreProvider.get());
    }
}