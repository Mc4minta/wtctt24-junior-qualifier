package com.google.zxing.q;

import java.util.Arrays;

/* compiled from: BitMatrix.java */
/* loaded from: classes2.dex */
public final class b implements Cloneable {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9913b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9914c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f9915d;

    public b(int i2) {
        this(i2, i2);
    }

    private String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f9913b * (this.a + 1));
        for (int i2 = 0; i2 < this.f9913b; i2++) {
            for (int i3 = 0; i3 < this.a; i3++) {
                sb.append(e(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.a, this.f9913b, this.f9914c, (int[]) this.f9915d.clone());
    }

    public void d(int i2, int i3) {
        int i4 = (i3 * this.f9914c) + (i2 / 32);
        int[] iArr = this.f9915d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean e(int i2, int i3) {
        return ((this.f9915d[(i3 * this.f9914c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.f9913b == bVar.f9913b && this.f9914c == bVar.f9914c && Arrays.equals(this.f9915d, bVar.f9915d);
        }
        return false;
    }

    public int[] f() {
        int length = this.f9915d.length - 1;
        while (length >= 0 && this.f9915d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f9914c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f9915d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public int[] h() {
        int i2 = this.a;
        int i3 = this.f9913b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.f9913b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = this.f9914c;
                if (i7 < i8) {
                    int i9 = this.f9915d[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 << 5;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        if (i4 < i2 || i5 < i3) {
            return null;
        }
        return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
    }

    public int hashCode() {
        int i2 = this.a;
        return (((((((i2 * 31) + i2) * 31) + this.f9913b) * 31) + this.f9914c) * 31) + Arrays.hashCode(this.f9915d);
    }

    public int i() {
        return this.f9913b;
    }

    public a k(int i2, a aVar) {
        if (aVar != null && aVar.o() >= this.a) {
            aVar.e();
        } else {
            aVar = new a(this.a);
        }
        int i3 = i2 * this.f9914c;
        for (int i4 = 0; i4 < this.f9914c; i4++) {
            aVar.u(i4 << 5, this.f9915d[i3 + i4]);
        }
        return aVar;
    }

    public int[] l() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.f9915d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.f9914c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int n() {
        return this.a;
    }

    public void o() {
        int n = n();
        int i2 = i();
        a aVar = new a(n);
        a aVar2 = new a(n);
        for (int i3 = 0; i3 < (i2 + 1) / 2; i3++) {
            aVar = k(i3, aVar);
            int i4 = (i2 - 1) - i3;
            aVar2 = k(i4, aVar2);
            aVar.s();
            aVar2.s();
            r(i3, aVar2);
            r(i4, aVar);
        }
    }

    public void p(int i2, int i3) {
        int i4 = (i3 * this.f9914c) + (i2 / 32);
        int[] iArr = this.f9915d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void q(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 > 0 && i4 > 0) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f9913b || i6 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f9914c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f9915d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public void r(int i2, a aVar) {
        int[] k2 = aVar.k();
        int[] iArr = this.f9915d;
        int i3 = this.f9914c;
        System.arraycopy(k2, 0, iArr, i2 * i3, i3);
    }

    public String s(String str, String str2) {
        return b(str, str2, "\n");
    }

    public String toString() {
        return s("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.a = i2;
            this.f9913b = i3;
            int i4 = (i2 + 31) / 32;
            this.f9914c = i4;
            this.f9915d = new int[i4 * i3];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.a = i2;
        this.f9913b = i3;
        this.f9914c = i4;
        this.f9915d = iArr;
    }
}