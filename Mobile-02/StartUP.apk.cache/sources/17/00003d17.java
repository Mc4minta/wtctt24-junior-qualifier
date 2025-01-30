package com.google.zxing.r.b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public final class d {
    private final com.google.zxing.common.reedsolomon.c a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f9803f);

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.a();
        }
    }

    public com.google.zxing.q.e b(com.google.zxing.q.b bVar) throws FormatException, ChecksumException {
        a aVar = new a(bVar);
        b[] b2 = b.b(aVar.c(), aVar.b());
        int i2 = 0;
        for (b bVar2 : b2) {
            i2 += bVar2.c();
        }
        byte[] bArr = new byte[i2];
        int length = b2.length;
        for (int i3 = 0; i3 < length; i3++) {
            b bVar3 = b2[i3];
            byte[] a = bVar3.a();
            int c2 = bVar3.c();
            a(a, c2);
            for (int i4 = 0; i4 < c2; i4++) {
                bArr[(i4 * length) + i3] = a[i4];
            }
        }
        return c.a(bArr);
    }
}