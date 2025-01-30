package com.coinbase.wallet.di;

import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApiInterface;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiModule_ProvidesPushNotificationApiInterfaceFactory implements f.c.d<PushNotificationApiInterface> {
    private final Provider<t> retrofitProvider;

    public ApiModule_ProvidesPushNotificationApiInterfaceFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static ApiModule_ProvidesPushNotificationApiInterfaceFactory create(Provider<t> provider) {
        return new ApiModule_ProvidesPushNotificationApiInterfaceFactory(provider);
    }

    public static PushNotificationApiInterface providesPushNotificationApiInterface(t tVar) {
        return (PushNotificationApiInterface) f.c.h.f(ApiModule.providesPushNotificationApiInterface(tVar));
    }

    @Override // javax.inject.Provider
    public PushNotificationApiInterface get() {
        return providesPushNotificationApiInterface(this.retrofitProvider.get());
    }
}