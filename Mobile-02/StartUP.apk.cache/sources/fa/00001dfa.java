package com.coinbase.wallet.features.cloudbackup.viewModel;

import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.repositories.UserRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EnterPasswordViewModel_Factory implements f.c.d<EnterPasswordViewModel> {
    private final Provider<e.j.i.i2.d> mnemonicBackupRepositoryProvider;
    private final Provider<MnemonicRepositoryInterface> mnemonicRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public EnterPasswordViewModel_Factory(Provider<e.j.i.i2.d> provider, Provider<MnemonicRepositoryInterface> provider2, Provider<UserRepository> provider3) {
        this.mnemonicBackupRepositoryProvider = provider;
        this.mnemonicRepositoryProvider = provider2;
        this.userRepositoryProvider = provider3;
    }

    public static EnterPasswordViewModel_Factory create(Provider<e.j.i.i2.d> provider, Provider<MnemonicRepositoryInterface> provider2, Provider<UserRepository> provider3) {
        return new EnterPasswordViewModel_Factory(provider, provider2, provider3);
    }

    public static EnterPasswordViewModel newInstance(e.j.i.i2.d dVar, MnemonicRepositoryInterface mnemonicRepositoryInterface, UserRepository userRepository) {
        return new EnterPasswordViewModel(dVar, mnemonicRepositoryInterface, userRepository);
    }

    @Override // javax.inject.Provider
    public EnterPasswordViewModel get() {
        return newInstance(this.mnemonicBackupRepositoryProvider.get(), this.mnemonicRepositoryProvider.get(), this.userRepositoryProvider.get());
    }
}