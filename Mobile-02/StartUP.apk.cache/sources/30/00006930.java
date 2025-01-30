package org.spongycastle.pqc.math.ntru.euclid;

/* loaded from: classes3.dex */
public class IntEuclidean {
    public int gcd;
    public int x;
    public int y;

    private IntEuclidean() {
    }

    public static IntEuclidean calculate(int i2, int i3) {
        int i4 = 1;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        int i8 = i2;
        int i9 = i3;
        while (i9 != 0) {
            int i10 = i8 / i9;
            int i11 = i8 % i9;
            int i12 = i7 - (i10 * i6);
            i8 = i9;
            i9 = i11;
            int i13 = i5;
            i5 = i4 - (i10 * i5);
            i4 = i13;
            i7 = i6;
            i6 = i12;
        }
        IntEuclidean intEuclidean = new IntEuclidean();
        intEuclidean.x = i4;
        intEuclidean.y = i7;
        intEuclidean.gcd = i8;
        return intEuclidean;
    }
}