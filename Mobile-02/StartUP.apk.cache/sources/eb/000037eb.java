package com.google.api.client.auth.openidconnect;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.a;
import e.g.b.a.d.q;
import e.g.b.a.d.y;
import java.io.IOException;

/* loaded from: classes2.dex */
public class IdTokenResponse extends TokenResponse {
    @q("id_token")
    private String idToken;

    public static IdTokenResponse execute(a aVar) throws IOException {
        return (IdTokenResponse) aVar.executeUnparsed().m(IdTokenResponse.class);
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public IdToken parseIdToken() throws IOException {
        return IdToken.h(getFactory(), this.idToken);
    }

    public IdTokenResponse setIdToken(String str) {
        this.idToken = (String) y.d(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public IdTokenResponse setAccessToken(String str) {
        super.setAccessToken(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public IdTokenResponse setExpiresInSeconds(Long l2) {
        super.setExpiresInSeconds(l2);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public IdTokenResponse setRefreshToken(String str) {
        super.setRefreshToken(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public IdTokenResponse setScope(String str) {
        super.setScope(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse
    public IdTokenResponse setTokenType(String str) {
        super.setTokenType(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse, e.g.b.a.c.b, e.g.b.a.d.n
    public IdTokenResponse set(String str, Object obj) {
        return (IdTokenResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.TokenResponse, e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public IdTokenResponse clone() {
        return (IdTokenResponse) super.clone();
    }
}