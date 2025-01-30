package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendViewModel_Factory implements f.c.d<LendViewModel> {
    private final Provider<ILendRepository> lendRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<TxHistoryRepository> txHistoryRepositoryProvider;

    public LendViewModel_Factory(Provider<ILendRepository> provider, Provider<TxHistoryRepository> provider2, Provider<StoreInterface> provider3) {
        this.lendRepositoryProvider = provider;
        this.txHistoryRepositoryProvider = provider2;
        this.storeProvider = provider3;
    }

    public static LendViewModel_Factory create(Provider<ILendRepository> provider, Provider<TxHistoryRepository> provider2, Provider<StoreInterface> provider3) {
        return new LendViewModel_Factory(provider, provider2, provider3);
    }

    public static LendViewModel newInstance(ILendRepository iLendRepository, TxHistoryRepository txHistoryRepository, StoreInterface storeInterface) {
        return new LendViewModel(iLendRepository, txHistoryRepository, storeInterface);
    }

    @Override // javax.inject.Provider
    public LendViewModel get() {
        return newInstance(this.lendRepositoryProvider.get(), this.txHistoryRepositoryProvider.get(), this.storeProvider.get());
    }
}