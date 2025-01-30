package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class PolynomialGF2mSmallM {
    public static final char RANDOM_IRREDUCIBLE_POLYNOMIAL = 'I';
    private int[] coefficients;
    private int degree;
    private GF2mField field;

    public PolynomialGF2mSmallM(GF2mField gF2mField) {
        this.field = gF2mField;
        this.degree = -1;
        this.coefficients = new int[1];
    }

    private void computeDegree() {
        this.degree = this.coefficients.length - 1;
        while (true) {
            int i2 = this.degree;
            if (i2 < 0 || this.coefficients[i2] != 0) {
                return;
            }
            this.degree = i2 - 1;
        }
    }

    private int[] createRandomIrreduciblePolynomial(int i2, SecureRandom secureRandom) {
        int[] iArr = new int[i2 + 1];
        iArr[i2] = 1;
        iArr[0] = this.field.getRandomNonZeroElement(secureRandom);
        for (int i3 = 1; i3 < i2; i3++) {
            iArr[i3] = this.field.getRandomElement(secureRandom);
        }
        while (!isIrreducible(iArr)) {
            int nextInt = RandUtils.nextInt(secureRandom, i2);
            if (nextInt == 0) {
                iArr[0] = this.field.getRandomNonZeroElement(secureRandom);
            } else {
                iArr[nextInt] = this.field.getRandomElement(secureRandom);
            }
        }
        return iArr;
    }

    private static int headCoefficient(int[] iArr) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return 0;
        }
        return iArr[computeDegree];
    }

    private static boolean isEqual(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree != computeDegree(iArr2)) {
            return false;
        }
        for (int i2 = 0; i2 <= computeDegree; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean isIrreducible(int[] iArr) {
        if (iArr[0] == 0) {
            return false;
        }
        int computeDegree = computeDegree(iArr) >> 1;
        int[] iArr2 = {0, 1};
        int[] iArr3 = {0, 1};
        int degree = this.field.getDegree();
        for (int i2 = 0; i2 < computeDegree; i2++) {
            for (int i3 = degree - 1; i3 >= 0; i3--) {
                iArr2 = modMultiply(iArr2, iArr2, iArr);
            }
            iArr2 = normalForm(iArr2);
            if (computeDegree(gcd(add(iArr2, iArr3), iArr)) != 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] normalForm(int[] iArr) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return new int[1];
        }
        int i2 = computeDegree + 1;
        if (iArr.length == i2) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[i2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        return iArr2;
    }

    public PolynomialGF2mSmallM add(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, add(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM addMonomial(int i2) {
        int[] iArr = new int[i2 + 1];
        iArr[i2] = 1;
        return new PolynomialGF2mSmallM(this.field, add(this.coefficients, iArr));
    }

    public void addToThis(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.coefficients = add(this.coefficients, polynomialGF2mSmallM.coefficients);
        computeDegree();
    }

    public PolynomialGF2mSmallM[] div(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[][] div = div(this.coefficients, polynomialGF2mSmallM.coefficients);
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, div[0]), new PolynomialGF2mSmallM(this.field, div[1])};
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PolynomialGF2mSmallM)) {
            PolynomialGF2mSmallM polynomialGF2mSmallM = (PolynomialGF2mSmallM) obj;
            if (this.field.equals(polynomialGF2mSmallM.field) && this.degree == polynomialGF2mSmallM.degree && isEqual(this.coefficients, polynomialGF2mSmallM.coefficients)) {
                return true;
            }
        }
        return false;
    }

    public int evaluateAt(int i2) {
        int[] iArr = this.coefficients;
        int i3 = this.degree;
        int i4 = iArr[i3];
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            i4 = this.field.mult(i4, i2) ^ this.coefficients[i5];
        }
        return i4;
    }

    public PolynomialGF2mSmallM gcd(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, gcd(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public int getCoefficient(int i2) {
        if (i2 < 0 || i2 > this.degree) {
            return 0;
        }
        return this.coefficients[i2];
    }

    public int getDegree() {
        int[] iArr = this.coefficients;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] getEncoded() {
        int i2 = 8;
        int i3 = 1;
        while (this.field.getDegree() > i2) {
            i3++;
            i2 += 8;
        }
        byte[] bArr = new byte[this.coefficients.length * i3];
        int i4 = 0;
        for (int i5 = 0; i5 < this.coefficients.length; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                bArr[i4] = (byte) (this.coefficients[i5] >>> i6);
                i6 += 8;
                i4++;
            }
        }
        return bArr;
    }

    public int getHeadCoefficient() {
        int i2 = this.degree;
        if (i2 == -1) {
            return 0;
        }
        return this.coefficients[i2];
    }

    public int hashCode() {
        int hashCode = this.field.hashCode();
        int i2 = 0;
        while (true) {
            int[] iArr = this.coefficients;
            if (i2 >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i2];
            i2++;
        }
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, mod(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM modDiv(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.field, modDiv(this.coefficients, polynomialGF2mSmallM.coefficients, polynomialGF2mSmallM2.coefficients));
    }

    public PolynomialGF2mSmallM modInverse(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, modDiv(new int[]{1}, this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM modMultiply(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.field, modMultiply(this.coefficients, polynomialGF2mSmallM.coefficients, polynomialGF2mSmallM2.coefficients));
    }

    public PolynomialGF2mSmallM[] modPolynomialToFracton(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i2 = polynomialGF2mSmallM.degree >> 1;
        int[] normalForm = normalForm(polynomialGF2mSmallM.coefficients);
        int[] mod = mod(this.coefficients, polynomialGF2mSmallM.coefficients);
        int[] iArr = {0};
        int[] iArr2 = {1};
        while (computeDegree(mod) > i2) {
            int[][] div = div(normalForm, mod);
            int[] iArr3 = div[1];
            int[] add = add(iArr, modMultiply(div[0], iArr2, polynomialGF2mSmallM.coefficients));
            iArr = iArr2;
            iArr2 = add;
            normalForm = mod;
            mod = iArr3;
        }
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, mod), new PolynomialGF2mSmallM(this.field, iArr2)};
    }

    public PolynomialGF2mSmallM modSquareMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        int i2 = 0;
        while (true) {
            int[] iArr3 = this.coefficients;
            if (i2 >= iArr3.length) {
                break;
            }
            iArr2[i2] = this.field.mult(iArr3[i2], iArr3[i2]);
            i2++;
        }
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                if (i3 < polynomialGF2mSmallMArr[i4].coefficients.length) {
                    iArr[i3] = this.field.add(iArr[i3], this.field.mult(polynomialGF2mSmallMArr[i4].coefficients[i3], iArr2[i4]));
                }
            }
        }
        return new PolynomialGF2mSmallM(this.field, iArr);
    }

    public PolynomialGF2mSmallM modSquareRoot(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[] clone = IntUtils.clone(this.coefficients);
        int[] modMultiply = modMultiply(clone, clone, polynomialGF2mSmallM.coefficients);
        while (!isEqual(modMultiply, this.coefficients)) {
            clone = normalForm(modMultiply);
            modMultiply = modMultiply(clone, clone, polynomialGF2mSmallM.coefficients);
        }
        return new PolynomialGF2mSmallM(this.field, clone);
    }

    public PolynomialGF2mSmallM modSquareRootMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 < polynomialGF2mSmallMArr[i3].coefficients.length) {
                    int[] iArr2 = this.coefficients;
                    if (i3 < iArr2.length) {
                        iArr[i2] = this.field.add(iArr[i2], this.field.mult(polynomialGF2mSmallMArr[i3].coefficients[i2], iArr2[i3]));
                    }
                }
            }
        }
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.field.sqRoot(iArr[i4]);
        }
        return new PolynomialGF2mSmallM(this.field, iArr);
    }

    public void multThisWithElement(int i2) {
        if (this.field.isElementOfThisField(i2)) {
            this.coefficients = multWithElement(this.coefficients, i2);
            computeDegree();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int i2) {
        if (this.field.isElementOfThisField(i2)) {
            return new PolynomialGF2mSmallM(this.field, multWithElement(this.coefficients, i2));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithMonomial(int i2) {
        return new PolynomialGF2mSmallM(this.field, multWithMonomial(this.coefficients, i2));
    }

    public PolynomialGF2mSmallM multiply(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, multiply(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public String toString() {
        String str = " Polynomial over " + this.field.toString() + ": \n";
        for (int i2 = 0; i2 < this.coefficients.length; i2++) {
            str = str + this.field.elementToStr(this.coefficients[i2]) + "Y^" + i2 + "+";
        }
        return str + ";";
    }

    private int[] add(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.field.add(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    private static int computeDegree(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    private int[][] div(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr2);
        int computeDegree2 = computeDegree(iArr) + 1;
        if (computeDegree != -1) {
            int[][] iArr3 = {new int[1], new int[computeDegree2]};
            int inverse = this.field.inverse(headCoefficient(iArr2));
            iArr3[0][0] = 0;
            System.arraycopy(iArr, 0, iArr3[1], 0, iArr3[1].length);
            while (computeDegree <= computeDegree(iArr3[1])) {
                int[] iArr4 = {this.field.mult(headCoefficient(iArr3[1]), inverse)};
                int[] multWithElement = multWithElement(iArr2, iArr4[0]);
                int computeDegree3 = computeDegree(iArr3[1]) - computeDegree;
                int[] multWithMonomial = multWithMonomial(multWithElement, computeDegree3);
                iArr3[0] = add(multWithMonomial(iArr4, computeDegree3), iArr3[0]);
                iArr3[1] = add(multWithMonomial, iArr3[1]);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero.");
    }

    private int[] gcd(int[] iArr, int[] iArr2) {
        if (computeDegree(iArr) == -1) {
            return iArr2;
        }
        while (computeDegree(iArr2) != -1) {
            int[] mod = mod(iArr, iArr2);
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            int length2 = mod.length;
            int[] iArr4 = new int[length2];
            System.arraycopy(mod, 0, iArr4, 0, length2);
            iArr2 = iArr4;
            iArr = iArr3;
        }
        return multWithElement(iArr, this.field.inverse(headCoefficient(iArr)));
    }

    private int[] mod(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr2);
        if (computeDegree != -1) {
            int length = iArr.length;
            int[] iArr3 = new int[length];
            int inverse = this.field.inverse(headCoefficient(iArr2));
            System.arraycopy(iArr, 0, iArr3, 0, length);
            while (computeDegree <= computeDegree(iArr3)) {
                iArr3 = add(multWithElement(multWithMonomial(iArr2, computeDegree(iArr3) - computeDegree), this.field.mult(headCoefficient(iArr3), inverse)), iArr3);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero");
    }

    private int[] modDiv(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] normalForm = normalForm(iArr3);
        int[] mod = mod(iArr2, iArr3);
        int[] iArr4 = {0};
        int[] mod2 = mod(iArr, iArr3);
        while (computeDegree(mod) != -1) {
            int[][] div = div(normalForm, mod);
            int[] normalForm2 = normalForm(mod);
            int[] normalForm3 = normalForm(div[1]);
            int[] add = add(iArr4, modMultiply(div[0], mod2, iArr3));
            iArr4 = normalForm(mod2);
            mod2 = normalForm(add);
            normalForm = normalForm2;
            mod = normalForm3;
        }
        return multWithElement(iArr4, this.field.inverse(headCoefficient(normalForm)));
    }

    private int[] modMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        return mod(multiply(iArr, iArr2), iArr3);
    }

    private static int[] multWithMonomial(int[] iArr, int i2) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[computeDegree + i2 + 1];
        System.arraycopy(iArr, 0, iArr2, i2, computeDegree + 1);
        return iArr2;
    }

    private int[] multiply(int[] iArr, int[] iArr2) {
        if (computeDegree(iArr) < computeDegree(iArr2)) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] normalForm = normalForm(iArr);
        int[] normalForm2 = normalForm(iArr2);
        if (normalForm2.length == 1) {
            return multWithElement(normalForm, normalForm2[0]);
        }
        int length = normalForm.length;
        int length2 = normalForm2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        if (length2 != length) {
            int[] iArr4 = new int[length2];
            int i2 = length - length2;
            int[] iArr5 = new int[i2];
            System.arraycopy(normalForm, 0, iArr4, 0, length2);
            System.arraycopy(normalForm, length2, iArr5, 0, i2);
            return add(multiply(iArr4, normalForm2), multWithMonomial(multiply(iArr5, normalForm2), length2));
        }
        int i3 = (length + 1) >>> 1;
        int i4 = length - i3;
        int[] iArr6 = new int[i3];
        int[] iArr7 = new int[i3];
        int[] iArr8 = new int[i4];
        int[] iArr9 = new int[i4];
        System.arraycopy(normalForm, 0, iArr6, 0, i3);
        System.arraycopy(normalForm, i3, iArr8, 0, i4);
        System.arraycopy(normalForm2, 0, iArr7, 0, i3);
        System.arraycopy(normalForm2, i3, iArr9, 0, i4);
        int[] add = add(iArr6, iArr8);
        int[] add2 = add(iArr7, iArr9);
        int[] multiply = multiply(iArr6, iArr7);
        int[] multiply2 = multiply(add, add2);
        int[] multiply3 = multiply(iArr8, iArr9);
        return add(multWithMonomial(add(add(add(multiply2, multiply), multiply3), multWithMonomial(multiply3, i3)), i3), multiply);
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i2, char c2, SecureRandom secureRandom) {
        this.field = gF2mField;
        if (c2 == 'I') {
            this.coefficients = createRandomIrreduciblePolynomial(i2, secureRandom);
            computeDegree();
            return;
        }
        throw new IllegalArgumentException(" Error: type " + c2 + " is not defined for GF2smallmPolynomial");
    }

    private int[] multWithElement(int[] iArr, int i2) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1 || i2 == 0) {
            return new int[1];
        }
        if (i2 == 1) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[computeDegree + 1];
        while (computeDegree >= 0) {
            iArr2[computeDegree] = this.field.mult(iArr[computeDegree], i2);
            computeDegree--;
        }
        return iArr2;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i2) {
        this.field = gF2mField;
        this.degree = i2;
        int[] iArr = new int[i2 + 1];
        this.coefficients = iArr;
        iArr[i2] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.field = gF2mField;
        this.coefficients = normalForm(iArr);
        computeDegree();
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] bArr) {
        this.field = gF2mField;
        int i2 = 8;
        int i3 = 1;
        while (gF2mField.getDegree() > i2) {
            i3++;
            i2 += 8;
        }
        if (bArr.length % i3 == 0) {
            this.coefficients = new int[bArr.length / i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr = this.coefficients;
                if (i4 < iArr.length) {
                    int i6 = 0;
                    while (i6 < i2) {
                        int[] iArr2 = this.coefficients;
                        iArr2[i4] = ((bArr[i5] & 255) << i6) ^ iArr2[i4];
                        i6 += 8;
                        i5++;
                    }
                    if (!this.field.isElementOfThisField(this.coefficients[i4])) {
                        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                    }
                    i4++;
                } else if (iArr.length != 1 && iArr[iArr.length - 1] == 0) {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                } else {
                    computeDegree();
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = polynomialGF2mSmallM.field;
        this.degree = polynomialGF2mSmallM.degree;
        this.coefficients = IntUtils.clone(polynomialGF2mSmallM.coefficients);
    }

    public PolynomialGF2mSmallM(GF2mVector gF2mVector) {
        this(gF2mVector.getField(), gF2mVector.getIntArrayForm());
    }
}