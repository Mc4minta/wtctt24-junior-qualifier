package com.google.zxing.t;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.Arrays;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.apache.http.message.TokenParser;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: Code39Reader.java */
/* loaded from: classes2.dex */
public final class c extends k {
    static final int[] a = {52, 289, 97, 352, 49, HttpStatus.SC_NOT_MODIFIED, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 448, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, HttpStatus.SC_BAD_REQUEST, 208, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 388, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, 42};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9991b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9992c;

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f9993d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f9994e;

    public c() {
        this(false);
    }

    private static String h(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb.append(charAt);
            } else {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i2 = charAt2 - ' ';
                                } else if (charAt2 != 'Z') {
                                    throw FormatException.a();
                                } else {
                                    c2 = ':';
                                    sb.append(c2);
                                }
                            }
                            c2 = 0;
                            sb.append(c2);
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.a();
                        } else {
                            i2 = charAt2 + TokenParser.SP;
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i2 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i2 = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i2 = charAt2 + 16;
                    } else if (charAt2 < 'P' || charAt2 > 'T') {
                        if (charAt2 != 'U') {
                            if (charAt2 == 'V') {
                                c2 = '@';
                            } else if (charAt2 == 'W') {
                                c2 = '`';
                            } else if (charAt2 != 'X' && charAt2 != 'Y' && charAt2 != 'Z') {
                                throw FormatException.a();
                            } else {
                                c2 = 127;
                            }
                            sb.append(c2);
                        }
                        c2 = 0;
                        sb.append(c2);
                    } else {
                        i2 = charAt2 + '+';
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.a();
                } else {
                    i2 = charAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] i(com.google.zxing.q.a aVar, int[] iArr) throws NotFoundException {
        int o = aVar.o();
        int l2 = aVar.l(0);
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
                } else if (k(iArr) == 148 && aVar.q(Math.max(0, i3 - ((l2 - i3) / 2)), i3, false)) {
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

    private static char j(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = a;
            if (i3 >= iArr.length) {
                if (i2 == 148) {
                    return '*';
                }
                throw NotFoundException.a();
            } else if (iArr[i3] == i2) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i3);
            } else {
                i3++;
            }
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] i3;
        String sb;
        int[] iArr = this.f9994e;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f9993d;
        sb2.setLength(0);
        int l2 = aVar.l(i(aVar, iArr)[1]);
        int o = aVar.o();
        while (true) {
            k.f(aVar, l2, iArr);
            int k2 = k(iArr);
            if (k2 >= 0) {
                char j2 = j(k2);
                sb2.append(j2);
                int i4 = l2;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int l3 = aVar.l(i4);
                if (j2 == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i6 = 0;
                    for (int i7 : iArr) {
                        i6 += i7;
                    }
                    int i8 = (l3 - l2) - i6;
                    if (l3 != o && (i8 << 1) < i6) {
                        throw NotFoundException.a();
                    }
                    if (this.f9991b) {
                        int length = sb2.length() - 1;
                        int i9 = 0;
                        for (int i10 = 0; i10 < length; i10++) {
                            i9 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f9993d.charAt(i10));
                        }
                        if (sb2.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i9 % 43)) {
                            sb2.setLength(length);
                        } else {
                            throw ChecksumException.a();
                        }
                    }
                    if (sb2.length() != 0) {
                        if (this.f9992c) {
                            sb = h(sb2);
                        } else {
                            sb = sb2.toString();
                        }
                        float f2 = i2;
                        return new com.google.zxing.k(sb, null, new com.google.zxing.m[]{new com.google.zxing.m((i3[1] + i3[0]) / 2.0f, f2), new com.google.zxing.m(l2 + (i6 / 2.0f), f2)}, com.google.zxing.a.CODE_39);
                    }
                    throw NotFoundException.a();
                }
                l2 = l3;
            } else {
                throw NotFoundException.a();
            }
        }
    }

    public c(boolean z) {
        this(z, false);
    }

    public c(boolean z, boolean z2) {
        this.f9991b = z;
        this.f9992c = z2;
        this.f9993d = new StringBuilder(20);
        this.f9994e = new int[9];
    }
}