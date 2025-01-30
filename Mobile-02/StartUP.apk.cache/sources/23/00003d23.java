package com.google.zxing.s.b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.d;
import com.google.zxing.q.e;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public final class c {
    private final com.google.zxing.common.reedsolomon.c a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f9805h);

    private void a(byte[] bArr, int i2, int i3, int i4, int i5) throws ChecksumException {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & 255;
            }
        }
        try {
            this.a.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.a();
        }
    }

    public e b(com.google.zxing.q.b bVar, Map<d, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] a = new a(bVar).a();
        a(a, 0, 10, 10, 0);
        int i2 = a[0] & 15;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            a(a, 20, 84, 40, 1);
            a(a, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (i2 == 5) {
            a(a, 20, 68, 56, 1);
            a(a, 20, 68, 56, 2);
            bArr = new byte[78];
        } else {
            throw FormatException.a();
        }
        System.arraycopy(a, 0, bArr, 0, 10);
        System.arraycopy(a, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i2);
    }
}