package com.google.zxing.t;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader.java */
/* loaded from: classes2.dex */
public abstract class p extends k {
    static final int[] a = {1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f10013b = {1, 1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f10014c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    static final int[][] f10015d;

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f10016e;

    /* renamed from: f  reason: collision with root package name */
    private final StringBuilder f10017f = new StringBuilder(20);

    /* renamed from: g  reason: collision with root package name */
    private final o f10018g = new o();

    /* renamed from: h  reason: collision with root package name */
    private final g f10019h = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f10015d = iArr;
        int[][] iArr2 = new int[20];
        f10016e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f10015d[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            f10016e[i2] = iArr4;
        }
    }

    static boolean i(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return r(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(com.google.zxing.q.a aVar, int[] iArr, int i2, int[][] iArr2) throws NotFoundException {
        k.f(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float e2 = k.e(iArr, iArr2[i4], 0.7f);
            if (e2 < f2) {
                i3 = i4;
                f2 = e2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] n(com.google.zxing.q.a aVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        return o(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] o(com.google.zxing.q.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int o = aVar.o();
        int n = z ? aVar.n(i2) : aVar.l(i2);
        int length = iArr.length;
        boolean z2 = z;
        int i3 = 0;
        int i4 = n;
        while (n < o) {
            if (aVar.i(n) != z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (k.e(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i4, n};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            n++;
        }
        throw NotFoundException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] p(com.google.zxing.q.a aVar) throws NotFoundException {
        int[] iArr = new int[a.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            int[] iArr3 = a;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = o(aVar, i2, false, iArr3, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = aVar.q(i5, i3, false);
            }
            i2 = i4;
        }
        return iArr2;
    }

    static int r(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.a();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.a();
            }
            i4 += charAt2;
        }
        return (1000 - i4) % 10;
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(i2, aVar, p(aVar), map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(String str) throws FormatException {
        return i(str);
    }

    int[] k(com.google.zxing.q.a aVar, int i2) throws NotFoundException {
        return n(aVar, i2, false, a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int l(com.google.zxing.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException;

    public com.google.zxing.k m(int i2, com.google.zxing.q.a aVar, int[] iArr, Map<com.google.zxing.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i3;
        String c2;
        com.google.zxing.n nVar = map == null ? null : (com.google.zxing.n) map.get(com.google.zxing.d.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (nVar != null) {
            nVar.a(new com.google.zxing.m((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.f10017f;
        sb.setLength(0);
        int l2 = l(aVar, iArr, sb);
        if (nVar != null) {
            nVar.a(new com.google.zxing.m(l2, i2));
        }
        int[] k2 = k(aVar, l2);
        if (nVar != null) {
            nVar.a(new com.google.zxing.m((k2[0] + k2[1]) / 2.0f, i2));
        }
        int i4 = k2[1];
        int i5 = (i4 - k2[0]) + i4;
        if (i5 < aVar.o() && aVar.q(i4, i5, false)) {
            String sb2 = sb.toString();
            if (sb2.length() >= 8) {
                if (h(sb2)) {
                    com.google.zxing.a q = q();
                    float f2 = i2;
                    com.google.zxing.k kVar = new com.google.zxing.k(sb2, null, new com.google.zxing.m[]{new com.google.zxing.m((iArr[1] + iArr[0]) / 2.0f, f2), new com.google.zxing.m((k2[1] + k2[0]) / 2.0f, f2)}, q);
                    try {
                        com.google.zxing.k a2 = this.f10018g.a(i2, aVar, k2[1]);
                        kVar.h(com.google.zxing.l.UPC_EAN_EXTENSION, a2.f());
                        kVar.g(a2.d());
                        kVar.a(a2.e());
                        i3 = a2.f().length();
                    } catch (ReaderException unused) {
                        i3 = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(com.google.zxing.d.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length = iArr2.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                z = false;
                                break;
                            } else if (i3 == iArr2[i6]) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (!z) {
                            throw NotFoundException.a();
                        }
                    }
                    if ((q == com.google.zxing.a.EAN_13 || q == com.google.zxing.a.UPC_A) && (c2 = this.f10019h.c(sb2)) != null) {
                        kVar.h(com.google.zxing.l.POSSIBLE_COUNTRY, c2);
                    }
                    return kVar;
                }
                throw ChecksumException.a();
            }
            throw FormatException.a();
        }
        throw NotFoundException.a();
    }

    abstract com.google.zxing.a q();
}