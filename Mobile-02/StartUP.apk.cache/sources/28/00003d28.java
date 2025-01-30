package com.google.zxing.t;

import com.google.zxing.NotFoundException;

/* compiled from: EAN13Reader.java */
/* loaded from: classes2.dex */
public final class e extends p {

    /* renamed from: i  reason: collision with root package name */
    static final int[] f9999i = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: j  reason: collision with root package name */
    private final int[] f10000j = new int[4];

    private static void s(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f9999i[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw NotFoundException.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.t.p
    public int l(com.google.zxing.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f10000j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int o = aVar.o();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < o; i4++) {
            int j2 = p.j(aVar, iArr2, i2, p.f10016e);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        s(sb, i3);
        int i6 = p.n(aVar, i2, true, p.f10013b)[1];
        for (int i7 = 0; i7 < 6 && i6 < o; i7++) {
            sb.append((char) (p.j(aVar, iArr2, i6, p.f10015d) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // com.google.zxing.t.p
    com.google.zxing.a q() {
        return com.google.zxing.a.EAN_13;
    }
}