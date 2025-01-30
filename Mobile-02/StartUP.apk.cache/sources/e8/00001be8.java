package com.coinbase.wallet.ethereum.di;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.ethereum.interfaces.IERC20Fetching;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EthereumModule_Companion_ProvidesERC20Fetching$ethereum_releaseFactory implements d<IERC20Fetching> {
    private final Provider<CipherCoreInterface> cipherCoreProvider;

    public EthereumModule_Companion_ProvidesERC20Fetching$ethereum_releaseFactory(Provider<CipherCoreInterface> provider) {
        this.cipherCoreProvider = provider;
    }

    public static EthereumModule_Companion_ProvidesERC20Fetching$ethereum_releaseFactory create(Provider<CipherCoreInterface> provider) {
        return new EthereumModule_Companion_ProvidesERC20Fetching$ethereum_releaseFactory(provider);
    }

    public static IERC20Fetching providesERC20Fetching$ethereum_release(CipherCoreInterface cipherCoreInterface) {
        return (IERC20Fetching) h.f(EthereumModule.Companion.providesERC20Fetching$ethereum_release(cipherCoreInterface));
    }

    @Override // javax.inject.Provider
    public IERC20Fetching get() {
        return providesERC20Fetching$ethereum_release(this.cipherCoreProvider.get());
    }
}