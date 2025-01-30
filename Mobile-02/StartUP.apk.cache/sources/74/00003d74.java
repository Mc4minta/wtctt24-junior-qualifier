package com.google.zxing.v.c;

import com.google.zxing.FormatException;
import com.google.zxing.q.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes2.dex */
final class d {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.values().length];
            a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.google.zxing.q.e a(byte[] bArr, j jVar, f fVar, Map<com.google.zxing.d, ?> map) throws FormatException {
        h h2;
        h hVar;
        com.google.zxing.q.c cVar = new com.google.zxing.q.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        boolean z = true;
        ArrayList arrayList = new ArrayList(1);
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        com.google.zxing.q.d dVar = null;
        while (true) {
            try {
                if (cVar.a() < 4) {
                    h2 = h.TERMINATOR;
                } else {
                    h2 = h.h(cVar.d(4));
                }
                h hVar2 = h2;
                int[] iArr = a.a;
                switch (iArr[hVar2.ordinal()]) {
                    case 5:
                        hVar = hVar2;
                        break;
                    case 6:
                    case 7:
                        z2 = z;
                        hVar = hVar2;
                        break;
                    case 8:
                        if (cVar.a() >= 16) {
                            int d2 = cVar.d(8);
                            i3 = cVar.d(8);
                            i2 = d2;
                            hVar = hVar2;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                    case 9:
                        dVar = com.google.zxing.q.d.n(g(cVar));
                        if (dVar != null) {
                            hVar = hVar2;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                    case 10:
                        int d3 = cVar.d(4);
                        int d4 = cVar.d(hVar2.q(jVar));
                        if (d3 == z) {
                            d(cVar, sb, d4);
                        }
                        hVar = hVar2;
                        break;
                    default:
                        int d5 = cVar.d(hVar2.q(jVar));
                        int i4 = iArr[hVar2.ordinal()];
                        if (i4 == z) {
                            hVar = hVar2;
                            f(cVar, sb, d5);
                            break;
                        } else if (i4 == 2) {
                            hVar = hVar2;
                            b(cVar, sb, d5, z2);
                            break;
                        } else if (i4 == 3) {
                            hVar = hVar2;
                            c(cVar, sb, d5, dVar, arrayList, map);
                            break;
                        } else if (i4 == 4) {
                            e(cVar, sb, d5);
                            hVar = hVar2;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                }
                if (hVar == h.TERMINATOR) {
                    return new com.google.zxing.q.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i2, i3);
                }
                z = true;
            } catch (IllegalArgumentException unused) {
                throw FormatException.a();
            }
        }
    }

    private static void b(com.google.zxing.q.c cVar, StringBuilder sb, int i2, boolean z) throws FormatException {
        while (i2 > 1) {
            if (cVar.a() >= 11) {
                int d2 = cVar.d(11);
                sb.append(h(d2 / 45));
                sb.append(h(d2 % 45));
                i2 -= 2;
            } else {
                throw FormatException.a();
            }
        }
        if (i2 == 1) {
            if (cVar.a() >= 6) {
                sb.append(h(cVar.d(6)));
            } else {
                throw FormatException.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(com.google.zxing.q.c cVar, StringBuilder sb, int i2, com.google.zxing.q.d dVar, Collection<byte[]> collection, Map<com.google.zxing.d, ?> map) throws FormatException {
        String name;
        if ((i2 << 3) <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.d(8);
            }
            if (dVar == null) {
                name = l.a(bArr, map);
            } else {
                name = dVar.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.a();
            }
        }
        throw FormatException.a();
    }

    private static void d(com.google.zxing.q.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int d2 = cVar.d(13);
                int i4 = (d2 % 96) | ((d2 / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.a();
            }
        }
        throw FormatException.a();
    }

    private static void e(com.google.zxing.q.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int d2 = cVar.d(13);
                int i4 = (d2 % 192) | ((d2 / 192) << 8);
                int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.a();
            }
        }
        throw FormatException.a();
    }

    private static void f(com.google.zxing.q.c cVar, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (cVar.a() >= 10) {
                int d2 = cVar.d(10);
                if (d2 < 1000) {
                    sb.append(h(d2 / 100));
                    sb.append(h((d2 / 10) % 10));
                    sb.append(h(d2 % 10));
                    i2 -= 3;
                } else {
                    throw FormatException.a();
                }
            } else {
                throw FormatException.a();
            }
        }
        if (i2 == 2) {
            if (cVar.a() >= 7) {
                int d3 = cVar.d(7);
                if (d3 < 100) {
                    sb.append(h(d3 / 10));
                    sb.append(h(d3 % 10));
                    return;
                }
                throw FormatException.a();
            }
            throw FormatException.a();
        } else if (i2 == 1) {
            if (cVar.a() >= 4) {
                int d4 = cVar.d(4);
                if (d4 < 10) {
                    sb.append(h(d4));
                    return;
                }
                throw FormatException.a();
            }
            throw FormatException.a();
        }
    }

    private static int g(com.google.zxing.q.c cVar) throws FormatException {
        int d2 = cVar.d(8);
        if ((d2 & 128) == 0) {
            return d2 & 127;
        }
        if ((d2 & 192) == 128) {
            return cVar.d(8) | ((d2 & 63) << 8);
        }
        if ((d2 & 224) == 192) {
            return cVar.d(16) | ((d2 & 31) << 16);
        }
        throw FormatException.a();
    }

    private static char h(int i2) throws FormatException {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.a();
    }
}