package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public abstract class Nat160 {
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
        return (int) (j6 >>> 32);
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
        return (int) (j6 >>> 32);
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
        long j6 = (j5 >>> 32) + (iArr[4] & M) + (M & iArr2[4]);
        iArr2[4] = (int) j6;
        return (int) (j6 >>> 32);
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
        long j6 = (j5 >>> 32) + (iArr[i16] & M) + (M & iArr2[i17]);
        int i18 = (int) j6;
        iArr[i16] = i18;
        iArr2[i17] = i18;
        return (int) (j6 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
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
        for (int i2 = 4; i2 >= 0; i2--) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 160) {
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
            if (i4 < 0 || i4 >= 5) {
                return 0;
            }
            i3 = iArr[i4] >>> (i2 & 31);
        }
        return i3 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i2 = 4; i2 >= 0; i2--) {
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
        for (int i2 = 1; i2 < 5; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i2 = 0; i2 < 5; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j2 = iArr2[0] & M;
        int i2 = 1;
        long j3 = iArr2[1] & M;
        long j4 = iArr2[2] & M;
        long j5 = iArr2[3] & M;
        long j6 = iArr2[4] & M;
        long j7 = iArr[0] & M;
        long j8 = (j7 * j2) + 0;
        iArr3[0] = (int) j8;
        long j9 = (j8 >>> 32) + (j7 * j3);
        iArr3[1] = (int) j9;
        long j10 = (j9 >>> 32) + (j7 * j4);
        iArr3[2] = (int) j10;
        long j11 = (j10 >>> 32) + (j7 * j5);
        iArr3[3] = (int) j11;
        long j12 = (j11 >>> 32) + (j7 * j6);
        iArr3[4] = (int) j12;
        iArr3[5] = (int) (j12 >>> 32);
        for (int i3 = 5; i2 < i3; i3 = 5) {
            long j13 = iArr[i2] & M;
            int i4 = i2 + 0;
            long j14 = (j13 * j2) + (iArr3[i4] & M) + 0;
            iArr3[i4] = (int) j14;
            int i5 = i2 + 1;
            long j15 = j3;
            long j16 = (j14 >>> 32) + (j13 * j3) + (iArr3[i5] & M);
            iArr3[i5] = (int) j16;
            int i6 = i2 + 2;
            long j17 = j6;
            long j18 = (j16 >>> 32) + (j13 * j4) + (iArr3[i6] & M);
            iArr3[i6] = (int) j18;
            int i7 = i2 + 3;
            long j19 = (j18 >>> 32) + (j13 * j5) + (iArr3[i7] & M);
            iArr3[i7] = (int) j19;
            int i8 = i2 + 4;
            long j20 = (j19 >>> 32) + (j13 * j17) + (iArr3[i8] & M);
            iArr3[i8] = (int) j20;
            iArr3[i2 + 5] = (int) (j20 >>> 32);
            i2 = i5;
            j6 = j17;
            j2 = j2;
            j3 = j15;
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
        long j13 = (j11 >>> 32) + (j2 * j12) + j10 + (M & iArr2[i4 + 4]);
        iArr3[i5 + 4] = (int) j13;
        return (j13 >>> 32) + j12;
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
        return Nat.incAt(5, iArr, i3, 4);
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
        return Nat.incAt(5, iArr, i4, 3);
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        long j2 = M;
        long j3 = iArr2[0] & M;
        long j4 = iArr2[1] & M;
        long j5 = iArr2[2] & M;
        long j6 = iArr2[3] & M;
        long j7 = iArr2[4] & M;
        long j8 = 0;
        while (i7 < 5) {
            long j9 = iArr[i7] & j2;
            long j10 = (j9 * j3) + (iArr3[i2] & j2) + 0;
            iArr3[i7 + 0] = (int) j10;
            int i8 = i7 + 1;
            long j11 = j4;
            long j12 = (j10 >>> 32) + (j9 * j4) + (iArr3[i8] & M);
            iArr3[i8] = (int) j12;
            long j13 = j5;
            long j14 = (j12 >>> 32) + (j9 * j5) + (iArr3[i3] & M);
            iArr3[i7 + 2] = (int) j14;
            long j15 = (j14 >>> 32) + (j9 * j6) + (iArr3[i4] & M);
            iArr3[i7 + 3] = (int) j15;
            long j16 = (j15 >>> 32) + (j9 * j7) + (iArr3[i5] & M);
            iArr3[i7 + 4] = (int) j16;
            long j17 = (j16 >>> 32) + j8 + (iArr3[i6] & M);
            iArr3[i7 + 5] = (int) j17;
            j8 = j17 >>> 32;
            i7 = i8;
            j2 = 4294967295L;
            j3 = j3;
            j5 = j13;
            j4 = j11;
        }
        return (int) j8;
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
        } while (i4 < 5);
        return (int) j3;
    }

    public static int mulWordAddExt(int i2, int[] iArr, int i3, int[] iArr2, int i4) {
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
        long j7 = (j6 >>> 32) + (j2 * (iArr[i3 + 4] & M)) + (iArr2[i9] & M);
        iArr2[i9] = (int) j7;
        return (int) (j7 >>> 32);
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
        return Nat.incAt(5, iArr, i3, 3);
    }

    public static int mulWordsAdd(int i2, int i3, int[] iArr, int i4) {
        long j2 = (i3 & M) * (i2 & M);
        int i5 = i4 + 0;
        long j3 = j2 + (iArr[i5] & M) + 0;
        iArr[i5] = (int) j3;
        int i6 = i4 + 1;
        long j4 = (j3 >>> 32) + (M & iArr[i6]);
        iArr[i6] = (int) j4;
        if ((j4 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i4, 2);
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j2 = iArr[0] & M;
        int i2 = 10;
        int i3 = 0;
        int i4 = 4;
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
                int i10 = i9 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j11 * j7);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & M;
                long j18 = iArr[3] & M;
                long j19 = iArr2[5] & M;
                long j20 = iArr2[6] & M;
                long j21 = j17 + (j18 * j2);
                int i11 = (int) j21;
                iArr2[3] = (i11 << 1) | i10;
                long j22 = j16 + (j21 >>> 32) + (j18 * j7);
                long j23 = j19 + (j22 >>> 32) + (j18 * j11);
                long j24 = j22 & M;
                long j25 = j20 + (j23 >>> 32);
                long j26 = j23 & M;
                long j27 = iArr[4] & M;
                long j28 = iArr2[7] & M;
                long j29 = M & iArr2[8];
                long j30 = j24 + (j27 * j2);
                int i12 = (int) j30;
                iArr2[4] = (i11 >>> 31) | (i12 << 1);
                long j31 = j26 + (j30 >>> 32) + (j27 * j7);
                long j32 = j25 + (j31 >>> 32) + (j27 * j11);
                long j33 = j28 + (j32 >>> 32) + (j27 * j18);
                long j34 = j29 + (j33 >>> 32);
                int i13 = (int) j31;
                iArr2[5] = (i13 << 1) | (i12 >>> 31);
                int i14 = (int) j32;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                int i15 = (int) j33;
                iArr2[7] = (i15 << 1) | (i14 >>> 31);
                int i16 = (int) j34;
                iArr2[8] = (i15 >>> 31) | (i16 << 1);
                iArr2[9] = (i16 >>> 31) | ((iArr2[9] + ((int) (j34 >> 32))) << 1);
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
        return (int) (j6 >> 32);
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
        return (int) (j6 >> 32);
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
        long j6 = (j5 >> 32) + ((iArr2[4] & M) - (M & iArr[4]));
        iArr2[4] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                Pack.intToBigEndian(i3, bArr, (4 - i2) << 2);
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
    }

    public static boolean gte(int[] iArr, int i2, int[] iArr2, int i3) {
        for (int i4 = 4; i4 >= 0; i4--) {
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
        long j6 = (j5 >>> 32) + (iArr[i2 + 4] & M) + (M & iArr2[i9]);
        iArr2[i9] = (int) j6;
        return (int) (j6 >>> 32);
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
        return (int) (j6 >> 32);
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
        return (int) (j6 >> 32);
    }

    public static int mulAddTo(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j2 = M;
        long j3 = iArr2[i3 + 0] & M;
        long j4 = iArr2[i3 + 1] & M;
        long j5 = iArr2[i3 + 2] & M;
        long j6 = iArr2[i3 + 3] & M;
        long j7 = iArr2[i3 + 4] & M;
        int i10 = 0;
        long j8 = 0;
        int i11 = i4;
        while (i10 < 5) {
            long j9 = iArr[i2 + i10] & j2;
            long j10 = (j9 * j3) + (iArr3[i5] & j2) + 0;
            iArr3[i11 + 0] = (int) j10;
            int i12 = i11 + 1;
            long j11 = j4;
            long j12 = (j10 >>> 32) + (j9 * j4) + (iArr3[i12] & M);
            iArr3[i12] = (int) j12;
            long j13 = j5;
            long j14 = (j12 >>> 32) + (j9 * j5) + (iArr3[i6] & M);
            iArr3[i11 + 2] = (int) j14;
            long j15 = (j14 >>> 32) + (j9 * j6) + (iArr3[i7] & M);
            iArr3[i11 + 3] = (int) j15;
            long j16 = (j15 >>> 32) + (j9 * j7) + (iArr3[i8] & M);
            iArr3[i11 + 4] = (int) j16;
            long j17 = (j16 >>> 32) + j8 + (iArr3[i9] & M);
            iArr3[i11 + 5] = (int) j17;
            j8 = j17 >>> 32;
            i10++;
            i11 = i12;
            j3 = j3;
            j2 = 4294967295L;
            j4 = j11;
            j5 = j13;
        }
        return (int) j8;
    }

    public static void mul(int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j2 = iArr2[i3 + 0] & M;
        long j3 = iArr2[i3 + 1] & M;
        long j4 = iArr2[i3 + 2] & M;
        long j5 = iArr2[i3 + 3] & M;
        long j6 = iArr2[i3 + 4] & M;
        long j7 = iArr[i2 + 0] & M;
        long j8 = (j7 * j2) + 0;
        iArr3[i4 + 0] = (int) j8;
        long j9 = (j8 >>> 32) + (j7 * j3);
        iArr3[i4 + 1] = (int) j9;
        long j10 = (j9 >>> 32) + (j7 * j4);
        iArr3[i4 + 2] = (int) j10;
        long j11 = (j10 >>> 32) + (j7 * j5);
        iArr3[i4 + 3] = (int) j11;
        long j12 = (j11 >>> 32) + (j7 * j6);
        iArr3[i4 + 4] = (int) j12;
        iArr3[i4 + 5] = (int) (j12 >>> 32);
        int i10 = 1;
        int i11 = i4;
        int i12 = 1;
        while (i12 < 5) {
            i11 += i10;
            long j13 = iArr[i2 + i12] & M;
            long j14 = (j13 * j2) + (iArr3[i5] & M) + 0;
            iArr3[i11 + 0] = (int) j14;
            long j15 = (j14 >>> 32) + (j13 * j3) + (iArr3[i6] & M);
            iArr3[i11 + 1] = (int) j15;
            long j16 = (j15 >>> 32) + (j13 * j4) + (iArr3[i7] & M);
            iArr3[i11 + 2] = (int) j16;
            long j17 = (j16 >>> 32) + (j13 * j5) + (iArr3[i8] & M);
            iArr3[i11 + 3] = (int) j17;
            long j18 = (j17 >>> 32) + (j13 * j6) + (iArr3[i9] & M);
            iArr3[i11 + 4] = (int) j18;
            iArr3[i11 + 5] = (int) (j18 >>> 32);
            i12++;
            j4 = j4;
            j2 = j2;
            i10 = 1;
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
        long j2 = iArr[i2 + 0] & M;
        int i11 = 0;
        int i12 = 10;
        int i13 = 4;
        while (true) {
            int i14 = i13 - 1;
            long j3 = iArr[i2 + i13] & M;
            long j4 = j3 * j3;
            int i15 = i12 - 1;
            iArr2[i3 + i15] = (i11 << 31) | ((int) (j4 >>> 33));
            i12 = i15 - 1;
            iArr2[i3 + i12] = (int) (j4 >>> 1);
            i11 = (int) j4;
            if (i14 <= 0) {
                long j5 = j2 * j2;
                long j6 = ((i11 << 31) & M) | (j5 >>> 33);
                iArr2[i3 + 0] = (int) j5;
                long j7 = iArr[i2 + 1] & M;
                long j8 = iArr2[i4] & M;
                long j9 = j6 + (j7 * j2);
                int i16 = (int) j9;
                iArr2[i3 + 1] = (i16 << 1) | (((int) (j5 >>> 32)) & 1);
                int i17 = i16 >>> 31;
                long j10 = j8 + (j9 >>> 32);
                long j11 = iArr[i2 + 2] & M;
                long j12 = iArr2[i5] & M;
                long j13 = iArr2[i6] & M;
                long j14 = j10 + (j11 * j2);
                int i18 = (int) j14;
                iArr2[i3 + 2] = (i18 << 1) | i17;
                int i19 = i18 >>> 31;
                long j15 = j12 + (j14 >>> 32) + (j11 * j7);
                long j16 = j15 & M;
                long j17 = iArr[i2 + 3] & M;
                long j18 = iArr2[i7] & M;
                long j19 = iArr2[i8] & M;
                long j20 = j16 + (j17 * j2);
                int i20 = (int) j20;
                iArr2[i3 + 3] = (i20 << 1) | i19;
                long j21 = j13 + (j15 >>> 32) + (j20 >>> 32) + (j17 * j7);
                long j22 = j18 + (j21 >>> 32) + (j17 * j11);
                long j23 = j21 & M;
                long j24 = j22 & M;
                long j25 = iArr[i2 + 4] & M;
                long j26 = iArr2[i9] & M;
                long j27 = iArr2[i10] & M;
                long j28 = j23 + (j2 * j25);
                int i21 = (int) j28;
                iArr2[i3 + 4] = (i21 << 1) | (i20 >>> 31);
                long j29 = j24 + (j28 >>> 32) + (j25 * j7);
                long j30 = j19 + (j22 >>> 32) + (j29 >>> 32) + (j25 * j11);
                long j31 = j26 + (j30 >>> 32) + (j25 * j17);
                long j32 = j27 + (j31 >>> 32);
                int i22 = (int) j29;
                iArr2[i3 + 5] = (i21 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j30;
                iArr2[i3 + 6] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j31;
                iArr2[i3 + 7] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j32;
                iArr2[i3 + 8] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = i3 + 9;
                iArr2[i30] = i29 | ((iArr2[i30] + ((int) (j32 >> 32))) << 1);
                return;
            }
            i13 = i14;
        }
    }
}