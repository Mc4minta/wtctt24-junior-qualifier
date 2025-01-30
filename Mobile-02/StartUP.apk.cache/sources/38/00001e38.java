package com.coinbase.wallet.features.ethereum.apis;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CollectiblesApi_Factory implements f.c.d<CollectiblesApi> {
    private final Provider<CollectiblesApiHttp> apiProvider;

    public CollectiblesApi_Factory(Provider<CollectiblesApiHttp> provider) {
        this.apiProvider = provider;
    }

    public static CollectiblesApi_Factory create(Provider<CollectiblesApiHttp> provider) {
        return new CollectiblesApi_Factory(provider);
    }

    public static CollectiblesApi newInstance(CollectiblesApiHttp collectiblesApiHttp) {
        return new CollectiblesApi(collectiblesApiHttp);
    }

    @Override // javax.inject.Provider
    public CollectiblesApi get() {
        return newInstance(this.apiProvider.get());
    }
}