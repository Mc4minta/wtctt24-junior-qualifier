package com.google.api.client.http.e0;

import com.google.api.client.http.u;
import e.g.b.a.d.y;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;

/* compiled from: NetHttpTransport.java */
/* loaded from: classes2.dex */
public final class e extends u {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f8355c;

    /* renamed from: d  reason: collision with root package name */
    private final a f8356d;

    /* renamed from: e  reason: collision with root package name */
    private final SSLSocketFactory f8357e;

    /* renamed from: f  reason: collision with root package name */
    private final HostnameVerifier f8358f;

    static {
        String[] strArr = {HttpDelete.METHOD_NAME, HttpGet.METHOD_NAME, HttpHead.METHOD_NAME, HttpOptions.METHOD_NAME, HttpPost.METHOD_NAME, HttpPut.METHOD_NAME, HttpTrace.METHOD_NAME};
        f8355c = strArr;
        Arrays.sort(strArr);
    }

    public e() {
        this(null, null, null);
    }

    private static Proxy g() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort"))));
    }

    private a h(a aVar) {
        if (aVar == null) {
            if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
                return new b(g());
            }
            return new b();
        }
        return aVar;
    }

    @Override // com.google.api.client.http.u
    public boolean e(String str) {
        return Arrays.binarySearch(f8355c, str) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.http.u
    /* renamed from: f */
    public c b(String str, String str2) throws IOException {
        y.c(e(str), "HTTP method %s not supported", str);
        HttpURLConnection a = this.f8356d.a(new URL(str2));
        a.setRequestMethod(str);
        if (a instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a;
            HostnameVerifier hostnameVerifier = this.f8358f;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
            SSLSocketFactory sSLSocketFactory = this.f8357e;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return new c(a);
    }

    e(a aVar, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this.f8356d = h(aVar);
        this.f8357e = sSLSocketFactory;
        this.f8358f = hostnameVerifier;
    }
}