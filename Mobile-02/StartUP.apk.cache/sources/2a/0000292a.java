package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI;
import com.coinbase.wallet.compoundfinance.daos.CompoundTokenDAO;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesCompoundFinanceRepositoryFactory implements d<CompoundFinanceRepository> {
    private final Provider<CompoundFinanceAPI> compoundFinanceAPIProvider;
    private final Provider<CompoundTokenDAO> compoundTokenDAOProvider;

    public WalletsModule_Companion_ProvidesCompoundFinanceRepositoryFactory(Provider<CompoundFinanceAPI> provider, Provider<CompoundTokenDAO> provider2) {
        this.compoundFinanceAPIProvider = provider;
        this.compoundTokenDAOProvider = provider2;
    }

    public static WalletsModule_Companion_ProvidesCompoundFinanceRepositoryFactory create(Provider<CompoundFinanceAPI> provider, Provider<CompoundTokenDAO> provider2) {
        return new WalletsModule_Companion_ProvidesCompoundFinanceRepositoryFactory(provider, provider2);
    }

    public static CompoundFinanceRepository providesCompoundFinanceRepository(CompoundFinanceAPI compoundFinanceAPI, CompoundTokenDAO compoundTokenDAO) {
        return (CompoundFinanceRepository) h.f(WalletsModule.Companion.providesCompoundFinanceRepository(compoundFinanceAPI, compoundTokenDAO));
    }

    @Override // javax.inject.Provider
    public CompoundFinanceRepository get() {
        return providesCompoundFinanceRepository(this.compoundFinanceAPIProvider.get(), this.compoundTokenDAOProvider.get());
    }
}