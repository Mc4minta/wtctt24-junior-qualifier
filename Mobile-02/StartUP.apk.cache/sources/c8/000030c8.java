package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.datatransport.cct.b.j;
import com.google.android.datatransport.cct.b.k;
import com.google.android.datatransport.cct.b.l;
import com.google.android.datatransport.cct.b.m;
import com.google.android.datatransport.cct.b.n;
import com.google.android.datatransport.cct.b.o;
import com.google.android.datatransport.cct.b.p;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.m;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.g.a.c.i.h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public final class e implements m {

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f5803b;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.i.w.a f5805d;

    /* renamed from: e  reason: collision with root package name */
    private final e.g.a.c.i.w.a f5806e;
    private final com.google.firebase.encoders.a a = new com.google.firebase.encoders.g.d().g(com.google.android.datatransport.cct.b.b.a).h(true).f();

    /* renamed from: c  reason: collision with root package name */
    final URL f5804c = f(com.google.android.datatransport.cct.a.a);

    /* renamed from: f  reason: collision with root package name */
    private final int f5807f = 40000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class a {
        final URL a;

        /* renamed from: b  reason: collision with root package name */
        final j f5808b;

        /* renamed from: c  reason: collision with root package name */
        final String f5809c;

        a(URL url, j jVar, String str) {
            this.a = url;
            this.f5808b = jVar;
            this.f5809c = str;
        }

        a a(URL url) {
            return new a(url, this.f5808b, this.f5809c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final URL f5810b;

        /* renamed from: c  reason: collision with root package name */
        final long f5811c;

        b(int i2, URL url, long j2) {
            this.a = i2;
            this.f5810b = url;
            this.f5811c = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, e.g.a.c.i.w.a aVar, e.g.a.c.i.w.a aVar2) {
        this.f5803b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f5805d = aVar2;
        this.f5806e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a c(a aVar, b bVar) {
        URL url = bVar.f5810b;
        if (url != null) {
            e.g.a.c.i.t.a.a("CctTransportBackend", "Following redirect to: %s", url);
            return aVar.a(bVar.f5810b);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b d(a aVar) throws IOException {
        e.g.a.c.i.t.a.a("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(aVar.a.openConnection()));
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f5807f);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.2.1"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
        String str = aVar.f5809c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            this.a.a(aVar.f5808b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
            g(null, gZIPOutputStream);
            if (outputStream != null) {
                g(null, outputStream);
            }
            int responseCode = httpURLConnection.getResponseCode();
            e.g.a.c.i.t.a.e("CctTransportBackend", "Status Code: " + responseCode);
            e.g.a.c.i.t.a.e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
            e.g.a.c.i.t.a.e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
            if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                return new b(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0L);
            }
            if (responseCode != 200) {
                return new b(responseCode, null, 0L);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(gZIPInputStream))).a());
                if (gZIPInputStream != null) {
                    g(null, gZIPInputStream);
                }
                if (inputStream != null) {
                    g(null, inputStream);
                }
                return bVar;
            } finally {
            }
        } catch (EncodingException | IOException e2) {
            e.g.a.c.i.t.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e2);
            return new b(HttpStatus.SC_BAD_REQUEST, null, 0L);
        }
    }

    private static URL f(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    private static /* synthetic */ void g(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable unused) {
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public g a(com.google.android.datatransport.runtime.backends.f fVar) {
        l.a b2;
        HashMap hashMap = new HashMap();
        for (h hVar : fVar.b()) {
            String j2 = hVar.j();
            if (!hashMap.containsKey(j2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(hVar);
                hashMap.put(j2, arrayList);
            } else {
                ((List) hashMap.get(j2)).add(hVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            h hVar2 = (h) ((List) entry.getValue()).get(0);
            m.a c2 = com.google.android.datatransport.cct.b.m.a().d(p.a).b(this.f5806e.a()).i(this.f5805d.a()).c(k.a().b(k.b.f5776b).a(com.google.android.datatransport.cct.b.a.a().a(Integer.valueOf(hVar2.g("sdk-version"))).g(hVar2.b("model")).e(hVar2.b("hardware")).b(hVar2.b("device")).i(hVar2.b("product")).h(hVar2.b("os-uild")).f(hVar2.b("manufacturer")).d(hVar2.b("fingerprint")).c()).c());
            try {
                c2.a(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                c2.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (h hVar3 : (List) entry.getValue()) {
                e.g.a.c.i.g e2 = hVar3.e();
                e.g.a.c.b b3 = e2.b();
                if (b3.equals(e.g.a.c.b.b("proto"))) {
                    b2 = l.b(e2.a());
                } else if (b3.equals(e.g.a.c.b.b("json"))) {
                    b2 = l.a(new String(e2.a(), Charset.forName("UTF-8")));
                } else {
                    e.g.a.c.i.t.a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b3);
                }
                b2.a(hVar3.f()).g(hVar3.k()).h(hVar3.h("tz-offset")).b(o.a().b(o.c.h(hVar3.g("net-type"))).a(o.b.h(hVar3.g("mobile-subtype"))).c());
                if (hVar3.d() != null) {
                    b2.c(hVar3.d());
                }
                arrayList3.add(b2.f());
            }
            c2.g(arrayList3);
            arrayList2.add(c2.h());
        }
        j a2 = j.a(arrayList2);
        URL url = this.f5804c;
        if (fVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a d2 = com.google.android.datatransport.cct.a.d(fVar.c());
                r1 = d2.e() != null ? d2.e() : null;
                if (d2.f() != null) {
                    url = f(d2.f());
                }
            } catch (IllegalArgumentException unused2) {
                return g.a();
            }
        }
        try {
            b bVar = (b) e.g.a.c.i.u.b.a(5, new a(url, a2, r1), c.a(this), d.b());
            int i2 = bVar.a;
            if (i2 == 200) {
                return g.d(bVar.f5811c);
            }
            if (i2 < 500 && i2 != 404) {
                return g.a();
            }
            return g.e();
        } catch (IOException e3) {
            e.g.a.c.i.t.a.c("CctTransportBackend", "Could not make request to the backend", e3);
            return g.e();
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public h b(h hVar) {
        int type;
        int subtype;
        NetworkInfo activeNetworkInfo = this.f5803b.getActiveNetworkInfo();
        h.a c2 = hVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        h.a b2 = c2.b("tz-offset", TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
        if (activeNetworkInfo == null) {
            type = o.c.w.a();
        } else {
            type = activeNetworkInfo.getType();
        }
        h.a a2 = b2.a("net-type", type);
        if (activeNetworkInfo == null) {
            subtype = o.b.a.a();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = o.b.y.a();
            } else if (o.b.h(subtype) == null) {
                subtype = 0;
            }
        }
        return a2.a("mobile-subtype", subtype).d();
    }
}