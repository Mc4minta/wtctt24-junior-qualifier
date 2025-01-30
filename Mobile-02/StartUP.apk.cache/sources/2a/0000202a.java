package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendConfirmationViewModel_Factory implements f.c.d<SendConfirmationViewModel> {
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private final Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public SendConfirmationViewModel_Factory(Provider<AuthenticationHelper> provider, Provider<CurrencyFormatter> provider2, Provider<IWalletRepository> provider3, Provider<ITxRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<FeatureFlagsRepository> provider6, Provider<HighMinerFeesPrompt> provider7) {
        this.authenticationHelperProvider = provider;
        this.currencyFormatterProvider = provider2;
        this.walletRepositoryProvider = provider3;
        this.txRepositoryProvider = provider4;
        this.exchangeRateRepositoryProvider = provider5;
        this.featureFlagsRepositoryProvider = provider6;
        this.highMinerFeesPromptProvider = provider7;
    }

    public static SendConfirmationViewModel_Factory create(Provider<AuthenticationHelper> provider, Provider<CurrencyFormatter> provider2, Provider<IWalletRepository> provider3, Provider<ITxRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<FeatureFlagsRepository> provider6, Provider<HighMinerFeesPrompt> provider7) {
        return new SendConfirmationViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SendConfirmationViewModel newInstance(AuthenticationHelper authenticationHelper, CurrencyFormatter currencyFormatter, IWalletRepository iWalletRepository, ITxRepository iTxRepository, IExchangeRateRepository iExchangeRateRepository, FeatureFlagsRepository featureFlagsRepository, HighMinerFeesPrompt highMinerFeesPrompt) {
        return new SendConfirmationViewModel(authenticationHelper, currencyFormatter, iWalletRepository, iTxRepository, iExchangeRateRepository, featureFlagsRepository, highMinerFeesPrompt);
    }

    @Override // javax.inject.Provider
    public SendConfirmationViewModel get() {
        return newInstance(this.authenticationHelperProvider.get(), this.currencyFormatterProvider.get(), this.walletRepositoryProvider.get(), this.txRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.featureFlagsRepositoryProvider.get(), this.highMinerFeesPromptProvider.get());
    }
}