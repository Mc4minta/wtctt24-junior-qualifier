package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import e.g.b.a.d.q;
import e.g.b.a.d.y;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GoogleTokenResponse extends TokenResponse {
    @q("id_token")
    private String idToken;

    public final String getIdToken() {
        return this.idToken;
    }

    public GoogleIdToken parseIdToken() throws IOException {
        return GoogleIdToken.j(getFactory(), getIdToken());
    }

    public GoogleTokenResponse setIdToken(String str) {
        this.idToken = (String) y.d(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public GoogleTokenResponse setAccessToken(String str) {
        return (GoogleTokenResponse) super.setAccessToken(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public GoogleTokenResponse setExpiresInSeconds(Long l2) {
        return (GoogleTokenResponse) super.setExpiresInSeconds(l2);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public GoogleTokenResponse setRefreshToken(String str) {
        return (GoogleTokenResponse) super.setRefreshToken(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public GoogleTokenResponse setScope(String str) {
        return (GoogleTokenResponse) super.setScope(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public GoogleTokenResponse setTokenType(String str) {
        return (GoogleTokenResponse) super.setTokenType(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse, e.g.b.a.c.b, e.g.b.a.d.n
    public GoogleTokenResponse set(String str, Object obj) {
        return (GoogleTokenResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse, e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public GoogleTokenResponse clone() {
        return (GoogleTokenResponse) super.clone();
    }
}