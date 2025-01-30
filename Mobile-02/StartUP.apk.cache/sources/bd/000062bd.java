package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class SRP6GroupParameters {
    private BigInteger N;

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17822g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.N = bigInteger;
        this.f17822g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f17822g;
    }

    public BigInteger getN() {
        return this.N;
    }
}