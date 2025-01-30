package com.google.api.client.http.e0;

import com.google.api.client.http.x;
import com.google.api.client.http.y;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* compiled from: NetHttpRequest.java */
/* loaded from: classes2.dex */
final class c extends x {

    /* renamed from: e  reason: collision with root package name */
    private final HttpURLConnection f8349e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HttpURLConnection httpURLConnection) {
        this.f8349e = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    @Override // com.google.api.client.http.x
    public void a(String str, String str2) {
        this.f8349e.addRequestProperty(str, str2);
    }

    @Override // com.google.api.client.http.x
    public y b() throws IOException {
        HttpURLConnection httpURLConnection = this.f8349e;
        if (f() != null) {
            String e2 = e();
            if (e2 != null) {
                a("Content-Type", e2);
            }
            String c2 = c();
            if (c2 != null) {
                a("Content-Encoding", c2);
            }
            long d2 = d();
            int i2 = (d2 > 0L ? 1 : (d2 == 0L ? 0 : -1));
            if (i2 >= 0) {
                httpURLConnection.setRequestProperty("Content-Length", Long.toString(d2));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if (!HttpPost.METHOD_NAME.equals(requestMethod) && !HttpPut.METHOD_NAME.equals(requestMethod)) {
                e.g.b.a.d.y.c(i2 == 0, "%s with non-zero content length is not supported", requestMethod);
            } else {
                httpURLConnection.setDoOutput(true);
                if (i2 >= 0 && d2 <= 2147483647L) {
                    httpURLConnection.setFixedLengthStreamingMode((int) d2);
                } else {
                    httpURLConnection.setChunkedStreamingMode(0);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    f().writeTo(outputStream);
                    try {
                    } catch (IOException e3) {
                        throw e3;
                    }
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        try {
            httpURLConnection.connect();
            return new d(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    @Override // com.google.api.client.http.x
    public void k(int i2, int i3) {
        this.f8349e.setReadTimeout(i3);
        this.f8349e.setConnectTimeout(i2);
    }
}