package com.coinbase.wallet.di;

import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class NetworkCoreModule_Companion_BaseOkHttpClientFactory implements f.c.d<OkHttpClient> {
    private final Provider<Cache> cacheProvider;

    public NetworkCoreModule_Companion_BaseOkHttpClientFactory(Provider<Cache> provider) {
        this.cacheProvider = provider;
    }

    public static OkHttpClient baseOkHttpClient(Cache cache) {
        return (OkHttpClient) f.c.h.f(NetworkCoreModule.Companion.baseOkHttpClient(cache));
    }

    public static NetworkCoreModule_Companion_BaseOkHttpClientFactory create(Provider<Cache> provider) {
        return new NetworkCoreModule_Companion_BaseOkHttpClientFactory(provider);
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return baseOkHttpClient(this.cacheProvider.get());
    }
}