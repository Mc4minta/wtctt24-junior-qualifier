package org.spongycastle.pqc.crypto.rainbow;

/* loaded from: classes3.dex */
public class RainbowPublicKeyParameters extends RainbowKeyParameters {
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;

    public RainbowPublicKeyParameters(int i2, short[][] sArr, short[][] sArr2, short[] sArr3) {
        super(false, i2);
        this.coeffquadratic = sArr;
        this.coeffsingular = sArr2;
        this.coeffscalar = sArr3;
    }

    public short[][] getCoeffQuadratic() {
        return this.coeffquadratic;
    }

    public short[] getCoeffScalar() {
        return this.coeffscalar;
    }

    public short[][] getCoeffSingular() {
        return this.coeffsingular;
    }
}