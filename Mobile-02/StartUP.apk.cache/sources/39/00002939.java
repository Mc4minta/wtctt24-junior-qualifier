package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_ProvidesDOGEServiceFactory implements d<DOGEService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_ProvidesDOGEServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_ProvidesDOGEServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_ProvidesDOGEServiceFactory(provider);
    }

    public static DOGEService providesDOGEService(WalletEngine walletEngine) {
        return (DOGEService) h.f(WalletsModule.providesDOGEService(walletEngine));
    }

    @Override // javax.inject.Provider
    public DOGEService get() {
        return providesDOGEService(this.walletEngineProvider.get());
    }
}