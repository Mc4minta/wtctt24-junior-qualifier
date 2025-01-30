package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapCompleteFragment_MembersInjector implements f.b<SwapCompleteFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<SwapCompleteViewModel.Factory> viewModelFactoryProvider;

    public SwapCompleteFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapCompleteViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SwapCompleteFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapCompleteViewModel.Factory> provider2) {
        return new SwapCompleteFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SwapCompleteFragment swapCompleteFragment, SwapCompleteViewModel.Factory factory) {
        swapCompleteFragment.viewModelFactory = factory;
    }

    public void injectMembers(SwapCompleteFragment swapCompleteFragment) {
        i.a(swapCompleteFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(swapCompleteFragment, this.viewModelFactoryProvider.get());
    }
}