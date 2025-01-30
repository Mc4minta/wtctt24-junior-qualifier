package com.google.zxing.q;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* compiled from: HybridBinarizer.java */
/* loaded from: classes2.dex */
public final class j extends h {

    /* renamed from: e  reason: collision with root package name */
    private b f9941e;

    public j(com.google.zxing.g gVar) {
        super(gVar);
    }

    private static int[][] i(byte[] bArr, int i2, int i3, int i4, int i5) {
        char c2;
        int i6 = 8;
        int i7 = i5 - 8;
        int i8 = i4 - 8;
        char c3 = 2;
        boolean z = true;
        int i9 = 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i3, i2);
        int i10 = 0;
        while (i10 < i3) {
            int i11 = i10 << 3;
            if (i11 > i7) {
                i11 = i7;
            }
            int i12 = i9;
            while (i12 < i2) {
                int i13 = i12 << 3;
                if (i13 > i8) {
                    i13 = i8;
                }
                int i14 = (i11 * i4) + i13;
                int i15 = i9;
                int i16 = i15;
                int i17 = i16;
                int i18 = 255;
                while (i15 < i6) {
                    int i19 = i17;
                    int i20 = 0;
                    while (i20 < i6) {
                        int i21 = bArr[i14 + i20] & 255;
                        i16 += i21;
                        if (i21 < i18) {
                            i18 = i21;
                        }
                        if (i21 > i19) {
                            i19 = i21;
                        }
                        i20++;
                        i6 = 8;
                    }
                    if (i19 - i18 <= 24) {
                        i15++;
                        i14 += i4;
                        i17 = i19;
                        z = true;
                        i6 = 8;
                    }
                    while (true) {
                        i15++;
                        i14 += i4;
                        if (i15 < 8) {
                            int i22 = 0;
                            for (int i23 = 8; i22 < i23; i23 = 8) {
                                i16 += bArr[i14 + i22] & 255;
                                i22++;
                            }
                        }
                    }
                    i15++;
                    i14 += i4;
                    i17 = i19;
                    z = true;
                    i6 = 8;
                }
                boolean z2 = z;
                int i24 = i16 >> 6;
                if (i17 - i18 <= 24) {
                    i24 = i18 / 2;
                    if (i10 > 0 && i12 > 0) {
                        int i25 = i10 - 1;
                        int i26 = i12 - 1;
                        c2 = 2;
                        int i27 = ((iArr[i25][i12] + (iArr[i10][i26] * 2)) + iArr[i25][i26]) / 4;
                        if (i18 < i27) {
                            i24 = i27;
                        }
                        iArr[i10][i12] = i24;
                        i12++;
                        z = z2;
                        c3 = c2;
                        i6 = 8;
                        i9 = 0;
                    }
                }
                c2 = 2;
                iArr[i10][i12] = i24;
                i12++;
                z = z2;
                c3 = c2;
                i6 = 8;
                i9 = 0;
            }
            i10++;
            i6 = 8;
            i9 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int k2 = k(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int k3 = k(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[k2 + i15];
                    i14 += iArr2[k3 - 2] + iArr2[k3 - 1] + iArr2[k3] + iArr2[k3 + 1] + iArr2[k3 + 2];
                }
                l(bArr, i13, i10, i14 / 25, i4, bVar);
            }
        }
    }

    private static int k(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void l(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.p(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // com.google.zxing.b
    public com.google.zxing.b a(com.google.zxing.g gVar) {
        return new j(gVar);
    }

    @Override // com.google.zxing.q.h, com.google.zxing.b
    public b b() throws NotFoundException {
        b bVar = this.f9941e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.g e2 = e();
        int d2 = e2.d();
        int a = e2.a();
        if (d2 >= 40 && a >= 40) {
            byte[] b2 = e2.b();
            int i2 = d2 >> 3;
            if ((d2 & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = a >> 3;
            if ((a & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] i6 = i(b2, i3, i5, d2, a);
            b bVar2 = new b(d2, a);
            j(b2, i3, i5, d2, a, i6, bVar2);
            this.f9941e = bVar2;
        } else {
            this.f9941e = super.b();
        }
        return this.f9941e;
    }
}