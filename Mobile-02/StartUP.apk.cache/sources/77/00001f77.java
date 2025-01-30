package com.coinbase.wallet.features.send.di;

import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.resolver.ResolverService;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ENSModule_ProvidesResolverServiceFactory implements d<ResolverService> {
    private final Provider<WalletEngine> walletEngineProvider;

    public ENSModule_ProvidesResolverServiceFactory(Provider<WalletEngine> provider) {
        this.walletEngineProvider = provider;
    }

    public static ENSModule_ProvidesResolverServiceFactory create(Provider<WalletEngine> provider) {
        return new ENSModule_ProvidesResolverServiceFactory(provider);
    }

    public static ResolverService providesResolverService(WalletEngine walletEngine) {
        return (ResolverService) h.f(ENSModule.providesResolverService(walletEngine));
    }

    @Override // javax.inject.Provider
    public ResolverService get() {
        return providesResolverService(this.walletEngineProvider.get());
    }
}