package com.google.api.client.auth.oauth2;

import e.g.b.a.c.b;
import e.g.b.a.d.q;
import e.g.b.a.d.y;

/* loaded from: classes2.dex */
public class TokenErrorResponse extends b {
    @q
    private String error;
    @q("error_description")
    private String errorDescription;
    @q("error_uri")
    private String errorUri;

    public final String getError() {
        return this.error;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getErrorUri() {
        return this.errorUri;
    }

    public TokenErrorResponse setError(String str) {
        this.error = (String) y.d(str);
        return this;
    }

    public TokenErrorResponse setErrorDescription(String str) {
        this.errorDescription = str;
        return this;
    }

    public TokenErrorResponse setErrorUri(String str) {
        this.errorUri = str;
        return this;
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public TokenErrorResponse set(String str, Object obj) {
        return (TokenErrorResponse) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public TokenErrorResponse clone() {
        return (TokenErrorResponse) super.clone();
    }
}