package com.coinbase.wallet.features.lend.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.lend.viewmodels.LendProviderPickerViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendProviderPickerFragment_MembersInjector implements f.b<LendProviderPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LendProviderPickerViewModel>> lendProviderPickerViewModelFactoryProvider;

    public LendProviderPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendProviderPickerViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.lendProviderPickerViewModelFactoryProvider = provider2;
    }

    public static f.b<LendProviderPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendProviderPickerViewModel>> provider2) {
        return new LendProviderPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectLendProviderPickerViewModelFactory(LendProviderPickerFragment lendProviderPickerFragment, GenericViewModelFactory<LendProviderPickerViewModel> genericViewModelFactory) {
        lendProviderPickerFragment.lendProviderPickerViewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(LendProviderPickerFragment lendProviderPickerFragment) {
        i.a(lendProviderPickerFragment, this.androidInjectorProvider.get());
        injectLendProviderPickerViewModelFactory(lendProviderPickerFragment, this.lendProviderPickerViewModelFactoryProvider.get());
    }
}