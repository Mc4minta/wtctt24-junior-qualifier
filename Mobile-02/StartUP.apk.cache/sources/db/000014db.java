package com.coinbase.wallet.commonui.viewmodels;

import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AmountViewModel_Factory implements f.c.d<AmountViewModel> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IFiatCurrencyRepository> currencyRepositoryProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;

    public AmountViewModel_Factory(Provider<IFiatCurrencyRepository> provider, Provider<IExchangeRateRepository> provider2, Provider<CurrencyFormatter> provider3) {
        this.currencyRepositoryProvider = provider;
        this.exchangeRateRepositoryProvider = provider2;
        this.currencyFormatterProvider = provider3;
    }

    public static AmountViewModel_Factory create(Provider<IFiatCurrencyRepository> provider, Provider<IExchangeRateRepository> provider2, Provider<CurrencyFormatter> provider3) {
        return new AmountViewModel_Factory(provider, provider2, provider3);
    }

    public static AmountViewModel newInstance(IFiatCurrencyRepository iFiatCurrencyRepository, IExchangeRateRepository iExchangeRateRepository, CurrencyFormatter currencyFormatter) {
        return new AmountViewModel(iFiatCurrencyRepository, iExchangeRateRepository, currencyFormatter);
    }

    @Override // javax.inject.Provider
    public AmountViewModel get() {
        return newInstance(this.currencyRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.currencyFormatterProvider.get());
    }
}