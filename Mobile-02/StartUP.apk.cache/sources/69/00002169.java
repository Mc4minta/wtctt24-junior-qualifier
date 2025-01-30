package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwitchEthereumChainViewModel_Factory implements f.c.d<SwitchEthereumChainViewModel> {
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SwitchEthereumChainViewModel_Factory(Provider<IWalletRepository> provider, Provider<WalletLinkRepository> provider2) {
        this.walletRepositoryProvider = provider;
        this.walletLinkRepositoryProvider = provider2;
    }

    public static SwitchEthereumChainViewModel_Factory create(Provider<IWalletRepository> provider, Provider<WalletLinkRepository> provider2) {
        return new SwitchEthereumChainViewModel_Factory(provider, provider2);
    }

    public static SwitchEthereumChainViewModel newInstance(IWalletRepository iWalletRepository, WalletLinkRepository walletLinkRepository) {
        return new SwitchEthereumChainViewModel(iWalletRepository, walletLinkRepository);
    }

    @Override // javax.inject.Provider
    public SwitchEthereumChainViewModel get() {
        return newInstance(this.walletRepositoryProvider.get(), this.walletLinkRepositoryProvider.get());
    }
}