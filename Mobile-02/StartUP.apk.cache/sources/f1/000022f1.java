package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapInterstitialFragment_MembersInjector implements f.b<SwapInterstitialFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<SwapInterstitialViewModel.Factory> swapInterstitialViewModelFactoryProvider;

    public SwapInterstitialFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapInterstitialViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.swapInterstitialViewModelFactoryProvider = provider2;
    }

    public static f.b<SwapInterstitialFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapInterstitialViewModel.Factory> provider2) {
        return new SwapInterstitialFragment_MembersInjector(provider, provider2);
    }

    public static void injectSwapInterstitialViewModelFactory(SwapInterstitialFragment swapInterstitialFragment, SwapInterstitialViewModel.Factory factory) {
        swapInterstitialFragment.swapInterstitialViewModelFactory = factory;
    }

    public void injectMembers(SwapInterstitialFragment swapInterstitialFragment) {
        i.a(swapInterstitialFragment, this.androidInjectorProvider.get());
        injectSwapInterstitialViewModelFactory(swapInterstitialFragment, this.swapInterstitialViewModelFactoryProvider.get());
    }
}