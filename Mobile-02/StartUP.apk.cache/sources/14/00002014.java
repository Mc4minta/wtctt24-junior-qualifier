package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendAmountPickerViewModel_Factory implements f.c.d<SendAmountPickerViewModel> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SendAmountPickerViewModel_Factory(Provider<IWalletRepository> provider, Provider<CurrencyFormatter> provider2, Provider<StoreInterface> provider3) {
        this.walletRepositoryProvider = provider;
        this.currencyFormatterProvider = provider2;
        this.storeProvider = provider3;
    }

    public static SendAmountPickerViewModel_Factory create(Provider<IWalletRepository> provider, Provider<CurrencyFormatter> provider2, Provider<StoreInterface> provider3) {
        return new SendAmountPickerViewModel_Factory(provider, provider2, provider3);
    }

    public static SendAmountPickerViewModel newInstance(IWalletRepository iWalletRepository, CurrencyFormatter currencyFormatter, StoreInterface storeInterface) {
        return new SendAmountPickerViewModel(iWalletRepository, currencyFormatter, storeInterface);
    }

    @Override // javax.inject.Provider
    public SendAmountPickerViewModel get() {
        return newInstance(this.walletRepositoryProvider.get(), this.currencyFormatterProvider.get(), this.storeProvider.get());
    }
}