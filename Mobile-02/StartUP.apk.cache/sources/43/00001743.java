package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAccountsViewModel_AssistedFactory implements ConsumerAccountsViewModel.Factory {
    private final Provider<ConsumerAccountsRepository> consumerAccountsRepository;
    private final Provider<ConsumerTransferRepository> consumerTransferRepository;
    private final Provider<ConsumerUserRepository> consumerUserRepository;
    private final Provider<CurrencyFormatter> currencyFormatter;
    private final Provider<IExchangeRateRepository> exchangeRateRepository;
    private final Provider<IWalletRepository> walletRepository;

    public ConsumerAccountsViewModel_AssistedFactory(Provider<ConsumerAccountsRepository> provider, Provider<ConsumerUserRepository> provider2, Provider<CurrencyFormatter> provider3, Provider<ConsumerTransferRepository> provider4, Provider<IExchangeRateRepository> provider5, Provider<IWalletRepository> provider6) {
        this.consumerAccountsRepository = provider;
        this.consumerUserRepository = provider2;
        this.currencyFormatter = provider3;
        this.consumerTransferRepository = provider4;
        this.exchangeRateRepository = provider5;
        this.walletRepository = provider6;
    }

    @Override // com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel.Factory
    public ConsumerAccountsViewModel create(androidx.lifecycle.z zVar) {
        return new ConsumerAccountsViewModel(this.consumerAccountsRepository.get(), this.consumerUserRepository.get(), this.currencyFormatter.get(), this.consumerTransferRepository.get(), zVar, this.exchangeRateRepository.get(), this.walletRepository.get());
    }
}