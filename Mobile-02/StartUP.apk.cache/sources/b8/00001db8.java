package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class OnboardingBackupRecoveryPhraseFragment_MembersInjector implements f.b<OnboardingBackupRecoveryPhraseFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<OnboardingBackupRecoveryPhraseViewModel.Factory> viewModelFactoryProvider;

    public OnboardingBackupRecoveryPhraseFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<OnboardingBackupRecoveryPhraseViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<OnboardingBackupRecoveryPhraseFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<OnboardingBackupRecoveryPhraseViewModel.Factory> provider2) {
        return new OnboardingBackupRecoveryPhraseFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment, OnboardingBackupRecoveryPhraseViewModel.Factory factory) {
        onboardingBackupRecoveryPhraseFragment.viewModelFactory = factory;
    }

    public void injectMembers(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment) {
        dagger.android.g.i.a(onboardingBackupRecoveryPhraseFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(onboardingBackupRecoveryPhraseFragment, this.viewModelFactoryProvider.get());
    }
}