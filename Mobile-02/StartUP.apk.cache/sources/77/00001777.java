package com.coinbase.wallet.consumer.viewmodels;

/* loaded from: classes.dex */
public final class ConsumerOnboardingViewModel_AssistedFactory_Factory implements f.c.d<ConsumerOnboardingViewModel_AssistedFactory> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final ConsumerOnboardingViewModel_AssistedFactory_Factory INSTANCE = new ConsumerOnboardingViewModel_AssistedFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static ConsumerOnboardingViewModel_AssistedFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ConsumerOnboardingViewModel_AssistedFactory newInstance() {
        return new ConsumerOnboardingViewModel_AssistedFactory();
    }

    @Override // javax.inject.Provider
    public ConsumerOnboardingViewModel_AssistedFactory get() {
        return newInstance();
    }
}