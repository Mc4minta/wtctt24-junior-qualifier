package org.spongycastle.pqc.math.ntru.polynomial;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class LongPolynomial5 {
    private long[] coeffs;
    private int numCoeffs;

    public LongPolynomial5(IntegerPolynomial integerPolynomial) {
        int length = integerPolynomial.coeffs.length;
        this.numCoeffs = length;
        this.coeffs = new long[(length + 4) / 5];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.numCoeffs; i4++) {
            long[] jArr = this.coeffs;
            jArr[i2] = jArr[i2] | (integerPolynomial.coeffs[i4] << i3);
            i3 += 12;
            if (i3 >= 60) {
                i2++;
                i3 = 0;
            }
        }
    }

    public LongPolynomial5 mult(TernaryPolynomial ternaryPolynomial) {
        long j2;
        int i2;
        long[][] jArr = (long[][]) Array.newInstance(long.class, 5, (this.coeffs.length + ((ternaryPolynomial.size() + 4) / 5)) - 1);
        int[] ones = ternaryPolynomial.getOnes();
        for (int i3 = 0; i3 != ones.length; i3++) {
            int i4 = ones[i3];
            int i5 = i4 / 5;
            int i6 = i4 - (i5 * 5);
            int i7 = 0;
            while (true) {
                long[] jArr2 = this.coeffs;
                if (i7 < jArr2.length) {
                    jArr[i6][i5] = (jArr[i6][i5] + jArr2[i7]) & 576319980446939135L;
                    i5++;
                    i7++;
                }
            }
        }
        int[] negOnes = ternaryPolynomial.getNegOnes();
        for (int i8 = 0; i8 != negOnes.length; i8++) {
            int i9 = negOnes[i8];
            int i10 = i9 / 5;
            int i11 = i9 - (i10 * 5);
            int i12 = 0;
            while (true) {
                long[] jArr3 = this.coeffs;
                if (i12 < jArr3.length) {
                    jArr[i11][i10] = ((jArr[i11][i10] + 576601524159907840L) - jArr3[i12]) & 576319980446939135L;
                    i10++;
                    i12++;
                }
            }
        }
        long[] copyOf = Arrays.copyOf(jArr[0], jArr[0].length + 1);
        for (int i13 = 1; i13 <= 4; i13++) {
            int i14 = i13 * 12;
            int i15 = 60 - i14;
            long j3 = (1 << i15) - 1;
            int length = jArr[i13].length;
            int i16 = 0;
            while (i16 < length) {
                copyOf[i16] = (copyOf[i16] + ((jArr[i13][i16] & j3) << i14)) & 576319980446939135L;
                i16++;
                copyOf[i16] = (copyOf[i16] + (jArr[i13][i16] >> i15)) & 576319980446939135L;
            }
        }
        int i17 = (this.numCoeffs % 5) * 12;
        for (int length2 = this.coeffs.length - 1; length2 < copyOf.length; length2++) {
            long[] jArr4 = this.coeffs;
            if (length2 == jArr4.length - 1) {
                j2 = this.numCoeffs == 5 ? 0L : copyOf[length2] >> i17;
                i2 = 0;
            } else {
                j2 = copyOf[length2];
                i2 = (length2 * 5) - this.numCoeffs;
            }
            int i18 = i2 / 5;
            int i19 = i2 - (i18 * 5);
            long j4 = j2 << (i19 * 12);
            long j5 = j2 >> ((5 - i19) * 12);
            copyOf[i18] = (copyOf[i18] + j4) & 576319980446939135L;
            int i20 = i18 + 1;
            if (i20 < jArr4.length) {
                copyOf[i20] = (copyOf[i20] + j5) & 576319980446939135L;
            }
        }
        return new LongPolynomial5(copyOf, this.numCoeffs);
    }

    public IntegerPolynomial toIntegerPolynomial() {
        int[] iArr = new int[this.numCoeffs];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.numCoeffs; i4++) {
            iArr[i4] = (int) ((this.coeffs[i2] >> i3) & 2047);
            i3 += 12;
            if (i3 >= 60) {
                i2++;
                i3 = 0;
            }
        }
        return new IntegerPolynomial(iArr);
    }

    private LongPolynomial5(long[] jArr, int i2) {
        this.coeffs = jArr;
        this.numCoeffs = i2;
    }
}