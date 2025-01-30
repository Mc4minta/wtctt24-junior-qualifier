package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendCoinPickerViewModel_Factory implements f.c.d<LendCoinPickerViewModel> {
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private final Provider<ILendRepository> lendRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public LendCoinPickerViewModel_Factory(Provider<IWalletRepository> provider, Provider<ILendRepository> provider2, Provider<FeatureFlagsRepository> provider3, Provider<ConsumerUserRepository> provider4, Provider<CurrencyFormatter> provider5) {
        this.walletRepositoryProvider = provider;
        this.lendRepositoryProvider = provider2;
        this.featureFlagsRepositoryProvider = provider3;
        this.consumerUserRepositoryProvider = provider4;
        this.currencyFormatterProvider = provider5;
    }

    public static LendCoinPickerViewModel_Factory create(Provider<IWalletRepository> provider, Provider<ILendRepository> provider2, Provider<FeatureFlagsRepository> provider3, Provider<ConsumerUserRepository> provider4, Provider<CurrencyFormatter> provider5) {
        return new LendCoinPickerViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LendCoinPickerViewModel newInstance(IWalletRepository iWalletRepository, ILendRepository iLendRepository, FeatureFlagsRepository featureFlagsRepository, ConsumerUserRepository consumerUserRepository, CurrencyFormatter currencyFormatter) {
        return new LendCoinPickerViewModel(iWalletRepository, iLendRepository, featureFlagsRepository, consumerUserRepository, currencyFormatter);
    }

    @Override // javax.inject.Provider
    public LendCoinPickerViewModel get() {
        return newInstance(this.walletRepositoryProvider.get(), this.lendRepositoryProvider.get(), this.featureFlagsRepositoryProvider.get(), this.consumerUserRepositoryProvider.get(), this.currencyFormatterProvider.get());
    }
}