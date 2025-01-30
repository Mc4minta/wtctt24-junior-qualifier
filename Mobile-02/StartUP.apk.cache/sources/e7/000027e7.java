package com.coinbase.wallet.user.apis;

import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserApi_Factory implements f.c.d<UserApi> {
    private final Provider<UserApiHttp> apiProvider;

    public UserApi_Factory(Provider<UserApiHttp> provider) {
        this.apiProvider = provider;
    }

    public static UserApi_Factory create(Provider<UserApiHttp> provider) {
        return new UserApi_Factory(provider);
    }

    public static UserApi newInstance(UserApiHttp userApiHttp) {
        return new UserApi(userApiHttp);
    }

    @Override // javax.inject.Provider
    public UserApi get() {
        return newInstance(this.apiProvider.get());
    }
}