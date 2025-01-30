package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferMethodsViewModel_AssistedFactory implements ConsumerTransferMethodsViewModel.Factory {
    private final Provider<ConsumerTransferRepository> consumerTransferRepository;
    private final Provider<CurrencyFormatter> currencyFormatter;

    public ConsumerTransferMethodsViewModel_AssistedFactory(Provider<CurrencyFormatter> provider, Provider<ConsumerTransferRepository> provider2) {
        this.currencyFormatter = provider;
        this.consumerTransferRepository = provider2;
    }

    @Override // com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel.Factory
    public ConsumerTransferMethodsViewModel create(androidx.lifecycle.z zVar) {
        return new ConsumerTransferMethodsViewModel(this.currencyFormatter.get(), this.consumerTransferRepository.get(), zVar);
    }
}