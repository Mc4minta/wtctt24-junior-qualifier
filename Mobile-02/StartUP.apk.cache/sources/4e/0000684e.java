package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat448;

/* loaded from: classes3.dex */
public class SecT409Field {
    private static final long M25 = 33554431;
    private static final long M59 = 576460752303423487L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 13; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        long[] fromBigInteger64 = Nat448.fromBigInteger64(bigInteger);
        reduce39(fromBigInteger64, 0);
        return fromBigInteger64;
    }

    protected static void implCompactExt(long[] jArr) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        long j8 = jArr[6];
        long j9 = jArr[7];
        long j10 = jArr[8];
        long j11 = jArr[9];
        long j12 = jArr[10];
        long j13 = jArr[11];
        long j14 = jArr[12];
        long j15 = jArr[13];
        jArr[0] = j2 ^ (j3 << 59);
        jArr[1] = (j3 >>> 5) ^ (j4 << 54);
        jArr[2] = (j4 >>> 10) ^ (j5 << 49);
        jArr[3] = (j5 >>> 15) ^ (j6 << 44);
        jArr[4] = (j6 >>> 20) ^ (j7 << 39);
        jArr[5] = (j7 >>> 25) ^ (j8 << 34);
        jArr[6] = (j8 >>> 30) ^ (j9 << 29);
        jArr[7] = (j9 >>> 35) ^ (j10 << 24);
        jArr[8] = (j10 >>> 40) ^ (j11 << 19);
        jArr[9] = (j11 >>> 45) ^ (j12 << 14);
        jArr[10] = (j12 >>> 50) ^ (j13 << 9);
        jArr[11] = ((j13 >>> 55) ^ (j14 << 4)) ^ (j15 << 63);
        jArr[12] = (j14 >>> 60) ^ (j15 >>> 1);
        jArr[13] = 0;
    }

    protected static void implExpand(long[] jArr, long[] jArr2) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        long j8 = jArr[6];
        jArr2[0] = j2 & M59;
        jArr2[1] = ((j2 >>> 59) ^ (j3 << 5)) & M59;
        jArr2[2] = ((j3 >>> 54) ^ (j4 << 10)) & M59;
        jArr2[3] = ((j4 >>> 49) ^ (j5 << 15)) & M59;
        jArr2[4] = ((j5 >>> 44) ^ (j6 << 20)) & M59;
        jArr2[5] = ((j6 >>> 39) ^ (j7 << 25)) & M59;
        jArr2[6] = (j7 >>> 34) ^ (j8 << 30);
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        implExpand(jArr, jArr4);
        implExpand(jArr2, jArr5);
        for (int i2 = 0; i2 < 7; i2++) {
            implMulwAcc(jArr4, jArr5[i2], jArr3, i2);
        }
        implCompactExt(jArr3);
    }

    protected static void implMulwAcc(long[] jArr, long j2, long[] jArr2, int i2) {
        long[] jArr3 = {0, j2, jArr3[1] << 1, jArr3[2] ^ j2, jArr3[2] << 1, jArr3[4] ^ j2, jArr3[3] << 1, jArr3[6] ^ j2};
        for (int i3 = 0; i3 < 7; i3++) {
            long j3 = jArr[i3];
            int i4 = (int) j3;
            long j4 = 0;
            long j5 = jArr3[i4 & 7] ^ (jArr3[(i4 >>> 3) & 7] << 3);
            int i5 = 54;
            do {
                int i6 = (int) (j3 >>> i5);
                long j6 = jArr3[i6 & 7] ^ (jArr3[(i6 >>> 3) & 7] << 3);
                j5 ^= j6 << i5;
                j4 ^= j6 >>> (-i5);
                i5 -= 6;
            } while (i5 > 0);
            int i7 = i2 + i3;
            jArr2[i7] = jArr2[i7] ^ (M59 & j5);
            int i8 = i7 + 1;
            jArr2[i8] = jArr2[i8] ^ ((j4 << 5) ^ (j5 >>> 59));
        }
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < 6; i2++) {
            Interleave.expand64To128(jArr[i2], jArr2, i2 << 1);
        }
        jArr2[12] = Interleave.expand32to64((int) jArr[6]);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat448.isZero64(jArr)) {
            long[] create64 = Nat448.create64();
            long[] create642 = Nat448.create64();
            long[] create643 = Nat448.create64();
            square(jArr, create64);
            squareN(create64, 1, create642);
            multiply(create64, create642, create64);
            squareN(create642, 1, create642);
            multiply(create64, create642, create64);
            squareN(create64, 3, create642);
            multiply(create64, create642, create64);
            squareN(create64, 6, create642);
            multiply(create64, create642, create64);
            squareN(create64, 12, create642);
            multiply(create64, create642, create643);
            squareN(create643, 24, create64);
            squareN(create64, 24, create642);
            multiply(create64, create642, create64);
            squareN(create64, 48, create642);
            multiply(create64, create642, create64);
            squareN(create64, 96, create642);
            multiply(create64, create642, create64);
            squareN(create64, 192, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat448.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat448.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        long j8 = jArr[6];
        long j9 = jArr[7];
        long j10 = jArr[12];
        long j11 = j8 ^ ((j10 >>> 25) ^ (j10 << 62));
        long j12 = j9 ^ (j10 >>> 2);
        long j13 = jArr[11];
        long j14 = j6 ^ (j13 << 39);
        long j15 = (j7 ^ (j10 << 39)) ^ ((j13 >>> 25) ^ (j13 << 62));
        long j16 = j11 ^ (j13 >>> 2);
        long j17 = jArr[10];
        long j18 = j5 ^ (j17 << 39);
        long j19 = j14 ^ ((j17 >>> 25) ^ (j17 << 62));
        long j20 = j15 ^ (j17 >>> 2);
        long j21 = jArr[9];
        long j22 = j4 ^ (j21 << 39);
        long j23 = j18 ^ ((j21 >>> 25) ^ (j21 << 62));
        long j24 = j19 ^ (j21 >>> 2);
        long j25 = jArr[8];
        long j26 = j2 ^ (j12 << 39);
        long j27 = (j22 ^ ((j25 >>> 25) ^ (j25 << 62))) ^ (j12 >>> 2);
        long j28 = j16 >>> 25;
        jArr2[0] = j26 ^ j28;
        long j29 = j28 << 23;
        jArr2[1] = j29 ^ ((j3 ^ (j25 << 39)) ^ ((j12 >>> 25) ^ (j12 << 62)));
        jArr2[2] = j27;
        jArr2[3] = j23 ^ (j25 >>> 2);
        jArr2[4] = j24;
        jArr2[5] = j20;
        jArr2[6] = j16 & M25;
    }

    public static void reduce39(long[] jArr, int i2) {
        int i3 = i2 + 6;
        long j2 = jArr[i3];
        long j3 = j2 >>> 25;
        jArr[i2] = jArr[i2] ^ j3;
        int i4 = i2 + 1;
        jArr[i4] = (j3 << 23) ^ jArr[i4];
        jArr[i3] = j2 & M25;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j2 = (unshuffle & 4294967295L) | (unshuffle2 << 32);
        long j3 = (unshuffle >>> 32) | (unshuffle2 & (-4294967296L));
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long unshuffle4 = Interleave.unshuffle(jArr[3]);
        long j4 = (unshuffle3 & 4294967295L) | (unshuffle4 << 32);
        long j5 = (unshuffle3 >>> 32) | (unshuffle4 & (-4294967296L));
        long unshuffle5 = Interleave.unshuffle(jArr[4]);
        long unshuffle6 = Interleave.unshuffle(jArr[5]);
        long j6 = (unshuffle5 >>> 32) | (unshuffle6 & (-4294967296L));
        long unshuffle7 = Interleave.unshuffle(jArr[6]);
        long j7 = unshuffle7 & 4294967295L;
        long j8 = unshuffle7 >>> 32;
        jArr2[0] = j2 ^ (j3 << 44);
        jArr2[1] = (j4 ^ (j5 << 44)) ^ (j3 >>> 20);
        jArr2[2] = (((unshuffle5 & 4294967295L) | (unshuffle6 << 32)) ^ (j6 << 44)) ^ (j5 >>> 20);
        jArr2[3] = (((j8 << 44) ^ j7) ^ (j6 >>> 20)) ^ (j3 << 13);
        jArr2[4] = (j3 >>> 51) ^ ((j8 >>> 20) ^ (j5 << 13));
        jArr2[5] = (j6 << 13) ^ (j5 >>> 51);
        jArr2[6] = (j8 << 13) ^ (j6 >>> 51);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        reduce(create64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        addExt(jArr2, create64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        reduce(create64, jArr2);
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            implSquare(jArr2, create64);
            reduce(create64, jArr2);
        }
    }

    public static int trace(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}