package com.coinbase.wallet.features.send.apis;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RecipientAPI_Factory implements f.c.d<RecipientAPI> {
    private final Provider<RecipientAPIHttp> apiProvider;

    public RecipientAPI_Factory(Provider<RecipientAPIHttp> provider) {
        this.apiProvider = provider;
    }

    public static RecipientAPI_Factory create(Provider<RecipientAPIHttp> provider) {
        return new RecipientAPI_Factory(provider);
    }

    public static RecipientAPI newInstance(RecipientAPIHttp recipientAPIHttp) {
        return new RecipientAPI(recipientAPIHttp);
    }

    @Override // javax.inject.Provider
    public RecipientAPI get() {
        return newInstance(this.apiProvider.get());
    }
}