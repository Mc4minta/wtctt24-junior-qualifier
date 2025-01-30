package org.reactnative.camera.h;

import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: ImageDimensions.java */
/* loaded from: classes3.dex */
public class a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f17742b;

    /* renamed from: c  reason: collision with root package name */
    private int f17743c;

    /* renamed from: d  reason: collision with root package name */
    private int f17744d;

    public a(int i2, int i3) {
        this(i2, i3, 0);
    }

    public int a() {
        return this.f17743c;
    }

    public int b() {
        if (e()) {
            return this.a;
        }
        return this.f17742b;
    }

    public int c() {
        return this.f17744d;
    }

    public int d() {
        if (e()) {
            return this.f17742b;
        }
        return this.a;
    }

    public boolean e() {
        return this.f17744d % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 90;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.d() == d() && aVar.b() == b() && aVar.a() == a() && aVar.c() == c();
        }
        return super.equals(obj);
    }

    public a(int i2, int i3, int i4) {
        this(i2, i3, i4, -1);
    }

    public a(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.f17742b = i3;
        this.f17743c = i5;
        this.f17744d = i4;
    }
}