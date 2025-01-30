package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendViewModel_Factory implements f.c.d<SendViewModel> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SendViewModel_Factory(Provider<IWalletRepository> provider, Provider<CurrencyFormatter> provider2, Provider<StoreInterface> provider3) {
        this.walletRepositoryProvider = provider;
        this.currencyFormatterProvider = provider2;
        this.storeProvider = provider3;
    }

    public static SendViewModel_Factory create(Provider<IWalletRepository> provider, Provider<CurrencyFormatter> provider2, Provider<StoreInterface> provider3) {
        return new SendViewModel_Factory(provider, provider2, provider3);
    }

    public static SendViewModel newInstance(IWalletRepository iWalletRepository, CurrencyFormatter currencyFormatter, StoreInterface storeInterface) {
        return new SendViewModel(iWalletRepository, currencyFormatter, storeInterface);
    }

    @Override // javax.inject.Provider
    public SendViewModel get() {
        return newInstance(this.walletRepositoryProvider.get(), this.currencyFormatterProvider.get(), this.storeProvider.get());
    }
}