package com.google.zxing.q;

import java.util.List;

/* compiled from: DecoderResult.java */
/* loaded from: classes2.dex */
public final class e {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f9928b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9929c;

    /* renamed from: d  reason: collision with root package name */
    private final List<byte[]> f9930d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9931e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f9932f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f9933g;

    /* renamed from: h  reason: collision with root package name */
    private Object f9934h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9935i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9936j;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f9930d;
    }

    public String b() {
        return this.f9931e;
    }

    public int c() {
        return this.f9928b;
    }

    public Object d() {
        return this.f9934h;
    }

    public byte[] e() {
        return this.a;
    }

    public int f() {
        return this.f9935i;
    }

    public int g() {
        return this.f9936j;
    }

    public String h() {
        return this.f9929c;
    }

    public boolean i() {
        return this.f9935i >= 0 && this.f9936j >= 0;
    }

    public void j(Integer num) {
        this.f9933g = num;
    }

    public void k(Integer num) {
        this.f9932f = num;
    }

    public void l(int i2) {
        this.f9928b = i2;
    }

    public void m(Object obj) {
        this.f9934h = obj;
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        this.f9928b = bArr == null ? 0 : bArr.length * 8;
        this.f9929c = str;
        this.f9930d = list;
        this.f9931e = str2;
        this.f9935i = i3;
        this.f9936j = i2;
    }
}