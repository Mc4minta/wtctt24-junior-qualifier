package com.coinbase.wallet.features.walletlink.di;

import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.walletlink.WalletLinkInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletLinkModule_ProvideWalletLinkInterfaceFactory implements d<WalletLinkInterface> {
    private final Provider<BaseApplication> appProvider;

    public WalletLinkModule_ProvideWalletLinkInterfaceFactory(Provider<BaseApplication> provider) {
        this.appProvider = provider;
    }

    public static WalletLinkModule_ProvideWalletLinkInterfaceFactory create(Provider<BaseApplication> provider) {
        return new WalletLinkModule_ProvideWalletLinkInterfaceFactory(provider);
    }

    public static WalletLinkInterface provideWalletLinkInterface(BaseApplication baseApplication) {
        return (WalletLinkInterface) h.f(WalletLinkModule.provideWalletLinkInterface(baseApplication));
    }

    @Override // javax.inject.Provider
    public WalletLinkInterface get() {
        return provideWalletLinkInterface(this.appProvider.get());
    }
}