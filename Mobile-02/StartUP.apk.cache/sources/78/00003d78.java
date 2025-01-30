package com.google.zxing.v.c;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: FormatInformation.java */
/* loaded from: classes2.dex */
final class g {
    private static final int[][] a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: b  reason: collision with root package name */
    private final f f10133b;

    /* renamed from: c  reason: collision with root package name */
    private final byte f10134c;

    private g(int i2) {
        this.f10133b = f.h((i2 >> 3) & 3);
        this.f10134c = (byte) (i2 & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a(int i2, int i3) {
        g b2 = b(i2, i3);
        return b2 != null ? b2 : b(i2 ^ 21522, i3 ^ 21522);
    }

    private static g b(int i2, int i3) {
        int e2;
        int[][] iArr = a;
        int i4 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        int i5 = 0;
        for (int[] iArr2 : iArr) {
            int i6 = iArr2[0];
            if (i6 != i2 && i6 != i3) {
                int e3 = e(i2, i6);
                if (e3 < i4) {
                    i5 = iArr2[1];
                    i4 = e3;
                }
                if (i2 != i3 && (e2 = e(i3, i6)) < i4) {
                    i5 = iArr2[1];
                    i4 = e2;
                }
            } else {
                return new g(iArr2[1]);
            }
        }
        if (i4 <= 3) {
            return new g(i5);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i2, int i3) {
        return Integer.bitCount(i2 ^ i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte c() {
        return this.f10134c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f d() {
        return this.f10133b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f10133b == gVar.f10133b && this.f10134c == gVar.f10134c;
        }
        return false;
    }

    public int hashCode() {
        return (this.f10133b.ordinal() << 3) | this.f10134c;
    }
}