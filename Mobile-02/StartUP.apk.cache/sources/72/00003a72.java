package com.google.firebase.crashlytics.c.k;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Response;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class d {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private String f8978b;

    /* renamed from: c  reason: collision with root package name */
    private Headers f8979c;

    d(int i2, String str, Headers headers) {
        this.a = i2;
        this.f8978b = str;
        this.f8979c = headers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d c(Response response) throws IOException {
        return new d(response.code(), response.body() == null ? null : response.body().string(), response.headers());
    }

    public String a() {
        return this.f8978b;
    }

    public int b() {
        return this.a;
    }

    public String d(String str) {
        return this.f8979c.get(str);
    }
}