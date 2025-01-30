package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.wallets.apis.ExchangeRateAPI;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule_Companion_ProvideExchangeRateRepository$wallets_releaseFactory implements d<IExchangeRateRepository> {
    private final Provider<CompoundFinanceRepository> compoundFinanceRepositoryProvider;
    private final Provider<ExchangeRateAPI> exchangeRateApiProvider;
    private final Provider<FiatExchangeRateDAO> exchangeRateDAOProvider;
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;
    private final Provider<Tracing> tracerProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public WalletsRepositoriesModule_Companion_ProvideExchangeRateRepository$wallets_releaseFactory(Provider<IFiatCurrencyRepository> provider, Provider<ExchangeRateAPI> provider2, Provider<CompoundFinanceRepository> provider3, Provider<FiatExchangeRateDAO> provider4, Provider<IWalletRepository> provider5, Provider<Tracing> provider6) {
        this.fiatCurrencyRepositoryProvider = provider;
        this.exchangeRateApiProvider = provider2;
        this.compoundFinanceRepositoryProvider = provider3;
        this.exchangeRateDAOProvider = provider4;
        this.walletRepositoryProvider = provider5;
        this.tracerProvider = provider6;
    }

    public static WalletsRepositoriesModule_Companion_ProvideExchangeRateRepository$wallets_releaseFactory create(Provider<IFiatCurrencyRepository> provider, Provider<ExchangeRateAPI> provider2, Provider<CompoundFinanceRepository> provider3, Provider<FiatExchangeRateDAO> provider4, Provider<IWalletRepository> provider5, Provider<Tracing> provider6) {
        return new WalletsRepositoriesModule_Companion_ProvideExchangeRateRepository$wallets_releaseFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static IExchangeRateRepository provideExchangeRateRepository$wallets_release(IFiatCurrencyRepository iFiatCurrencyRepository, ExchangeRateAPI exchangeRateAPI, CompoundFinanceRepository compoundFinanceRepository, FiatExchangeRateDAO fiatExchangeRateDAO, IWalletRepository iWalletRepository, Tracing tracing) {
        return (IExchangeRateRepository) h.f(WalletsRepositoriesModule.Companion.provideExchangeRateRepository$wallets_release(iFiatCurrencyRepository, exchangeRateAPI, compoundFinanceRepository, fiatExchangeRateDAO, iWalletRepository, tracing));
    }

    @Override // javax.inject.Provider
    public IExchangeRateRepository get() {
        return provideExchangeRateRepository$wallets_release(this.fiatCurrencyRepositoryProvider.get(), this.exchangeRateApiProvider.get(), this.compoundFinanceRepositoryProvider.get(), this.exchangeRateDAOProvider.get(), this.walletRepositoryProvider.get(), this.tracerProvider.get());
    }
}