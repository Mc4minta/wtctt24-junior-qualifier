package org.spongycastle.pqc.math.linearalgebra;

import com.coinbase.wallet.core.extensions.Strings;
import java.security.SecureRandom;
import okhttp3.internal.cache.DiskLruCache;

/* loaded from: classes3.dex */
public class GF2mField {
    private int degree;
    private int polynomial;

    public GF2mField(int i2) {
        this.degree = 0;
        if (i2 >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        }
        if (i2 >= 1) {
            this.degree = i2;
            this.polynomial = PolynomialRingGF2.getIrreduciblePolynomial(i2);
            return;
        }
        throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
    }

    private static String polyToString(int i2) {
        if (i2 == 0) {
            return Strings.zero;
        }
        String str = ((byte) (i2 & 1)) == 1 ? DiskLruCache.VERSION_1 : "";
        int i3 = i2 >>> 1;
        int i4 = 1;
        while (i3 != 0) {
            if (((byte) (i3 & 1)) == 1) {
                str = str + "+x^" + i4;
            }
            i3 >>>= 1;
            i4++;
        }
        return str;
    }

    public int add(int i2, int i3) {
        return i2 ^ i3;
    }

    public String elementToStr(int i2) {
        String str = "";
        for (int i3 = 0; i3 < this.degree; i3++) {
            str = (((byte) i2) & 1) == 0 ? Strings.zero + str : DiskLruCache.VERSION_1 + str;
            i2 >>>= 1;
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof GF2mField)) {
            GF2mField gF2mField = (GF2mField) obj;
            if (this.degree == gF2mField.degree && this.polynomial == gF2mField.polynomial) {
                return true;
            }
        }
        return false;
    }

    public int exp(int i2, int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i3 < 0) {
            i2 = inverse(i2);
            i3 = -i3;
        }
        int i4 = 1;
        while (i3 != 0) {
            if ((i3 & 1) == 1) {
                i4 = mult(i4, i2);
            }
            i2 = mult(i2, i2);
            i3 >>>= 1;
        }
        return i4;
    }

    public int getDegree() {
        return this.degree;
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.I2OSP(this.polynomial);
    }

    public int getPolynomial() {
        return this.polynomial;
    }

    public int getRandomElement(SecureRandom secureRandom) {
        return RandUtils.nextInt(secureRandom, 1 << this.degree);
    }

    public int getRandomNonZeroElement() {
        return getRandomNonZeroElement(new SecureRandom());
    }

    public int hashCode() {
        return this.polynomial;
    }

    public int inverse(int i2) {
        return exp(i2, (1 << this.degree) - 2);
    }

    public boolean isElementOfThisField(int i2) {
        int i3 = this.degree;
        return i3 == 31 ? i2 >= 0 : i2 >= 0 && i2 < (1 << i3);
    }

    public int mult(int i2, int i3) {
        return PolynomialRingGF2.modMultiply(i2, i3, this.polynomial);
    }

    public int sqRoot(int i2) {
        for (int i3 = 1; i3 < this.degree; i3++) {
            i2 = mult(i2, i2);
        }
        return i2;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.degree + ") = GF(2)[X]/<" + polyToString(this.polynomial) + "> ";
    }

    public int getRandomNonZeroElement(SecureRandom secureRandom) {
        int nextInt = RandUtils.nextInt(secureRandom, 1 << this.degree);
        int i2 = 0;
        while (nextInt == 0 && i2 < 1048576) {
            nextInt = RandUtils.nextInt(secureRandom, 1 << this.degree);
            i2++;
        }
        if (i2 == 1048576) {
            return 1;
        }
        return nextInt;
    }

    public GF2mField(int i2, int i3) {
        this.degree = 0;
        if (i2 == PolynomialRingGF2.degree(i3)) {
            if (PolynomialRingGF2.isIrreducible(i3)) {
                this.degree = i2;
                this.polynomial = i3;
                return;
            }
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
        throw new IllegalArgumentException(" Error: the degree is not correct");
    }

    public GF2mField(byte[] bArr) {
        this.degree = 0;
        if (bArr.length == 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr);
            this.polynomial = OS2IP;
            if (PolynomialRingGF2.isIrreducible(OS2IP)) {
                this.degree = PolynomialRingGF2.degree(this.polynomial);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    public GF2mField(GF2mField gF2mField) {
        this.degree = 0;
        this.degree = gF2mField.degree;
        this.polynomial = gF2mField.polynomial;
    }
}