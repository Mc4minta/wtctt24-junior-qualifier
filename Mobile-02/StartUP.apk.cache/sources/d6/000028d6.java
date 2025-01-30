package com.coinbase.wallet.wallets.di;

import com.coinbase.Coinbase;
import com.coinbase.wallet.wallets.apis.ExchangeRateAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes2.dex */
public final class APIModule_Companion_ExchangeRateAPI$wallets_releaseFactory implements d<ExchangeRateAPI> {
    private final Provider<Coinbase> coinbaseProvider;
    private final Provider<t> retrofitProvider;

    public APIModule_Companion_ExchangeRateAPI$wallets_releaseFactory(Provider<t> provider, Provider<Coinbase> provider2) {
        this.retrofitProvider = provider;
        this.coinbaseProvider = provider2;
    }

    public static APIModule_Companion_ExchangeRateAPI$wallets_releaseFactory create(Provider<t> provider, Provider<Coinbase> provider2) {
        return new APIModule_Companion_ExchangeRateAPI$wallets_releaseFactory(provider, provider2);
    }

    public static ExchangeRateAPI exchangeRateAPI$wallets_release(t tVar, Coinbase coinbase) {
        return (ExchangeRateAPI) h.f(APIModule.Companion.exchangeRateAPI$wallets_release(tVar, coinbase));
    }

    @Override // javax.inject.Provider
    public ExchangeRateAPI get() {
        return exchangeRateAPI$wallets_release(this.retrofitProvider.get(), this.coinbaseProvider.get());
    }
}