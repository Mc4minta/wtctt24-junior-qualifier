package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: classes3.dex */
public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17810g;

    /* renamed from: j  reason: collision with root package name */
    private BigInteger f17811j;

    /* renamed from: l  reason: collision with root package name */
    private int f17812l;
    private int m;
    private BigInteger p;
    private BigInteger q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    private static int getDefaultMParam(int i2) {
        if (i2 != 0 && i2 < 160) {
            return i2;
        }
        return 160;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DHParameters) {
            DHParameters dHParameters = (DHParameters) obj;
            if (getQ() != null) {
                if (!getQ().equals(dHParameters.getQ())) {
                    return false;
                }
            } else if (dHParameters.getQ() != null) {
                return false;
            }
            return dHParameters.getP().equals(this.p) && dHParameters.getG().equals(this.f17810g);
        }
        return false;
    }

    public BigInteger getG() {
        return this.f17810g;
    }

    public BigInteger getJ() {
        return this.f17811j;
    }

    public int getL() {
        return this.f17812l;
    }

    public int getM() {
        return this.m;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i2), i2, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2, int i3) {
        this(bigInteger, bigInteger2, bigInteger3, i2, i3, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, dHValidationParameters);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2, int i3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i3 != 0) {
            if (i3 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i3 < i2) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        this.f17810g = bigInteger2;
        this.p = bigInteger;
        this.q = bigInteger3;
        this.m = i2;
        this.f17812l = i3;
        this.f17811j = bigInteger4;
        this.validation = dHValidationParameters;
    }
}