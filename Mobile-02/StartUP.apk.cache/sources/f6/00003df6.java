package com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import java.util.Map;

/* compiled from: BarcodeResult.java */
/* loaded from: classes2.dex */
public class b {
    protected com.google.zxing.k a;

    /* renamed from: b  reason: collision with root package name */
    protected o f10345b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10346c = 2;

    public b(com.google.zxing.k kVar, o oVar) {
        this.a = kVar;
        this.f10345b = oVar;
    }

    public com.google.zxing.a a() {
        return this.a.b();
    }

    public Bitmap b() {
        return this.f10345b.b(2);
    }

    public byte[] c() {
        return this.a.c();
    }

    public Map<com.google.zxing.l, Object> d() {
        return this.a.d();
    }

    public String e() {
        return this.a.f();
    }

    public String toString() {
        return this.a.f();
    }
}