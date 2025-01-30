package com.coinbase.wallet.consumer.di;

import com.coinbase.Coinbase;
import com.squareup.moshi.Moshi;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ConsumerModule_CoinbaseRetrofitFactory implements d<t> {
    private final Provider<Coinbase> coinbaseProvider;
    private final Provider<Moshi> moshiProvider;

    public ConsumerModule_CoinbaseRetrofitFactory(Provider<Coinbase> provider, Provider<Moshi> provider2) {
        this.coinbaseProvider = provider;
        this.moshiProvider = provider2;
    }

    public static t coinbaseRetrofit(Coinbase coinbase, Moshi moshi) {
        return (t) h.f(ConsumerModule.coinbaseRetrofit(coinbase, moshi));
    }

    public static ConsumerModule_CoinbaseRetrofitFactory create(Provider<Coinbase> provider, Provider<Moshi> provider2) {
        return new ConsumerModule_CoinbaseRetrofitFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public t get() {
        return coinbaseRetrofit(this.coinbaseProvider.get(), this.moshiProvider.get());
    }
}