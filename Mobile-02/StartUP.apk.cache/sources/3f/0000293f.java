package com.coinbase.wallet.wallets.di;

import android.content.Context;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_ProvidesWalletEngineFactory implements d<WalletEngine> {
    private final Provider<String> blockchainUrlProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<String> walletServiceUrlProvider;
    private final Provider<String> xrpNodeUrlProvider;

    public WalletsModule_ProvidesWalletEngineFactory(Provider<Context> provider, Provider<Tracing> provider2, Provider<String> provider3, Provider<String> provider4, Provider<String> provider5) {
        this.contextProvider = provider;
        this.tracerProvider = provider2;
        this.walletServiceUrlProvider = provider3;
        this.blockchainUrlProvider = provider4;
        this.xrpNodeUrlProvider = provider5;
    }

    public static WalletsModule_ProvidesWalletEngineFactory create(Provider<Context> provider, Provider<Tracing> provider2, Provider<String> provider3, Provider<String> provider4, Provider<String> provider5) {
        return new WalletsModule_ProvidesWalletEngineFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static WalletEngine providesWalletEngine(Context context, Tracing tracing, String str, String str2, String str3) {
        return (WalletEngine) h.f(WalletsModule.providesWalletEngine(context, tracing, str, str2, str3));
    }

    @Override // javax.inject.Provider
    public WalletEngine get() {
        return providesWalletEngine(this.contextProvider.get(), this.tracerProvider.get(), this.walletServiceUrlProvider.get(), this.blockchainUrlProvider.get(), this.xrpNodeUrlProvider.get());
    }
}