package com.google.api.client.http.e0;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: DefaultConnectionFactory.java */
/* loaded from: classes2.dex */
public class b implements a {
    private final Proxy a;

    public b() {
        this(null);
    }

    @Override // com.google.api.client.http.e0.a
    public HttpURLConnection a(URL url) throws IOException {
        Proxy proxy = this.a;
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(proxy == null ? url.openConnection() : url.openConnection(proxy)));
    }

    public b(Proxy proxy) {
        this.a = proxy;
    }
}