package com.google.zxing.u.d;

import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder.java */
/* loaded from: classes2.dex */
final class i {
    private static final float[][] a = (float[][]) Array.newInstance(float.class, com.google.zxing.u.a.f10070b.length, 8);

    static {
        int i2;
        int i3 = 0;
        while (true) {
            int[] iArr = com.google.zxing.u.a.f10070b;
            if (i3 >= iArr.length) {
                return;
            }
            int i4 = iArr[i3];
            int i5 = i4 & 1;
            int i6 = 0;
            while (i6 < 8) {
                float f2 = 0.0f;
                while (true) {
                    i2 = i4 & 1;
                    if (i2 == i5) {
                        f2 += 1.0f;
                        i4 >>= 1;
                    }
                }
                a[i3][(8 - i6) - 1] = f2 / 17.0f;
                i6++;
                i5 = i2;
            }
            i3++;
        }
    }

    private static int a(int[] iArr) {
        long j2 = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            for (int i3 = 0; i3 < iArr[i2]; i3++) {
                int i4 = 1;
                long j3 = j2 << 1;
                if (i2 % 2 != 0) {
                    i4 = 0;
                }
                j2 = j3 | i4;
            }
        }
        return (int) j2;
    }

    private static int b(int[] iArr) {
        int d2 = com.google.zxing.q.m.a.d(iArr);
        float[] fArr = new float[8];
        if (d2 > 1) {
            for (int i2 = 0; i2 < 8; i2++) {
                fArr[i2] = iArr[i2] / d2;
            }
        }
        float f2 = Float.MAX_VALUE;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            float[][] fArr2 = a;
            if (i4 >= fArr2.length) {
                return i3;
            }
            float f3 = 0.0f;
            float[] fArr3 = fArr2[i4];
            for (int i5 = 0; i5 < 8; i5++) {
                float f4 = fArr3[i5] - fArr[i5];
                f3 += f4 * f4;
                if (f3 >= f2) {
                    break;
                }
            }
            if (f3 < f2) {
                i3 = com.google.zxing.u.a.f10070b[i4];
                f2 = f3;
            }
            i4++;
        }
    }

    private static int c(int[] iArr) {
        int a2 = a(iArr);
        if (com.google.zxing.u.a.a(a2) == -1) {
            return -1;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int[] iArr) {
        int c2 = c(e(iArr));
        return c2 != -1 ? c2 : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float d2 = com.google.zxing.q.m.a.d(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 17; i4++) {
            if (iArr[i3] + i2 <= (d2 / 34.0f) + ((i4 * d2) / 17.0f)) {
                i2 += iArr[i3];
                i3++;
            }
            iArr2[i3] = iArr2[i3] + 1;
        }
        return iArr2;
    }
}