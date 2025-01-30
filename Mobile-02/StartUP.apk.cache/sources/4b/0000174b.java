package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAddCardViewModel_Factory implements f.c.d<ConsumerAddCardViewModel> {
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<ConsumerWebViewConfig> consumerWebViewConfigProvider;

    public ConsumerAddCardViewModel_Factory(Provider<ConsumerWebViewConfig> provider, Provider<ConsumerTransferRepository> provider2) {
        this.consumerWebViewConfigProvider = provider;
        this.consumerTransferRepositoryProvider = provider2;
    }

    public static ConsumerAddCardViewModel_Factory create(Provider<ConsumerWebViewConfig> provider, Provider<ConsumerTransferRepository> provider2) {
        return new ConsumerAddCardViewModel_Factory(provider, provider2);
    }

    public static ConsumerAddCardViewModel newInstance(ConsumerWebViewConfig consumerWebViewConfig, ConsumerTransferRepository consumerTransferRepository) {
        return new ConsumerAddCardViewModel(consumerWebViewConfig, consumerTransferRepository);
    }

    @Override // javax.inject.Provider
    public ConsumerAddCardViewModel get() {
        return newInstance(this.consumerWebViewConfigProvider.get(), this.consumerTransferRepositoryProvider.get());
    }
}