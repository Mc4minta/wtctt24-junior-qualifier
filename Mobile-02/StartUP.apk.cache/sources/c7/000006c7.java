package com.amplitude.api;

import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.cache.DiskLruCache;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Diagnostics.java */
/* loaded from: classes.dex */
public class i {
    protected static i a;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f3564c;

    /* renamed from: d  reason: collision with root package name */
    private volatile OkHttpClient f3565d;

    /* renamed from: e  reason: collision with root package name */
    private volatile String f3566e;

    /* renamed from: h  reason: collision with root package name */
    m f3569h = new m("diagnosticThread");

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f3563b = false;

    /* renamed from: f  reason: collision with root package name */
    int f3567f = 50;

    /* renamed from: g  reason: collision with root package name */
    String f3568g = "https://api.amplitude.com/diagnostic";

    /* renamed from: i  reason: collision with root package name */
    List<String> f3570i = new ArrayList(this.f3567f);

    /* renamed from: j  reason: collision with root package name */
    Map<String, JSONObject> f3571j = new HashMap(this.f3567f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Diagnostics.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f3572b;

        a(String str, Throwable th) {
            this.a = str;
            this.f3572b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = i.this.f3571j.get(this.a);
            try {
                if (jSONObject == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", c.j0(this.a));
                    jSONObject2.put("timestamp", System.currentTimeMillis());
                    jSONObject2.put("device_id", i.this.f3566e);
                    jSONObject2.put("count", 1);
                    Throwable th = this.f3572b;
                    if (th != null) {
                        String stackTraceString = Log.getStackTraceString(th);
                        if (!l.b(stackTraceString)) {
                            jSONObject2.put("stack_trace", c.j0(stackTraceString));
                        }
                    }
                    if (i.this.f3570i.size() >= i.this.f3567f) {
                        for (int i2 = 0; i2 < 5; i2++) {
                            i.this.f3571j.remove(i.this.f3570i.remove(0));
                        }
                    }
                    i.this.f3571j.put(this.a, jSONObject2);
                    i.this.f3570i.add(this.a);
                    return;
                }
                jSONObject.put("count", jSONObject.optInt("count", 0) + 1);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Diagnostics.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f3570i.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(i.this.f3570i.size());
            for (String str : i.this.f3570i) {
                arrayList.add(i.this.f3571j.get(str));
            }
            String jSONArray = new JSONArray((Collection) arrayList).toString();
            if (l.b(jSONArray)) {
                return;
            }
            i.this.g(jSONArray);
        }
    }

    private i() {
        this.f3569h.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized i d() {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i();
            }
            iVar = a;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i b(OkHttpClient okHttpClient, String str, String str2) {
        this.f3563b = true;
        this.f3564c = str;
        this.f3565d = okHttpClient;
        this.f3566e = str2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c() {
        if (this.f3563b && !l.b(this.f3564c) && this.f3565d != null && !l.b(this.f3566e)) {
            h(new b());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i e(String str) {
        return f(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i f(String str, Throwable th) {
        if (this.f3563b && !l.b(str) && !l.b(this.f3566e)) {
            h(new a(str, th));
        }
        return this;
    }

    protected void g(String str) {
        FormBody.Builder add = new FormBody.Builder().add("v", DiskLruCache.VERSION_1).add("client", this.f3564c).add("e", str);
        try {
            if (FirebasePerfOkHttpClient.execute(this.f3565d.newCall(new Request.Builder().url(this.f3568g).post(add.add("upload_time", "" + System.currentTimeMillis()).build()).build())).body().string().equals("success")) {
                this.f3571j.clear();
                this.f3570i.clear();
            }
        } catch (IOException | AssertionError | Exception unused) {
        }
    }

    protected void h(Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        m mVar = this.f3569h;
        if (currentThread != mVar) {
            mVar.a(runnable);
        } else {
            runnable.run();
        }
    }
}