package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class i7 extends w5 {

    /* renamed from: c  reason: collision with root package name */
    private final SSLSocketFactory f7646c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i7(b5 b5Var) {
        super(b5Var);
        this.f7646c = Build.VERSION.SDK_INT < 19 ? new u9() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] x(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HttpURLConnection v(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            SSLSocketFactory sSLSocketFactory = this.f7646c;
            if (sSLSocketFactory != null && (openConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(sSLSocketFactory);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    public final boolean y() {
        NetworkInfo networkInfo;
        q();
        try {
            networkInfo = ((ConnectivityManager) h().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}