package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;

/* loaded from: classes3.dex */
public class SecT239Field {
    private static final long M47 = 140737488355327L;
    private static final long M60 = 1152921504606846975L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        long[] fromBigInteger64 = Nat256.fromBigInteger64(bigInteger);
        reduce17(fromBigInteger64, 0);
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
        jArr[0] = j2 ^ (j3 << 60);
        jArr[1] = (j3 >>> 4) ^ (j4 << 56);
        jArr[2] = (j4 >>> 8) ^ (j5 << 52);
        jArr[3] = (j5 >>> 12) ^ (j6 << 48);
        jArr[4] = (j6 >>> 16) ^ (j7 << 44);
        jArr[5] = (j7 >>> 20) ^ (j8 << 40);
        jArr[6] = (j8 >>> 24) ^ (j9 << 36);
        jArr[7] = j9 >>> 28;
    }

    protected static void implExpand(long[] jArr, long[] jArr2) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        jArr2[0] = j2 & M60;
        jArr2[1] = ((j2 >>> 60) ^ (j3 << 4)) & M60;
        jArr2[2] = ((j3 >>> 56) ^ (j4 << 8)) & M60;
        jArr2[3] = (j4 >>> 52) ^ (j5 << 12);
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        implExpand(jArr, jArr4);
        implExpand(jArr2, jArr5);
        implMulwAcc(jArr4[0], jArr5[0], jArr3, 0);
        implMulwAcc(jArr4[1], jArr5[1], jArr3, 1);
        implMulwAcc(jArr4[2], jArr5[2], jArr3, 2);
        implMulwAcc(jArr4[3], jArr5[3], jArr3, 3);
        for (int i2 = 5; i2 > 0; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 1];
        }
        implMulwAcc(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        implMulwAcc(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i3 = 7; i3 > 1; i3--) {
            jArr3[i3] = jArr3[i3] ^ jArr3[i3 - 2];
        }
        long j2 = jArr4[0] ^ jArr4[2];
        long j3 = jArr4[1] ^ jArr4[3];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr5[1] ^ jArr5[3];
        implMulwAcc(j2 ^ j3, j4 ^ j5, jArr3, 3);
        long[] jArr6 = new long[3];
        implMulwAcc(j2, j4, jArr6, 0);
        implMulwAcc(j3, j5, jArr6, 1);
        long j6 = jArr6[0];
        long j7 = jArr6[1];
        long j8 = jArr6[2];
        jArr3[2] = jArr3[2] ^ j6;
        jArr3[3] = (j6 ^ j7) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j8 ^ j7);
        jArr3[5] = jArr3[5] ^ j8;
        implCompactExt(jArr3);
    }

    protected static void implMulwAcc(long j2, long j3, long[] jArr, int i2) {
        long[] jArr2 = {0, j3, jArr2[1] << 1, jArr2[2] ^ j3, jArr2[2] << 1, jArr2[4] ^ j3, jArr2[3] << 1, jArr2[6] ^ j3};
        int i3 = (int) j2;
        long j4 = (jArr2[(i3 >>> 3) & 7] << 3) ^ jArr2[i3 & 7];
        long j5 = 0;
        int i4 = 54;
        do {
            int i5 = (int) (j2 >>> i4);
            long j6 = jArr2[i5 & 7] ^ (jArr2[(i5 >>> 3) & 7] << 3);
            j4 ^= j6 << i4;
            j5 ^= j6 >>> (-i4);
            i4 -= 6;
        } while (i4 > 0);
        jArr[i2] = jArr[i2] ^ (M60 & j4);
        int i6 = i2 + 1;
        jArr[i6] = ((((((j2 & 585610922974906400L) & ((j3 << 4) >> 63)) >>> 5) ^ j5) << 4) ^ (j4 >>> 60)) ^ jArr[i6];
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr[0], jArr2, 0);
        Interleave.expand64To128(jArr[1], jArr2, 2);
        Interleave.expand64To128(jArr[2], jArr2, 4);
        long j2 = jArr[3];
        jArr2[6] = Interleave.expand32to64((int) j2);
        jArr2[7] = Interleave.expand16to32((int) (j2 >>> 32)) & 4294967295L;
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat256.isZero64(jArr)) {
            long[] create64 = Nat256.create64();
            long[] create642 = Nat256.create64();
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
            square(create642, create642);
            multiply(create642, jArr, create642);
            squareN(create642, 29, create64);
            multiply(create64, create642, create64);
            square(create64, create64);
            multiply(create64, jArr, create64);
            squareN(create64, 59, create642);
            multiply(create642, create64, create642);
            square(create642, create642);
            multiply(create642, jArr, create642);
            squareN(create642, 119, create64);
            multiply(create64, create642, create64);
            square(create64, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat256.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat256.createExt64();
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
        long j10 = j8 ^ (j9 >>> 17);
        long j11 = (j7 ^ (j9 << 47)) ^ (j10 >>> 17);
        long j12 = ((j6 ^ (j9 >>> 47)) ^ (j10 << 47)) ^ (j11 >>> 17);
        long j13 = j2 ^ (j12 << 17);
        long j14 = (j3 ^ (j11 << 17)) ^ (j12 >>> 47);
        long j15 = (((j5 ^ (j9 << 17)) ^ (j10 >>> 47)) ^ (j11 << 47)) ^ (j12 >>> 17);
        long j16 = j15 >>> 47;
        jArr2[0] = j13 ^ j16;
        jArr2[1] = j14;
        long j17 = j16 << 30;
        jArr2[2] = j17 ^ (((j4 ^ (j10 << 17)) ^ (j11 >>> 47)) ^ (j12 << 47));
        jArr2[3] = M47 & j15;
    }

    public static void reduce17(long[] jArr, int i2) {
        int i3 = i2 + 3;
        long j2 = jArr[i3];
        long j3 = j2 >>> 47;
        jArr[i2] = jArr[i2] ^ j3;
        int i4 = i2 + 2;
        jArr[i4] = (j3 << 30) ^ jArr[i4];
        jArr[i3] = j2 & M47;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        int i2 = 0;
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j2 = (unshuffle & 4294967295L) | (unshuffle2 << 32);
        long j3 = (unshuffle >>> 32) | (unshuffle2 & (-4294967296L));
        int i3 = 2;
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long unshuffle4 = Interleave.unshuffle(jArr[3]);
        long j4 = (unshuffle3 & 4294967295L) | (unshuffle4 << 32);
        long j5 = (unshuffle4 & (-4294967296L)) | (unshuffle3 >>> 32);
        long j6 = j5 >>> 49;
        long j7 = (j3 >>> 49) | (j5 << 15);
        long j8 = j5 ^ (j3 << 15);
        long[] createExt64 = Nat256.createExt64();
        int[] iArr = {39, 120};
        while (i2 < i3) {
            int i4 = iArr[i2] >>> 6;
            int i5 = iArr[i2] & 63;
            createExt64[i4] = createExt64[i4] ^ (j3 << i5);
            int i6 = i4 + 1;
            int[] iArr2 = iArr;
            int i7 = -i5;
            createExt64[i6] = createExt64[i6] ^ ((j8 << i5) | (j3 >>> i7));
            int i8 = i4 + 2;
            createExt64[i8] = createExt64[i8] ^ ((j7 << i5) | (j8 >>> i7));
            int i9 = i4 + 3;
            createExt64[i9] = createExt64[i9] ^ ((j6 << i5) | (j7 >>> i7));
            int i10 = i4 + 4;
            createExt64[i10] = createExt64[i10] ^ (j6 >>> i7);
            i2++;
            i3 = 2;
            iArr = iArr2;
        }
        reduce(createExt64, jArr2);
        jArr2[0] = jArr2[0] ^ j2;
        jArr2[1] = jArr2[1] ^ j4;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] createExt64 = Nat256.createExt64();
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
        return ((int) ((jArr[0] ^ (jArr[1] >>> 17)) ^ (jArr[2] >>> 34))) & 1;
    }
}