package com.coinbase.wallet.di;

import com.coinbase.wallet.features.ofac.apis.OFACApiHttp;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiModule_Companion_OfacApiHttpFactory implements f.c.d<OFACApiHttp> {
    private final Provider<t> retrofitProvider;

    public ApiModule_Companion_OfacApiHttpFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static ApiModule_Companion_OfacApiHttpFactory create(Provider<t> provider) {
        return new ApiModule_Companion_OfacApiHttpFactory(provider);
    }

    public static OFACApiHttp ofacApiHttp(t tVar) {
        return (OFACApiHttp) f.c.h.f(ApiModule.Companion.ofacApiHttp(tVar));
    }

    @Override // javax.inject.Provider
    public OFACApiHttp get() {
        return ofacApiHttp(this.retrofitProvider.get());
    }
}