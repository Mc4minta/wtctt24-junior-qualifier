package com.coinbase.wallet.di;

import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class NetworkCoreModule_BaseOkHttpClientFactory implements f.c.d<OkHttpClient> {
    private final Provider<Cache> cacheProvider;

    public NetworkCoreModule_BaseOkHttpClientFactory(Provider<Cache> provider) {
        this.cacheProvider = provider;
    }

    public static OkHttpClient baseOkHttpClient(Cache cache) {
        return (OkHttpClient) f.c.h.f(NetworkCoreModule.baseOkHttpClient(cache));
    }

    public static NetworkCoreModule_BaseOkHttpClientFactory create(Provider<Cache> provider) {
        return new NetworkCoreModule_BaseOkHttpClientFactory(provider);
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return baseOkHttpClient(this.cacheProvider.get());
    }
}