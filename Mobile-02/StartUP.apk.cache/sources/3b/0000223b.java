package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapCompleteViewModel_AssistedFactory implements SwapCompleteViewModel.Factory {
    private final Provider<IWalletRepository> walletRepository;

    public SwapCompleteViewModel_AssistedFactory(Provider<IWalletRepository> provider) {
        this.walletRepository = provider;
    }

    @Override // com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel.Factory
    public SwapCompleteViewModel create(androidx.lifecycle.z zVar) {
        return new SwapCompleteViewModel(this.walletRepository.get(), zVar);
    }
}