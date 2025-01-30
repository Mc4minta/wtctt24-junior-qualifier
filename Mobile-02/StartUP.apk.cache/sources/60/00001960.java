package com.coinbase.wallet.di;

import com.toshi.network.VersioningInterface;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiModule_Companion_ProvidesVersioningInterfaceFactory implements f.c.d<VersioningInterface> {
    private final Provider<t> retrofitProvider;

    public ApiModule_Companion_ProvidesVersioningInterfaceFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static ApiModule_Companion_ProvidesVersioningInterfaceFactory create(Provider<t> provider) {
        return new ApiModule_Companion_ProvidesVersioningInterfaceFactory(provider);
    }

    public static VersioningInterface providesVersioningInterface(t tVar) {
        return (VersioningInterface) f.c.h.f(ApiModule.Companion.providesVersioningInterface(tVar));
    }

    @Override // javax.inject.Provider
    public VersioningInterface get() {
        return providesVersioningInterface(this.retrofitProvider.get());
    }
}