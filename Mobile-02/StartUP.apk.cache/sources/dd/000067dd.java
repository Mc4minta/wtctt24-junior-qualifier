package org.spongycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class FixedPointUtil {
    public static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(ECCurve eCCurve) {
        BigInteger order = eCCurve.getOrder();
        return order == null ? eCCurve.getFieldSize() + 1 : order.bitLength();
    }

    public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo != null && (preCompInfo instanceof FixedPointPreCompInfo)) {
            return (FixedPointPreCompInfo) preCompInfo;
        }
        return new FixedPointPreCompInfo();
    }

    public static FixedPointPreCompInfo precompute(ECPoint eCPoint, int i2) {
        ECCurve curve = eCPoint.getCurve();
        int i3 = 1 << i2;
        FixedPointPreCompInfo fixedPointPreCompInfo = getFixedPointPreCompInfo(curve.getPreCompInfo(eCPoint, PRECOMP_NAME));
        ECPoint[] preComp = fixedPointPreCompInfo.getPreComp();
        if (preComp == null || preComp.length < i3) {
            int combSize = ((getCombSize(curve) + i2) - 1) / i2;
            ECPoint[] eCPointArr = new ECPoint[i2];
            eCPointArr[0] = eCPoint;
            for (int i4 = 1; i4 < i2; i4++) {
                eCPointArr[i4] = eCPointArr[i4 - 1].timesPow2(combSize);
            }
            curve.normalizeAll(eCPointArr);
            ECPoint[] eCPointArr2 = new ECPoint[i3];
            eCPointArr2[0] = curve.getInfinity();
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                ECPoint eCPoint2 = eCPointArr[i5];
                int i6 = 1 << i5;
                for (int i7 = i6; i7 < i3; i7 += i6 << 1) {
                    eCPointArr2[i7] = eCPointArr2[i7 - i6].add(eCPoint2);
                }
            }
            curve.normalizeAll(eCPointArr2);
            fixedPointPreCompInfo.setPreComp(eCPointArr2);
            fixedPointPreCompInfo.setWidth(i2);
            curve.setPreCompInfo(eCPoint, PRECOMP_NAME, fixedPointPreCompInfo);
        }
        return fixedPointPreCompInfo;
    }
}