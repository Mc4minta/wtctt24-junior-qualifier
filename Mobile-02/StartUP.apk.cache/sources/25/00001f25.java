package com.coinbase.wallet.features.ofac.apis;

import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class OFACApi_Factory implements d<OFACApi> {
    private final Provider<OFACApiHttp> apiProvider;

    public OFACApi_Factory(Provider<OFACApiHttp> provider) {
        this.apiProvider = provider;
    }

    public static OFACApi_Factory create(Provider<OFACApiHttp> provider) {
        return new OFACApi_Factory(provider);
    }

    public static OFACApi newInstance(OFACApiHttp oFACApiHttp) {
        return new OFACApi(oFACApiHttp);
    }

    @Override // javax.inject.Provider
    public OFACApi get() {
        return newInstance(this.apiProvider.get());
    }
}