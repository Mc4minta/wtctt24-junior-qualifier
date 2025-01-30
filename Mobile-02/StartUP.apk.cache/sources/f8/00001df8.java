package com.coinbase.wallet.features.cloudbackup.viewModel;

import com.coinbase.wallet.user.repositories.UserRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CreatePasswordViewModel_Factory implements f.c.d<CreatePasswordViewModel> {
    private final Provider<e.j.i.i2.d> mnemonicBackupRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public CreatePasswordViewModel_Factory(Provider<e.j.i.i2.d> provider, Provider<UserRepository> provider2) {
        this.mnemonicBackupRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
    }

    public static CreatePasswordViewModel_Factory create(Provider<e.j.i.i2.d> provider, Provider<UserRepository> provider2) {
        return new CreatePasswordViewModel_Factory(provider, provider2);
    }

    public static CreatePasswordViewModel newInstance(e.j.i.i2.d dVar, UserRepository userRepository) {
        return new CreatePasswordViewModel(dVar, userRepository);
    }

    @Override // javax.inject.Provider
    public CreatePasswordViewModel get() {
        return newInstance(this.mnemonicBackupRepositoryProvider.get(), this.userRepositoryProvider.get());
    }
}