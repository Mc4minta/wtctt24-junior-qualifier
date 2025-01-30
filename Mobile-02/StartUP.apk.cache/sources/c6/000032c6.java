package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class m5 {
    private static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private static long b(long j2, long j3, long j4) {
        long j5 = (j2 ^ j3) * j4;
        long j6 = ((j5 ^ (j5 >>> 47)) ^ j3) * j4;
        return (j6 ^ (j6 >>> 47)) * j4;
    }

    public static long c(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("Out of bound index with offput: 0 and length: ");
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int i2 = 37;
        char c2 = 0;
        if (length <= 32) {
            if (length > 16) {
                long j2 = (length << 1) - 7286425919675154353L;
                long e2 = e(bArr, 0) * (-5435081209227447693L);
                long e3 = e(bArr, 8);
                int i3 = length + 0;
                long e4 = e(bArr, i3 - 8) * j2;
                return b(Long.rotateRight(e2 + e3, 43) + Long.rotateRight(e4, 30) + (e(bArr, i3 - 16) * (-7286425919675154353L)), e2 + Long.rotateRight(e3 - 7286425919675154353L, 18) + e4, j2);
            } else if (length >= 8) {
                long j3 = (length << 1) - 7286425919675154353L;
                long e5 = e(bArr, 0) - 7286425919675154353L;
                long e6 = e(bArr, (length + 0) - 8);
                return b((Long.rotateRight(e6, 37) * j3) + e5, (Long.rotateRight(e5, 25) + e6) * j3, j3);
            } else if (length >= 4) {
                return b(length + ((a(bArr, 0) & 4294967295L) << 3), a(bArr, (length + 0) - 4) & 4294967295L, (length << 1) - 7286425919675154353L);
            } else if (length > 0) {
                long j4 = (((bArr[0] & 255) + ((bArr[(length >> 1) + 0] & 255) << 8)) * (-7286425919675154353L)) ^ ((length + ((bArr[(length - 1) + 0] & 255) << 2)) * (-4348849565147123417L));
                return (j4 ^ (j4 >>> 47)) * (-7286425919675154353L);
            } else {
                return -7286425919675154353L;
            }
        } else if (length <= 64) {
            long j5 = (length << 1) - 7286425919675154353L;
            long e7 = e(bArr, 0) * (-7286425919675154353L);
            long e8 = e(bArr, 8);
            int i4 = length + 0;
            long e9 = e(bArr, i4 - 8) * j5;
            long rotateRight = Long.rotateRight(e7 + e8, 43) + Long.rotateRight(e9, 30) + (e(bArr, i4 - 16) * (-7286425919675154353L));
            long b2 = b(rotateRight, Long.rotateRight((-7286425919675154353L) + e8, 18) + e7 + e9, j5);
            long e10 = e(bArr, 16) * j5;
            long e11 = e(bArr, 24);
            long e12 = (rotateRight + e(bArr, i4 - 32)) * j5;
            return b(Long.rotateRight(e10 + e11, 43) + Long.rotateRight(e12, 30) + ((b2 + e(bArr, i4 - 24)) * j5), e10 + Long.rotateRight(e11 + e7, 18) + e12, j5);
        } else {
            long j6 = 2480279821605975764L;
            long j7 = 1390051526045402406L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            long e13 = e(bArr, 0) + 95310865018149119L;
            int i5 = length - 1;
            int i6 = ((i5 / 64) << 6) + 0;
            int i7 = i5 & 63;
            int i8 = (i6 + i7) - 63;
            int i9 = 0;
            while (true) {
                long rotateRight2 = (Long.rotateRight(((e13 + j6) + jArr[c2]) + e(bArr, i9 + 8), i2) * (-5435081209227447693L)) ^ jArr2[1];
                long rotateRight3 = (Long.rotateRight(j6 + jArr[1] + e(bArr, i9 + 48), 42) * (-5435081209227447693L)) + jArr[0] + e(bArr, i9 + 40);
                long rotateRight4 = Long.rotateRight(j7 + jArr2[0], 33) * (-5435081209227447693L);
                int i10 = i7;
                int i11 = i6;
                d(bArr, i9, jArr[1] * (-5435081209227447693L), rotateRight2 + jArr2[0], jArr);
                d(bArr, i9 + 32, rotateRight4 + jArr2[1], rotateRight3 + e(bArr, i9 + 16), jArr2);
                int i12 = i9 + 64;
                if (i12 == i11) {
                    long j8 = ((255 & rotateRight2) << 1) - 5435081209227447693L;
                    jArr2[0] = jArr2[0] + i10;
                    jArr[0] = jArr[0] + jArr2[0];
                    jArr2[0] = jArr2[0] + jArr[0];
                    long rotateRight5 = (Long.rotateRight(((rotateRight4 + rotateRight3) + jArr[0]) + e(bArr, i8 + 8), 37) * j8) ^ (jArr2[1] * 9);
                    long rotateRight6 = (Long.rotateRight(rotateRight3 + jArr[1] + e(bArr, i8 + 48), 42) * j8) + (jArr[0] * 9) + e(bArr, i8 + 40);
                    long rotateRight7 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j8;
                    d(bArr, i8, jArr[1] * j8, rotateRight5 + jArr2[0], jArr);
                    d(bArr, i8 + 32, jArr2[1] + rotateRight7, e(bArr, i8 + 16) + rotateRight6, jArr2);
                    return b(b(jArr[0], jArr2[0], j8) + (((rotateRight6 >>> 47) ^ rotateRight6) * (-4348849565147123417L)) + rotateRight5, b(jArr[1], jArr2[1], j8) + rotateRight7, j8);
                }
                i9 = i12;
                i6 = i11;
                i7 = i10;
                j7 = rotateRight2;
                e13 = rotateRight4;
                i2 = 37;
                c2 = 0;
                j6 = rotateRight3;
            }
        }
    }

    private static void d(byte[] bArr, int i2, long j2, long j3, long[] jArr) {
        long e2 = e(bArr, i2);
        long e3 = e(bArr, i2 + 8);
        long e4 = e(bArr, i2 + 16);
        long e5 = e(bArr, i2 + 24);
        long j4 = j2 + e2;
        long j5 = e3 + j4 + e4;
        jArr[0] = j5 + e5;
        jArr[1] = Long.rotateRight(j3 + j4 + e5, 21) + Long.rotateRight(j5, 44) + j4;
    }

    private static long e(byte[] bArr, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i2, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}