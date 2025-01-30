package com.coinbase.wallet.features.networking.jwt;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AccessTokenInterceptor_Factory implements f.c.d<AccessTokenInterceptor> {
    private final Provider<AccessTokenProviderInterface> tokenProvider;

    public AccessTokenInterceptor_Factory(Provider<AccessTokenProviderInterface> provider) {
        this.tokenProvider = provider;
    }

    public static AccessTokenInterceptor_Factory create(Provider<AccessTokenProviderInterface> provider) {
        return new AccessTokenInterceptor_Factory(provider);
    }

    public static AccessTokenInterceptor newInstance(AccessTokenProviderInterface accessTokenProviderInterface) {
        return new AccessTokenInterceptor(accessTokenProviderInterface);
    }

    @Override // javax.inject.Provider
    public AccessTokenInterceptor get() {
        return newInstance(this.tokenProvider.get());
    }
}