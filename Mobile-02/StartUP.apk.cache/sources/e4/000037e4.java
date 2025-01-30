package com.google.api.client.auth.oauth2;

import com.coinbase.ApiConstants;
import e.g.b.a.c.b;
import e.g.b.a.d.q;
import e.g.b.a.d.y;

/* loaded from: classes2.dex */
public class TokenResponse extends b {
    @q("access_token")
    private String accessToken;
    @q("expires_in")
    private Long expiresInSeconds;
    @q(ApiConstants.REFRESH_TOKEN)
    private String refreshToken;
    @q
    private String scope;
    @q("token_type")
    private String tokenType;

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresInSeconds() {
        return this.expiresInSeconds;
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

    public TokenResponse setAccessToken(String str) {
        this.accessToken = (String) y.d(str);
        return this;
    }

    public TokenResponse setExpiresInSeconds(Long l2) {
        this.expiresInSeconds = l2;
        return this;
    }

    public TokenResponse setRefreshToken(String str) {
        this.refreshToken = str;
        return this;
    }

    public TokenResponse setScope(String str) {
        this.scope = str;
        return this;
    }

    public TokenResponse setTokenType(String str) {
        this.tokenType = (String) y.d(str);
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public TokenResponse set(String str, Object obj) {
        return (TokenResponse) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public TokenResponse clone() {
        return (TokenResponse) super.clone();
    }
}