package com.coinbase.wallet.features.networking.jwt;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AccessTokenAuthenticator_Factory implements f.c.d<AccessTokenAuthenticator> {
    private final Provider<AccessTokenProviderInterface> tokenProvider;

    public AccessTokenAuthenticator_Factory(Provider<AccessTokenProviderInterface> provider) {
        this.tokenProvider = provider;
    }

    public static AccessTokenAuthenticator_Factory create(Provider<AccessTokenProviderInterface> provider) {
        return new AccessTokenAuthenticator_Factory(provider);
    }

    public static AccessTokenAuthenticator newInstance(AccessTokenProviderInterface accessTokenProviderInterface) {
        return new AccessTokenAuthenticator(accessTokenProviderInterface);
    }

    @Override // javax.inject.Provider
    public AccessTokenAuthenticator get() {
        return newInstance(this.tokenProvider.get());
    }
}