package com.coinbase.wallet.consumer.repositories;

import com.coinbase.Coinbase;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerUserRepository_Factory implements f.c.d<ConsumerUserRepository> {
    private final Provider<Coinbase> coinbaseProvider;
    private final Provider<ConsumerAPI> consumerAPIProvider;
    private final Provider<ConsumerNetworkConfig> consumerNetworkConfigProvider;
    private final Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private final Provider<StoreInterface> storeProvider;
    private final Provider<Tracing> tracerProvider;

    public ConsumerUserRepository_Factory(Provider<StoreInterface> provider, Provider<ConsumerAPI> provider2, Provider<Coinbase> provider3, Provider<Tracing> provider4, Provider<FeatureFlagsRepository> provider5, Provider<ConsumerNetworkConfig> provider6) {
        this.storeProvider = provider;
        this.consumerAPIProvider = provider2;
        this.coinbaseProvider = provider3;
        this.tracerProvider = provider4;
        this.featureFlagsRepositoryProvider = provider5;
        this.consumerNetworkConfigProvider = provider6;
    }

    public static ConsumerUserRepository_Factory create(Provider<StoreInterface> provider, Provider<ConsumerAPI> provider2, Provider<Coinbase> provider3, Provider<Tracing> provider4, Provider<FeatureFlagsRepository> provider5, Provider<ConsumerNetworkConfig> provider6) {
        return new ConsumerUserRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ConsumerUserRepository newInstance(StoreInterface storeInterface, ConsumerAPI consumerAPI, f.a<Coinbase> aVar, Tracing tracing, FeatureFlagsRepository featureFlagsRepository, ConsumerNetworkConfig consumerNetworkConfig) {
        return new ConsumerUserRepository(storeInterface, consumerAPI, aVar, tracing, featureFlagsRepository, consumerNetworkConfig);
    }

    @Override // javax.inject.Provider
    public ConsumerUserRepository get() {
        return newInstance(this.storeProvider.get(), this.consumerAPIProvider.get(), f.c.c.a(this.coinbaseProvider), this.tracerProvider.get(), this.featureFlagsRepositoryProvider.get(), this.consumerNetworkConfigProvider.get());
    }
}