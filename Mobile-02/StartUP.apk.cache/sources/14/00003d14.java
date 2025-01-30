package com.google.zxing.r.b;

import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.message.TokenParser;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes2.dex */
final class c {
    private static final char[] a = {'*', '*', '*', TokenParser.SP, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f9961b;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f9962c;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f9963d;

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f9964e;

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', TokenParser.DQUOTE, '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', TokenParser.ESCAPE, ']', '^', '_'};
        f9961b = cArr;
        f9962c = new char[]{'*', '*', '*', TokenParser.SP, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f9963d = cArr;
        f9964e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, '{', '|', '}', '~', 127};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.zxing.q.e a(byte[] bArr) throws FormatException {
        com.google.zxing.q.c cVar = new com.google.zxing.q.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            b bVar2 = b.ASCII_ENCODE;
            if (bVar == bVar2) {
                bVar = c(cVar, sb, sb2);
            } else {
                int i2 = a.a[bVar.ordinal()];
                if (i2 == 1) {
                    e(cVar, sb);
                } else if (i2 == 2) {
                    g(cVar, sb);
                } else if (i2 == 3) {
                    b(cVar, sb);
                } else if (i2 == 4) {
                    f(cVar, sb);
                } else if (i2 == 5) {
                    d(cVar, sb, arrayList);
                } else {
                    throw FormatException.a();
                }
                bVar = bVar2;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new com.google.zxing.q.e(bArr, sb3, arrayList, null);
    }

    private static void b(com.google.zxing.q.c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append(TokenParser.CR);
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append('>');
                } else if (i3 == 3) {
                    sb.append(TokenParser.SP);
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else if (i3 < 40) {
                    sb.append((char) (i3 + 51));
                } else {
                    throw FormatException.a();
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static b c(com.google.zxing.q.c cVar, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int d2 = cVar.d(8);
            if (d2 == 0) {
                throw FormatException.a();
            }
            if (d2 > 128) {
                if (d2 != 129) {
                    if (d2 <= 229) {
                        int i2 = d2 - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    } else {
                        switch (d2) {
                            case 230:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return b.ANSIX12_ENCODE;
                            case 239:
                                return b.TEXT_ENCODE;
                            case 240:
                                return b.EDIFACT_ENCODE;
                            default:
                                if (d2 >= 242 && (d2 != 254 || cVar.a() != 0)) {
                                    throw FormatException.a();
                                }
                                break;
                        }
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z) {
                    d2 += 128;
                }
                sb.append((char) (d2 - 1));
                return b.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void d(com.google.zxing.q.c cVar, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int c2 = cVar.c() + 1;
        int i2 = c2 + 1;
        int i3 = i(cVar.d(8), c2);
        if (i3 == 0) {
            i3 = cVar.a() / 8;
        } else if (i3 >= 250) {
            i3 = ((i3 - 249) * 250) + i(cVar.d(8), i2);
            i2++;
        }
        if (i3 >= 0) {
            byte[] bArr = new byte[i3];
            int i4 = 0;
            while (i4 < i3) {
                if (cVar.a() >= 8) {
                    bArr[i4] = (byte) i(cVar.d(8), i2);
                    i4++;
                    i2++;
                } else {
                    throw FormatException.a();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        }
        throw FormatException.a();
    }

    private static void e(com.google.zxing.q.c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f9961b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else if (i4 != 30) {
                                throw FormatException.a();
                            } else {
                                z = true;
                            }
                            i2 = 0;
                        } else if (i2 != 3) {
                            throw FormatException.a();
                        } else {
                            if (z) {
                                sb.append((char) (i4 + 224));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i4 < cArr2.length) {
                        char c3 = cArr2[i4];
                        if (z) {
                            sb.append((char) (c3 + 128));
                            z = false;
                        } else {
                            sb.append(c3);
                        }
                    } else {
                        throw FormatException.a();
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(com.google.zxing.q.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int d2 = cVar.d(6);
                if (d2 == 31) {
                    int b2 = 8 - cVar.b();
                    if (b2 != 8) {
                        cVar.d(b2);
                        return;
                    }
                    return;
                }
                if ((d2 & 32) == 0) {
                    d2 |= 64;
                }
                sb.append((char) d2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(com.google.zxing.q.c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f9963d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else if (i4 != 30) {
                                throw FormatException.a();
                            } else {
                                z = true;
                            }
                            i2 = 0;
                        } else if (i2 == 3) {
                            char[] cArr2 = f9964e;
                            if (i4 < cArr2.length) {
                                char c3 = cArr2[i4];
                                if (z) {
                                    sb.append((char) (c3 + 128));
                                    z = false;
                                    i2 = 0;
                                } else {
                                    sb.append(c3);
                                    i2 = 0;
                                }
                            } else {
                                throw FormatException.a();
                            }
                        } else {
                            throw FormatException.a();
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f9962c;
                    if (i4 < cArr3.length) {
                        char c4 = cArr3[i4];
                        if (z) {
                            sb.append((char) (c4 + 128));
                            z = false;
                        } else {
                            sb.append(c4);
                        }
                    } else {
                        throw FormatException.a();
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static int i(int i2, int i3) {
        int i4 = i2 - (((i3 * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}