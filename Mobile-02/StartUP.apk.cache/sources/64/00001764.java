package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsViewModel_Factory implements f.c.d<ConsumerAvailablePaymentMethodsViewModel> {
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;

    public ConsumerAvailablePaymentMethodsViewModel_Factory(Provider<ConsumerTransferRepository> provider) {
        this.consumerTransferRepositoryProvider = provider;
    }

    public static ConsumerAvailablePaymentMethodsViewModel_Factory create(Provider<ConsumerTransferRepository> provider) {
        return new ConsumerAvailablePaymentMethodsViewModel_Factory(provider);
    }

    public static ConsumerAvailablePaymentMethodsViewModel newInstance(ConsumerTransferRepository consumerTransferRepository) {
        return new ConsumerAvailablePaymentMethodsViewModel(consumerTransferRepository);
    }

    @Override // javax.inject.Provider
    public ConsumerAvailablePaymentMethodsViewModel get() {
        return newInstance(this.consumerTransferRepositoryProvider.get());
    }
}