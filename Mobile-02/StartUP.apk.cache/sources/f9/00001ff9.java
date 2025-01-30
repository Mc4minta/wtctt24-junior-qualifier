package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFeeViewModel_AssistedFactory_Factory implements f.c.d<AdjustableMinerFeeViewModel_AssistedFactory> {
    private final Provider<AdjustableMinerFeeRepository> adjustableMinerFeeRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;

    public AdjustableMinerFeeViewModel_AssistedFactory_Factory(Provider<CurrencyFormatter> provider, Provider<IExchangeRateRepository> provider2, Provider<AdjustableMinerFeeRepository> provider3) {
        this.currencyFormatterProvider = provider;
        this.exchangeRateRepositoryProvider = provider2;
        this.adjustableMinerFeeRepositoryProvider = provider3;
    }

    public static AdjustableMinerFeeViewModel_AssistedFactory_Factory create(Provider<CurrencyFormatter> provider, Provider<IExchangeRateRepository> provider2, Provider<AdjustableMinerFeeRepository> provider3) {
        return new AdjustableMinerFeeViewModel_AssistedFactory_Factory(provider, provider2, provider3);
    }

    public static AdjustableMinerFeeViewModel_AssistedFactory newInstance(Provider<CurrencyFormatter> provider, Provider<IExchangeRateRepository> provider2, Provider<AdjustableMinerFeeRepository> provider3) {
        return new AdjustableMinerFeeViewModel_AssistedFactory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public AdjustableMinerFeeViewModel_AssistedFactory get() {
        return newInstance(this.currencyFormatterProvider, this.exchangeRateRepositoryProvider, this.adjustableMinerFeeRepositoryProvider);
    }
}