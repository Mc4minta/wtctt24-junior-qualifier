package com.coinbase.wallet.features.ofac.repositories;

import com.coinbase.wallet.features.ofac.apis.OFACApi;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class OFACRepository_Factory implements d<OFACRepository> {
    private final Provider<OFACApi> ofacApiProvider;

    public OFACRepository_Factory(Provider<OFACApi> provider) {
        this.ofacApiProvider = provider;
    }

    public static OFACRepository_Factory create(Provider<OFACApi> provider) {
        return new OFACRepository_Factory(provider);
    }

    public static OFACRepository newInstance(OFACApi oFACApi) {
        return new OFACRepository(oFACApi);
    }

    @Override // javax.inject.Provider
    public OFACRepository get() {
        return newInstance(this.ofacApiProvider.get());
    }
}