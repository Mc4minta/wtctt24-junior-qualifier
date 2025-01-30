package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.wallets.apis.CryptoCurrencyAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes2.dex */
public final class APIModule_Companion_CryptoCurrencyAPI$wallets_releaseFactory implements d<CryptoCurrencyAPI> {
    private final Provider<t> retrofitProvider;

    public APIModule_Companion_CryptoCurrencyAPI$wallets_releaseFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static APIModule_Companion_CryptoCurrencyAPI$wallets_releaseFactory create(Provider<t> provider) {
        return new APIModule_Companion_CryptoCurrencyAPI$wallets_releaseFactory(provider);
    }

    public static CryptoCurrencyAPI cryptoCurrencyAPI$wallets_release(t tVar) {
        return (CryptoCurrencyAPI) h.f(APIModule.Companion.cryptoCurrencyAPI$wallets_release(tVar));
    }

    @Override // javax.inject.Provider
    public CryptoCurrencyAPI get() {
        return cryptoCurrencyAPI$wallets_release(this.retrofitProvider.get());
    }
}