package com.coinbase.wallet.application.fragment;

import com.coinbase.wallet.application.viewmodel.SignOutViewModel;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.g;
import f.b;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SignOutFragment_MembersInjector implements b<SignOutFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<SignOutViewModel>> viewModelFactoryProvider;

    public SignOutFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SignOutViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static b<SignOutFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SignOutViewModel>> provider2) {
        return new SignOutFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SignOutFragment signOutFragment, GenericViewModelFactory<SignOutViewModel> genericViewModelFactory) {
        signOutFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(SignOutFragment signOutFragment) {
        g.a(signOutFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(signOutFragment, this.viewModelFactoryProvider.get());
    }
}