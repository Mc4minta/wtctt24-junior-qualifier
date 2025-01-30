package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class k7 implements Runnable {
    private final URL a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f7715b;

    /* renamed from: c  reason: collision with root package name */
    private final h7 f7716c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7717d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f7718e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ i7 f7719f;

    public k7(i7 i7Var, String str, URL url, byte[] bArr, Map<String, String> map, h7 h7Var) {
        this.f7719f = i7Var;
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(url);
        com.google.android.gms.common.internal.t.k(h7Var);
        this.a = url;
        this.f7715b = null;
        this.f7716c = h7Var;
        this.f7717d = str;
        this.f7718e = null;
    }

    private final void b(int i2, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.f7719f.l().A(new Runnable(this, i2, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.j7
            private final k7 a;

            /* renamed from: b  reason: collision with root package name */
            private final int f7676b;

            /* renamed from: c  reason: collision with root package name */
            private final Exception f7677c;

            /* renamed from: d  reason: collision with root package name */
            private final byte[] f7678d;

            /* renamed from: e  reason: collision with root package name */
            private final Map f7679e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f7676b = i2;
                this.f7677c = exc;
                this.f7678d = bArr;
                this.f7679e = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.f7676b, this.f7677c, this.f7678d, this.f7679e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i2, Exception exc, byte[] bArr, Map map) {
        this.f7716c.a(this.f7717d, i2, exc, bArr, map);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        byte[] x;
        this.f7719f.c();
        int i2 = 0;
        try {
            httpURLConnection = this.f7719f.v(this.a);
            try {
                Map<String, String> map3 = this.f7718e;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                i2 = httpURLConnection.getResponseCode();
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                try {
                    i7 i7Var = this.f7719f;
                    x = i7.x(httpURLConnection);
                    httpURLConnection.disconnect();
                    b(i2, null, x, headerFields);
                } catch (IOException e2) {
                    map2 = headerFields;
                    e = e2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(i2, e, null, map2);
                } catch (Throwable th) {
                    map = headerFields;
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(i2, null, null, map);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                map2 = null;
            } catch (Throwable th2) {
                th = th2;
                map = null;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            map = null;
        }
    }
}