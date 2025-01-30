package com.coinbase.wallet.consumer.di;

import com.coinbase.wallet.consumer.apis.ConsumerAPIHttp;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ConsumerModule_ConsumerApiFactory implements d<ConsumerAPIHttp> {
    private final Provider<t> retrofitProvider;

    public ConsumerModule_ConsumerApiFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static ConsumerAPIHttp consumerApi(t tVar) {
        return (ConsumerAPIHttp) h.f(ConsumerModule.consumerApi(tVar));
    }

    public static ConsumerModule_ConsumerApiFactory create(Provider<t> provider) {
        return new ConsumerModule_ConsumerApiFactory(provider);
    }

    @Override // javax.inject.Provider
    public ConsumerAPIHttp get() {
        return consumerApi(this.retrofitProvider.get());
    }
}