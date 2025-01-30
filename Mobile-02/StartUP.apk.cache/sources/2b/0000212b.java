package com.coinbase.wallet.features.settings.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import f.b;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class UserProfileFragment_MembersInjector implements b<UserProfileFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<UserProfileViewModel>> viewModelFactoryProvider;

    public UserProfileFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<UserProfileViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static b<UserProfileFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<UserProfileViewModel>> provider2) {
        return new UserProfileFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(UserProfileFragment userProfileFragment, GenericViewModelFactory<UserProfileViewModel> genericViewModelFactory) {
        userProfileFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(UserProfileFragment userProfileFragment) {
        i.a(userProfileFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(userProfileFragment, this.viewModelFactoryProvider.get());
    }
}