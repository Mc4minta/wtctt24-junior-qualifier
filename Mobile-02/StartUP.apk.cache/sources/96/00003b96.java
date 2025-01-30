package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import com.google.android.gms.internal.p000firebaseperf.z0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    private static InputStream a(z0 z0Var, com.google.firebase.perf.internal.d dVar, y0 y0Var) throws IOException {
        y0Var.b();
        long c2 = y0Var.c();
        i0 b2 = i0.b(dVar);
        try {
            URLConnection a = z0Var.a();
            if (a instanceof HttpsURLConnection) {
                return new c((HttpsURLConnection) a, y0Var, b2).getInputStream();
            }
            if (a instanceof HttpURLConnection) {
                return new d((HttpURLConnection) a, y0Var, b2).getInputStream();
            }
            return a.getInputStream();
        } catch (IOException e2) {
            b2.l(c2);
            b2.o(y0Var.a());
            b2.h(z0Var.toString());
            g.c(b2);
            throw e2;
        }
    }

    private static Object b(z0 z0Var, Class[] clsArr, com.google.firebase.perf.internal.d dVar, y0 y0Var) throws IOException {
        y0Var.b();
        long c2 = y0Var.c();
        i0 b2 = i0.b(dVar);
        try {
            URLConnection a = z0Var.a();
            if (a instanceof HttpsURLConnection) {
                return new c((HttpsURLConnection) a, y0Var, b2).getContent(clsArr);
            }
            if (a instanceof HttpURLConnection) {
                return new d((HttpURLConnection) a, y0Var, b2).getContent(clsArr);
            }
            return a.getContent(clsArr);
        } catch (IOException e2) {
            b2.l(c2);
            b2.o(y0Var.a());
            b2.h(z0Var.toString());
            g.c(b2);
            throw e2;
        }
    }

    private static Object c(z0 z0Var, com.google.firebase.perf.internal.d dVar, y0 y0Var) throws IOException {
        y0Var.b();
        long c2 = y0Var.c();
        i0 b2 = i0.b(dVar);
        try {
            URLConnection a = z0Var.a();
            if (a instanceof HttpsURLConnection) {
                return new c((HttpsURLConnection) a, y0Var, b2).getContent();
            }
            if (a instanceof HttpURLConnection) {
                return new d((HttpURLConnection) a, y0Var, b2).getContent();
            }
            return a.getContent();
        } catch (IOException e2) {
            b2.l(c2);
            b2.o(y0Var.a());
            b2.h(z0Var.toString());
            g.c(b2);
            throw e2;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return c(new z0(url), com.google.firebase.perf.internal.d.k(), new y0());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new c((HttpsURLConnection) obj, new y0(), i0.b(com.google.firebase.perf.internal.d.k()));
        }
        return obj instanceof HttpURLConnection ? new d((HttpURLConnection) obj, new y0(), i0.b(com.google.firebase.perf.internal.d.k())) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return a(new z0(url), com.google.firebase.perf.internal.d.k(), new y0());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return b(new z0(url), clsArr, com.google.firebase.perf.internal.d.k(), new y0());
    }
}