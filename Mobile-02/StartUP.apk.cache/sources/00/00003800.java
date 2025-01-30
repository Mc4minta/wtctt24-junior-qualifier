package com.google.api.client.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: AbstractInputStreamContent.java */
/* loaded from: classes2.dex */
public abstract class b implements h {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8338b = true;

    public b(String str) {
        e(str);
    }

    public final boolean b() {
        return this.f8338b;
    }

    public abstract InputStream c() throws IOException;

    public b d(boolean z) {
        this.f8338b = z;
        return this;
    }

    public b e(String str) {
        this.a = str;
        return this;
    }

    @Override // com.google.api.client.http.h
    public String getType() {
        return this.a;
    }

    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        e.g.b.a.d.o.c(c(), outputStream, this.f8338b);
        outputStream.flush();
    }
}