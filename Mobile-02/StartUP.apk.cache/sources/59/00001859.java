package com.coinbase.wallet.consumer.views;

import com.coinbase.Coinbase;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAppToAppViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerOnboardingFragment_MembersInjector implements f.b<ConsumerOnboardingFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<ConsumerAppToAppViewModel>> appToAppViewModelFactoryProvider;
    private final Provider<Coinbase> coinbaseApiProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<ConsumerWebViewConfig> consumerWebviewConfigProvider;
    private final Provider<ConsumerOnboardingViewModel.Factory> onboardingViewModelFactoryProvider;

    public ConsumerOnboardingFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerAppToAppViewModel>> provider2, Provider<ConsumerOnboardingViewModel.Factory> provider3, Provider<Coinbase> provider4, Provider<ConsumerUserRepository> provider5, Provider<ConsumerWebViewConfig> provider6) {
        this.androidInjectorProvider = provider;
        this.appToAppViewModelFactoryProvider = provider2;
        this.onboardingViewModelFactoryProvider = provider3;
        this.coinbaseApiProvider = provider4;
        this.consumerUserRepositoryProvider = provider5;
        this.consumerWebviewConfigProvider = provider6;
    }

    public static f.b<ConsumerOnboardingFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ConsumerAppToAppViewModel>> provider2, Provider<ConsumerOnboardingViewModel.Factory> provider3, Provider<Coinbase> provider4, Provider<ConsumerUserRepository> provider5, Provider<ConsumerWebViewConfig> provider6) {
        return new ConsumerOnboardingFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectAppToAppViewModelFactory(ConsumerOnboardingFragment consumerOnboardingFragment, GenericViewModelFactory<ConsumerAppToAppViewModel> genericViewModelFactory) {
        consumerOnboardingFragment.appToAppViewModelFactory = genericViewModelFactory;
    }

    public static void injectCoinbaseApi(ConsumerOnboardingFragment consumerOnboardingFragment, Coinbase coinbase) {
        consumerOnboardingFragment.coinbaseApi = coinbase;
    }

    public static void injectConsumerUserRepository(ConsumerOnboardingFragment consumerOnboardingFragment, ConsumerUserRepository consumerUserRepository) {
        consumerOnboardingFragment.consumerUserRepository = consumerUserRepository;
    }

    public static void injectConsumerWebviewConfig(ConsumerOnboardingFragment consumerOnboardingFragment, ConsumerWebViewConfig consumerWebViewConfig) {
        consumerOnboardingFragment.consumerWebviewConfig = consumerWebViewConfig;
    }

    public static void injectOnboardingViewModelFactory(ConsumerOnboardingFragment consumerOnboardingFragment, ConsumerOnboardingViewModel.Factory factory) {
        consumerOnboardingFragment.onboardingViewModelFactory = factory;
    }

    public void injectMembers(ConsumerOnboardingFragment consumerOnboardingFragment) {
        dagger.android.g.i.a(consumerOnboardingFragment, this.androidInjectorProvider.get());
        injectAppToAppViewModelFactory(consumerOnboardingFragment, this.appToAppViewModelFactoryProvider.get());
        injectOnboardingViewModelFactory(consumerOnboardingFragment, this.onboardingViewModelFactoryProvider.get());
        injectCoinbaseApi(consumerOnboardingFragment, this.coinbaseApiProvider.get());
        injectConsumerUserRepository(consumerOnboardingFragment, this.consumerUserRepositoryProvider.get());
        injectConsumerWebviewConfig(consumerOnboardingFragment, this.consumerWebviewConfigProvider.get());
    }
}