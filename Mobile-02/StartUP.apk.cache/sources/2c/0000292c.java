package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.litecoin.services.LTCService;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesLTCServiceFactory implements d<LTCService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_Companion_ProvidesLTCServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_Companion_ProvidesLTCServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_Companion_ProvidesLTCServiceFactory(provider);
    }

    public static LTCService providesLTCService(WalletEngine walletEngine) {
        return (LTCService) h.f(WalletsModule.Companion.providesLTCService(walletEngine));
    }

    @Override // javax.inject.Provider
    public LTCService get() {
        return providesLTCService(this.walletEngineProvider.get());
    }
}