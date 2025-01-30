package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendUserAgreementViewModel_Factory implements f.c.d<LendUserAgreementViewModel> {
    private final Provider<ILendRepository> lendRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<TxHistoryRepository> txHistoryRepositoryProvider;

    public LendUserAgreementViewModel_Factory(Provider<StoreInterface> provider, Provider<TxHistoryRepository> provider2, Provider<ILendRepository> provider3) {
        this.storeProvider = provider;
        this.txHistoryRepositoryProvider = provider2;
        this.lendRepositoryProvider = provider3;
    }

    public static LendUserAgreementViewModel_Factory create(Provider<StoreInterface> provider, Provider<TxHistoryRepository> provider2, Provider<ILendRepository> provider3) {
        return new LendUserAgreementViewModel_Factory(provider, provider2, provider3);
    }

    public static LendUserAgreementViewModel newInstance(StoreInterface storeInterface, TxHistoryRepository txHistoryRepository, ILendRepository iLendRepository) {
        return new LendUserAgreementViewModel(storeInterface, txHistoryRepository, iLendRepository);
    }

    @Override // javax.inject.Provider
    public LendUserAgreementViewModel get() {
        return newInstance(this.storeProvider.get(), this.txHistoryRepositoryProvider.get(), this.lendRepositoryProvider.get());
    }
}