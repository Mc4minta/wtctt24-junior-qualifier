package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.util.RecoveryPhraseClipboardWrapper;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment_MembersInjector implements f.b<BackupRecoveryPhraseFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<RecoveryPhraseClipboardWrapper> recoveryPhraseClipboardWrapperProvider;
    private final Provider<GenericViewModelFactory<BackupRecoveryPhraseViewModel>> viewModelFactoryProvider;

    public BackupRecoveryPhraseFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<AuthenticationHelper> provider2, Provider<RecoveryPhraseClipboardWrapper> provider3, Provider<GenericViewModelFactory<BackupRecoveryPhraseViewModel>> provider4) {
        this.androidInjectorProvider = provider;
        this.authenticationHelperProvider = provider2;
        this.recoveryPhraseClipboardWrapperProvider = provider3;
        this.viewModelFactoryProvider = provider4;
    }

    public static f.b<BackupRecoveryPhraseFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<AuthenticationHelper> provider2, Provider<RecoveryPhraseClipboardWrapper> provider3, Provider<GenericViewModelFactory<BackupRecoveryPhraseViewModel>> provider4) {
        return new BackupRecoveryPhraseFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectAuthenticationHelper(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, AuthenticationHelper authenticationHelper) {
        backupRecoveryPhraseFragment.authenticationHelper = authenticationHelper;
    }

    public static void injectRecoveryPhraseClipboardWrapper(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper) {
        backupRecoveryPhraseFragment.recoveryPhraseClipboardWrapper = recoveryPhraseClipboardWrapper;
    }

    public static void injectViewModelFactory(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, GenericViewModelFactory<BackupRecoveryPhraseViewModel> genericViewModelFactory) {
        backupRecoveryPhraseFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        dagger.android.g.i.a(backupRecoveryPhraseFragment, this.androidInjectorProvider.get());
        injectAuthenticationHelper(backupRecoveryPhraseFragment, this.authenticationHelperProvider.get());
        injectRecoveryPhraseClipboardWrapper(backupRecoveryPhraseFragment, this.recoveryPhraseClipboardWrapperProvider.get());
        injectViewModelFactory(backupRecoveryPhraseFragment, this.viewModelFactoryProvider.get());
    }
}