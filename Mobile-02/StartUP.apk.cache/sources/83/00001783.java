package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerSendTwoFactorViewModel_Factory implements f.c.d<ConsumerSendTwoFactorViewModel> {
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;

    public ConsumerSendTwoFactorViewModel_Factory(Provider<ConsumerTransferRepository> provider) {
        this.consumerTransferRepositoryProvider = provider;
    }

    public static ConsumerSendTwoFactorViewModel_Factory create(Provider<ConsumerTransferRepository> provider) {
        return new ConsumerSendTwoFactorViewModel_Factory(provider);
    }

    public static ConsumerSendTwoFactorViewModel newInstance(ConsumerTransferRepository consumerTransferRepository) {
        return new ConsumerSendTwoFactorViewModel(consumerTransferRepository);
    }

    @Override // javax.inject.Provider
    public ConsumerSendTwoFactorViewModel get() {
        return newInstance(this.consumerTransferRepositoryProvider.get());
    }
}