package com.coinbase.wallet.wallets.di;

import android.app.Application;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.core.interfaces.Tracing;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CryptoModule_ProvidesCipherCoreInterfaceFactory implements d<CipherCoreInterface> {
    private final Provider<Application> appProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<String> walletApiServiceUrlProvider;

    public CryptoModule_ProvidesCipherCoreInterfaceFactory(Provider<Application> provider, Provider<Tracing> provider2, Provider<String> provider3) {
        this.appProvider = provider;
        this.tracerProvider = provider2;
        this.walletApiServiceUrlProvider = provider3;
    }

    public static CryptoModule_ProvidesCipherCoreInterfaceFactory create(Provider<Application> provider, Provider<Tracing> provider2, Provider<String> provider3) {
        return new CryptoModule_ProvidesCipherCoreInterfaceFactory(provider, provider2, provider3);
    }

    public static CipherCoreInterface providesCipherCoreInterface(Application application, Tracing tracing, String str) {
        return (CipherCoreInterface) h.f(CryptoModule.providesCipherCoreInterface(application, tracing, str));
    }

    @Override // javax.inject.Provider
    public CipherCoreInterface get() {
        return providesCipherCoreInterface(this.appProvider.get(), this.tracerProvider.get(), this.walletApiServiceUrlProvider.get());
    }
}