package com.coinbase.wallet.features.walletlink.viewmodels;

import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletLinkSettingsViewModel_Factory implements d<WalletLinkSettingsViewModel> {
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;

    public WalletLinkSettingsViewModel_Factory(Provider<WalletLinkRepository> provider) {
        this.walletLinkRepositoryProvider = provider;
    }

    public static WalletLinkSettingsViewModel_Factory create(Provider<WalletLinkRepository> provider) {
        return new WalletLinkSettingsViewModel_Factory(provider);
    }

    public static WalletLinkSettingsViewModel newInstance(WalletLinkRepository walletLinkRepository) {
        return new WalletLinkSettingsViewModel(walletLinkRepository);
    }

    @Override // javax.inject.Provider
    public WalletLinkSettingsViewModel get() {
        return newInstance(this.walletLinkRepositoryProvider.get());
    }
}