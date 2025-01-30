package org.spongycastle.pqc.math.ntru.polynomial;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.pqc.math.ntru.util.ArrayEncoder;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class SparseTernaryPolynomial implements TernaryPolynomial {
    private static final int BITS_PER_INDEX = 11;
    private int N;
    private int[] negOnes;
    private int[] ones;

    SparseTernaryPolynomial(int i2, int[] iArr, int[] iArr2) {
        this.N = i2;
        this.ones = iArr;
        this.negOnes = iArr2;
    }

    public static SparseTernaryPolynomial fromBinary(InputStream inputStream, int i2, int i3, int i4) throws IOException {
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(2047);
        return new SparseTernaryPolynomial(i2, ArrayEncoder.decodeModQ(Util.readFullLength(inputStream, ((i3 * numberOfLeadingZeros) + 7) / 8), i3, (int) PKIFailureInfo.wrongIntegrity), ArrayEncoder.decodeModQ(Util.readFullLength(inputStream, ((numberOfLeadingZeros * i4) + 7) / 8), i4, (int) PKIFailureInfo.wrongIntegrity));
    }

    public static SparseTernaryPolynomial generateRandom(int i2, int i3, int i4, SecureRandom secureRandom) {
        return new SparseTernaryPolynomial(Util.generateRandomTernary(i2, i3, i4, secureRandom));
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public void clear() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.ones;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.negOnes;
            if (i3 >= iArr2.length) {
                return;
            }
            iArr2[i3] = 0;
            i3++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SparseTernaryPolynomial sparseTernaryPolynomial = (SparseTernaryPolynomial) obj;
            return this.N == sparseTernaryPolynomial.N && Arrays.areEqual(this.negOnes, sparseTernaryPolynomial.negOnes) && Arrays.areEqual(this.ones, sparseTernaryPolynomial.ones);
        }
        return false;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public int[] getNegOnes() {
        return this.negOnes;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public int[] getOnes() {
        return this.ones;
    }

    public int hashCode() {
        return ((((this.N + 31) * 31) + Arrays.hashCode(this.negOnes)) * 31) + Arrays.hashCode(this.ones);
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial, org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial) {
        int[] iArr = integerPolynomial.coeffs;
        int length = iArr.length;
        int i2 = this.N;
        if (length == i2) {
            int[] iArr2 = new int[i2];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr3 = this.ones;
                if (i4 == iArr3.length) {
                    break;
                }
                int i5 = iArr3[i4];
                int i6 = this.N;
                int i7 = (i6 - 1) - i5;
                for (int i8 = i6 - 1; i8 >= 0; i8--) {
                    iArr2[i8] = iArr2[i8] + iArr[i7];
                    i7--;
                    if (i7 < 0) {
                        i7 = this.N - 1;
                    }
                }
                i4++;
            }
            while (true) {
                int[] iArr4 = this.negOnes;
                if (i3 != iArr4.length) {
                    int i9 = iArr4[i3];
                    int i10 = this.N;
                    int i11 = (i10 - 1) - i9;
                    for (int i12 = i10 - 1; i12 >= 0; i12--) {
                        iArr2[i12] = iArr2[i12] - iArr[i11];
                        i11--;
                        if (i11 < 0) {
                            i11 = this.N - 1;
                        }
                    }
                    i3++;
                } else {
                    return new IntegerPolynomial(iArr2);
                }
            }
        } else {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial
    public int size() {
        return this.N;
    }

    public byte[] toBinary() {
        byte[] encodeModQ = ArrayEncoder.encodeModQ(this.ones, PKIFailureInfo.wrongIntegrity);
        byte[] encodeModQ2 = ArrayEncoder.encodeModQ(this.negOnes, PKIFailureInfo.wrongIntegrity);
        byte[] copyOf = Arrays.copyOf(encodeModQ, encodeModQ.length + encodeModQ2.length);
        System.arraycopy(encodeModQ2, 0, copyOf, encodeModQ.length, encodeModQ2.length);
        return copyOf;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial toIntegerPolynomial() {
        int[] iArr = new int[this.N];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.ones;
            if (i3 == iArr2.length) {
                break;
            }
            iArr[iArr2[i3]] = 1;
            i3++;
        }
        while (true) {
            int[] iArr3 = this.negOnes;
            if (i2 != iArr3.length) {
                iArr[iArr3[i2]] = -1;
                i2++;
            } else {
                return new IntegerPolynomial(iArr);
            }
        }
    }

    public SparseTernaryPolynomial(IntegerPolynomial integerPolynomial) {
        this(integerPolynomial.coeffs);
    }

    public SparseTernaryPolynomial(int[] iArr) {
        int length = iArr.length;
        this.N = length;
        this.ones = new int[length];
        this.negOnes = new int[length];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.N; i4++) {
            int i5 = iArr[i4];
            if (i5 == -1) {
                this.negOnes[i3] = i4;
                i3++;
            } else if (i5 == 0) {
                continue;
            } else if (i5 == 1) {
                this.ones[i2] = i4;
                i2++;
            } else {
                throw new IllegalArgumentException("Illegal value: " + i5 + ", must be one of {-1, 0, 1}");
            }
        }
        this.ones = Arrays.copyOf(this.ones, i2);
        this.negOnes = Arrays.copyOf(this.negOnes, i3);
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial, int i2) {
        IntegerPolynomial mult = mult(integerPolynomial);
        mult.mod(i2);
        return mult;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public BigIntPolynomial mult(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = bigIntPolynomial.coeffs;
        int length = bigIntegerArr.length;
        int i2 = this.N;
        if (length == i2) {
            BigInteger[] bigIntegerArr2 = new BigInteger[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < this.N; i4++) {
                bigIntegerArr2[i4] = BigInteger.ZERO;
            }
            int i5 = 0;
            while (true) {
                int[] iArr = this.ones;
                if (i5 == iArr.length) {
                    break;
                }
                int i6 = iArr[i5];
                int i7 = this.N;
                int i8 = (i7 - 1) - i6;
                for (int i9 = i7 - 1; i9 >= 0; i9--) {
                    bigIntegerArr2[i9] = bigIntegerArr2[i9].add(bigIntegerArr[i8]);
                    i8--;
                    if (i8 < 0) {
                        i8 = this.N - 1;
                    }
                }
                i5++;
            }
            while (true) {
                int[] iArr2 = this.negOnes;
                if (i3 != iArr2.length) {
                    int i10 = iArr2[i3];
                    int i11 = this.N;
                    int i12 = (i11 - 1) - i10;
                    for (int i13 = i11 - 1; i13 >= 0; i13--) {
                        bigIntegerArr2[i13] = bigIntegerArr2[i13].subtract(bigIntegerArr[i12]);
                        i12--;
                        if (i12 < 0) {
                            i12 = this.N - 1;
                        }
                    }
                    i3++;
                } else {
                    return new BigIntPolynomial(bigIntegerArr2);
                }
            }
        } else {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
    }
}