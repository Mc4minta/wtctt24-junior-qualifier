package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferMethodsViewModel_AssistedFactory_Factory implements f.c.d<ConsumerTransferMethodsViewModel_AssistedFactory> {
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;

    public ConsumerTransferMethodsViewModel_AssistedFactory_Factory(Provider<CurrencyFormatter> provider, Provider<ConsumerTransferRepository> provider2) {
        this.currencyFormatterProvider = provider;
        this.consumerTransferRepositoryProvider = provider2;
    }

    public static ConsumerTransferMethodsViewModel_AssistedFactory_Factory create(Provider<CurrencyFormatter> provider, Provider<ConsumerTransferRepository> provider2) {
        return new ConsumerTransferMethodsViewModel_AssistedFactory_Factory(provider, provider2);
    }

    public static ConsumerTransferMethodsViewModel_AssistedFactory newInstance(Provider<CurrencyFormatter> provider, Provider<ConsumerTransferRepository> provider2) {
        return new ConsumerTransferMethodsViewModel_AssistedFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public ConsumerTransferMethodsViewModel_AssistedFactory get() {
        return newInstance(this.currencyFormatterProvider, this.consumerTransferRepositoryProvider);
    }
}