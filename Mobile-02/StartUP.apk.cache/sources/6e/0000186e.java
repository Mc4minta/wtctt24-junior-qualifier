package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSendTwoFactorViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerSendTwoFactorFragment_MembersInjector implements f.b<ConsumerSendTwoFactorFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<ConsumerSendTwoFactorViewModel>> viewModelFactoryProvider;

    public ConsumerSendTwoFactorFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerSendTwoFactorViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ConsumerSendTwoFactorFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerSendTwoFactorViewModel>> provider2) {
        return new ConsumerSendTwoFactorFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment, GenericViewModelFactory<ConsumerSendTwoFactorViewModel> genericViewModelFactory) {
        consumerSendTwoFactorFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment) {
        dagger.android.g.i.a(consumerSendTwoFactorFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerSendTwoFactorFragment, this.viewModelFactoryProvider.get());
    }
}