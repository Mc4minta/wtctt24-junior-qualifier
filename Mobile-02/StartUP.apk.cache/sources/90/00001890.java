package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferMethodsFragment_MembersInjector implements f.b<ConsumerTransferMethodsFragment> {
    private final Provider<ConsumerTransferMethodsViewModel.Factory> viewModelFactoryProvider;

    public ConsumerTransferMethodsFragment_MembersInjector(Provider<ConsumerTransferMethodsViewModel.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static f.b<ConsumerTransferMethodsFragment> create(Provider<ConsumerTransferMethodsViewModel.Factory> provider) {
        return new ConsumerTransferMethodsFragment_MembersInjector(provider);
    }

    public static void injectViewModelFactory(ConsumerTransferMethodsFragment consumerTransferMethodsFragment, ConsumerTransferMethodsViewModel.Factory factory) {
        consumerTransferMethodsFragment.viewModelFactory = factory;
    }

    public void injectMembers(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
        injectViewModelFactory(consumerTransferMethodsFragment, this.viewModelFactoryProvider.get());
    }
}