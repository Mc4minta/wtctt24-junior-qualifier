package com.google.zxing.q;

import com.google.zxing.NotFoundException;

/* compiled from: GlobalHistogramBinarizer.java */
/* loaded from: classes2.dex */
public class h extends com.google.zxing.b {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9938b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private byte[] f9939c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f9940d;

    public h(com.google.zxing.g gVar) {
        super(gVar);
        this.f9939c = f9938b;
        this.f9940d = new int[32];
    }

    private static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 <= i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i4 - i6 > length / 16) {
            int i12 = i4 - 1;
            int i13 = -1;
            int i14 = i12;
            while (i12 > i6) {
                int i15 = i12 - i6;
                int i16 = i15 * i15 * (i4 - i12) * (i3 - iArr[i12]);
                if (i16 > i13) {
                    i14 = i12;
                    i13 = i16;
                }
                i12--;
            }
            return i14 << 3;
        }
        throw NotFoundException.a();
    }

    private void h(int i2) {
        if (this.f9939c.length < i2) {
            this.f9939c = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f9940d[i3] = 0;
        }
    }

    @Override // com.google.zxing.b
    public b b() throws NotFoundException {
        com.google.zxing.g e2 = e();
        int d2 = e2.d();
        int a = e2.a();
        b bVar = new b(d2, a);
        h(d2);
        int[] iArr = this.f9940d;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] c2 = e2.c((a * i2) / 5, this.f9939c);
            int i3 = (d2 << 2) / 5;
            for (int i4 = d2 / 5; i4 < i3; i4++) {
                int i5 = (c2[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int g2 = g(iArr);
        byte[] b2 = e2.b();
        for (int i6 = 0; i6 < a; i6++) {
            int i7 = i6 * d2;
            for (int i8 = 0; i8 < d2; i8++) {
                if ((b2[i7 + i8] & 255) < g2) {
                    bVar.p(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.b
    public a c(int i2, a aVar) throws NotFoundException {
        com.google.zxing.g e2 = e();
        int d2 = e2.d();
        if (aVar != null && aVar.o() >= d2) {
            aVar.e();
        } else {
            aVar = new a(d2);
        }
        h(d2);
        byte[] c2 = e2.c(i2, this.f9939c);
        int[] iArr = this.f9940d;
        for (int i3 = 0; i3 < d2; i3++) {
            int i4 = (c2[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int g2 = g(iArr);
        if (d2 < 3) {
            for (int i5 = 0; i5 < d2; i5++) {
                if ((c2[i5] & 255) < g2) {
                    aVar.t(i5);
                }
            }
        } else {
            int i6 = c2[1] & 255;
            int i7 = 1;
            int i8 = c2[0] & 255;
            int i9 = i6;
            while (i7 < d2 - 1) {
                int i10 = i7 + 1;
                int i11 = c2[i10] & 255;
                if ((((i9 << 2) - i8) - i11) / 2 < g2) {
                    aVar.t(i7);
                }
                i8 = i9;
                i7 = i10;
                i9 = i11;
            }
        }
        return aVar;
    }
}