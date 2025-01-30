package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerInterstitialViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerInterstitialFragment_MembersInjector implements f.b<ConsumerInterstitialFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ConsumerInterstitialViewModel.Factory> consumerInterstitialViewModelFactoryProvider;

    public ConsumerInterstitialFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerInterstitialViewModel.Factory> provider2) {
        this.androidInjectorProvider = provider;
        this.consumerInterstitialViewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerInterstitialFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerInterstitialViewModel.Factory> provider2) {
        return new ConsumerInterstitialFragment_MembersInjector(provider, provider2);
    }

    public static void injectConsumerInterstitialViewModelFactory(ConsumerInterstitialFragment consumerInterstitialFragment, ConsumerInterstitialViewModel.Factory factory) {
        consumerInterstitialFragment.consumerInterstitialViewModelFactory = factory;
    }

    public void injectMembers(ConsumerInterstitialFragment consumerInterstitialFragment) {
        dagger.android.g.i.a(consumerInterstitialFragment, this.androidInjectorProvider.get());
        injectConsumerInterstitialViewModelFactory(consumerInterstitialFragment, this.consumerInterstitialViewModelFactoryProvider.get());
    }
}