package com.google.api.client.googleapis.auth.oauth2;

import com.coinbase.ApiConstants;
import e.g.b.a.c.b;
import e.g.b.a.c.c;
import e.g.b.a.d.q;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/* loaded from: classes2.dex */
public final class GoogleClientSecrets extends b {
    @q
    private Details installed;
    @q
    private Details web;

    public static GoogleClientSecrets load(c cVar, Reader reader) throws IOException {
        return (GoogleClientSecrets) cVar.g(reader, GoogleClientSecrets.class);
    }

    public Details getDetails() {
        y.a((this.web == null) != (this.installed == null));
        Details details = this.web;
        return details == null ? this.installed : details;
    }

    public Details getInstalled() {
        return this.installed;
    }

    public Details getWeb() {
        return this.web;
    }

    public GoogleClientSecrets setInstalled(Details details) {
        this.installed = details;
        return this;
    }

    public GoogleClientSecrets setWeb(Details details) {
        this.web = details;
        return this;
    }

    /* loaded from: classes2.dex */
    public static final class Details extends b {
        @q("auth_uri")
        private String authUri;
        @q(ApiConstants.CLIENT_ID)
        private String clientId;
        @q(ApiConstants.CLIENT_SECRET)
        private String clientSecret;
        @q("redirect_uris")
        private List<String> redirectUris;
        @q("token_uri")
        private String tokenUri;

        public String getAuthUri() {
            return this.authUri;
        }

        public String getClientId() {
            return this.clientId;
        }

        public String getClientSecret() {
            return this.clientSecret;
        }

        public List<String> getRedirectUris() {
            return this.redirectUris;
        }

        public String getTokenUri() {
            return this.tokenUri;
        }

        public Details setAuthUri(String str) {
            this.authUri = str;
            return this;
        }

        public Details setClientId(String str) {
            this.clientId = str;
            return this;
        }

        public Details setClientSecret(String str) {
            this.clientSecret = str;
            return this;
        }

        public Details setRedirectUris(List<String> list) {
            this.redirectUris = list;
            return this;
        }

        public Details setTokenUri(String str) {
            this.tokenUri = str;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public Details set(String str, Object obj) {
            return (Details) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Details clone() {
            return (Details) super.clone();
        }
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n
    public GoogleClientSecrets set(String str, Object obj) {
        return (GoogleClientSecrets) super.set(str, obj);
    }

    @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
    public GoogleClientSecrets clone() {
        return (GoogleClientSecrets) super.clone();
    }
}