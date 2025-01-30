package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

/* loaded from: classes3.dex */
public class SecP256R1Field {
    private static final long M = 4294967295L;
    private static final int P7 = -1;
    private static final int PExt15 = -1;
    static final int[] P = {-1, -1, -1, 0, 0, 0, 1, -1};
    static final int[] PExt = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && Nat256.gte(iArr3, P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(16, iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && Nat.gte(16, iArr3, PExt))) {
            Nat.subFrom(16, PExt, iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && Nat256.gte(iArr2, P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
        long j2 = (iArr[0] & M) + 1;
        iArr[0] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (iArr[1] & M);
            iArr[1] = (int) j4;
            long j5 = (j4 >> 32) + (iArr[2] & M);
            iArr[2] = (int) j5;
            j3 = j5 >> 32;
        }
        long j6 = j3 + ((iArr[3] & M) - 1);
        iArr[3] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (iArr[4] & M);
            iArr[4] = (int) j8;
            long j9 = (j8 >> 32) + (iArr[5] & M);
            iArr[5] = (int) j9;
            j7 = j9 >> 32;
        }
        long j10 = j7 + ((iArr[6] & M) - 1);
        iArr[6] = (int) j10;
        iArr[7] = (int) ((j10 >> 32) + (M & iArr[7]) + 1);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat256.fromBigInteger(bigInteger);
        if (fromBigInteger[7] == -1) {
            int[] iArr = P;
            if (Nat256.gte(fromBigInteger, iArr)) {
                Nat256.subFrom(iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(8, iArr2, Nat256.add(iArr, P, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat256.createExt();
        Nat256.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && Nat.gte(16, iArr3, PExt))) {
            Nat.subFrom(16, PExt, iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat256.isZero(iArr)) {
            Nat256.zero(iArr2);
        } else {
            Nat256.sub(P, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j2 = iArr[8] & M;
        long j3 = iArr[9] & M;
        long j4 = iArr[10] & M;
        long j5 = iArr[11] & M;
        long j6 = iArr[12] & M;
        long j7 = iArr[13] & M;
        long j8 = iArr[14] & M;
        long j9 = iArr[15] & M;
        long j10 = j2 - 6;
        long j11 = j10 + j3;
        long j12 = j3 + j4;
        long j13 = (j4 + j5) - j9;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j7 + j8;
        long j17 = j8 + j9;
        long j18 = ((((iArr[0] & M) + j11) - j14) - j16) + 0;
        iArr2[0] = (int) j18;
        long j19 = (j18 >> 32) + ((((iArr[1] & M) + j12) - j15) - j17);
        iArr2[1] = (int) j19;
        long j20 = (j19 >> 32) + (((iArr[2] & M) + j13) - j16);
        iArr2[2] = (int) j20;
        long j21 = (j20 >> 32) + (((((iArr[3] & M) + (j14 << 1)) + j7) - j9) - j11);
        iArr2[3] = (int) j21;
        long j22 = (j21 >> 32) + ((((iArr[4] & M) + (j15 << 1)) + j8) - j12);
        iArr2[4] = (int) j22;
        long j23 = (j22 >> 32) + (((iArr[5] & M) + (j16 << 1)) - j13);
        iArr2[5] = (int) j23;
        long j24 = (j23 >> 32) + ((((iArr[6] & M) + (j17 << 1)) + j16) - j11);
        iArr2[6] = (int) j24;
        long j25 = (j24 >> 32) + (((((iArr[7] & M) + (j9 << 1)) + j10) - j13) - j15);
        iArr2[7] = (int) j25;
        reduce32((int) ((j25 >> 32) + 6), iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        long j2;
        if (i2 != 0) {
            long j3 = i2 & M;
            long j4 = (iArr[0] & M) + j3 + 0;
            iArr[0] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (iArr[1] & M);
                iArr[1] = (int) j6;
                long j7 = (j6 >> 32) + (iArr[2] & M);
                iArr[2] = (int) j7;
                j5 = j7 >> 32;
            }
            long j8 = j5 + ((iArr[3] & M) - j3);
            iArr[3] = (int) j8;
            long j9 = j8 >> 32;
            if (j9 != 0) {
                long j10 = j9 + (iArr[4] & M);
                iArr[4] = (int) j10;
                long j11 = (j10 >> 32) + (iArr[5] & M);
                iArr[5] = (int) j11;
                j9 = j11 >> 32;
            }
            long j12 = j9 + ((iArr[6] & M) - j3);
            iArr[6] = (int) j12;
            long j13 = (j12 >> 32) + (M & iArr[7]) + j3;
            iArr[7] = (int) j13;
            j2 = j13 >> 32;
        } else {
            j2 = 0;
        }
        if (j2 != 0 || (iArr[7] == -1 && Nat256.gte(iArr, P))) {
            addPInvTo(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] createExt = Nat256.createExt();
        Nat256.square(iArr, createExt);
        reduce(createExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] createExt = Nat256.createExt();
        Nat256.square(iArr, createExt);
        reduce(createExt, iArr2);
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            Nat256.square(iArr2, createExt);
            reduce(createExt, iArr2);
        }
    }

    private static void subPInvFrom(int[] iArr) {
        long j2 = (iArr[0] & M) - 1;
        iArr[0] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (iArr[1] & M);
            iArr[1] = (int) j4;
            long j5 = (j4 >> 32) + (iArr[2] & M);
            iArr[2] = (int) j5;
            j3 = j5 >> 32;
        }
        long j6 = j3 + (iArr[3] & M) + 1;
        iArr[3] = (int) j6;
        long j7 = j6 >> 32;
        if (j7 != 0) {
            long j8 = j7 + (iArr[4] & M);
            iArr[4] = (int) j8;
            long j9 = (j8 >> 32) + (iArr[5] & M);
            iArr[5] = (int) j9;
            j7 = j9 >> 32;
        }
        long j10 = j7 + (iArr[6] & M) + 1;
        iArr[6] = (int) j10;
        iArr[7] = (int) ((j10 >> 32) + ((M & iArr[7]) - 1));
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(16, iArr, iArr2, iArr3) != 0) {
            Nat.addTo(16, PExt, iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && Nat256.gte(iArr2, P))) {
            addPInvTo(iArr2);
        }
    }
}