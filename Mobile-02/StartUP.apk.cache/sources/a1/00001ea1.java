package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendProviderPickerViewModel_Factory implements f.c.d<LendProviderPickerViewModel> {
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;

    public LendProviderPickerViewModel_Factory(Provider<FeatureFlagsRepository> provider, Provider<CurrencyFormatter> provider2) {
        this.featureFlagsRepositoryProvider = provider;
        this.currencyFormatterProvider = provider2;
    }

    public static LendProviderPickerViewModel_Factory create(Provider<FeatureFlagsRepository> provider, Provider<CurrencyFormatter> provider2) {
        return new LendProviderPickerViewModel_Factory(provider, provider2);
    }

    public static LendProviderPickerViewModel newInstance(FeatureFlagsRepository featureFlagsRepository, CurrencyFormatter currencyFormatter) {
        return new LendProviderPickerViewModel(featureFlagsRepository, currencyFormatter);
    }

    @Override // javax.inject.Provider
    public LendProviderPickerViewModel get() {
        return newInstance(this.featureFlagsRepositoryProvider.get(), this.currencyFormatterProvider.get());
    }
}