package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public abstract class Nat256 {
    private static final long M = 4294967295L;

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j2 = (iArr[0] & M) + (iArr2[0] & M) + 0;
        iArr3[0] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[1] & M) + (iArr2[1] & M);
        iArr3[1] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[2] & M) + (iArr2[2] & M);
        iArr3[2] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[3] & M) + (iArr2[3] & M);
        iArr3[3] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[4] & M) + (iArr2[4] & M);
        iArr3[4] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[5] & M) + (iArr2[5] & M);
        iArr3[5] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[6] & M) + (iArr2[6] & M);
        iArr3[6] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[7] & M) + (iArr2[7] & M);
        iArr3[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j2 = (iArr[0] & M) + (iArr2[0] & M) + (iArr3[0] & M) + 0;
        iArr3[0] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[1] & M) + (iArr2[1] & M) + (iArr3[1] & M);
        iArr3[1] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[2] & M) + (iArr2[2] & M) + (iArr3[2] & M);
        iArr3[2] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[3] & M) + (iArr2[3] & M) + (iArr3[3] & M);
        iArr3[3] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[4] & M) + (iArr2[4] & M) + (iArr3[4] & M);
        iArr3[4] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[5] & M) + (iArr2[5] & M) + (iArr3[5] & M);
        iArr3[5] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[6] & M) + (iArr2[6] & M) + (iArr3[6] & M);
        iArr3[6] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[7] & M) + (iArr2[7] & M) + (iArr3[7] & M);
        iArr3[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j2 = (iArr[0] & M) + (iArr2[0] & M) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[1] & M) + (iArr2[1] & M);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[2] & M) + (iArr2[2] & M);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[3] & M) + (iArr2[3] & M);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[4] & M) + (iArr2[4] & M);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[5] & M) + (iArr2[5] & M);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[6] & M) + (iArr2[6] & M);
        iArr2[6] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[7] & M) + (M & iArr2[7]);
        iArr2[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i2 + 0;
        int i5 = i3 + 0;
        long j2 = (iArr[i4] & M) + (iArr2[i5] & M) + 0;
        int i6 = (int) j2;
        iArr[i4] = i6;
        iArr2[i5] = i6;
        int i7 = i2 + 1;
        int i8 = i3 + 1;
        long j3 = (j2 >>> 32) + (iArr[i7] & M) + (iArr2[i8] & M);
        int i9 = (int) j3;
        iArr[i7] = i9;
        iArr2[i8] = i9;
        int i10 = i2 + 2;
        int i11 = i3 + 2;
        long j4 = (j3 >>> 32) + (iArr[i10] & M) + (iArr2[i11] & M);
        int i12 = (int) j4;
        iArr[i10] = i12;
        iArr2[i11] = i12;
        int i13 = i2 + 3;
        int i14 = i3 + 3;
        long j5 = (j4 >>> 32) + (iArr[i13] & M) + (iArr2[i14] & M);
        int i15 = (int) j5;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        int i16 = i2 + 4;
        int i17 = i3 + 4;
        long j6 = (j5 >>> 32) + (iArr[i16] & M) + (iArr2[i17] & M);
        int i18 = (int) j6;
        iArr[i16] = i18;
        iArr2[i17] = i18;
        int i19 = i2 + 5;
        int i20 = i3 + 5;
        long j7 = (j6 >>> 32) + (iArr[i19] & M) + (iArr2[i20] & M);
        int i21 = (int) j7;
        iArr[i19] = i21;
        iArr2[i20] = i21;
        int i22 = i2 + 6;
        int i23 = i3 + 6;
        long j8 = (j7 >>> 32) + (iArr[i22] & M) + (iArr2[i23] & M);
        int i24 = (int) j8;
        iArr[i22] = i24;
        iArr2[i23] = i24;
        int i25 = i2 + 7;
        int i26 = i3 + 7;
        long j9 = (j8 >>> 32) + (iArr[i25] & M) + (M & iArr2[i26]);
        int i27 = (int) j9;
        iArr[i25] = i27;
        iArr2[i26] = i27;
        return (int) (j9 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
        iArr2[7] = iArr[7];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static int[] create() {
        return new int[8];
    }

    public static long[] create64() {
        return new long[4];
    }

    public static int[] createExt() {
        return new int[16];
    }

    public static long[] createExt64() {
        return new long[8];
    }

    public static boolean diff(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        boolean gte = gte(iArr, i2, iArr2, i3);
        if (gte) {
            sub(iArr, i2, iArr2, i3, iArr3, i4);
        } else {
            sub(iArr2, i3, iArr, i2, iArr3, i4);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i2 = 7; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i2 = 3; i2 >= 0; i2--) {
            if (jArr[i2] != jArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 256) {
            int[] create = create();
            int i2 = 0;
            while (bigInteger.signum() != 0) {
                create[i2] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
                i2++;
            }
            return create;
        }
        throw new IllegalArgumentException();
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 256) {
            long[] create64 = create64();
            int i2 = 0;
            while (bigInteger.signum() != 0) {
                create64[i2] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
                i2++;
            }
            return create64;
        }
        throw new IllegalArgumentException();
    }

    public static int getBit(int[] iArr, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = iArr[0];
        } else if ((i2 & 255) != i2) {
            return 0;
        } else {
            i3 = iArr[i2 >>> 5] >>> (i2 & 31);
        }
        return i3 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i2 = 7; i2 >= 0; i2--) {
            int i3 = iArr[i2] ^ Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE ^ iArr2[i2];
            if (i3 < i4) {
                return false;
            }
            if (i3 > i4) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 8; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 4; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j2 = iArr2[0] & M;
        long j3 = iArr2[1] & M;
        long j4 = iArr2[2] & M;
        long j5 = iArr2[3] & M;
        long j6 = iArr2[4] & M;
        long j7 = iArr2[5] & M;
        long j8 = iArr2[6] & M;
        long j9 = iArr2[7] & M;
        long j10 = iArr[0] & M;
        long j11 = (j10 * j2) + 0;
        iArr3[0] = (int) j11;
        long j12 = (j11 >>> 32) + (j10 * j3);
        iArr3[1] = (int) j12;
        long j13 = (j12 >>> 32) + (j10 * j4);
        iArr3[2] = (int) j13;
        long j14 = (j13 >>> 32) + (j10 * j5);
        iArr3[3] = (int) j14;
        long j15 = (j14 >>> 32) + (j10 * j6);
        iArr3[4] = (int) j15;
        long j16 = (j15 >>> 32) + (j10 * j7);
        iArr3[5] = (int) j16;
        long j17 = (j16 >>> 32) + (j10 * j8);
        iArr3[6] = (int) j17;
        long j18 = (j17 >>> 32) + (j10 * j9);
        iArr3[7] = (int) j18;
        iArr3[8] = (int) (j18 >>> 32);
        int i9 = 1;
        for (int i10 = 8; i9 < i10; i10 = 8) {
            long j19 = iArr[i9] & M;
            long j20 = (j19 * j2) + (iArr3[i2] & M) + 0;
            iArr3[i9 + 0] = (int) j20;
            int i11 = i9 + 1;
            long j21 = j3;
            long j22 = (j20 >>> 32) + (j19 * j3) + (iArr3[i11] & M);
            iArr3[i11] = (int) j22;
            long j23 = j7;
            long j24 = (j22 >>> 32) + (j19 * j4) + (iArr3[i3] & M);
            iArr3[i9 + 2] = (int) j24;
            long j25 = (j24 >>> 32) + (j19 * j5) + (iArr3[i4] & M);
            iArr3[i9 + 3] = (int) j25;
            long j26 = (j25 >>> 32) + (j19 * j6) + (iArr3[i5] & M);
            iArr3[i9 + 4] = (int) j26;
            long j27 = (j26 >>> 32) + (j19 * j23) + (iArr3[i6] & M);
            iArr3[i9 + 5] = (int) j27;
            long j28 = (j27 >>> 32) + (j19 * j8) + (iArr3[i7] & M);
            iArr3[i9 + 6] = (int) j28;
            long j29 = (j28 >>> 32) + (j19 * j9) + (iArr3[i8] & M);
            iArr3[i9 + 7] = (int) j29;
            iArr3[i9 + 8] = (int) (j29 >>> 32);
            i9 = i11;
            j2 = j2;
            j3 = j21;
            j7 = j23;
        }
    }

    public static long mul33Add(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5) {
        long j2 = i2 & M;
        long j3 = iArr[i3 + 0] & M;
        long j4 = (j2 * j3) + (iArr2[i4 + 0] & M) + 0;
        iArr3[i5 + 0] = (int) j4;
        long j5 = iArr[i3 + 1] & M;
        long j6 = (j4 >>> 32) + (j2 * j5) + j3 + (iArr2[i4 + 1] & M);
        iArr3[i5 + 1] = (int) j6;
        long j7 = j6 >>> 32;
        long j8 = iArr[i3 + 2] & M;
        long j9 = j7 + (j2 * j8) + j5 + (iArr2[i4 + 2] & M);
        iArr3[i5 + 2] = (int) j9;
        long j10 = iArr[i3 + 3] & M;
        long j11 = (j9 >>> 32) + (j2 * j10) + j8 + (iArr2[i4 + 3] & M);
        iArr3[i5 + 3] = (int) j11;
        long j12 = iArr[i3 + 4] & M;
        long j13 = (j11 >>> 32) + (j2 * j12) + j10 + (iArr2[i4 + 4] & M);
        iArr3[i5 + 4] = (int) j13;
        long j14 = iArr[i3 + 5] & M;
        long j15 = (j13 >>> 32) + (j2 * j14) + j12 + (iArr2[i4 + 5] & M);
        iArr3[i5 + 5] = (int) j15;
        long j16 = iArr[i3 + 6] & M;
        long j17 = (j15 >>> 32) + (j2 * j16) + j14 + (iArr2[i4 + 6] & M);
        iArr3[i5 + 6] = (int) j17;
        long j18 = iArr[i3 + 7] & M;
        long j19 = (j17 >>> 32) + (j2 * j18) + j16 + (M & iArr2[i4 + 7]);
        iArr3[i5 + 7] = (int) j19;
        return (j19 >>> 32) + j18;
    }

    public static int mul33DWordAdd(int i2, long j2, int[] iArr, int i3) {
        long j3 = i2 & M;
        long j4 = j2 & M;
        int i4 = i3 + 0;
        long j5 = (j3 * j4) + (iArr[i4] & M) + 0;
        iArr[i4] = (int) j5;
        long j6 = j2 >>> 32;
        long j7 = (j3 * j6) + j4;
        int i5 = i3 + 1;
        long j8 = (j5 >>> 32) + j7 + (iArr[i5] & M);
        iArr[i5] = (int) j8;
        int i6 = i3 + 2;
        long j9 = (j8 >>> 32) + j6 + (iArr[i6] & M);
        iArr[i6] = (int) j9;
        int i7 = i3 + 3;
        long j10 = (j9 >>> 32) + (M & iArr[i7]);
        iArr[i7] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i3, 4);
    }

    public static int mul33WordAdd(int i2, int i3, int[] iArr, int i4) {
        long j2 = i2 & M;
        long j3 = i3 & M;
        int i5 = i4 + 0;
        long j4 = (j2 * j3) + (iArr[i5] & M) + 0;
        iArr[i5] = (int) j4;
        int i6 = i4 + 1;
        long j5 = (j4 >>> 32) + j3 + (iArr[i6] & M);
        iArr[i6] = (int) j5;
        long j6 = j5 >>> 32;
        int i7 = i4 + 2;
        long j7 = j6 + (iArr[i7] & M);
        iArr[i7] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i4, 3);
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j2 = M;
        long j3 = iArr2[0] & M;
        long j4 = iArr2[1] & M;
        long j5 = iArr2[2] & M;
        long j6 = iArr2[3] & M;
        long j7 = iArr2[4] & M;
        long j8 = iArr2[5] & M;
        long j9 = iArr2[6] & M;
        long j10 = iArr2[7] & M;
        long j11 = 0;
        int i10 = 0;
        while (i10 < 8) {
            long j12 = j10;
            long j13 = iArr[i10] & j2;
            long j14 = j8;
            long j15 = (j13 * j3) + (iArr3[i2] & j2) + 0;
            iArr3[i10 + 0] = (int) j15;
            int i11 = i10 + 1;
            long j16 = j4;
            long j17 = (j15 >>> 32) + (j13 * j4) + (iArr3[i11] & j2);
            iArr3[i11] = (int) j17;
            long j18 = (j17 >>> 32) + (j13 * j5) + (iArr3[i3] & j2);
            iArr3[i10 + 2] = (int) j18;
            long j19 = (j18 >>> 32) + (j13 * j6) + (iArr3[i4] & j2);
            iArr3[i10 + 3] = (int) j19;
            long j20 = (j19 >>> 32) + (j13 * j7) + (iArr3[i5] & j2);
            iArr3[i10 + 4] = (int) j20;
            long j21 = (j20 >>> 32) + (j13 * j14) + (iArr3[i6] & j2);
            iArr3[i10 + 5] = (int) j21;
            long j22 = (j21 >>> 32) + (j13 * j9) + (iArr3[i7] & j2);
            iArr3[i10 + 6] = (int) j22;
            long j23 = (j22 >>> 32) + (j13 * j12) + (iArr3[i8] & j2);
            iArr3[i10 + 7] = (int) j23;
            long j24 = (j23 >>> 32) + j11 + (iArr3[i9] & j2);
            iArr3[i10 + 8] = (int) j24;
            j11 = j24 >>> 32;
            i10 = i11;
            j10 = j12;
            j8 = j14;
            j4 = j16;
            j2 = M;
        }
        return (int) j11;
    }

    public static int mulByWord(int i2, int[] iArr) {
        long j2 = i2 & M;
        long j3 = ((iArr[0] & M) * j2) + 0;
        iArr[0] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr[1] & M) * j2);
        iArr[1] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr[2] & M) * j2);
        iArr[2] = (int) j5;
        long j6 = (j5 >>> 32) + ((iArr[3] & M) * j2);
        iArr[3] = (int) j6;
        long j7 = (j6 >>> 32) + ((iArr[4] & M) * j2);
        iArr[4] = (int) j7;
        long j8 = (j7 >>> 32) + ((iArr[5] & M) * j2);
        iArr[5] = (int) j8;
        long j9 = (j8 >>> 32) + ((iArr[6] & M) * j2);
        iArr[6] = (int) j9;
        long j10 = (j9 >>> 32) + (j2 * (M & iArr[7]));
        iArr[7] = (int) j10;
        return (int) (j10 >>> 32);
    }

    public static int mulByWordAddTo(int i2, int[] iArr, int[] iArr2) {
        long j2 = i2 & M;
        long j3 = ((iArr2[0] & M) * j2) + (iArr[0] & M) + 0;
        iArr2[0] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr2[1] & M) * j2) + (iArr[1] & M);
        iArr2[1] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr2[2] & M) * j2) + (iArr[2] & M);
        iArr2[2] = (int) j5;
        long j6 = (j5 >>> 32) + ((iArr2[3] & M) * j2) + (iArr[3] & M);
        iArr2[3] = (int) j6;
        long j7 = (j6 >>> 32) + ((iArr2[4] & M) * j2) + (iArr[4] & M);
        iArr2[4] = (int) j7;
        long j8 = (j7 >>> 32) + ((iArr2[5] & M) * j2) + (iArr[5] & M);
        iArr2[5] = (int) j8;
        long j9 = (j8 >>> 32) + ((iArr2[6] & M) * j2) + (iArr[6] & M);
        iArr2[6] = (int) j9;
        long j10 = (j9 >>> 32) + (j2 * (iArr2[7] & M)) + (M & iArr[7]);
        iArr2[7] = (int) j10;
        return (int) (j10 >>> 32);
    }

    public static int mulWord(int i2, int[] iArr, int[] iArr2, int i3) {
        long j2 = i2 & M;
        long j3 = 0;
        int i4 = 0;
        do {
            long j4 = j3 + ((iArr[i4] & M) * j2);
            iArr2[i3 + i4] = (int) j4;
            j3 = j4 >>> 32;
            i4++;
        } while (i4 < 8);
        return (int) j3;
    }

    public static int mulWordAddTo(int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        long j2 = i2 & M;
        int i5 = i4 + 0;
        long j3 = ((iArr[i3 + 0] & M) * j2) + (iArr2[i5] & M) + 0;
        iArr2[i5] = (int) j3;
        int i6 = i4 + 1;
        long j4 = (j3 >>> 32) + ((iArr[i3 + 1] & M) * j2) + (iArr2[i6] & M);
        iArr2[i6] = (int) j4;
        int i7 = i4 + 2;
        long j5 = (j4 >>> 32) + ((iArr[i3 + 2] & M) * j2) + (iArr2[i7] & M);
        iArr2[i7] = (int) j5;
        int i8 = i4 + 3;
        long j6 = (j5 >>> 32) + ((iArr[i3 + 3] & M) * j2) + (iArr2[i8] & M);
        iArr2[i8] = (int) j6;
        int i9 = i4 + 4;
        long j7 = (j6 >>> 32) + ((iArr[i3 + 4] & M) * j2) + (iArr2[i9] & M);
        iArr2[i9] = (int) j7;
        int i10 = i4 + 5;
        long j8 = (j7 >>> 32) + ((iArr[i3 + 5] & M) * j2) + (iArr2[i10] & M);
        iArr2[i10] = (int) j8;
        int i11 = i4 + 6;
        long j9 = (j8 >>> 32) + ((iArr[i3 + 6] & M) * j2) + (iArr2[i11] & M);
        iArr2[i11] = (int) j9;
        int i12 = i4 + 7;
        long j10 = (j9 >>> 32) + (j2 * (iArr[i3 + 7] & M)) + (iArr2[i12] & M);
        iArr2[i12] = (int) j10;
        return (int) (j10 >>> 32);
    }

    public static int mulWordDwordAdd(int i2, long j2, int[] iArr, int i3) {
        long j3 = i2 & M;
        int i4 = i3 + 0;
        long j4 = ((j2 & M) * j3) + (iArr[i4] & M) + 0;
        iArr[i4] = (int) j4;
        long j5 = j3 * (j2 >>> 32);
        int i5 = i3 + 1;
        long j6 = (j4 >>> 32) + j5 + (iArr[i5] & M);
        iArr[i5] = (int) j6;
        int i6 = i3 + 2;
        long j7 = (j6 >>> 32) + (iArr[i6] & M);
        iArr[i6] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i3, 3);
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j2 = iArr[0] & M;
        int i2 = 16;
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i4 - 1;
            long j3 = iArr[i4] & M;
            long j4 = j3 * j3;
            int i6 = i2 - 1;
            iArr2[i6] = (i3 << 31) | ((int) (j4 >>> 33));
            i2 = i6 - 1;
            iArr2[i2] = (int) (j4 >>> 1);
            int i7 = (int) j4;
            if (i5 <= 0) {
                long j5 = j2 * j2;
                long j6 = ((i7 << 31) & M) | (j5 >>> 33);
                iArr2[0] = (int) j5;
                long j7 = iArr[1] & M;
                long j8 = iArr2[2] & M;
                long j9 = j6 + (j7 * j2);
                int i8 = (int) j9;
                iArr2[1] = (i8 << 1) | (((int) (j5 >>> 32)) & 1);
                long j10 = j8 + (j9 >>> 32);
                long j11 = iArr[2] & M;
                long j12 = iArr2[3] & M;
                long j13 = iArr2[4] & M;
                long j14 = j10 + (j11 * j2);
                int i9 = (int) j14;
                iArr2[2] = (i9 << 1) | (i8 >>> 31);
                long j15 = j12 + (j14 >>> 32) + (j11 * j7);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & M;
                long j18 = iArr[3] & M;
                long j19 = iArr2[5] & M;
                long j20 = iArr2[6] & M;
                long j21 = j17 + (j18 * j2);
                int i10 = (int) j21;
                iArr2[3] = (i10 << 1) | (i9 >>> 31);
                long j22 = j16 + (j21 >>> 32) + (j18 * j7);
                long j23 = j19 + (j22 >>> 32) + (j18 * j11);
                long j24 = j22 & M;
                long j25 = j20 + (j23 >>> 32);
                long j26 = j23 & M;
                long j27 = iArr[4] & M;
                long j28 = iArr2[7] & M;
                long j29 = iArr2[8] & M;
                long j30 = j24 + (j27 * j2);
                int i11 = (int) j30;
                iArr2[4] = (i11 << 1) | (i10 >>> 31);
                int i12 = i11 >>> 31;
                long j31 = j26 + (j30 >>> 32) + (j27 * j7);
                long j32 = j25 + (j31 >>> 32) + (j27 * j11);
                long j33 = j31 & M;
                long j34 = j28 + (j32 >>> 32) + (j27 * j18);
                long j35 = j32 & M;
                long j36 = j29 + (j34 >>> 32);
                long j37 = j34 & M;
                long j38 = iArr[5] & M;
                long j39 = iArr2[9] & M;
                long j40 = iArr2[10] & M;
                long j41 = j33 + (j38 * j2);
                int i13 = (int) j41;
                iArr2[5] = (i13 << 1) | i12;
                int i14 = i13 >>> 31;
                long j42 = j35 + (j41 >>> 32) + (j38 * j7);
                long j43 = j37 + (j42 >>> 32) + (j38 * j11);
                long j44 = j42 & M;
                long j45 = j36 + (j43 >>> 32) + (j38 * j18);
                long j46 = j43 & M;
                long j47 = j39 + (j45 >>> 32) + (j38 * j27);
                long j48 = j45 & M;
                long j49 = j40 + (j47 >>> 32);
                long j50 = j47 & M;
                long j51 = iArr[6] & M;
                long j52 = iArr2[11] & M;
                long j53 = iArr2[12] & M;
                long j54 = j44 + (j51 * j2);
                int i15 = (int) j54;
                iArr2[6] = (i15 << 1) | i14;
                long j55 = j46 + (j54 >>> 32) + (j51 * j7);
                long j56 = j48 + (j55 >>> 32) + (j51 * j11);
                long j57 = j55 & M;
                long j58 = j50 + (j56 >>> 32) + (j51 * j18);
                long j59 = j56 & M;
                long j60 = j49 + (j58 >>> 32) + (j51 * j27);
                long j61 = j58 & M;
                long j62 = j52 + (j60 >>> 32) + (j51 * j38);
                long j63 = j60 & M;
                long j64 = j53 + (j62 >>> 32);
                long j65 = j62 & M;
                long j66 = iArr[7] & M;
                long j67 = iArr2[13] & M;
                long j68 = M & iArr2[14];
                long j69 = j57 + (j2 * j66);
                int i16 = (int) j69;
                iArr2[7] = (i15 >>> 31) | (i16 << 1);
                int i17 = i16 >>> 31;
                long j70 = j59 + (j69 >>> 32) + (j7 * j66);
                long j71 = j61 + (j70 >>> 32) + (j66 * j11);
                long j72 = j63 + (j71 >>> 32) + (j66 * j18);
                long j73 = j65 + (j72 >>> 32) + (j66 * j27);
                long j74 = j64 + (j73 >>> 32) + (j66 * j38);
                long j75 = j67 + (j74 >>> 32) + (j66 * j51);
                long j76 = j68 + (j75 >>> 32);
                int i18 = (int) j70;
                iArr2[8] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) j71;
                iArr2[9] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j72;
                iArr2[10] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j73;
                iArr2[11] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j74;
                iArr2[12] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j75;
                iArr2[13] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) j76;
                iArr2[14] = i29 | (i30 << 1);
                iArr2[15] = (i30 >>> 31) | ((iArr2[15] + ((int) (j76 >> 32))) << 1);
                return;
            }
            i4 = i5;
            i3 = i7;
        }
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j2 = ((iArr[0] & M) - (iArr2[0] & M)) + 0;
        iArr3[0] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[1] & M) - (iArr2[1] & M));
        iArr3[1] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[2] & M) - (iArr2[2] & M));
        iArr3[2] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[3] & M) - (iArr2[3] & M));
        iArr3[3] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr[4] & M) - (iArr2[4] & M));
        iArr3[4] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr[5] & M) - (iArr2[5] & M));
        iArr3[5] = (int) j7;
        long j8 = (j7 >> 32) + ((iArr[6] & M) - (iArr2[6] & M));
        iArr3[6] = (int) j8;
        long j9 = (j8 >> 32) + ((iArr[7] & M) - (iArr2[7] & M));
        iArr3[7] = (int) j9;
        return (int) (j9 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j2 = (((iArr3[0] & M) - (iArr[0] & M)) - (iArr2[0] & M)) + 0;
        iArr3[0] = (int) j2;
        long j3 = (j2 >> 32) + (((iArr3[1] & M) - (iArr[1] & M)) - (iArr2[1] & M));
        iArr3[1] = (int) j3;
        long j4 = (j3 >> 32) + (((iArr3[2] & M) - (iArr[2] & M)) - (iArr2[2] & M));
        iArr3[2] = (int) j4;
        long j5 = (j4 >> 32) + (((iArr3[3] & M) - (iArr[3] & M)) - (iArr2[3] & M));
        iArr3[3] = (int) j5;
        long j6 = (j5 >> 32) + (((iArr3[4] & M) - (iArr[4] & M)) - (iArr2[4] & M));
        iArr3[4] = (int) j6;
        long j7 = (j6 >> 32) + (((iArr3[5] & M) - (iArr[5] & M)) - (iArr2[5] & M));
        iArr3[5] = (int) j7;
        long j8 = (j7 >> 32) + (((iArr3[6] & M) - (iArr[6] & M)) - (iArr2[6] & M));
        iArr3[6] = (int) j8;
        long j9 = (j8 >> 32) + (((iArr3[7] & M) - (iArr[7] & M)) - (iArr2[7] & M));
        iArr3[7] = (int) j9;
        return (int) (j9 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j2 = ((iArr2[0] & M) - (iArr[0] & M)) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr2[1] & M) - (iArr[1] & M));
        iArr2[1] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr2[2] & M) - (iArr[2] & M));
        iArr2[2] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr2[3] & M) - (iArr[3] & M));
        iArr2[3] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr2[4] & M) - (iArr[4] & M));
        iArr2[4] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr2[5] & M) - (iArr[5] & M));
        iArr2[5] = (int) j7;
        long j8 = (j7 >> 32) + ((iArr2[6] & M) - (iArr[6] & M));
        iArr2[6] = (int) j8;
        long j9 = (j8 >> 32) + ((iArr2[7] & M) - (M & iArr[7]));
        iArr2[7] = (int) j9;
        return (int) (j9 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                Pack.intToBigEndian(i3, bArr, (7 - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i2 = 0; i2 < 4; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                Pack.longToBigEndian(j2, bArr, (3 - i2) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
    }

    public static boolean gte(int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 7; i4 >= 0; i4--) {
            int i5 = iArr[i2 + i4] ^ Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE ^ iArr2[i3 + i4];
            if (i5 < i6) {
                return false;
            }
            if (i5 > i6) {
                return true;
            }
        }
        return true;
    }

    public static int add(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j2 = (iArr[i2 + 0] & M) + (iArr2[i3 + 0] & M) + 0;
        iArr3[i4 + 0] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[i2 + 1] & M) + (iArr2[i3 + 1] & M);
        iArr3[i4 + 1] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[i2 + 2] & M) + (iArr2[i3 + 2] & M);
        iArr3[i4 + 2] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[i2 + 3] & M) + (iArr2[i3 + 3] & M);
        iArr3[i4 + 3] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[i2 + 4] & M) + (iArr2[i3 + 4] & M);
        iArr3[i4 + 4] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[i2 + 5] & M) + (iArr2[i3 + 5] & M);
        iArr3[i4 + 5] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[i2 + 6] & M) + (iArr2[i3 + 6] & M);
        iArr3[i4 + 6] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[i2 + 7] & M) + (iArr2[i3 + 7] & M);
        iArr3[i4 + 7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5 = i4 + 0;
        long j2 = (iArr[i2 + 0] & M) + (iArr2[i3 + 0] & M) + (iArr3[i5] & M) + 0;
        iArr3[i5] = (int) j2;
        int i6 = i4 + 1;
        long j3 = (j2 >>> 32) + (iArr[i2 + 1] & M) + (iArr2[i3 + 1] & M) + (iArr3[i6] & M);
        iArr3[i6] = (int) j3;
        int i7 = i4 + 2;
        long j4 = (j3 >>> 32) + (iArr[i2 + 2] & M) + (iArr2[i3 + 2] & M) + (iArr3[i7] & M);
        iArr3[i7] = (int) j4;
        int i8 = i4 + 3;
        long j5 = (j4 >>> 32) + (iArr[i2 + 3] & M) + (iArr2[i3 + 3] & M) + (iArr3[i8] & M);
        iArr3[i8] = (int) j5;
        int i9 = i4 + 4;
        long j6 = (j5 >>> 32) + (iArr[i2 + 4] & M) + (iArr2[i3 + 4] & M) + (iArr3[i9] & M);
        iArr3[i9] = (int) j6;
        int i10 = i4 + 5;
        long j7 = (j6 >>> 32) + (iArr[i2 + 5] & M) + (iArr2[i3 + 5] & M) + (iArr3[i10] & M);
        iArr3[i10] = (int) j7;
        int i11 = i4 + 6;
        long j8 = (j7 >>> 32) + (iArr[i2 + 6] & M) + (iArr2[i3 + 6] & M) + (iArr3[i11] & M);
        iArr3[i11] = (int) j8;
        int i12 = i4 + 7;
        long j9 = (j8 >>> 32) + (iArr[i2 + 7] & M) + (iArr2[i3 + 7] & M) + (iArr3[i12] & M);
        iArr3[i12] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int addTo(int[] iArr, int i2, int[] iArr2, int i3, int i4) {
        int i5 = i3 + 0;
        long j2 = (i4 & M) + (iArr[i2 + 0] & M) + (iArr2[i5] & M);
        iArr2[i5] = (int) j2;
        int i6 = i3 + 1;
        long j3 = (j2 >>> 32) + (iArr[i2 + 1] & M) + (iArr2[i6] & M);
        iArr2[i6] = (int) j3;
        int i7 = i3 + 2;
        long j4 = (j3 >>> 32) + (iArr[i2 + 2] & M) + (iArr2[i7] & M);
        iArr2[i7] = (int) j4;
        int i8 = i3 + 3;
        long j5 = (j4 >>> 32) + (iArr[i2 + 3] & M) + (iArr2[i8] & M);
        iArr2[i8] = (int) j5;
        int i9 = i3 + 4;
        long j6 = (j5 >>> 32) + (iArr[i2 + 4] & M) + (iArr2[i9] & M);
        iArr2[i9] = (int) j6;
        int i10 = i3 + 5;
        long j7 = (j6 >>> 32) + (iArr[i2 + 5] & M) + (iArr2[i10] & M);
        iArr2[i10] = (int) j7;
        int i11 = i3 + 6;
        long j8 = (j7 >>> 32) + (iArr[i2 + 6] & M) + (iArr2[i11] & M);
        iArr2[i11] = (int) j8;
        int i12 = i3 + 7;
        long j9 = (j8 >>> 32) + (iArr[i2 + 7] & M) + (M & iArr2[i12]);
        iArr2[i12] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int sub(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j2 = ((iArr[i2 + 0] & M) - (iArr2[i3 + 0] & M)) + 0;
        iArr3[i4 + 0] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[i2 + 1] & M) - (iArr2[i3 + 1] & M));
        iArr3[i4 + 1] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[i2 + 2] & M) - (iArr2[i3 + 2] & M));
        iArr3[i4 + 2] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[i2 + 3] & M) - (iArr2[i3 + 3] & M));
        iArr3[i4 + 3] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr[i2 + 4] & M) - (iArr2[i3 + 4] & M));
        iArr3[i4 + 4] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr[i2 + 5] & M) - (iArr2[i3 + 5] & M));
        iArr3[i4 + 5] = (int) j7;
        long j8 = (j7 >> 32) + ((iArr[i2 + 6] & M) - (iArr2[i3 + 6] & M));
        iArr3[i4 + 6] = (int) j8;
        long j9 = (j8 >> 32) + ((iArr[i2 + 7] & M) - (iArr2[i3 + 7] & M));
        iArr3[i4 + 7] = (int) j9;
        return (int) (j9 >> 32);
    }

    public static int subFrom(int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        long j2 = ((iArr2[i4] & M) - (iArr[i2 + 0] & M)) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >> 32) + ((iArr2[i5] & M) - (iArr[i2 + 1] & M));
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = (j3 >> 32) + ((iArr2[i6] & M) - (iArr[i2 + 2] & M));
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = (j4 >> 32) + ((iArr2[i7] & M) - (iArr[i2 + 3] & M));
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = (j5 >> 32) + ((iArr2[i8] & M) - (iArr[i2 + 4] & M));
        iArr2[i8] = (int) j6;
        int i9 = i3 + 5;
        long j7 = (j6 >> 32) + ((iArr2[i9] & M) - (iArr[i2 + 5] & M));
        iArr2[i9] = (int) j7;
        int i10 = i3 + 6;
        long j8 = (j7 >> 32) + ((iArr2[i10] & M) - (iArr[i2 + 6] & M));
        iArr2[i10] = (int) j8;
        int i11 = i3 + 7;
        long j9 = (j8 >> 32) + ((iArr2[i11] & M) - (iArr[i2 + 7] & M));
        iArr2[i11] = (int) j9;
        return (int) (j9 >> 32);
    }

    public static int mulAddTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long j2 = iArr2[i3 + 0] & M;
        long j3 = iArr2[i3 + 1] & M;
        long j4 = iArr2[i3 + 2] & M;
        long j5 = iArr2[i3 + 3] & M;
        long j6 = iArr2[i3 + 4] & M;
        long j7 = iArr2[i3 + 5] & M;
        long j8 = iArr2[i3 + 6] & M;
        long j9 = iArr2[i3 + 7] & M;
        int i13 = 0;
        long j10 = 0;
        int i14 = i4;
        while (i13 < 8) {
            int i15 = i13;
            long j11 = iArr[i2 + i13] & M;
            long j12 = j2;
            long j13 = (j11 * j2) + (iArr3[i5] & M) + 0;
            long j14 = j9;
            iArr3[i14 + 0] = (int) j13;
            int i16 = i14 + 1;
            long j15 = (j13 >>> 32) + (j11 * j3) + (iArr3[i16] & M);
            iArr3[i16] = (int) j15;
            long j16 = (j15 >>> 32) + (j11 * j4) + (iArr3[i6] & M);
            iArr3[i14 + 2] = (int) j16;
            long j17 = (j16 >>> 32) + (j11 * j5) + (iArr3[i7] & M);
            iArr3[i14 + 3] = (int) j17;
            long j18 = (j17 >>> 32) + (j11 * j6) + (iArr3[i8] & M);
            iArr3[i14 + 4] = (int) j18;
            long j19 = (j18 >>> 32) + (j11 * j7) + (iArr3[i9] & M);
            iArr3[i14 + 5] = (int) j19;
            long j20 = (j19 >>> 32) + (j11 * j8) + (iArr3[i10] & M);
            iArr3[i14 + 6] = (int) j20;
            long j21 = (j20 >>> 32) + (j11 * j14) + (iArr3[i11] & M);
            iArr3[i14 + 7] = (int) j21;
            long j22 = (j21 >>> 32) + j10 + (iArr3[i12] & M);
            iArr3[i14 + 8] = (int) j22;
            j10 = j22 >>> 32;
            i13 = i15 + 1;
            i14 = i16;
            j9 = j14;
            j2 = j12;
            j4 = j4;
            j3 = j3;
        }
        return (int) j10;
    }

    public static void mul(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long j2 = iArr2[i3 + 0] & M;
        long j3 = iArr2[i3 + 1] & M;
        long j4 = iArr2[i3 + 2] & M;
        long j5 = iArr2[i3 + 3] & M;
        long j6 = iArr2[i3 + 4] & M;
        long j7 = iArr2[i3 + 5] & M;
        long j8 = iArr2[i3 + 6] & M;
        long j9 = iArr2[i3 + 7] & M;
        long j10 = iArr[i2 + 0] & M;
        long j11 = (j10 * j2) + 0;
        iArr3[i4 + 0] = (int) j11;
        long j12 = (j11 >>> 32) + (j10 * j3);
        iArr3[i4 + 1] = (int) j12;
        long j13 = (j12 >>> 32) + (j10 * j4);
        iArr3[i4 + 2] = (int) j13;
        long j14 = (j13 >>> 32) + (j10 * j5);
        iArr3[i4 + 3] = (int) j14;
        long j15 = (j14 >>> 32) + (j10 * j6);
        iArr3[i4 + 4] = (int) j15;
        long j16 = (j15 >>> 32) + (j10 * j7);
        iArr3[i4 + 5] = (int) j16;
        long j17 = (j16 >>> 32) + (j10 * j8);
        iArr3[i4 + 6] = (int) j17;
        long j18 = j9;
        long j19 = (j17 >>> 32) + (j10 * j18);
        iArr3[i4 + 7] = (int) j19;
        iArr3[i4 + 8] = (int) (j19 >>> 32);
        int i13 = 1;
        int i14 = i4;
        int i15 = 1;
        while (i15 < 8) {
            i14 += i13;
            long j20 = iArr[i2 + i15] & M;
            long j21 = (j20 * j2) + (iArr3[i5] & M) + 0;
            iArr3[i14 + 0] = (int) j21;
            long j22 = j18;
            long j23 = (j21 >>> 32) + (j20 * j3) + (iArr3[i6] & M);
            iArr3[i14 + 1] = (int) j23;
            long j24 = j4;
            long j25 = (j23 >>> 32) + (j20 * j4) + (iArr3[i7] & M);
            iArr3[i14 + 2] = (int) j25;
            long j26 = (j25 >>> 32) + (j20 * j5) + (iArr3[i8] & M);
            iArr3[i14 + 3] = (int) j26;
            long j27 = (j26 >>> 32) + (j20 * j6) + (iArr3[i9] & M);
            iArr3[i14 + 4] = (int) j27;
            long j28 = (j27 >>> 32) + (j20 * j7) + (iArr3[i10] & M);
            iArr3[i14 + 5] = (int) j28;
            long j29 = (j28 >>> 32) + (j20 * j8) + (iArr3[i11] & M);
            iArr3[i14 + 6] = (int) j29;
            long j30 = (j29 >>> 32) + (j20 * j22) + (iArr3[i12] & M);
            iArr3[i14 + 7] = (int) j30;
            iArr3[i14 + 8] = (int) (j30 >>> 32);
            i15++;
            j4 = j24;
            j18 = j22;
            j5 = j5;
            i13 = 1;
        }
    }

    public static void square(int[] iArr, int i2, int[] iArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        long j2 = iArr[i2 + 0] & M;
        int i17 = 0;
        int i18 = 16;
        int i19 = 7;
        while (true) {
            int i20 = i19 - 1;
            long j3 = iArr[i2 + i19] & M;
            long j4 = j3 * j3;
            int i21 = i18 - 1;
            iArr2[i3 + i21] = (i17 << 31) | ((int) (j4 >>> 33));
            i18 = i21 - 1;
            iArr2[i3 + i18] = (int) (j4 >>> 1);
            i17 = (int) j4;
            if (i20 <= 0) {
                long j5 = j2 * j2;
                long j6 = ((i17 << 31) & M) | (j5 >>> 33);
                iArr2[i3 + 0] = (int) j5;
                long j7 = iArr[i2 + 1] & M;
                long j8 = iArr2[i4] & M;
                long j9 = j6 + (j7 * j2);
                int i22 = (int) j9;
                iArr2[i3 + 1] = (i22 << 1) | (((int) (j5 >>> 32)) & 1);
                int i23 = i22 >>> 31;
                long j10 = j8 + (j9 >>> 32);
                long j11 = iArr[i2 + 2] & M;
                long j12 = iArr2[i5] & M;
                long j13 = iArr2[i6] & M;
                long j14 = j10 + (j11 * j2);
                int i24 = (int) j14;
                iArr2[i3 + 2] = (i24 << 1) | i23;
                int i25 = i24 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j11 * j7);
                long j16 = j15 & M;
                long j17 = iArr[i2 + 3] & M;
                long j18 = iArr2[i7] & M;
                long j19 = iArr2[i8] & M;
                long j20 = j16 + (j17 * j2);
                int i26 = (int) j20;
                iArr2[i3 + 3] = (i26 << 1) | i25;
                long j21 = j13 + (j15 >>> 32) + (j20 >>> 32) + (j17 * j7);
                long j22 = j18 + (j21 >>> 32) + (j17 * j11);
                long j23 = j21 & M;
                long j24 = j22 & M;
                long j25 = iArr[i2 + 4] & M;
                long j26 = iArr2[i9] & M;
                long j27 = iArr2[i10] & M;
                long j28 = j23 + (j25 * j2);
                int i27 = (int) j28;
                iArr2[i3 + 4] = (i26 >>> 31) | (i27 << 1);
                int i28 = i27 >>> 31;
                long j29 = j24 + (j28 >>> 32) + (j25 * j7);
                long j30 = j19 + (j22 >>> 32) + (j29 >>> 32) + (j25 * j11);
                long j31 = j29 & M;
                long j32 = j26 + (j30 >>> 32) + (j25 * j17);
                long j33 = j30 & M;
                long j34 = j27 + (j32 >>> 32);
                long j35 = j32 & M;
                long j36 = iArr[i2 + 5] & M;
                long j37 = iArr2[i11] & M;
                long j38 = iArr2[i12] & M;
                long j39 = j31 + (j36 * j2);
                int i29 = (int) j39;
                iArr2[i3 + 5] = i28 | (i29 << 1);
                int i30 = i29 >>> 31;
                long j40 = j33 + (j39 >>> 32) + (j36 * j7);
                long j41 = j35 + (j40 >>> 32) + (j36 * j11);
                long j42 = j40 & M;
                long j43 = j34 + (j41 >>> 32) + (j36 * j17);
                long j44 = j41 & M;
                long j45 = j37 + (j43 >>> 32) + (j36 * j25);
                long j46 = j43 & M;
                long j47 = j38 + (j45 >>> 32);
                long j48 = j45 & M;
                long j49 = iArr[i2 + 6] & M;
                long j50 = iArr2[i13] & M;
                long j51 = iArr2[i14] & M;
                long j52 = j42 + (j49 * j2);
                int i31 = (int) j52;
                iArr2[i3 + 6] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                long j53 = j44 + (j52 >>> 32) + (j49 * j7);
                long j54 = j46 + (j53 >>> 32) + (j49 * j11);
                long j55 = j53 & M;
                long j56 = j48 + (j54 >>> 32) + (j49 * j17);
                long j57 = j54 & M;
                long j58 = j47 + (j56 >>> 32) + (j49 * j25);
                long j59 = j56 & M;
                long j60 = j50 + (j58 >>> 32) + (j49 * j36);
                long j61 = j58 & M;
                long j62 = j51 + (j60 >>> 32);
                long j63 = j60 & M;
                long j64 = iArr[i2 + 7] & M;
                long j65 = iArr2[i15] & M;
                long j66 = iArr2[i16] & M;
                long j67 = j55 + (j2 * j64);
                int i33 = (int) j67;
                iArr2[i3 + 7] = (i33 << 1) | i32;
                long j68 = j57 + (j67 >>> 32) + (j64 * j7);
                long j69 = j59 + (j68 >>> 32) + (j64 * j11);
                long j70 = j61 + (j69 >>> 32) + (j64 * j17);
                long j71 = j63 + (j70 >>> 32) + (j64 * j25);
                long j72 = j62 + (j71 >>> 32) + (j64 * j36);
                long j73 = j65 + (j72 >>> 32) + (j64 * j49);
                long j74 = j66 + (j73 >>> 32);
                int i34 = (int) j68;
                iArr2[i3 + 8] = (i33 >>> 31) | (i34 << 1);
                int i35 = i34 >>> 31;
                int i36 = (int) j69;
                iArr2[i3 + 9] = i35 | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) j70;
                iArr2[i3 + 10] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j71;
                iArr2[i3 + 11] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) j72;
                iArr2[i3 + 12] = i41 | (i42 << 1);
                int i43 = i42 >>> 31;
                int i44 = (int) j73;
                iArr2[i3 + 13] = i43 | (i44 << 1);
                int i45 = i44 >>> 31;
                int i46 = (int) j74;
                iArr2[i3 + 14] = i45 | (i46 << 1);
                int i47 = i46 >>> 31;
                int i48 = i3 + 15;
                iArr2[i48] = i47 | ((iArr2[i48] + ((int) (j74 >> 32))) << 1);
                return;
            }
            i19 = i20;
        }
    }
}