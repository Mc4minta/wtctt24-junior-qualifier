package com.coinbase.wallet.features.walletlink.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletlink.WalletLinkInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletLinkRepository_Factory implements f.c.d<WalletLinkRepository> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<IETHTxRepository> ethTxRepositoryProvider;
    private final Provider<IETHWalletRepository> ethWalletRepositoryProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;
    private final Provider<WalletLinkInterface> walletLinkProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public WalletLinkRepository_Factory(Provider<WalletLinkInterface> provider, Provider<CipherCoreInterface> provider2, Provider<UserRepository> provider3, Provider<PushNotificationRepository> provider4, Provider<IETHWalletRepository> provider5, Provider<IETHTxRepository> provider6, Provider<IWalletRepository> provider7) {
        this.walletLinkProvider = provider;
        this.cipherCoreProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.pushNotificationRepositoryProvider = provider4;
        this.ethWalletRepositoryProvider = provider5;
        this.ethTxRepositoryProvider = provider6;
        this.walletRepositoryProvider = provider7;
    }

    public static WalletLinkRepository_Factory create(Provider<WalletLinkInterface> provider, Provider<CipherCoreInterface> provider2, Provider<UserRepository> provider3, Provider<PushNotificationRepository> provider4, Provider<IETHWalletRepository> provider5, Provider<IETHTxRepository> provider6, Provider<IWalletRepository> provider7) {
        return new WalletLinkRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static WalletLinkRepository newInstance(WalletLinkInterface walletLinkInterface, CipherCoreInterface cipherCoreInterface, UserRepository userRepository, PushNotificationRepository pushNotificationRepository, IETHWalletRepository iETHWalletRepository, IETHTxRepository iETHTxRepository, IWalletRepository iWalletRepository) {
        return new WalletLinkRepository(walletLinkInterface, cipherCoreInterface, userRepository, pushNotificationRepository, iETHWalletRepository, iETHTxRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public WalletLinkRepository get() {
        return newInstance(this.walletLinkProvider.get(), this.cipherCoreProvider.get(), this.userRepositoryProvider.get(), this.pushNotificationRepositoryProvider.get(), this.ethWalletRepositoryProvider.get(), this.ethTxRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}