package com.coinbase.wallet.di;

import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.store.Store;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppCoreModule_Companion_ProvidesFeatureFlagRepositoryFactory implements f.c.d<FeatureFlagsRepository> {
    private final Provider<Store> storeProvider;
    private final Provider<String> walletApiUrlProvider;

    public AppCoreModule_Companion_ProvidesFeatureFlagRepositoryFactory(Provider<Store> provider, Provider<String> provider2) {
        this.storeProvider = provider;
        this.walletApiUrlProvider = provider2;
    }

    public static AppCoreModule_Companion_ProvidesFeatureFlagRepositoryFactory create(Provider<Store> provider, Provider<String> provider2) {
        return new AppCoreModule_Companion_ProvidesFeatureFlagRepositoryFactory(provider, provider2);
    }

    public static FeatureFlagsRepository providesFeatureFlagRepository(Store store, String str) {
        return (FeatureFlagsRepository) f.c.h.f(AppCoreModule.Companion.providesFeatureFlagRepository(store, str));
    }

    @Override // javax.inject.Provider
    public FeatureFlagsRepository get() {
        return providesFeatureFlagRepository(this.storeProvider.get(), this.walletApiUrlProvider.get());
    }
}