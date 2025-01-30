package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

/* loaded from: classes3.dex */
public class McElieceParameters implements CipherParameters {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;
    private int m;
    private int n;
    private int t;

    public McElieceParameters() {
        this(11, 50);
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.m;
    }

    public int getN() {
        return this.n;
    }

    public int getT() {
        return this.t;
    }

    public McElieceParameters(int i2) throws IllegalArgumentException {
        if (i2 >= 1) {
            this.m = 0;
            this.n = 1;
            while (true) {
                int i3 = this.n;
                if (i3 < i2) {
                    this.n = i3 << 1;
                    this.m++;
                } else {
                    int i4 = i3 >>> 1;
                    this.t = i4;
                    int i5 = this.m;
                    this.t = i4 / i5;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i5);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceParameters(int i2, int i3) throws IllegalArgumentException {
        if (i2 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i2 <= 32) {
            this.m = i2;
            int i4 = 1 << i2;
            this.n = i4;
            if (i3 < 0) {
                throw new IllegalArgumentException("t must be positive");
            }
            if (i3 <= i4) {
                this.t = i3;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i2);
                return;
            }
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        throw new IllegalArgumentException("m is too large");
    }

    public McElieceParameters(int i2, int i3, int i4) throws IllegalArgumentException {
        this.m = i2;
        if (i2 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i2 <= 32) {
            int i5 = 1 << i2;
            this.n = i5;
            this.t = i3;
            if (i3 < 0) {
                throw new IllegalArgumentException("t must be positive");
            }
            if (i3 <= i5) {
                if (PolynomialRingGF2.degree(i4) == i2 && PolynomialRingGF2.isIrreducible(i4)) {
                    this.fieldPoly = i4;
                    return;
                }
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            }
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        throw new IllegalArgumentException(" m is too large");
    }
}