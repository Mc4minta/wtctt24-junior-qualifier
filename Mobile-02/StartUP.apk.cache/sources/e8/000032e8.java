package com.google.android.gms.internal.clearcut;

import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class r4 {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f6550b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final Object f6551c = new Object();

    public static boolean a(int[] iArr, int[] iArr2) {
        return (iArr == null || iArr.length == 0) ? iArr2 == null || iArr2.length == 0 : Arrays.equals(iArr, iArr2);
    }

    public static boolean b(long[] jArr, long[] jArr2) {
        return (jArr == null || jArr.length == 0) ? jArr2 == null || jArr2.length == 0 : Arrays.equals(jArr, jArr2);
    }

    public static boolean c(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length || objArr[i2] != null) {
                while (i3 < length2 && objArr2[i3] == null) {
                    i3++;
                }
                boolean z = i2 >= length;
                boolean z2 = i3 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i2].equals(objArr2[i3])) {
                    return false;
                }
                i2++;
                i3++;
            } else {
                i2++;
            }
        }
    }

    public static int d(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    public static int e(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr);
    }

    public static int f(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = objArr[i3];
            if (obj != null) {
                i2 = (i2 * 31) + obj.hashCode();
            }
        }
        return i2;
    }

    public static int g(byte[][] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr2 = bArr[i3];
            if (bArr2 != null) {
                i2 = (i2 * 31) + Arrays.hashCode(bArr2);
            }
        }
        return i2;
    }

    public static void h(n4 n4Var, n4 n4Var2) {
        p4 p4Var = n4Var.f6521b;
        if (p4Var != null) {
            n4Var2.f6521b = (p4) p4Var.clone();
        }
    }

    public static boolean i(byte[][] bArr, byte[][] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length || bArr[i2] != null) {
                while (i3 < length2 && bArr2[i3] == null) {
                    i3++;
                }
                boolean z = i2 >= length;
                boolean z2 = i3 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !Arrays.equals(bArr[i2], bArr2[i3])) {
                    return false;
                }
                i2++;
                i3++;
            } else {
                i2++;
            }
        }
    }
}