package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat576;

/* loaded from: classes3.dex */
public class SecT571Field {
    private static final long M59 = 576460752303423487L;
    private static final long RM = -1190112520884487202L;
    private static final long[] ROOT_Z = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 9; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }

    private static void addBothTo(long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        for (int i5 = 0; i5 < 9; i5++) {
            int i6 = i4 + i5;
            jArr3[i6] = jArr3[i6] ^ (jArr[i2 + i5] ^ jArr2[i3 + i5]);
        }
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 18; i2++) {
            jArr3[i2] = jArr[i2] ^ jArr2[i2];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i2 = 1; i2 < 9; i2++) {
            jArr2[i2] = jArr[i2];
        }
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        long[] fromBigInteger64 = Nat576.fromBigInteger64(bigInteger);
        reduce5(fromBigInteger64, 0);
        return fromBigInteger64;
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA];
        System.arraycopy(jArr2, 0, jArr4, 9, 9);
        int i2 = 7;
        int i3 = 0;
        while (i2 > 0) {
            int i4 = i3 + 18;
            Nat.shiftUpBit64(9, jArr4, i4 >>> 1, 0L, jArr4, i4);
            reduce5(jArr4, i4);
            add(jArr4, 9, jArr4, i4, jArr4, i4 + 9);
            i2--;
            i3 = i4;
        }
        long[] jArr5 = new long[CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA];
        Nat.shiftUpBits64(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, jArr4, 0, 4, 0L, jArr5, 0);
        for (int i5 = 56; i5 >= 0; i5 -= 8) {
            for (int i6 = 1; i6 < 9; i6 += 2) {
                int i7 = (int) (jArr[i6] >>> i5);
                addBothTo(jArr4, (i7 & 15) * 9, jArr5, ((i7 >>> 4) & 15) * 9, jArr3, i6 - 1);
            }
            Nat.shiftUpBits64(16, jArr3, 0, 8, 0L);
        }
        for (int i8 = 56; i8 >= 0; i8 -= 8) {
            for (int i9 = 0; i9 < 9; i9 += 2) {
                int i10 = (int) (jArr[i9] >>> i8);
                addBothTo(jArr4, (i10 & 15) * 9, jArr5, ((i10 >>> 4) & 15) * 9, jArr3, i9);
            }
            if (i8 > 0) {
                Nat.shiftUpBits64(18, jArr3, 0, 8, 0L);
            }
        }
    }

    protected static void implMulwAcc(long[] jArr, long j2, long[] jArr2, int i2) {
        long[] jArr3 = new long[32];
        jArr3[1] = j2;
        for (int i3 = 2; i3 < 32; i3 += 2) {
            jArr3[i3] = jArr3[i3 >>> 1] << 1;
            jArr3[i3 + 1] = jArr3[i3] ^ j2;
        }
        int i4 = 0;
        long j3 = 0;
        while (i4 < 9) {
            long j4 = jArr[i4];
            long j5 = j3 ^ jArr3[((int) j4) & 31];
            int i5 = 60;
            long j6 = 0;
            do {
                long j7 = jArr3[((int) (j4 >>> i5)) & 31];
                j5 ^= j7 << i5;
                j6 ^= j7 >>> (-i5);
                i5 -= 5;
            } while (i5 > 0);
            for (int i6 = 0; i6 < 4; i6++) {
                j4 = (j4 & RM) >>> 1;
                j6 ^= ((j2 << i6) >> 63) & j4;
            }
            int i7 = i2 + i4;
            jArr2[i7] = j5 ^ jArr2[i7];
            i4++;
            j3 = j6;
        }
        int i8 = i2 + 9;
        jArr2[i8] = jArr2[i8] ^ j3;
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < 9; i2++) {
            Interleave.expand64To128(jArr[i2], jArr2, i2 << 1);
        }
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat576.isZero64(jArr)) {
            long[] create64 = Nat576.create64();
            long[] create642 = Nat576.create64();
            long[] create643 = Nat576.create64();
            square(jArr, create643);
            square(create643, create64);
            square(create64, create642);
            multiply(create64, create642, create64);
            squareN(create64, 2, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, create64);
            squareN(create64, 5, create642);
            multiply(create64, create642, create64);
            squareN(create642, 5, create642);
            multiply(create64, create642, create64);
            squareN(create64, 15, create642);
            multiply(create64, create642, create643);
            squareN(create643, 30, create64);
            squareN(create64, 30, create642);
            multiply(create64, create642, create64);
            squareN(create64, 60, create642);
            multiply(create64, create642, create64);
            squareN(create642, 60, create642);
            multiply(create64, create642, create64);
            squareN(create64, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, create642);
            multiply(create64, create642, create64);
            squareN(create642, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j2 = jArr[9];
        long j3 = jArr[17];
        long j4 = (((j2 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
        long j5 = (j3 << 15) ^ (((jArr[8] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10));
        for (int i2 = 16; i2 >= 10; i2--) {
            long j6 = jArr[i2];
            jArr2[i2 - 8] = (((j5 ^ (j6 >>> 59)) ^ (j6 >>> 57)) ^ (j6 >>> 54)) ^ (j6 >>> 49);
            j5 = (((jArr[i2 - 9] ^ (j6 << 5)) ^ (j6 << 7)) ^ (j6 << 10)) ^ (j6 << 15);
        }
        jArr2[1] = (((j5 ^ (j4 >>> 59)) ^ (j4 >>> 57)) ^ (j4 >>> 54)) ^ (j4 >>> 49);
        long j7 = (j4 << 15) ^ (((jArr[0] ^ (j4 << 5)) ^ (j4 << 7)) ^ (j4 << 10));
        long j8 = jArr2[8];
        long j9 = j8 >>> 59;
        jArr2[0] = (((j7 ^ j9) ^ (j9 << 2)) ^ (j9 << 5)) ^ (j9 << 10);
        jArr2[8] = M59 & j8;
    }

    public static void reduce5(long[] jArr, int i2) {
        int i3 = i2 + 8;
        long j2 = jArr[i3];
        long j3 = j2 >>> 59;
        jArr[i2] = ((j3 << 10) ^ (((j3 << 2) ^ j3) ^ (j3 << 5))) ^ jArr[i2];
        jArr[i3] = j2 & M59;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat576.create64();
        long[] create642 = Nat576.create64();
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i2 + 1;
            long unshuffle = Interleave.unshuffle(jArr[i2]);
            i2 = i4 + 1;
            long unshuffle2 = Interleave.unshuffle(jArr[i4]);
            create64[i3] = (4294967295L & unshuffle) | (unshuffle2 << 32);
            create642[i3] = (unshuffle >>> 32) | ((-4294967296L) & unshuffle2);
        }
        long unshuffle3 = Interleave.unshuffle(jArr[i2]);
        create64[4] = 4294967295L & unshuffle3;
        create642[4] = unshuffle3 >>> 32;
        multiply(create642, ROOT_Z, jArr2);
        add(jArr2, create64, jArr2);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i2, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
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
        return ((int) ((jArr[0] ^ (jArr[8] >>> 49)) ^ (jArr[8] >>> 57))) & 1;
    }

    private static void add(long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        for (int i5 = 0; i5 < 9; i5++) {
            jArr3[i4 + i5] = jArr[i2 + i5] ^ jArr2[i3 + i5];
        }
    }
}