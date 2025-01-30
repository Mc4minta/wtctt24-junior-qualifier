package com.coinbase.resources.auth;

import com.coinbase.ApiConstants;
import com.coinbase.network.ApiCall;
import h.c.b0;

/* loaded from: classes.dex */
public class AuthResource {
    private final AuthApi authApi;
    private final AuthApiRx authApiRx;

    public AuthResource(AuthApi authApi, AuthApiRx authApiRx) {
        this.authApi = authApi;
        this.authApiRx = authApiRx;
    }

    public ApiCall<AccessToken> getTokens(String str, String str2, String str3, String str4) {
        AuthApi authApi = this.authApi;
        if (str4 == null) {
            str4 = ApiConstants.TWO_LEGGED;
        }
        return authApi.getTokens(new GetTokensRequest(str, str2, str3, str4));
    }

    public b0<AccessToken> getTokensRx(String str, String str2, String str3, String str4) {
        AuthApiRx authApiRx = this.authApiRx;
        if (str4 == null) {
            str4 = ApiConstants.TWO_LEGGED;
        }
        return authApiRx.getTokens(new GetTokensRequest(str, str2, str3, str4));
    }

    public ApiCall<AccessToken> refreshTokens(String str, String str2, String str3) {
        return this.authApi.refreshTokens(new RefreshTokenRequest(str, str2, str3));
    }

    public b0<AccessToken> refreshTokensRx(String str, String str2, String str3) {
        return this.authApiRx.refreshTokens(new RefreshTokenRequest(str, str2, str3));
    }

    public ApiCall<RevokeTokenResponse> revokeToken(String str) {
        if (str != null) {
            return this.authApi.revokeToken(new RevokeTokenRequest(str));
        }
        throw new IllegalStateException("Client is not logged in!");
    }

    public b0<RevokeTokenResponse> revokeTokenRx(String str) {
        if (str != null) {
            return this.authApiRx.revokeToken(new RevokeTokenRequest(str));
        }
        throw new IllegalStateException("Client is not logged in!");
    }
}