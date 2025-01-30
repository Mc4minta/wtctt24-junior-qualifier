package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAccountsViewModel_AssistedFactory_Factory implements f.c.d<ConsumerAccountsViewModel_AssistedFactory> {
    private final Provider<ConsumerAccountsRepository> consumerAccountsRepositoryProvider;
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public ConsumerAccountsViewModel_AssistedFactory_Factory(Provider<ConsumerAccountsRepository> provider, Provider<ConsumerUserRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<ConsumerTransferRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<IWalletRepository> provider6) {
        this.consumerAccountsRepositoryProvider = provider;
        this.consumerUserRepositoryProvider = provider2;
        this.currencyFormatterProvider = provider3;
        this.consumerTransferRepositoryProvider = provider4;
        this.exchangeRateRepositoryProvider = provider5;
        this.walletRepositoryProvider = provider6;
    }

    public static ConsumerAccountsViewModel_AssistedFactory_Factory create(Provider<ConsumerAccountsRepository> provider, Provider<ConsumerUserRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<ConsumerTransferRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<IWalletRepository> provider6) {
        return new ConsumerAccountsViewModel_AssistedFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ConsumerAccountsViewModel_AssistedFactory newInstance(Provider<ConsumerAccountsRepository> provider, Provider<ConsumerUserRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<ConsumerTransferRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<IWalletRepository> provider6) {
        return new ConsumerAccountsViewModel_AssistedFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public ConsumerAccountsViewModel_AssistedFactory get() {
        return newInstance(this.consumerAccountsRepositoryProvider, this.consumerUserRepositoryProvider, this.currencyFormatterProvider, this.consumerTransferRepositoryProvider, this.exchangeRateRepositoryProvider, this.walletRepositoryProvider);
    }
}