package com.coinbase.wallet.ethereum.di;

import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class EthereumModule_MinerFeeAPI$ethereum_releaseFactory implements d<MinerFeeAPI> {
    private final Provider<t> retrofitProvider;

    public EthereumModule_MinerFeeAPI$ethereum_releaseFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static EthereumModule_MinerFeeAPI$ethereum_releaseFactory create(Provider<t> provider) {
        return new EthereumModule_MinerFeeAPI$ethereum_releaseFactory(provider);
    }

    public static MinerFeeAPI minerFeeAPI$ethereum_release(t tVar) {
        MinerFeeAPI minerFeeAPI$ethereum_release;
        minerFeeAPI$ethereum_release = EthereumModule.Companion.minerFeeAPI$ethereum_release(tVar);
        return (MinerFeeAPI) h.f(minerFeeAPI$ethereum_release);
    }

    @Override // javax.inject.Provider
    public MinerFeeAPI get() {
        return minerFeeAPI$ethereum_release(this.retrofitProvider.get());
    }
}