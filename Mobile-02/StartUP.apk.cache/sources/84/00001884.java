package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferInitiatedViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferInitiatedFragment_MembersInjector implements f.b<ConsumerTransferInitiatedFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<ConsumerTransferInitiatedViewModel>> viewModelFactoryProvider;

    public ConsumerTransferInitiatedFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerTransferInitiatedViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerTransferInitiatedFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerTransferInitiatedViewModel>> provider2) {
        return new ConsumerTransferInitiatedFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment, GenericViewModelFactory<ConsumerTransferInitiatedViewModel> genericViewModelFactory) {
        consumerTransferInitiatedFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment) {
        dagger.android.g.i.a(consumerTransferInitiatedFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerTransferInitiatedFragment, this.viewModelFactoryProvider.get());
    }
}