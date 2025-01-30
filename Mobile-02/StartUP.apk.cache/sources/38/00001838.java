package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerFragment_MembersInjector implements f.b<ConsumerFragment> {
    private final Provider<ConsumerAccountsViewModel.Factory> accountsViewModelFactoryProvider;
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public ConsumerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerAccountsViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.accountsViewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerAccountsViewModel.Factory> provider2) {
        return new ConsumerFragment_MembersInjector(provider, provider2);
    }

    public static void injectAccountsViewModelFactory(ConsumerFragment consumerFragment, ConsumerAccountsViewModel.Factory factory) {
        consumerFragment.accountsViewModelFactory = factory;
    }

    public void injectMembers(ConsumerFragment consumerFragment) {
        dagger.android.g.i.a(consumerFragment, this.androidInjectorProvider.get());
        injectAccountsViewModelFactory(consumerFragment, this.accountsViewModelFactoryProvider.get());
    }
}