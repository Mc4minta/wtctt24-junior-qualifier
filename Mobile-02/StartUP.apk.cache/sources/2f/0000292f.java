package com.coinbase.wallet.wallets.di;

import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.stellar.StellarService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesStellarServiceFactory implements d<StellarService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_Companion_ProvidesStellarServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_Companion_ProvidesStellarServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_Companion_ProvidesStellarServiceFactory(provider);
    }

    public static StellarService providesStellarService(WalletEngine walletEngine) {
        return (StellarService) h.f(WalletsModule.Companion.providesStellarService(walletEngine));
    }

    @Override // javax.inject.Provider
    public StellarService get() {
        return providesStellarService(this.walletEngineProvider.get());
    }
}