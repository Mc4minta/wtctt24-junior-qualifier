package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CompleteFragment_MembersInjector implements f.b<CompleteFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactoryWithMap> viewModelFactoryProvider;

    public CompleteFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactoryWithMap> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<CompleteFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactoryWithMap> provider2) {
        return new CompleteFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(CompleteFragment completeFragment, ViewModelFactoryWithMap viewModelFactoryWithMap) {
        completeFragment.viewModelFactory = viewModelFactoryWithMap;
    }

    public void injectMembers(CompleteFragment completeFragment) {
        dagger.android.g.i.a(completeFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(completeFragment, this.viewModelFactoryProvider.get());
    }
}