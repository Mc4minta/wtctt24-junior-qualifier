package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MessageSignerViewModel_Factory implements f.c.d<MessageSignerViewModel> {
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<IETHWalletRepository> ethWalletRepositoryProvider;
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public MessageSignerViewModel_Factory(Provider<CipherCoreInterface> provider, Provider<IETHWalletRepository> provider2, Provider<IWalletRepository> provider3, Provider<WalletLinkRepository> provider4, Provider<AuthenticationHelper> provider5) {
        this.cipherCoreProvider = provider;
        this.ethWalletRepositoryProvider = provider2;
        this.walletRepositoryProvider = provider3;
        this.walletLinkRepositoryProvider = provider4;
        this.authenticationHelperProvider = provider5;
    }

    public static MessageSignerViewModel_Factory create(Provider<CipherCoreInterface> provider, Provider<IETHWalletRepository> provider2, Provider<IWalletRepository> provider3, Provider<WalletLinkRepository> provider4, Provider<AuthenticationHelper> provider5) {
        return new MessageSignerViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MessageSignerViewModel newInstance(CipherCoreInterface cipherCoreInterface, IETHWalletRepository iETHWalletRepository, IWalletRepository iWalletRepository, WalletLinkRepository walletLinkRepository, AuthenticationHelper authenticationHelper) {
        return new MessageSignerViewModel(cipherCoreInterface, iETHWalletRepository, iWalletRepository, walletLinkRepository, authenticationHelper);
    }

    @Override // javax.inject.Provider
    public MessageSignerViewModel get() {
        return newInstance(this.cipherCoreProvider.get(), this.ethWalletRepositoryProvider.get(), this.walletRepositoryProvider.get(), this.walletLinkRepositoryProvider.get(), this.authenticationHelperProvider.get());
    }
}