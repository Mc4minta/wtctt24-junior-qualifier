package com.coinbase.wallet.consumer.viewmodels;

/* loaded from: classes.dex */
public final class ConsumerInterstitialViewModel_AssistedFactory_Factory implements f.c.d<ConsumerInterstitialViewModel_AssistedFactory> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final ConsumerInterstitialViewModel_AssistedFactory_Factory INSTANCE = new ConsumerInterstitialViewModel_AssistedFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static ConsumerInterstitialViewModel_AssistedFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ConsumerInterstitialViewModel_AssistedFactory newInstance() {
        return new ConsumerInterstitialViewModel_AssistedFactory();
    }

    @Override // javax.inject.Provider
    public ConsumerInterstitialViewModel_AssistedFactory get() {
        return newInstance();
    }
}