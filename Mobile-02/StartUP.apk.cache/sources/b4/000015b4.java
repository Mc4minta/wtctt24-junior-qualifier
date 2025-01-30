package com.coinbase.wallet.consumer.di;

import com.coinbase.android.apiv3.generated.authed.sends.Sends;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ConsumerModule_ConsumerApiV3Factory implements d<Sends> {
    private final Provider<t> retrofitProvider;

    public ConsumerModule_ConsumerApiV3Factory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static Sends consumerApiV3(t tVar) {
        return (Sends) h.f(ConsumerModule.consumerApiV3(tVar));
    }

    public static ConsumerModule_ConsumerApiV3Factory create(Provider<t> provider) {
        return new ConsumerModule_ConsumerApiV3Factory(provider);
    }

    @Override // javax.inject.Provider
    public Sends get() {
        return consumerApiV3(this.retrofitProvider.get());
    }
}