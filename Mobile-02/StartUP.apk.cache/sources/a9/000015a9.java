package com.coinbase.wallet.consumer.di;

import com.coinbase.Coinbase;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ConsumerModule_CoinbaseV3RetrofitFactory implements d<t> {
    private final Provider<Coinbase> coinbaseProvider;
    private final Provider<ConsumerNetworkConfig> consumerNetworkConfigProvider;

    public ConsumerModule_CoinbaseV3RetrofitFactory(Provider<Coinbase> provider, Provider<ConsumerNetworkConfig> provider2) {
        this.coinbaseProvider = provider;
        this.consumerNetworkConfigProvider = provider2;
    }

    public static t coinbaseV3Retrofit(Coinbase coinbase, ConsumerNetworkConfig consumerNetworkConfig) {
        return (t) h.f(ConsumerModule.coinbaseV3Retrofit(coinbase, consumerNetworkConfig));
    }

    public static ConsumerModule_CoinbaseV3RetrofitFactory create(Provider<Coinbase> provider, Provider<ConsumerNetworkConfig> provider2) {
        return new ConsumerModule_CoinbaseV3RetrofitFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public t get() {
        return coinbaseV3Retrofit(this.coinbaseProvider.get(), this.consumerNetworkConfigProvider.get());
    }
}