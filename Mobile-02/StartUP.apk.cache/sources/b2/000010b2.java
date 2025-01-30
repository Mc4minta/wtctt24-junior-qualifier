package com.coinbase.resources.auth;

import com.coinbase.ApiConstants;
import h.c.b0;
import retrofit2.z.a;
import retrofit2.z.o;

/* loaded from: classes.dex */
public interface AuthApiRx {
    @o(ApiConstants.OAuth.TOKEN)
    b0<AccessToken> getTokens(@a GetTokensRequest getTokensRequest);

    @o(ApiConstants.OAuth.TOKEN)
    b0<AccessToken> refreshTokens(@a RefreshTokenRequest refreshTokenRequest);

    @o(ApiConstants.OAuth.REVOKE)
    b0<RevokeTokenResponse> revokeToken(@a RevokeTokenRequest revokeTokenRequest);
}