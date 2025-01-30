package com.facebook.yoga;

/* compiled from: YogaMeasureOutput.java */
/* loaded from: classes2.dex */
public class o {
    public static long a(float f2, float f3) {
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        return Float.floatToRawIntBits(f3) | (floatToRawIntBits << 32);
    }

    public static long b(int i2, int i3) {
        return a(i2, i3);
    }
}