package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSecure3DVerificationViewModel;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationViewModel_AssistedFactory implements ConsumerSecure3DVerificationViewModel.Factory {
    private final Provider<ConsumerWebViewConfig> consumerWebViewConfig;

    public ConsumerSecure3DVerificationViewModel_AssistedFactory(Provider<ConsumerWebViewConfig> provider) {
        this.consumerWebViewConfig = provider;
    }

    @Override // com.coinbase.wallet.consumer.viewmodels.ConsumerSecure3DVerificationViewModel.Factory
    public ConsumerSecure3DVerificationViewModel create(androidx.lifecycle.z zVar) {
        return new ConsumerSecure3DVerificationViewModel(this.consumerWebViewConfig.get(), zVar);
    }
}