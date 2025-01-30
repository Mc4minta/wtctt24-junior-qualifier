package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationViewModel_AssistedFactory_Factory implements f.c.d<ConsumerSecure3DVerificationViewModel_AssistedFactory> {
    private final Provider<ConsumerWebViewConfig> consumerWebViewConfigProvider;

    public ConsumerSecure3DVerificationViewModel_AssistedFactory_Factory(Provider<ConsumerWebViewConfig> provider) {
        this.consumerWebViewConfigProvider = provider;
    }

    public static ConsumerSecure3DVerificationViewModel_AssistedFactory_Factory create(Provider<ConsumerWebViewConfig> provider) {
        return new ConsumerSecure3DVerificationViewModel_AssistedFactory_Factory(provider);
    }

    public static ConsumerSecure3DVerificationViewModel_AssistedFactory newInstance(Provider<ConsumerWebViewConfig> provider) {
        return new ConsumerSecure3DVerificationViewModel_AssistedFactory(provider);
    }

    @Override // javax.inject.Provider
    public ConsumerSecure3DVerificationViewModel_AssistedFactory get() {
        return newInstance(this.consumerWebViewConfigProvider);
    }
}