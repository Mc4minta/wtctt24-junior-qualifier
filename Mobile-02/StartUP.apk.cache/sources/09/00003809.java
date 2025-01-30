package com.google.api.client.http.d0;

import e.g.b.a.d.y;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* compiled from: HttpExtensionMethod.java */
/* loaded from: classes2.dex */
final class e extends HttpEntityEnclosingRequestBase {
    private final String a;

    public e(String str, String str2) {
        this.a = (String) y.d(str);
        setURI(URI.create(str2));
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.a;
    }
}