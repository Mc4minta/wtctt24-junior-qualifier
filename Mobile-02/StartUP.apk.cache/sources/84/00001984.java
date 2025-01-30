package com.coinbase.wallet.di;

import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import h.c.s;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppModule_ProvidesActiveCurrencyObservableFactory implements f.c.d<s<FiatCurrency>> {
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;

    public AppModule_ProvidesActiveCurrencyObservableFactory(Provider<IFiatCurrencyRepository> provider) {
        this.fiatCurrencyRepositoryProvider = provider;
    }

    public static AppModule_ProvidesActiveCurrencyObservableFactory create(Provider<IFiatCurrencyRepository> provider) {
        return new AppModule_ProvidesActiveCurrencyObservableFactory(provider);
    }

    public static s<FiatCurrency> providesActiveCurrencyObservable(IFiatCurrencyRepository iFiatCurrencyRepository) {
        return (s) f.c.h.f(AppModule.providesActiveCurrencyObservable(iFiatCurrencyRepository));
    }

    @Override // javax.inject.Provider
    public s<FiatCurrency> get() {
        return providesActiveCurrencyObservable(this.fiatCurrencyRepositoryProvider.get());
    }
}