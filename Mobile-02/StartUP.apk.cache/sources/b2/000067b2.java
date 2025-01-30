package org.spongycastle.jce.spec;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class ECPrivateKeySpec extends ECKeySpec {

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f17838d;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f17838d = bigInteger;
    }

    public BigInteger getD() {
        return this.f17838d;
    }
}