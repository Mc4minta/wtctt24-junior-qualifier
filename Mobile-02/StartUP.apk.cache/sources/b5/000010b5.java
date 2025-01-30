package com.coinbase.resources.auth;

import com.coinbase.ApiConstants;

/* loaded from: classes.dex */
public class RefreshTokenRequest {
    public final String clientId;
    public final String clientSecret;
    public final String grantType = ApiConstants.REFRESH_TOKEN;
    public final String refreshToken;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RefreshTokenRequest(String str, String str2, String str3) {
        this.clientId = str;
        this.clientSecret = str2;
        this.refreshToken = str3;
    }
}