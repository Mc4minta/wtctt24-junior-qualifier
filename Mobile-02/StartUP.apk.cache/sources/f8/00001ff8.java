package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFeeViewModel_AssistedFactory implements AdjustableMinerFeeViewModel.Factory {
    private final Provider<AdjustableMinerFeeRepository> adjustableMinerFeeRepository;
    private final Provider<CurrencyFormatter> currencyFormatter;
    private final Provider<IExchangeRateRepository> exchangeRateRepository;

    public AdjustableMinerFeeViewModel_AssistedFactory(Provider<CurrencyFormatter> provider, Provider<IExchangeRateRepository> provider2, Provider<AdjustableMinerFeeRepository> provider3) {
        this.currencyFormatter = provider;
        this.exchangeRateRepository = provider2;
        this.adjustableMinerFeeRepository = provider3;
    }

    @Override // com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel.Factory
    public AdjustableMinerFeeViewModel create(androidx.lifecycle.z zVar) {
        return new AdjustableMinerFeeViewModel(this.currencyFormatter.get(), this.exchangeRateRepository.get(), this.adjustableMinerFeeRepository.get(), zVar);
    }
}