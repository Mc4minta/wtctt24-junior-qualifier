package com.google.api.client.http.d0;

import com.google.api.client.http.y;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

/* compiled from: ApacheHttpResponse.java */
/* loaded from: classes2.dex */
final class b extends y {
    private final HttpRequestBase a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpResponse f8345b;

    /* renamed from: c  reason: collision with root package name */
    private final Header[] f8346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        this.a = httpRequestBase;
        this.f8345b = httpResponse;
        this.f8346c = httpResponse.getAllHeaders();
    }

    @Override // com.google.api.client.http.y
    public void a() {
        this.a.abort();
    }

    @Override // com.google.api.client.http.y
    public InputStream b() throws IOException {
        HttpEntity entity = this.f8345b.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.getContent();
    }

    @Override // com.google.api.client.http.y
    public String c() {
        Header contentEncoding;
        HttpEntity entity = this.f8345b.getEntity();
        if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
            return null;
        }
        return contentEncoding.getValue();
    }

    @Override // com.google.api.client.http.y
    public String d() {
        Header contentType;
        HttpEntity entity = this.f8345b.getEntity();
        if (entity == null || (contentType = entity.getContentType()) == null) {
            return null;
        }
        return contentType.getValue();
    }

    @Override // com.google.api.client.http.y
    public int e() {
        return this.f8346c.length;
    }

    @Override // com.google.api.client.http.y
    public String f(int i2) {
        return this.f8346c[i2].getName();
    }

    @Override // com.google.api.client.http.y
    public String g(int i2) {
        return this.f8346c[i2].getValue();
    }

    @Override // com.google.api.client.http.y
    public String h() {
        StatusLine statusLine = this.f8345b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.getReasonPhrase();
    }

    @Override // com.google.api.client.http.y
    public int i() {
        StatusLine statusLine = this.f8345b.getStatusLine();
        if (statusLine == null) {
            return 0;
        }
        return statusLine.getStatusCode();
    }

    @Override // com.google.api.client.http.y
    public String j() {
        StatusLine statusLine = this.f8345b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.toString();
    }
}