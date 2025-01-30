package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSecure3DVerificationViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationFragment_MembersInjector implements f.b<ConsumerSecure3DVerificationFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ConsumerSecure3DVerificationViewModel.Factory> viewModelFactoryProvider;
    private final Provider<ConsumerWebViewConfig> webviewConfigProvider;

    public ConsumerSecure3DVerificationFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerWebViewConfig> provider2, Provider<ConsumerSecure3DVerificationViewModel.Factory> provider3) {
        this.androidInjectorProvider = provider;
        this.webviewConfigProvider = provider2;
        this.viewModelFactoryProvider = provider3;
    }

    public static f.b<ConsumerSecure3DVerificationFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ConsumerWebViewConfig> provider2, Provider<ConsumerSecure3DVerificationViewModel.Factory> provider3) {
        return new ConsumerSecure3DVerificationFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectViewModelFactory(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment, ConsumerSecure3DVerificationViewModel.Factory factory) {
        consumerSecure3DVerificationFragment.viewModelFactory = factory;
    }

    public static void injectWebviewConfig(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment, ConsumerWebViewConfig consumerWebViewConfig) {
        consumerSecure3DVerificationFragment.webviewConfig = consumerWebViewConfig;
    }

    public void injectMembers(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment) {
        dagger.android.g.i.a(consumerSecure3DVerificationFragment, this.androidInjectorProvider.get());
        injectWebviewConfig(consumerSecure3DVerificationFragment, this.webviewConfigProvider.get());
        injectViewModelFactory(consumerSecure3DVerificationFragment, this.viewModelFactoryProvider.get());
    }
}