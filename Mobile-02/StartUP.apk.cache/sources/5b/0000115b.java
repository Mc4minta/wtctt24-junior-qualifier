package com.coinbase.wallet.application;

import com.coinbase.wallet.application.service.ApplicationService;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class BaseApplication_MembersInjector implements f.b<BaseApplication> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ApplicationService> applicationServiceProvider;

    public BaseApplication_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ApplicationService> provider2) {
        this.androidInjectorProvider = provider;
        this.applicationServiceProvider = provider2;
    }

    public static f.b<BaseApplication> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ApplicationService> provider2) {
        return new BaseApplication_MembersInjector(provider, provider2);
    }

    public static void injectApplicationService(BaseApplication baseApplication, ApplicationService applicationService) {
        baseApplication.applicationService = applicationService;
    }

    public void injectMembers(BaseApplication baseApplication) {
        dagger.android.d.a(baseApplication, this.androidInjectorProvider.get());
        injectApplicationService(baseApplication, this.applicationServiceProvider.get());
    }
}