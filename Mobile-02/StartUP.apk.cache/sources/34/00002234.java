package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapAssetPickerViewModel_AssistedFactory implements SwapAssetPickerViewModel.Factory {
    private final Provider<CurrencyFormatter> currencyFormatter;
    private final Provider<ISwapRepository> swapRepository;
    private final Provider<UnsupportedSwapAssetPrompt> unsupportedSwapAssetPrompt;
    private final Provider<IWalletRepository> walletRepository;

    public SwapAssetPickerViewModel_AssistedFactory(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<UnsupportedSwapAssetPrompt> provider4) {
        this.walletRepository = provider;
        this.swapRepository = provider2;
        this.currencyFormatter = provider3;
        this.unsupportedSwapAssetPrompt = provider4;
    }

    @Override // com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel.Factory
    public SwapAssetPickerViewModel create(androidx.lifecycle.z zVar) {
        return new SwapAssetPickerViewModel(this.walletRepository.get(), this.swapRepository.get(), this.currencyFormatter.get(), this.unsupportedSwapAssetPrompt.get(), zVar);
    }
}