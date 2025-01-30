package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapConfirmationViewModel_AssistedFactory_Factory implements f.c.d<SwapConfirmationViewModel_AssistedFactory> {
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IETHTxRepository> ethTxRepositoryProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
    private final Provider<ISwapRepository> swapRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SwapConfirmationViewModel_AssistedFactory_Factory(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<IExchangeRateRepository> provider3, Provider<IETHTxRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<AuthenticationHelper> provider6, Provider<HighMinerFeesPrompt> provider7) {
        this.walletRepositoryProvider = provider;
        this.swapRepositoryProvider = provider2;
        this.exchangeRateRepositoryProvider = provider3;
        this.ethTxRepositoryProvider = provider4;
        this.currencyFormatterProvider = provider5;
        this.authenticationHelperProvider = provider6;
        this.highMinerFeesPromptProvider = provider7;
    }

    public static SwapConfirmationViewModel_AssistedFactory_Factory create(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<IExchangeRateRepository> provider3, Provider<IETHTxRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<AuthenticationHelper> provider6, Provider<HighMinerFeesPrompt> provider7) {
        return new SwapConfirmationViewModel_AssistedFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SwapConfirmationViewModel_AssistedFactory newInstance(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<IExchangeRateRepository> provider3, Provider<IETHTxRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<AuthenticationHelper> provider6, Provider<HighMinerFeesPrompt> provider7) {
        return new SwapConfirmationViewModel_AssistedFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public SwapConfirmationViewModel_AssistedFactory get() {
        return newInstance(this.walletRepositoryProvider, this.swapRepositoryProvider, this.exchangeRateRepositoryProvider, this.ethTxRepositoryProvider, this.currencyFormatterProvider, this.authenticationHelperProvider, this.highMinerFeesPromptProvider);
    }
}