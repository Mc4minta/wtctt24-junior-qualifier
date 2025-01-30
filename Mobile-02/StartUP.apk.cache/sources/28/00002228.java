package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel_AssistedFactory implements SwapAmountPickerViewModel.Factory {
    private final Provider<AmountPickerFormatter> amountPickerFormatter;
    private final Provider<AppLockRepositoryInterface> appLockRepository;
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepository;
    private final Provider<ISwapRepository> swapRepository;
    private final Provider<IWalletRepository> walletRepository;

    public SwapAmountPickerViewModel_AssistedFactory(Provider<AppLockRepositoryInterface> provider, Provider<ISwapRepository> provider2, Provider<AmountPickerFormatter> provider3, Provider<IFiatCurrencyRepository> provider4, Provider<IWalletRepository> provider5) {
        this.appLockRepository = provider;
        this.swapRepository = provider2;
        this.amountPickerFormatter = provider3;
        this.fiatCurrencyRepository = provider4;
        this.walletRepository = provider5;
    }

    @Override // com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel.Factory
    public SwapAmountPickerViewModel create(androidx.lifecycle.z zVar) {
        return new SwapAmountPickerViewModel(this.appLockRepository.get(), this.swapRepository.get(), this.amountPickerFormatter.get(), this.fiatCurrencyRepository.get(), this.walletRepository.get(), zVar);
    }
}