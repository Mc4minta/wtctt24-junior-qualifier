package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapDisclaimerViewModel_AssistedFactory_Factory implements f.c.d<SwapDisclaimerViewModel_AssistedFactory> {
    private final Provider<StoreInterface> storeProvider;

    public SwapDisclaimerViewModel_AssistedFactory_Factory(Provider<StoreInterface> provider) {
        this.storeProvider = provider;
    }

    public static SwapDisclaimerViewModel_AssistedFactory_Factory create(Provider<StoreInterface> provider) {
        return new SwapDisclaimerViewModel_AssistedFactory_Factory(provider);
    }

    public static SwapDisclaimerViewModel_AssistedFactory newInstance(Provider<StoreInterface> provider) {
        return new SwapDisclaimerViewModel_AssistedFactory(provider);
    }

    @Override // javax.inject.Provider
    public SwapDisclaimerViewModel_AssistedFactory get() {
        return newInstance(this.storeProvider);
    }
}