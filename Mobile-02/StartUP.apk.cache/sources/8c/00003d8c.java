package com.google.zxing.v.e;

import com.google.zxing.WriterException;
import com.google.zxing.v.c.j;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: MatrixUtil.java */
/* loaded from: classes2.dex */
final class e {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f10173b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f10174c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, -1}, new int[]{6, 34, 60, 86, 112, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, -1}, new int[]{6, 30, 58, 86, 114, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, -1}, new int[]{6, 34, 62, 90, 118, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, -1}, new int[]{6, 30, 54, 78, 102, 126, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA}, new int[]{6, 24, 50, 76, 102, 128, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA}, new int[]{6, 28, 54, 80, 106, CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256}, new int[]{6, 32, 58, 84, 110, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256}, new int[]{6, 26, 54, 82, 110, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256}, new int[]{6, 30, 58, 86, 114, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f10175d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.google.zxing.q.a aVar, com.google.zxing.v.c.f fVar, j jVar, int i2, b bVar) throws WriterException {
        c(bVar);
        d(jVar, bVar);
        l(fVar, i2, bVar);
        s(jVar, bVar);
        f(aVar, i2, bVar);
    }

    static int b(int i2, int i3) {
        if (i3 != 0) {
            int n = n(i3);
            int i4 = i2 << (n - 1);
            while (n(i4) >= n) {
                i4 ^= i3 << (n(i4) - n);
            }
            return i4;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(j jVar, b bVar) throws WriterException {
        j(bVar);
        e(bVar);
        r(jVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws WriterException {
        if (bVar.b(8, bVar.d() - 8) != 0) {
            bVar.f(8, bVar.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    static void f(com.google.zxing.q.a aVar, int i2, b bVar) throws WriterException {
        boolean z;
        int e2 = bVar.e() - 1;
        int d2 = bVar.d() - 1;
        int i3 = -1;
        int i4 = 0;
        while (e2 > 0) {
            if (e2 == 6) {
                e2--;
            }
            while (d2 >= 0 && d2 < bVar.d()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = e2 - i5;
                    if (o(bVar.b(i6, d2))) {
                        if (i4 < aVar.o()) {
                            z = aVar.i(i4);
                            i4++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && d.f(i2, i6, d2)) {
                            z = !z;
                        }
                        bVar.g(i6, d2, z);
                    }
                }
                d2 += i3;
            }
            i3 = -i3;
            d2 += i3;
            e2 -= 2;
        }
        if (i4 == aVar.o()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i4 + '/' + aVar.o());
    }

    private static void g(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (o(bVar.b(i5, i3))) {
                bVar.f(i5, i3, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void h(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = f10173b[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.f(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void i(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.f(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void j(b bVar) throws WriterException {
        int length = a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i2 = 8;
        while (i2 < bVar.e() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (o(bVar.b(i2, 6))) {
                bVar.f(i2, 6, i4);
            }
            if (o(bVar.b(6, i2))) {
                bVar.f(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void l(com.google.zxing.v.c.f fVar, int i2, b bVar) throws WriterException {
        com.google.zxing.q.a aVar = new com.google.zxing.q.a();
        p(fVar, i2, aVar);
        for (int i3 = 0; i3 < aVar.o(); i3++) {
            boolean i4 = aVar.i((aVar.o() - 1) - i3);
            int[] iArr = f10175d[i3];
            bVar.g(iArr[0], iArr[1], i4);
            if (i3 < 8) {
                bVar.g((bVar.e() - i3) - 1, 8, i4);
            } else {
                bVar.g(8, (bVar.d() - 7) + (i3 - 8), i4);
            }
        }
    }

    private static void m(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (o(bVar.b(i2, i5))) {
                bVar.f(i2, i5, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    static int n(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    private static boolean o(int i2) {
        return i2 == -1;
    }

    static void p(com.google.zxing.v.c.f fVar, int i2, com.google.zxing.q.a aVar) throws WriterException {
        if (f.b(i2)) {
            int n = (fVar.n() << 3) | i2;
            aVar.d(n, 5);
            aVar.d(b(n, 1335), 10);
            com.google.zxing.q.a aVar2 = new com.google.zxing.q.a();
            aVar2.d(21522, 15);
            aVar.w(aVar2);
            if (aVar.o() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + aVar.o());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void q(j jVar, com.google.zxing.q.a aVar) throws WriterException {
        aVar.d(jVar.j(), 6);
        aVar.d(b(jVar.j(), 7973), 12);
        if (aVar.o() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.o());
    }

    private static void r(j jVar, b bVar) {
        if (jVar.j() < 2) {
            return;
        }
        int[] iArr = f10174c[jVar.j() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && o(bVar.b(i3, i2))) {
                        h(i3 - 2, i2 - 2, bVar);
                    }
                }
            }
        }
    }

    static void s(j jVar, b bVar) throws WriterException {
        if (jVar.j() < 7) {
            return;
        }
        com.google.zxing.q.a aVar = new com.google.zxing.q.a();
        q(jVar, aVar);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean i5 = aVar.i(i2);
                i2--;
                bVar.g(i3, (bVar.d() - 11) + i4, i5);
                bVar.g((bVar.d() - 11) + i4, i3, i5);
            }
        }
    }
}