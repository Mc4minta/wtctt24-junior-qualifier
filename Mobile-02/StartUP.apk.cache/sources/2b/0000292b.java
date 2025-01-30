package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesDOGEServiceFactory implements d<DOGEService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_Companion_ProvidesDOGEServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_Companion_ProvidesDOGEServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_Companion_ProvidesDOGEServiceFactory(provider);
    }

    public static DOGEService providesDOGEService(WalletEngine walletEngine) {
        return (DOGEService) h.f(WalletsModule.Companion.providesDOGEService(walletEngine));
    }

    @Override // javax.inject.Provider
    public DOGEService get() {
        return providesDOGEService(this.walletEngineProvider.get());
    }
}