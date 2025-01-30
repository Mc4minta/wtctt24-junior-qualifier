package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendConfirmationViewModel_Factory implements f.c.d<LendConfirmationViewModel> {
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
    private final Provider<ILendRepository> lendRepositoryProvider;
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public LendConfirmationViewModel_Factory(Provider<AuthenticationHelper> provider, Provider<HighMinerFeesPrompt> provider2, Provider<CurrencyFormatter> provider3, Provider<ITxRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<ILendRepository> provider6, Provider<IWalletRepository> provider7) {
        this.authenticationHelperProvider = provider;
        this.highMinerFeesPromptProvider = provider2;
        this.currencyFormatterProvider = provider3;
        this.txRepositoryProvider = provider4;
        this.exchangeRateRepositoryProvider = provider5;
        this.lendRepositoryProvider = provider6;
        this.walletRepositoryProvider = provider7;
    }

    public static LendConfirmationViewModel_Factory create(Provider<AuthenticationHelper> provider, Provider<HighMinerFeesPrompt> provider2, Provider<CurrencyFormatter> provider3, Provider<ITxRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<ILendRepository> provider6, Provider<IWalletRepository> provider7) {
        return new LendConfirmationViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static LendConfirmationViewModel newInstance(AuthenticationHelper authenticationHelper, HighMinerFeesPrompt highMinerFeesPrompt, CurrencyFormatter currencyFormatter, ITxRepository iTxRepository, IExchangeRateRepository iExchangeRateRepository, ILendRepository iLendRepository, IWalletRepository iWalletRepository) {
        return new LendConfirmationViewModel(authenticationHelper, highMinerFeesPrompt, currencyFormatter, iTxRepository, iExchangeRateRepository, iLendRepository, iWalletRepository);
    }

    @Override // javax.inject.Provider
    public LendConfirmationViewModel get() {
        return newInstance(this.authenticationHelperProvider.get(), this.highMinerFeesPromptProvider.get(), this.currencyFormatterProvider.get(), this.txRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.lendRepositoryProvider.get(), this.walletRepositoryProvider.get());
    }
}