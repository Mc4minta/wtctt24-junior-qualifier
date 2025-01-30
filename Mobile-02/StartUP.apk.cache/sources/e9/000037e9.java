package com.google.api.client.auth.openidconnect;

import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import e.g.b.a.c.c;
import e.g.b.a.d.q;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public class IdToken extends JsonWebSignature {

    /* loaded from: classes2.dex */
    public static class Payload extends JsonWebToken.Payload {
        @q("at_hash")
        private String accessTokenHash;
        @q("auth_time")
        private Long authorizationTimeSeconds;
        @q("azp")
        private String authorizedParty;
        @q("acr")
        private String classReference;
        @q("amr")
        private List<String> methodsReferences;
        @q
        private String nonce;

        public final String getAccessTokenHash() {
            return this.accessTokenHash;
        }

        public final Long getAuthorizationTimeSeconds() {
            return this.authorizationTimeSeconds;
        }

        public final String getAuthorizedParty() {
            return this.authorizedParty;
        }

        public final String getClassReference() {
            return this.classReference;
        }

        public final List<String> getMethodsReferences() {
            return this.methodsReferences;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public Payload setAccessTokenHash(String str) {
            this.accessTokenHash = str;
            return this;
        }

        public Payload setAuthorizationTimeSeconds(Long l2) {
            this.authorizationTimeSeconds = l2;
            return this;
        }

        public Payload setAuthorizedParty(String str) {
            this.authorizedParty = str;
            return this;
        }

        public Payload setClassReference(String str) {
            this.classReference = str;
            return this;
        }

        public Payload setMethodsReferences(List<String> list) {
            this.methodsReferences = list;
            return this;
        }

        public Payload setNonce(String str) {
            this.nonce = str;
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setAudience(Object obj) {
            return (Payload) super.setAudience(obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setExpirationTimeSeconds(Long l2) {
            return (Payload) super.setExpirationTimeSeconds(l2);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setIssuedAtTimeSeconds(Long l2) {
            return (Payload) super.setIssuedAtTimeSeconds(l2);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setIssuer(String str) {
            return (Payload) super.setIssuer(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setJwtId(String str) {
            return (Payload) super.setJwtId(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setNotBeforeTimeSeconds(Long l2) {
            return (Payload) super.setNotBeforeTimeSeconds(l2);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setSubject(String str) {
            return (Payload) super.setSubject(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setType(String str) {
            return (Payload) super.setType(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload, e.g.b.a.c.b, e.g.b.a.d.n
        public Payload set(String str, Object obj) {
            return (Payload) super.set(str, obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload, e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Payload clone() {
            return (Payload) super.clone();
        }
    }

    public IdToken(JsonWebSignature.Header header, Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload, bArr, bArr2);
    }

    public static IdToken h(c cVar, String str) throws IOException {
        JsonWebSignature a = JsonWebSignature.f(cVar).b(Payload.class).a(str);
        return new IdToken(a.c(), (Payload) a.b(), a.d(), a.e());
    }

    @Override // com.google.api.client.json.webtoken.JsonWebToken
    /* renamed from: g */
    public Payload b() {
        return (Payload) super.b();
    }
}