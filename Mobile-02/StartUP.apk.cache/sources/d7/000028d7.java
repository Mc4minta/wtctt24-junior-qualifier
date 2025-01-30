package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.wallets.apis.FiatCurrencyAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes2.dex */
public final class APIModule_Companion_FiatCurrencyAPI$wallets_releaseFactory implements d<FiatCurrencyAPI> {
    private final Provider<t> retrofitProvider;

    public APIModule_Companion_FiatCurrencyAPI$wallets_releaseFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static APIModule_Companion_FiatCurrencyAPI$wallets_releaseFactory create(Provider<t> provider) {
        return new APIModule_Companion_FiatCurrencyAPI$wallets_releaseFactory(provider);
    }

    public static FiatCurrencyAPI fiatCurrencyAPI$wallets_release(t tVar) {
        return (FiatCurrencyAPI) h.f(APIModule.Companion.fiatCurrencyAPI$wallets_release(tVar));
    }

    @Override // javax.inject.Provider
    public FiatCurrencyAPI get() {
        return fiatCurrencyAPI$wallets_release(this.retrofitProvider.get());
    }
}