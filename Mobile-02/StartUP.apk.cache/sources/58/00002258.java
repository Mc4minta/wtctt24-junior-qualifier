package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapDisclaimerViewModel_AssistedFactory implements SwapDisclaimerViewModel.Factory {
    private final Provider<StoreInterface> store;

    public SwapDisclaimerViewModel_AssistedFactory(Provider<StoreInterface> provider) {
        this.store = provider;
    }

    @Override // com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel.Factory
    public SwapDisclaimerViewModel create(androidx.lifecycle.z zVar) {
        return new SwapDisclaimerViewModel(this.store.get(), zVar);
    }
}