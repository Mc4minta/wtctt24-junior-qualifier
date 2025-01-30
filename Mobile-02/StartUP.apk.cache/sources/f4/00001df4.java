package com.coinbase.wallet.features.cloudbackup.viewModel;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class BackupRecoveryPhraseViewModel_Factory implements f.c.d<BackupRecoveryPhraseViewModel> {
    private final Provider<e.j.i.i2.d> mnemonicBackupRepositoryProvider;

    public BackupRecoveryPhraseViewModel_Factory(Provider<e.j.i.i2.d> provider) {
        this.mnemonicBackupRepositoryProvider = provider;
    }

    public static BackupRecoveryPhraseViewModel_Factory create(Provider<e.j.i.i2.d> provider) {
        return new BackupRecoveryPhraseViewModel_Factory(provider);
    }

    public static BackupRecoveryPhraseViewModel newInstance(e.j.i.i2.d dVar) {
        return new BackupRecoveryPhraseViewModel(dVar);
    }

    @Override // javax.inject.Provider
    public BackupRecoveryPhraseViewModel get() {
        return newInstance(this.mnemonicBackupRepositoryProvider.get());
    }
}