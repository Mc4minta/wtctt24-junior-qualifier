package com.google.zxing.t.r;

import com.google.zxing.m;

/* compiled from: FinderPattern.java */
/* loaded from: classes2.dex */
public final class c {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f10029b;

    /* renamed from: c  reason: collision with root package name */
    private final m[] f10030c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.a = i2;
        this.f10029b = iArr;
        float f2 = i5;
        this.f10030c = new m[]{new m(i3, f2), new m(i4, f2)};
    }

    public m[] a() {
        return this.f10030c;
    }

    public int[] b() {
        return this.f10029b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}