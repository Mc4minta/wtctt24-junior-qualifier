package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerCardCDVViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerCardCDVFragment_MembersInjector implements f.b<ConsumerCardCDVFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ConsumerCardCDVViewModel.Factory> viewModelFactoryProvider;

    public ConsumerCardCDVFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerCardCDVViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerCardCDVFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerCardCDVViewModel.Factory> provider2) {
        return new ConsumerCardCDVFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ConsumerCardCDVFragment consumerCardCDVFragment, ConsumerCardCDVViewModel.Factory factory) {
        consumerCardCDVFragment.viewModelFactory = factory;
    }

    public void injectMembers(ConsumerCardCDVFragment consumerCardCDVFragment) {
        dagger.android.g.i.a(consumerCardCDVFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerCardCDVFragment, this.viewModelFactoryProvider.get());
    }
}