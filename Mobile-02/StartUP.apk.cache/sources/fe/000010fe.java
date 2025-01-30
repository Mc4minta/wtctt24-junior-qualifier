package com.coinbase.resources.users;

import com.coinbase.ApiConstants;
import com.coinbase.CoinbaseResponse;
import com.coinbase.network.ApiCall;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.p;
import retrofit2.z.s;

/* loaded from: classes.dex */
public interface UsersApi {
    @f(ApiConstants.USER_AUTH_INFO)
    ApiCall<CoinbaseResponse<AuthInfo>> getAuthInfo();

    @f(ApiConstants.USER)
    ApiCall<CoinbaseResponse<AuthUser>> getCurrentUser();

    @f("users/{userId}")
    ApiCall<CoinbaseResponse<User>> getUser(@s("userId") String str);

    @p(ApiConstants.USER)
    ApiCall<CoinbaseResponse<AuthUser>> updateUser(@a UpdateUserRequest updateUserRequest);
}