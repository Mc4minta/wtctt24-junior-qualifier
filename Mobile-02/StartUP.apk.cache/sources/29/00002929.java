package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesBTCServiceFactory implements d<BTCService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_Companion_ProvidesBTCServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_Companion_ProvidesBTCServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_Companion_ProvidesBTCServiceFactory(provider);
    }

    public static BTCService providesBTCService(WalletEngine walletEngine) {
        return (BTCService) h.f(WalletsModule.Companion.providesBTCService(walletEngine));
    }

    @Override // javax.inject.Provider
    public BTCService get() {
        return providesBTCService(this.walletEngineProvider.get());
    }
}