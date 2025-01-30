package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ParentRequestEthereumAccountsViewModel_Factory implements f.c.d<ParentRequestEthereumAccountsViewModel> {
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;

    public ParentRequestEthereumAccountsViewModel_Factory(Provider<WalletLinkRepository> provider) {
        this.walletLinkRepositoryProvider = provider;
    }

    public static ParentRequestEthereumAccountsViewModel_Factory create(Provider<WalletLinkRepository> provider) {
        return new ParentRequestEthereumAccountsViewModel_Factory(provider);
    }

    public static ParentRequestEthereumAccountsViewModel newInstance(WalletLinkRepository walletLinkRepository) {
        return new ParentRequestEthereumAccountsViewModel(walletLinkRepository);
    }

    @Override // javax.inject.Provider
    public ParentRequestEthereumAccountsViewModel get() {
        return newInstance(this.walletLinkRepositoryProvider.get());
    }
}