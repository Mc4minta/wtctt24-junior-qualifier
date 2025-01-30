package com.coinbase.wallet.consumer.di;

import android.app.Application;
import com.coinbase.Coinbase;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import f.c.d;
import f.c.h;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerModule_Companion_ProvidesCoinbaseFactory implements d<Coinbase> {
    private final Provider<Application> appProvider;
    private final Provider<BuildConfigWrapper> buildConfigWrapperProvider;
    private final Provider<ConsumerNetworkConfig> networkConfigProvider;
    private final Provider<StoreInterface> storeProvider;

    public ConsumerModule_Companion_ProvidesCoinbaseFactory(Provider<Application> provider, Provider<StoreInterface> provider2, Provider<ConsumerNetworkConfig> provider3, Provider<BuildConfigWrapper> provider4) {
        this.appProvider = provider;
        this.storeProvider = provider2;
        this.networkConfigProvider = provider3;
        this.buildConfigWrapperProvider = provider4;
    }

    public static ConsumerModule_Companion_ProvidesCoinbaseFactory create(Provider<Application> provider, Provider<StoreInterface> provider2, Provider<ConsumerNetworkConfig> provider3, Provider<BuildConfigWrapper> provider4) {
        return new ConsumerModule_Companion_ProvidesCoinbaseFactory(provider, provider2, provider3, provider4);
    }

    public static Coinbase providesCoinbase(Application application, StoreInterface storeInterface, ConsumerNetworkConfig consumerNetworkConfig, BuildConfigWrapper buildConfigWrapper) {
        return (Coinbase) h.f(ConsumerModule.Companion.providesCoinbase(application, storeInterface, consumerNetworkConfig, buildConfigWrapper));
    }

    @Override // javax.inject.Provider
    public Coinbase get() {
        return providesCoinbase(this.appProvider.get(), this.storeProvider.get(), this.networkConfigProvider.get(), this.buildConfigWrapperProvider.get());
    }
}