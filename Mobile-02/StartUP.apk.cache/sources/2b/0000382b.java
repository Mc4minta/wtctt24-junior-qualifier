package com.google.api.client.json.webtoken;

import com.google.api.client.json.webtoken.JsonWebToken;
import e.g.b.a.c.c;
import e.g.b.a.d.c0;
import e.g.b.a.d.e;
import e.g.b.a.d.q;
import e.g.b.a.d.y;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class JsonWebSignature extends JsonWebToken {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f8413c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f8414d;

    /* loaded from: classes2.dex */
    public static class Header extends JsonWebToken.Header {
        @q("alg")
        private String algorithm;
        @q("crit")
        private List<String> critical;
        @q("jwk")
        private String jwk;
        @q("jku")
        private String jwkUrl;
        @q("kid")
        private String keyId;
        @q("x5c")
        private List<String> x509Certificates;
        @q("x5t")
        private String x509Thumbprint;
        @q("x5u")
        private String x509Url;

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public final List<String> getCritical() {
            return this.critical;
        }

        public final String getJwk() {
            return this.jwk;
        }

        public final String getJwkUrl() {
            return this.jwkUrl;
        }

        public final String getKeyId() {
            return this.keyId;
        }

        @Deprecated
        public final String getX509Certificate() {
            List<String> list = this.x509Certificates;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return this.x509Certificates.get(0);
        }

        public final List<String> getX509Certificates() {
            return this.x509Certificates;
        }

        public final String getX509Thumbprint() {
            return this.x509Thumbprint;
        }

        public final String getX509Url() {
            return this.x509Url;
        }

        public Header setAlgorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Header setCritical(List<String> list) {
            this.critical = list;
            return this;
        }

        public Header setJwk(String str) {
            this.jwk = str;
            return this;
        }

        public Header setJwkUrl(String str) {
            this.jwkUrl = str;
            return this;
        }

        public Header setKeyId(String str) {
            this.keyId = str;
            return this;
        }

        @Deprecated
        public Header setX509Certificate(String str) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.x509Certificates = arrayList;
            return this;
        }

        public Header setX509Certificates(List<String> list) {
            this.x509Certificates = list;
            return this;
        }

        public Header setX509Thumbprint(String str) {
            this.x509Thumbprint = str;
            return this;
        }

        public Header setX509Url(String str) {
            this.x509Url = str;
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header
        public Header setType(String str) {
            super.setType(str);
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header, e.g.b.a.c.b, e.g.b.a.d.n
        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header, e.g.b.a.c.b, e.g.b.a.d.n, java.util.AbstractMap
        public Header clone() {
            return (Header) super.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private final c a;

        /* renamed from: b  reason: collision with root package name */
        private Class<? extends Header> f8415b = Header.class;

        /* renamed from: c  reason: collision with root package name */
        private Class<? extends JsonWebToken.Payload> f8416c = JsonWebToken.Payload.class;

        public a(c cVar) {
            this.a = (c) y.d(cVar);
        }

        public JsonWebSignature a(String str) throws IOException {
            int indexOf = str.indexOf(46);
            y.a(indexOf != -1);
            byte[] a = e.a(str.substring(0, indexOf));
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(46, i2);
            y.a(indexOf2 != -1);
            int i3 = indexOf2 + 1;
            y.a(str.indexOf(46, i3) == -1);
            byte[] a2 = e.a(str.substring(i2, indexOf2));
            byte[] a3 = e.a(str.substring(i3));
            byte[] a4 = c0.a(str.substring(0, indexOf2));
            Header header = (Header) this.a.f(new ByteArrayInputStream(a), this.f8415b);
            y.a(header.getAlgorithm() != null);
            return new JsonWebSignature(header, (JsonWebToken.Payload) this.a.f(new ByteArrayInputStream(a2), this.f8416c), a3, a4);
        }

        public a b(Class<? extends JsonWebToken.Payload> cls) {
            this.f8416c = cls;
            return this;
        }
    }

    public JsonWebSignature(Header header, JsonWebToken.Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload);
        this.f8413c = (byte[]) y.d(bArr);
        this.f8414d = (byte[]) y.d(bArr2);
    }

    public static a f(c cVar) {
        return new a(cVar);
    }

    public Header c() {
        return (Header) super.a();
    }

    public final byte[] d() {
        return this.f8413c;
    }

    public final byte[] e() {
        return this.f8414d;
    }
}