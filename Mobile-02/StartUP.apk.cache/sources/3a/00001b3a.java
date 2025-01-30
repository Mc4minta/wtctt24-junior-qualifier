package com.coinbase.wallet.di;

import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.repositories.AccessTokenRepository;
import h.c.b0;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkCoreModule_Companion_ProvidesSignInHandlerFactory implements f.c.d<b0<CreateAccessTokenResponseDTO>> {
    private final Provider<AccessTokenRepository> accessTokenRepositoryProvider;

    public NetworkCoreModule_Companion_ProvidesSignInHandlerFactory(Provider<AccessTokenRepository> provider) {
        this.accessTokenRepositoryProvider = provider;
    }

    public static NetworkCoreModule_Companion_ProvidesSignInHandlerFactory create(Provider<AccessTokenRepository> provider) {
        return new NetworkCoreModule_Companion_ProvidesSignInHandlerFactory(provider);
    }

    public static b0<CreateAccessTokenResponseDTO> providesSignInHandler(AccessTokenRepository accessTokenRepository) {
        return (b0) f.c.h.f(NetworkCoreModule.Companion.providesSignInHandler(accessTokenRepository));
    }

    @Override // javax.inject.Provider
    public b0<CreateAccessTokenResponseDTO> get() {
        return providesSignInHandler(this.accessTokenRepositoryProvider.get());
    }
}