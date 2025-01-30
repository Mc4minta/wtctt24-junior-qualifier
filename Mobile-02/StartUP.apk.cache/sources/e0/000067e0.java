package org.spongycastle.math.ec;

import java.math.BigInteger;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MixedNafR2LMultiplier extends AbstractECMultiplier {
    protected int additionCoord;
    protected int doublingCoord;

    public MixedNafR2LMultiplier() {
        this(2, 4);
    }

    protected ECCurve configureCurve(ECCurve eCCurve, int i2) {
        if (eCCurve.getCoordinateSystem() == i2) {
            return eCCurve;
        }
        if (eCCurve.supportsCoordinateSystem(i2)) {
            return eCCurve.configure().setCoordinateSystem(i2).create();
        }
        throw new IllegalArgumentException("Coordinate system " + i2 + " not supported by this curve");
    }

    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve curve = eCPoint.getCurve();
        ECCurve configureCurve = configureCurve(curve, this.additionCoord);
        ECCurve configureCurve2 = configureCurve(curve, this.doublingCoord);
        int[] generateCompactNaf = WNafUtil.generateCompactNaf(bigInteger);
        ECPoint infinity = configureCurve.getInfinity();
        ECPoint importPoint = configureCurve2.importPoint(eCPoint);
        int i2 = 0;
        ECPoint eCPoint2 = infinity;
        int i3 = 0;
        while (i2 < generateCompactNaf.length) {
            int i4 = generateCompactNaf[i2];
            int i5 = i4 >> 16;
            importPoint = importPoint.timesPow2(i3 + (i4 & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
            ECPoint importPoint2 = configureCurve.importPoint(importPoint);
            if (i5 < 0) {
                importPoint2 = importPoint2.negate();
            }
            eCPoint2 = eCPoint2.add(importPoint2);
            i2++;
            i3 = 1;
        }
        return curve.importPoint(eCPoint2);
    }

    public MixedNafR2LMultiplier(int i2, int i3) {
        this.additionCoord = i2;
        this.doublingCoord = i3;
    }
}