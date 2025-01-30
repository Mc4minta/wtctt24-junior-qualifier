package com.google.zxing.t;

import com.google.zxing.NotFoundException;

/* compiled from: EAN8Reader.java */
/* loaded from: classes2.dex */
public final class f extends p {

    /* renamed from: i  reason: collision with root package name */
    private final int[] f10001i = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.t.p
    public int l(com.google.zxing.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f10001i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int o = aVar.o();
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < o; i3++) {
            sb.append((char) (p.j(aVar, iArr2, i2, p.f10015d) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int i5 = p.n(aVar, i2, true, p.f10013b)[1];
        for (int i6 = 0; i6 < 4 && i5 < o; i6++) {
            sb.append((char) (p.j(aVar, iArr2, i5, p.f10015d) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // com.google.zxing.t.p
    com.google.zxing.a q() {
        return com.google.zxing.a.EAN_8;
    }
}