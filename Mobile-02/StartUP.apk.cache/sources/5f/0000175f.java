package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel_AssistedFactory_Factory implements f.c.d<ConsumerAmountPickerViewModel_AssistedFactory> {
    private final Provider<AmountViewModel> amountViewModelProvider;
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IFiatCurrencyRepository> currencyRepositoryProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public ConsumerAmountPickerViewModel_AssistedFactory_Factory(Provider<IFiatCurrencyRepository> provider, Provider<AmountViewModel> provider2, Provider<IWalletRepository> provider3, Provider<CurrencyFormatter> provider4, Provider<StoreInterface> provider5, Provider<ConsumerTransferRepository> provider6, Provider<IExchangeRateRepository> provider7) {
        this.currencyRepositoryProvider = provider;
        this.amountViewModelProvider = provider2;
        this.walletRepositoryProvider = provider3;
        this.currencyFormatterProvider = provider4;
        this.storeProvider = provider5;
        this.consumerTransferRepositoryProvider = provider6;
        this.exchangeRateRepositoryProvider = provider7;
    }

    public static ConsumerAmountPickerViewModel_AssistedFactory_Factory create(Provider<IFiatCurrencyRepository> provider, Provider<AmountViewModel> provider2, Provider<IWalletRepository> provider3, Provider<CurrencyFormatter> provider4, Provider<StoreInterface> provider5, Provider<ConsumerTransferRepository> provider6, Provider<IExchangeRateRepository> provider7) {
        return new ConsumerAmountPickerViewModel_AssistedFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ConsumerAmountPickerViewModel_AssistedFactory newInstance(Provider<IFiatCurrencyRepository> provider, Provider<AmountViewModel> provider2, Provider<IWalletRepository> provider3, Provider<CurrencyFormatter> provider4, Provider<StoreInterface> provider5, Provider<ConsumerTransferRepository> provider6, Provider<IExchangeRateRepository> provider7) {
        return new ConsumerAmountPickerViewModel_AssistedFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public ConsumerAmountPickerViewModel_AssistedFactory get() {
        return newInstance(this.currencyRepositoryProvider, this.amountViewModelProvider, this.walletRepositoryProvider, this.currencyFormatterProvider, this.storeProvider, this.consumerTransferRepositoryProvider, this.exchangeRateRepositoryProvider);
    }
}