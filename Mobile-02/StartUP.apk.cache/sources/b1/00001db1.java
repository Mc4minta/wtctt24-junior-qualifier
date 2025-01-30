package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.features.cloudbackup.util.RecoveryPhraseClipboardWrapper;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ManualBackupFragment_MembersInjector implements f.b<ManualBackupFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<RecoveryPhraseClipboardWrapper> recoveryPhraseClipboardWrapperProvider;

    public ManualBackupFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<RecoveryPhraseClipboardWrapper> provider2) {
        this.androidInjectorProvider = provider;
        this.recoveryPhraseClipboardWrapperProvider = provider2;
    }

    public static f.b<ManualBackupFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<RecoveryPhraseClipboardWrapper> provider2) {
        return new ManualBackupFragment_MembersInjector(provider, provider2);
    }

    public static void injectRecoveryPhraseClipboardWrapper(ManualBackupFragment manualBackupFragment, RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper) {
        manualBackupFragment.recoveryPhraseClipboardWrapper = recoveryPhraseClipboardWrapper;
    }

    public void injectMembers(ManualBackupFragment manualBackupFragment) {
        dagger.android.g.i.a(manualBackupFragment, this.androidInjectorProvider.get());
        injectRecoveryPhraseClipboardWrapper(manualBackupFragment, this.recoveryPhraseClipboardWrapperProvider.get());
    }
}