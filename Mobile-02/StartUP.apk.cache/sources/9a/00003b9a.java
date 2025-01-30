package com.google.firebase.perf.network;

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

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class d extends HttpURLConnection {
    private final f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HttpURLConnection httpURLConnection, y0 y0Var, i0 i0Var) {
        super(httpURLConnection.getURL());
        this.a = new f(httpURLConnection, y0Var, i0Var);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.a.a(str, str2);
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        this.a.b();
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        this.a.c();
    }

    public final boolean equals(Object obj) {
        return this.a.equals(obj);
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.a.d();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.a.e();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        return this.a.f();
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() {
        return this.a.h();
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        return this.a.i();
    }

    @Override // java.net.URLConnection
    public final long getContentLengthLong() {
        return this.a.j();
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        return this.a.k();
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        return this.a.l();
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.a.m();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.a.n();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.a.o();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        return this.a.p();
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        return this.a.q();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        return this.a.r(i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j2) {
        return this.a.t(str, j2);
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i2) {
        return this.a.u(str, i2);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        return this.a.v(i2);
    }

    @Override // java.net.URLConnection
    public final long getHeaderFieldLong(String str, long j2) {
        return this.a.w(str, j2);
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        return this.a.x();
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        return this.a.y();
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        return this.a.z();
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.a.A();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        return this.a.B();
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        return this.a.C();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() throws IOException {
        return this.a.D();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.a.E();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.a.F();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.a.G();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.a.H(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        return this.a.I();
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        return this.a.J();
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.a.K();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.a.L();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z) {
        this.a.M(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i2) {
        this.a.N(i2);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i2) {
        this.a.O(i2);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z) {
        this.a.P(z);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z) {
        this.a.Q(z);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z) {
        this.a.R(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i2) {
        this.a.S(i2);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j2) {
        this.a.U(j2);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z) {
        this.a.V(z);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i2) {
        this.a.W(i2);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        this.a.X(str);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.a.Y(str, str2);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z) {
        this.a.Z(z);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.a.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.a.a0();
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        return this.a.g(clsArr);
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        return this.a.s(str);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(long j2) {
        this.a.T(j2);
    }
}