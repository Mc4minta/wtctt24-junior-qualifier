package com.google.api.client.json.webtoken;

import e.g.b.a.c.b;
import e.g.b.a.d.q;
import e.g.b.a.d.x;
import e.g.b.a.d.y;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class JsonWebToken {
    private final Header a;

    /* renamed from: b  reason: collision with root package name */
    private final Payload f8417b;

    public JsonWebToken(Header header, Payload payload) {
        this.a = (Header) y.d(header);
        this.f8417b = (Payload) y.d(payload);
    }

    public Header a() {
        return this.a;
    }

    public Payload b() {
        return this.f8417b;
    }

    public String toString() {
        return x.b(this).a("header", this.a).a("payload", this.f8417b).toString();
    }

    /* loaded from: classes2.dex */
    public static class Header extends b {
        @q("cty")
        private String contentType;
        @q("typ")
        private String type;

        public final String getContentType() {
            return this.contentType;
        }

        public final String getType() {
            return this.type;
        }

        public Header setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Header setType(String str) {
            this.type = str;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Header clone() {
            return (Header) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static class Payload extends b {
        @q("aud")
        private Object audience;
        @q("exp")
        private Long expirationTimeSeconds;
        @q("iat")
        private Long issuedAtTimeSeconds;
        @q("iss")
        private String issuer;
        @q("jti")
        private String jwtId;
        @q("nbf")
        private Long notBeforeTimeSeconds;
        @q("sub")
        private String subject;
        @q("typ")
        private String type;

        public final Object getAudience() {
            return this.audience;
        }

        public final List<String> getAudienceAsList() {
            Object obj = this.audience;
            if (obj == null) {
                return Collections.emptyList();
            }
            if (obj instanceof String) {
                return Collections.singletonList((String) obj);
            }
            return (List) obj;
        }

        public final Long getExpirationTimeSeconds() {
            return this.expirationTimeSeconds;
        }

        public final Long getIssuedAtTimeSeconds() {
            return this.issuedAtTimeSeconds;
        }

        public final String getIssuer() {
            return this.issuer;
        }

        public final String getJwtId() {
            return this.jwtId;
        }

        public final Long getNotBeforeTimeSeconds() {
            return this.notBeforeTimeSeconds;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final String getType() {
            return this.type;
        }

        public Payload setAudience(Object obj) {
            this.audience = obj;
            return this;
        }

        public Payload setExpirationTimeSeconds(Long l2) {
            this.expirationTimeSeconds = l2;
            return this;
        }

        public Payload setIssuedAtTimeSeconds(Long l2) {
            this.issuedAtTimeSeconds = l2;
            return this;
        }

        public Payload setIssuer(String str) {
            this.issuer = str;
            return this;
        }

        public Payload setJwtId(String str) {
            this.jwtId = str;
            return this;
        }

        public Payload setNotBeforeTimeSeconds(Long l2) {
            this.notBeforeTimeSeconds = l2;
            return this;
        }

        public Payload setSubject(String str) {
            this.subject = str;
            return this;
        }

        public Payload setType(String str) {
            this.type = str;
            return this;
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n
        public Payload set(String str, Object obj) {
            return (Payload) super.set(str, obj);
        }

        @Override // e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Payload clone() {
            return (Payload) super.clone();
        }
    }
}