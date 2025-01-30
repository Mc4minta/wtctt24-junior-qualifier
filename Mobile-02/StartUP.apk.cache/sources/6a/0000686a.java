package org.spongycastle.math.raw;

import java.util.Random;

/* loaded from: classes3.dex */
public abstract class Mod {
    public static void add(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.add(length, iArr2, iArr3, iArr4) != 0) {
            Nat.subFrom(length, iArr, iArr4);
        }
    }

    private static int getTrailingZeroes(int i2) {
        int i3 = 0;
        while ((i2 & 1) == 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    public static int inverse32(int i2) {
        int i3 = (2 - (i2 * i2)) * i2;
        int i4 = i3 * (2 - (i2 * i3));
        int i5 = i4 * (2 - (i2 * i4));
        return i5 * (2 - (i2 * i5));
    }

    private static void inversionResult(int[] iArr, int i2, int[] iArr2, int[] iArr3) {
        if (i2 < 0) {
            Nat.add(iArr.length, iArr2, iArr, iArr3);
        } else {
            System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
        }
    }

    private static int inversionStep(int[] iArr, int[] iArr2, int i2, int[] iArr3, int i3) {
        int subFrom;
        int length = iArr.length;
        int i4 = 0;
        while (iArr2[0] == 0) {
            Nat.shiftDownWord(i2, iArr2, 0);
            i4 += 32;
        }
        int trailingZeroes = getTrailingZeroes(iArr2[0]);
        if (trailingZeroes > 0) {
            Nat.shiftDownBits(i2, iArr2, trailingZeroes, 0);
            i4 += trailingZeroes;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if ((iArr3[0] & 1) != 0) {
                if (i3 < 0) {
                    subFrom = Nat.addTo(length, iArr, iArr3);
                } else {
                    subFrom = Nat.subFrom(length, iArr, iArr3);
                }
                i3 += subFrom;
            }
            Nat.shiftDownBit(length, iArr3, i3);
        }
        return i3;
    }

    public static void invert(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        if (!Nat.isZero(length, iArr2)) {
            int i2 = 0;
            if (Nat.isOne(length, iArr2)) {
                System.arraycopy(iArr2, 0, iArr3, 0, length);
                return;
            }
            int[] copy = Nat.copy(length, iArr2);
            int[] create = Nat.create(length);
            create[0] = 1;
            int inversionStep = (1 & copy[0]) == 0 ? inversionStep(iArr, copy, length, create, 0) : 0;
            if (Nat.isOne(length, copy)) {
                inversionResult(iArr, inversionStep, create, iArr3);
                return;
            }
            int[] copy2 = Nat.copy(length, iArr);
            int[] create2 = Nat.create(length);
            int i3 = length;
            while (true) {
                int i4 = i3 - 1;
                if (copy[i4] == 0 && copy2[i4] == 0) {
                    i3--;
                } else if (Nat.gte(i3, copy, copy2)) {
                    Nat.subFrom(i3, copy2, copy);
                    inversionStep = inversionStep(iArr, copy, i3, create, inversionStep + (Nat.subFrom(length, create2, create) - i2));
                    if (Nat.isOne(i3, copy)) {
                        inversionResult(iArr, inversionStep, create, iArr3);
                        return;
                    }
                } else {
                    Nat.subFrom(i3, copy, copy2);
                    i2 = inversionStep(iArr, copy2, i3, create2, i2 + (Nat.subFrom(length, create, create2) - inversionStep));
                    if (Nat.isOne(i3, copy2)) {
                        inversionResult(iArr, i2, create2, iArr3);
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("'x' cannot be 0");
        }
    }

    public static int[] random(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] create = Nat.create(length);
        int i2 = length - 1;
        int i3 = iArr[i2];
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        do {
            for (int i9 = 0; i9 != length; i9++) {
                create[i9] = random.nextInt();
            }
            create[i2] = create[i2] & i8;
        } while (Nat.gte(length, create, iArr));
        return create;
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int length = iArr.length;
        if (Nat.sub(length, iArr2, iArr3, iArr4) != 0) {
            Nat.addTo(length, iArr, iArr4);
        }
    }
}