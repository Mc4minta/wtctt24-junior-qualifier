package com.google.zxing.t;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpStatus;
import org.apache.http.message.TokenParser;

/* compiled from: Code93Reader.java */
/* loaded from: classes2.dex */
public final class d extends k {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f9995b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f9996c;

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f9997d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private final int[] f9998e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, HttpStatus.SC_FAILED_DEPENDENCY, HttpStatus.SC_METHOD_FAILURE, 418, HttpStatus.SC_NOT_FOUND, HttpStatus.SC_PAYMENT_REQUIRED, 394, 360, 356, 354, StatusLine.HTTP_PERM_REDIRECT, 282, 344, 332, 326, HttpStatus.SC_MULTIPLE_CHOICES, 278, 436, 434, 428, HttpStatus.SC_UNPROCESSABLE_ENTITY, HttpStatus.SC_NOT_ACCEPTABLE, HttpStatus.SC_GONE, 364, 358, 310, 314, HttpStatus.SC_MOVED_TEMPORARILY, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f9995b = iArr;
        f9996c = iArr[47];
    }

    private static void h(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    private static void i(CharSequence charSequence, int i2, int i3) throws ChecksumException {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i2 - 1; i6 >= 0; i6--) {
            i4 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i6)) * i5;
            i5++;
            if (i5 > i3) {
                i5 = 1;
            }
        }
        if (charSequence.charAt(i2) != a[i4 % 47]) {
            throw ChecksumException.a();
        }
    }

    private static String j(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else if (i3 < length - 1) {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 - '@';
                            c2 = (char) i2;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i2 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i2 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i2 = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i2 = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c2 = 127;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                        c2 = (char) i2;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i2 = charAt2 - ' ';
                            c2 = (char) i2;
                            break;
                        } else if (charAt2 == 'Z') {
                            c2 = ':';
                            break;
                        } else {
                            throw FormatException.a();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 + TokenParser.SP;
                            c2 = (char) i2;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                    default:
                        c2 = 0;
                        break;
                }
                sb.append(c2);
            } else {
                throw FormatException.a();
            }
            i3++;
        }
        return sb.toString();
    }

    private int[] k(com.google.zxing.q.a aVar) throws NotFoundException {
        int o = aVar.o();
        int l2 = aVar.l(0);
        Arrays.fill(this.f9998e, 0);
        int[] iArr = this.f9998e;
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        int i3 = l2;
        while (l2 < o) {
            if (aVar.i(l2) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (m(iArr) == f9996c) {
                    return new int[]{i3, l2};
                } else {
                    i3 += iArr[0] + iArr[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i2] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
            l2++;
        }
        throw NotFoundException.a();
    }

    private static char l(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f9995b;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return a[i3];
                }
                i3++;
            } else {
                throw NotFoundException.a();
            }
        }
    }

    private static int m(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int round = Math.round((iArr[i5] * 9.0f) / i2);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                for (int i6 = 0; i6 < round; i6++) {
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= round;
            }
        }
        return i4;
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] k2;
        int l2 = aVar.l(k(aVar)[1]);
        int o = aVar.o();
        int[] iArr = this.f9998e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f9997d;
        sb.setLength(0);
        while (true) {
            k.f(aVar, l2, iArr);
            int m = m(iArr);
            if (m >= 0) {
                char l3 = l(m);
                sb.append(l3);
                int i3 = l2;
                for (int i4 : iArr) {
                    i3 += i4;
                }
                int l4 = aVar.l(i3);
                if (l3 == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i5 = 0;
                    for (int i6 : iArr) {
                        i5 += i6;
                    }
                    if (l4 != o && aVar.i(l4)) {
                        if (sb.length() >= 2) {
                            h(sb);
                            sb.setLength(sb.length() - 2);
                            float f2 = i2;
                            return new com.google.zxing.k(j(sb), null, new com.google.zxing.m[]{new com.google.zxing.m((k2[1] + k2[0]) / 2.0f, f2), new com.google.zxing.m(l2 + (i5 / 2.0f), f2)}, com.google.zxing.a.CODE_93);
                        }
                        throw NotFoundException.a();
                    }
                    throw NotFoundException.a();
                }
                l2 = l4;
            } else {
                throw NotFoundException.a();
            }
        }
    }
}