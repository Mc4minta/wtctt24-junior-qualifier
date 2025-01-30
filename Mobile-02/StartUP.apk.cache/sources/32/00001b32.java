package com.coinbase.wallet.di;

import com.squareup.moshi.Moshi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.t;

/* loaded from: classes.dex */
public final class NetworkCoreModule_BaseRetrofitFactory implements f.c.d<t> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<String> walletApiUrlProvider;

    public NetworkCoreModule_BaseRetrofitFactory(Provider<Moshi> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.moshiProvider = provider;
        this.okHttpClientProvider = provider2;
        this.walletApiUrlProvider = provider3;
    }

    public static t baseRetrofit(Moshi moshi, OkHttpClient okHttpClient, String str) {
        return (t) f.c.h.f(NetworkCoreModule.baseRetrofit(moshi, okHttpClient, str));
    }

    public static NetworkCoreModule_BaseRetrofitFactory create(Provider<Moshi> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new NetworkCoreModule_BaseRetrofitFactory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public t get() {
        return baseRetrofit(this.moshiProvider.get(), this.okHttpClientProvider.get(), this.walletApiUrlProvider.get());
    }
}