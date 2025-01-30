package com.google.api.client.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteArrayContent.java */
/* loaded from: classes2.dex */
public final class d extends b {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f8340c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8341d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8342e;

    public d(String str, byte[] bArr, int i2, int i3) {
        super(str);
        this.f8340c = (byte[]) e.g.b.a.d.y.d(bArr);
        e.g.b.a.d.y.c(i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length, "offset %s, length %s, array length %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length));
        this.f8341d = i2;
        this.f8342e = i3;
    }

    @Override // com.google.api.client.http.h
    public boolean a() {
        return true;
    }

    @Override // com.google.api.client.http.b
    public InputStream c() {
        return new ByteArrayInputStream(this.f8340c, this.f8341d, this.f8342e);
    }

    @Override // com.google.api.client.http.b
    /* renamed from: f */
    public d e(String str) {
        return (d) super.e(str);
    }

    @Override // com.google.api.client.http.h
    public long getLength() {
        return this.f8342e;
    }
}