package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

/* loaded from: classes3.dex */
public class ElGamalParameters implements CipherParameters {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17817g;

    /* renamed from: l  reason: collision with root package name */
    private int f17818l;
    private BigInteger p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ElGamalParameters) {
            ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
            return elGamalParameters.getP().equals(this.p) && elGamalParameters.getG().equals(this.f17817g) && elGamalParameters.getL() == this.f17818l;
        }
        return false;
    }

    public BigInteger getG() {
        return this.f17817g;
    }

    public int getL() {
        return this.f17818l;
    }

    public BigInteger getP() {
        return this.p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f17818l;
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i2) {
        this.f17817g = bigInteger2;
        this.p = bigInteger;
        this.f17818l = i2;
    }
}