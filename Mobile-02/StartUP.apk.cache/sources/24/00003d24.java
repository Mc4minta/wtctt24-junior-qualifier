package com.google.zxing.t;

import com.google.zxing.NotFoundException;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.Arrays;
import java.util.Map;

/* compiled from: CodaBarReader.java */
/* loaded from: classes2.dex */
public final class a extends k {
    static final char[] a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f9986b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f9987c = {'A', 'B', 'C', 'D'};

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f9988d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private int[] f9989e = new int[80];

    /* renamed from: f  reason: collision with root package name */
    private int f9990f = 0;

    static boolean h(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i(int i2) {
        int[] iArr = this.f9989e;
        int i3 = this.f9990f;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.f9990f = i4;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f9989e = iArr2;
        }
    }

    private int j() throws NotFoundException {
        for (int i2 = 1; i2 < this.f9990f; i2 += 2) {
            int l2 = l(i2);
            if (l2 != -1 && h(f9987c, a[l2])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f9989e[i4];
                }
                if (i2 == 1 || this.f9989e[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw NotFoundException.a();
    }

    private void k(com.google.zxing.q.a aVar) throws NotFoundException {
        int i2 = 0;
        this.f9990f = 0;
        int n = aVar.n(0);
        int o = aVar.o();
        if (n < o) {
            boolean z = true;
            while (n < o) {
                if (aVar.i(n) != z) {
                    i2++;
                } else {
                    i(i2);
                    z = !z;
                    i2 = 1;
                }
                n++;
            }
            i(i2);
            return;
        }
        throw NotFoundException.a();
    }

    private int l(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f9990f) {
            return -1;
        }
        int[] iArr = this.f9989e;
        int i4 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f9986b;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
        throw com.google.zxing.NotFoundException.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(int r15) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.a.m(int):void");
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException {
        Arrays.fill(this.f9989e, 0);
        k(aVar);
        int j2 = j();
        this.f9988d.setLength(0);
        int i3 = j2;
        do {
            int l2 = l(i3);
            if (l2 != -1) {
                this.f9988d.append((char) l2);
                i3 += 8;
                if (this.f9988d.length() > 1 && h(f9987c, a[l2])) {
                    break;
                }
            } else {
                throw NotFoundException.a();
            }
        } while (i3 < this.f9990f);
        int i4 = i3 - 1;
        int i5 = this.f9989e[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f9989e[i3 + i7];
        }
        if (i3 < this.f9990f && i5 < i6 / 2) {
            throw NotFoundException.a();
        }
        m(j2);
        for (int i8 = 0; i8 < this.f9988d.length(); i8++) {
            StringBuilder sb = this.f9988d;
            sb.setCharAt(i8, a[sb.charAt(i8)]);
        }
        char charAt = this.f9988d.charAt(0);
        char[] cArr = f9987c;
        if (h(cArr, charAt)) {
            StringBuilder sb2 = this.f9988d;
            if (h(cArr, sb2.charAt(sb2.length() - 1))) {
                if (this.f9988d.length() > 3) {
                    if (map == null || !map.containsKey(com.google.zxing.d.RETURN_CODABAR_START_END)) {
                        StringBuilder sb3 = this.f9988d;
                        sb3.deleteCharAt(sb3.length() - 1);
                        this.f9988d.deleteCharAt(0);
                    }
                    int i9 = 0;
                    for (int i10 = 0; i10 < j2; i10++) {
                        i9 += this.f9989e[i10];
                    }
                    float f2 = i9;
                    while (j2 < i4) {
                        i9 += this.f9989e[j2];
                        j2++;
                    }
                    float f3 = i2;
                    return new com.google.zxing.k(this.f9988d.toString(), null, new com.google.zxing.m[]{new com.google.zxing.m(f2, f3), new com.google.zxing.m(i9, f3)}, com.google.zxing.a.CODABAR);
                }
                throw NotFoundException.a();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }
}