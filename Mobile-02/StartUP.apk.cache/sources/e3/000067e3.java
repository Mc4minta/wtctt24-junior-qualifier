package org.spongycastle.math.ec;

import java.math.BigInteger;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class NafR2LMultiplier extends AbstractECMultiplier {
    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        int[] generateCompactNaf = WNafUtil.generateCompactNaf(bigInteger);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int i2 = 0;
        int i3 = 0;
        while (i2 < generateCompactNaf.length) {
            int i4 = generateCompactNaf[i2];
            int i5 = i4 >> 16;
            eCPoint = eCPoint.timesPow2(i3 + (i4 & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
            infinity = infinity.add(i5 < 0 ? eCPoint.negate() : eCPoint);
            i2++;
            i3 = 1;
        }
        return infinity;
    }
}