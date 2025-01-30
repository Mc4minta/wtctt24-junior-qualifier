package com.coinbase.wallet.di;

import com.coinbase.wallet.features.send.apis.RecipientAPIHttp;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiModule_RecipientApiInterfaceFactory implements f.c.d<RecipientAPIHttp> {
    private final Provider<t> retrofitProvider;

    public ApiModule_RecipientApiInterfaceFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static ApiModule_RecipientApiInterfaceFactory create(Provider<t> provider) {
        return new ApiModule_RecipientApiInterfaceFactory(provider);
    }

    public static RecipientAPIHttp recipientApiInterface(t tVar) {
        return (RecipientAPIHttp) f.c.h.f(ApiModule.recipientApiInterface(tVar));
    }

    @Override // javax.inject.Provider
    public RecipientAPIHttp get() {
        return recipientApiInterface(this.retrofitProvider.get());
    }
}