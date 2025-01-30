package com.coinbase.resources.auth;

/* loaded from: classes.dex */
public class AccessToken {
    private String accessToken;
    private Integer expiresIn;
    private String refreshToken;
    private String scope;
    private String tokenType;

    public String getAccessToken() {
        return this.accessToken;
    }

    public Integer getExpiresIn() {
        return this.expiresIn;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getScope() {
        return this.scope;
    }

    public String getTokenType() {
        return this.tokenType;
    }
}