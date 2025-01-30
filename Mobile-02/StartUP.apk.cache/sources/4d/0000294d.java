package com.coinbase.wallet.wallets.di;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.apis.FiatCurrencyAPI;
import com.coinbase.wallet.wallets.daos.FiatCurrencyDAO;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule_ProvideFiatCurrencyRepository$wallets_releaseFactory implements d<IFiatCurrencyRepository> {
    private final Provider<FiatCurrencyAPI> fiatCurrencyAPIProvider;
    private final Provider<FiatCurrencyDAO> fiatCurrencyDAOProvider;
    private final Provider<StoreInterface> storeProvider;

    public WalletsRepositoriesModule_ProvideFiatCurrencyRepository$wallets_releaseFactory(Provider<StoreInterface> provider, Provider<FiatCurrencyAPI> provider2, Provider<FiatCurrencyDAO> provider3) {
        this.storeProvider = provider;
        this.fiatCurrencyAPIProvider = provider2;
        this.fiatCurrencyDAOProvider = provider3;
    }

    public static WalletsRepositoriesModule_ProvideFiatCurrencyRepository$wallets_releaseFactory create(Provider<StoreInterface> provider, Provider<FiatCurrencyAPI> provider2, Provider<FiatCurrencyDAO> provider3) {
        return new WalletsRepositoriesModule_ProvideFiatCurrencyRepository$wallets_releaseFactory(provider, provider2, provider3);
    }

    public static IFiatCurrencyRepository provideFiatCurrencyRepository$wallets_release(StoreInterface storeInterface, FiatCurrencyAPI fiatCurrencyAPI, FiatCurrencyDAO fiatCurrencyDAO) {
        IFiatCurrencyRepository provideFiatCurrencyRepository$wallets_release;
        provideFiatCurrencyRepository$wallets_release = WalletsRepositoriesModule.Companion.provideFiatCurrencyRepository$wallets_release(storeInterface, fiatCurrencyAPI, fiatCurrencyDAO);
        return (IFiatCurrencyRepository) h.f(provideFiatCurrencyRepository$wallets_release);
    }

    @Override // javax.inject.Provider
    public IFiatCurrencyRepository get() {
        return provideFiatCurrencyRepository$wallets_release(this.storeProvider.get(), this.fiatCurrencyAPIProvider.get(), this.fiatCurrencyDAOProvider.get());
    }
}