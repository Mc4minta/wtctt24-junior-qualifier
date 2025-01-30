package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapConfirmationFragment_MembersInjector implements f.b<SwapConfirmationFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<SwapConfirmationViewModel.Factory> viewModelFactoryProvider;

    public SwapConfirmationFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapConfirmationViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SwapConfirmationFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapConfirmationViewModel.Factory> provider2) {
        return new SwapConfirmationFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SwapConfirmationFragment swapConfirmationFragment, SwapConfirmationViewModel.Factory factory) {
        swapConfirmationFragment.viewModelFactory = factory;
    }

    public void injectMembers(SwapConfirmationFragment swapConfirmationFragment) {
        i.a(swapConfirmationFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(swapConfirmationFragment, this.viewModelFactoryProvider.get());
    }
}