package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapDisclaimerFragment_MembersInjector implements f.b<SwapDisclaimerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<SwapDisclaimerViewModel.Factory> viewModelFactoryProvider;

    public SwapDisclaimerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapDisclaimerViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SwapDisclaimerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapDisclaimerViewModel.Factory> provider2) {
        return new SwapDisclaimerFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SwapDisclaimerFragment swapDisclaimerFragment, SwapDisclaimerViewModel.Factory factory) {
        swapDisclaimerFragment.viewModelFactory = factory;
    }

    public void injectMembers(SwapDisclaimerFragment swapDisclaimerFragment) {
        i.a(swapDisclaimerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(swapDisclaimerFragment, this.viewModelFactoryProvider.get());
    }
}