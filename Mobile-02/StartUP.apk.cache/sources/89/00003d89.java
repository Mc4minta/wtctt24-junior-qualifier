package com.google.zxing.v.e;

import com.google.zxing.WriterException;
import com.google.zxing.v.c.h;
import com.google.zxing.v.c.j;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
public final class c {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Encoder.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
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
        }
    }

    static void a(String str, com.google.zxing.q.a aVar, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.d(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.q.a aVar) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int p = p(charSequence.charAt(i2));
            if (p == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int p2 = p(charSequence.charAt(i3));
                if (p2 != -1) {
                    aVar.d((p * 45) + p2, 11);
                    i2 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                aVar.d(p, 6);
                i2 = i3;
            }
        }
    }

    static void c(String str, h hVar, com.google.zxing.q.a aVar, String str2) throws WriterException {
        int i2 = a.a[hVar.ordinal()];
        if (i2 == 1) {
            h(str, aVar);
        } else if (i2 == 2) {
            b(str, aVar);
        } else if (i2 == 3) {
            a(str, aVar, str2);
        } else if (i2 == 4) {
            e(str, aVar);
        } else {
            throw new WriterException("Invalid mode: " + hVar);
        }
    }

    private static void d(com.google.zxing.q.d dVar, com.google.zxing.q.a aVar) {
        aVar.d(h.ECI.n(), 4);
        aVar.d(dVar.q(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void e(java.lang.String r6, com.google.zxing.q.a r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = r4
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.d(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.v.e.c.e(java.lang.String, com.google.zxing.q.a):void");
    }

    static void f(int i2, j jVar, h hVar, com.google.zxing.q.a aVar) throws WriterException {
        int q = hVar.q(jVar);
        int i3 = 1 << q;
        if (i2 < i3) {
            aVar.d(i2, q);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    static void g(h hVar, com.google.zxing.q.a aVar) {
        aVar.d(hVar.n(), 4);
    }

    static void h(CharSequence charSequence, com.google.zxing.q.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.d((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.d((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.d(charAt, 4);
                }
            }
        }
    }

    private static int i(h hVar, com.google.zxing.q.a aVar, com.google.zxing.q.a aVar2, j jVar) {
        return aVar.o() + hVar.q(jVar) + aVar2.o();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(com.google.zxing.q.a aVar, com.google.zxing.v.c.f fVar, j jVar, b bVar) throws WriterException {
        int i2 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(aVar, fVar, jVar, i4, bVar);
            int j2 = j(bVar);
            if (j2 < i2) {
                i3 = i4;
                i2 = j2;
            }
        }
        return i3;
    }

    private static h l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return h.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (p(charAt) == -1) {
                return h.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return h.ALPHANUMERIC;
        }
        if (z2) {
            return h.NUMERIC;
        }
        return h.BYTE;
    }

    private static j m(int i2, com.google.zxing.v.c.f fVar) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            j i4 = j.i(i3);
            if (v(i2, i4, fVar)) {
                return i4;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.v.e.f n(java.lang.String r8, com.google.zxing.v.c.f r9, java.util.Map<com.google.zxing.e, ?> r10) throws com.google.zxing.WriterException {
        /*
            r0 = 1
            r1 = 0
            if (r10 == 0) goto Le
            com.google.zxing.e r2 = com.google.zxing.e.CHARACTER_SET
            boolean r2 = r10.containsKey(r2)
            if (r2 == 0) goto Le
            r2 = r0
            goto Lf
        Le:
            r2 = r1
        Lf:
            java.lang.String r3 = "ISO-8859-1"
            if (r2 == 0) goto L1e
            com.google.zxing.e r4 = com.google.zxing.e.CHARACTER_SET
            java.lang.Object r4 = r10.get(r4)
            java.lang.String r4 = r4.toString()
            goto L1f
        L1e:
            r4 = r3
        L1f:
            com.google.zxing.v.c.h r5 = l(r8, r4)
            com.google.zxing.q.a r6 = new com.google.zxing.q.a
            r6.<init>()
            com.google.zxing.v.c.h r7 = com.google.zxing.v.c.h.BYTE
            if (r5 != r7) goto L3d
            if (r2 != 0) goto L34
            boolean r2 = r3.equals(r4)
            if (r2 != 0) goto L3d
        L34:
            com.google.zxing.q.d r2 = com.google.zxing.q.d.h(r4)
            if (r2 == 0) goto L3d
            d(r2, r6)
        L3d:
            if (r10 == 0) goto L48
            com.google.zxing.e r2 = com.google.zxing.e.GS1_FORMAT
            boolean r2 = r10.containsKey(r2)
            if (r2 == 0) goto L48
            goto L49
        L48:
            r0 = r1
        L49:
            if (r0 == 0) goto L64
            com.google.zxing.e r0 = com.google.zxing.e.GS1_FORMAT
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L64
            com.google.zxing.v.c.h r0 = com.google.zxing.v.c.h.FNC1_FIRST_POSITION
            g(r0, r6)
        L64:
            g(r5, r6)
            com.google.zxing.q.a r0 = new com.google.zxing.q.a
            r0.<init>()
            c(r8, r5, r0, r4)
            if (r10 == 0) goto L9c
            com.google.zxing.e r1 = com.google.zxing.e.QR_VERSION
            boolean r2 = r10.containsKey(r1)
            if (r2 == 0) goto L9c
            java.lang.Object r10 = r10.get(r1)
            java.lang.String r10 = r10.toString()
            int r10 = java.lang.Integer.parseInt(r10)
            com.google.zxing.v.c.j r10 = com.google.zxing.v.c.j.i(r10)
            int r1 = i(r5, r6, r0, r10)
            boolean r1 = v(r1, r10, r9)
            if (r1 == 0) goto L94
            goto La0
        L94:
            com.google.zxing.WriterException r8 = new com.google.zxing.WriterException
            java.lang.String r9 = "Data too big for requested version"
            r8.<init>(r9)
            throw r8
        L9c:
            com.google.zxing.v.c.j r10 = t(r9, r5, r6, r0)
        La0:
            com.google.zxing.q.a r1 = new com.google.zxing.q.a
            r1.<init>()
            r1.c(r6)
            if (r5 != r7) goto Laf
            int r8 = r0.p()
            goto Lb3
        Laf:
            int r8 = r8.length()
        Lb3:
            f(r8, r10, r5, r1)
            r1.c(r0)
            com.google.zxing.v.c.j$b r8 = r10.f(r9)
            int r0 = r10.h()
            int r2 = r8.d()
            int r0 = r0 - r2
            u(r0, r1)
            int r2 = r10.h()
            int r8 = r8.c()
            com.google.zxing.q.a r8 = r(r1, r2, r0, r8)
            com.google.zxing.v.e.f r0 = new com.google.zxing.v.e.f
            r0.<init>()
            r0.c(r9)
            r0.f(r5)
            r0.g(r10)
            int r1 = r10.e()
            com.google.zxing.v.e.b r2 = new com.google.zxing.v.e.b
            r2.<init>(r1, r1)
            int r1 = k(r8, r9, r10, r2)
            r0.d(r1)
            com.google.zxing.v.e.e.a(r8, r9, r10, r1, r2)
            r0.e(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.v.e.c.n(java.lang.String, com.google.zxing.v.c.f, java.util.Map):com.google.zxing.v.e.f");
    }

    static byte[] o(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.zxing.common.reedsolomon.d(com.google.zxing.common.reedsolomon.a.f9802e).b(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static int p(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    static void q(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
            iArr[0] = i11;
            iArr2[0] = i13;
            return;
        }
        throw new WriterException("Block ID too large");
    }

    static com.google.zxing.q.a r(com.google.zxing.q.a aVar, int i2, int i3, int i4) throws WriterException {
        if (aVar.p() == i3) {
            ArrayList<com.google.zxing.v.e.a> arrayList = new ArrayList(i4);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                q(i2, i3, i4, i8, iArr, iArr2);
                int i9 = iArr[0];
                byte[] bArr = new byte[i9];
                aVar.v(i5 << 3, bArr, 0, i9);
                byte[] o = o(bArr, iArr2[0]);
                arrayList.add(new com.google.zxing.v.e.a(bArr, o));
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, o.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                com.google.zxing.q.a aVar2 = new com.google.zxing.q.a();
                for (int i10 = 0; i10 < i6; i10++) {
                    for (com.google.zxing.v.e.a aVar3 : arrayList) {
                        byte[] a2 = aVar3.a();
                        if (i10 < a2.length) {
                            aVar2.d(a2[i10], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i7; i11++) {
                    for (com.google.zxing.v.e.a aVar4 : arrayList) {
                        byte[] b2 = aVar4.b();
                        if (i11 < b2.length) {
                            aVar2.d(b2[i11], 8);
                        }
                    }
                }
                if (i2 == aVar2.p()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i2 + " and " + aVar2.p() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static j t(com.google.zxing.v.c.f fVar, h hVar, com.google.zxing.q.a aVar, com.google.zxing.q.a aVar2) throws WriterException {
        return m(i(hVar, aVar, aVar2, m(i(hVar, aVar, aVar2, j.i(1)), fVar)), fVar);
    }

    static void u(int i2, com.google.zxing.q.a aVar) throws WriterException {
        int i3 = i2 << 3;
        if (aVar.o() <= i3) {
            for (int i4 = 0; i4 < 4 && aVar.o() < i3; i4++) {
                aVar.b(false);
            }
            int o = aVar.o() & 7;
            if (o > 0) {
                while (o < 8) {
                    aVar.b(false);
                    o++;
                }
            }
            int p = i2 - aVar.p();
            for (int i5 = 0; i5 < p; i5++) {
                aVar.d((i5 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.o() != i3) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.o() + " > " + i3);
    }

    private static boolean v(int i2, j jVar, com.google.zxing.v.c.f fVar) {
        return jVar.h() - jVar.f(fVar).d() >= (i2 + 7) / 8;
    }
}