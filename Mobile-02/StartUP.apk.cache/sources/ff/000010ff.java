package com.coinbase.resources.users;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import h.c.b0;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.p;
import retrofit2.z.s;

/* loaded from: classes.dex */
public interface UsersApiRx {
    @f(ApiConstants.USER_AUTH_INFO)
    b0<CoinbaseResponse<AuthInfo>> getAuthInfo();

    @f(ApiConstants.USER)
    b0<CoinbaseResponse<AuthUser>> getCurrentUser();

    @f("users/{userId}")
    b0<CoinbaseResponse<User>> getUser(@s("userId") String str);

    @p(ApiConstants.USER)
    b0<CoinbaseResponse<AuthUser>> updateUser(@a UpdateUserRequest updateUserRequest);
}