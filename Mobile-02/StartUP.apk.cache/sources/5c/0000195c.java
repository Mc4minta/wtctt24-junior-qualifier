package com.coinbase.wallet.di;

import com.coinbase.wallet.features.ethereum.apis.CollectiblesApiHttp;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiModule_CollectiblesApiHttpFactory implements f.c.d<CollectiblesApiHttp> {
    private final Provider<t> retrofitProvider;

    public ApiModule_CollectiblesApiHttpFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static CollectiblesApiHttp collectiblesApiHttp(t tVar) {
        return (CollectiblesApiHttp) f.c.h.f(ApiModule.collectiblesApiHttp(tVar));
    }

    public static ApiModule_CollectiblesApiHttpFactory create(Provider<t> provider) {
        return new ApiModule_CollectiblesApiHttpFactory(provider);
    }

    @Override // javax.inject.Provider
    public CollectiblesApiHttp get() {
        return collectiblesApiHttp(this.retrofitProvider.get());
    }
}