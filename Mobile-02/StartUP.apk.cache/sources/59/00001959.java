package com.coinbase.wallet.di;

import com.coinbase.wallet.user.apis.AccessTokenApiInterface;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiCoreModule_AccessTokenApiInterfaceFactory implements f.c.d<AccessTokenApiInterface> {
    private final ApiCoreModule module;
    private final Provider<t> retrofitProvider;

    public ApiCoreModule_AccessTokenApiInterfaceFactory(ApiCoreModule apiCoreModule, Provider<t> provider) {
        this.module = apiCoreModule;
        this.retrofitProvider = provider;
    }

    public static AccessTokenApiInterface accessTokenApiInterface(ApiCoreModule apiCoreModule, t tVar) {
        return (AccessTokenApiInterface) f.c.h.f(apiCoreModule.accessTokenApiInterface(tVar));
    }

    public static ApiCoreModule_AccessTokenApiInterfaceFactory create(ApiCoreModule apiCoreModule, Provider<t> provider) {
        return new ApiCoreModule_AccessTokenApiInterfaceFactory(apiCoreModule, provider);
    }

    @Override // javax.inject.Provider
    public AccessTokenApiInterface get() {
        return accessTokenApiInterface(this.module, this.retrofitProvider.get());
    }
}