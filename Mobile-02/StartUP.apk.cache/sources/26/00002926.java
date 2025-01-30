package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsModule_Companion_CurrencyFormatterFactory implements d<CurrencyFormatter> {
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;

    public WalletsModule_Companion_CurrencyFormatterFactory(Provider<StoreInterface> provider, Provider<IExchangeRateRepository> provider2) {
        this.storeProvider = provider;
        this.exchangeRateRepositoryProvider = provider2;
    }

    public static WalletsModule_Companion_CurrencyFormatterFactory create(Provider<StoreInterface> provider, Provider<IExchangeRateRepository> provider2) {
        return new WalletsModule_Companion_CurrencyFormatterFactory(provider, provider2);
    }

    public static CurrencyFormatter currencyFormatter(StoreInterface storeInterface, IExchangeRateRepository iExchangeRateRepository) {
        return (CurrencyFormatter) h.f(WalletsModule.Companion.currencyFormatter(storeInterface, iExchangeRateRepository));
    }

    @Override // javax.inject.Provider
    public CurrencyFormatter get() {
        return currencyFormatter(this.storeProvider.get(), this.exchangeRateRepositoryProvider.get());
    }
}