package e.a.a.x;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import e.a.a.e;
import e.a.a.f;
import e.a.a.m;
import e.a.a.z.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipInputStream;
import org.apache.http.client.methods.HttpGet;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class c {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11916b;

    /* renamed from: c  reason: collision with root package name */
    private final b f11917c;

    private c(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f11916b = str;
        if (str2 == null) {
            this.f11917c = null;
        } else {
            this.f11917c = new b(applicationContext);
        }
    }

    private e a() {
        androidx.core.util.e<a, InputStream> a;
        m<e> i2;
        b bVar = this.f11917c;
        if (bVar == null || (a = bVar.a(this.f11916b)) == null) {
            return null;
        }
        a aVar = a.a;
        InputStream inputStream = a.f1541b;
        if (aVar == a.ZIP) {
            i2 = f.s(new ZipInputStream(inputStream), this.f11916b);
        } else {
            i2 = f.i(inputStream, this.f11916b);
        }
        if (i2.b() != null) {
            return i2.b();
        }
        return null;
    }

    private m<e> b() {
        try {
            return c();
        } catch (IOException e2) {
            return new m<>(e2);
        }
    }

    private m<e> c() throws IOException {
        d.a("Fetching " + this.f11916b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f11916b).openConnection()));
        httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                m<e> g2 = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(g2.b() != null);
                d.a(sb.toString());
                return g2;
            }
            String f2 = f(httpURLConnection);
            return new m<>(new IllegalArgumentException("Unable to fetch " + this.f11916b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f2));
        } catch (Exception e2) {
            return new m<>(e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static m<e> e(Context context, String str, String str2) {
        return new c(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    private m<e> g(HttpURLConnection httpURLConnection) throws IOException {
        a aVar;
        m<e> i2;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            d.a("Handling zip response.");
            aVar = a.ZIP;
            b bVar = this.f11917c;
            if (bVar == null) {
                i2 = f.s(new ZipInputStream(httpURLConnection.getInputStream()), null);
            } else {
                i2 = f.s(new ZipInputStream(new FileInputStream(bVar.f(this.f11916b, httpURLConnection.getInputStream(), aVar))), this.f11916b);
            }
        } else {
            d.a("Received json response.");
            aVar = a.JSON;
            b bVar2 = this.f11917c;
            if (bVar2 == null) {
                i2 = f.i(httpURLConnection.getInputStream(), null);
            } else {
                i2 = f.i(new FileInputStream(new File(bVar2.f(this.f11916b, httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f11916b);
            }
        }
        if (this.f11917c != null && i2.b() != null) {
            this.f11917c.e(this.f11916b, aVar);
        }
        return i2;
    }

    public m<e> d() {
        e a = a();
        if (a != null) {
            return new m<>(a);
        }
        d.a("Animation for " + this.f11916b + " not found in cache. Fetching from network.");
        return b();
    }
}