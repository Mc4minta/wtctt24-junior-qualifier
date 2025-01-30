package com.google.zxing.t;

import com.google.zxing.NotFoundException;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UPCEANExtension5Support.java */
/* loaded from: classes2.dex */
public final class n {
    private static final int[] a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b  reason: collision with root package name */
    private final int[] f10009b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f10010c = new StringBuilder();

    private int a(com.google.zxing.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f10009b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int o = aVar.o();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && i2 < o; i4++) {
            int j2 = p.j(aVar, iArr2, i2, p.f10016e);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                i2 = aVar.n(aVar.l(i2));
            }
        }
        if (sb.length() == 5) {
            if (d(sb.toString()) == c(i3)) {
                return i2;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    private static int c(int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == a[i3]) {
                return i3;
            }
        }
        throw NotFoundException.a();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            i2 += charSequence.charAt(i3) - '0';
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        return (i4 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if (r5.equals("90000") == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r5) {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L4d
            r2 = 53
            if (r1 == r2) goto L4a
            r2 = 57
            if (r1 == r2) goto L15
            goto L4f
        L15:
            r1 = -1
            int r2 = r5.hashCode()
            switch(r2) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r0 = r1
            goto L3e
        L1f:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L28
            goto L1d
        L28:
            r0 = 2
            goto L3e
        L2a:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L33
            goto L1d
        L33:
            r0 = r4
            goto L3e
        L35:
            java.lang.String r2 = "90000"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L3e
            goto L1d
        L3e:
            switch(r0) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r3 = "$"
            goto L4f
        L4d:
            java.lang.String r3 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r4)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L72
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "0"
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            goto L76
        L72:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L76:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.n.e(java.lang.String):java.lang.String");
    }

    private static Map<com.google.zxing.l, Object> f(String str) {
        String e2;
        if (str.length() == 5 && (e2 = e(str)) != null) {
            EnumMap enumMap = new EnumMap(com.google.zxing.l.class);
            enumMap.put((EnumMap) com.google.zxing.l.SUGGESTED_PRICE, (com.google.zxing.l) e2);
            return enumMap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.k b(int i2, com.google.zxing.q.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f10010c;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<com.google.zxing.l, Object> f2 = f(sb2);
        float f3 = i2;
        com.google.zxing.k kVar = new com.google.zxing.k(sb2, null, new com.google.zxing.m[]{new com.google.zxing.m((iArr[0] + iArr[1]) / 2.0f, f3), new com.google.zxing.m(a2, f3)}, com.google.zxing.a.UPC_EAN_EXTENSION);
        if (f2 != null) {
            kVar.g(f2);
        }
        return kVar;
    }
}