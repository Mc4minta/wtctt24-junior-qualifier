package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

/* loaded from: classes3.dex */
public class SecP224R1Field {
    private static final long M = 4294967295L;
    private static final int P6 = -1;
    private static final int PExt13 = -1;
    static final int[] P = {1, 0, 0, -1, -1, -1, -1};
    static final int[] PExt = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
    private static final int[] PExtInv = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.add(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && Nat224.gte(iArr3, P))) {
            addPInvTo(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && Nat.gte(14, iArr3, PExt))) {
            int[] iArr4 = PExtInv;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && Nat224.gte(iArr2, P))) {
            addPInvTo(iArr2);
        }
    }

    private static void addPInvTo(int[] iArr) {
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
        long j6 = j3 + (M & iArr[3]) + 1;
        iArr[3] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.incAt(7, iArr, 4);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat224.fromBigInteger(bigInteger);
        if (fromBigInteger[6] == -1) {
            int[] iArr = P;
            if (Nat224.gte(fromBigInteger, iArr)) {
                Nat224.subFrom(iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(7, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(7, iArr2, Nat224.add(iArr, P, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat224.createExt();
        Nat224.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && Nat.gte(14, iArr3, PExt))) {
            int[] iArr4 = PExtInv;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat224.isZero(iArr)) {
            Nat224.zero(iArr2);
        } else {
            Nat224.sub(P, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j2 = iArr[10] & M;
        long j3 = iArr[11] & M;
        long j4 = iArr[12] & M;
        long j5 = iArr[13] & M;
        long j6 = ((iArr[7] & M) + j3) - 1;
        long j7 = (iArr[8] & M) + j4;
        long j8 = (iArr[9] & M) + j5;
        long j9 = ((iArr[0] & M) - j6) + 0;
        long j10 = j9 & M;
        long j11 = (j9 >> 32) + ((iArr[1] & M) - j7);
        iArr2[1] = (int) j11;
        long j12 = (j11 >> 32) + ((iArr[2] & M) - j8);
        iArr2[2] = (int) j12;
        long j13 = (j12 >> 32) + (((iArr[3] & M) + j6) - j2);
        long j14 = j13 & M;
        long j15 = (j13 >> 32) + (((iArr[4] & M) + j7) - j3);
        iArr2[4] = (int) j15;
        long j16 = (j15 >> 32) + (((iArr[5] & M) + j8) - j4);
        iArr2[5] = (int) j16;
        long j17 = (j16 >> 32) + (((iArr[6] & M) + j2) - j5);
        iArr2[6] = (int) j17;
        long j18 = (j17 >> 32) + 1;
        long j19 = j14 + j18;
        long j20 = j10 - j18;
        iArr2[0] = (int) j20;
        long j21 = j20 >> 32;
        if (j21 != 0) {
            long j22 = j21 + (iArr2[1] & M);
            iArr2[1] = (int) j22;
            long j23 = (j22 >> 32) + (M & iArr2[2]);
            iArr2[2] = (int) j23;
            j19 += j23 >> 32;
        }
        iArr2[3] = (int) j19;
        if (((j19 >> 32) == 0 || Nat.incAt(7, iArr2, 4) == 0) && !(iArr2[6] == -1 && Nat224.gte(iArr2, P))) {
            return;
        }
        addPInvTo(iArr2);
    }

    public static void reduce32(int i2, int[] iArr) {
        long j2;
        if (i2 != 0) {
            long j3 = i2 & M;
            long j4 = ((iArr[0] & M) - j3) + 0;
            iArr[0] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (iArr[1] & M);
                iArr[1] = (int) j6;
                long j7 = (j6 >> 32) + (iArr[2] & M);
                iArr[2] = (int) j7;
                j5 = j7 >> 32;
            }
            long j8 = j5 + (M & iArr[3]) + j3;
            iArr[3] = (int) j8;
            j2 = j8 >> 32;
        } else {
            j2 = 0;
        }
        if ((j2 == 0 || Nat.incAt(7, iArr, 4) == 0) && !(iArr[6] == -1 && Nat224.gte(iArr, P))) {
            return;
        }
        addPInvTo(iArr);
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] createExt = Nat224.createExt();
        Nat224.square(iArr, createExt);
        reduce(createExt, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] createExt = Nat224.createExt();
        Nat224.square(iArr, createExt);
        reduce(createExt, iArr2);
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            Nat224.square(iArr2, createExt);
            reduce(createExt, iArr2);
        }
    }

    private static void subPInvFrom(int[] iArr) {
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
        long j6 = j3 + ((M & iArr[3]) - 1);
        iArr[3] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.decAt(7, iArr, 4);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.sub(iArr, iArr2, iArr3) != 0) {
            subPInvFrom(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = PExtInv;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && Nat224.gte(iArr2, P))) {
            addPInvTo(iArr2);
        }
    }
}