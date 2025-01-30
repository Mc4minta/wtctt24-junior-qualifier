package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapAssetPickerViewModel_AssistedFactory_Factory implements f.c.d<SwapAssetPickerViewModel_AssistedFactory> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<ISwapRepository> swapRepositoryProvider;
    private final Provider<UnsupportedSwapAssetPrompt> unsupportedSwapAssetPromptProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SwapAssetPickerViewModel_AssistedFactory_Factory(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<UnsupportedSwapAssetPrompt> provider4) {
        this.walletRepositoryProvider = provider;
        this.swapRepositoryProvider = provider2;
        this.currencyFormatterProvider = provider3;
        this.unsupportedSwapAssetPromptProvider = provider4;
    }

    public static SwapAssetPickerViewModel_AssistedFactory_Factory create(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<UnsupportedSwapAssetPrompt> provider4) {
        return new SwapAssetPickerViewModel_AssistedFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static SwapAssetPickerViewModel_AssistedFactory newInstance(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<UnsupportedSwapAssetPrompt> provider4) {
        return new SwapAssetPickerViewModel_AssistedFactory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public SwapAssetPickerViewModel_AssistedFactory get() {
        return newInstance(this.walletRepositoryProvider, this.swapRepositoryProvider, this.currencyFormatterProvider, this.unsupportedSwapAssetPromptProvider);
    }
}