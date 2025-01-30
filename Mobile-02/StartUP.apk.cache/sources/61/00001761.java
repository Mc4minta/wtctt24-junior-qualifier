package com.coinbase.wallet.consumer.viewmodels;

import android.content.pm.PackageManager;
import com.coinbase.wallet.consumer.repositories.AppToAppAuthRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConsumerAppToAppViewModel_Factory implements f.c.d<ConsumerAppToAppViewModel> {
    private final Provider<AppToAppAuthRepository> appToAppAuthRepositoryProvider;
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final Provider<PackageManager> packageManagerProvider;

    public ConsumerAppToAppViewModel_Factory(Provider<ConsumerUserRepository> provider, Provider<AppToAppAuthRepository> provider2, Provider<PackageManager> provider3) {
        this.consumerUserRepositoryProvider = provider;
        this.appToAppAuthRepositoryProvider = provider2;
        this.packageManagerProvider = provider3;
    }

    public static ConsumerAppToAppViewModel_Factory create(Provider<ConsumerUserRepository> provider, Provider<AppToAppAuthRepository> provider2, Provider<PackageManager> provider3) {
        return new ConsumerAppToAppViewModel_Factory(provider, provider2, provider3);
    }

    public static ConsumerAppToAppViewModel newInstance(ConsumerUserRepository consumerUserRepository, AppToAppAuthRepository appToAppAuthRepository, PackageManager packageManager) {
        return new ConsumerAppToAppViewModel(consumerUserRepository, appToAppAuthRepository, packageManager);
    }

    @Override // javax.inject.Provider
    public ConsumerAppToAppViewModel get() {
        return newInstance(this.consumerUserRepositoryProvider.get(), this.appToAppAuthRepositoryProvider.get(), this.packageManagerProvider.get());
    }
}