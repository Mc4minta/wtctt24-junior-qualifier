package com.coinbase.wallet.lending.di;

import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.lending.apis.LendAPI;
import com.coinbase.wallet.lending.daos.LendTokenDAO;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.WalletEngine;
import f.c.d;
import f.c.h;
import h.c.s;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendModule_Companion_ProvidesLendRepository$lending_releaseFactory implements d<ILendRepository> {
    private final Provider<LendAPI> lendAPIProvider;
    private final Provider<LendTokenDAO> lendTokenDAOProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<s<WalletAddress>> walletAddressObservableProvider;
    private final Provider<WalletEngine> walletEngineProvider;

    public LendModule_Companion_ProvidesLendRepository$lending_releaseFactory(Provider<WalletEngine> provider, Provider<s<WalletAddress>> provider2, Provider<LendTokenDAO> provider3, Provider<Tracing> provider4, Provider<LendAPI> provider5, Provider<StoreInterface> provider6) {
        this.walletEngineProvider = provider;
        this.walletAddressObservableProvider = provider2;
        this.lendTokenDAOProvider = provider3;
        this.tracerProvider = provider4;
        this.lendAPIProvider = provider5;
        this.storeProvider = provider6;
    }

    public static LendModule_Companion_ProvidesLendRepository$lending_releaseFactory create(Provider<WalletEngine> provider, Provider<s<WalletAddress>> provider2, Provider<LendTokenDAO> provider3, Provider<Tracing> provider4, Provider<LendAPI> provider5, Provider<StoreInterface> provider6) {
        return new LendModule_Companion_ProvidesLendRepository$lending_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ILendRepository providesLendRepository$lending_release(WalletEngine walletEngine, s<WalletAddress> sVar, LendTokenDAO lendTokenDAO, Tracing tracing, LendAPI lendAPI, StoreInterface storeInterface) {
        return (ILendRepository) h.f(LendModule.Companion.providesLendRepository$lending_release(walletEngine, sVar, lendTokenDAO, tracing, lendAPI, storeInterface));
    }

    @Override // javax.inject.Provider
    public ILendRepository get() {
        return providesLendRepository$lending_release(this.walletEngineProvider.get(), this.walletAddressObservableProvider.get(), this.lendTokenDAOProvider.get(), this.tracerProvider.get(), this.lendAPIProvider.get(), this.storeProvider.get());
    }
}