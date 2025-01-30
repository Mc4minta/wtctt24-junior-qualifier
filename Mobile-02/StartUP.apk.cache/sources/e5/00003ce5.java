package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result.java */
/* loaded from: classes2.dex */
public final class k {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f9840b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9841c;

    /* renamed from: d  reason: collision with root package name */
    private m[] f9842d;

    /* renamed from: e  reason: collision with root package name */
    private final a f9843e;

    /* renamed from: f  reason: collision with root package name */
    private Map<l, Object> f9844f;

    /* renamed from: g  reason: collision with root package name */
    private final long f9845g;

    public k(String str, byte[] bArr, m[] mVarArr, a aVar) {
        this(str, bArr, mVarArr, aVar, System.currentTimeMillis());
    }

    public void a(m[] mVarArr) {
        m[] mVarArr2 = this.f9842d;
        if (mVarArr2 == null) {
            this.f9842d = mVarArr;
        } else if (mVarArr == null || mVarArr.length <= 0) {
        } else {
            m[] mVarArr3 = new m[mVarArr2.length + mVarArr.length];
            System.arraycopy(mVarArr2, 0, mVarArr3, 0, mVarArr2.length);
            System.arraycopy(mVarArr, 0, mVarArr3, mVarArr2.length, mVarArr.length);
            this.f9842d = mVarArr3;
        }
    }

    public a b() {
        return this.f9843e;
    }

    public byte[] c() {
        return this.f9840b;
    }

    public Map<l, Object> d() {
        return this.f9844f;
    }

    public m[] e() {
        return this.f9842d;
    }

    public String f() {
        return this.a;
    }

    public void g(Map<l, Object> map) {
        if (map != null) {
            Map<l, Object> map2 = this.f9844f;
            if (map2 == null) {
                this.f9844f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(l lVar, Object obj) {
        if (this.f9844f == null) {
            this.f9844f = new EnumMap(l.class);
        }
        this.f9844f.put(lVar, obj);
    }

    public String toString() {
        return this.a;
    }

    public k(String str, byte[] bArr, m[] mVarArr, a aVar, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, mVarArr, aVar, j2);
    }

    public k(String str, byte[] bArr, int i2, m[] mVarArr, a aVar, long j2) {
        this.a = str;
        this.f9840b = bArr;
        this.f9841c = i2;
        this.f9842d = mVarArr;
        this.f9843e = aVar;
        this.f9844f = null;
        this.f9845g = j2;
    }
}