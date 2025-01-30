package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapCompleteViewModel_AssistedFactory_Factory implements f.c.d<SwapCompleteViewModel_AssistedFactory> {
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SwapCompleteViewModel_AssistedFactory_Factory(Provider<IWalletRepository> provider) {
        this.walletRepositoryProvider = provider;
    }

    public static SwapCompleteViewModel_AssistedFactory_Factory create(Provider<IWalletRepository> provider) {
        return new SwapCompleteViewModel_AssistedFactory_Factory(provider);
    }

    public static SwapCompleteViewModel_AssistedFactory newInstance(Provider<IWalletRepository> provider) {
        return new SwapCompleteViewModel_AssistedFactory(provider);
    }

    @Override // javax.inject.Provider
    public SwapCompleteViewModel_AssistedFactory get() {
        return newInstance(this.walletRepositoryProvider);
    }
}