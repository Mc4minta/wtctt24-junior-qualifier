package com.google.api.client.http;

import java.io.InputStream;

/* compiled from: InputStreamContent.java */
/* loaded from: classes2.dex */
public final class w extends b {

    /* renamed from: c  reason: collision with root package name */
    private long f8404c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8405d;

    /* renamed from: e  reason: collision with root package name */
    private final InputStream f8406e;

    public w(String str, InputStream inputStream) {
        super(str);
        this.f8404c = -1L;
        this.f8406e = (InputStream) e.g.b.a.d.y.d(inputStream);
    }

    @Override // com.google.api.client.http.h
    public boolean a() {
        return this.f8405d;
    }

    @Override // com.google.api.client.http.b
    public InputStream c() {
        return this.f8406e;
    }

    public w f(boolean z) {
        return (w) super.d(z);
    }

    public w g(long j2) {
        this.f8404c = j2;
        return this;
    }

    @Override // com.google.api.client.http.h
    public long getLength() {
        return this.f8404c;
    }

    public w h(boolean z) {
        this.f8405d = z;
        return this;
    }

    @Override // com.google.api.client.http.b
    /* renamed from: i */
    public w e(String str) {
        return (w) super.e(str);
    }
}