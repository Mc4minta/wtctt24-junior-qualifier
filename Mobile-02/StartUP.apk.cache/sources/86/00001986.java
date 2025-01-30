package com.coinbase.wallet.di;

import android.app.Application;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AppModule_ProvidesBranchClientFactory implements f.c.d<io.branch.referral.b> {
    private final Provider<Application> appProvider;

    public AppModule_ProvidesBranchClientFactory(Provider<Application> provider) {
        this.appProvider = provider;
    }

    public static AppModule_ProvidesBranchClientFactory create(Provider<Application> provider) {
        return new AppModule_ProvidesBranchClientFactory(provider);
    }

    public static io.branch.referral.b providesBranchClient(Application application) {
        return (io.branch.referral.b) f.c.h.f(AppModule.providesBranchClient(application));
    }

    @Override // javax.inject.Provider
    public io.branch.referral.b get() {
        return providesBranchClient(this.appProvider.get());
    }
}