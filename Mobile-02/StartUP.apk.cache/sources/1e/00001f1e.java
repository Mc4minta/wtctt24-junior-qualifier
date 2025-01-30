package com.coinbase.wallet.features.networking.jwt;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.user.apis.AccessTokenApi;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import h.c.b0;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AccessTokenProvider_Factory implements f.c.d<AccessTokenProvider> {
    private final Provider<AccessTokenApi> accessTokenApiProvider;
    private final Provider<b0<CreateAccessTokenResponseDTO>> signInHandlerProvider;
    private final Provider<StoreInterface> storeProvider;

    public AccessTokenProvider_Factory(Provider<b0<CreateAccessTokenResponseDTO>> provider, Provider<AccessTokenApi> provider2, Provider<StoreInterface> provider3) {
        this.signInHandlerProvider = provider;
        this.accessTokenApiProvider = provider2;
        this.storeProvider = provider3;
    }

    public static AccessTokenProvider_Factory create(Provider<b0<CreateAccessTokenResponseDTO>> provider, Provider<AccessTokenApi> provider2, Provider<StoreInterface> provider3) {
        return new AccessTokenProvider_Factory(provider, provider2, provider3);
    }

    public static AccessTokenProvider newInstance(b0<CreateAccessTokenResponseDTO> b0Var, AccessTokenApi accessTokenApi, StoreInterface storeInterface) {
        return new AccessTokenProvider(b0Var, accessTokenApi, storeInterface);
    }

    @Override // javax.inject.Provider
    public AccessTokenProvider get() {
        return newInstance(this.signInHandlerProvider.get(), this.accessTokenApiProvider.get(), this.storeProvider.get());
    }
}