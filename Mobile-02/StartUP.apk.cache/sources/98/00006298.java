package org.spongycastle.crypto.params;

import org.spongycastle.math.ec.ECPoint;

/* loaded from: classes3.dex */
public class ECPublicKeyParameters extends ECKeyParameters {
    ECPoint Q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.Q = eCPoint.normalize();
    }

    public ECPoint getQ() {
        return this.Q;
    }
}