package com.coinbase.wallet.features.settings.viewmodels;

import com.coinbase.wallet.user.repositories.UserRepository;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class UserProfileViewModel_Factory implements d<UserProfileViewModel> {
    private final Provider<UserRepository> userRepositoryProvider;

    public UserProfileViewModel_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    public static UserProfileViewModel_Factory create(Provider<UserRepository> provider) {
        return new UserProfileViewModel_Factory(provider);
    }

    public static UserProfileViewModel newInstance(UserRepository userRepository) {
        return new UserProfileViewModel(userRepository);
    }

    @Override // javax.inject.Provider
    public UserProfileViewModel get() {
        return newInstance(this.userRepositoryProvider.get());
    }
}