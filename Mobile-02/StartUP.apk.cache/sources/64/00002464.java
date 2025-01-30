package com.coinbase.wallet.lending.repositories;

import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.lending.apis.LendAPI;
import com.coinbase.wallet.lending.daos.LendTokenDAO;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendRepository_Factory implements f.c.d<LendRepository> {
    private final Provider<LendTokenDAO> daoProvider;
    private final Provider<LendAPI> lendAPIProvider;
    private final Provider<h.c.s<WalletAddress>> primaryETHAddressObservableProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;

    public LendRepository_Factory(Provider<LendTokenDAO> provider, Provider<h.c.s<WalletAddress>> provider2, Provider<Tracing> provider3, Provider<LendAPI> provider4, Provider<StoreInterface> provider5) {
        this.daoProvider = provider;
        this.primaryETHAddressObservableProvider = provider2;
        this.tracerProvider = provider3;
        this.lendAPIProvider = provider4;
        this.storeProvider = provider5;
    }

    public static LendRepository_Factory create(Provider<LendTokenDAO> provider, Provider<h.c.s<WalletAddress>> provider2, Provider<Tracing> provider3, Provider<LendAPI> provider4, Provider<StoreInterface> provider5) {
        return new LendRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LendRepository newInstance(LendTokenDAO lendTokenDAO, h.c.s<WalletAddress> sVar, Tracing tracing, LendAPI lendAPI, StoreInterface storeInterface) {
        return new LendRepository(lendTokenDAO, sVar, tracing, lendAPI, storeInterface);
    }

    @Override // javax.inject.Provider
    public LendRepository get() {
        return newInstance(this.daoProvider.get(), this.primaryETHAddressObservableProvider.get(), this.tracerProvider.get(), this.lendAPIProvider.get(), this.storeProvider.get());
    }
}