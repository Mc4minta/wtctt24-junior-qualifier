package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAmountPickerViewModel_AssistedFactory implements ConsumerAmountPickerViewModel.Factory {
    private final Provider<AmountViewModel> amountViewModel;
    private final Provider<ConsumerTransferRepository> consumerTransferRepository;
    private final Provider<CurrencyFormatter> currencyFormatter;
    private final Provider<IFiatCurrencyRepository> currencyRepository;
    private final Provider<IExchangeRateRepository> exchangeRateRepository;
    private final Provider<StoreInterface> store;
    private final Provider<IWalletRepository> walletRepository;

    public ConsumerAmountPickerViewModel_AssistedFactory(Provider<IFiatCurrencyRepository> provider, Provider<AmountViewModel> provider2, Provider<IWalletRepository> provider3, Provider<CurrencyFormatter> provider4, Provider<StoreInterface> provider5, Provider<ConsumerTransferRepository> provider6, Provider<IExchangeRateRepository> provider7) {
        this.currencyRepository = provider;
        this.amountViewModel = provider2;
        this.walletRepository = provider3;
        this.currencyFormatter = provider4;
        this.store = provider5;
        this.consumerTransferRepository = provider6;
        this.exchangeRateRepository = provider7;
    }

    @Override // com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel.Factory
    public ConsumerAmountPickerViewModel create(androidx.lifecycle.z zVar) {
        return new ConsumerAmountPickerViewModel(this.currencyRepository.get(), this.amountViewModel.get(), this.walletRepository.get(), this.currencyFormatter.get(), this.store.get(), this.consumerTransferRepository.get(), this.exchangeRateRepository.get(), zVar);
    }
}