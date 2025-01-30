package org.spongycastle.math.ec;

import java.math.BigInteger;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class WNafL2RMultiplier extends AbstractECMultiplier {
    protected int getWindowSize(int i2) {
        return WNafUtil.getWindowSize(i2);
    }

    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        int max = Math.max(2, Math.min(16, getWindowSize(bigInteger.bitLength())));
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, max, true);
        ECPoint[] preComp = precompute.getPreComp();
        ECPoint[] preCompNeg = precompute.getPreCompNeg();
        int[] generateCompactWindowNaf = WNafUtil.generateCompactWindowNaf(max, bigInteger);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int length = generateCompactWindowNaf.length;
        if (length > 1) {
            length--;
            int i2 = generateCompactWindowNaf[length];
            int i3 = i2 >> 16;
            int i4 = i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            int abs = Math.abs(i3);
            ECPoint[] eCPointArr = i3 < 0 ? preCompNeg : preComp;
            if ((abs << 2) < (1 << max)) {
                byte b2 = LongArray.bitLengths[abs];
                int i5 = max - b2;
                eCPoint2 = eCPointArr[((1 << (max - 1)) - 1) >>> 1].add(eCPointArr[(((abs ^ (1 << (b2 - 1))) << i5) + 1) >>> 1]);
                i4 -= i5;
            } else {
                eCPoint2 = eCPointArr[abs >>> 1];
            }
            infinity = eCPoint2.timesPow2(i4);
        }
        while (length > 0) {
            length--;
            int i6 = generateCompactWindowNaf[length];
            int i7 = i6 >> 16;
            infinity = infinity.twicePlus((i7 < 0 ? preCompNeg : preComp)[Math.abs(i7) >>> 1]).timesPow2(i6 & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        }
        return infinity;
    }
}