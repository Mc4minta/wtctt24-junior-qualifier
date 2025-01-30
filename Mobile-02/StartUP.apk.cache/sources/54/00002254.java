package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapConfirmationViewModel_AssistedFactory implements SwapConfirmationViewModel.Factory {
    private final Provider<AuthenticationHelper> authenticationHelper;
    private final Provider<CurrencyFormatter> currencyFormatter;
    private final Provider<IETHTxRepository> ethTxRepository;
    private final Provider<IExchangeRateRepository> exchangeRateRepository;
    private final Provider<HighMinerFeesPrompt> highMinerFeesPrompt;
    private final Provider<ISwapRepository> swapRepository;
    private final Provider<IWalletRepository> walletRepository;

    public SwapConfirmationViewModel_AssistedFactory(Provider<IWalletRepository> provider, Provider<ISwapRepository> provider2, Provider<IExchangeRateRepository> provider3, Provider<IETHTxRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<AuthenticationHelper> provider6, Provider<HighMinerFeesPrompt> provider7) {
        this.walletRepository = provider;
        this.swapRepository = provider2;
        this.exchangeRateRepository = provider3;
        this.ethTxRepository = provider4;
        this.currencyFormatter = provider5;
        this.authenticationHelper = provider6;
        this.highMinerFeesPrompt = provider7;
    }

    @Override // com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel.Factory
    public SwapConfirmationViewModel create(androidx.lifecycle.z zVar) {
        return new SwapConfirmationViewModel(this.walletRepository.get(), this.swapRepository.get(), this.exchangeRateRepository.get(), this.ethTxRepository.get(), this.currencyFormatter.get(), this.authenticationHelper.get(), this.highMinerFeesPrompt.get(), zVar);
    }
}