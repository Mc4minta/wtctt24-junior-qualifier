package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFee1559ViewModel_AssistedFactory_Factory implements f.c.d<AdjustableMinerFee1559ViewModel_AssistedFactory> {
    private final Provider<AdjustableMinerFeeRepository> adjustableMinerFeeRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;

    public AdjustableMinerFee1559ViewModel_AssistedFactory_Factory(Provider<CurrencyFormatter> provider, Provider<AdjustableMinerFeeRepository> provider2) {
        this.currencyFormatterProvider = provider;
        this.adjustableMinerFeeRepositoryProvider = provider2;
    }

    public static AdjustableMinerFee1559ViewModel_AssistedFactory_Factory create(Provider<CurrencyFormatter> provider, Provider<AdjustableMinerFeeRepository> provider2) {
        return new AdjustableMinerFee1559ViewModel_AssistedFactory_Factory(provider, provider2);
    }

    public static AdjustableMinerFee1559ViewModel_AssistedFactory newInstance(Provider<CurrencyFormatter> provider, Provider<AdjustableMinerFeeRepository> provider2) {
        return new AdjustableMinerFee1559ViewModel_AssistedFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public AdjustableMinerFee1559ViewModel_AssistedFactory get() {
        return newInstance(this.currencyFormatterProvider, this.adjustableMinerFeeRepositoryProvider);
    }
}