package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* loaded from: classes3.dex */
public class McElieceCCA2PrivateKeySpec implements KeySpec {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* renamed from: h  reason: collision with root package name */
    private GF2Matrix f17873h;

    /* renamed from: k  reason: collision with root package name */
    private int f17874k;
    private int n;
    private String oid;
    private Permutation p;
    private PolynomialGF2mSmallM[] qInv;

    public McElieceCCA2PrivateKeySpec(String str, int i2, int i3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, GF2Matrix gF2Matrix, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.oid = str;
        this.n = i2;
        this.f17874k = i3;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.p = permutation;
        this.f17873h = gF2Matrix;
        this.qInv = polynomialGF2mSmallMArr;
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.f17873h;
    }

    public int getK() {
        return this.f17874k;
    }

    public int getN() {
        return this.n;
    }

    public String getOIDString() {
        return this.oid;
    }

    public Permutation getP() {
        return this.p;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public McElieceCCA2PrivateKeySpec(String str, int i2, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][] bArr5) {
        this.oid = str;
        this.n = i2;
        this.f17874k = i3;
        GF2mField gF2mField = new GF2mField(bArr);
        this.field = gF2mField;
        this.goppaPoly = new PolynomialGF2mSmallM(gF2mField, bArr2);
        this.p = new Permutation(bArr3);
        this.f17873h = new GF2Matrix(bArr4);
        this.qInv = new PolynomialGF2mSmallM[bArr5.length];
        for (int i4 = 0; i4 < bArr5.length; i4++) {
            this.qInv[i4] = new PolynomialGF2mSmallM(this.field, bArr5[i4]);
        }
    }
}