package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class f {
    private final HttpURLConnection a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f9389b;

    /* renamed from: c  reason: collision with root package name */
    private long f9390c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f9391d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final y0 f9392e;

    public f(HttpURLConnection httpURLConnection, y0 y0Var, i0 i0Var) {
        this.a = httpURLConnection;
        this.f9389b = i0Var;
        this.f9392e = y0Var;
        i0Var.h(httpURLConnection.getURL().toString());
    }

    private final void b0() {
        if (this.f9390c == -1) {
            this.f9392e.b();
            long c2 = this.f9392e.c();
            this.f9390c = c2;
            this.f9389b.l(c2);
        }
        String requestMethod = this.a.getRequestMethod();
        if (requestMethod != null) {
            this.f9389b.i(requestMethod);
        } else if (this.a.getDoOutput()) {
            this.f9389b.i(HttpPost.METHOD_NAME);
        } else {
            this.f9389b.i(HttpGet.METHOD_NAME);
        }
    }

    public final boolean A() {
        return this.a.getInstanceFollowRedirects();
    }

    public final long B() {
        b0();
        return this.a.getLastModified();
    }

    public final OutputStream C() throws IOException {
        try {
            return new a(this.a.getOutputStream(), this.f9389b, this.f9392e);
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final Permission D() throws IOException {
        try {
            return this.a.getPermission();
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final int E() {
        return this.a.getReadTimeout();
    }

    public final String F() {
        return this.a.getRequestMethod();
    }

    public final Map<String, List<String>> G() {
        return this.a.getRequestProperties();
    }

    public final String H(String str) {
        return this.a.getRequestProperty(str);
    }

    public final int I() throws IOException {
        b0();
        if (this.f9391d == -1) {
            long a = this.f9392e.a();
            this.f9391d = a;
            this.f9389b.n(a);
        }
        try {
            int responseCode = this.a.getResponseCode();
            this.f9389b.c(responseCode);
            return responseCode;
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final String J() throws IOException {
        b0();
        if (this.f9391d == -1) {
            long a = this.f9392e.a();
            this.f9391d = a;
            this.f9389b.n(a);
        }
        try {
            String responseMessage = this.a.getResponseMessage();
            this.f9389b.c(this.a.getResponseCode());
            return responseMessage;
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final URL K() {
        return this.a.getURL();
    }

    public final boolean L() {
        return this.a.getUseCaches();
    }

    public final void M(boolean z) {
        this.a.setAllowUserInteraction(z);
    }

    public final void N(int i2) {
        this.a.setChunkedStreamingMode(i2);
    }

    public final void O(int i2) {
        this.a.setConnectTimeout(i2);
    }

    public final void P(boolean z) {
        this.a.setDefaultUseCaches(z);
    }

    public final void Q(boolean z) {
        this.a.setDoInput(z);
    }

    public final void R(boolean z) {
        this.a.setDoOutput(z);
    }

    public final void S(int i2) {
        this.a.setFixedLengthStreamingMode(i2);
    }

    public final void T(long j2) {
        this.a.setFixedLengthStreamingMode(j2);
    }

    public final void U(long j2) {
        this.a.setIfModifiedSince(j2);
    }

    public final void V(boolean z) {
        this.a.setInstanceFollowRedirects(z);
    }

    public final void W(int i2) {
        this.a.setReadTimeout(i2);
    }

    public final void X(String str) throws ProtocolException {
        this.a.setRequestMethod(str);
    }

    public final void Y(String str, String str2) {
        this.a.setRequestProperty(str, str2);
    }

    public final void Z(boolean z) {
        this.a.setUseCaches(z);
    }

    public final void a(String str, String str2) {
        this.a.addRequestProperty(str, str2);
    }

    public final boolean a0() {
        return this.a.usingProxy();
    }

    public final void b() throws IOException {
        if (this.f9390c == -1) {
            this.f9392e.b();
            long c2 = this.f9392e.c();
            this.f9390c = c2;
            this.f9389b.l(c2);
        }
        try {
            this.a.connect();
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final void c() {
        this.f9389b.o(this.f9392e.a());
        this.f9389b.g();
        this.a.disconnect();
    }

    public final boolean d() {
        return this.a.getAllowUserInteraction();
    }

    public final int e() {
        return this.a.getConnectTimeout();
    }

    public final boolean equals(Object obj) {
        return this.a.equals(obj);
    }

    public final Object f() throws IOException {
        b0();
        this.f9389b.c(this.a.getResponseCode());
        try {
            Object content = this.a.getContent();
            if (content instanceof InputStream) {
                this.f9389b.j(this.a.getContentType());
                return new b((InputStream) content, this.f9389b, this.f9392e);
            }
            this.f9389b.j(this.a.getContentType());
            this.f9389b.p(this.a.getContentLength());
            this.f9389b.o(this.f9392e.a());
            this.f9389b.g();
            return content;
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final Object g(Class[] clsArr) throws IOException {
        b0();
        this.f9389b.c(this.a.getResponseCode());
        try {
            Object content = this.a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f9389b.j(this.a.getContentType());
                return new b((InputStream) content, this.f9389b, this.f9392e);
            }
            this.f9389b.j(this.a.getContentType());
            this.f9389b.p(this.a.getContentLength());
            this.f9389b.o(this.f9392e.a());
            this.f9389b.g();
            return content;
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }

    public final String h() {
        b0();
        return this.a.getContentEncoding();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final int i() {
        b0();
        return this.a.getContentLength();
    }

    public final long j() {
        b0();
        return this.a.getContentLengthLong();
    }

    public final String k() {
        b0();
        return this.a.getContentType();
    }

    public final long l() {
        b0();
        return this.a.getDate();
    }

    public final boolean m() {
        return this.a.getDefaultUseCaches();
    }

    public final boolean n() {
        return this.a.getDoInput();
    }

    public final boolean o() {
        return this.a.getDoOutput();
    }

    public final InputStream p() {
        b0();
        try {
            this.f9389b.c(this.a.getResponseCode());
        } catch (IOException unused) {
            Log.d("FirebasePerformance", "IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.a.getErrorStream();
        return errorStream != null ? new b(errorStream, this.f9389b, this.f9392e) : errorStream;
    }

    public final long q() {
        b0();
        return this.a.getExpiration();
    }

    public final String r(int i2) {
        b0();
        return this.a.getHeaderField(i2);
    }

    public final String s(String str) {
        b0();
        return this.a.getHeaderField(str);
    }

    public final long t(String str, long j2) {
        b0();
        return this.a.getHeaderFieldDate(str, j2);
    }

    public final String toString() {
        return this.a.toString();
    }

    public final int u(String str, int i2) {
        b0();
        return this.a.getHeaderFieldInt(str, i2);
    }

    public final String v(int i2) {
        b0();
        return this.a.getHeaderFieldKey(i2);
    }

    public final long w(String str, long j2) {
        b0();
        return this.a.getHeaderFieldLong(str, j2);
    }

    public final Map<String, List<String>> x() {
        b0();
        return this.a.getHeaderFields();
    }

    public final long y() {
        return this.a.getIfModifiedSince();
    }

    public final InputStream z() throws IOException {
        b0();
        this.f9389b.c(this.a.getResponseCode());
        this.f9389b.j(this.a.getContentType());
        try {
            return new b(this.a.getInputStream(), this.f9389b, this.f9392e);
        } catch (IOException e2) {
            this.f9389b.o(this.f9392e.a());
            g.c(this.f9389b);
            throw e2;
        }
    }
}