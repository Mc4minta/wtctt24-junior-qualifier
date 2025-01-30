package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

/* loaded from: classes3.dex */
public class Curve25519Field {
    private static final long M = 4294967295L;
    private static final int P7 = Integer.MAX_VALUE;
    private static final int PInv = 19;
    static final int[] P = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    private static final int[] PExt = {361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat256.add(iArr, iArr2, iArr3);
        if (Nat256.gte(iArr3, P)) {
            subPFrom(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat.add(16, iArr, iArr2, iArr3);
        if (Nat.gte(16, iArr3, PExt)) {
            subPExtFrom(iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        Nat.inc(8, iArr, iArr2);
        if (Nat256.gte(iArr2, P)) {
            subPFrom(iArr2);
        }
    }

    private static int addPExtTo(int[] iArr) {
        long j2 = iArr[0] & M;
        int[] iArr2 = PExt;
        long j3 = j2 + (iArr2[0] & M);
        iArr[0] = (int) j3;
        long j4 = j3 >> 32;
        if (j4 != 0) {
            j4 = Nat.incAt(8, iArr, 1);
        }
        long j5 = j4 + ((iArr[8] & M) - 19);
        iArr[8] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            j6 = Nat.decAt(15, iArr, 9);
        }
        long j7 = j6 + (iArr[15] & M) + (M & (iArr2[15] + 1));
        iArr[15] = (int) j7;
        return (int) (j7 >> 32);
    }

    private static int addPTo(int[] iArr) {
        long j2 = (iArr[0] & M) - 19;
        iArr[0] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            j3 = Nat.decAt(7, iArr, 1);
        }
        long j4 = j3 + (M & iArr[7]) + 2147483648L;
        iArr[7] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat256.fromBigInteger(bigInteger);
        while (true) {
            int[] iArr = P;
            if (!Nat256.gte(fromBigInteger, iArr)) {
                return fromBigInteger;
            }
            Nat256.subFrom(iArr, fromBigInteger);
        }
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(8, iArr, 0, iArr2);
            return;
        }
        Nat256.add(iArr, P, iArr2);
        Nat.shiftDownBit(8, iArr2, 0);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat256.createExt();
        Nat256.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat256.mulAddTo(iArr, iArr2, iArr3);
        if (Nat.gte(16, iArr3, PExt)) {
            subPExtFrom(iArr3);
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
        int i2 = iArr[7];
        Nat.shiftUpBit(8, iArr, 8, i2, iArr2, 0);
        int i3 = iArr2[7];
        iArr2[7] = (i3 & Integer.MAX_VALUE) + Nat.addWordTo(7, ((Nat256.mulByWordAddTo(19, iArr, iArr2) << 1) + ((i3 >>> 31) - (i2 >>> 31))) * 19, iArr2);
        if (Nat256.gte(iArr2, P)) {
            subPFrom(iArr2);
        }
    }

    public static void reduce27(int i2, int[] iArr) {
        int i3 = iArr[7];
        iArr[7] = (i3 & Integer.MAX_VALUE) + Nat.addWordTo(7, ((i2 << 1) | (i3 >>> 31)) * 19, iArr);
        if (Nat256.gte(iArr, P)) {
            subPFrom(iArr);
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

    private static int subPExtFrom(int[] iArr) {
        long j2 = iArr[0] & M;
        int[] iArr2 = PExt;
        long j3 = j2 - (iArr2[0] & M);
        iArr[0] = (int) j3;
        long j4 = j3 >> 32;
        if (j4 != 0) {
            j4 = Nat.decAt(8, iArr, 1);
        }
        long j5 = j4 + (iArr[8] & M) + 19;
        iArr[8] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            j6 = Nat.incAt(15, iArr, 9);
        }
        long j7 = j6 + ((iArr[15] & M) - (M & (iArr2[15] + 1)));
        iArr[15] = (int) j7;
        return (int) (j7 >> 32);
    }

    private static int subPFrom(int[] iArr) {
        long j2 = (iArr[0] & M) + 19;
        iArr[0] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            j3 = Nat.incAt(7, iArr, 1);
        }
        long j4 = j3 + ((M & iArr[7]) - 2147483648L);
        iArr[7] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.sub(iArr, iArr2, iArr3) != 0) {
            addPTo(iArr3);
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(16, iArr, iArr2, iArr3) != 0) {
            addPExtTo(iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        Nat.shiftUpBit(8, iArr, 0, iArr2);
        if (Nat256.gte(iArr2, P)) {
            subPFrom(iArr2);
        }
    }
}