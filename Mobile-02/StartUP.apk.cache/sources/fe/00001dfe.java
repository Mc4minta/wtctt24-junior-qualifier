package com.coinbase.wallet.features.cloudbackup.viewModel;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class OnboardingBackupRecoveryPhraseViewModel_AssistedFactory_Factory implements f.c.d<OnboardingBackupRecoveryPhraseViewModel_AssistedFactory> {
    private final Provider<StoreInterface> storeProvider;

    public OnboardingBackupRecoveryPhraseViewModel_AssistedFactory_Factory(Provider<StoreInterface> provider) {
        this.storeProvider = provider;
    }

    public static OnboardingBackupRecoveryPhraseViewModel_AssistedFactory_Factory create(Provider<StoreInterface> provider) {
        return new OnboardingBackupRecoveryPhraseViewModel_AssistedFactory_Factory(provider);
    }

    public static OnboardingBackupRecoveryPhraseViewModel_AssistedFactory newInstance(Provider<StoreInterface> provider) {
        return new OnboardingBackupRecoveryPhraseViewModel_AssistedFactory(provider);
    }

    @Override // javax.inject.Provider
    public OnboardingBackupRecoveryPhraseViewModel_AssistedFactory get() {
        return newInstance(this.storeProvider);
    }
}