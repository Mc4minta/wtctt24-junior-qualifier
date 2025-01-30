package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerCardCDVViewModel;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerCardCDVViewModel_AssistedFactory implements ConsumerCardCDVViewModel.Factory {
    private final Provider<ConsumerTransferRepository> consumerTransferRepository;

    public ConsumerCardCDVViewModel_AssistedFactory(Provider<ConsumerTransferRepository> provider) {
        this.consumerTransferRepository = provider;
    }

    @Override // com.coinbase.wallet.consumer.viewmodels.ConsumerCardCDVViewModel.Factory
    public ConsumerCardCDVViewModel create(androidx.lifecycle.z zVar) {
        return new ConsumerCardCDVViewModel(this.consumerTransferRepository.get(), zVar);
    }
}