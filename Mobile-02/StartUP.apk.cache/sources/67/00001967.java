package com.coinbase.wallet.di;

import com.coinbase.wallet.user.apis.UserApiHttp;
import javax.inject.Provider;
import retrofit2.t;

/* loaded from: classes.dex */
public final class ApiModule_UserApiInterfaceFactory implements f.c.d<UserApiHttp> {
    private final Provider<t> retrofitProvider;

    public ApiModule_UserApiInterfaceFactory(Provider<t> provider) {
        this.retrofitProvider = provider;
    }

    public static ApiModule_UserApiInterfaceFactory create(Provider<t> provider) {
        return new ApiModule_UserApiInterfaceFactory(provider);
    }

    public static UserApiHttp userApiInterface(t tVar) {
        return (UserApiHttp) f.c.h.f(ApiModule.userApiInterface(tVar));
    }

    @Override // javax.inject.Provider
    public UserApiHttp get() {
        return userApiInterface(this.retrofitProvider.get());
    }
}