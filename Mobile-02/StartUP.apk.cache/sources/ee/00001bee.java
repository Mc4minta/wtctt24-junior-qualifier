package com.coinbase.wallet.ethereum.di;

import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import f.c.d;
import f.c.h;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class EthereumModule_Erc20API$ethereum_releaseFactory implements d<ERC20TokenAPI> {
    private final Provider<t> retrofitProvider;

    public EthereumModule_Erc20API$ethereum_releaseFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static EthereumModule_Erc20API$ethereum_releaseFactory create(Provider<t> provider) {
        return new EthereumModule_Erc20API$ethereum_releaseFactory(provider);
    }

    public static ERC20TokenAPI erc20API$ethereum_release(t tVar) {
        ERC20TokenAPI erc20API$ethereum_release;
        erc20API$ethereum_release = EthereumModule.Companion.erc20API$ethereum_release(tVar);
        return (ERC20TokenAPI) h.f(erc20API$ethereum_release);
    }

    @Override // javax.inject.Provider
    public ERC20TokenAPI get() {
        return erc20API$ethereum_release(this.retrofitProvider.get());
    }
}