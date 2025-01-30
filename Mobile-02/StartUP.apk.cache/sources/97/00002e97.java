package com.facebook.react.modules.network;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

/* compiled from: OkHttpClientProvider.java */
/* loaded from: classes2.dex */
public class g {
    private static f a;

    public static OkHttpClient a() {
        f fVar = a;
        if (fVar != null) {
            return fVar.a();
        }
        return c().build();
    }

    public static OkHttpClient b(Context context) {
        f fVar = a;
        if (fVar != null) {
            return fVar.a();
        }
        return d(context).build();
    }

    public static OkHttpClient.Builder c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder cookieJar = builder.connectTimeout(0L, timeUnit).readTimeout(0L, timeUnit).writeTimeout(0L, timeUnit).cookieJar(new l());
        try {
            Security.insertProviderAt((Provider) Class.forName("org.conscrypt.OpenSSLProvider").newInstance(), 1);
            return cookieJar;
        } catch (Exception unused) {
            return f(cookieJar);
        }
    }

    public static OkHttpClient.Builder d(Context context) {
        return e(context, 10485760);
    }

    public static OkHttpClient.Builder e(Context context, int i2) {
        OkHttpClient.Builder c2 = c();
        return i2 == 0 ? c2 : c2.cache(new Cache(new File(context.getCacheDir(), "http-cache"), i2));
    }

    public static OkHttpClient.Builder f(OkHttpClient.Builder builder) {
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                builder.sslSocketFactory(new o());
                ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
                ArrayList arrayList = new ArrayList();
                arrayList.add(build);
                arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
                arrayList.add(ConnectionSpec.CLEARTEXT);
                builder.connectionSpecs(arrayList);
            } catch (Exception e2) {
                e.f.d.d.a.j("OkHttpClientProvider", "Error while enabling TLS 1.2", e2);
            }
        }
        return builder;
    }

    public static void g(f fVar) {
        a = fVar;
    }
}