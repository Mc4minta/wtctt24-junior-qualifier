package com.google.zxing.v.c;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public final class e {
    private final com.google.zxing.common.reedsolomon.c a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f9802e);

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

    private com.google.zxing.q.e c(a aVar, Map<com.google.zxing.d, ?> map) throws FormatException, ChecksumException {
        j e2 = aVar.e();
        f d2 = aVar.d().d();
        b[] b2 = b.b(aVar.c(), e2, d2);
        int i2 = 0;
        for (b bVar : b2) {
            i2 += bVar.c();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (b bVar2 : b2) {
            byte[] a = bVar2.a();
            int c2 = bVar2.c();
            a(a, c2);
            int i4 = 0;
            while (i4 < c2) {
                bArr[i3] = a[i4];
                i4++;
                i3++;
            }
        }
        return d.a(bArr, e2, d2, map);
    }

    public com.google.zxing.q.e b(com.google.zxing.q.b bVar, Map<com.google.zxing.d, ?> map) throws FormatException, ChecksumException {
        ChecksumException e2;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return c(aVar, map);
        } catch (ChecksumException e3) {
            e2 = e3;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                com.google.zxing.q.e c2 = c(aVar, map);
                c2.m(new i(true));
                return c2;
            } catch (ChecksumException | FormatException e4) {
                if (formatException == null) {
                    if (e2 != null) {
                        throw e2;
                    }
                    throw e4;
                }
                throw formatException;
            }
        } catch (FormatException e5) {
            e2 = null;
            formatException = e5;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            com.google.zxing.q.e c22 = c(aVar, map);
            c22.m(new i(true));
            return c22;
        }
    }
}