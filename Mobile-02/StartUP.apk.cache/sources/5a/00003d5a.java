package com.google.zxing.u.d;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes2.dex */
final class e {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f10091b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger[] f10092c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
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
                a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f10092c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f10092c;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.u.d.e.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.q.e b(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            com.google.zxing.u.c r3 = new com.google.zxing.u.c
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = g(r6, r4, r0)
            goto L60
        L28:
            int r2 = d(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.q.d r1 = com.google.zxing.q.d.n(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        L49:
            int r2 = f(r6, r4, r0)
            goto L60
        L4e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = g(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            com.google.zxing.q.e r6 = new com.google.zxing.q.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.m(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.u.d.e.b(int[], java.lang.String):com.google.zxing.q.e");
    }

    private static String c(int[] iArr, int i2) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(f10092c[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.a();
    }

    private static int d(int[] iArr, int i2, com.google.zxing.u.c cVar) throws FormatException {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            cVar.d(Integer.parseInt(c(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int g2 = g(iArr, i2, sb);
            cVar.a(sb.toString());
            int i4 = iArr[g2];
            if (i4 == 922) {
                cVar.b(true);
                return g2 + 1;
            } else if (i4 != 923) {
                return g2;
            } else {
                int i5 = g2 + 1;
                int[] iArr3 = new int[iArr[0] - i5];
                boolean z = false;
                int i6 = 0;
                while (i5 < iArr[0] && !z) {
                    int i7 = i5 + 1;
                    int i8 = iArr[i5];
                    if (i8 < 900) {
                        iArr3[i6] = i8;
                        i5 = i7;
                        i6++;
                    } else if (i8 == 922) {
                        cVar.b(true);
                        i5 = i7 + 1;
                        z = true;
                    } else {
                        throw FormatException.a();
                    }
                }
                cVar.c(Arrays.copyOf(iArr3, i6));
                return i5;
            }
        }
        throw FormatException.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        b bVar;
        int i3;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            int i6 = a.a[bVar2.ordinal()];
            char c2 = TokenParser.SP;
            switch (i6) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 27:
                                    bVar2 = b.LOWER;
                                    break;
                                case 28:
                                    bVar2 = b.MIXED;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar4 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 27:
                                    bVar = b.ALPHA_SHIFT;
                                    c2 = 0;
                                    b bVar42 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar42;
                                    break;
                                case 28:
                                    bVar2 = b.MIXED;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar422 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar422;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 3:
                    if (i5 < 25) {
                        c2 = f10091b[i5];
                        break;
                    } else {
                        if (i5 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 25:
                                    bVar2 = b.PUNCT;
                                    break;
                                case 27:
                                    bVar2 = b.LOWER;
                                    break;
                                case 28:
                                    bVar2 = b.ALPHA;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar4222 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar4222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 4:
                    if (i5 < 29) {
                        c2 = a[i5];
                        break;
                    } else {
                        if (i5 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i5 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i5 == 913) {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c2 = (char) (i5 + 65);
                    } else if (i5 != 26) {
                        bVar2 = i5 != 900 ? bVar3 : b.ALPHA;
                        c2 = 0;
                        break;
                    }
                    bVar2 = bVar3;
                    break;
                case 6:
                    if (i5 >= 29) {
                        if (i5 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i5 != 900) {
                            if (i5 == 913) {
                                sb.append((char) iArr2[i4]);
                            }
                            c2 = 0;
                        } else {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                        break;
                    } else {
                        c2 = a[i5];
                    }
                    bVar2 = bVar3;
                    break;
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int f(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else {
                if (i5 != 900 && i5 != 901 && i5 != 928) {
                    switch (i5) {
                    }
                }
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == 902 || z) && i3 > 0) {
                sb.append(c(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    private static int g(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) << 1];
        int[] iArr3 = new int[(iArr[0] - i2) << 1];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = 913;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i2;
    }
}