package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.cloudbackup.viewModel.EnterPasswordViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EnterPasswordFragment_MembersInjector implements f.b<EnterPasswordFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<EnterPasswordViewModel>> viewModelFactoryProvider;

    public EnterPasswordFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<EnterPasswordViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<EnterPasswordFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<EnterPasswordViewModel>> provider2) {
        return new EnterPasswordFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(EnterPasswordFragment enterPasswordFragment, GenericViewModelFactory<EnterPasswordViewModel> genericViewModelFactory) {
        enterPasswordFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(EnterPasswordFragment enterPasswordFragment) {
        dagger.android.g.i.a(enterPasswordFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(enterPasswordFragment, this.viewModelFactoryProvider.get());
    }
}