package com.coinbase.resources.auth;

import com.coinbase.ApiConstants;
import com.coinbase.network.ApiCall;
import retrofit2.z.a;
import retrofit2.z.o;

/* loaded from: classes.dex */
public interface AuthApi {
    @o(ApiConstants.OAuth.TOKEN)
    ApiCall<AccessToken> getTokens(@a GetTokensRequest getTokensRequest);

    @o(ApiConstants.OAuth.TOKEN)
    ApiCall<AccessToken> refreshTokens(@a RefreshTokenRequest refreshTokenRequest);

    @o(ApiConstants.OAuth.REVOKE)
    ApiCall<RevokeTokenResponse> revokeToken(@a RevokeTokenRequest revokeTokenRequest);
}