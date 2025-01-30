package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFee1559ViewModel_AssistedFactory implements AdjustableMinerFee1559ViewModel.Factory {
    private final Provider<AdjustableMinerFeeRepository> adjustableMinerFeeRepository;
    private final Provider<CurrencyFormatter> currencyFormatter;

    public AdjustableMinerFee1559ViewModel_AssistedFactory(Provider<CurrencyFormatter> provider, Provider<AdjustableMinerFeeRepository> provider2) {
        this.currencyFormatter = provider;
        this.adjustableMinerFeeRepository = provider2;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel.Factory
    public AdjustableMinerFee1559ViewModel create(androidx.lifecycle.z zVar) {
        return new AdjustableMinerFee1559ViewModel(this.currencyFormatter.get(), this.adjustableMinerFeeRepository.get(), zVar);
    }
}