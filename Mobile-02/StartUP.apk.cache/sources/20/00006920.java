package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class GF2nPolynomialField extends GF2nField {
    private boolean isPentanomial;
    private boolean isTrinomial;
    private int[] pc;
    GF2Polynomial[] squaringMatrix;
    private int tc;

    public GF2nPolynomialField(int i2, SecureRandom secureRandom) {
        super(secureRandom);
        this.isTrinomial = false;
        this.isPentanomial = false;
        this.pc = new int[3];
        if (i2 >= 3) {
            this.mDegree = i2;
            computeFieldPolynomial();
            computeSquaringMatrix();
            this.fields = new java.util.Vector();
            this.matrices = new java.util.Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeSquaringMatrix() {
        int i2 = this.mDegree;
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i2 - 1];
        this.squaringMatrix = new GF2Polynomial[i2];
        int i3 = 0;
        while (true) {
            GF2Polynomial[] gF2PolynomialArr2 = this.squaringMatrix;
            if (i3 >= gF2PolynomialArr2.length) {
                break;
            }
            gF2PolynomialArr2[i3] = new GF2Polynomial(this.mDegree, "ZERO");
            i3++;
        }
        for (int i4 = 0; i4 < this.mDegree - 1; i4++) {
            gF2PolynomialArr[i4] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + i4).remainder(this.fieldPolynomial);
        }
        for (int i5 = 1; i5 <= Math.abs(this.mDegree >> 1); i5++) {
            int i6 = 1;
            while (true) {
                int i7 = this.mDegree;
                if (i6 <= i7) {
                    if (gF2PolynomialArr[i7 - (i5 << 1)].testBit(i7 - i6)) {
                        this.squaringMatrix[i6 - 1].setBit(this.mDegree - i5);
                    }
                    i6++;
                }
            }
        }
        int abs = Math.abs(this.mDegree >> 1) + 1;
        while (true) {
            int i8 = this.mDegree;
            if (abs > i8) {
                return;
            }
            this.squaringMatrix[((abs << 1) - i8) - 1].setBit(i8 - abs);
            abs++;
        }
    }

    private boolean testPentanomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        boolean z = false;
        int i2 = 1;
        while (i2 <= this.mDegree - 3 && !z) {
            this.fieldPolynomial.setBit(i2);
            int i3 = i2 + 1;
            int i4 = i3;
            while (i4 <= this.mDegree - 2 && !z) {
                this.fieldPolynomial.setBit(i4);
                int i5 = i4 + 1;
                for (int i6 = i5; i6 <= this.mDegree - 1 && !z; i6++) {
                    this.fieldPolynomial.setBit(i6);
                    if ((((this.mDegree & 1) != 0) | ((i2 & 1) != 0) | ((i4 & 1) != 0) | ((i6 & 1) != 0)) && (z = this.fieldPolynomial.isIrreducible())) {
                        this.isPentanomial = true;
                        int[] iArr = this.pc;
                        iArr[0] = i2;
                        iArr[1] = i4;
                        iArr[2] = i6;
                        return z;
                    }
                    this.fieldPolynomial.resetBit(i6);
                }
                this.fieldPolynomial.resetBit(i4);
                i4 = i5;
            }
            this.fieldPolynomial.resetBit(i2);
            i2 = i3;
        }
        return z;
    }

    private boolean testRandom() {
        this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
        do {
            this.fieldPolynomial.randomize();
            this.fieldPolynomial.setBit(this.mDegree);
            this.fieldPolynomial.setBit(0);
        } while (!this.fieldPolynomial.isIrreducible());
        return true;
    }

    private boolean testTrinomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        boolean z = false;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        for (int i2 = 1; i2 < this.mDegree && !z; i2++) {
            this.fieldPolynomial.setBit(i2);
            boolean isIrreducible = this.fieldPolynomial.isIrreducible();
            if (isIrreducible) {
                this.isTrinomial = true;
                this.tc = i2;
                return isIrreducible;
            }
            this.fieldPolynomial.resetBit(i2);
            z = this.fieldPolynomial.isIrreducible();
        }
        return z;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    protected void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        GF2nElement[] gF2nElementArr;
        int i2;
        int i3 = this.mDegree;
        if (i3 == gF2nField.mDegree) {
            boolean z = gF2nField instanceof GF2nONBField;
            if (z) {
                gF2nField.computeCOBMatrix(this);
                return;
            }
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i3];
            for (int i4 = 0; i4 < this.mDegree; i4++) {
                gF2PolynomialArr[i4] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            if (randomRoot instanceof GF2nONBElement) {
                int i5 = this.mDegree;
                gF2nElementArr = new GF2nONBElement[i5];
                gF2nElementArr[i5 - 1] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
            } else {
                int i6 = this.mDegree;
                gF2nElementArr = new GF2nPolynomialElement[i6];
                gF2nElementArr[i6 - 1] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
            }
            int i7 = this.mDegree;
            gF2nElementArr[i7 - 2] = randomRoot;
            for (int i8 = i7 - 3; i8 >= 0; i8--) {
                gF2nElementArr[i8] = (GF2nElement) gF2nElementArr[i8 + 1].multiply(randomRoot);
            }
            if (z) {
                for (int i9 = 0; i9 < this.mDegree; i9++) {
                    int i10 = 0;
                    while (true) {
                        if (i10 < this.mDegree) {
                            if (gF2nElementArr[i9].testBit((i2 - i10) - 1)) {
                                int i11 = this.mDegree;
                                gF2PolynomialArr[(i11 - i10) - 1].setBit((i11 - i9) - 1);
                            }
                            i10++;
                        }
                    }
                }
            } else {
                for (int i12 = 0; i12 < this.mDegree; i12++) {
                    for (int i13 = 0; i13 < this.mDegree; i13++) {
                        if (gF2nElementArr[i12].testBit(i13)) {
                            int i14 = this.mDegree;
                            gF2PolynomialArr[(i14 - i13) - 1].setBit((i14 - i12) - 1);
                        }
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    protected void computeFieldPolynomial() {
        if (testTrinomials() || testPentanomials()) {
            return;
        }
        testRandom();
    }

    protected void computeFieldPolynomial2() {
        if (testTrinomials() || testPentanomials()) {
            return;
        }
        testRandom();
    }

    public int[] getPc() throws RuntimeException {
        if (this.isPentanomial) {
            int[] iArr = new int[3];
            System.arraycopy(this.pc, 0, iArr, 0, 3);
            return iArr;
        }
        throw new RuntimeException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.GF2nField
    protected GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, this);
        int degree3 = gF2nPolynomial.getDegree();
        while (degree3 > 1) {
            while (true) {
                GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, GF2nPolynomialElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nPolynomialElement);
                GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial2);
                for (int i2 = 1; i2 <= this.mDegree - 1; i2++) {
                    gF2nPolynomial3 = gF2nPolynomial3.multiplyAndReduce(gF2nPolynomial3, gF2nPolynomial).add(gF2nPolynomial2);
                }
                gcd = gF2nPolynomial3.gcd(gF2nPolynomial);
                degree = gcd.getDegree();
                degree2 = gF2nPolynomial.getDegree();
                if (degree != 0 && degree != degree2) {
                    break;
                }
            }
            if ((degree << 1) > degree2) {
                gF2nPolynomial = gF2nPolynomial.quotient(gcd);
            } else {
                gF2nPolynomial = new GF2nPolynomial(gcd);
            }
            degree3 = gF2nPolynomial.getDegree();
        }
        return gF2nPolynomial.at(0);
    }

    public GF2Polynomial getSquaringVector(int i2) {
        return new GF2Polynomial(this.squaringMatrix[i2]);
    }

    public int getTc() throws RuntimeException {
        if (this.isTrinomial) {
            return this.tc;
        }
        throw new RuntimeException();
    }

    public boolean isPentanomial() {
        return this.isPentanomial;
    }

    public boolean isTrinomial() {
        return this.isTrinomial;
    }

    public GF2nPolynomialField(int i2, SecureRandom secureRandom, boolean z) {
        super(secureRandom);
        this.isTrinomial = false;
        this.isPentanomial = false;
        this.pc = new int[3];
        if (i2 >= 3) {
            this.mDegree = i2;
            if (z) {
                computeFieldPolynomial();
            } else {
                computeFieldPolynomial2();
            }
            computeSquaringMatrix();
            this.fields = new java.util.Vector();
            this.matrices = new java.util.Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    public GF2nPolynomialField(int i2, SecureRandom secureRandom, GF2Polynomial gF2Polynomial) throws RuntimeException {
        super(secureRandom);
        this.isTrinomial = false;
        this.isPentanomial = false;
        this.pc = new int[3];
        if (i2 >= 3) {
            if (gF2Polynomial.getLength() == i2 + 1) {
                if (gF2Polynomial.isIrreducible()) {
                    this.mDegree = i2;
                    this.fieldPolynomial = gF2Polynomial;
                    computeSquaringMatrix();
                    int i3 = 2;
                    for (int i4 = 1; i4 < this.fieldPolynomial.getLength() - 1; i4++) {
                        if (this.fieldPolynomial.testBit(i4)) {
                            i3++;
                            if (i3 == 3) {
                                this.tc = i4;
                            }
                            if (i3 <= 5) {
                                this.pc[i3 - 3] = i4;
                            }
                        }
                    }
                    if (i3 == 3) {
                        this.isTrinomial = true;
                    }
                    if (i3 == 5) {
                        this.isPentanomial = true;
                    }
                    this.fields = new java.util.Vector();
                    this.matrices = new java.util.Vector();
                    return;
                }
                throw new RuntimeException();
            }
            throw new RuntimeException();
        }
        throw new IllegalArgumentException("degree must be at least 3");
    }
}