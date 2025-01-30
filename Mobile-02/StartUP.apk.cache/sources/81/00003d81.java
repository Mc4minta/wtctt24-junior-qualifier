package com.google.zxing.v.d;

import com.google.zxing.m;

/* compiled from: FinderPattern.java */
/* loaded from: classes2.dex */
public final class d extends m {

    /* renamed from: c  reason: collision with root package name */
    private final float f10162c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10163d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f10162c);
        return abs <= 1.0f || abs <= this.f10162c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d g(float f2, float f3, float f4) {
        int i2 = this.f10163d;
        int i3 = i2 + 1;
        float c2 = (i2 * c()) + f3;
        float f5 = i3;
        return new d(c2 / f5, ((this.f10163d * d()) + f2) / f5, ((this.f10163d * this.f10162c) + f4) / f5, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f10163d;
    }

    public float i() {
        return this.f10162c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f10162c = f4;
        this.f10163d = i2;
    }
}