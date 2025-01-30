package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapInterstitialViewModel_AssistedFactory implements SwapInterstitialViewModel.Factory {
    private final Provider<StoreInterface> store;

    public SwapInterstitialViewModel_AssistedFactory(Provider<StoreInterface> provider) {
        this.store = provider;
    }

    @Override // com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel.Factory
    public SwapInterstitialViewModel create(androidx.lifecycle.z zVar) {
        return new SwapInterstitialViewModel(this.store.get(), zVar);
    }
}