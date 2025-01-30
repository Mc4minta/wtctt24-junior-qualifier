package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat512;

/* loaded from: classes3.dex */
public class SecP521R1Field {
    private static final int P16 = 511;
    static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, P16};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        int add = Nat.add(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (add > P16 || (add == P16 && Nat.eq(16, iArr3, P))) {
            add = (add + Nat.inc(16, iArr3)) & P16;
        }
        iArr3[16] = add;
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        int inc = Nat.inc(16, iArr, iArr2) + iArr[16];
        if (inc > P16 || (inc == P16 && Nat.eq(16, iArr2, P))) {
            inc = (inc + Nat.inc(16, iArr2)) & P16;
        }
        iArr2[16] = inc;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(521, bigInteger);
        if (Nat.eq(17, fromBigInteger, P)) {
            Nat.zero(17, fromBigInteger);
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        int i2 = iArr[16];
        iArr2[16] = (Nat.shiftDownBit(16, iArr, i2, iArr2) >>> 23) | (i2 >>> 1);
    }

    protected static void implMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat512.mul(iArr, iArr2, iArr3);
        int i2 = iArr[16];
        int i3 = iArr2[16];
        iArr3[32] = Nat.mul31BothAdd(16, i2, iArr2, i3, iArr, iArr3, 16) + (i2 * i3);
    }

    protected static void implSquare(int[] iArr, int[] iArr2) {
        Nat512.square(iArr, iArr2);
        int i2 = iArr[16];
        iArr2[32] = Nat.mulWordAddTo(16, i2 << 1, iArr, 0, iArr2, 16) + (i2 * i2);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(33);
        implMultiply(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat.isZero(17, iArr)) {
            Nat.zero(17, iArr2);
        } else {
            Nat.sub(17, P, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int i2 = iArr[32];
        int shiftDownBits = (Nat.shiftDownBits(16, iArr, 16, 9, i2, iArr2, 0) >>> 23) + (i2 >>> 9) + Nat.addTo(16, iArr, iArr2);
        if (shiftDownBits > P16 || (shiftDownBits == P16 && Nat.eq(16, iArr2, P))) {
            shiftDownBits = (shiftDownBits + Nat.inc(16, iArr2)) & P16;
        }
        iArr2[16] = shiftDownBits;
    }

    public static void reduce23(int[] iArr) {
        int i2 = iArr[16];
        int addWordTo = Nat.addWordTo(16, i2 >>> 9, iArr) + (i2 & P16);
        if (addWordTo > P16 || (addWordTo == P16 && Nat.eq(16, iArr, P))) {
            addWordTo = (addWordTo + Nat.inc(16, iArr)) & P16;
        }
        iArr[16] = addWordTo;
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(33);
        implSquare(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i2, int[] iArr2) {
        int[] create = Nat.create(33);
        implSquare(iArr, create);
        reduce(create, iArr2);
        while (true) {
            i2--;
            if (i2 <= 0) {
                return;
            }
            implSquare(iArr2, create);
            reduce(create, iArr2);
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        int sub = (Nat.sub(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (sub < 0) {
            sub = (sub + Nat.dec(16, iArr3)) & P16;
        }
        iArr3[16] = sub;
    }

    public static void twice(int[] iArr, int[] iArr2) {
        int i2 = iArr[16];
        iArr2[16] = (Nat.shiftUpBit(16, iArr, i2 << 23, iArr2) | (i2 << 1)) & P16;
    }
}