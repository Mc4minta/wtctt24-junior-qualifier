package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17820g;
    int lowerSigmaBound;
    private BigInteger n;

    public NaccacheSternKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, int i2) {
        super(z);
        this.f17820g = bigInteger;
        this.n = bigInteger2;
        this.lowerSigmaBound = i2;
    }

    public BigInteger getG() {
        return this.f17820g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.n;
    }
}