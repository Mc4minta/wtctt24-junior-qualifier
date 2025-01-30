package com.google.zxing.r.b;

import com.google.zxing.r.b.e;

/* compiled from: DataBlock.java */
/* loaded from: classes2.dex */
final class b {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f9960b;

    private b(int i2, byte[] bArr) {
        this.a = i2;
        this.f9960b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, e eVar) {
        e.c d2 = eVar.d();
        e.b[] a = d2.a();
        int i2 = 0;
        for (e.b bVar : a) {
            i2 += bVar.a();
        }
        b[] bVarArr = new b[i2];
        int i3 = 0;
        for (e.b bVar2 : a) {
            int i4 = 0;
            while (i4 < bVar2.a()) {
                int b2 = bVar2.b();
                bVarArr[i3] = new b(b2, new byte[d2.b() + b2]);
                i4++;
                i3++;
            }
        }
        int length = bVarArr[0].f9960b.length - d2.b();
        int i5 = length - 1;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = 0;
            while (i8 < i3) {
                bVarArr[i8].f9960b[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        boolean z = eVar.i() == 24;
        int i9 = z ? 8 : i3;
        int i10 = 0;
        while (i10 < i9) {
            bVarArr[i10].f9960b[i5] = bArr[i6];
            i10++;
            i6++;
        }
        int length2 = bVarArr[0].f9960b.length;
        while (length < length2) {
            int i11 = 0;
            while (i11 < i3) {
                int i12 = z ? (i11 + 8) % i3 : i11;
                bVarArr[i12].f9960b[(!z || i12 <= 7) ? length : length - 1] = bArr[i6];
                i11++;
                i6++;
            }
            length++;
        }
        if (i6 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f9960b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.a;
    }
}