package com.coinbase.wallet.di;

import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppModule_Companion_ProvidesAmountPickerFormatterFactory implements f.c.d<AmountPickerFormatter> {
    private final Provider<IFiatCurrencyRepository> currencyRepositoryProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;

    public AppModule_Companion_ProvidesAmountPickerFormatterFactory(Provider<IFiatCurrencyRepository> provider, Provider<IExchangeRateRepository> provider2) {
        this.currencyRepositoryProvider = provider;
        this.exchangeRateRepositoryProvider = provider2;
    }

    public static AppModule_Companion_ProvidesAmountPickerFormatterFactory create(Provider<IFiatCurrencyRepository> provider, Provider<IExchangeRateRepository> provider2) {
        return new AppModule_Companion_ProvidesAmountPickerFormatterFactory(provider, provider2);
    }

    public static AmountPickerFormatter providesAmountPickerFormatter(IFiatCurrencyRepository iFiatCurrencyRepository, IExchangeRateRepository iExchangeRateRepository) {
        return (AmountPickerFormatter) f.c.h.f(AppModule.Companion.providesAmountPickerFormatter(iFiatCurrencyRepository, iExchangeRateRepository));
    }

    @Override // javax.inject.Provider
    public AmountPickerFormatter get() {
        return providesAmountPickerFormatter(this.currencyRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get());
    }
}