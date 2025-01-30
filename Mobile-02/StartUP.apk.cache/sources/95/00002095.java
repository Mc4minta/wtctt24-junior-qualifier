package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AmountPickerFragment_MembersInjector implements f.b<AmountPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactoryWithMap> viewModelFactoryProvider;

    public AmountPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactoryWithMap> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<AmountPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactoryWithMap> provider2) {
        return new AmountPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(AmountPickerFragment amountPickerFragment, ViewModelFactoryWithMap viewModelFactoryWithMap) {
        amountPickerFragment.viewModelFactory = viewModelFactoryWithMap;
    }

    public void injectMembers(AmountPickerFragment amountPickerFragment) {
        dagger.android.g.i.a(amountPickerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(amountPickerFragment, this.viewModelFactoryProvider.get());
    }
}