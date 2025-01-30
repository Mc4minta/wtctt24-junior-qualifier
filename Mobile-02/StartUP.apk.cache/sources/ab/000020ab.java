package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConfirmationFragment_MembersInjector implements f.b<ConfirmationFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactoryWithMap> viewModelFactoryProvider;

    public ConfirmationFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactoryWithMap> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ConfirmationFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactoryWithMap> provider2) {
        return new ConfirmationFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ConfirmationFragment confirmationFragment, ViewModelFactoryWithMap viewModelFactoryWithMap) {
        confirmationFragment.viewModelFactory = viewModelFactoryWithMap;
    }

    public void injectMembers(ConfirmationFragment confirmationFragment) {
        dagger.android.g.i.a(confirmationFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(confirmationFragment, this.viewModelFactoryProvider.get());
    }
}