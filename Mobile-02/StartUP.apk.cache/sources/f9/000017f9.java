package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAddCardViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAddCardFragment_MembersInjector implements f.b<ConsumerAddCardFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ConsumerWebViewConfig> consumerWebViewConfigProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<GenericViewModelFactory<ConsumerAddCardViewModel>> viewModelFactoryProvider;

    public ConsumerAddCardFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerAddCardViewModel>> provider2, Provider<ConsumerWebViewConfig> provider3, Provider<StoreInterface> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.consumerWebViewConfigProvider = provider3;
        this.storeProvider = provider4;
    }

    public static f.b<ConsumerAddCardFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerAddCardViewModel>> provider2, Provider<ConsumerWebViewConfig> provider3, Provider<StoreInterface> provider4) {
        return new ConsumerAddCardFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectConsumerWebViewConfig(ConsumerAddCardFragment consumerAddCardFragment, ConsumerWebViewConfig consumerWebViewConfig) {
        consumerAddCardFragment.consumerWebViewConfig = consumerWebViewConfig;
    }

    public static void injectStore(ConsumerAddCardFragment consumerAddCardFragment, StoreInterface storeInterface) {
        consumerAddCardFragment.store = storeInterface;
    }

    public static void injectViewModelFactory(ConsumerAddCardFragment consumerAddCardFragment, GenericViewModelFactory<ConsumerAddCardViewModel> genericViewModelFactory) {
        consumerAddCardFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(ConsumerAddCardFragment consumerAddCardFragment) {
        dagger.android.g.i.a(consumerAddCardFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(consumerAddCardFragment, this.viewModelFactoryProvider.get());
        injectConsumerWebViewConfig(consumerAddCardFragment, this.consumerWebViewConfigProvider.get());
        injectStore(consumerAddCardFragment, this.storeProvider.get());
    }
}