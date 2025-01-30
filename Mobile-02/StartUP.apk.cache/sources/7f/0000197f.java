package com.coinbase.wallet.di;

import android.content.pm.PackageManager;
import com.coinbase.wallet.application.BaseApplication;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppModule_Companion_ProvidesPackageManagerFactory implements f.c.d<PackageManager> {
    private final Provider<BaseApplication> appProvider;

    public AppModule_Companion_ProvidesPackageManagerFactory(Provider<BaseApplication> provider) {
        this.appProvider = provider;
    }

    public static AppModule_Companion_ProvidesPackageManagerFactory create(Provider<BaseApplication> provider) {
        return new AppModule_Companion_ProvidesPackageManagerFactory(provider);
    }

    public static PackageManager providesPackageManager(BaseApplication baseApplication) {
        return (PackageManager) f.c.h.f(AppModule.Companion.providesPackageManager(baseApplication));
    }

    @Override // javax.inject.Provider
    public PackageManager get() {
        return providesPackageManager(this.appProvider.get());
    }
}