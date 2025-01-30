package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapInterstitialViewModel_AssistedFactory_Factory implements f.c.d<SwapInterstitialViewModel_AssistedFactory> {
    private final Provider<StoreInterface> storeProvider;

    public SwapInterstitialViewModel_AssistedFactory_Factory(Provider<StoreInterface> provider) {
        this.storeProvider = provider;
    }

    public static SwapInterstitialViewModel_AssistedFactory_Factory create(Provider<StoreInterface> provider) {
        return new SwapInterstitialViewModel_AssistedFactory_Factory(provider);
    }

    public static SwapInterstitialViewModel_AssistedFactory newInstance(Provider<StoreInterface> provider) {
        return new SwapInterstitialViewModel_AssistedFactory(provider);
    }

    @Override // javax.inject.Provider
    public SwapInterstitialViewModel_AssistedFactory get() {
        return newInstance(this.storeProvider);
    }
}