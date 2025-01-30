package com.coinbase.wallet.ethereum.di;

import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class EthereumModule_Companion_MinerFeeAPI$ethereum_releaseFactory implements d<MinerFeeAPI> {
    private final Provider<t> retrofitProvider;

    public EthereumModule_Companion_MinerFeeAPI$ethereum_releaseFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static EthereumModule_Companion_MinerFeeAPI$ethereum_releaseFactory create(Provider<t> provider) {
        return new EthereumModule_Companion_MinerFeeAPI$ethereum_releaseFactory(provider);
    }

    public static MinerFeeAPI minerFeeAPI$ethereum_release(t tVar) {
        return (MinerFeeAPI) h.f(EthereumModule.Companion.minerFeeAPI$ethereum_release(tVar));
    }

    @Override // javax.inject.Provider
    public MinerFeeAPI get() {
        return minerFeeAPI$ethereum_release(this.retrofitProvider.get());
    }
}