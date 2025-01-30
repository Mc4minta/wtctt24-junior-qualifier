package com.coinbase.wallet.di;

import com.squareup.moshi.Moshi;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkModule_ProvidesMoshiConverterFactoryFactory implements f.c.d<retrofit2.y.b.a> {
    private final Provider<Moshi> moshiProvider;

    public NetworkModule_ProvidesMoshiConverterFactoryFactory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    public static NetworkModule_ProvidesMoshiConverterFactoryFactory create(Provider<Moshi> provider) {
        return new NetworkModule_ProvidesMoshiConverterFactoryFactory(provider);
    }

    public static retrofit2.y.b.a providesMoshiConverterFactory(Moshi moshi) {
        return (retrofit2.y.b.a) f.c.h.f(NetworkModule.providesMoshiConverterFactory(moshi));
    }

    @Override // javax.inject.Provider
    public retrofit2.y.b.a get() {
        return providesMoshiConverterFactory(this.moshiProvider.get());
    }
}