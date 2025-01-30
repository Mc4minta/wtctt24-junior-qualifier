package com.google.zxing.v.c;

import com.google.zxing.v.c.j;

/* compiled from: DataBlock.java */
/* loaded from: classes2.dex */
final class b {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f10118b;

    private b(int i2, byte[] bArr) {
        this.a = i2;
        this.f10118b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, j jVar, f fVar) {
        if (bArr.length == jVar.h()) {
            j.b f2 = jVar.f(fVar);
            j.a[] a = f2.a();
            int i2 = 0;
            for (j.a aVar : a) {
                i2 += aVar.a();
            }
            b[] bVarArr = new b[i2];
            int i3 = 0;
            for (j.a aVar2 : a) {
                int i4 = 0;
                while (i4 < aVar2.a()) {
                    int b2 = aVar2.b();
                    bVarArr[i3] = new b(b2, new byte[f2.b() + b2]);
                    i4++;
                    i3++;
                }
            }
            int length = bVarArr[0].f10118b.length;
            int i5 = i2 - 1;
            while (i5 >= 0 && bVarArr[i5].f10118b.length != length) {
                i5--;
            }
            int i6 = i5 + 1;
            int b3 = length - f2.b();
            int i7 = 0;
            for (int i8 = 0; i8 < b3; i8++) {
                int i9 = 0;
                while (i9 < i3) {
                    bVarArr[i9].f10118b[i8] = bArr[i7];
                    i9++;
                    i7++;
                }
            }
            int i10 = i6;
            while (i10 < i3) {
                bVarArr[i10].f10118b[b3] = bArr[i7];
                i10++;
                i7++;
            }
            int length2 = bVarArr[0].f10118b.length;
            while (b3 < length2) {
                int i11 = 0;
                while (i11 < i3) {
                    bVarArr[i11].f10118b[i11 < i6 ? b3 : b3 + 1] = bArr[i7];
                    i11++;
                    i7++;
                }
                b3++;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f10118b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.a;
    }
}