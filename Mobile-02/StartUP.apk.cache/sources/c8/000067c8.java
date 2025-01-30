package org.spongycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class DoubleAddMultiplier extends AbstractECMultiplier {
    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint[] eCPointArr = new ECPoint[2];
        eCPointArr[0] = eCPoint.getCurve().getInfinity();
        eCPointArr[1] = eCPoint;
        int bitLength = bigInteger.bitLength();
        for (int i2 = 0; i2 < bitLength; i2++) {
            boolean testBit = bigInteger.testBit(i2);
            int i3 = 1 - (testBit ? 1 : 0);
            eCPointArr[i3] = eCPointArr[i3].twicePlus(eCPointArr[testBit ? 1 : 0]);
        }
        return eCPointArr[0];
    }
}