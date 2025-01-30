package com.coinbase.wallet.user.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.authentication.AuthenticationHelperInterface;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.apis.AccessTokenApi;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AccessTokenRepository_Factory implements f.c.d<AccessTokenRepository> {
    private final Provider<AccessTokenApi> accessTokenApiProvider;
    private final Provider<AuthenticationHelperInterface> authenticationHelperProvider;
    private final Provider<CipherCoreInterface> cipherCoreProvider;
    private final Provider<StoreInterface> storeProvider;

    public AccessTokenRepository_Factory(Provider<AuthenticationHelperInterface> provider, Provider<AccessTokenApi> provider2, Provider<CipherCoreInterface> provider3, Provider<StoreInterface> provider4) {
        this.authenticationHelperProvider = provider;
        this.accessTokenApiProvider = provider2;
        this.cipherCoreProvider = provider3;
        this.storeProvider = provider4;
    }

    public static AccessTokenRepository_Factory create(Provider<AuthenticationHelperInterface> provider, Provider<AccessTokenApi> provider2, Provider<CipherCoreInterface> provider3, Provider<StoreInterface> provider4) {
        return new AccessTokenRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static AccessTokenRepository newInstance(AuthenticationHelperInterface authenticationHelperInterface, AccessTokenApi accessTokenApi, CipherCoreInterface cipherCoreInterface, StoreInterface storeInterface) {
        return new AccessTokenRepository(authenticationHelperInterface, accessTokenApi, cipherCoreInterface, storeInterface);
    }

    @Override // javax.inject.Provider
    public AccessTokenRepository get() {
        return newInstance(this.authenticationHelperProvider.get(), this.accessTokenApiProvider.get(), this.cipherCoreProvider.get(), this.storeProvider.get());
    }
}