package com.coinbase.wallet.features.wallets.viewmodels;

import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.List;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletsTabViewModel_Factory implements f.c.d<WalletsTabViewModel> {
    private final Provider<e.j.j.b> appPrefsProvider;
    private final Provider<CloudBackupPrompt> cloudBackupPromptProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;
    private final Provider<List<NetworkSetting>> networkSettingsProvider;
    private final Provider<TxHistoryRepository> txHistoryRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public WalletsTabViewModel_Factory(Provider<IWalletRepository> provider, Provider<TxHistoryRepository> provider2, Provider<IFiatCurrencyRepository> provider3, Provider<IExchangeRateRepository> provider4, Provider<e.j.j.b> provider5, Provider<CurrencyFormatter> provider6, Provider<List<NetworkSetting>> provider7, Provider<CloudBackupPrompt> provider8, Provider<ConsumerUserRepository> provider9) {
        this.walletRepositoryProvider = provider;
        this.txHistoryRepositoryProvider = provider2;
        this.fiatCurrencyRepositoryProvider = provider3;
        this.exchangeRateRepositoryProvider = provider4;
        this.appPrefsProvider = provider5;
        this.currencyFormatterProvider = provider6;
        this.networkSettingsProvider = provider7;
        this.cloudBackupPromptProvider = provider8;
        this.consumerUserRepositoryProvider = provider9;
    }

    public static WalletsTabViewModel_Factory create(Provider<IWalletRepository> provider, Provider<TxHistoryRepository> provider2, Provider<IFiatCurrencyRepository> provider3, Provider<IExchangeRateRepository> provider4, Provider<e.j.j.b> provider5, Provider<CurrencyFormatter> provider6, Provider<List<NetworkSetting>> provider7, Provider<CloudBackupPrompt> provider8, Provider<ConsumerUserRepository> provider9) {
        return new WalletsTabViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static WalletsTabViewModel newInstance(IWalletRepository iWalletRepository, TxHistoryRepository txHistoryRepository, IFiatCurrencyRepository iFiatCurrencyRepository, IExchangeRateRepository iExchangeRateRepository, e.j.j.b bVar, CurrencyFormatter currencyFormatter, List<NetworkSetting> list, CloudBackupPrompt cloudBackupPrompt, ConsumerUserRepository consumerUserRepository) {
        return new WalletsTabViewModel(iWalletRepository, txHistoryRepository, iFiatCurrencyRepository, iExchangeRateRepository, bVar, currencyFormatter, list, cloudBackupPrompt, consumerUserRepository);
    }

    @Override // javax.inject.Provider
    public WalletsTabViewModel get() {
        return newInstance(this.walletRepositoryProvider.get(), this.txHistoryRepositoryProvider.get(), this.fiatCurrencyRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get(), this.appPrefsProvider.get(), this.currencyFormatterProvider.get(), this.networkSettingsProvider.get(), this.cloudBackupPromptProvider.get(), this.consumerUserRepositoryProvider.get());
    }
}