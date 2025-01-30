package com.coinbase.wallet.user.apis;

import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AccessTokenApi_Factory implements f.c.d<AccessTokenApi> {
    private final Provider<AccessTokenApiInterface> apiProvider;

    public AccessTokenApi_Factory(Provider<AccessTokenApiInterface> provider) {
        this.apiProvider = provider;
    }

    public static AccessTokenApi_Factory create(Provider<AccessTokenApiInterface> provider) {
        return new AccessTokenApi_Factory(provider);
    }

    public static AccessTokenApi newInstance(AccessTokenApiInterface accessTokenApiInterface) {
        return new AccessTokenApi(accessTokenApiInterface);
    }

    @Override // javax.inject.Provider
    public AccessTokenApi get() {
        return newInstance(this.apiProvider.get());
    }
}