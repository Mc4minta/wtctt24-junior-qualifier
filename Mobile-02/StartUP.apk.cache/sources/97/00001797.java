package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationViewModel_AssistedFactory implements ConsumerTransferConfirmationViewModel.Factory {
    private final Provider<ConsumerTransferRepository> consumerTransferRepository;
    private final Provider<CurrencyFormatter> currencyFormatter;

    public ConsumerTransferConfirmationViewModel_AssistedFactory(Provider<ConsumerTransferRepository> provider, Provider<CurrencyFormatter> provider2) {
        this.consumerTransferRepository = provider;
        this.currencyFormatter = provider2;
    }

    @Override // com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel.Factory
    public ConsumerTransferConfirmationViewModel create(androidx.lifecycle.z zVar) {
        return new ConsumerTransferConfirmationViewModel(this.consumerTransferRepository.get(), this.currencyFormatter.get(), zVar);
    }
}