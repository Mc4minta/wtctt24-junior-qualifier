package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RequestEthereumAccountsViewModel_Factory implements f.c.d<RequestEthereumAccountsViewModel> {
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;

    public RequestEthereumAccountsViewModel_Factory(Provider<WalletLinkRepository> provider) {
        this.walletLinkRepositoryProvider = provider;
    }

    public static RequestEthereumAccountsViewModel_Factory create(Provider<WalletLinkRepository> provider) {
        return new RequestEthereumAccountsViewModel_Factory(provider);
    }

    public static RequestEthereumAccountsViewModel newInstance(WalletLinkRepository walletLinkRepository) {
        return new RequestEthereumAccountsViewModel(walletLinkRepository);
    }

    @Override // javax.inject.Provider
    public RequestEthereumAccountsViewModel get() {
        return newInstance(this.walletLinkRepositoryProvider.get());
    }
}