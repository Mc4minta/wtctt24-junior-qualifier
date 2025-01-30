package com.coinbase.wallet.di;

import com.coinbase.wallet.core.interfaces.Destroyable;
import javax.inject.Provider;
import okhttp3.Cache;

/* loaded from: classes.dex */
public final class DestroyableModule_Companion_ProvidesCacheDestroyableFactory implements f.c.d<Destroyable> {
    private final Provider<Cache> cacheProvider;

    public DestroyableModule_Companion_ProvidesCacheDestroyableFactory(Provider<Cache> provider) {
        this.cacheProvider = provider;
    }

    public static DestroyableModule_Companion_ProvidesCacheDestroyableFactory create(Provider<Cache> provider) {
        return new DestroyableModule_Companion_ProvidesCacheDestroyableFactory(provider);
    }

    public static Destroyable providesCacheDestroyable(Cache cache) {
        return (Destroyable) f.c.h.f(DestroyableModule.Companion.providesCacheDestroyable(cache));
    }

    @Override // javax.inject.Provider
    public Destroyable get() {
        return providesCacheDestroyable(this.cacheProvider.get());
    }
}