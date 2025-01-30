package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.stellar.api.TimeAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes2.dex */
public final class APIModule_TimeApiFactory implements d<TimeAPI> {
    private final Provider<t> retrofitProvider;

    public APIModule_TimeApiFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static APIModule_TimeApiFactory create(Provider<t> provider) {
        return new APIModule_TimeApiFactory(provider);
    }

    public static TimeAPI timeApi(t tVar) {
        return (TimeAPI) h.f(APIModule.timeApi(tVar));
    }

    @Override // javax.inject.Provider
    public TimeAPI get() {
        return timeApi(this.retrofitProvider.get());
    }
}