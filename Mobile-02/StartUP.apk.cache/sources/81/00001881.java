package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationFragment_MembersInjector implements f.b<ConsumerTransferConfirmationFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ConsumerTransferMethodsViewModel.Factory> transferMethodsViewModelFactoryProvider;
    private final Provider<ConsumerTransferConfirmationViewModel.Factory> viewModelFactoryProvider;

    public ConsumerTransferConfirmationFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerTransferConfirmationViewModel.Factory> provider2, Provider<ConsumerTransferMethodsViewModel.Factory> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.transferMethodsViewModelFactoryProvider = provider3;
    }

    public static f.b<ConsumerTransferConfirmationFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerTransferConfirmationViewModel.Factory> provider2, Provider<ConsumerTransferMethodsViewModel.Factory> provider3) {
        return new ConsumerTransferConfirmationFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectTransferMethodsViewModelFactory(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment, ConsumerTransferMethodsViewModel.Factory factory) {
        consumerTransferConfirmationFragment.transferMethodsViewModelFactory = factory;
    }

    public static void injectViewModelFactory(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment, ConsumerTransferConfirmationViewModel.Factory factory) {
        consumerTransferConfirmationFragment.viewModelFactory = factory;
    }

    public void injectMembers(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
        dagger.android.g.i.a(consumerTransferConfirmationFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerTransferConfirmationFragment, this.viewModelFactoryProvider.get());
        injectTransferMethodsViewModelFactory(consumerTransferConfirmationFragment, this.transferMethodsViewModelFactoryProvider.get());
    }
}