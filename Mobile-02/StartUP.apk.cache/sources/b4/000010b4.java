package com.coinbase.resources.auth;

import com.coinbase.ApiConstants;

/* loaded from: classes.dex */
class GetTokensRequest {
    public final String clientId;
    public final String clientSecret;
    public final String code;
    public final String grantType = ApiConstants.AUTHORIZATION_CODE;
    public final String redirectUri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokensRequest(String str, String str2, String str3, String str4) {
        this.clientId = str;
        this.clientSecret = str2;
        this.code = str3;
        this.redirectUri = str4;
    }
}