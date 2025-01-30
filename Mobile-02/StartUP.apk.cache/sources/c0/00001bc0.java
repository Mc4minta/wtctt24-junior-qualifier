package com.coinbase.wallet.ethereum.apis;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MinerFeeAPI_Factory implements f.c.d<MinerFeeAPI> {
    private final Provider<MinerFeeHTTP> apiProvider;

    public MinerFeeAPI_Factory(Provider<MinerFeeHTTP> provider) {
        this.apiProvider = provider;
    }

    public static MinerFeeAPI_Factory create(Provider<MinerFeeHTTP> provider) {
        return new MinerFeeAPI_Factory(provider);
    }

    public static MinerFeeAPI newInstance(MinerFeeHTTP minerFeeHTTP) {
        return new MinerFeeAPI(minerFeeHTTP);
    }

    @Override // javax.inject.Provider
    public MinerFeeAPI get() {
        return newInstance(this.apiProvider.get());
    }
}