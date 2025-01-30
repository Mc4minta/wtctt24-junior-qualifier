package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapAssetPickerFragment_MembersInjector implements f.b<SwapAssetPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<SwapAssetPickerViewModel.Factory> viewModelFactoryProvider;

    public SwapAssetPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapAssetPickerViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SwapAssetPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapAssetPickerViewModel.Factory> provider2) {
        return new SwapAssetPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SwapAssetPickerFragment swapAssetPickerFragment, SwapAssetPickerViewModel.Factory factory) {
        swapAssetPickerFragment.viewModelFactory = factory;
    }

    public void injectMembers(SwapAssetPickerFragment swapAssetPickerFragment) {
        i.a(swapAssetPickerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(swapAssetPickerFragment, this.viewModelFactoryProvider.get());
    }
}