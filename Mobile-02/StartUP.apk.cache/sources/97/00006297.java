package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class ECPrivateKeyParameters extends ECKeyParameters {

    /* renamed from: d  reason: collision with root package name */
    BigInteger f17816d;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        this.f17816d = bigInteger;
    }

    public BigInteger getD() {
        return this.f17816d;
    }
}