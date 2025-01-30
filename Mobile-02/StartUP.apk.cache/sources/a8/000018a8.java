package com.coinbase.wallet.consumer.views;

import com.coinbase.Coinbase;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class UMOActivity_MembersInjector implements f.b<UMOActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<BuildConfigWrapper> buildConfigProvider;
    private final Provider<Coinbase> coinbaseProvider;
    private final Provider<ConsumerAccountsRepository> consumerAccountsRepositoryProvider;
    private final Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<ConsumerNetworkConfig> networkConfigProvider;
    private final Provider<StoreInterface> storeProvider;

    public UMOActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<StoreInterface> provider2, Provider<ConsumerUserRepository> provider3, Provider<ConsumerAccountsRepository> provider4, Provider<ConsumerTransferRepository> provider5, Provider<BuildConfigWrapper> provider6, Provider<ConsumerNetworkConfig> provider7, Provider<Coinbase> provider8) {
        this.androidInjectorProvider = provider;
        this.storeProvider = provider2;
        this.consumerUserRepositoryProvider = provider3;
        this.consumerAccountsRepositoryProvider = provider4;
        this.consumerTransferRepositoryProvider = provider5;
        this.buildConfigProvider = provider6;
        this.networkConfigProvider = provider7;
        this.coinbaseProvider = provider8;
    }

    public static f.b<UMOActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<StoreInterface> provider2, Provider<ConsumerUserRepository> provider3, Provider<ConsumerAccountsRepository> provider4, Provider<ConsumerTransferRepository> provider5, Provider<BuildConfigWrapper> provider6, Provider<ConsumerNetworkConfig> provider7, Provider<Coinbase> provider8) {
        return new UMOActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static void injectBuildConfig(UMOActivity uMOActivity, BuildConfigWrapper buildConfigWrapper) {
        uMOActivity.buildConfig = buildConfigWrapper;
    }

    public static void injectCoinbase(UMOActivity uMOActivity, f.a<Coinbase> aVar) {
        uMOActivity.coinbase = aVar;
    }

    public static void injectConsumerAccountsRepository(UMOActivity uMOActivity, ConsumerAccountsRepository consumerAccountsRepository) {
        uMOActivity.consumerAccountsRepository = consumerAccountsRepository;
    }

    public static void injectConsumerTransferRepository(UMOActivity uMOActivity, ConsumerTransferRepository consumerTransferRepository) {
        uMOActivity.consumerTransferRepository = consumerTransferRepository;
    }

    public static void injectConsumerUserRepository(UMOActivity uMOActivity, ConsumerUserRepository consumerUserRepository) {
        uMOActivity.consumerUserRepository = consumerUserRepository;
    }

    public static void injectNetworkConfig(UMOActivity uMOActivity, ConsumerNetworkConfig consumerNetworkConfig) {
        uMOActivity.networkConfig = consumerNetworkConfig;
    }

    public static void injectStore(UMOActivity uMOActivity, StoreInterface storeInterface) {
        uMOActivity.store = storeInterface;
    }

    public void injectMembers(UMOActivity uMOActivity) {
        dagger.android.g.c.a(uMOActivity, this.androidInjectorProvider.get());
        injectStore(uMOActivity, this.storeProvider.get());
        injectConsumerUserRepository(uMOActivity, this.consumerUserRepositoryProvider.get());
        injectConsumerAccountsRepository(uMOActivity, this.consumerAccountsRepositoryProvider.get());
        injectConsumerTransferRepository(uMOActivity, this.consumerTransferRepositoryProvider.get());
        injectBuildConfig(uMOActivity, this.buildConfigProvider.get());
        injectNetworkConfig(uMOActivity, this.networkConfigProvider.get());
        injectCoinbase(uMOActivity, f.c.c.a(this.coinbaseProvider));
    }
}