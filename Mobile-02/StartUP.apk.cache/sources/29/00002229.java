package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel_AssistedFactory_Factory implements f.c.d<SwapAmountPickerViewModel_AssistedFactory> {
    private final Provider<AmountPickerFormatter> amountPickerFormatterProvider;
    private final Provider<AppLockRepositoryInterface> appLockRepositoryProvider;
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;
    private final Provider<ISwapRepository> swapRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SwapAmountPickerViewModel_AssistedFactory_Factory(Provider<AppLockRepositoryInterface> provider, Provider<ISwapRepository> provider2, Provider<AmountPickerFormatter> provider3, Provider<IFiatCurrencyRepository> provider4, Provider<IWalletRepository> provider5) {
        this.appLockRepositoryProvider = provider;
        this.swapRepositoryProvider = provider2;
        this.amountPickerFormatterProvider = provider3;
        this.fiatCurrencyRepositoryProvider = provider4;
        this.walletRepositoryProvider = provider5;
    }

    public static SwapAmountPickerViewModel_AssistedFactory_Factory create(Provider<AppLockRepositoryInterface> provider, Provider<ISwapRepository> provider2, Provider<AmountPickerFormatter> provider3, Provider<IFiatCurrencyRepository> provider4, Provider<IWalletRepository> provider5) {
        return new SwapAmountPickerViewModel_AssistedFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SwapAmountPickerViewModel_AssistedFactory newInstance(Provider<AppLockRepositoryInterface> provider, Provider<ISwapRepository> provider2, Provider<AmountPickerFormatter> provider3, Provider<IFiatCurrencyRepository> provider4, Provider<IWalletRepository> provider5) {
        return new SwapAmountPickerViewModel_AssistedFactory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public SwapAmountPickerViewModel_AssistedFactory get() {
        return newInstance(this.appLockRepositoryProvider, this.swapRepositoryProvider, this.amountPickerFormatterProvider, this.fiatCurrencyRepositoryProvider, this.walletRepositoryProvider);
    }
}