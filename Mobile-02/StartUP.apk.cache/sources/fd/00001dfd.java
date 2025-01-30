package com.coinbase.wallet.features.cloudbackup.viewModel;

import androidx.lifecycle.z;
import com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class OnboardingBackupRecoveryPhraseViewModel_AssistedFactory implements OnboardingBackupRecoveryPhraseViewModel.Factory {
    private final Provider<StoreInterface> store;

    public OnboardingBackupRecoveryPhraseViewModel_AssistedFactory(Provider<StoreInterface> provider) {
        this.store = provider;
    }

    @Override // com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel.Factory
    public OnboardingBackupRecoveryPhraseViewModel create(z zVar) {
        return new OnboardingBackupRecoveryPhraseViewModel(this.store.get(), zVar);
    }
}