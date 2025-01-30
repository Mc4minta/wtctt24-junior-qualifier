package com.coinbase.wallet.consumer.apis;

import com.coinbase.Coinbase;
import com.coinbase.android.apiv3.generated.authed.sends.Sends;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAPI_Factory implements f.c.d<ConsumerAPI> {
    private final Provider<Coinbase> coinbaseProvider;
    private final Provider<ConsumerAPIHttp> consumerAPIProvider;
    private final Provider<Sends> sendsProvider;

    public ConsumerAPI_Factory(Provider<Coinbase> provider, Provider<ConsumerAPIHttp> provider2, Provider<Sends> provider3) {
        this.coinbaseProvider = provider;
        this.consumerAPIProvider = provider2;
        this.sendsProvider = provider3;
    }

    public static ConsumerAPI_Factory create(Provider<Coinbase> provider, Provider<ConsumerAPIHttp> provider2, Provider<Sends> provider3) {
        return new ConsumerAPI_Factory(provider, provider2, provider3);
    }

    public static ConsumerAPI newInstance(f.a<Coinbase> aVar, ConsumerAPIHttp consumerAPIHttp, Sends sends) {
        return new ConsumerAPI(aVar, consumerAPIHttp, sends);
    }

    @Override // javax.inject.Provider
    public ConsumerAPI get() {
        return newInstance(f.c.c.a(this.coinbaseProvider), this.consumerAPIProvider.get(), this.sendsProvider.get());
    }
}