package com.coinbase.wallet.wallets.di;

import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.xrp.XRPService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesXRPServiceFactory implements d<XRPService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public WalletsModule_Companion_ProvidesXRPServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static WalletsModule_Companion_ProvidesXRPServiceFactory create(Provider<WalletEngine> provider) {
        return new WalletsModule_Companion_ProvidesXRPServiceFactory(provider);
    }

    public static XRPService providesXRPService(WalletEngine walletEngine) {
        return (XRPService) h.f(WalletsModule.Companion.providesXRPService(walletEngine));
    }

    @Override // javax.inject.Provider
    public XRPService get() {
        return providesXRPService(this.walletEngineProvider.get());
    }
}