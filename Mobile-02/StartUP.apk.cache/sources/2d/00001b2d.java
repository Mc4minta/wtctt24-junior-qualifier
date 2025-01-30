package com.coinbase.wallet.di;

import com.coinbase.wallet.core.interfaces.Destroyable;
import javax.inject.Provider;
import okhttp3.Cache;

/* loaded from: classes.dex */
public final class DestroyableModule_ProvidesCacheDestroyableFactory implements f.c.d<Destroyable> {
    private final Provider<Cache> cacheProvider;

    public DestroyableModule_ProvidesCacheDestroyableFactory(Provider<Cache> provider) {
        this.cacheProvider = provider;
    }

    public static DestroyableModule_ProvidesCacheDestroyableFactory create(Provider<Cache> provider) {
        return new DestroyableModule_ProvidesCacheDestroyableFactory(provider);
    }

    public static Destroyable providesCacheDestroyable(Cache cache) {
        return (Destroyable) f.c.h.f(DestroyableModule.providesCacheDestroyable(cache));
    }

    @Override // javax.inject.Provider
    public Destroyable get() {
        return providesCacheDestroyable(this.cacheProvider.get());
    }
}