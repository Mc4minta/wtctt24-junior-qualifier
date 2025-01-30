package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerCardCDVViewModel_AssistedFactory_Factory implements f.c.d<ConsumerCardCDVViewModel_AssistedFactory> {
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;

    public ConsumerCardCDVViewModel_AssistedFactory_Factory(Provider<ConsumerTransferRepository> provider) {
        this.consumerTransferRepositoryProvider = provider;
    }

    public static ConsumerCardCDVViewModel_AssistedFactory_Factory create(Provider<ConsumerTransferRepository> provider) {
        return new ConsumerCardCDVViewModel_AssistedFactory_Factory(provider);
    }

    public static ConsumerCardCDVViewModel_AssistedFactory newInstance(Provider<ConsumerTransferRepository> provider) {
        return new ConsumerCardCDVViewModel_AssistedFactory(provider);
    }

    @Override // javax.inject.Provider
    public ConsumerCardCDVViewModel_AssistedFactory get() {
        return newInstance(this.consumerTransferRepositoryProvider);
    }
}