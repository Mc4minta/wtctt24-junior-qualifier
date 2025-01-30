package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import f.c.d;
import f.c.h;
import h.c.s;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_ProvidesActiveCurrencyObservableFactory implements d<s<FiatCurrency>> {
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;

    public WalletsModule_Companion_ProvidesActiveCurrencyObservableFactory(Provider<IFiatCurrencyRepository> provider) {
        this.fiatCurrencyRepositoryProvider = provider;
    }

    public static WalletsModule_Companion_ProvidesActiveCurrencyObservableFactory create(Provider<IFiatCurrencyRepository> provider) {
        return new WalletsModule_Companion_ProvidesActiveCurrencyObservableFactory(provider);
    }

    public static s<FiatCurrency> providesActiveCurrencyObservable(IFiatCurrencyRepository iFiatCurrencyRepository) {
        return (s) h.f(WalletsModule.Companion.providesActiveCurrencyObservable(iFiatCurrencyRepository));
    }

    @Override // javax.inject.Provider
    public s<FiatCurrency> get() {
        return providesActiveCurrencyObservable(this.fiatCurrencyRepositoryProvider.get());
    }
}