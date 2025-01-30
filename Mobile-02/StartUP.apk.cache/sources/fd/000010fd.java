package com.coinbase.resources.users;

import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import h.c.b0;

/* loaded from: classes.dex */
public class UserResource {
    private UsersApi usersApi;
    private UsersApiRx usersApiRx;

    public UserResource(UsersApi usersApi, UsersApiRx usersApiRx) {
        this.usersApi = usersApi;
        this.usersApiRx = usersApiRx;
    }

    public ApiCall<CoinbaseResponse<AuthInfo>> getAuthInfo() {
        return this.usersApi.getAuthInfo();
    }

    public b0<CoinbaseResponse<AuthInfo>> getAuthInfoRx() {
        return this.usersApiRx.getAuthInfo();
    }

    public ApiCall<CoinbaseResponse<AuthUser>> getCurrentUser() {
        return this.usersApi.getCurrentUser();
    }

    public b0<CoinbaseResponse<AuthUser>> getCurrentUserRx() {
        return this.usersApiRx.getCurrentUser();
    }

    public ApiCall<CoinbaseResponse<User>> getUser(String str) {
        return this.usersApi.getUser(str);
    }

    public b0<CoinbaseResponse<User>> getUserRx(String str) {
        return this.usersApiRx.getUser(str);
    }

    public ApiCall<CoinbaseResponse<AuthUser>> updateUser(UpdateUserRequest updateUserRequest) {
        return this.usersApi.updateUser(updateUserRequest);
    }

    public b0<CoinbaseResponse<AuthUser>> updateUserRx(UpdateUserRequest updateUserRequest) {
        return this.usersApiRx.updateUser(updateUserRequest);
    }
}