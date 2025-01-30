package com.google.api.client.http.d0;

import com.google.api.client.http.u;
import java.net.ProxySelector;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ApacheHttpTransport.java */
/* loaded from: classes2.dex */
public final class c extends u {

    /* renamed from: c  reason: collision with root package name */
    private final HttpClient f8347c;

    public c() {
        this(g());
    }

    public static DefaultHttpClient g() {
        return h(SSLSocketFactory.getSocketFactory(), i(), ProxySelector.getDefault());
    }

    static DefaultHttpClient h(SSLSocketFactory sSLSocketFactory, HttpParams httpParams, ProxySelector proxySelector) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", sSLSocketFactory, 443));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
        defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        if (proxySelector != null) {
            defaultHttpClient.setRoutePlanner(new ProxySelectorRoutePlanner(schemeRegistry, proxySelector));
        }
        return defaultHttpClient;
    }

    static HttpParams i() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, PKIFailureInfo.certRevoked);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 200);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(20));
        return basicHttpParams;
    }

    @Override // com.google.api.client.http.u
    public boolean e(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.http.u
    /* renamed from: f */
    public a b(String str, String str2) {
        HttpRequestBase eVar;
        if (str.equals(HttpDelete.METHOD_NAME)) {
            eVar = new HttpDelete(str2);
        } else if (str.equals(HttpGet.METHOD_NAME)) {
            eVar = new HttpGet(str2);
        } else if (str.equals(HttpHead.METHOD_NAME)) {
            eVar = new HttpHead(str2);
        } else if (str.equals(HttpPost.METHOD_NAME)) {
            eVar = new HttpPost(str2);
        } else if (str.equals(HttpPut.METHOD_NAME)) {
            eVar = new HttpPut(str2);
        } else if (str.equals(HttpTrace.METHOD_NAME)) {
            eVar = new HttpTrace(str2);
        } else if (str.equals(HttpOptions.METHOD_NAME)) {
            eVar = new HttpOptions(str2);
        } else {
            eVar = new e(str, str2);
        }
        return new a(this.f8347c, eVar);
    }

    public c(HttpClient httpClient) {
        this.f8347c = httpClient;
        HttpParams params = httpClient.getParams();
        params = params == null ? g().getParams() : params;
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        params.setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, false);
    }
}