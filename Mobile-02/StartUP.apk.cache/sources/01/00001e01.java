package com.coinbase.wallet.features.cloudbackup.viewModel;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RestoreWalletViewModel_Factory implements f.c.d<RestoreWalletViewModel> {
    private final Provider<e.j.i.i2.d> mnemonicBackupRepositoryProvider;

    public RestoreWalletViewModel_Factory(Provider<e.j.i.i2.d> provider) {
        this.mnemonicBackupRepositoryProvider = provider;
    }

    public static RestoreWalletViewModel_Factory create(Provider<e.j.i.i2.d> provider) {
        return new RestoreWalletViewModel_Factory(provider);
    }

    public static RestoreWalletViewModel newInstance(e.j.i.i2.d dVar) {
        return new RestoreWalletViewModel(dVar);
    }

    @Override // javax.inject.Provider
    public RestoreWalletViewModel get() {
        return newInstance(this.mnemonicBackupRepositoryProvider.get());
    }
}