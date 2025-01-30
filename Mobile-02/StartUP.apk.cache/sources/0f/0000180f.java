package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAmountPickerFragment_MembersInjector implements f.b<ConsumerAmountPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ConsumerAmountPickerViewModel.Factory> viewModelFactoryProvider;

    public ConsumerAmountPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerAmountPickerViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerAmountPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerAmountPickerViewModel.Factory> provider2) {
        return new ConsumerAmountPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ConsumerAmountPickerFragment consumerAmountPickerFragment, ConsumerAmountPickerViewModel.Factory factory) {
        consumerAmountPickerFragment.viewModelFactory = factory;
    }

    public void injectMembers(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
        dagger.android.g.i.a(consumerAmountPickerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerAmountPickerFragment, this.viewModelFactoryProvider.get());
    }
}