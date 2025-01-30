package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes3.dex */
public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f17839g;
    private BigInteger p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.p = bigInteger;
        this.f17839g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f17839g;
    }

    public BigInteger getP() {
        return this.p;
    }
}