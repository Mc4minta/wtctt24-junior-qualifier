package com.coinbase.wallet.features.lend.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.lend.viewmodels.LendCoinPickerViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendCoinPickerFragment_MembersInjector implements f.b<LendCoinPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LendCoinPickerViewModel>> lendCoinPickerViewModelFactoryProvider;

    public LendCoinPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendCoinPickerViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.lendCoinPickerViewModelFactoryProvider = provider2;
    }

    public static f.b<LendCoinPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendCoinPickerViewModel>> provider2) {
        return new LendCoinPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectLendCoinPickerViewModelFactory(LendCoinPickerFragment lendCoinPickerFragment, GenericViewModelFactory<LendCoinPickerViewModel> genericViewModelFactory) {
        lendCoinPickerFragment.lendCoinPickerViewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(LendCoinPickerFragment lendCoinPickerFragment) {
        i.a(lendCoinPickerFragment, this.androidInjectorProvider.get());
        injectLendCoinPickerViewModelFactory(lendCoinPickerFragment, this.lendCoinPickerViewModelFactoryProvider.get());
    }
}