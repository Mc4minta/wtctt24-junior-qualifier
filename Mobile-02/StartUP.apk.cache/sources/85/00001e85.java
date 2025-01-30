package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import e.j.i.a2;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendAmountPickerViewModel_Factory implements f.c.d<LendAmountPickerViewModel> {
    private final Provider<CloudBackupPrompt> cloudBackupPromptProvider;
    private final Provider<CurrencyFormatter> currencyFormatterProvider;
    private final Provider<a2> mnemonicBackupRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;

    public LendAmountPickerViewModel_Factory(Provider<CurrencyFormatter> provider, Provider<StoreInterface> provider2, Provider<CloudBackupPrompt> provider3, Provider<a2> provider4) {
        this.currencyFormatterProvider = provider;
        this.storeProvider = provider2;
        this.cloudBackupPromptProvider = provider3;
        this.mnemonicBackupRepositoryProvider = provider4;
    }

    public static LendAmountPickerViewModel_Factory create(Provider<CurrencyFormatter> provider, Provider<StoreInterface> provider2, Provider<CloudBackupPrompt> provider3, Provider<a2> provider4) {
        return new LendAmountPickerViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static LendAmountPickerViewModel newInstance(CurrencyFormatter currencyFormatter, StoreInterface storeInterface, CloudBackupPrompt cloudBackupPrompt, a2 a2Var) {
        return new LendAmountPickerViewModel(currencyFormatter, storeInterface, cloudBackupPrompt, a2Var);
    }

    @Override // javax.inject.Provider
    public LendAmountPickerViewModel get() {
        return newInstance(this.currencyFormatterProvider.get(), this.storeProvider.get(), this.cloudBackupPromptProvider.get(), this.mnemonicBackupRepositoryProvider.get());
    }
}