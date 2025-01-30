package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public abstract class Nat224 {
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
        return (int) (j8 >>> 32);
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
        return (int) (j8 >>> 32);
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
        long j8 = (j7 >>> 32) + (iArr[6] & M) + (M & iArr2[6]);
        iArr2[6] = (int) j8;
        return (int) (j8 >>> 32);
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
        long j8 = (j7 >>> 32) + (iArr[i22] & M) + (M & iArr2[i23]);
        int i24 = (int) j8;
        iArr[i22] = i24;
        iArr2[i23] = i24;
        return (int) (j8 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
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
        for (int i2 = 6; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 224) {
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

    public static int getBit(int[] iArr, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = iArr[0];
        } else {
            int i4 = i2 >> 5;
            if (i4 < 0 || i4 >= 7) {
                return 0;
            }
            i3 = iArr[i4] >>> (i2 & 31);
        }
        return i3 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i2 = 6; i2 >= 0; i2--) {
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
        for (int i2 = 1; i2 < 7; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i2 = 0; i2 < 7; i2++) {
            if (iArr[i2] != 0) {
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
        long j2 = iArr2[0] & M;
        long j3 = iArr2[1] & M;
        long j4 = iArr2[2] & M;
        long j5 = iArr2[3] & M;
        long j6 = iArr2[4] & M;
        long j7 = iArr2[5] & M;
        long j8 = iArr2[6] & M;
        long j9 = iArr[0] & M;
        long j10 = (j9 * j2) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (j9 * j3);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (j9 * j4);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (j9 * j5);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j6);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j7);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j8);
        iArr3[6] = (int) j16;
        iArr3[7] = (int) (j16 >>> 32);
        int i8 = 1;
        for (int i9 = 7; i8 < i9; i9 = 7) {
            long j17 = iArr[i8] & M;
            long j18 = (j17 * j2) + (iArr3[i2] & M) + 0;
            iArr3[i8 + 0] = (int) j18;
            int i10 = i8 + 1;
            long j19 = j3;
            long j20 = (j18 >>> 32) + (j17 * j3) + (iArr3[i10] & M);
            iArr3[i10] = (int) j20;
            long j21 = j7;
            long j22 = (j20 >>> 32) + (j17 * j4) + (iArr3[i3] & M);
            iArr3[i8 + 2] = (int) j22;
            long j23 = (j22 >>> 32) + (j17 * j5) + (iArr3[i4] & M);
            iArr3[i8 + 3] = (int) j23;
            long j24 = (j23 >>> 32) + (j17 * j6) + (iArr3[i5] & M);
            iArr3[i8 + 4] = (int) j24;
            long j25 = (j24 >>> 32) + (j17 * j21) + (iArr3[i6] & M);
            iArr3[i8 + 5] = (int) j25;
            long j26 = (j25 >>> 32) + (j17 * j8) + (iArr3[i7] & M);
            iArr3[i8 + 6] = (int) j26;
            iArr3[i8 + 7] = (int) (j26 >>> 32);
            i8 = i10;
            j2 = j2;
            j3 = j19;
            j7 = j21;
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
        long j17 = (j15 >>> 32) + (j2 * j16) + j14 + (M & iArr2[i4 + 6]);
        iArr3[i5 + 6] = (int) j17;
        return (j17 >>> 32) + j16;
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
        return Nat.incAt(7, iArr, i3, 4);
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
        return Nat.incAt(7, iArr, i4, 3);
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j2 = M;
        long j3 = iArr2[0] & M;
        long j4 = iArr2[1] & M;
        long j5 = iArr2[2] & M;
        long j6 = iArr2[3] & M;
        long j7 = iArr2[4] & M;
        long j8 = iArr2[5] & M;
        long j9 = iArr2[6] & M;
        long j10 = 0;
        int i9 = 0;
        while (i9 < 7) {
            long j11 = j9;
            long j12 = iArr[i9] & j2;
            long j13 = j8;
            long j14 = (j12 * j3) + (iArr3[i2] & j2) + 0;
            iArr3[i9 + 0] = (int) j14;
            int i10 = i9 + 1;
            long j15 = j4;
            long j16 = (j14 >>> 32) + (j12 * j4) + (iArr3[i10] & j2);
            iArr3[i10] = (int) j16;
            long j17 = (j16 >>> 32) + (j12 * j5) + (iArr3[i3] & j2);
            iArr3[i9 + 2] = (int) j17;
            long j18 = (j17 >>> 32) + (j12 * j6) + (iArr3[i4] & j2);
            iArr3[i9 + 3] = (int) j18;
            long j19 = (j18 >>> 32) + (j12 * j7) + (iArr3[i5] & j2);
            iArr3[i9 + 4] = (int) j19;
            long j20 = (j19 >>> 32) + (j12 * j13) + (iArr3[i6] & j2);
            iArr3[i9 + 5] = (int) j20;
            long j21 = (j20 >>> 32) + (j12 * j11) + (iArr3[i7] & j2);
            iArr3[i9 + 6] = (int) j21;
            long j22 = (j21 >>> 32) + j10 + (iArr3[i8] & j2);
            iArr3[i9 + 7] = (int) j22;
            j10 = j22 >>> 32;
            i9 = i10;
            j9 = j11;
            j8 = j13;
            j4 = j15;
            j2 = M;
        }
        return (int) j10;
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
        long j9 = (j8 >>> 32) + (j2 * (M & iArr[6]));
        iArr[6] = (int) j9;
        return (int) (j9 >>> 32);
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
        long j9 = (j8 >>> 32) + (j2 * (iArr2[6] & M)) + (M & iArr[6]);
        iArr2[6] = (int) j9;
        return (int) (j9 >>> 32);
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
        } while (i4 < 7);
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
        long j9 = (j8 >>> 32) + (j2 * (iArr[i3 + 6] & M)) + (iArr2[i11] & M);
        iArr2[i11] = (int) j9;
        return (int) (j9 >>> 32);
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
        return Nat.incAt(7, iArr, i3, 3);
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j2 = iArr[0] & M;
        int i2 = 14;
        int i3 = 0;
        int i4 = 6;
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
                long j53 = M & iArr2[12];
                long j54 = j44 + (j2 * j51);
                int i14 = (int) j54;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                int i15 = i14 >>> 31;
                long j55 = j46 + (j54 >>> 32) + (j7 * j51);
                long j56 = j48 + (j55 >>> 32) + (j51 * j11);
                long j57 = j50 + (j56 >>> 32) + (j51 * j18);
                long j58 = j49 + (j57 >>> 32) + (j51 * j27);
                long j59 = j52 + (j58 >>> 32) + (j51 * j38);
                long j60 = j53 + (j59 >>> 32);
                int i16 = (int) j55;
                iArr2[7] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j56;
                iArr2[8] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) j57;
                iArr2[9] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j58;
                iArr2[10] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j59;
                iArr2[11] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j60;
                iArr2[12] = i25 | (i26 << 1);
                iArr2[13] = (i26 >>> 31) | ((iArr2[13] + ((int) (j60 >> 32))) << 1);
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
        return (int) (j8 >> 32);
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
        return (int) (j8 >> 32);
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
        long j8 = (j7 >> 32) + ((iArr2[6] & M) - (M & iArr[6]));
        iArr2[6] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i2 = 0; i2 < 7; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                Pack.intToBigEndian(i3, bArr, (6 - i2) << 2);
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
    }

    public static boolean gte(int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 6; i4 >= 0; i4--) {
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
        return (int) (j8 >>> 32);
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
        return (int) (j8 >>> 32);
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
        long j8 = (j7 >>> 32) + (iArr[i2 + 6] & M) + (M & iArr2[i11]);
        iArr2[i11] = (int) j8;
        return (int) (j8 >>> 32);
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
        return (int) (j8 >> 32);
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
        return (int) (j8 >> 32);
    }

    public static int mulAddTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j2 = iArr2[i3 + 0] & M;
        long j3 = iArr2[i3 + 1] & M;
        long j4 = iArr2[i3 + 2] & M;
        long j5 = iArr2[i3 + 3] & M;
        long j6 = iArr2[i3 + 4] & M;
        long j7 = iArr2[i3 + 5] & M;
        long j8 = iArr2[i3 + 6] & M;
        long j9 = 0;
        int i12 = 0;
        int i13 = i4;
        while (i12 < 7) {
            int i14 = i12;
            long j10 = iArr[i2 + i12] & M;
            long j11 = j2;
            long j12 = (j10 * j2) + (iArr3[i5] & M) + 0;
            long j13 = j8;
            iArr3[i13 + 0] = (int) j12;
            int i15 = i13 + 1;
            long j14 = (j12 >>> 32) + (j10 * j3) + (iArr3[i15] & M);
            iArr3[i15] = (int) j14;
            long j15 = (j14 >>> 32) + (j10 * j4) + (iArr3[i6] & M);
            iArr3[i13 + 2] = (int) j15;
            long j16 = (j15 >>> 32) + (j10 * j5) + (iArr3[i7] & M);
            iArr3[i13 + 3] = (int) j16;
            long j17 = (j16 >>> 32) + (j10 * j6) + (iArr3[i8] & M);
            iArr3[i13 + 4] = (int) j17;
            long j18 = (j17 >>> 32) + (j10 * j7) + (iArr3[i9] & M);
            iArr3[i13 + 5] = (int) j18;
            long j19 = (j18 >>> 32) + (j10 * j13) + (iArr3[i10] & M);
            iArr3[i13 + 6] = (int) j19;
            long j20 = (j19 >>> 32) + j9 + (iArr3[i11] & M);
            iArr3[i13 + 7] = (int) j20;
            j9 = j20 >>> 32;
            i12 = i14 + 1;
            i13 = i15;
            j8 = j13;
            j2 = j11;
            j4 = j4;
            j3 = j3;
        }
        return (int) j9;
    }

    public static void mul(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j2 = iArr2[i3 + 0] & M;
        long j3 = iArr2[i3 + 1] & M;
        long j4 = iArr2[i3 + 2] & M;
        long j5 = iArr2[i3 + 3] & M;
        long j6 = iArr2[i3 + 4] & M;
        long j7 = iArr2[i3 + 5] & M;
        long j8 = iArr2[i3 + 6] & M;
        long j9 = iArr[i2 + 0] & M;
        long j10 = (j9 * j2) + 0;
        iArr3[i4 + 0] = (int) j10;
        long j11 = (j10 >>> 32) + (j9 * j3);
        iArr3[i4 + 1] = (int) j11;
        long j12 = (j11 >>> 32) + (j9 * j4);
        iArr3[i4 + 2] = (int) j12;
        long j13 = (j12 >>> 32) + (j9 * j5);
        iArr3[i4 + 3] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j6);
        iArr3[i4 + 4] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j7);
        iArr3[i4 + 5] = (int) j15;
        long j16 = j8;
        long j17 = (j15 >>> 32) + (j9 * j16);
        iArr3[i4 + 6] = (int) j17;
        iArr3[i4 + 7] = (int) (j17 >>> 32);
        int i12 = 1;
        int i13 = i4;
        int i14 = 1;
        while (i14 < 7) {
            i13 += i12;
            long j18 = iArr[i2 + i14] & M;
            long j19 = (j18 * j2) + (iArr3[i5] & M) + 0;
            iArr3[i13 + 0] = (int) j19;
            long j20 = j16;
            long j21 = (j19 >>> 32) + (j18 * j3) + (iArr3[i6] & M);
            iArr3[i13 + 1] = (int) j21;
            long j22 = j4;
            long j23 = (j21 >>> 32) + (j18 * j4) + (iArr3[i7] & M);
            iArr3[i13 + 2] = (int) j23;
            long j24 = (j23 >>> 32) + (j18 * j5) + (iArr3[i8] & M);
            iArr3[i13 + 3] = (int) j24;
            long j25 = (j24 >>> 32) + (j18 * j6) + (iArr3[i9] & M);
            iArr3[i13 + 4] = (int) j25;
            long j26 = (j25 >>> 32) + (j18 * j7) + (iArr3[i10] & M);
            iArr3[i13 + 5] = (int) j26;
            long j27 = (j26 >>> 32) + (j18 * j20) + (iArr3[i11] & M);
            iArr3[i13 + 6] = (int) j27;
            iArr3[i13 + 7] = (int) (j27 >>> 32);
            i14++;
            j4 = j22;
            j16 = j20;
            j5 = j5;
            i12 = 1;
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
        long j2 = iArr[i2 + 0] & M;
        int i15 = 0;
        int i16 = 14;
        int i17 = 6;
        while (true) {
            int i18 = i17 - 1;
            long j3 = iArr[i2 + i17] & M;
            long j4 = j3 * j3;
            int i19 = i16 - 1;
            iArr2[i3 + i19] = (i15 << 31) | ((int) (j4 >>> 33));
            i16 = i19 - 1;
            iArr2[i3 + i16] = (int) (j4 >>> 1);
            i15 = (int) j4;
            if (i18 <= 0) {
                long j5 = j2 * j2;
                long j6 = ((i15 << 31) & M) | (j5 >>> 33);
                iArr2[i3 + 0] = (int) j5;
                long j7 = iArr[i2 + 1] & M;
                long j8 = iArr2[i4] & M;
                long j9 = j6 + (j7 * j2);
                int i20 = (int) j9;
                iArr2[i3 + 1] = (i20 << 1) | (((int) (j5 >>> 32)) & 1);
                int i21 = i20 >>> 31;
                long j10 = j8 + (j9 >>> 32);
                long j11 = iArr[i2 + 2] & M;
                long j12 = iArr2[i5] & M;
                long j13 = iArr2[i6] & M;
                long j14 = j10 + (j11 * j2);
                int i22 = (int) j14;
                iArr2[i3 + 2] = (i22 << 1) | i21;
                int i23 = i22 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j11 * j7);
                long j16 = j15 & M;
                long j17 = iArr[i2 + 3] & M;
                long j18 = iArr2[i7] & M;
                long j19 = iArr2[i8] & M;
                long j20 = j16 + (j17 * j2);
                int i24 = (int) j20;
                iArr2[i3 + 3] = (i24 << 1) | i23;
                long j21 = j13 + (j15 >>> 32) + (j20 >>> 32) + (j17 * j7);
                long j22 = j18 + (j21 >>> 32) + (j17 * j11);
                long j23 = j21 & M;
                long j24 = j22 & M;
                long j25 = iArr[i2 + 4] & M;
                long j26 = iArr2[i9] & M;
                long j27 = iArr2[i10] & M;
                long j28 = j23 + (j25 * j2);
                int i25 = (int) j28;
                iArr2[i3 + 4] = (i24 >>> 31) | (i25 << 1);
                int i26 = i25 >>> 31;
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
                int i27 = (int) j39;
                iArr2[i3 + 5] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
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
                long j52 = j42 + (j2 * j49);
                int i29 = (int) j52;
                iArr2[i3 + 6] = (i29 << 1) | i28;
                long j53 = j44 + (j52 >>> 32) + (j49 * j7);
                long j54 = j46 + (j53 >>> 32) + (j49 * j11);
                long j55 = j48 + (j54 >>> 32) + (j49 * j17);
                long j56 = j47 + (j55 >>> 32) + (j49 * j25);
                long j57 = j50 + (j56 >>> 32) + (j49 * j36);
                long j58 = j51 + (j57 >>> 32);
                int i30 = (int) j53;
                iArr2[i3 + 7] = (i29 >>> 31) | (i30 << 1);
                int i31 = i30 >>> 31;
                int i32 = (int) j54;
                iArr2[i3 + 8] = i31 | (i32 << 1);
                int i33 = i32 >>> 31;
                int i34 = (int) j55;
                iArr2[i3 + 9] = i33 | (i34 << 1);
                int i35 = i34 >>> 31;
                int i36 = (int) j56;
                iArr2[i3 + 10] = i35 | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) j57;
                iArr2[i3 + 11] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j58;
                iArr2[i3 + 12] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = i3 + 13;
                iArr2[i42] = i41 | ((iArr2[i42] + ((int) (j58 >> 32))) << 1);
                return;
            }
            i17 = i18;
        }
    }
}