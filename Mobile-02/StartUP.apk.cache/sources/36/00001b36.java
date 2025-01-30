package com.coinbase.wallet.di;

import com.coinbase.wallet.features.networking.jwt.AccessTokenAuthenticator;
import com.coinbase.wallet.features.networking.jwt.AccessTokenInterceptor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.t;

/* loaded from: classes.dex */
public final class NetworkCoreModule_Companion_BaseWalletServiceRetrofitFactory implements f.c.d<t> {
    private final Provider<AccessTokenInterceptor> accessTokenInterceptorProvider;
    private final Provider<AccessTokenAuthenticator> authenticatorProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<t> retrofitProvider;

    public NetworkCoreModule_Companion_BaseWalletServiceRetrofitFactory(Provider<OkHttpClient> provider, Provider<AccessTokenAuthenticator> provider2, Provider<AccessTokenInterceptor> provider3, Provider<t> provider4) {
        this.okHttpClientProvider = provider;
        this.authenticatorProvider = provider2;
        this.accessTokenInterceptorProvider = provider3;
        this.retrofitProvider = provider4;
    }

    public static t baseWalletServiceRetrofit(OkHttpClient okHttpClient, AccessTokenAuthenticator accessTokenAuthenticator, AccessTokenInterceptor accessTokenInterceptor, t tVar) {
        return (t) f.c.h.f(NetworkCoreModule.Companion.baseWalletServiceRetrofit(okHttpClient, accessTokenAuthenticator, accessTokenInterceptor, tVar));
    }

    public static NetworkCoreModule_Companion_BaseWalletServiceRetrofitFactory create(Provider<OkHttpClient> provider, Provider<AccessTokenAuthenticator> provider2, Provider<AccessTokenInterceptor> provider3, Provider<t> provider4) {
        return new NetworkCoreModule_Companion_BaseWalletServiceRetrofitFactory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public t get() {
        return baseWalletServiceRetrofit(this.okHttpClientProvider.get(), this.authenticatorProvider.get(), this.accessTokenInterceptorProvider.get(), this.retrofitProvider.get());
    }
}