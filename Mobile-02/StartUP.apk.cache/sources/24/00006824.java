package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat128;

/* loaded from: classes3.dex */
public class SecT113Field {
    private static final long M49 = 562949953421311L;
    private static final long M57 = 144115188075855871L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        long[] fromBigInteger64 = Nat128.fromBigInteger64(bigInteger);
        reduce15(fromBigInteger64, 0);
        return fromBigInteger64;
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long j2 = jArr[0];
        long j3 = ((jArr[1] << 7) ^ (j2 >>> 57)) & M57;
        long j4 = j2 & M57;
        long j5 = jArr2[0];
        long j6 = ((jArr2[1] << 7) ^ (j5 >>> 57)) & M57;
        long j7 = M57 & j5;
        long[] jArr4 = new long[6];
        implMulw(j4, j7, jArr4, 0);
        implMulw(j3, j6, jArr4, 2);
        implMulw(j4 ^ j3, j7 ^ j6, jArr4, 4);
        long j8 = jArr4[1] ^ jArr4[2];
        long j9 = jArr4[0];
        long j10 = jArr4[3];
        long j11 = (jArr4[4] ^ j9) ^ j8;
        long j12 = j8 ^ (jArr4[5] ^ j10);
        jArr3[0] = j9 ^ (j11 << 57);
        jArr3[1] = (j11 >>> 7) ^ (j12 << 50);
        jArr3[2] = (j12 >>> 14) ^ (j10 << 43);
        jArr3[3] = j10 >>> 21;
    }

    protected static void implMulw(long j2, long j3, long[] jArr, int i2) {
        long[] jArr2 = {0, j3, jArr2[1] << 1, jArr2[2] ^ j3, jArr2[2] << 1, jArr2[4] ^ j3, jArr2[3] << 1, jArr2[6] ^ j3};
        long j4 = jArr2[((int) j2) & 7];
        long j5 = 0;
        int i3 = 48;
        do {
            int i4 = (int) (j2 >>> i3);
            long j6 = (jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6);
            j4 ^= j6 << i3;
            j5 ^= j6 >>> (-i3);
            i3 -= 9;
        } while (i3 > 0);
        jArr[i2] = M57 & j4;
        jArr[i2 + 1] = (((((j2 & 72198606942111744L) & ((j3 << 7) >> 63)) >>> 8) ^ j5) << 7) ^ (j4 >>> 57);
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr[0], jArr2, 0);
        Interleave.expand64To128(jArr[1], jArr2, 2);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat128.isZero64(jArr)) {
            long[] create64 = Nat128.create64();
            long[] create642 = Nat128.create64();
            square(jArr, create64);
            multiply(create64, jArr, create64);
            square(create64, create64);
            multiply(create64, jArr, create64);
            squareN(create64, 3, create642);
            multiply(create642, create64, create642);
            square(create642, create642);
            multiply(create642, jArr, create642);
            squareN(create642, 7, create64);
            multiply(create64, create642, create64);
            squareN(create64, 14, create642);
            multiply(create642, create64, create642);
            squareN(create642, 28, create64);
            multiply(create64, create642, create64);
            squareN(create64, 56, create642);
            multiply(create642, create64, create642);
            square(create642, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat128.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat128.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = j4 ^ ((j5 >>> 40) ^ (j5 >>> 49));
        long j7 = j2 ^ ((j6 << 15) ^ (j6 << 24));
        long j8 = (j3 ^ ((j5 << 15) ^ (j5 << 24))) ^ ((j6 >>> 40) ^ (j6 >>> 49));
        long j9 = j8 >>> 49;
        jArr2[0] = (j7 ^ j9) ^ (j9 << 9);
        jArr2[1] = M49 & j8;
    }

    public static void reduce15(long[] jArr, int i2) {
        int i3 = i2 + 1;
        long j2 = jArr[i3];
        long j3 = j2 >>> 49;
        jArr[i2] = (j3 ^ (j3 << 9)) ^ jArr[i2];
        jArr[i3] = j2 & M49;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j2 = (unshuffle >>> 32) | (unshuffle2 & (-4294967296L));
        jArr2[0] = ((j2 << 57) ^ ((4294967295L & unshuffle) | (unshuffle2 << 32))) ^ (j2 << 5);
        jArr2[1] = (j2 >>> 59) ^ (j2 >>> 7);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
        }
    }

    public static int trace(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}