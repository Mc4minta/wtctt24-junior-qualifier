package com.google.api.client.http.d0;

import com.google.api.client.http.x;
import com.google.api.client.http.y;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* compiled from: ApacheHttpRequest.java */
/* loaded from: classes2.dex */
final class a extends x {

    /* renamed from: e  reason: collision with root package name */
    private final HttpClient f8343e;

    /* renamed from: f  reason: collision with root package name */
    private final HttpRequestBase f8344f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.f8343e = httpClient;
        this.f8344f = httpRequestBase;
    }

    @Override // com.google.api.client.http.x
    public void a(String str, String str2) {
        this.f8344f.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.x
    public y b() throws IOException {
        if (f() != null) {
            HttpRequestBase httpRequestBase = this.f8344f;
            e.g.b.a.d.y.c(httpRequestBase instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", httpRequestBase.getRequestLine().getMethod());
            d dVar = new d(d(), f());
            dVar.setContentEncoding(c());
            dVar.setContentType(e());
            ((HttpEntityEnclosingRequest) this.f8344f).setEntity(dVar);
        }
        HttpRequestBase httpRequestBase2 = this.f8344f;
        return new b(httpRequestBase2, FirebasePerfHttpClient.execute(this.f8343e, httpRequestBase2));
    }

    @Override // com.google.api.client.http.x
    public void k(int i2, int i3) throws IOException {
        HttpParams params = this.f8344f.getParams();
        ConnManagerParams.setTimeout(params, i2);
        HttpConnectionParams.setConnectionTimeout(params, i2);
        HttpConnectionParams.setSoTimeout(params, i3);
    }
}