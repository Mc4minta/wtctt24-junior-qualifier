package com.google.zxing.t.r;

import com.google.zxing.NotFoundException;
import com.google.zxing.t.k;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: AbstractRSSReader.java */
/* loaded from: classes2.dex */
public abstract class a extends k {

    /* renamed from: b  reason: collision with root package name */
    private final int[] f10023b;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f10026e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f10027f;
    private final int[] a = new int[4];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f10024c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f10025d = new float[4];

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        int[] iArr = new int[8];
        this.f10023b = iArr;
        this.f10026e = new int[iArr.length / 2];
        this.f10027f = new int[iArr.length / 2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void o(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean p(int[] iArr) {
        int i2;
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + i2) + iArr[3]);
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i3 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            int i4 = Integer.MIN_VALUE;
            for (int i5 : iArr) {
                if (i5 > i4) {
                    i4 = i5;
                }
                if (i5 < i3) {
                    i3 = i5;
                }
            }
            if (i4 < i3 * 10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int q(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (k.e(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw NotFoundException.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] i() {
        return this.f10023b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] j() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] k() {
        return this.f10027f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] l() {
        return this.f10025d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] m() {
        return this.f10026e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] n() {
        return this.f10024c;
    }
}