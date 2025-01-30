package com.google.zxing.v.e;

import com.google.zxing.v.c.h;
import com.google.zxing.v.c.j;

/* compiled from: QRCode.java */
/* loaded from: classes2.dex */
public final class f {
    private h a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.zxing.v.c.f f10176b;

    /* renamed from: c  reason: collision with root package name */
    private j f10177c;

    /* renamed from: d  reason: collision with root package name */
    private int f10178d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f10179e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public b a() {
        return this.f10179e;
    }

    public void c(com.google.zxing.v.c.f fVar) {
        this.f10176b = fVar;
    }

    public void d(int i2) {
        this.f10178d = i2;
    }

    public void e(b bVar) {
        this.f10179e = bVar;
    }

    public void f(h hVar) {
        this.a = hVar;
    }

    public void g(j jVar) {
        this.f10177c = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.f10176b);
        sb.append("\n version: ");
        sb.append(this.f10177c);
        sb.append("\n maskPattern: ");
        sb.append(this.f10178d);
        if (this.f10179e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f10179e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}