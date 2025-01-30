package com.google.zxing.r.b;

import com.google.zxing.FormatException;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes2.dex */
final class a {
    private final com.google.zxing.q.b a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.zxing.q.b f9958b;

    /* renamed from: c  reason: collision with root package name */
    private final e f9959c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.zxing.q.b bVar) throws FormatException {
        int i2 = bVar.i();
        if (i2 >= 8 && i2 <= 144 && (i2 & 1) == 0) {
            this.f9959c = j(bVar);
            com.google.zxing.q.b a = a(bVar);
            this.a = a;
            this.f9958b = new com.google.zxing.q.b(a.n(), a.i());
            return;
        }
        throw FormatException.a();
    }

    private com.google.zxing.q.b a(com.google.zxing.q.b bVar) {
        int f2 = this.f9959c.f();
        int e2 = this.f9959c.e();
        if (bVar.i() == f2) {
            int c2 = this.f9959c.c();
            int b2 = this.f9959c.b();
            int i2 = f2 / c2;
            int i3 = e2 / b2;
            com.google.zxing.q.b bVar2 = new com.google.zxing.q.b(i3 * b2, i2 * c2);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 * c2;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i6 * b2;
                    for (int i8 = 0; i8 < c2; i8++) {
                        int i9 = ((c2 + 2) * i4) + 1 + i8;
                        int i10 = i5 + i8;
                        for (int i11 = 0; i11 < b2; i11++) {
                            if (bVar.e(((b2 + 2) * i6) + 1 + i11, i9)) {
                                bVar2.p(i7 + i11, i10);
                            }
                        }
                    }
                }
            }
            return bVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int d(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (h(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (h(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return h(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    private int e(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return h(1, i10, i2, i3) ? i11 | 1 : i11;
    }

    private int f(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (h(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return h(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    private int g(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    private boolean h(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f9958b.p(i3, i2);
        return this.a.e(i3, i2);
    }

    private int i(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (h(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (h(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (h(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (h(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    private static e j(com.google.zxing.q.b bVar) throws FormatException {
        return e.h(bVar.i(), bVar.n());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e b() {
        return this.f9959c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() throws FormatException {
        byte[] bArr = new byte[this.f9959c.g()];
        int i2 = this.a.i();
        int n = this.a.n();
        int i3 = 0;
        int i4 = 4;
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i4 == i2 && i3 == 0 && !z) {
                bArr[i5] = (byte) d(i2, n);
                i4 -= 2;
                i3 += 2;
                i5++;
                z = true;
            } else {
                int i6 = i2 - 2;
                if (i4 == i6 && i3 == 0 && (n & 3) != 0 && !z2) {
                    bArr[i5] = (byte) e(i2, n);
                    i4 -= 2;
                    i3 += 2;
                    i5++;
                    z2 = true;
                } else if (i4 == i2 + 4 && i3 == 2 && (n & 7) == 0 && !z3) {
                    bArr[i5] = (byte) f(i2, n);
                    i4 -= 2;
                    i3 += 2;
                    i5++;
                    z3 = true;
                } else if (i4 == i6 && i3 == 0 && (n & 7) == 4 && !z4) {
                    bArr[i5] = (byte) g(i2, n);
                    i4 -= 2;
                    i3 += 2;
                    i5++;
                    z4 = true;
                } else {
                    do {
                        if (i4 < i2 && i3 >= 0 && !this.f9958b.e(i3, i4)) {
                            bArr[i5] = (byte) i(i4, i3, i2, n);
                            i5++;
                        }
                        i4 -= 2;
                        i3 += 2;
                        if (i4 < 0) {
                            break;
                        }
                    } while (i3 < n);
                    int i7 = i4 + 1;
                    int i8 = i3 + 3;
                    do {
                        if (i7 >= 0 && i8 < n && !this.f9958b.e(i8, i7)) {
                            bArr[i5] = (byte) i(i7, i8, i2, n);
                            i5++;
                        }
                        i7 += 2;
                        i8 -= 2;
                        if (i7 >= i2) {
                            break;
                        }
                    } while (i8 >= 0);
                    i4 = i7 + 3;
                    i3 = i8 + 1;
                }
            }
            if (i4 >= i2 && i3 >= n) {
                break;
            }
        }
        if (i5 == this.f9959c.g()) {
            return bArr;
        }
        throw FormatException.a();
    }
}