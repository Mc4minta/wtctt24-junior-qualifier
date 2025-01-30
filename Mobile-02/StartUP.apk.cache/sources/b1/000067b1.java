package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

/* loaded from: classes3.dex */
public class ECParameterSpec implements AlgorithmParameterSpec {
    private ECPoint G;
    private ECCurve curve;

    /* renamed from: h  reason: collision with root package name */
    private BigInteger f17837h;
    private BigInteger n;
    private byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.f17837h = BigInteger.valueOf(1L);
        this.seed = null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECParameterSpec) {
            ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
            return getCurve().equals(eCParameterSpec.getCurve()) && getG().equals(eCParameterSpec.getG());
        }
        return false;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.f17837h;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.f17837h = bigInteger2;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.G = eCPoint.normalize();
        this.n = bigInteger;
        this.f17837h = bigInteger2;
        this.seed = bArr;
    }
}