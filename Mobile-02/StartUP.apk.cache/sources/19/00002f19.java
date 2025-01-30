package com.facebook.react.uimanager;

/* compiled from: Spacing.java */
/* loaded from: classes2.dex */
public class g0 {
    private static final int[] a = {1, 2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: b  reason: collision with root package name */
    private final float[] f5123b;

    /* renamed from: c  reason: collision with root package name */
    private int f5124c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5125d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5126e;

    public g0() {
        this(0.0f);
    }

    private static float[] c() {
        return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }

    public float a(int i2) {
        float f2 = (i2 == 4 || i2 == 5) ? Float.NaN : this.f5125d;
        int i3 = this.f5124c;
        if (i3 == 0) {
            return f2;
        }
        int[] iArr = a;
        if ((iArr[i2] & i3) != 0) {
            return this.f5123b[i2];
        }
        if (this.f5126e) {
            char c2 = (i2 == 1 || i2 == 3) ? (char) 7 : (char) 6;
            if ((iArr[c2] & i3) != 0) {
                return this.f5123b[c2];
            }
            if ((i3 & iArr[8]) != 0) {
                return this.f5123b[8];
            }
        }
        return f2;
    }

    public float b(int i2) {
        return this.f5123b[i2];
    }

    public boolean d(int i2, float f2) {
        boolean z = false;
        if (d.a(this.f5123b[i2], f2)) {
            return false;
        }
        this.f5123b[i2] = f2;
        if (com.facebook.yoga.g.a(f2)) {
            this.f5124c = (~a[i2]) & this.f5124c;
        } else {
            this.f5124c = a[i2] | this.f5124c;
        }
        int i3 = this.f5124c;
        int[] iArr = a;
        if ((iArr[8] & i3) != 0 || (iArr[7] & i3) != 0 || (i3 & iArr[6]) != 0) {
            z = true;
        }
        this.f5126e = z;
        return true;
    }

    public g0(float f2) {
        this.f5124c = 0;
        this.f5125d = f2;
        this.f5123b = c();
    }
}