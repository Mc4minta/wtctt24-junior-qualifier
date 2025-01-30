package com.coinbase.wallet.consumer.repositories;

import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferRepository_Factory implements f.c.d<ConsumerTransferRepository> {
    private final Provider<ConsumerAPI> consumerAPIProvider;
    private final Provider<ConsumerAccountsRepository> consumerAccountsRepositoryProvider;
    private final Provider<ConsumerAvailablePaymentMethodsDAO> consumerAvailablePaymentMethodsDAOProvider;
    private final Provider<ConsumerPaymentMethodsDAO> consumerPaymentMethodsDAOProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<IETHWalletRepository> erc20OwningProvider;
    private final Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;

    public ConsumerTransferRepository_Factory(Provider<ConsumerAccountsRepository> provider, Provider<ConsumerAPI> provider2, Provider<IETHWalletRepository> provider3, Provider<ConsumerUserRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<ConsumerPaymentMethodsDAO> provider6, Provider<ConsumerAvailablePaymentMethodsDAO> provider7, Provider<FeatureFlagsRepository> provider8, Provider<IExchangeRateRepository> provider9) {
        this.consumerAccountsRepositoryProvider = provider;
        this.consumerAPIProvider = provider2;
        this.erc20OwningProvider = provider3;
        this.consumerUserRepositoryProvider = provider4;
        this.currencyFormatterProvider = provider5;
        this.consumerPaymentMethodsDAOProvider = provider6;
        this.consumerAvailablePaymentMethodsDAOProvider = provider7;
        this.featureFlagsRepositoryProvider = provider8;
        this.exchangeRateRepositoryProvider = provider9;
    }

    public static ConsumerTransferRepository_Factory create(Provider<ConsumerAccountsRepository> provider, Provider<ConsumerAPI> provider2, Provider<IETHWalletRepository> provider3, Provider<ConsumerUserRepository> provider4, Provider<CurrencyFormatter> provider5, Provider<ConsumerPaymentMethodsDAO> provider6, Provider<ConsumerAvailablePaymentMethodsDAO> provider7, Provider<FeatureFlagsRepository> provider8, Provider<IExchangeRateRepository> provider9) {
        return new ConsumerTransferRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ConsumerTransferRepository newInstance(ConsumerAccountsRepository consumerAccountsRepository, ConsumerAPI consumerAPI, IETHWalletRepository iETHWalletRepository, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter, ConsumerPaymentMethodsDAO consumerPaymentMethodsDAO, ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO, FeatureFlagsRepository featureFlagsRepository, IExchangeRateRepository iExchangeRateRepository) {
        return new ConsumerTransferRepository(consumerAccountsRepository, consumerAPI, iETHWalletRepository, consumerUserRepository, currencyFormatter, consumerPaymentMethodsDAO, consumerAvailablePaymentMethodsDAO, featureFlagsRepository, iExchangeRateRepository);
    }

    @Override // javax.inject.Provider
    public ConsumerTransferRepository get() {
        return newInstance(this.consumerAccountsRepositoryProvider.get(), this.consumerAPIProvider.get(), this.erc20OwningProvider.get(), this.consumerUserRepositoryProvider.get(), this.currencyFormatterProvider.get(), this.consumerPaymentMethodsDAOProvider.get(), this.consumerAvailablePaymentMethodsDAOProvider.get(), this.featureFlagsRepositoryProvider.get(), this.exchangeRateRepositoryProvider.get());
    }
}