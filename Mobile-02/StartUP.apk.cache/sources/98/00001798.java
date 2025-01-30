package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationViewModel_AssistedFactory_Factory implements f.c.d<ConsumerTransferConfirmationViewModel_AssistedFactory> {
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;

    public ConsumerTransferConfirmationViewModel_AssistedFactory_Factory(Provider<ConsumerTransferRepository> provider, Provider<CurrencyFormatter> provider2) {
        this.consumerTransferRepositoryProvider = provider;
        this.currencyFormatterProvider = provider2;
    }

    public static ConsumerTransferConfirmationViewModel_AssistedFactory_Factory create(Provider<ConsumerTransferRepository> provider, Provider<CurrencyFormatter> provider2) {
        return new ConsumerTransferConfirmationViewModel_AssistedFactory_Factory(provider, provider2);
    }

    public static ConsumerTransferConfirmationViewModel_AssistedFactory newInstance(Provider<ConsumerTransferRepository> provider, Provider<CurrencyFormatter> provider2) {
        return new ConsumerTransferConfirmationViewModel_AssistedFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public ConsumerTransferConfirmationViewModel_AssistedFactory get() {
        return newInstance(this.consumerTransferRepositoryProvider, this.currencyFormatterProvider);
    }
}