package com.coinbase.wallet.consumer.repositories;

import android.content.pm.PackageManager;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppToAppAuthRepository_Factory implements f.c.d<AppToAppAuthRepository> {
    private final Provider<BuildConfigWrapper> buildConfigWrapperProvider;
    private final Provider<PackageManager> pmProvider;

    public AppToAppAuthRepository_Factory(Provider<PackageManager> provider, Provider<BuildConfigWrapper> provider2) {
        this.pmProvider = provider;
        this.buildConfigWrapperProvider = provider2;
    }

    public static AppToAppAuthRepository_Factory create(Provider<PackageManager> provider, Provider<BuildConfigWrapper> provider2) {
        return new AppToAppAuthRepository_Factory(provider, provider2);
    }

    public static AppToAppAuthRepository newInstance(PackageManager packageManager, BuildConfigWrapper buildConfigWrapper) {
        return new AppToAppAuthRepository(packageManager, buildConfigWrapper);
    }

    @Override // javax.inject.Provider
    public AppToAppAuthRepository get() {
        return newInstance(this.pmProvider.get(), this.buildConfigWrapperProvider.get());
    }
}