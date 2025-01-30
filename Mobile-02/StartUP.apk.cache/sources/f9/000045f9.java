package e.f.j.b.a;

import android.os.Looper;
import android.os.SystemClock;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import e.f.j.i.d;
import e.f.j.l.e;
import e.f.j.l.f0;
import e.f.j.l.k;
import e.f.j.l.k0;
import e.f.j.l.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.HttpHeaders;

/* compiled from: OkHttpNetworkFetcher.java */
/* loaded from: classes2.dex */
public class b extends e.f.j.l.c<c> {
    private final Call.Factory a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheControl f12404b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f12405c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpNetworkFetcher.java */
    /* loaded from: classes2.dex */
    public class a extends e {
        final /* synthetic */ Call a;

        /* compiled from: OkHttpNetworkFetcher.java */
        /* renamed from: e.f.j.b.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0271a implements Runnable {
            RunnableC0271a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.cancel();
            }
        }

        a(Call call) {
            this.a = call;
        }

        @Override // e.f.j.l.l0
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b.this.f12405c.execute(new RunnableC0271a());
            } else {
                this.a.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpNetworkFetcher.java */
    /* renamed from: e.f.j.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0272b implements Callback {
        final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f0.a f12407b;

        C0272b(c cVar, f0.a aVar) {
            this.a = cVar;
            this.f12407b = aVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            b.this.l(call, iOException, this.f12407b);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            this.a.f12410g = SystemClock.elapsedRealtime();
            ResponseBody body = response.body();
            try {
                try {
                } catch (Exception e2) {
                    b.this.l(call, e2, this.f12407b);
                }
                if (!response.isSuccessful()) {
                    b.this.l(call, new IOException("Unexpected HTTP code " + response), this.f12407b);
                    return;
                }
                com.facebook.imagepipeline.common.a c2 = com.facebook.imagepipeline.common.a.c(response.header(HttpHeaders.CONTENT_RANGE));
                if (c2 != null && (c2.f4507b != 0 || c2.f4508c != Integer.MAX_VALUE)) {
                    this.a.k(c2);
                    this.a.j(8);
                }
                long contentLength = body.contentLength();
                if (contentLength < 0) {
                    contentLength = 0;
                }
                this.f12407b.b(body.byteStream(), (int) contentLength);
            } finally {
                body.close();
            }
        }
    }

    /* compiled from: OkHttpNetworkFetcher.java */
    /* loaded from: classes2.dex */
    public static class c extends s {

        /* renamed from: f  reason: collision with root package name */
        public long f12409f;

        /* renamed from: g  reason: collision with root package name */
        public long f12410g;

        /* renamed from: h  reason: collision with root package name */
        public long f12411h;

        public c(k<d> kVar, k0 k0Var) {
            super(kVar, k0Var);
        }
    }

    public b(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Call call, Exception exc, f0.a aVar) {
        if (call.isCanceled()) {
            aVar.a();
        } else {
            aVar.onFailure(exc);
        }
    }

    @Override // e.f.j.l.f0
    /* renamed from: h */
    public c e(k<d> kVar, k0 k0Var) {
        return new c(kVar, k0Var);
    }

    @Override // e.f.j.l.f0
    /* renamed from: i */
    public void d(c cVar, f0.a aVar) {
        cVar.f12409f = SystemClock.elapsedRealtime();
        try {
            Request.Builder builder = new Request.Builder().url(cVar.h().toString()).get();
            CacheControl cacheControl = this.f12404b;
            if (cacheControl != null) {
                builder.cacheControl(cacheControl);
            }
            com.facebook.imagepipeline.common.a b2 = cVar.b().c().b();
            if (b2 != null) {
                builder.addHeader(HttpHeaders.RANGE, b2.d());
            }
            j(cVar, aVar, builder.build());
        } catch (Exception e2) {
            aVar.onFailure(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(c cVar, f0.a aVar, Request request) {
        Call newCall = this.a.newCall(request);
        cVar.b().d(new a(newCall));
        FirebasePerfOkHttpClient.enqueue(newCall, new C0272b(cVar, aVar));
    }

    @Override // e.f.j.l.f0
    /* renamed from: k */
    public Map<String, String> c(c cVar, int i2) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(cVar.f12410g - cVar.f12409f));
        hashMap.put("fetch_time", Long.toString(cVar.f12411h - cVar.f12410g));
        hashMap.put("total_time", Long.toString(cVar.f12411h - cVar.f12409f));
        hashMap.put("image_size", Integer.toString(i2));
        return hashMap;
    }

    @Override // e.f.j.l.f0
    /* renamed from: m */
    public void a(c cVar, int i2) {
        cVar.f12411h = SystemClock.elapsedRealtime();
    }

    public b(Call.Factory factory, Executor executor) {
        this(factory, executor, true);
    }

    public b(Call.Factory factory, Executor executor, boolean z) {
        this.a = factory;
        this.f12405c = executor;
        this.f12404b = z ? new CacheControl.Builder().noStore().build() : null;
    }
}