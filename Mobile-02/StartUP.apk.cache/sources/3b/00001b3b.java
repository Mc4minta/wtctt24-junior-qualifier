package com.coinbase.wallet.di;

import android.content.Context;
import javax.inject.Provider;
import okhttp3.Cache;

/* loaded from: classes.dex */
public final class NetworkCoreModule_ProvideCacheFactory implements f.c.d<Cache> {
    private final Provider<Context> contextProvider;

    public NetworkCoreModule_ProvideCacheFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static NetworkCoreModule_ProvideCacheFactory create(Provider<Context> provider) {
        return new NetworkCoreModule_ProvideCacheFactory(provider);
    }

    public static Cache provideCache(Context context) {
        return (Cache) f.c.h.f(NetworkCoreModule.provideCache(context));
    }

    @Override // javax.inject.Provider
    public Cache get() {
        return provideCache(this.contextProvider.get());
    }
}