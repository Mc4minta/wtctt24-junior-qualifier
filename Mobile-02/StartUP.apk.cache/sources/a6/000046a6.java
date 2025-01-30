package e.f.j.l;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import e.f.j.l.f0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

/* compiled from: HttpUrlConnectionNetworkFetcher.java */
/* loaded from: classes2.dex */
public class t extends e.f.j.l.c<c> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f12742b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.common.time.b f12743c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0.a f12744b;

        a(c cVar, f0.a aVar) {
            this.a = cVar;
            this.f12744b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.j(this.a, this.f12744b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* loaded from: classes2.dex */
    public class b extends e {
        final /* synthetic */ Future a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0.a f12746b;

        b(Future future, f0.a aVar) {
            this.a = future;
            this.f12746b = aVar;
        }

        @Override // e.f.j.l.l0
        public void a() {
            if (this.a.cancel(false)) {
                this.f12746b.a();
            }
        }
    }

    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* loaded from: classes2.dex */
    public static class c extends s {

        /* renamed from: f  reason: collision with root package name */
        private long f12748f;

        /* renamed from: g  reason: collision with root package name */
        private long f12749g;

        /* renamed from: h  reason: collision with root package name */
        private long f12750h;

        public c(k<e.f.j.i.d> kVar, k0 k0Var) {
            super(kVar, k0Var);
        }
    }

    public t(int i2) {
        this(RealtimeSinceBootClock.get());
        this.a = i2;
    }

    private HttpURLConnection g(Uri uri, int i2) throws IOException {
        HttpURLConnection o = o(uri);
        o.setConnectTimeout(this.a);
        int responseCode = o.getResponseCode();
        if (m(responseCode)) {
            return o;
        }
        if (l(responseCode)) {
            String headerField = o.getHeaderField(HttpHeaders.LOCATION);
            o.disconnect();
            Uri parse = headerField == null ? null : Uri.parse(headerField);
            String scheme = uri.getScheme();
            if (i2 > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                return g(parse, i2 - 1);
            }
            throw new IOException(i2 == 0 ? h("URL %s follows too many redirects", uri.toString()) : h("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        o.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
    }

    private static String h(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    private static boolean l(int i2) {
        if (i2 == 307 || i2 == 308) {
            return true;
        }
        switch (i2) {
            case HttpStatus.SC_MULTIPLE_CHOICES /* 300 */:
            case HttpStatus.SC_MOVED_PERMANENTLY /* 301 */:
            case HttpStatus.SC_MOVED_TEMPORARILY /* 302 */:
            case HttpStatus.SC_SEE_OTHER /* 303 */:
                return true;
            default:
                return false;
        }
    }

    private static boolean m(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    static HttpURLConnection o(Uri uri) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(com.facebook.common.util.e.m(uri).openConnection()));
    }

    @Override // e.f.j.l.f0
    /* renamed from: f */
    public c e(k<e.f.j.i.d> kVar, k0 k0Var) {
        return new c(kVar, k0Var);
    }

    @Override // e.f.j.l.f0
    /* renamed from: i */
    public void d(c cVar, f0.a aVar) {
        cVar.f12748f = this.f12743c.now();
        cVar.b().d(new b(this.f12742b.submit(new a(cVar, aVar)), aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void j(e.f.j.l.t.c r5, e.f.j.l.f0.a r6) {
        /*
            r4 = this;
            r0 = 0
            android.net.Uri r1 = r5.h()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L2a
            r2 = 5
            java.net.HttpURLConnection r1 = r4.g(r1, r2)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L2a
            com.facebook.common.time.b r2 = r4.f12743c     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3a
            long r2 = r2.now()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3a
            e.f.j.l.t.c.o(r5, r2)     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3a
            if (r1 == 0) goto L1d
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3a
            r5 = -1
            r6.b(r0, r5)     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L3a
        L1d:
            if (r0 == 0) goto L22
            r0.close()     // Catch: java.io.IOException -> L22
        L22:
            if (r1 == 0) goto L39
            goto L36
        L25:
            r5 = move-exception
            goto L2c
        L27:
            r5 = move-exception
            r1 = r0
            goto L3b
        L2a:
            r5 = move-exception
            r1 = r0
        L2c:
            r6.onFailure(r5)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L34
            r0.close()     // Catch: java.io.IOException -> L34
        L34:
            if (r1 == 0) goto L39
        L36:
            r1.disconnect()
        L39:
            return
        L3a:
            r5 = move-exception
        L3b:
            if (r0 == 0) goto L40
            r0.close()     // Catch: java.io.IOException -> L40
        L40:
            if (r1 == 0) goto L45
            r1.disconnect()
        L45:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.j.l.t.j(e.f.j.l.t$c, e.f.j.l.f0$a):void");
    }

    @Override // e.f.j.l.f0
    /* renamed from: k */
    public Map<String, String> c(c cVar, int i2) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(cVar.f12749g - cVar.f12748f));
        hashMap.put("fetch_time", Long.toString(cVar.f12750h - cVar.f12749g));
        hashMap.put("total_time", Long.toString(cVar.f12750h - cVar.f12748f));
        hashMap.put("image_size", Integer.toString(i2));
        return hashMap;
    }

    @Override // e.f.j.l.f0
    /* renamed from: n */
    public void a(c cVar, int i2) {
        cVar.f12750h = this.f12743c.now();
    }

    t(com.facebook.common.time.b bVar) {
        this.f12742b = Executors.newFixedThreadPool(3);
        this.f12743c = bVar;
    }
}