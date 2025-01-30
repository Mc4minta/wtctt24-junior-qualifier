package com.coinbase.wallet.application.viewmodel;

import com.coinbase.wallet.application.service.ApplicationService;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SignOutViewModel_Factory implements d<SignOutViewModel> {
    private final Provider<ApplicationService> applicationServiceProvider;

    public SignOutViewModel_Factory(Provider<ApplicationService> provider) {
        this.applicationServiceProvider = provider;
    }

    public static SignOutViewModel_Factory create(Provider<ApplicationService> provider) {
        return new SignOutViewModel_Factory(provider);
    }

    public static SignOutViewModel newInstance(ApplicationService applicationService) {
        return new SignOutViewModel(applicationService);
    }

    @Override // javax.inject.Provider
    public SignOutViewModel get() {
        return newInstance(this.applicationServiceProvider.get());
    }
}