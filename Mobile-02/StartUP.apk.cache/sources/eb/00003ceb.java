package com.google.zxing.o.c;

import com.appsflyer.share.Constants;
import com.coinbase.wallet.core.extensions.Strings;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.q.e;
import java.util.Arrays;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public final class a {
    private static final String[] a = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f9860b = {"CTRL_PS", " ", "a", "b", Constants.URL_CAMPAIGN, "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f9861c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f9862d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f9863e = {"CTRL_PS", " ", Strings.zero, DiskLruCache.VERSION_1, "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: f  reason: collision with root package name */
    private com.google.zxing.o.a f9864f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Decoder.java */
    /* renamed from: com.google.zxing.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0206a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Decoder.java */
    /* loaded from: classes2.dex */
    public enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = h(zArr, i2 << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws FormatException {
        com.google.zxing.common.reedsolomon.a aVar;
        int i2 = 8;
        if (this.f9864f.d() <= 2) {
            i2 = 6;
            aVar = com.google.zxing.common.reedsolomon.a.f9800c;
        } else if (this.f9864f.d() <= 8) {
            aVar = com.google.zxing.common.reedsolomon.a.f9804g;
        } else if (this.f9864f.d() <= 22) {
            i2 = 10;
            aVar = com.google.zxing.common.reedsolomon.a.f9799b;
        } else {
            i2 = 12;
            aVar = com.google.zxing.common.reedsolomon.a.a;
        }
        int c2 = this.f9864f.c();
        int length = zArr.length / i2;
        if (length >= c2) {
            int length2 = zArr.length % i2;
            int[] iArr = new int[length];
            int i3 = 0;
            while (i3 < length) {
                iArr[i3] = i(zArr, length2, i2);
                i3++;
                length2 += i2;
            }
            try {
                new c(aVar).a(iArr, length - c2);
                int i4 = (1 << i2) - 1;
                int i5 = 0;
                for (int i6 = 0; i6 < c2; i6++) {
                    int i7 = iArr[i6];
                    if (i7 == 0 || i7 == i4) {
                        throw FormatException.a();
                    }
                    if (i7 == 1 || i7 == i4 - 1) {
                        i5++;
                    }
                }
                boolean[] zArr2 = new boolean[(c2 * i2) - i5];
                int i8 = 0;
                for (int i9 = 0; i9 < c2; i9++) {
                    int i10 = iArr[i9];
                    if (i10 == 1 || i10 == i4 - 1) {
                        Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                        i8 += i2 - 1;
                    } else {
                        int i11 = i2 - 1;
                        while (i11 >= 0) {
                            int i12 = i8 + 1;
                            zArr2[i8] = ((1 << i11) & i10) != 0;
                            i11--;
                            i8 = i12;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e2) {
                throw FormatException.b(e2);
            }
        }
        throw FormatException.a();
    }

    private boolean[] d(com.google.zxing.q.b bVar) {
        boolean e2 = this.f9864f.e();
        int d2 = this.f9864f.d();
        int i2 = (e2 ? 11 : 14) + (d2 << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[j(d2, e2)];
        int i3 = 2;
        if (e2) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < d2) {
            int i11 = ((d2 - i9) << i3) + (e2 ? 9 : 12);
            int i12 = i9 << 1;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 << 1;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i10 + i15 + i16] = bVar.e(iArr[i17], iArr[i18]);
                    int i19 = iArr[i18];
                    int i20 = i13 - i16;
                    boolean z = e2;
                    zArr[(i11 * 2) + i10 + i15 + i16] = bVar.e(i19, iArr[i20]);
                    int i21 = i13 - i14;
                    zArr[(i11 * 4) + i10 + i15 + i16] = bVar.e(iArr[i20], iArr[i21]);
                    zArr[(i11 * 6) + i10 + i15 + i16] = bVar.e(iArr[i21], iArr[i17]);
                    i16++;
                    d2 = d2;
                    e2 = z;
                    i3 = 2;
                }
                i14++;
                i3 = 2;
            }
            i10 += i11 << 3;
            i9++;
            i3 = 2;
        }
        return zArr;
    }

    private static String e(b bVar, int i2) {
        int i3 = C0206a.a[bVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            return f9863e[i2];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return f9862d[i2];
                }
                return f9861c[i2];
            }
            return f9860b[i2];
        }
        return a[i2];
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVar2 = bVar;
        int i2 = 0;
        while (i2 < length) {
            if (bVar != b.BINARY) {
                int i3 = bVar == b.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int i4 = i(zArr, i2, i3);
                i2 += i3;
                String e2 = e(bVar, i4);
                if (e2.startsWith("CTRL_")) {
                    bVar2 = g(e2.charAt(5));
                    if (e2.charAt(6) != 'L') {
                        bVar2 = bVar;
                        bVar = bVar2;
                    }
                } else {
                    sb.append(e2);
                }
                bVar = bVar2;
            } else if (length - i2 < 5) {
                break;
            } else {
                int i5 = i(zArr, i2, 5);
                i2 += 5;
                if (i5 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    i5 = i(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        break;
                    } else if (length - i2 < 8) {
                        i2 = length;
                        break;
                    } else {
                        sb.append((char) i(zArr, i2, 8));
                        i2 += 8;
                        i6++;
                    }
                }
                bVar = bVar2;
            }
        }
        return sb.toString();
    }

    private static b g(char c2) {
        if (c2 != 'B') {
            if (c2 != 'D') {
                if (c2 != 'P') {
                    if (c2 != 'L') {
                        if (c2 != 'M') {
                            return b.UPPER;
                        }
                        return b.MIXED;
                    }
                    return b.LOWER;
                }
                return b.PUNCT;
            }
            return b.DIGIT;
        }
        return b.BINARY;
    }

    private static byte h(boolean[] zArr, int i2) {
        int i3;
        int length = zArr.length - i2;
        if (length >= 8) {
            i3 = i(zArr, i2, 8);
        } else {
            i3 = i(zArr, i2, length) << (8 - length);
        }
        return (byte) i3;
    }

    private static int i(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    private static int j(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public e c(com.google.zxing.o.a aVar) throws FormatException {
        this.f9864f = aVar;
        boolean[] b2 = b(d(aVar.a()));
        e eVar = new e(a(b2), f(b2), null, null);
        eVar.l(b2.length);
        return eVar;
    }
}