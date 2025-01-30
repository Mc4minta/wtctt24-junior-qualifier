package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TxSignerViewModel_Factory implements f.c.d<TxSignerViewModel> {
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IETHTxRepository> ethereumTxRepositoryProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private final Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
    private final Provider<MinerFeeAPI> minerFeeAPIProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<ITxRepository> txRepositoryProvider;
    private final Provider<WalletLinkRepository> walletLinkRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public TxSignerViewModel_Factory(Provider<CurrencyFormatter> provider, Provider<HighMinerFeesPrompt> provider2, Provider<IWalletRepository> provider3, Provider<ITxRepository> provider4, Provider<IETHTxRepository> provider5, Provider<WalletLinkRepository> provider6, Provider<FeatureFlagsRepository> provider7, Provider<IExchangeRateRepository> provider8, Provider<AuthenticationHelper> provider9, Provider<MinerFeeAPI> provider10, Provider<StoreInterface> provider11) {
        this.currencyFormatterProvider = provider;
        this.highMinerFeesPromptProvider = provider2;
        this.walletRepositoryProvider = provider3;
        this.txRepositoryProvider = provider4;
        this.ethereumTxRepositoryProvider = provider5;
        this.walletLinkRepositoryProvider = provider6;
        this.featureFlagsRepositoryProvider = provider7;
        this.exchangeRateRepositoryProvider = provider8;
        this.authenticationHelperProvider = provider9;
        this.minerFeeAPIProvider = provider10;
        this.storeProvider = provider11;
    }

    public static TxSignerViewModel_Factory create(Provider<CurrencyFormatter> provider, Provider<HighMinerFeesPrompt> provider2, Provider<IWalletRepository> provider3, Provider<ITxRepository> provider4, Provider<IETHTxRepository> provider5, Provider<WalletLinkRepository> provider6, Provider<FeatureFlagsRepository> provider7, Provider<IExchangeRateRepository> provider8, Provider<AuthenticationHelper> provider9, Provider<MinerFeeAPI> provider10, Provider<StoreInterface> provider11) {
        return new TxSignerViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static TxSignerViewModel newInstance(CurrencyFormatter currencyFormatter, HighMinerFeesPrompt highMinerFeesPrompt, IWalletRepository iWalletRepository, ITxRepository iTxRepository, IETHTxRepository iETHTxRepository, WalletLinkRepository walletLinkRepository, FeatureFlagsRepository featureFlagsRepository, IExchangeRateRepository iExchangeRateRepository, AuthenticationHelper authenticationHelper, MinerFeeAPI minerFeeAPI, StoreInterface storeInterface) {
        return new TxSignerViewModel(currencyFormatter, highMinerFeesPrompt, iWalletRepository, iTxRepository, iETHTxRepository, walletLinkRepository, featureFlagsRepository, iExchangeRateRepository, authenticationHelper, minerFeeAPI, storeInterface);
    }

    @Override // javax.inject.Provider
    public TxSignerViewModel get() {
        return newInstance(this.currencyFormatterProvider.get(), this.highMinerFeesPromptProvider.get(), this.walletRepositoryProvider.get(), this.txRepositoryProvider.get(), this.ethereumTxRepositoryProvider.get(), this.walletLinkRepositoryProvider.get(), this.featureFlagsRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.authenticationHelperProvider.get(), this.minerFeeAPIProvider.get(), this.storeProvider.get());
    }
}