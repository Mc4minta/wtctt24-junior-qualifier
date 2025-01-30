package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotificationCreator;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SignerViewModel_Factory implements f.c.d<SignerViewModel> {
    private final Provider<AppLockRepositoryInterface> appLockRepositoryProvider;
    private final Provider<IETHWalletRepository> ethWalletRepositoryProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private final Provider<WalletLinkPushNotificationCreator> walletLinkPushNotificationCreatorProvider;
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;

    public SignerViewModel_Factory(Provider<IETHWalletRepository> provider, Provider<WalletLinkRepository> provider2, Provider<PushNotificationRepository> provider3, Provider<WalletLinkPushNotificationCreator> provider4, Provider<AppLockRepositoryInterface> provider5) {
        this.ethWalletRepositoryProvider = provider;
        this.walletLinkRepositoryProvider = provider2;
        this.pushNotificationRepositoryProvider = provider3;
        this.walletLinkPushNotificationCreatorProvider = provider4;
        this.appLockRepositoryProvider = provider5;
    }

    public static SignerViewModel_Factory create(Provider<IETHWalletRepository> provider, Provider<WalletLinkRepository> provider2, Provider<PushNotificationRepository> provider3, Provider<WalletLinkPushNotificationCreator> provider4, Provider<AppLockRepositoryInterface> provider5) {
        return new SignerViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SignerViewModel newInstance(IETHWalletRepository iETHWalletRepository, WalletLinkRepository walletLinkRepository, PushNotificationRepository pushNotificationRepository, WalletLinkPushNotificationCreator walletLinkPushNotificationCreator, AppLockRepositoryInterface appLockRepositoryInterface) {
        return new SignerViewModel(iETHWalletRepository, walletLinkRepository, pushNotificationRepository, walletLinkPushNotificationCreator, appLockRepositoryInterface);
    }

    @Override // javax.inject.Provider
    public SignerViewModel get() {
        return newInstance(this.ethWalletRepositoryProvider.get(), this.walletLinkRepositoryProvider.get(), this.pushNotificationRepositoryProvider.get(), this.walletLinkPushNotificationCreatorProvider.get(), this.appLockRepositoryProvider.get());
    }
}