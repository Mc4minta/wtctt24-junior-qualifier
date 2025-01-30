package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.bitcoincash.services.BCHService;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_ProvidesBCHServiceFactory implements d<BCHService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_ProvidesBCHServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_ProvidesBCHServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_ProvidesBCHServiceFactory(provider);
    }

    public static BCHService providesBCHService(WalletEngine walletEngine) {
        return (BCHService) h.f(WalletsModule.providesBCHService(walletEngine));
    }

    @Override // javax.inject.Provider
    public BCHService get() {
        return providesBCHService(this.walletEngineProvider.get());
    }
}