package com.google.zxing.t;

import com.google.zxing.NotFoundException;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UPCEANExtension2Support.java */
/* loaded from: classes2.dex */
public final class m {
    private final int[] a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f10008b = new StringBuilder();

    private int a(com.google.zxing.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int o = aVar.o();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 2 && i2 < o; i4++) {
            int j2 = p.j(aVar, iArr2, i2, p.f10016e);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (1 - i4);
            }
            if (i4 != 1) {
                i2 = aVar.n(aVar.l(i2));
            }
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i3) {
                return i2;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    private static Map<com.google.zxing.l, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(com.google.zxing.l.class);
        enumMap.put((EnumMap) com.google.zxing.l.ISSUE_NUMBER, (com.google.zxing.l) Integer.valueOf(str));
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.k b(int i2, com.google.zxing.q.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f10008b;
        sb.setLength(0);
        int a = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<com.google.zxing.l, Object> c2 = c(sb2);
        float f2 = i2;
        com.google.zxing.k kVar = new com.google.zxing.k(sb2, null, new com.google.zxing.m[]{new com.google.zxing.m((iArr[0] + iArr[1]) / 2.0f, f2), new com.google.zxing.m(a, f2)}, com.google.zxing.a.UPC_EAN_EXTENSION);
        if (c2 != null) {
            kVar.g(c2);
        }
        return kVar;
    }
}