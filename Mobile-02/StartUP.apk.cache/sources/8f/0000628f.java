package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: classes3.dex */
public class DSAParameters implements CipherParameters {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17814g;
    private BigInteger p;
    private BigInteger q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f17814g = bigInteger3;
        this.p = bigInteger;
        this.q = bigInteger2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DSAParameters) {
            DSAParameters dSAParameters = (DSAParameters) obj;
            return dSAParameters.getP().equals(this.p) && dSAParameters.getQ().equals(this.q) && dSAParameters.getG().equals(this.f17814g);
        }
        return false;
    }

    public BigInteger getG() {
        return this.f17814g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f17814g = bigInteger3;
        this.p = bigInteger;
        this.q = bigInteger2;
        this.validation = dSAValidationParameters;
    }
}