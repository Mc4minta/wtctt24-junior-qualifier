package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwapAmountPickerFragment_MembersInjector implements f.b<SwapAmountPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<SwapAmountPickerViewModel.Factory> swapAmountPickerViewModelFactoryProvider;

    public SwapAmountPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapAmountPickerViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.swapAmountPickerViewModelFactoryProvider = provider2;
    }

    public static f.b<SwapAmountPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<SwapAmountPickerViewModel.Factory> provider2) {
        return new SwapAmountPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectSwapAmountPickerViewModelFactory(SwapAmountPickerFragment swapAmountPickerFragment, SwapAmountPickerViewModel.Factory factory) {
        swapAmountPickerFragment.swapAmountPickerViewModelFactory = factory;
    }

    public void injectMembers(SwapAmountPickerFragment swapAmountPickerFragment) {
        i.a(swapAmountPickerFragment, this.androidInjectorProvider.get());
        injectSwapAmountPickerViewModelFactory(swapAmountPickerFragment, this.swapAmountPickerViewModelFactoryProvider.get());
    }
}