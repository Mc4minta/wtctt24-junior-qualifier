package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAvailablePaymentMethodsViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsFragment_MembersInjector implements f.b<ConsumerAvailablePaymentMethodsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel>> viewModelFactoryProvider;

    public ConsumerAvailablePaymentMethodsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerAvailablePaymentMethodsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel>> provider2) {
        return new ConsumerAvailablePaymentMethodsFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment, GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel> genericViewModelFactory) {
        consumerAvailablePaymentMethodsFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
        dagger.android.g.i.a(consumerAvailablePaymentMethodsFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerAvailablePaymentMethodsFragment, this.viewModelFactoryProvider.get());
    }
}