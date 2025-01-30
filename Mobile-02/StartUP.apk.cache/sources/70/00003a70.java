package com.google.firebase.crashlytics.c.k;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class b {
    private static final OkHttpClient a = new OkHttpClient().newBuilder().callTimeout(10000, TimeUnit.MILLISECONDS).build();

    /* renamed from: b  reason: collision with root package name */
    private final a f8973b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8974c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f8975d;

    /* renamed from: f  reason: collision with root package name */
    private MultipartBody.Builder f8977f = null;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f8976e = new HashMap();

    public b(a aVar, String str, Map<String, String> map) {
        this.f8973b = aVar;
        this.f8974c = str;
        this.f8975d = map;
    }

    private Request a() {
        Request.Builder cacheControl = new Request.Builder().cacheControl(new CacheControl.Builder().noCache().build());
        HttpUrl.Builder newBuilder = HttpUrl.parse(this.f8974c).newBuilder();
        for (Map.Entry<String, String> entry : this.f8975d.entrySet()) {
            newBuilder = newBuilder.addEncodedQueryParameter(entry.getKey(), entry.getValue());
        }
        Request.Builder url = cacheControl.url(newBuilder.build());
        for (Map.Entry<String, String> entry2 : this.f8976e.entrySet()) {
            url = url.header(entry2.getKey(), entry2.getValue());
        }
        MultipartBody.Builder builder = this.f8977f;
        return url.method(this.f8973b.name(), builder == null ? null : builder.build()).build();
    }

    private MultipartBody.Builder c() {
        if (this.f8977f == null) {
            this.f8977f = new MultipartBody.Builder().setType(MultipartBody.FORM);
        }
        return this.f8977f;
    }

    public d b() throws IOException {
        return d.c(a.newCall(a()).execute());
    }

    public b d(String str, String str2) {
        this.f8976e.put(str, str2);
        return this;
    }

    public b e(Map.Entry<String, String> entry) {
        return d(entry.getKey(), entry.getValue());
    }

    public String f() {
        return this.f8973b.name();
    }

    public b g(String str, String str2) {
        this.f8977f = c().addFormDataPart(str, str2);
        return this;
    }

    public b h(String str, String str2, String str3, File file) {
        this.f8977f = c().addFormDataPart(str, str2, RequestBody.create(MediaType.parse(str3), file));
        return this;
    }
}