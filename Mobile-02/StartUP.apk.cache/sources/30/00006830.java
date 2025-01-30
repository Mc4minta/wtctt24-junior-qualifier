package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat192;

/* loaded from: classes3.dex */
public class SecT163Field {
    private static final long M35 = 34359738367L;
    private static final long M55 = 36028797018963967L;
    private static final long[] ROOT_Z = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        long[] fromBigInteger64 = Nat192.fromBigInteger64(bigInteger);
        reduce29(fromBigInteger64, 0);
        return fromBigInteger64;
    }

    protected static void implCompactExt(long[] jArr) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        jArr[0] = j2 ^ (j3 << 55);
        jArr[1] = (j3 >>> 9) ^ (j4 << 46);
        jArr[2] = (j4 >>> 18) ^ (j5 << 37);
        jArr[3] = (j5 >>> 27) ^ (j6 << 28);
        jArr[4] = (j6 >>> 36) ^ (j7 << 19);
        jArr[5] = j7 >>> 45;
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = (jArr[2] << 18) ^ (j3 >>> 46);
        long j5 = ((j3 << 9) ^ (j2 >>> 55)) & M55;
        long j6 = j2 & M55;
        long j7 = jArr2[0];
        long j8 = jArr2[1];
        long j9 = (j8 >>> 46) ^ (jArr2[2] << 18);
        long j10 = ((j7 >>> 55) ^ (j8 << 9)) & M55;
        long j11 = j7 & M55;
        long[] jArr4 = new long[10];
        implMulw(j6, j11, jArr4, 0);
        implMulw(j4, j9, jArr4, 2);
        long j12 = (j6 ^ j5) ^ j4;
        long j13 = (j11 ^ j10) ^ j9;
        implMulw(j12, j13, jArr4, 4);
        long j14 = (j5 << 1) ^ (j4 << 2);
        long j15 = (j10 << 1) ^ (j9 << 2);
        implMulw(j6 ^ j14, j11 ^ j15, jArr4, 6);
        implMulw(j12 ^ j14, j13 ^ j15, jArr4, 8);
        long j16 = jArr4[6] ^ jArr4[8];
        long j17 = jArr4[7] ^ jArr4[9];
        long j18 = (j16 << 1) ^ jArr4[6];
        long j19 = (j16 ^ (j17 << 1)) ^ jArr4[7];
        long j20 = jArr4[0];
        long j21 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j22 = jArr4[1] ^ jArr4[5];
        long j23 = ((j18 ^ j20) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j24 = (((j19 ^ j21) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j23 >>> 55);
        long j25 = j23 & M55;
        long j26 = (j22 ^ j17) ^ (j24 >>> 55);
        long j27 = j24 & M55;
        long j28 = (j25 >>> 1) ^ ((j27 & 1) << 54);
        long j29 = j28 ^ (j28 << 1);
        long j30 = j29 ^ (j29 << 2);
        long j31 = j30 ^ (j30 << 4);
        long j32 = j31 ^ (j31 << 8);
        long j33 = j32 ^ (j32 << 16);
        long j34 = (j33 ^ (j33 << 32)) & M55;
        long j35 = ((j27 >>> 1) ^ ((j26 & 1) << 54)) ^ (j34 >>> 54);
        long j36 = j35 ^ (j35 << 1);
        long j37 = j36 ^ (j36 << 2);
        long j38 = j37 ^ (j37 << 4);
        long j39 = j38 ^ (j38 << 8);
        long j40 = j39 ^ (j39 << 16);
        long j41 = (j40 ^ (j40 << 32)) & M55;
        long j42 = (j26 >>> 1) ^ (j41 >>> 54);
        long j43 = j42 ^ (j42 << 1);
        long j44 = j43 ^ (j43 << 2);
        long j45 = j44 ^ (j44 << 4);
        long j46 = j45 ^ (j45 << 8);
        long j47 = j46 ^ (j46 << 16);
        long j48 = j47 ^ (j47 << 32);
        jArr3[0] = j20;
        jArr3[1] = (j21 ^ j34) ^ jArr4[2];
        jArr3[2] = ((j22 ^ j41) ^ j34) ^ jArr4[3];
        jArr3[3] = j48 ^ j41;
        jArr3[4] = jArr4[2] ^ j48;
        jArr3[5] = jArr4[3];
        implCompactExt(jArr3);
    }

    protected static void implMulw(long j2, long j3, long[] jArr, int i2) {
        long[] jArr2 = {0, j3, jArr2[1] << 1, jArr2[2] ^ j3, jArr2[2] << 1, jArr2[4] ^ j3, jArr2[3] << 1, jArr2[6] ^ j3};
        long j4 = jArr2[((int) j2) & 3];
        long j5 = 0;
        int i3 = 47;
        do {
            int i4 = (int) (j2 >>> i3);
            long j6 = (jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6);
            j4 ^= j6 << i3;
            j5 ^= j6 >>> (-i3);
            i3 -= 9;
        } while (i3 > 0);
        jArr[i2] = M55 & j4;
        jArr[i2 + 1] = (j4 >>> 55) ^ (j5 << 9);
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr[0], jArr2, 0);
        Interleave.expand64To128(jArr[1], jArr2, 2);
        long j2 = jArr[2];
        jArr2[4] = Interleave.expand32to64((int) j2);
        jArr2[5] = Interleave.expand8to16((int) (j2 >>> 32)) & 4294967295L;
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat192.isZero64(jArr)) {
            long[] create64 = Nat192.create64();
            long[] create642 = Nat192.create64();
            square(jArr, create64);
            squareN(create64, 1, create642);
            multiply(create64, create642, create64);
            squareN(create642, 1, create642);
            multiply(create64, create642, create64);
            squareN(create64, 3, create642);
            multiply(create64, create642, create64);
            squareN(create642, 3, create642);
            multiply(create64, create642, create64);
            squareN(create64, 9, create642);
            multiply(create64, create642, create64);
            squareN(create642, 9, create642);
            multiply(create64, create642, create64);
            squareN(create64, 27, create642);
            multiply(create64, create642, create64);
            squareN(create642, 27, create642);
            multiply(create64, create642, create64);
            squareN(create64, 81, create642);
            multiply(create64, create642, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat192.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat192.createExt64();
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
        long j8 = j5 ^ ((((j7 >>> 35) ^ (j7 >>> 32)) ^ (j7 >>> 29)) ^ (j7 >>> 28));
        long j9 = j3 ^ ((((j6 << 29) ^ (j6 << 32)) ^ (j6 << 35)) ^ (j6 << 36));
        long j10 = (j4 ^ ((((j7 << 29) ^ (j7 << 32)) ^ (j7 << 35)) ^ (j7 << 36))) ^ ((j6 >>> 28) ^ (((j6 >>> 35) ^ (j6 >>> 32)) ^ (j6 >>> 29)));
        long j11 = j2 ^ ((((j8 << 29) ^ (j8 << 32)) ^ (j8 << 35)) ^ (j8 << 36));
        long j12 = j9 ^ ((j8 >>> 28) ^ (((j8 >>> 35) ^ (j8 >>> 32)) ^ (j8 >>> 29)));
        long j13 = j10 >>> 35;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 3)) ^ (j13 << 6)) ^ (j13 << 7);
        jArr2[1] = j12;
        jArr2[2] = M35 & j10;
    }

    public static void reduce29(long[] jArr, int i2) {
        int i3 = i2 + 2;
        long j2 = jArr[i3];
        long j3 = j2 >>> 35;
        jArr[i2] = ((j3 << 7) ^ (((j3 << 3) ^ j3) ^ (j3 << 6))) ^ jArr[i2];
        jArr[i3] = j2 & M35;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat192.create64();
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        create64[0] = (unshuffle >>> 32) | (unshuffle2 & (-4294967296L));
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long j2 = unshuffle3 & 4294967295L;
        create64[1] = unshuffle3 >>> 32;
        multiply(create64, ROOT_Z, jArr2);
        jArr2[0] = jArr2[0] ^ ((unshuffle & 4294967295L) | (unshuffle2 << 32));
        jArr2[1] = jArr2[1] ^ j2;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
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
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }
}