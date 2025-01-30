package org.spongycastle.math.ec;

import java.math.BigInteger;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class NafL2RMultiplier extends AbstractECMultiplier {
    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        int[] generateCompactNaf = WNafUtil.generateCompactNaf(bigInteger);
        ECPoint normalize = eCPoint.normalize();
        ECPoint negate = normalize.negate();
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int length = generateCompactNaf.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            int i2 = generateCompactNaf[length];
            infinity = infinity.twicePlus((i2 >> 16) < 0 ? negate : normalize).timesPow2(i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        }
    }
}